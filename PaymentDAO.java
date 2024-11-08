package com.demo.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.Customer;
import com.demo.Payment;
import com.demo.Utility.HibernateUtil;

public class PaymentDAO {

	
	
	public void savePayment(Payment p) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction= session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
		
	}
	
	
	  public Payment getPaymentById(int id) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Payment p = session.get(Payment.class, id);
	        session.close();
	        return p;
	    }

	
	
	
	
	
	
	
	
	
}
