package com.kodigo.personalagenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long idEmail;

    @Getter @Setter
    @Column(name = "email_address")
    private String emailAddress;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_contact", nullable = false)
    private Contact idContact;
}
