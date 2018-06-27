package com.ipiecoles.java.mdd050.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipiecoles.java.mdd050.exception.EmployeException;
import com.ipiecoles.java.mdd050.model.Commercial;

@RestController
@RequestMapping("/commercials")
public class CommercialController extends EmployeController {
	
		@RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_CHARSET_UTF_8, produces = APPLICATION_JSON_CHARSET_UTF_8, value = "")
		public Commercial createEmploye(@RequestBody Commercial employe) {
			return this.employeService.creerEmploye(employe);
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public Commercial updateEmploye(@PathVariable(value = "id") Long id, @RequestBody Commercial employe) {
		   try {
		      return this.employeService.updateEmploye(id, employe);
		   } catch (EmployeException e) {
		      throw new EntityNotFoundException(e.getMessage());
		   }
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
		@ResponseStatus(value = HttpStatus.NO_CONTENT)
		    public void deleteEmploye(@PathVariable Long id) throws EmployeException {
		        try {
		            this.employeService.deleteEmploye(id);
		            
		        } catch (IllegalArgumentException e){
	            throw new EntityNotFoundException("L'employé d'identifiant : " + id + " n'a pas été trouvé.");
		       }
		    }
	}
	


