package com.example.projetoesports.domain.dadosFagammon;

import com.example.projetoesports.domain.email.dto.EmailPrimeiroAcessoDTO;
import com.example.projetoesports.domain.dadosFagammon.dto.RegisterDTO;
import com.example.projetoesports.utils.StringUtils;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Entity(name = "User")
@Table(schema = "dados_fagammon", name = "user")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_user_role", referencedColumnName = "id")
    private UserRole userRole;

    private boolean enabled;

    private boolean firstAccess;

    public User(RegisterDTO registerDTO) {
        this.cpf = registerDTO.cpf();
        this.password = StringUtils.getPasswordEncrypted(registerDTO.password());
        this.email = registerDTO.email();
        this.enabled = true;
        this.firstAccess = true;
        this.userRole = new UserRole();
        this.userRole.setId(registerDTO.role().longValue());
    }

    public User(EmailPrimeiroAcessoDTO emailPrimeiroAcessoDTO, String password){
        this.cpf = emailPrimeiroAcessoDTO.cpfReceiver();
        this.password = StringUtils.getPasswordEncrypted(password);
        this.email = emailPrimeiroAcessoDTO.emailReceiver();
        this.enabled = true;
        this.firstAccess = true;
        this.userRole = new UserRole();
        this.userRole.setId(3L);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return switch (this.userRole.getId().byteValue()) {
            case 1 -> List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_PLAYER"),
                    new SimpleGrantedAuthority("ROLE_COACH")
            );
            case 2 -> List.of(new SimpleGrantedAuthority("ROLE_COACH"));
            case 3 -> List.of(new SimpleGrantedAuthority("ROLE_PLAYER"));
            default -> throw new IllegalStateException("Unexpected value: " + this.userRole.getId());
        };
    }

    @Override
    public String getUsername() {
        return this.cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
