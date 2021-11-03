package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.Contact;
import com.kodigo.personalagenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContactById(@PathVariable long id){
        try{
            Optional<Contact> contact = contactRepository.findById(id);
            return ResponseEntity.of(contact);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        try{
           Contact response = contactRepository.save(contact);
           return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact){
        try{
            return contactRepository.findById(contact.getIdContact())
                    .map(c -> {
                        c.setFirstname(contact.getFirstname());
                        c.setLastname(contact.getLastname());
                        c.setAddress(contact.getAddress());
                        c.setBirthday(contact.getBirthday());
                        c.setIdContactType(contact.getIdContactType());
                        Contact response = contactRepository.save(c);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        contact.setIdContact(contact.getIdContact());
                        Contact response = contactRepository.save(contact);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteContact(@PathVariable long id){
        try{
            contactRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
