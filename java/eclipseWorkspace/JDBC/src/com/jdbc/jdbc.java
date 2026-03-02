package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        String url="jdbc:mysql://localhost:3306/jdbc";    // [API]:[Vendor]://[IP address of server: Port Number]/[Schema name]
        String user="root";
        String pass="Mysql@4239";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            st=con.createStatement();
            
            st.executeUpdate("INSERT INTO students (id, name, email, college) VALUES (5, 'Priya', 'priya@gmail.com', 'IEM')");
            rs=st.executeQuery("SELECT * FROM STUDENTS");
            while(rs.next()) {
                System.out.println(rs.getInt(1)+" , "+rs.getString("name")+" , "+rs.getString(3)+" , "+rs.getString("college"));
            }    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}