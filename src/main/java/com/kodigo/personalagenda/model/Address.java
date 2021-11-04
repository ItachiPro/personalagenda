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

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_address_type")
    private AddressType idAddressType;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_city")
    private City idCity;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "idContact")
    private Contact idContact;
}
