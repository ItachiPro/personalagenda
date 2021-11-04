package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address_type")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_address_type", updatable = false, nullable = false)
    private long idAddressType;

    @Getter @Setter @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idAddressType")
    private List<Address> address;
}
