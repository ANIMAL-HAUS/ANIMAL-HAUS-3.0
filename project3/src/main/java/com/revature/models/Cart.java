package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique=true)
	private String username;
	private ServiceOffered service;
	private String contractorFirstName;
	private String contractorLastName;
	private Double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ServiceOffered getService() {
		return service;
	}
	public void setService(ServiceOffered service) {
		this.service = service;
	}
	public String getContractorFirstName() {
		return contractorFirstName;
	}
	public void setContractorFirstName(String contractorFirstName) {
		this.contractorFirstName = contractorFirstName;
	}
	public String getContractorLastName() {
		return contractorLastName;
	}
	public void setContractorLastName(String contractorLastName) {
		this.contractorLastName = contractorLastName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contractorFirstName, contractorLastName, id, price, service, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(contractorFirstName, other.contractorFirstName)
				&& Objects.equals(contractorLastName, other.contractorLastName) && id == other.id
				&& Objects.equals(price, other.price) && service == other.service
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", username=" + username + ", service=" + service + ", contractorFirstName="
				+ contractorFirstName + ", contractorLastName=" + contractorLastName + ", price=" + price + "]";
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int id, String username, ServiceOffered service, String contractorFirstName, String contractorLastName,
			Double price) {
		super();
		this.id = id;
		this.username = username;
		this.service = service;
		this.contractorFirstName = contractorFirstName;
		this.contractorLastName = contractorLastName;
		this.price = price;
	}
	public Cart(String username, ServiceOffered service, String contractorFirstName, String contractorLastName,
			Double price) {
		super();
		this.username = username;
		this.service = service;
		this.contractorFirstName = contractorFirstName;
		this.contractorLastName = contractorLastName;
		this.price = price;
	}
	
	
}
