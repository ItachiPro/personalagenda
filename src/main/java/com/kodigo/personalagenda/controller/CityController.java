package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.City;
import com.kodigo.personalagenda.model.Department;
import com.kodigo.personalagenda.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public List<City> getCities(){
        return cityRepository.findAll();
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public ResponseEntity<City> getCityById(@PathVariable long id){
        try{
            Optional<City> city = cityRepository.findById(id);
            return ResponseEntity.of(city);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public ResponseEntity<City> saveCity(@RequestBody City city){
        try{
            City response = cityRepository.save(city);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public ResponseEntity<City> updateCity(@RequestBody City city){
        try{
            return cityRepository.findById(city.getIdCity())
                    .map(c -> {
                        c.setName(city.getName());
                        c.setIdDepartment(city.getIdDepartment());
                        City response = cityRepository.save(c);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        city.setIdDepartment(city.getIdDepartment());
                        City response = cityRepository.save(city);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/city/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCity(@PathVariable long id){
        try{
            cityRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
