package com.kodigo.personalagenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.userdetails.User;

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

    @JsonIgnore
    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private Users idUser;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "idContact")
    private Contact idContact;
}
