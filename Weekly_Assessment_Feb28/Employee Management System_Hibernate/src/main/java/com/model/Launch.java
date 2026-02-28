package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Launch {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        
        Session s = sf.openSession();

        try {
            Transaction t1 = s.beginTransaction();
            Employee e1 = new Employee(12, "Jenny", "jenny@mail.com", "88988", 110000);
            s.persist(e1); 
            t1.commit();
            System.out.println("Created: " + e1.getName());

            Employee fetched = s.get(Employee.class, 10);
            System.out.println("Read Employee: " + fetched.getName());

            // UPDATE
            Transaction t2 = s.beginTransaction();
            if (fetched != null) {
                fetched.setSalary(120000);
                s.merge(fetched);
            }
            t2.commit();
            System.out.println("Updated to: " + fetched.getName());

            // DELETE
            Transaction t3 = s.beginTransaction();
            Employee toDelete = s.get(Employee.class, 2);
            if (toDelete != null) {
                s.remove(toDelete);
            }
            t3.commit();
            System.out.println("Deleted successfully!");

        } catch (Exception ex) {
            System.err.println("Transaction failed, rolling back.");
            ex.printStackTrace();
        } finally {
            s.close();
            sf.close();
        }
    }
}