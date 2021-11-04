package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contact_type")
@ToString
@AllArgsConstructor @NoArgsConstructor
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_contact_type", updatable = false, nullable = false)
    private long idContactType;

    @Getter @Setter @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "idContactType")
    private Contact contact;
}
