package com.gabriel.empregos.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.repositories.VagaRepository;

@Service
public class DBService {
	
	@Autowired
	private VagaRepository vagaRepository;
	
	public void instanciaBaseDeDados() {
		
		Vaga vaga1 = new Vaga(null, "Auxiliar", "Temporario", 5, 2000d, "Goiânia", new Date());
		Vaga vaga2 = new Vaga(null, "Estagiario", "Temporario", 2, 1200d, "Goiânia", new Date());
		Vaga vaga3 = new Vaga(null, "Ajudante", "Temporario", 5, 1600d, "Goiânia", new Date());
		Vaga vaga4 = new Vaga(null, "Estagiario", "Temporario", 5, 2000d, "Ap. de Goiânia", new Date());
		Vaga vaga5 = new Vaga(null, "Auxiliar", "Temporario", 5, 1900d, "Goiânia", new Date());
		
		this.vagaRepository.saveAll(Arrays.asList(vaga1, vaga2, vaga3, vaga4, vaga5));
		
	}
}
