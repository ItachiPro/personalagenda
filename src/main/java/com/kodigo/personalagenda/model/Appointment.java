package com.kodigo.personalagenda.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
@AllArgsConstructor @NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_appointment", updatable = false, nullable = false)
    private long idAppointment;

    @Getter @Setter @Column(name = "appointment_date")
    private Date appointmentDate;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "description")
    private String description;

    @Getter @Setter
    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private Users idUser;

}
