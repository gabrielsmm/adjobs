package com.gabriel.empregos.resources;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailResource {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@GetMapping(value = "/send")
	public ResponseEntity<String> sendMail() {
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            
            StringBuilder mailText = new StringBuilder()
            		.append("<h3>Olá [nome],</h3>")
            		.append("<p>Houve uma solicitação para recuperar sua senha!</p>")
            		.append("<p>Se você não fez essa solicitação, ignore este e-mail.</p>")
            		.append("<p>Caso contrário, aqui está sua senha: [senha]</p>");

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom("remetente");
            helper.setTo("destinatario");
            helper.setSubject( "Recuperação de senha" );
            helper.setText(mailText.toString(), true);
            mailSender.send(mail);
            
            return new ResponseEntity<String>("OK", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Erro ao enviar e-mail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
