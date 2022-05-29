package com.gabriel.empregos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabriel.empregos.entities.Candidatura;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato", nativeQuery = true)
	List<Candidatura> findAllByCandidato(@Param(value = "idCandidato") Integer idCandidato);
	
	@Query(value = "SELECT COUNT(*) FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato", nativeQuery = true)
	long buscaNumeroVagas(@Param(value = "idCandidato") Integer idCandidato);
	
}
