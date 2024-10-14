package com.example.projetoesports.utils;

import com.example.projetoesports.domain.dadosFagammon.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

public class StringUtils {

    // Função que remove os colchetes de uma lista de String
    // ex: recebe "[email@email.com]" retorna email@email.com
    public static String removeColchete(String[] strings) {
        String[] recipients = strings;
        StringBuilder recipientBuilder = new StringBuilder();
        for (String recipient : recipients) {
            recipientBuilder.append(recipient).append(",");
        }

        if (recipientBuilder.length() > 0) {
            recipientBuilder.deleteCharAt(recipientBuilder.length() - 1);
        }
        return recipientBuilder.toString();
    }

    // Função que valida se o email e cpf são válidos
    public static void valitationUserCpf(User userByEmail, User userByCpf, String email, String cpf) {
        if (userByEmail != null || userByCpf != null) {
            throw new RuntimeException("Usuário já cadastrado");
        }
        validateCpfEmail(cpf, email);
    }

    // Função que valida se o cpf e email são válidos
    public static void validateCpfEmail (String cpf, String email) {
        if (cpf.length() != 11) {
            throw new RuntimeException("CPF inválido");
        }
        validateEmail(email);
    }

    // Função que valida se o email é válido
    public static void validateEmail (String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new RuntimeException("Email inválido");
        }
    }

    // Função que gera uma senha aleatória
    public static StringBuilder getRandomPassword() {
        Random random = new Random();
        StringBuilder randomPassword = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomPassword.append(randomChar);
        }
        return randomPassword;
    }

    // Função que criptografa a senha
    public static String getPasswordEncrypted(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
