package com.gabriel.empregos.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.interfaces.ContadorAuxiliar;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
	//0 ATIVA 1 CANCELADA
	
	@Query(value = "SELECT * FROM TB_VAGAS AS obj WHERE obj.TIPOCONTRATACAO_ID = 3",
			nativeQuery = true)
	List<Vaga> getSomenteVagasEstagio();
	
	@Query(value = "SELECT * FROM TB_VAGAS AS obj WHERE obj.status <> 1 ORDER BY obj.data_cadastro DESC",
			countQuery = "SELECT * FROM TB_VAGAS AS obj WHERE obj.status <> 1",
			nativeQuery = true)
	Page<Vaga> findAll(Pageable pageable);
	
	@Query(value = "SELECT * FROM TB_VAGAS AS obj WHERE obj.empresa_id = :idEmpresa AND obj.status <> 1 ORDER BY obj.data_cadastro DESC", 
			countQuery = "SELECT COUNT(*) FROM TB_VAGAS AS obj WHERE obj.empresa_id = :idEmpresa AND obj.status <> 1",
			nativeQuery = true)
	Page<Vaga> findAllByEmpresa(@Param(value = "idEmpresa") Integer idEmpresa, Pageable pageable);
	
	@Query(value = "SELECT * FROM TB_VAGAS AS obj WHERE UPPER(obj.nome) LIKE '%' || UPPER(:nome) || '%' AND obj.status <> 1 ORDER BY obj.data_cadastro DESC",
			countQuery = "SELECT COUNT(*) FROM TB_VAGAS AS obj WHERE UPPER(obj.nome) LIKE '%' || UPPER(:nome) || '%' AND obj.status <> 1",
			nativeQuery = true)
	Page<Vaga> findAllByNome(@Param(value = "nome") String nome, Pageable pageable);
	
	@Query(value = "SELECT * FROM TB_VAGAS obj WHERE obj.tipo = :tipo ORDER BY obj.data_cadastro DESC",
		    countQuery = "SELECT count(*) FROM TB_VAGAS obj WHERE obj.tipo = :tipo",
		    nativeQuery = true)
	Page<Vaga> findAllByTipo(@Param(value = "tipo") Integer tipo, Pageable pageable);
	
	@Query(value = "SELECT * FROM TB_VAGAS AS obj WHERE (UPPER(obj.nome) LIKE '%' || UPPER(:palavraChave) || '%' AND UPPER(obj.localizacao) LIKE '%' || UPPER(:localizacao) || '%') AND obj.status <> 1 ORDER BY obj.data_cadastro DESC",
			countQuery = "SELECT COUNT(*) FROM TB_VAGAS AS obj WHERE (UPPER(obj.nome) LIKE '%' || UPPER(:palavraChave) || '%' AND UPPER(obj.localizacao) LIKE '%' || UPPER(:localizacao) || '%') AND obj.status <> 1",
			nativeQuery = true)
	Page<Vaga> findAllByPalavraLocalizacao(@Param(value = "palavraChave") String palavraChave, @Param(value = "localizacao") String localizacao, Pageable pageable);
	
	@Query(value = "SELECT COUNT(*) FROM TB_VAGAS AS obj WHERE obj.status <> 1", nativeQuery = true)
	long buscaNumeroVagas();
	
	@Query(value = "SELECT COUNT(*) FROM TB_VAGAS AS obj WHERE obj.empresa_id = :idEmpresa", nativeQuery = true)
	long buscaNumeroVagasCadastradasPorEmpresa(@Param(value = "idEmpresa") Integer idEmpresa);	
	
	@Query(value = "SELECT "
			+ "(SELECT COUNT(*) FROM TB_VAGAS AS obj WHERE obj.empresa_id = :idEmpresa) AS QTDPOSTADAS, "
			+ "(SELECT COUNT(*) FROM TB_CANDIDATURAS AS obj JOIN TB_VAGAS as v WHERE v.id = obj.vaga_id AND v.empresa_id = :idEmpresa) AS QTDCANDIDATOS", nativeQuery = true)
	ContadorAuxiliar getContador(@Param(value = "idEmpresa") Integer idEmpresa);
	
}
