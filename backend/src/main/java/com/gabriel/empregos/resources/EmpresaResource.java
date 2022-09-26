package com.gabriel.empregos.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.empregos.dtos.EmpresaDTO;
import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> findById(@PathVariable Integer id){
		Empresa obj = this.service.findById(id);
		return ResponseEntity.ok().body(new EmpresaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<Empresa>> findAll() {
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<Empresa> create(@Valid @RequestBody Empresa obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Empresa> update(@PathVariable Integer id, @Valid @RequestBody EmpresaDTO obj){
		Empresa newObj = this.service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

}
