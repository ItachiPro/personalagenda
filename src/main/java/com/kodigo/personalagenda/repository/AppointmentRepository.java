package com.kodigo.personalagenda.repository;

import com.kodigo.personalagenda.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
