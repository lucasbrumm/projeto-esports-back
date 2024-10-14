package com.example.projetoesports.domain.email;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.mail.SimpleMailMessage;
import com.example.projetoesports.utils.StringUtils;

@Entity(name = "Email")
@Table(schema = "email", name = "email_history")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Email {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    private String subject;
    private String body;

    public Email(SimpleMailMessage simpleMailMessage) {
        this.sender = simpleMailMessage.getFrom();
        this.receiver = StringUtils.removeColchete(simpleMailMessage.getTo());
        this.subject = simpleMailMessage.getSubject();
        this.body = simpleMailMessage.getText();
    }
}
