package com.example.projetoesports.domain.dadosFagammon.dto;

import java.util.Date;
import java.util.stream.Stream;

public record UserInfromationDTO(Long idUsuario, String nickname, String nomeUsuario, String telefone,
                                 Date dataNasc, String sexo, String cep, String rua, Integer numeroCasa,
                                 String bairro, String cidade, String estado, PlayerDTO player){

    public UserInfromationDTO(Long idUsuario) {
        this(idUsuario, null, null, null, null, null, null,
                null, null, null, null, null, null);
    }

    public boolean hasEmptyFields() {
        return Stream.of(nomeUsuario, nickname, telefone, sexo, cep, rua, bairro, cidade, estado)
                .anyMatch(string -> string == null || string.trim().isEmpty());
    }
}
