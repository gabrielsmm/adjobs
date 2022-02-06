package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.empregos.entities.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
