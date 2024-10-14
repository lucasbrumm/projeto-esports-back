package com.example.projetoesports.domain.dadosFagammon;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "rel_screen_user_role")
public class RelScreenUserRole {
    @Column(name = "id_user_role")
    private Integer userRoleId;
    @Column(name = "id_screen")
    private Long screenId;
}
