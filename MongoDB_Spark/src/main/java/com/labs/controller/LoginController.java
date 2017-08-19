package com.labs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anupamrakshit on 15/08/17.
 */
@Controller
@SessionAttributes("name")
public class LoginController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model){
		return "login";
	}


	@RequestMapping(value="/", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

		if (validateUser(name, password)) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}

		model.put("name", name);
		model.put("password", password);

		return "welcome";
	}

	private boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("anupam")
				&& password.equalsIgnoreCase("rakshit");
	}
}
