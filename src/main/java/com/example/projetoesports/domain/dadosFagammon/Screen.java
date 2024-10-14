package com.example.projetoesports.domain.dadosFagammon;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(schema = "dados_fagammon", name = "screen")
@Entity(name = "Screen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "screen_name")
    private String screenName;

    @Column(name = "text")
    private String text;

    @Column(name = "route")
    private String route;

    @Column(name = "icon")
    private String icon;

    @Column(name = "description")
    private String description;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "order_visible")
    private Integer orderVisible;

    @ManyToMany
    @JoinTable(
            name = "rel_screen_user_role",
            schema = "dados_fagammon",
            joinColumns = @JoinColumn(name = "id_screen"),
            inverseJoinColumns = @JoinColumn(name = "id_user_role")
    )
    @JsonBackReference
    private Set<UserRole> userRoles;
}
