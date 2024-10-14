package com.example.projetoesports.service.impl;

import com.example.projetoesports.domain.email.Email;
import com.example.projetoesports.domain.email.dto.EmailPrimeiroAcessoDTO;
import com.example.projetoesports.domain.dadosFagammon.User;
import com.example.projetoesports.repository.EmailRepository;
import com.example.projetoesports.repository.UserInformationRepository;
import com.example.projetoesports.repository.UserRepository;
import com.example.projetoesports.service.EmailService;
import com.example.projetoesports.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    UserRepository usuarioRepository;

    @Autowired
    UserInformationRepository informacoesUsuarioRepository;

    @Override
    public void sendEmailPrimeiroAcesso(EmailPrimeiroAcessoDTO email) {
        var existsEmail = usuarioRepository.findByEmail(email.emailReceiver());
        var existsCpf = usuarioRepository.findByCpf(email.cpfReceiver());

        StringUtils.valitationUserCpf(existsEmail, ((User) existsCpf), email.emailReceiver(), email.cpfReceiver());

        sendEmailAndSaveData(email.cpfReceiver(), email.emailReceiver(),true, "Solicitação de primeiro acesso");
    }

    @Override
    public void sendEmailRecuperacaoSenha(String email) {
        var existsUser = usuarioRepository.findByEmail(email);
        StringUtils.validateEmail(email);

        if (existsUser == null) {
            throw new RuntimeException("Usuário não cadastrado");
        }

        sendEmailAndSaveData(existsUser.getCpf(), email, false, "Recuperação de senha");
    }

    private void sendEmailAndSaveData(String cpf, String email, boolean primeiroAcesso, String messageTitle) {

        EmailPrimeiroAcessoDTO emailPrimeiroAcessoDTO = new EmailPrimeiroAcessoDTO(email, cpf);
        StringBuilder randomPassword = StringUtils.getRandomPassword();

        var message = getSimpleMailMessage(emailPrimeiroAcessoDTO, randomPassword.toString(), messageTitle);
        javaMailSender.send(message);

        var newEmail = new Email(message);
        emailRepository.save(newEmail);

        if(primeiroAcesso){
            User newUser = entityToUsuario(emailPrimeiroAcessoDTO, randomPassword.toString());
            usuarioRepository.save(newUser);
        } else {
            User user = usuarioRepository.findByEmail(email);
            user.setPassword(getPasswordEncrypted(randomPassword.toString()));
            usuarioRepository.save(user);
        }

    }

    private SimpleMailMessage getSimpleMailMessage(EmailPrimeiroAcessoDTO email, String passwordSend,
                                                   String subjectMessage) {
        var message = new SimpleMailMessage();

        message.setFrom("noreply@email.com");
        message.setTo(email.emailReceiver());
        message.setSubject(subjectMessage);
        message.setText("Seus dados para o login são: " + "\n" +
                        "CPF: " + email.cpfReceiver() + "\n" +
                        "Senha: " + passwordSend + "\n" +
                        "Acesse o sistema e altere sua senha.");
        return message;
    }


    private User entityToUsuario(EmailPrimeiroAcessoDTO email, String password) {
        return new User(email, password);
    }

    private String getPasswordEncrypted(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
