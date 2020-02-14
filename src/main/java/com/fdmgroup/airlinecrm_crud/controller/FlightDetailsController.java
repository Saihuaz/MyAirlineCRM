package com.fdmgroup.airlinecrm_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.FlightDetailsRepository;
import com.fdmgroup.airlinecrm_crud.model.FlightDetails;

@Controller
public class FlightDetailsController {
	@Autowired
	FlightDetailsRepository flightDetailsRepository;
	
	@GetMapping("/flightdetailsindex")
	public String flightDetailsIndex(Model model) {
		model.addAttribute("flightdetails", flightDetailsRepository.findAll());
		return "index-flightdetails";
	}
	
	@GetMapping("/flightdetailssignup")
	public String showSignUpFormCustomer(FlightDetails flightDetails) {
		return "add-flightdetails";
	}

	@PostMapping("/addflightdetails")
	public String addFlightDetails(@Valid FlightDetails flightDetails, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-flightdetails";
		}

		flightDetailsRepository.save(flightDetails);
		model.addAttribute("flightdetails", flightDetailsRepository.findAll());
		return "index-flightdetails";
	}

	@GetMapping("/editflightdetails/{id}")
	public String showUpdateFlightDetails(@PathVariable("id") Integer id, Model model) {
		FlightDetails flightDetails = flightDetailsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid flight details Id:" + id));

		model.addAttribute("flightdetails", flightDetails);
		return "update-flightdetails";

	}

	@PostMapping("/updateflightdetails/{id}")
	public String updateFlightDetail(@PathVariable("id") Integer id, @Valid FlightDetails flightDetails, BindingResult result, Model model) {
		if (result.hasErrors()) {
			flightDetails.setId(id);
			return "update-flightdetails";
		}

		flightDetailsRepository.save(flightDetails);
		model.addAttribute("flightdetails", flightDetailsRepository.findAll());
		return "index-flightdetails";
	}

	@GetMapping("/deleteflightdetails/{id}")
	public String deleteFlightDetails(@PathVariable("id") Integer id, Model model) {
		FlightDetails flightDetails = flightDetailsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid flight details Id:" + id));
		flightDetailsRepository.delete(flightDetails);
		model.addAttribute("flightdetails", flightDetailsRepository.findAll());
		return "index-flightdetails";
	}
	

}
