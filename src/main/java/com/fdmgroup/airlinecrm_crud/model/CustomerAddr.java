package com.fdmgroup.airlinecrm_crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "customer_address")
public class CustomerAddr {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	private Integer house_number; 
	private String street;
	private String city;  
	private String country;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public CustomerAddr() {}

	public CustomerAddr(Integer id, Integer house_number, String street, String city, String country,
			Customer customer) {
		super();
		this.id = id;
		this.house_number = house_number;
		this.street = street;
		this.city = city;
		this.country = country;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHouse_number() {
		return house_number;
	}

	public void setHouse_number(Integer house_number) {
		this.house_number = house_number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerAddr [id=" + id + ", house_number=" + house_number + ", street=" + street + ", city=" + city
				+ ", country=" + country + ", customer=" + customer + "]";
	}
	

}
