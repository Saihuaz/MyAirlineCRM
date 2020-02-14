package com.fdmgroup.airlinecrm_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.AirlineRepository;
import com.fdmgroup.airlinecrm_crud.model.Airline;

@Controller
public class AirlineController {
	@Autowired
	private AirlineRepository airlineRepository;
	
	@GetMapping("/airlineindex")
	public String airlineIndex(Model model) {
		model.addAttribute("airlines", airlineRepository.findAll());
		return "index-airline";
	}
	
	@GetMapping("/airlinesignup")
	public String showAirlineSignUpForm(Airline airline) {
		return "add-airline";
	}

	@PostMapping("/addairline")
	public String addAirline(@Valid Airline airline, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-airline";
		}

		airlineRepository.save(airline);
		model.addAttribute("airlines", airlineRepository.findAll());
		return "index-airline";
	}

	@GetMapping("/editairline/{id}")
	public String showAirlineUpdateForm(@PathVariable("id") Integer id, Model model) {
		Airline airline = airlineRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid airline Id:" + id));

		model.addAttribute("airlines", airline);
		return "update-airline";

	}

	@PostMapping("/updateairline/{id}")
	public String updateAirline(@PathVariable("id") Integer id, @Valid Airline airline, BindingResult result, Model model) {
		if (result.hasErrors()) {
			airline.setId(id);
			return "update-airline";
		}

		airlineRepository.save(airline);
		model.addAttribute("airlines", airlineRepository.findAll());
		return "index-airline";
	}

	@GetMapping("/deleteairline/{id}")
	public String deleteAirline(@PathVariable("id") Integer id, Model model) {
		Airline airline = airlineRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid airline Id:" + id));
		airlineRepository.delete(airline);
		model.addAttribute("airlines", airlineRepository.findAll());
		return "index-airline";
	}

}
