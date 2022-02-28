package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.empregos.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
