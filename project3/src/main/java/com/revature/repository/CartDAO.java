package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.revature.models.Cart;
import com.revature.models.OrderHistory;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.services.CartServices;
import com.revature.utilities.HibernateUtil;
@Service
@Transactional
public class CartDAO {
	private static ArrayList<Cart> products = new ArrayList<Cart>();
	@PersistenceContext
	public static void insertProduct(Cart product) {
		try (Session ses = HibernateUtil.getSession()){
			ses.save(product);
			HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
			
			}catch(HibernateException e) {
				System.out.println(e);
				e.printStackTrace();
				
			}	
//		Configuration cfg  = new Configuration();
//		cfg.configure();
//		cfg.addAnnotatedClass(Cart.class);
//		SessionFactory sf = cfg.buildSessionFactory();
//		Session session  = sf.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(product);
//		tx.commit();
//		session.close();
//		return 0;
			}
	
	
	public ArrayList<Cart> insertUserItem(Cart product) {
		products.add(product);
		return products;
	}
	public static ArrayList<Cart> getAllUserProducts(){ 
		return products; 
	}
	public CartDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Cart>   removeUserItems( int index){
			products.remove(index);
			return products;
			
	}
	public static void clearAllItems( ) {
		products.clear();
	}
public static double checkout(int userId, List<Cart> p2) {
		double amount = 0;
		double tax = .08;
		try (Session ses = HibernateUtil.getSession()){
			for (Cart p : p2) {
				double temp =  (p.getPrice() * tax);
				amount += temp;
				
			}
			clearAllItems();
			HibernateUtil.closeSession(); //This closes the session which will help prevent a memory leak issue
			return amount;
			}catch(HibernateException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		return 0;
	}
public static List<Cart> getOrderbyUsername(String username) {
	Session ses = HibernateUtil.getSession(); //This opens the session
	//Users user = ses.(Users.class, username);
	Query q = ses.createQuery("FROM Cart WHERE username = ?1");
	q.setParameter(1,username);
	try {
		List<Cart> userList = q.getResultList();
		HibernateUtil.closeSession();
		
		System.out.println("user exist");
		return userList;
	} catch(Exception e) {
		return null;
	}

	
}

public static void removeItem(int id){
	Session session = HibernateUtil.getSession();
	Cart cart = session.get(Cart.class, id);
	System.out.println(cart);
	session.beginTransaction();
	session.delete(cart);
	session.getTransaction().commit();
	HibernateUtil.closeSession();
}


public static void clearItems(String username) {
	
	Session ses = HibernateUtil.getSession(); //This opens the session
	Transaction txn = ses.beginTransaction();
	//Users user = ses.(Users.class, username);
	Query q = ses.createQuery("DELETE FROM Cart WHERE username = ?1");
	
	q.setParameter(1,username);
	q.executeUpdate();
	txn.commit();
	HibernateUtil.closeSession();
//	try {
//		List<Cart> userList = q.getResultList();
//		HibernateUtil.closeSession();
//		
//		System.out.println("user exist");
//		return userList;
//	} catch(Exception e) {
//		return null;
//	}

	
}
}