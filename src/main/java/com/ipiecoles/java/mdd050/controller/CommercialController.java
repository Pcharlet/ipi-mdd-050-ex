package com.ipiecoles.java.mdd050.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ipiecoles.java.mdd050.model.Commercial;

@RestController
@RequestMapping("/commercials")
public class CommercialController extends EmployeController {
	
		@RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8, value = "")
		public Commercial createEmploye(@RequestBody Commercial employe) {
			return this.employeService.creerEmploye(employe);
		}
	}
	


