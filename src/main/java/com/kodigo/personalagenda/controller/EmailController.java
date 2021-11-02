package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.Email;
import com.kodigo.personalagenda.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailRepository emailRepository;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public List<Email> getEmails(){
        return emailRepository.findAll();
    }

    @RequestMapping(value = "/email/{id}", method = RequestMethod.GET)
    public ResponseEntity<Email> getEmailById(@PathVariable long id){
        try{
            Optional<Email> email = emailRepository.findById(id);
            return ResponseEntity.of(email);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity<Email> saveEmail(@RequestBody Email email){
        try{
            Email response = emailRepository.save(email);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/email", method = RequestMethod.PUT)
    public ResponseEntity<Email> updateEmail(@RequestBody Email email){
        try{
            return emailRepository.findById(email.getIdMail())
                    .map(m -> {
                        m.setEmailAddress(email.getEmailAddress());
                        m.setIdContact(email.getIdContact());
                        Email response = emailRepository.save(m);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        email.setIdMail(email.getIdMail());
                        Email response = emailRepository.save(email);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/email/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmail(@PathVariable long id){
        try{
            emailRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
