package com.labs.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by anupamrakshit on 15/08/17.
 */
@RestController
@SessionAttributes("name")
public class LoginController {


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model){
		return "login";
	}


	@RequestMapping(value="/", method = RequestMethod.GET)
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
		// in28minutes, dummy
		return userid.equalsIgnoreCase("in28minutes")
				&& password.equalsIgnoreCase("dummy");
	}
}
