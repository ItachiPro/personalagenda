package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

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

    @Getter @Setter @Column(name = "id_department")
    private long idDepartment;
}
