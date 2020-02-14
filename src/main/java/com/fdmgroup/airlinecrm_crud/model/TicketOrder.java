package com.fdmgroup.airlinecrm_crud.model;

import java.time.LocalDate;

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
@Table (name = "ticket_order")
public class TicketOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",updatable = false, nullable = false)
	private Integer id;
	
	private int price;
	private LocalDate date_purchased;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer ticketCustomer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flightdetails_id")
	private FlightDetails ticketFlightDetails;
	
	public TicketOrder() {}

	public TicketOrder(Integer id, int price, LocalDate date_purchased, Customer ticketCustomer,
			FlightDetails ticketFlightDetails) {
		super();
		this.id = id;
		this.price = price;
		this.date_purchased = date_purchased;
		this.ticketCustomer = ticketCustomer;
		this.ticketFlightDetails = ticketFlightDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getDate_purchased() {
		return date_purchased;
	}

	public void setDate_purchased(LocalDate date_purchased) {
		this.date_purchased = date_purchased;
	}

	public Customer getTicketCustomer() {
		return ticketCustomer;
	}

	public void setTicketCustomer(Customer ticketCustomer) {
		this.ticketCustomer = ticketCustomer;
	}

	public FlightDetails getTicketFlightDetails() {
		return ticketFlightDetails;
	}

	public void setTicketFlightDetails(FlightDetails ticketFlightDetails) {
		this.ticketFlightDetails = ticketFlightDetails;
	}

	@Override
	public String toString() {
		return "TicketOrder [id=" + id + ", price=" + price + ", date_purchased=" + date_purchased + ", ticketCustomer="
				+ ticketCustomer + ", ticketFlightDetails=" + ticketFlightDetails + "]";
	}

}
