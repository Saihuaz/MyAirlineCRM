package com.fdmgroup.airlinecrm_crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.airlinecrm_crud.dao.UserLoginRepository;
import com.fdmgroup.airlinecrm_crud.model.UserLogin;

@Controller
public class UserLoginController {
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@GetMapping("/userloginindex")
	public String userLoginIndex(Model model) {
		model.addAttribute("userLogin", userLoginRepository.findAll());
		return "index-userlogin";
	}
	
	@GetMapping("/userloginsignup")
	public String showSignUpFormUserLogin(UserLogin userLogin) {
		return "add-userlogin";
	}

	@PostMapping("/adduserlogin")
	public String addUserLogin(@Valid UserLogin userLogin, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-userlogin";
		}

		userLoginRepository.save(userLogin);
		model.addAttribute("userLogin", userLoginRepository.findAll());
		return "index-userlogin";
	}

	@GetMapping("/edituserlogin/{id}")
	public String showUpdateFormUserLogin(@PathVariable("id") Integer id, Model model) {
		UserLogin userLogin = userLoginRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user login Id:" + id));

		model.addAttribute("userLogin", userLogin);
		return "update-userlogin";

	}

	@PostMapping("/updateuserlogin/{id}")
	public String updateUserLogin(@PathVariable("id") Integer id, @Valid UserLogin userLogin, BindingResult result, Model model) {
		if (result.hasErrors()) {
			userLogin.setId(id);
			return "update-userlogin";
		}

		userLoginRepository.save(userLogin);
		model.addAttribute("userLogin", userLoginRepository.findAll());
		return "index-userlogin";
	}

	@GetMapping("/deleteuserlogin/{id}")
	public String deleteUserLogin(@PathVariable("id") Integer id, Model model) {
		UserLogin userLogin = userLoginRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user login Id:" + id));
		userLoginRepository.delete(userLogin);
		model.addAttribute("userLogin", userLoginRepository.findAll());
		return "index-userlogin";
	}
}
