package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.PhoneType;
import com.kodigo.personalagenda.model.User;
import com.kodigo.personalagenda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable long id){
        try{
            Optional<User> user = userRepository.findById(id);
            return ResponseEntity.of(user);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user){
        try{
            User response = userRepository.save(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try{
            return userRepository.findById(user.getIdUSer())
                    .map(u -> {
                        u.setUsername(user.getUsername());
                        u.setPassword(user.getPassword());
                        User response = userRepository.save(u);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        user.setIdUSer(user.getIdUSer());
                        User response = userRepository.save(user);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable long id){
        try{
            userRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
