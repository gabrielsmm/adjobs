package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.empregos.entities.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
