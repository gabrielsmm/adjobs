package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.empregos.entities.Concurso;

public interface ConcursoRepository extends JpaRepository<Concurso, Long> {
	
}
