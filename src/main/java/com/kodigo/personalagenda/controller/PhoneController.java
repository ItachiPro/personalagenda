package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.Phone;
import com.kodigo.personalagenda.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PhoneController {

    @Autowired
    PhoneRepository phoneRepository;

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public List<Phone> getPhones(){
        return phoneRepository.findAll();
    }

    @RequestMapping(value = "/phone/{id}", method = RequestMethod.GET)
    public ResponseEntity<Phone> getPhoneById(@PathVariable long id){
        try{
            Optional<Phone> phone = phoneRepository.findById(id);
            return ResponseEntity.of(phone);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public ResponseEntity<Phone> savePhone(@RequestBody Phone phone){
        try{
            Phone response = phoneRepository.save(phone);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/phone", method = RequestMethod.PUT)
    public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone){
        try{
            return phoneRepository.findById(phone.getIdPhone())
                    .map(p -> {
                        p.setNumberPhone(phone.getNumberPhone());
                        p.setIdPhoneType(phone.getIdPhoneType());
                        p.setIdContact(phone.getIdContact());
                        Phone response = phoneRepository.save(p);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        phone.setIdPhone(phone.getIdPhone());
                        Phone response = phoneRepository.save(phone);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/phone/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePhone(@PathVariable long id){
        try{
            phoneRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
