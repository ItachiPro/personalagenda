package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@ToString
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_user", updatable = false, nullable = false)
    private Long idUSer;

    @Getter @Setter @Column(name = "username")
    private String username;

    @Getter @Setter @Column(name = "password")
    private String password;
}
