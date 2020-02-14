package com.fdmgroup.airlinecrm_crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.airlinecrm_crud.model.UserLogin;

public interface UserLoginRepository extends CrudRepository <UserLogin, Integer> {

	UserLogin findByName(String name);
	

}
