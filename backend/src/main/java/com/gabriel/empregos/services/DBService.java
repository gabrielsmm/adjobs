package com.gabriel.empregos.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Candidatura;
import com.gabriel.empregos.entities.Concurso;
import com.gabriel.empregos.entities.Curriculo;
import com.gabriel.empregos.entities.CurriculoExperiencia;
import com.gabriel.empregos.entities.CurriculoFormacao;
import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.enums.CandidaturaStatus;
import com.gabriel.empregos.enums.EstadoCivil;
import com.gabriel.empregos.enums.FormacaoNivel;
import com.gabriel.empregos.enums.FormacaoStatus;
import com.gabriel.empregos.enums.Sexo;
import com.gabriel.empregos.enums.TipoContratacao;
import com.gabriel.empregos.enums.TipoUsuario;
import com.gabriel.empregos.enums.VagaStatus;
import com.gabriel.empregos.repositories.CandidatoRepository;
import com.gabriel.empregos.repositories.CandidaturaRepository;
import com.gabriel.empregos.repositories.ConcursoRepository;
import com.gabriel.empregos.repositories.CurriculoExperienciaRepository;
import com.gabriel.empregos.repositories.CurriculoFormacaoRepository;
import com.gabriel.empregos.repositories.CurriculoRepository;
import com.gabriel.empregos.repositories.EmpresaRepository;
import com.gabriel.empregos.repositories.VagaRepository;
import com.gabriel.empregos.util.Util;

@Service
public class DBService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
//	@Autowired 
//	private TipoContratacaoRepository tpContratacaoRepository;
	
	@Autowired
	private ConcursoRepository concursoRepository;	
	
	@Autowired 
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
//	@Autowired
//	private CargoRepository cargoRepository;
	
	@Autowired
	private CandidaturaRepository candidaturaRepository;
	
	@Autowired
	private CurriculoRepository curriculoRepository;
	
	@Autowired
	private CurriculoFormacaoRepository curriculoFormacaoRepository;
	
	@Autowired
	private CurriculoExperienciaRepository curriculoExperienciaRepository;
	
	public void instanciaBaseDeDados() {
		
		Empresa e1 = new Empresa(null, "Gsmmimports", "12345678987", 10, "74885230", "GO", "Goiânia", "Jardim Ipê", "Rua 2", "S/N", "Ao lado da rua 1", "Gabriel Mendes", "6239548540", "62996418943", "", "", "gsmm@gmail.com", Util.criptografar("123"), new Date(), TipoUsuario.EMPRESA);
		Empresa e2 = new Empresa(null, "Naza", "94321895431", 20, "74885230", "GO", "Goiânia", "Jardim Ipê", "Rua 2", "S/N", "Ao lado da rua 1", "Nazaré Mendes", "6239548540", "62996418943", "", "", "naza@gmail.com", Util.criptografar("321"), new Date(), TipoUsuario.EMPRESA);
		Empresa e3 = new Empresa(null, "Amor a vida", "123131233", 200, "74885230", "GO", "Goiânia", "Jardim Ipê", "Rua 2", "S/N", "Ao lado da rua 1", "Amarildo", "6239548540", "62996418943", "", "", "amoravida@gmail.com", Util.criptografar("amor123"), new Date(), TipoUsuario.EMPRESA);
		
//		Cargo ca1 = new Cargo(null, "Auxiliar");
//		Cargo ca2 = new Cargo(null, "Gerente");
//		Cargo ca3 = new Cargo(null, "Engenheiro");
//		Cargo ca4 = new Cargo(null, "Eletricista");
//		Cargo ca5 = new Cargo(null, "Encanador");
//		
//		this.cargoRepository.saveAll(Arrays.asList(ca1, ca2, ca3, ca4, ca5));
		
		Candidato c1 = new Candidato(null, "Gabriel", "74885230", "gabriel@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c2 = new Candidato(null, "Jorge", "74885239", "jorge@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c3 = new Candidato(null, "Lucas", "74885240", "lucas@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c4 = new Candidato(null, "teste1", "74885240", "teste1@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c5 = new Candidato(null, "teste2", "74885240", "teste2@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c6 = new Candidato(null, "teste3", "74885240", "teste3@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c7 = new Candidato(null, "teste4", "74885240", "teste4@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c8 = new Candidato(null, "teste5", "74885240", "teste5@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		Candidato c9 = new Candidato(null, "teste6", "74885240", "teste6@estudante.com.br", Util.criptografar("blablabla"), new Date(), TipoUsuario.CANDIDATO);
		
		this.candidatoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9));
		
		this.empresaRepository.saveAll(Arrays.asList(e1, e2, e3));
		
//		TipoContratacao tp1 = new TipoContratacao(null, "Temporário");
//		TipoContratacao tp2 = new TipoContratacao(null, "Parcial");
//		TipoContratacao tp3 = new TipoContratacao(null, "Estágio");
//		TipoContratacao tp4 = new TipoContratacao(null, "Jovem Aprendiz");
//		TipoContratacao tp5 = new TipoContratacao(null, "Terceirizado");
//		TipoContratacao tp6 = new TipoContratacao(null, "Home office");
//		TipoContratacao tp7 = new TipoContratacao(null, "Intermitente");
		
//		this.tpContratacaoRepository.saveAll(Arrays.asList(tp1, tp2, tp3, tp4, tp5, tp6, tp7));
		
		Vaga vaga1 = new Vaga(null, "Auxiliar", TipoContratacao.TEMPORARIO, 5, 2000d, "Goiânia", new Date(), null, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eleifend, ex non efficitur dictum, sem tellus dictum dui, feugiat venenatis diam nunc nec lectus. Nunc ac justo leo. Curabitur faucibus lorem ac tortor semper, eget eleifend velit egestas. Nulla facilisi. Mauris congue nisl ac sem imperdiet, nec sollicitudin eros rhoncus. Aliquam eleifend gravida semper. Nullam nisi tortor, venenatis vitae leo eget, facilisis consequat ligula. Nam augue tellus, sodales sit amet augue in, volutpat rhoncus massa. ", "VT, VA, Combinar", "Precisa saber escrever", VagaStatus.ATIVA, e1);
		Vaga vaga2 = new Vaga(null, "Estagiario", TipoContratacao.HOME_OFFICE, 2, 1200d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e2);
		Vaga vaga3 = new Vaga(null, "Ajudante", TipoContratacao.ESTAGIO, 5, 1600d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e3);
		Vaga vaga4 = new Vaga(null, "Estagiario", TipoContratacao.HOME_OFFICE, 5, 2000d, "Ap. de Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e1);
		Vaga vaga5 = new Vaga(null, "Auxiliar", TipoContratacao.JOVEM_APRENDIZ, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e2);
		Vaga vaga6 = new Vaga(null, "Ajudante", TipoContratacao.HOME_OFFICE, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e3);
		Vaga vaga7 = new Vaga(null, "Analista", TipoContratacao.JOVEM_APRENDIZ, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e1);
		Vaga vaga8 = new Vaga(null, "Gerente", TipoContratacao.HOME_OFFICE, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e2);
		Vaga vaga9 = new Vaga(null, "Estudante", TipoContratacao.JOVEM_APRENDIZ, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e3);
		Vaga vaga10 = new Vaga(null, "Brabeza", TipoContratacao.HOME_OFFICE, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e1);
		Vaga vaga11 = new Vaga(null, "Programador", TipoContratacao.ESTAGIO, 5, 3000d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e1);
		Vaga vaga12 = new Vaga(null, "Empacotador", TipoContratacao.HOME_OFFICE, 5, 1900d, "Goiânia", new Date(), null, "", "", "", VagaStatus.ATIVA, e1);
		
		this.vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3, vaga4, vaga5, vaga6, vaga7, vaga8, vaga9, vaga10, vaga11, vaga12));
		
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
		
		Candidatura can1 = new Candidatura(null, c1, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		Candidatura can2 = new Candidatura(null, c2, vaga2, new Date(), CandidaturaStatus.REVISADO);
		Candidatura can3 = new Candidatura(null, c1, vaga2, new Date(), CandidaturaStatus.PRESELECIONADO);
		Candidatura can4 = new Candidatura(null, c4, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		Candidatura can5 = new Candidatura(null, c5, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		Candidatura can6 = new Candidatura(null, c6, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		Candidatura can7 = new Candidatura(null, c7, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		Candidatura can8 = new Candidatura(null, c8, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		Candidatura can9 = new Candidatura(null, c9, vaga1, new Date(), CandidaturaStatus.RECEBIDO);
		
		this.candidaturaRepository.saveAll(Arrays.asList(can1, can2, can3, can4, can5, can6, can7, can8, can9));
		
		Curriculo crr1 = new Curriculo(null, c1, "Gabriel", "Sou estudante bla bla bla", "6232223333", "62996777777", new Date(), EstadoCivil.SOLTEIRO, Sexo.MASCULINO, "74444444", "GO", "Goiânia", "Jardim Seila", "Rua das maringueiras", "0", "Quadra 230 Lote 98", false, "https://www.linkedin.com.br", "", "https://www.instagram.com.br", "gmportfolios.com");
		Curriculo crr2 = new Curriculo(null, c2, "Jorge", "Sou estudante dois bla bla bla", "6232223333", "62996777777", new Date(), EstadoCivil.CASADO, Sexo.MASCULINO, "74444444", "GO", "Goiânia", "Jardim Porai", "Rua das maringueiras", "0", "Quadra 231 Lote 99", false, "https://www.linkedin.com.br", "", "https://www.instagram.com.br", "jorgeportfolios.com");
		
		CurriculoFormacao cf1 = new CurriculoFormacao(null, "UNIP", FormacaoNivel.SUPERIOR, FormacaoStatus.CURSANDO, "Ciencias da Computação", 1, 2019, 12, 2022, crr1);
		
		CurriculoExperiencia cx1 = new CurriculoExperiencia(null, "TESTE", "Estagiário", 1500d, 1, 2019, 12, 2022, true, "Lugar mt bom", crr1);
		
		crr1.getFormacoes().addAll(Arrays.asList(cf1));
		crr1.getExperiencias().addAll(Arrays.asList(cx1));
		
		this.curriculoRepository.saveAll(Arrays.asList(crr1, crr2));
		
		this.curriculoFormacaoRepository.saveAll(Arrays.asList(cf1));
		
		this.curriculoExperienciaRepository.saveAll(Arrays.asList(cx1));
	}
}
