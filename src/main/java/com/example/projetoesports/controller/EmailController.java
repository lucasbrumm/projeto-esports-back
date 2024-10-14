package com.example.projetoesports.controller;

import com.example.projetoesports.domain.email.dto.EmailPrimeiroAcessoDTO;
import com.example.projetoesports.service.EmailService;
import com.example.projetoesports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("http://localhost:3000/")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send-email-first-acess")
    public void sentEmail(@RequestBody EmailPrimeiroAcessoDTO email) {
        emailService.sendEmailPrimeiroAcesso(email);
    }

    @PostMapping("/send-email-recovery-password/{email}")
    public void sendEmailRecuperacaoSenha(@PathVariable String email) {
        emailService.sendEmailRecuperacaoSenha(email);
    }
}
