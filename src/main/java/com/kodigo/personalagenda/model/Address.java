package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_address", updatable = false, nullable = false)
    private long idAddress;

    @Getter @Setter @Column(name = "address_direction")
    private String addressDirection;

    @Getter @Setter @Column(name = "id_address_type")
    private String idAddressType;

    @Getter @Setter @Column(name = "id_city")
    private String idCity;

    @Getter @Setter @Column(name = "id_contact")
    private long idContact;
}
