package com.kodigo.personalagenda.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_contact", updatable = false, nullable = false)
    private long idContact;

    @Getter @Setter @Column(name = "firstname")
    private String firstname;

    @Getter @Setter @Column(name = "lastname")
    private String lastname;

    @Getter @Setter @Column(name = "address")
    private String address;

    @Getter @Setter @Column(name = "birthday")
    private Date birthday;

    @Getter @Setter @Column(name = "id_user")
    private long idUser;

    @Getter @Setter @Column(name = "id_contact_type")
    private long idContactType;
}
