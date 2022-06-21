package com.gabriel.empregos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gabriel.empregos.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>, CustomUsuarioRepository {
	
	@Query(value = "SELECT * FROM TB_USUARIOS AS obj WHERE obj.email = :email and obj.senha = :senha", nativeQuery = true)
	Optional<Usuario> findByEmailSenha(@Param(value = "email") String email, @Param(value = "senha") String senha);
	
	@Query(value = "SELECT * FROM TB_USUARIOS AS obj WHERE obj.email = :email", nativeQuery = true)
	Optional<Usuario> findByEmailCustom(@Param(value = "email") String email);
	
}
