package com.example.projetoesports.domain.dadosFagammon;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "UserRole")
@Table(schema = "dados_fagammon", name = "user_role")
@Getter
@Setter
public class UserRole {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "userRoles")
    @JsonManagedReference
    private Set<Screen> screens;
}
