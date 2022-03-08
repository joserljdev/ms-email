package br.com.joserlj.dev.email.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDTO {

	@NotBlank
	@Email
	private String emailDestinatario;
	@NotBlank
	private String assunto;
	@NotBlank
	private String mensagem;

}