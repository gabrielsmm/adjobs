package com.gabriel.empregos.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.empregos.entities.TipoContratacao;
import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.repositories.TipoContratacaoRepository;
import com.gabriel.empregos.repositories.VagaRepository;

@Service
public class DBService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired 
	private TipoContratacaoRepository tpContratacaoRepository;
	
	public void instanciaBaseDeDados() {
		
		TipoContratacao tp1 = new TipoContratacao(null, "Temporário");
		TipoContratacao tp2 = new TipoContratacao(null, "Parcial");
		TipoContratacao tp3 = new TipoContratacao(null, "Estágio");
		TipoContratacao tp4 = new TipoContratacao(null, "Jovem Aprendiz");
		TipoContratacao tp5 = new TipoContratacao(null, "Terceirizado");
		TipoContratacao tp6 = new TipoContratacao(null, "Home office");
		TipoContratacao tp7 = new TipoContratacao(null, "Intermitente");
		
		this.tpContratacaoRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6, tp7));
		
		Vaga vaga1 = new Vaga(null, "Auxiliar", tp1, 5, 2000d, "Goiânia", new Date());
		Vaga vaga2 = new Vaga(null, "Estagiario", tp3, 2, 1200d, "Goiânia", new Date());
		Vaga vaga3 = new Vaga(null, "Ajudante", tp2, 5, 1600d, "Goiânia", new Date());
		Vaga vaga4 = new Vaga(null, "Estagiario", tp3, 5, 2000d, "Ap. de Goiânia", new Date());
		Vaga vaga5 = new Vaga(null, "Auxiliar", tp5, 5, 1900d, "Goiânia", new Date());
		
		this.vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3, vaga4, vaga5));
		
	}
}
