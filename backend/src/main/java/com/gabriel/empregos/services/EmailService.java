package com.gabriel.empregos.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.entities.Usuario;
import com.gabriel.empregos.enums.TipoUsuario;
import com.gabriel.empregos.repositories.CandidatoRepository;
import com.gabriel.empregos.repositories.EmpresaRepository;
import com.gabriel.empregos.repositories.UsuarioRepository;
import com.gabriel.empregos.services.exceptions.EmailSenderException;
import com.gabriel.empregos.util.Util;

@Service
public class EmailService {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired 
	private CandidatoRepository candidatoRepository;
	
	public boolean sendMail(String email) {
		Usuario usuario = this.usuarioRepository.findByEmail(email);
		String senhaAleatoria = Util.gerarSenhaAleatoria(10);
		try {
            MimeMessage mail = mailSender.createMimeMessage();
            
            StringBuilder mailText = new StringBuilder()
            		.append("<p>Houve uma solicitação para recuperar seus dados de acesso!</p>")
            		.append("<hr>")
            		.append("<p>Login: " + usuario.getEmail() + "</p>")
            		.append("<p>Nova senha: " + senhaAleatoria + "</p>")
            		.append("<hr>");

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom("AdJobs");
            helper.setTo(email);
            helper.setSubject( "AdJobs - Dados de acesso" );
            helper.setText(mailText.toString(), true);
            mailSender.send(mail);
            
            if (usuario.getTipoUsuario() == TipoUsuario.EMPRESA) {
    			Empresa empresa = this.empresaRepository.getById(usuario.getId());
    			empresa.setSenha(Util.criptografar(senhaAleatoria));
    			this.empresaRepository.save(empresa);
    		} else if (usuario.getTipoUsuario() == TipoUsuario.CANDIDATO) {
    			Candidato candidato = this.candidatoRepository.getById(usuario.getId());
    			candidato.setSenha(Util.criptografar(senhaAleatoria));
    			this.candidatoRepository.save(candidato);
    		}
            
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            throw new EmailSenderException("Não foi possível enviar os dados, tente novamente mais tarde.");
        }
	}
	
}
