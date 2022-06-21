package com.gabriel.empregos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.empregos.dtos.CandidatoDTO;
import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.services.CandidatoService;

@RestController
@RequestMapping(value = "/candidatos")
public class CandidatoResource {
	
	@Autowired
	private CandidatoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CandidatoDTO> findById(@PathVariable Integer id){
		Candidato obj = this.service.findById(Integer.toUnsignedLong(id));
		return ResponseEntity.ok().body(new CandidatoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<Candidato>> findAll() {
		List<Candidato> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Candidato> create(@Valid @RequestBody Candidato obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
//		return ResponseEntity.created(uri).build();
	}

}
