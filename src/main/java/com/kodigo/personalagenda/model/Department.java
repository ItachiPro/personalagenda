package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_department", updatable = false, nullable = false)
    private long idDepartment;

    @Getter @Setter @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "idDepartment")
    private List<City> city;
}
