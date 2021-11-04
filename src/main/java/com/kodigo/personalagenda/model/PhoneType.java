package com.kodigo.personalagenda.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone_type")
@ToString
@AllArgsConstructor @NoArgsConstructor
public class PhoneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_phone_type", updatable = false, nullable = false)
    private long idPhoneType;

    @Getter @Setter @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idPhoneType")
    private List<Phone> phone;
}
