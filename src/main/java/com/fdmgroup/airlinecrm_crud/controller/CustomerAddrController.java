package com.fdmgroup.airlinecrm_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.CustomerAddrRepository;
import com.fdmgroup.airlinecrm_crud.model.CustomerAddr;

@Controller
public class CustomerAddrController {
	@Autowired
	private CustomerAddrRepository customerAddrRepository;
	
	@GetMapping("/customeraddrindex")
	public String customerAddrIndex(Model model) {
		model.addAttribute("customer_address", customerAddrRepository.findAll());
		return "index-customeraddr";
	}

	@GetMapping("/customeraddrsignup")
	public String showCustomerAddrSignUpForm(CustomerAddr customerAddr) {
		return "add-customeraddr";
	}

	@PostMapping("/addcustomeraddr")
	public String addCustomerAddr(@Valid CustomerAddr customerAddr, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-customeraddr";
		}

		customerAddrRepository.save(customerAddr);
		model.addAttribute("customer_address", customerAddrRepository.findAll());
		return "index-customeraddr";
	}

	@GetMapping("/editcustomeraddr/{id}")
	public String showCustomerAddrUpdateForm(@PathVariable("id") Integer id, Model model) {
		CustomerAddr customerAddr = customerAddrRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer address Id:" + id));

		model.addAttribute("customer_address", customerAddr);
		return "update-customeraddr";

	}

	@PostMapping("/updatecustomeraddr/{id}")
	public String updateCustomerAddresss(@PathVariable("id") Integer id, @Valid CustomerAddr customerAddr, BindingResult result, Model model) {
		if (result.hasErrors()) {
		customerAddr.setId(id);
			return "update-customeraddr";
		}

		customerAddrRepository.save(customerAddr);
		model.addAttribute("customer_address", customerAddrRepository.findAll());
		return "index-customeraddr";
	}

	@GetMapping("/deletecustomeraddr/{id}")
	public String deleteCustomerAddr(@PathVariable("id") Integer id, Model model) {
		CustomerAddr customerAddr = customerAddrRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer address Id:" + id));
		customerAddrRepository.delete(customerAddr);
		model.addAttribute("customer_address", customerAddrRepository.findAll());
		return "index-customeraddr";
		}

	}

