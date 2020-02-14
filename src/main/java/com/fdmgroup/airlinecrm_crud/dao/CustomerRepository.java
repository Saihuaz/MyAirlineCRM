package com.fdmgroup.airlinecrm_crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.airlinecrm_crud.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
