package com.gabriel.empregos.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.empregos.dtos.UsuarioDTO;
import com.gabriel.empregos.entities.Usuario;
import com.gabriel.empregos.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping(value = "/login")
	public ResponseEntity<UsuarioDTO> findByEmail(@Valid @RequestBody Usuario obj){
		Usuario usuario = this.service.login(obj);
		return new ResponseEntity<UsuarioDTO>(new UsuarioDTO(usuario, "Bearer "), HttpStatus.ACCEPTED);
	}
	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
//		Usuario obj = this.usuarioService.findById(id);
//		return ResponseEntity.ok().body(obj);
//	}
	
//	@GetMapping
//	public ResponseEntity<List<UsuarioDTO>> findAll(){
//		List<Usuario> list = this.usuarioService.findAll();
//		List<UsuarioDTO> listDTO = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDTO);
//	}
//	
//	@PostMapping
//	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario obj){
//		obj = usuarioService.create(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
////		return ResponseEntity.created(uri).body(obj);
//		return ResponseEntity.created(uri).build();
//	}
//	
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody Usuario obj){
//		Usuario newObj = this.usuarioService.update(id, obj);
//		return ResponseEntity.ok().body(new UsuarioDTO(newObj));
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Integer id){
//		this.usuarioService.delete(id);
//		return ResponseEntity.noContent().build();
//	}

}
