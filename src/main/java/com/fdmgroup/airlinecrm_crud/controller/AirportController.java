package com.fdmgroup.airlinecrm_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.AirportRepository;
import com.fdmgroup.airlinecrm_crud.model.Airport;

@Controller
public class AirportController {
	@Autowired
	private AirportRepository airportRepository;
	
	@GetMapping("/airportindex")
	public String airportIndex(Model model) {
		model.addAttribute("airports", airportRepository.findAll());
		return "index-airport";
	}
	
	@GetMapping("/airportsignup")
	public String showAirportSignUpForm(Airport airport) {
		return "add-airport";
	}

	@PostMapping("/addairport")
	public String addAirport(@Valid Airport airport, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-airport";
		}

		airportRepository.save(airport);
		model.addAttribute("airports", airportRepository.findAll());
		return "index-airport";
	}

	@GetMapping("/editairport/{id}")
	public String showAirportUpdateForm(@PathVariable("id") Integer id, Model model) {
		Airport airport = airportRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid airports Id:" + id));

		model.addAttribute("airports", airport);
		return "update-airport";

	}

	@PostMapping("/updateairport/{id}")
	public String updateAirport(@PathVariable("id") Integer id, @Valid Airport airport, BindingResult result, Model model) {
		if (result.hasErrors()) {
			airport.setId(id);
			return "update-airport";
		}

		airportRepository.save(airport);
		model.addAttribute("airports", airportRepository.findAll());
		return "index-airport";
	}

	@GetMapping("/deleteairport/{id}")
	public String deleteAirport(@PathVariable("id") Integer id, Model model) {
		Airport airport = airportRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid airport Id:" + id));
		airportRepository.delete(airport);
		model.addAttribute("airports", airportRepository.findAll());
		return "index-airports";
	}

}
