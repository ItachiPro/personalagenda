package com.kodigo.personalagenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_city", updatable = false, nullable = false)
    private long idCity;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_department")
    private Department idDepartment;

    @OneToMany(mappedBy = "idAddress")
    private List<Address> address;
}
