package br.com.joserlj.dev.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joserlj.dev.email.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}