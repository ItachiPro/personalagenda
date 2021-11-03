package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "department")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_department", updatable = false, nullable = false)
    private long idDepartment;

    @Getter @Setter @Column(name = "name")
    private String name;
}
