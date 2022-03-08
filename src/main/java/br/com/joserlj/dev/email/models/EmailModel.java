package br.com.joserlj.dev.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.joserlj.dev.email.enums.StatusEmail;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emailId;
	private String emailDestinatario;
	private String assunto;
	@Column(columnDefinition = "TEXT")
	private String mensagem;
	private LocalDateTime dataEnvioEmail;
	private StatusEmail statusEmail;

}
