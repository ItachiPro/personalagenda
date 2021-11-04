package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "email")
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
    @ManyToOne
    @JoinColumn(name = "id_contact")
    private Contact idContact;
}
