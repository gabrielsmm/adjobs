package com.gabriel.empregos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.empregos.services.EmailService;

@RestController
@RequestMapping(value = "/email")
public class EmailResource {
	
	@Autowired
	private EmailService service;
	
	@GetMapping(value = "/send/{email}")
	public ResponseEntity<Void> sendMail(@PathVariable String email) {
		if (this.service.sendMail(email)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
}
