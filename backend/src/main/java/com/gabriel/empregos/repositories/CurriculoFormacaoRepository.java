package com.gabriel.empregos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.CurriculoFormacao;

public interface CurriculoFormacaoRepository extends JpaRepository<CurriculoFormacao, Long> {
	
    @Modifying
    @Transactional
	@Query(value = "DELETE FROM TB_FORMACOES AS obj WHERE obj.curriculo_id = :idCurriculo", nativeQuery = true)
	void deleteAllByCurriculo(@Param(value = "idCurriculo") Long idCurriculo);
	
}
