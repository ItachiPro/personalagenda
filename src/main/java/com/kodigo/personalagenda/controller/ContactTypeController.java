package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.ContactType;
import com.kodigo.personalagenda.repository.ContactTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactTypeController {

    @Autowired
    ContactTypeRepository contactTypeRepository;

    @RequestMapping(value = "/contactType", method = RequestMethod.GET)
    public List<ContactType> getContactTypes(){
        return contactTypeRepository.findAll();
    }

    @RequestMapping(value = "/contactType/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContactType> getContactTypeById(@PathVariable long id){
        try{
            Optional<ContactType> contactType = contactTypeRepository.findById(id);
            return ResponseEntity.of(contactType);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/contactType", method = RequestMethod.POST)
    public ResponseEntity<ContactType> saveContactType(@RequestBody ContactType contactType){
        try{
            ContactType response = contactTypeRepository.save(contactType);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/contactType", method = RequestMethod.PUT)
    public ResponseEntity<ContactType> updateContactType(@RequestBody ContactType contactType){
        try{
            return contactTypeRepository.findById(contactType.getIdContactType())
                    .map(ct -> {
                        ct.setName(contactType.getName());
                        ContactType response = contactTypeRepository.save(ct);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        contactType.setIdContactType(contactType.getIdContactType());
                        ContactType response = contactTypeRepository.save(contactType);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/contactType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteContactType(@PathVariable long id){
        try{
            contactTypeRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
