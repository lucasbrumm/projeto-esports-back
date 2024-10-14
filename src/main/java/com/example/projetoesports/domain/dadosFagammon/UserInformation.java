package com.example.projetoesports.domain.dadosFagammon;

import com.example.projetoesports.domain.dadosFagammon.dto.UserInfromationDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "InformacoesUsuario")
@Table(schema = "dados_fagammon", name = "user_information")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")

public class UserInformation {
    @Id
    private Long idUsuario;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private User usuario;

    private String nomeUsuario;

    private String nickname;

    private String telefoneUsuario;

    private Date dataNascimento;

    private String sexo;

    private String cep;

    private String rua;

    private String bairro;

    private Integer numeroCasa;

    private String cidade;

    private String estado;

    public UserInformation(UserInfromationDTO informacoesUsuarioDTO) {
        this.idUsuario = informacoesUsuarioDTO.idUsuario();
        this.nomeUsuario = informacoesUsuarioDTO.nomeUsuario();
        this.nickname = informacoesUsuarioDTO.nickname();
        this.telefoneUsuario = informacoesUsuarioDTO.telefone();
        this.dataNascimento = informacoesUsuarioDTO.dataNasc();
        this.sexo = informacoesUsuarioDTO.sexo();
        this.cep = informacoesUsuarioDTO.cep();
        this.rua = informacoesUsuarioDTO.rua();
        this.bairro = informacoesUsuarioDTO.bairro();
        this.numeroCasa = informacoesUsuarioDTO.numeroCasa();
        this.cidade = informacoesUsuarioDTO.cidade();
        this.estado = informacoesUsuarioDTO.estado();
    }

    public UserInformation (Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}