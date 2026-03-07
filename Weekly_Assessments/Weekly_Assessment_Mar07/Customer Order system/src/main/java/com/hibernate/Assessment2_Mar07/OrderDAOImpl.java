package com.hibernate.Assessment2_Mar07;

import jakarta.persistence.EntityManager;

public class OrderDAOImpl {
    private EntityManager em;

    public OrderDAOImpl(EntityManager em) {
        this.em = em;
    }

    public void updateOrder(Order order) {
        em.merge(order);
    }

    public Order fetchOrderById(int id) {
        return em.find(Order.class, id);
    }
}