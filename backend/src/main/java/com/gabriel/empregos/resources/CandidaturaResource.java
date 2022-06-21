package com.gabriel.empregos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.empregos.entities.Candidatura;
import com.gabriel.empregos.services.CandidaturaService;

@RestController
@RequestMapping(value = "/candidaturas")
public class CandidaturaResource {
	
	@Autowired
	private CandidaturaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidatura> findById(@PathVariable Integer id){
		Candidatura obj = this.service.findById(Integer.toUnsignedLong(id));
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Candidatura>> findAll() {
		List<Candidatura> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/candidato/{idCandidato}")
	public ResponseEntity<List<Candidatura>> findAllByCandidato(@PathVariable Integer idCandidato) {
		List<Candidatura> list = service.findAllByCandidato(idCandidato);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/vaga/{idVaga}")
	public ResponseEntity<List<Candidatura>> findAllByVaga(@PathVariable Integer idVaga) {
		List<Candidatura> list = service.findAllByVaga(idVaga);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/candidatar/{idCandidato}/{idVaga}")
	public ResponseEntity<?> create(@PathVariable Integer idCandidato, @PathVariable Integer idVaga){
		Candidatura obj = service.create(idCandidato, idVaga);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Candidatura> update(@PathVariable Long id, @Valid @RequestBody Candidatura obj){
		Candidatura newObj = this.service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping(value = "/numero-candidaturas/{idCandidato}")
	public ResponseEntity<?> buscaNumeroCandidaturas(@PathVariable Integer idCandidato) {
		return ResponseEntity.ok().body(service.buscaNumeroCandidaturas(idCandidato));
	}
	
//	@PostMapping
//	public ResponseEntity<Candidato> create(@Valid @RequestBody Candidato obj) {
//		obj = service.create(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).body(obj);
////		return ResponseEntity.created(uri).build();
//	}
	
}
