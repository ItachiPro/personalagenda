package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString
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
}
