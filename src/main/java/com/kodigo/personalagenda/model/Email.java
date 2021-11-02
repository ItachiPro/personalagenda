package com.kodigo.personalagenda.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "email")
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_email", updatable = false, nullable = false)
    private long idMail;

    @Getter @Setter @Column(name = "email_address")
    private String emailAddress;

    @Getter @Setter @Column(name = "id_contact")
    private long idContact;
}
