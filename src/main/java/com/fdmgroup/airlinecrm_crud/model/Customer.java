package com.fdmgroup.airlinecrm_crud.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",updatable = false, nullable = false)
	private Integer id;
	
	private String first_name;
	private String last_name;
	private Integer age;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerAddr> customerAddr;
	
	@OneToMany(mappedBy = "ticketCustomer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TicketOrder> ticketOrder;
	
	public Customer(){}

	public Customer(Integer id, String first_name, String last_name, Integer age, List<CustomerAddr> customerAddr,
			List<TicketOrder> ticketOrder) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.customerAddr = customerAddr;
		this.ticketOrder = ticketOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<CustomerAddr> getCustomerAddr() {
		return customerAddr;
	}

	public void setCustomerAddr(List<CustomerAddr> customerAddr) {
		this.customerAddr = customerAddr;
	}

	public List<TicketOrder> getTicketOrder() {
		return ticketOrder;
	}

	public void setTicketOrder(List<TicketOrder> ticketOrder) {
		this.ticketOrder = ticketOrder;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age=" + age
				+ ", customerAddr=" + customerAddr + ", ticketOrder=" + ticketOrder + "]";
	}

}
