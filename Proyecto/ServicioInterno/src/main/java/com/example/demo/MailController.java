package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MailController {
	
	@Autowired
    private JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendMailRegister", method = RequestMethod.POST) 
	public void sendMailRegister(@RequestParam String email, @RequestParam String name) {		
		SimpleMailMessage message = new SimpleMailMessage();

		String body = "Hola, " + name + ". Desde CapyTournament estamos encantados de que te hayas unido a nuestra web ¡Mucha suerte en tus partidas!";
		String subject  = "¡BIENVENID@ A CAPY TOURNAMENT!";
		
        message.setFrom("capytournament@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Sent...");
}
	
	@RequestMapping(value = "/sendMailVictory", method = RequestMethod.POST) 
	public void sendMailVictory(@RequestParam String email, @RequestParam String playerName, @RequestParam String teamName, @RequestParam String championName) {		
		SimpleMailMessage message = new SimpleMailMessage();

		String body = "Hola, " + playerName + ". ¡Enhorabuena por tu victoria jugando para " + teamName + "! Nadie juega " + championName + " como tú! ;)";
		String subject  = "¡Victoria!";
		
        message.setFrom("capytournament@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Sent...");
}
}