package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor @NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_user", updatable = false, nullable = false)
    private Long idUser;

    @Getter @Setter @Column(name = "username")
    private String username;

    @Getter @Setter @Column(name = "pwd")
    private String password;

    @OneToMany(mappedBy = "idAppointment")
    private List<Appointment> appointments;

    /*@OneToMany(mappedBy = "idContact")
    private List<Contact> contacts;*/
}
