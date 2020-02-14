package com.fdmgroup.airlinecrm_crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdmgroup.airlinecrm_crud.model.TicketOrder;

public interface TicketOrderRepository extends CrudRepository <TicketOrder, Integer> {

}
