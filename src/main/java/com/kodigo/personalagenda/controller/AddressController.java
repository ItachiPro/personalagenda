package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.Address;
import com.kodigo.personalagenda.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddressById(@PathVariable long id){
        try{
            Optional<Address> address = addressRepository.findById(id);
            return ResponseEntity.of(address);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        try{
            Address response = addressRepository.save(address);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@RequestBody Address address){
        try{
            return addressRepository.findById(address.getIdAddress())
                    .map(a -> {
                        a.setAddressDirection(address.getAddressDirection());
                        a.setIdAddressType(address.getIdAddressType());
                        a.setIdCity(address.getIdCity());
                        a.setIdContact(address.getIdContact());
                        Address response = addressRepository.save(a);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        address.setIdAddress(address.getIdAddress());
                        Address response = addressRepository.save(address);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddress(@PathVariable long id){
        try{
            addressRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
