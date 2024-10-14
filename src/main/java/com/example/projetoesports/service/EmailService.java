package com.example.projetoesports.service;

import com.example.projetoesports.domain.email.dto.EmailPrimeiroAcessoDTO;

public interface EmailService {
    void sendEmailPrimeiroAcesso(EmailPrimeiroAcessoDTO email);

    void sendEmailRecuperacaoSenha(String email);
}
