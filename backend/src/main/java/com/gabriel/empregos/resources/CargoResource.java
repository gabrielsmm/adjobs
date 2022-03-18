package com.gabriel.empregos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.empregos.entities.Cargo;
import com.gabriel.empregos.services.CargoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {
	
	@Autowired
	private CargoService service;
	
	@GetMapping
	public ResponseEntity<List<Cargo>> findAll() {	
		List<Cargo> list = service.findAll();
		return ResponseEntity.ok(list);
 	}
	
}
