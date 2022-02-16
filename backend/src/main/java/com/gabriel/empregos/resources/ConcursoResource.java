package com.gabriel.empregos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.empregos.entities.Concurso;
import com.gabriel.empregos.services.ConcursoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/concursos")
public class ConcursoResource {
	
	@Autowired
	private ConcursoService service;
	
	@GetMapping
	public ResponseEntity<List<Concurso>> findAll() {
		List<Concurso> list = service.findAll();
		return ResponseEntity.ok(list);
 	}
	
}
