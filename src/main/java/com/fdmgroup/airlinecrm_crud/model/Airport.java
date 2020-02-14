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
@Table(name = "airport")
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	private String airport_name;

	@OneToMany(mappedBy = "destAirport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FlightDetails> flightDestAirport;

	@OneToMany(mappedBy = "depAirport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FlightDetails> flightDepAirport;

	public Airport() {
	}

	public Airport(Integer id, String airport_name, List<FlightDetails> flightDestAirport,
			List<FlightDetails> flightDepAirport) {
		super();
		this.id = id;
		this.airport_name = airport_name;
		this.flightDestAirport = flightDestAirport;
		this.flightDepAirport = flightDepAirport;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}

	public List<FlightDetails> getFlightDestAirport() {
		return flightDestAirport;
	}

	public void setFlightDestAirport(List<FlightDetails> flightDestAirport) {
		this.flightDestAirport = flightDestAirport;
	}

	public List<FlightDetails> getFlightDepAirport() {
		return flightDepAirport;
	}

	public void setFlightDepAirport(List<FlightDetails> flightDepAirport) {
		this.flightDepAirport = flightDepAirport;
	}

	@Override
	public String toString() {
		return "Airport [id=" + id + ", airport_name=" + airport_name + ", flightDestAirport=" + flightDestAirport
				+ ", flightDepAirport=" + flightDepAirport + "]";
	}

	

}
