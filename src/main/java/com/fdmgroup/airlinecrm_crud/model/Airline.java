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

@Entity
public class Airline {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private String airline_name;
	
	@OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FlightDetails> flightAirlineName;
	
	public Airline() {}

	public Airline(Integer id, String airline_name, List<FlightDetails> flightAirlineName) {
		super();
		this.id = id;
		this.airline_name = airline_name;
		this.flightAirlineName = flightAirlineName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAirline_name() {
		return airline_name;
	}

	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
	}

	public List<FlightDetails> getFlightAirlineName() {
		return flightAirlineName;
	}

	public void setFlightAirlineName(List<FlightDetails> flightAirlineName) {
		this.flightAirlineName = flightAirlineName;
	}

	@Override
	public String toString() {
		return "Airline [id=" + id + ", airline_name=" + airline_name + ", flightAirlineName=" + flightAirlineName
				+ "]";
	}
	
	

}
