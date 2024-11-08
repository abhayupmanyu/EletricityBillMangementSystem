package com.demo.DAO;

import org.hibernate.Session;

import org.hibernate.Transaction;

import com.demo.Bill;
import com.demo.Utility.HibernateUtil;



public class BillDAO {

    public void saveBill(Bill bill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bill);
        transaction.commit();
        session.close();
    }

    public Bill getBillById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Bill bill = session.get(Bill.class, id);
        session.close();
        return bill;
    }

    public void updateBill(Bill bill) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bill);
        transaction.commit();
        session.close();
    }

    public void deleteBill(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Bill bill = session.get(Bill.class, id);
        session.delete(bill);
        transaction.commit();
        session.close();
    }
}