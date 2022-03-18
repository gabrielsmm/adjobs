package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.empregos.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
