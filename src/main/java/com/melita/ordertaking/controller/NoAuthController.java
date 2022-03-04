package com.melita.ordertaking.controller;

import com.melita.ordertaking.constants.AppCons;
import com.melita.ordertaking.constants.REST_URI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(REST_URI.NO_AUTH_MAIN)
public class NoAuthController {

	@GetMapping(REST_URI.TEST)
	public String chekAPI() {
		return AppCons.API_CHECK;
	}

}
