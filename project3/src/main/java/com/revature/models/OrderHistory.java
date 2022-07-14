package com.revature.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "OrderList")
public class OrderHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String username;
	private ArrayList<Product> products;
	
	
}
