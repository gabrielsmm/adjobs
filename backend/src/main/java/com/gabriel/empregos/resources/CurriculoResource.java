package com.gabriel.empregos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.empregos.entities.Curriculo;
import com.gabriel.empregos.services.CurriculoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/curriculos")
public class CurriculoResource {
	
	@Autowired
	private CurriculoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Curriculo> findById(@PathVariable Integer id){
		Curriculo obj = service.findById(Integer.toUnsignedLong(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Curriculo>> findAll() {
		List<Curriculo> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/candidato/{idCandidato}")
	public ResponseEntity<Curriculo> findByCandidato(@PathVariable Integer idCandidato) {
		Curriculo obj = service.findByCandidato(idCandidato);
		return ResponseEntity.ok().body(obj);
	}
	
//	@PostMapping
//	public ResponseEntity<Candidato> create(@Valid @RequestBody Candidato obj) {
//		obj = service.create(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
////		return ResponseEntity.created(uri).build();
//	}
	
}
