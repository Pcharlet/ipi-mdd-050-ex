package com.ipiecoles.java.mdd050.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.service.EmployeService;


	@RestController
	@RequestMapping(value = "/employes")
	public class EmployeController {
	public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";
		
	  @Autowired
	  private EmployeService employeService;

	  @RequestMapping(value = "/count", method = RequestMethod.GET)
	  public Long CountEmployes() {
	      return employeService.countAllEmploye();
	  }
	  
	  @RequestMapping(value = "/{id}", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET)
	  public Employe findById(@PathVariable(value = "id") Long id){
	     Employe employe = employeService.findById(id);
	         if(employe == null){
	             throw new EntityNotFoundException("L'employé d'identifiant : " + id + " n'a pas été trouvé.");
	         }
	         return employe;
	  }
	  
	  @RequestMapping(value = "", produces = APPLICATION_JSON_CHARSET_UTF_8, method = RequestMethod.GET, params = "matricule")
	  public Employe findAll(@RequestParam("matricule") String matricule){
	     return employeService.findMyMatricule(matricule);
	  }
	  
	  
	  
	  
	  
	}

