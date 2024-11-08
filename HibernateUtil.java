package com.demo.Utility;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.Admin;
import com.demo.Bill;
import com.demo.Customer;
import com.demo.Payment;


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Bill.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Transaction.class)
                .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
