package com.jdbc;

import java.sql.*;
import java.util.*;

public class Jdbc {
    static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    static final String USER = "root";
    static final String PASS = "Mysql@4239";

    public static void main(String[] args) {
        // Try-with-resources to manage shared resources
        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            
            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. View All");
                System.out.println("2. View Specific IDs");
                System.out.println("3. Add New Student");
                System.out.println("4. Update Details (Single/Multiple)");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                
                int choice = getValidInt(sc);

                switch (choice) {
                    case 1 -> displayStudents(con, "SELECT * FROM students");
                    case 2 -> viewSpecificStudents(con, sc);
                    case 3 -> insertStudent(con, sc);
                    case 4 -> updateStudent(con, sc);
                    case 5 -> deleteStudent(con, sc);
                    case 6 -> {
                        exit = true;
                        System.out.println("Exiting... Goodbye!");
                    }
                    default -> System.out.println("Invalid choice. Please pick 1-6.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database Connection Error: " + e.getMessage());
        }
    }

    // Helper method to ensure the user enters an integer
    private static int getValidInt(Scanner sc) {
        while (true) {
            try {
                int val = sc.nextInt();
                sc.nextLine(); // Clear buffer
                return val;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Please enter a number: ");
                sc.nextLine(); // Clear bad input
            }
        }
    }

    // Displays students based on any query provided
    private static void displayStudents(Connection con, String query) {
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            
            String columnFormat = "%-10s %-20s %-30s %-20s%n";
            System.out.println("\n" + "-".repeat(80));
            System.out.printf(columnFormat, "ID", "Name", "Email", "College");
            System.out.println("-".repeat(80));

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf(columnFormat, 
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            if (!found) System.out.println("No records found.");
        } catch (SQLException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }

    // Operation: View multiple specific IDs
    private static void viewSpecificStudents(Connection con, Scanner sc) {
        System.out.print("Enter IDs separated by commas (e.g., 1,2,5): ");
        String input = sc.nextLine();
        // Construct query like: SELECT * FROM students WHERE id IN (1, 2, 5)
        String query = "SELECT * FROM students WHERE id IN (" + input.replaceAll("[^0-9,]", "") + ")";
        displayStudents(con, query);
    }

    private static void insertStudent(Connection con, Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            int id = getValidInt(sc);
            System.out.print("Name: "); String name = sc.nextLine();
            System.out.print("Email: "); String email = sc.nextLine();
            System.out.print("College: "); String college = sc.nextLine();

            String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setString(4, college);
                ps.executeUpdate();
                System.out.println("Student added successfully!");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error: ID already exists.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
    
    // Operation: Update multiple fields at once
    private static void updateStudent(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Student ID to update: ");
            int id = getValidInt(sc);

            List<String> columns = new ArrayList<>();
            List<String> values = new ArrayList<>();

            System.out.println("Type 'yes' for the fields you want to update:");
            
            System.out.print("Update Name? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                columns.add("name = ?");
                System.out.print("Enter New Name: ");
                values.add(sc.nextLine());
            }

            System.out.print("Update Email? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                columns.add("email = ?");
                System.out.print("Enter New Email: ");
                values.add(sc.nextLine());
            }

            System.out.print("Update College? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) {
                columns.add("college = ?");
                System.out.print("Enter New College: ");
                values.add(sc.nextLine());
            }

            if (columns.isEmpty()) {
                System.out.println("No changes requested.");
                return;
            }

            // Join the selected columns into a SQL string
            String sql = "UPDATE students SET " + String.join(", ", columns) + " WHERE id = ?";
            
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                int i = 1;
                for (String val : values) {
                    ps.setString(i++, val);
                }
                ps.setInt(i, id); // Set the ID for the WHERE clause
                
                if (ps.executeUpdate() > 0) System.out.println("Update successful!");
                else System.out.println("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    private static void deleteStudent(Connection con, Scanner sc) {
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = getValidInt(sc);

            String sql = "DELETE FROM students WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) System.out.println("Deleted successfully!");
                else System.out.println("ID not found.");
            }
        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}