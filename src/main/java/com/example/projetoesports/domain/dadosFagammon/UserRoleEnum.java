package com.example.projetoesports.domain.dadosFagammon;

public enum UserRoleEnum {
    ADMIN("admin"),
    PLAYER("player"),
    COACH("coach");

    private String role;

    UserRoleEnum(String role) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }
}
