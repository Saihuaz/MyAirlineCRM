package com.fdmgroup.airlinecrm_crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.airlinecrm_crud.model.Airline;

public interface AirlineRepository extends CrudRepository <Airline, Integer> {

}
