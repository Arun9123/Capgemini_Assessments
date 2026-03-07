package com.hibernate.Assessment2_Mar07;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CustomerDAOImpl {
    private EntityManager em;

    public CustomerDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void insertCustomer(Customer customer) {
        em.persist(customer);
    }

    public void updateCustomer(Customer customer) {
        em.merge(customer);
    }

    public void deleteCustomerById(int id) {
        Customer customer = em.find(Customer.class, id);
        if (customer != null) {
            em.remove(customer);
        }
    }

    public Customer fetchCustomerById(int id) {
        return em.find(Customer.class, id);
    }

    public List<Customer> fetchAllCustomers() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    // Question 4: JPQL Query to fetch by email
    public Customer fetchCustomerByEmail(String email) {
        TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}