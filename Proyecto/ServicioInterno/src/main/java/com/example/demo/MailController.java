package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailController {
	
	@Autowired
    private JavaMailSender mailSender;
	
	//@Value("${password}")
	//private String password;
	
	@CrossOrigin
	@RequestMapping(value = "/sendMail", method = RequestMethod.GET) 
	public ResponseEntity<Boolean> sendMail(@RequestParam String correo, @RequestParam String nombre) {
		
		System.out.println("CORREO: " + correo + "NOMBRE: " + nombre);
		
		SimpleMailMessage message = new SimpleMailMessage();

		String body = "test";
		String subject  = "subj";
		
        message.setFrom("capytournament@gmail.com");
        message.setTo(correo);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
        System.out.println("Mail Send...");
		
		
		
		
		
		/*try {

			//Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

			// Get a Properties object
			Properties props = System.getProperties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.smtps.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.smtp.socketFactory.port", "587");
			props.setProperty("mail.smtps.auth", "true");
			
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.starttls.required", "true");
			props.put("mail.smtps.quitwait", "false");
			
			props.put("mail.smtp.starttls.required", "true");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");

			Session session = Session.getInstance(props, null);

			final MimeMessage msg = new MimeMessage(session);

			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress("capytournament@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));

			msg.setSubject("Bienvenido a HardParadise");
			msg.setText(
					"Hola " + nombre
							+ "\n\nTe damos la bienvenida a Hard paradise. Ya puedes comenzar a disfrutar de este paraíso para amantes del hardware y montajes customizados.\n\nUn cordial saludo del equipo de desarrollo.\n\nJulio Cabesetti, Jefe de departamento de redes sociales Hard-Paradise.",
					"utf-8");
			msg.setSentDate(new Date());

			SMTPTransport t = (SMTPTransport) session.getTransport("smtps");

			String password = "capyt1234";
			
			t.connect("smtp.gmail.com", "capytournament@gmail.com", password);
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();

		} catch (MessagingException ex) {
			System.out.println(ex);
}		*/
		return null;
}
}