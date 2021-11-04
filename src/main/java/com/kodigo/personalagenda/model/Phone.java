package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phone")
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
    @ManyToOne
    @JoinColumn(name = "id_contact")
    private Contact idContact;
}
