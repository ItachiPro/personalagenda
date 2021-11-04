package com.kodigo.personalagenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone")
@ToString
@AllArgsConstructor @NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_phone", updatable = false, nullable = false)
    private long idPhone;

    @Getter @Setter @Column(name = "number_phone")
    private String numberPhone;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_phone_type")
    private PhoneType idPhoneType;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_contact")
    private Contact idContact;
}
