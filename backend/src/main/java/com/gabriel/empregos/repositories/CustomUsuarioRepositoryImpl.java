package com.gabriel.empregos.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gabriel.empregos.entities.Usuario;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Component
public class CustomUsuarioRepositoryImpl implements CustomUsuarioRepository {
	
	private JdbcTemplate jdbcTemplate;

	protected CustomUsuarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Usuario findByEmail(String email) {
		try {
			return jdbcTemplate.queryForObject("SELECT id, email, senha, data_Cadastro, tipo_Usuario FROM TB_USUARIOS WHERE EMAIL = ?", BeanPropertyRowMapper.newInstance(Usuario.class), email);
		} catch(EmptyResultDataAccessException e) {
	        throw new ObjectNotFoundException("Email informado não existe");
	    }
	}
	
}
