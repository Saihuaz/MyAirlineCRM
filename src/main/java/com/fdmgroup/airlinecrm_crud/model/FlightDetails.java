package com.fdmgroup.airlinecrm_crud.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flight_details")
public class FlightDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dest_airport")
	private Airport destAirport;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "dep_airport")
	private Airport depAirport;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id")
	private Airline airline;
	
	private LocalDate departureDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "flightdetails_id")
	private TicketOrder ticketFlightDetails;
	
	@OneToMany(mappedBy = "ticketFlightDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TicketOrder> TicketOrder;

	public FlightDetails() {
	}

	public FlightDetails(Integer id, Airport destAirport, Airport depAirport, Airline airline, LocalDate departureDate,
			com.fdmgroup.airlinecrm_crud.model.TicketOrder ticketFlightDetails,
			List<com.fdmgroup.airlinecrm_crud.model.TicketOrder> ticketOrder) {
		super();
		this.id = id;
		this.destAirport = destAirport;
		this.depAirport = depAirport;
		this.airline = airline;
		this.departureDate = departureDate;
		this.ticketFlightDetails = ticketFlightDetails;
		TicketOrder = ticketOrder;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Airport getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(Airport destAirport) {
		this.destAirport = destAirport;
	}

	public Airport getDepAirport() {
		return depAirport;
	}

	public void setDepAirport(Airport depAirport) {
		this.depAirport = depAirport;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public TicketOrder getTicketFlightDetails() {
		return ticketFlightDetails;
	}

	public void setTicketFlightDetails(TicketOrder ticketFlightDetails) {
		this.ticketFlightDetails = ticketFlightDetails;
	}

	public List<TicketOrder> getTicketOrder() {
		return TicketOrder;
	}

	public void setTicketOrder(List<TicketOrder> ticketOrder) {
		TicketOrder = ticketOrder;
	}

	@Override
	public String toString() {
		return "FlightDetails [id=" + id + ", destAirport=" + destAirport + ", depAirport=" + depAirport + ", airline="
				+ airline + ", departureDate=" + departureDate + ", ticketFlightDetails=" + ticketFlightDetails
				+ ", TicketOrder=" + TicketOrder + "]";
	}

	

}
