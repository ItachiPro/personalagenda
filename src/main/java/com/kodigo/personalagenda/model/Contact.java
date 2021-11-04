package com.kodigo.personalagenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contact")
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

    @Getter @Setter @Column(name = "birthday")
    private Date birthday;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users idUser;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "idContactType")
    private ContactType idContactType;

    @OneToMany(mappedBy = "idEmail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails;

    @OneToMany(mappedBy = "idPhone", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    @OneToMany(mappedBy = "idAddress", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

}
