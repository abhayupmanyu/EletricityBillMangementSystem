package com.demo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.Admin;
import com.demo.Customer;
import com.demo.Utility.HibernateUtil;



public class CustomerDAO {

    public void saveCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public Customer getCustomerById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public void updateCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    public void deleteCustomer(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, id);
        session.delete(customer);
        transaction.commit();
        session.close();
    }
    
    // Method to retrieve all Admin entities
    public List<Customer> getAllCustomer() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Customer> customers = session.createQuery("from Customer", Customer.class).getResultList();

        transaction.commit();
        return customers;
    }
}
