package com.hibernate.Hibernate2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");

    public static void main(String[] args) {
    	
        createEmployee("Ali", "ali@gmail.com", "96969", 70000);

        Employee found = readEmployee(1);
        
        System.out.println("Found: " + (found != null ? found.getName() : "Not Found"));

        updateEmployee(1, 105000);

//        deleteEmployee(1);
        
        emf.close();
    }

    // CREATE
    public static void createEmployee(String name, String email, String phone, double salary) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Employee e = new Employee("Arunabha", "arun@gmail.com", "90901", 95000);
            em.persist(e);
            Employee e1 = new Employee("Jyoti", "jyoti@gmail.com", "90902", 45000);
            em.persist(e1);
            Employee e2 = new Employee("Pushkar", "push@gmail.com", "90903", 25000);
            em.persist(e2);
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) et.rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    // READ
    public static Employee readEmployee(int id) {
        EntityManager em = emf.createEntityManager();
        Employee e = em.find(Employee.class, id);
        em.close();
        return e;
    }

    // UPDATE
    public static void updateEmployee(int id, int newSalary) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Employee e = em.find(Employee.class, id);
            if (e != null) {
                e.setSalary(newSalary);
            }
            et.commit();
        } catch (Exception ex) {
            if (et.isActive()) et.rollback();
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

//    // DELETE
//    public static void deleteEmployee(int id) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        try {
//            et.begin();
//            Employee e = em.find(Employee.class, id);
//            if (e != null) {
//                em.remove(e);
//            }
//            et.commit();
//        } catch (Exception ex) {
//            if (et.isActive()) et.rollback();
//            ex.printStackTrace();
//        } finally {
//            em.close();
//        }
//    }
}