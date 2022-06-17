package com.gabriel.empregos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabriel.empregos.entities.Candidatura;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato", nativeQuery = true)
	List<Candidatura> findAllByCandidato(@Param(value = "idCandidato") Integer idCandidato);
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.vaga_id = :idVaga", nativeQuery = true)
	List<Candidatura> findAllByVaga(@Param(value = "idVaga") Integer idVaga);
	
	@Query(value = "SELECT COUNT(*) FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato", nativeQuery = true)
	long buscaNumeroCandidaturas(@Param(value = "idCandidato") Integer idCandidato);
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato AND obj.vaga_id = :idVaga", nativeQuery = true)
	Candidatura verificaExisteCandidatura(@Param(value = "idCandidato") Integer idCandidato, @Param(value = "idVaga") Integer idVaga);
	
//	@Query(value = "INSERT INTO TB_CANDIDATURAS (DATA_CANDIDATURA, STATUS, CANDIDATO_ID, VAGA_ID) VALUES (:dataCandidatura, :status, :idCandidato, :idVaga)", nativeQuery = true)
//	void salvarCandidatura(@Param(value = "dataCandidatura") Date dataCandidatura, @Param(value = "status") CandidaturaStatus status, @Param(value = "idCandidato") Integer idCandidato, @Param(value = "idVaga") Integer idVaga);
	
}
