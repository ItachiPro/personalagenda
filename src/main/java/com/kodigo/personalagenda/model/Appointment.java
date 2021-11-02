package com.kodigo.personalagenda.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointment")
@ToString
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

    @Getter @Setter @Column(name = "id_user")
    private long idUser;

    @Getter @Setter @Column(name = "id_contact")
    private long idContact;
}
