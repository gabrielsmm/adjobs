package com.gabriel.empregos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.services.VagaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {
	
	@Autowired
	private VagaService service;
	
	@GetMapping
	public ResponseEntity<Page<Vaga>> findAll(Pageable pageable) {
		Page<Vaga> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/somente-vagas-estagio")
	public ResponseEntity<List<Vaga>> somenteVagasEstagio() {
		List<Vaga> list = service.somenteVagasEstagio();
		return ResponseEntity.ok(list);
	}
	
}
