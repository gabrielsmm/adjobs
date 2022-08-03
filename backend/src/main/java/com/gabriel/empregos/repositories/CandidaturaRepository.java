package com.gabriel.empregos.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabriel.empregos.entities.Candidatura;
import com.gabriel.empregos.interfaces.ContadorAuxiliar;

public interface CandidaturaRepository extends JpaRepository<Candidatura, Long> {
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato AND obj.status <> 4",
			countQuery = "SELECT COUNT(*) FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato AND obj.status <> 4",
			nativeQuery = true)
	Page<Candidatura> findAllByCandidato(@Param(value = "idCandidato") Integer idCandidato, Pageable pageable);
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.vaga_id = :idVaga AND obj.status <> 4", nativeQuery = true)
	List<Candidatura> findAllByVaga(@Param(value = "idVaga") Integer idVaga);
	
	@Query(value = "SELECT COUNT(*) FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato AND obj.status <> 4", nativeQuery = true)
	long buscaNumeroCandidaturas(@Param(value = "idCandidato") Integer idCandidato);
	
	@Query(value = "SELECT * FROM TB_CANDIDATURAS AS obj WHERE obj.candidato_id = :idCandidato AND obj.vaga_id = :idVaga", nativeQuery = true)
	Candidatura verificaExistenciaCandidatura(@Param(value = "idCandidato") Integer idCandidato, @Param(value = "idVaga") Integer idVaga);
	
	@Query(value = "SELECT "
			+ "(SELECT COUNT(*)  FROM TB_CANDIDATURAS AS obj  WHERE obj.candidato_id = :idCandidato AND obj.status = 0) AS QTDENVIADOS, "
			+ "(SELECT COUNT(*)  FROM TB_CANDIDATURAS AS obj  WHERE obj.candidato_id = :idCandidato AND obj.status between 1 AND 2) AS QTDEMPROCESSO, "
			+ "(SELECT COUNT(*)  FROM TB_CANDIDATURAS AS obj  WHERE obj.candidato_id = :idCandidato AND obj.status = 3) AS QTDFINALISTA, "
			+ "(SELECT"
			+ "     CAST(((CASE WHEN (CEP IS NOT NULL AND CEP <> '') THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN (COMPLEMENTO IS NOT NULL AND COMPLEMENTO <> '') THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN DATA_NASCIMENTO IS NOT NULL THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN ESTADO_CIVIL IS NOT NULL THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN (RESUMO IS NOT NULL AND RESUMO <> '') THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN SEXO IS NOT NULL THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN (TELEFONE IS NOT NULL AND TELEFONE <> '') THEN 1 ELSE 0 END)"
			+ "      + (CASE WHEN (TELEFONE_CELULAR IS NOT NULL AND TELEFONE_CELULAR <> '') THEN 1 ELSE 0 END)) AS DECIMAL(5,2)) / 8 * 100 "
			+ "FROM TB_CURRICULOS obj WHERE obj.candidato_id = :idCandidato) AS PORCENTAGEM", nativeQuery = true)
	ContadorAuxiliar getContador(@Param(value = "idCandidato") Integer idCandidato);
	
//	@Query(value = "INSERT INTO TB_CANDIDATURAS (DATA_CANDIDATURA, STATUS, CANDIDATO_ID, VAGA_ID) VALUES (:dataCandidatura, :status, :idCandidato, :idVaga)", nativeQuery = true)
//	void salvarCandidatura(@Param(value = "dataCandidatura") Date dataCandidatura, @Param(value = "status") CandidaturaStatus status, @Param(value = "idCandidato") Integer idCandidato, @Param(value = "idVaga") Integer idVaga);
	
}
