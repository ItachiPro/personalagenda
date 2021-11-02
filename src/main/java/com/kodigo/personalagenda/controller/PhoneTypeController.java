package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.PhoneType;
import com.kodigo.personalagenda.repository.PhoneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PhoneTypeController {

    @Autowired
    PhoneTypeRepository phoneTypeRepository;

    @RequestMapping(value = "/phoneType", method = RequestMethod.GET)
    public List<PhoneType> getPhoneTypes(){
        return phoneTypeRepository.findAll();
    }

    @RequestMapping(value = "/phoneType/{id}", method = RequestMethod.GET)
    public ResponseEntity<PhoneType> getPhoneTypeById(@PathVariable long id){
        try{
            Optional<PhoneType> contact = phoneTypeRepository.findById(id);
            return ResponseEntity.of(contact);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/phoneType", method = RequestMethod.POST)
    public ResponseEntity<PhoneType> savePhoneType(@RequestBody PhoneType phoneType){
        try{
            PhoneType response = phoneTypeRepository.save(phoneType);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/phoneType", method = RequestMethod.PUT)
    public ResponseEntity<PhoneType> updatePhoneType(@RequestBody PhoneType phoneType){
        try{
            return phoneTypeRepository.findById(phoneType.getIdPhoneType())
                    .map(pt -> {
                        pt.setName(phoneType.getName());
                        PhoneType response = phoneTypeRepository.save(pt);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        phoneType.setIdPhoneType(phoneType.getIdPhoneType());
                        PhoneType response = phoneTypeRepository.save(phoneType);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/phoneType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePhoneType(@PathVariable long id){
        try{
            phoneTypeRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
