package com.gabriel.empregos.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.empregos.entities.Concurso;
import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.entities.TipoContratacao;
import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.repositories.ConcursoRepository;
import com.gabriel.empregos.repositories.EmpresaRepository;
import com.gabriel.empregos.repositories.TipoContratacaoRepository;
import com.gabriel.empregos.repositories.VagaRepository;
import com.gabriel.empregos.util.Util;

@Service
public class DBService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired 
	private TipoContratacaoRepository tpContratacaoRepository;
	
	@Autowired
	private ConcursoRepository concursoRepository;
	
	@Autowired EmpresaRepository empresaRepository;
	
	public void instanciaBaseDeDados() {
		
		Empresa e1 = new Empresa(null, "Gsmmimports", "12345678987", 10, "74885230", "Gabriel Mendes", "6239548540", "62996418943", Util.criptografar("123"));
		Empresa e2 = new Empresa(null, "Naza", "94321895431", 20, "74885230", "Nazaré Mendes", "6239548540", "62996418943", Util.criptografar("321"));
		Empresa e3 = new Empresa(null, "Amor a vida", "123131233", 200, "74885230", "Amarildo", "6239548540", "62996418943", Util.criptografar("amor123"));
		
		this.empresaRepository.saveAll(Arrays.asList(e1, e2, e3));
		
		TipoContratacao tp1 = new TipoContratacao(null, "Temporário");
		TipoContratacao tp2 = new TipoContratacao(null, "Parcial");
		TipoContratacao tp3 = new TipoContratacao(null, "Estágio");
		TipoContratacao tp4 = new TipoContratacao(null, "Jovem Aprendiz");
		TipoContratacao tp5 = new TipoContratacao(null, "Terceirizado");
		TipoContratacao tp6 = new TipoContratacao(null, "Home office");
		TipoContratacao tp7 = new TipoContratacao(null, "Intermitente");
		
		this.tpContratacaoRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6, tp7));
		
		Vaga vaga1 = new Vaga(null, "Auxiliar", tp1, 5, 2000d, "Goiânia", new Date(), e1);
		Vaga vaga2 = new Vaga(null, "Estagiario", tp3, 2, 1200d, "Goiânia", new Date(), e2);
		Vaga vaga3 = new Vaga(null, "Ajudante", tp2, 5, 1600d, "Goiânia", new Date(), e3);
		Vaga vaga4 = new Vaga(null, "Estagiario", tp3, 5, 2000d, "Ap. de Goiânia", new Date(), e1);
		Vaga vaga5 = new Vaga(null, "Auxiliar", tp5, 5, 1900d, "Goiânia", new Date(), e2);
		Vaga vaga6 = new Vaga(null, "Ajudante", tp5, 5, 1900d, "Goiânia", new Date(), e3);
		Vaga vaga7 = new Vaga(null, "Analista", tp5, 5, 1900d, "Goiânia", new Date(), e1);
		Vaga vaga8 = new Vaga(null, "Gerente", tp5, 5, 1900d, "Goiânia", new Date(), e2);
		Vaga vaga9 = new Vaga(null, "Estudante", tp5, 5, 1900d, "Goiânia", new Date(), e3);
		Vaga vaga10 = new Vaga(null, "Brabeza", tp5, 5, 1900d, "Goiânia", new Date(), e1);
		
		this.vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3, vaga4, vaga5, vaga6, vaga7, vaga8, vaga9, vaga10));
		
		Concurso con1 = new Concurso(null, "Câmara de Jaboatão dos Guararapes (PE)", new Date(), 33, 3150d, "médio e superior", "Jaboatão dos Guararapes", "Pernambuco", e1);
		Concurso con2 = new Concurso(null, "Prefeitura de Cumaru do Norte (PA)", new Date(), 24, 1550d, "médio", "Cumaru do Norte", "Paraná", e2);
		Concurso con3 = new Concurso(null, "Prefeitura de Santa Fé (PR)", new Date(), 32, 6647.97d, "fundamental, médio e superior", "Santa Fé", "Paraná", e3);
		Concurso con4 = new Concurso(null, "Prefeitura de Bento de Abreu (SP)", new Date(), 30, 6800d, "superior", "Recife", "Pernambuco", e1);
		Concurso con5 = new Concurso(null, "Instituto Sagaz (RN)", new Date(), 129, 4000d, "fundamental, médio e superior", "Rio Grande do Norte", "Rio Grande do Norte", e2);
		Concurso con6 = new Concurso(null, "Prefeitura de Santa Fé (PR)", new Date(), 32, 6647.97d, "fundamental, médio e superior", "Santa Fé", "Paraná", e3);
		Concurso con7 = new Concurso(null, "Prefeitura de Santa Fé (PR)", new Date(), 32, 6647.97d, "fundamental, médio e superior", "Santa Fé", "Paraná", e1);
		Concurso con8 = new Concurso(null, "Prefeitura de Santa Fé (PR)", new Date(), 32, 6647.97d, "fundamental, médio e superior", "Santa Fé", "Paraná", e2);
		Concurso con9 = new Concurso(null, "Prefeitura de Santa Fé (PR)", new Date(), 32, 6647.97d, "fundamental, médio e superior", "Santa Fé", "Paraná", e3);
		Concurso con10 = new Concurso(null, "Prefeitura de Santa Fé (PR)", new Date(), 32, 6647.97d, "fundamental, médio e superior", "Santa Fé", "Paraná", e1);
		
		this.concursoRepository.saveAll(Arrays.asList(con1, con2, con3, con4, con5, con6, con7, con8, con9, con10));
	}
}
