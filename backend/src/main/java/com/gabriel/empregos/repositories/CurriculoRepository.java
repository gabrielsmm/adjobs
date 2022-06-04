package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabriel.empregos.entities.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
	
	@Query(value = "SELECT * FROM TB_CURRICULOS AS obj WHERE obj.candidato_id = :idCandidato", nativeQuery = true)
	Curriculo findByCandidato(@Param(value = "idCandidato") Integer idCandidato);
	
	@Query(value = "SELECT MAX(ID) FROM TB_CURRICULOS", nativeQuery = true)
	Long getMaxId();
	
}
