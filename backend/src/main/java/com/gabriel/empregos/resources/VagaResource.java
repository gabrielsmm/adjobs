package com.gabriel.empregos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.services.VagaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {
	
	@Autowired
	private VagaService service;
	
	@GetMapping
	public ResponseEntity<Page<Vaga>> findAll(@RequestParam(required = false) String nome,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Vaga> list;
		if (nome == null) {
			list = service.findAll(paging);
		} else {
			list = service.findAllByNome(nome, paging);
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/empresa/{idEmpresa}")
	public ResponseEntity<List<Vaga>> findAllByEmpresa(@PathVariable("idEmpresa") Integer idEmpresa) {
		List<Vaga> list = service.findAllByEmpresa(idEmpresa);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/somente-vagas-estagio")
	public ResponseEntity<List<Vaga>> getSomenteVagasEstagio() {
		List<Vaga> list = service.getSomenteVagasEstagio();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vaga> getDados(@PathVariable("id") Long id) {
		Vaga vaga = service.getDados(id);
		return ResponseEntity.ok().body(vaga);
	}
	
	@GetMapping(value = "/numero-vagas")
	public ResponseEntity<?> buscaNumeroVagas() {
		return ResponseEntity.ok().body(service.buscaNumeroVagas());
	}
	
	@GetMapping(value = "/numero-vagas/{idEmpresa}")
	public ResponseEntity<?> buscaNumeroVagasCadastradasPorEmpresa(@PathVariable Integer idEmpresa) {
		return ResponseEntity.ok().body(service.buscaNumeroVagasCadastradasPorEmpresa(idEmpresa));
	}
	
	@PostMapping
	public ResponseEntity<Vaga> create(@Valid @RequestBody Vaga obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
//		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Vaga> update(@PathVariable Long id, @Valid @RequestBody Vaga obj){
		Vaga newObj = this.service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
}
