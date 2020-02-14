package com.fdmgroup.airlinecrm_crud.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.CustomerRepository;
import com.fdmgroup.airlinecrm_crud.model.Customer;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customerindex")
	public String customerIndex(Model model) {
		model.addAttribute("customers", customerRepository.findAll());
		return "index-customer";
	}
	
	@GetMapping("/customersignup")
	public String showSignUpFormCustomer(Customer customer) {
		return "add-customer";
	}

	@PostMapping("/addcustomer")
	public String addCustomer(@Valid Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-customer";
		}

		customerRepository.save(customer);
		model.addAttribute("customers", customerRepository.findAll());
		return "index-customer";
	}

	@GetMapping("/editcustomer/{id}")
	public String showUpdateFormCustomer(@PathVariable("id") Integer id, Model model) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));

		model.addAttribute("customers", customer);
		return "update-customer";

	}

	@PostMapping("/updatecustomer/{id}")
	public String updateCustomer(@PathVariable("id") Integer id, @Valid Customer customer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			customer.setId(id);
			return "update-customer";
		}

		customerRepository.save(customer);
		model.addAttribute("customers", customerRepository.findAll());
		return "index-customer";
	}

	@GetMapping("/deletecustomer/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id, Model model) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer Id:" + id));
		customerRepository.delete(customer);
		model.addAttribute("customers", customerRepository.findAll());
		return "index-customer";
	}

	public Map<String, Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCustomer(Customer mockCustomer) {
		// TODO Auto-generated method stub
		
	}

	public void removeCustomerByFirstName(String customerFirstName) {
		// TODO Auto-generated method stub
		
	}

}
