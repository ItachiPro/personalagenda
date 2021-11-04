package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.AddressType;
import com.kodigo.personalagenda.repository.AddressTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressTypeController {

    @Autowired
    AddressTypeRepository addressTypeRepository;

    @RequestMapping(value = "/addressTypes", method = RequestMethod.GET)
    public List<AddressType> getAddressTypes(){
        return addressTypeRepository.findAll();
    }

    @RequestMapping(value = "/addressType/{id}", method = RequestMethod.GET)
    public ResponseEntity<AddressType> getAddressTypeById(@PathVariable long id){
        try{
            Optional<AddressType> addressType = addressTypeRepository.findById(id);
            return ResponseEntity.of(addressType);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addressType", method = RequestMethod.POST)
    public ResponseEntity<AddressType> saveAddressType(@RequestBody AddressType addressType){
        try{
            AddressType response = addressTypeRepository.save(addressType);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addressType", method = RequestMethod.PUT)
    public ResponseEntity<AddressType> updateAddressType(@RequestBody AddressType addressType){
        try{
            return addressTypeRepository.findById(addressType.getIdAddressType())
                    .map(at -> {
                        at.setName(addressType.getName());
                        AddressType response = addressTypeRepository.save(at);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        addressType.setIdAddressType(addressType.getIdAddressType());
                        AddressType response = addressTypeRepository.save(addressType);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/addressType/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddressType(@PathVariable long id){
        try{
            addressTypeRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
