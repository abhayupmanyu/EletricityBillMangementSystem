package com.demo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.Admin;
import com.demo.Customer;
import com.demo.Utility.HibernateUtil;
import javax.persistence.Query;
import java.util.List;

public class AdminDAO {

    
    // Method to save an Admin entity
    public void saveAdmin(Admin admin) {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(admin);  // Save the Admin object to the database
        transaction.commit();
        session.close();
    }

    // Method to retrieve an Admin entity by id
    public Admin getAdmin(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Admin admin = session.get(Admin.class, id);  // Get the Admin object by id
        transaction.commit();
        return admin;
    }

    // Method to update an existing Admin entity
    public void updateAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(admin);  // Update the Admin object in the database
        transaction.commit();
        session.close();
    }

    // Method to delete an Admin entity by id
    public void deleteAdmin(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
           
       /* // Using HQL to delete the Admin object by id
        Query query = session.createQuery("delete from Admin where id=:adminId");
        query.setParameter("adminId", id);
        query.executeUpdate();  */
        Admin ad = session.get(Admin.class, id);
        session.delete(ad);

        transaction.commit();
        session.close();
    }

    // Method to retrieve all Admin entities
    public List<Admin> getAllAdmins() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<Admin> admins = session.createQuery("from Admin", Admin.class).getResultList();

        transaction.commit();
        return admins;
    }

    
}

