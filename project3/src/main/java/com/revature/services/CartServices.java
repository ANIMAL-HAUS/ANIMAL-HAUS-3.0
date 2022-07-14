package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Cart;
import com.revature.models.OrderHistory;
import com.revature.models.Product;
import com.revature.models.Users;
import com.revature.repository.CartDAO;
import com.revature.repository.CheckoutDAO;
import com.revature.repository.ProductDAO;

public class CartServices {
	private static CartDAO cd;
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	private static ProductDAO pd;
	private static UserServices us;
	public CartServices(CartDAO cart) {
		this.cd= cart; 
				
	}
	public List<Cart> getAllUserProducts() {
	
		 cartList = cd.getAllUserProducts();
		return cartList;
	}
	public void clearAllItems() {
		cd.clearAllItems();
	}
	public List<Cart> removeUserItems( int index) {
		cartList = cd.removeUserItems(index);
		return cartList;
	}
	public void insertProduct(Cart product) {
		
		CartDAO.insertProduct(product);
	}
	
	
	public CartServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Cart> getOrderByUsername(String username){
		return CartDAO.getOrderbyUsername(username);
	}
	public ArrayList<Cart> addingToCart(Cart p,ArrayList<Cart> products){
		
		cartList.add(p);
		System.out.println(cartList);
		return cartList;
		
	}
	public double checkout(int userid, ArrayList<Cart> p) {
		
		Users user =us.getUserById(userid);
		return CartDAO.checkout(user.getId(),p);
	}
	public void removeItem(int id) {
		CartDAO.removeItem(id);
	}
	public void clearItems(String username) {
		CartDAO.clearItems(username);
	}
}