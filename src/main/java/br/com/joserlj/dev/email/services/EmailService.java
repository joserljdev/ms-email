package br.com.joserlj.dev.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.joserlj.dev.email.enums.StatusEmail;
import br.com.joserlj.dev.email.models.EmailModel;
import br.com.joserlj.dev.email.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	EmailRepository emailRepository;

	@Autowired
	JavaMailSender emailSender;

	@SuppressWarnings("finally")
	public EmailModel enviarEmail(EmailModel emailModel) {
		emailModel.setDataEnvioEmail(LocalDateTime.now());
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("EMAIL DO REMENTE AQUI!");
			message.setTo(emailModel.getEmailDestinatario());
			message.setSubject(emailModel.getAssunto());
			message.setText(emailModel.getMensagem());
			
			emailSender.send(message);

			emailModel.setStatusEmail(StatusEmail.ENVIADO);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERRO);
		} finally {
			return emailRepository.save(emailModel);
		}
	}
}