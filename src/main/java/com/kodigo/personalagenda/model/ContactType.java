package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact_type")
@AllArgsConstructor @NoArgsConstructor
public class ContactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_contact_type", updatable = false, nullable = false)
    private long idContactType;

    @Getter @Setter @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idContactType")
    private List<Contact> contact;
}
