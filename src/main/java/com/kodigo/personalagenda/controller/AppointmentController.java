package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.Appointment;
import com.kodigo.personalagenda.model.Contact;
import com.kodigo.personalagenda.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    @RequestMapping(value = "/appointment/{id}", method = RequestMethod.GET)
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable long id){
        try{
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            return ResponseEntity.of(appointment);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment){
        try{
            Appointment response = appointmentRepository.save(appointment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.PUT)
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment){
        try{
            return appointmentRepository.findById(appointment.getIdAppointment())
                    .map(a -> {
                        a.setAppointmentDate(appointment.getAppointmentDate());
                        a.setTitle(appointment.getTitle());
                        a.setDescription(appointment.getDescription());
                        a.setIdUser(appointment.getIdUser());
                        //a.setIdContact(appointment.getIdContact());
                        Appointment response = appointmentRepository.save(a);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        appointment.setIdAppointment(appointment.getIdAppointment());
                        Appointment response = appointmentRepository.save(appointment);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/appointment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAppointment(@PathVariable long id){
        try{
            appointmentRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
