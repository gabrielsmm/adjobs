package com.gabriel.empregos.repositories;

import com.gabriel.empregos.entities.Usuario;

public interface CustomUsuarioRepository {

	Usuario findByEmail(String email);
	
}
