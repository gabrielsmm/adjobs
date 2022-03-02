package com.gabriel.empregos.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gabriel.empregos.entities.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
	
	@Query(value = "SELECT * FROM TB_VAGAS AS obj WHERE obj.TIPOCONTRATACAO_ID = 3",
			nativeQuery = true)
	List<Vaga> getSomenteVagasEstagio();
	
	Page<Vaga> findAllByNomeIgnoreCaseContaining(String nome, Pageable pageable);
	
	@Query(value = "SELECT COUNT(*) FROM TB_VAGAS", nativeQuery = true)
	long buscaNumeroVagas();
	
}
