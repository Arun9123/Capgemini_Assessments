package com.hibernate.Assessment2_Mar07;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Initialize DAOs
        CustomerDAOImpl customerDAO = new CustomerDAOImpl(em);
        OrderDAOImpl orderDAO = new OrderDAOImpl(em);

        try {
            et.begin();
            String[] names = {"Arun", "Bonny", "Chirodeep", "Daniel", "Kabir"};
            String[] products = {"Monitor", "Keyboard", "Mouse", "Desk", "Chair"};
            
            for (int i = 0; i < 5; i++) {
                Customer tempCust = new Customer(names[i], names[i].toLowerCase() + "@test.com", "Mixed", 9000000000L + i, LocalDate.now());
                Order tempOrd = new Order("ORD-50" + i, products[i], 1, 1000.0 * (i + 1), LocalDate.now());
                tempCust.setOrder(tempOrd);
                customerDAO.insertCustomer(tempCust);
            }
            et.commit();
            System.out.println("5 Initial records inserted successfully!");

            // 1. Insert a new customer with order
            et.begin();
            Customer customer = new Customer("Ali", "ali@gmail.com", "Male", 9966554433L, LocalDate.now());
            Order order = new Order("ORD-100", "Smartphone", 1, 45000.0, LocalDate.now());
            customer.setOrder(order);
            customerDAO.insertCustomer(customer);
            et.commit();
            System.out.println("Customer and Order saved successfully!");

            // 2. Update customer details
            et.begin();
            Customer toUpdate = customerDAO.fetchCustomerById(customer.getId());
            toUpdate.setCustomerName("Ali Asgar");
            customerDAO.updateCustomer(toUpdate);
            et.commit();

            // 3. Fetch customer by id
            Customer fetched = customerDAO.fetchCustomerById(customer.getId());
            System.out.println("Fetched Customer: " + fetched.getCustomerName());

            // 4. Fetch all customers
            List<Customer> list = customerDAO.fetchAllCustomers();
            System.out.println("Total Customers in DB: " + list.size());

            // 5. Update order details and fetch order by id
            et.begin();
            Order ordToUpdate = orderDAO.fetchOrderById(order.getId());
            ordToUpdate.setProductName("Gaming Laptop");
            orderDAO.updateOrder(ordToUpdate);
            et.commit();
            System.out.println("Updated Order: " + orderDAO.fetchOrderById(order.getId()).getProductName());

            // 6. JPQL: Fetch by email
            Customer byEmail = customerDAO.fetchCustomerByEmail("daniel@test.com");
            System.out.println("Found by email: " + byEmail.getCustomerName());

            // 7. Delete customer by id
            et.begin();
            customerDAO.deleteCustomerById(3);
            et.commit();
            System.out.println("Customer deleted.");

        } catch (Exception e) {
            if (et.isActive()) et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
