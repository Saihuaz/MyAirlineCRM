package com.fdmgroup.airlinecrm_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.TicketOrderRepository;
import com.fdmgroup.airlinecrm_crud.model.TicketOrder;

@Controller
public class TicketOrderController {
	@Autowired
	private TicketOrderRepository ticketOrderRepository;
	
	@GetMapping("/ticketorderindex")
	public String ticketOrderIndex(Model model) {
		model.addAttribute("ticketOrders", ticketOrderRepository.findAll());
		return "index-ticketorder";
	}
	
	@GetMapping("/ticketordersignup")
	public String showSignUpFormTicketOrder(TicketOrder ticketOrder) {
		return "add-ticketorder";
	}

	@PostMapping("/addticketorder")
	public String addTicketOrder(@Valid TicketOrder ticketOrder, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-ticketorder";
		}

		ticketOrderRepository.save(ticketOrder);
		model.addAttribute("tickerOrders", ticketOrderRepository.findAll());
		return "index-ticketorder";
	}

	@GetMapping("/editticketorder/{id}")
	public String showUpdateTicketOrders(@PathVariable("id") Integer id, Model model) {
		TicketOrder ticketOrder = ticketOrderRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid ticket order Id:" + id));

		model.addAttribute("ticketOrders", ticketOrder);
		return "update-ticketorder";

	}

	@PostMapping("/updateticketorder/{id}")
	public String updateTicketOrders(@PathVariable("id") Integer id, @Valid TicketOrder ticketOrder, BindingResult result, Model model) {
		if (result.hasErrors()) {
			ticketOrder.setId(id);
			return "update-ticketorder";
		}

		ticketOrderRepository.save(ticketOrder);
		model.addAttribute("ticketOrders", ticketOrderRepository.findAll());
		return "index-ticketorder";
	}

	@GetMapping("/deleteticketorder/{id}")
	public String deleteTicketOrders(@PathVariable("id") Integer id, Model model) {
		TicketOrder ticketOrder = ticketOrderRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid ticket order Id:" + id));
		ticketOrderRepository.delete(ticketOrder);
		model.addAttribute("ticketOrders", ticketOrderRepository.findAll());
		return "index-ticketorder";
	}

}
