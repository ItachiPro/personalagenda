package com.kodigo.personalagenda.controller;

import com.kodigo.personalagenda.model.AddressType;
import com.kodigo.personalagenda.model.Department;
import com.kodigo.personalagenda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public ResponseEntity<Department> getDepartmentById(@PathVariable long id){
        try{
            Optional<Department> department = departmentRepository.findById(id);
            return ResponseEntity.of(department);
        }catch(Exception e){
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        try{
            Department response = departmentRepository.save(department);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        try{
            return departmentRepository.findById(department.getIdDepartment())
                    .map(d -> {
                        d.setName(department.getName());
                        Department response = departmentRepository.save(d);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    })
                    .orElseGet(() -> {
                        department.setIdDepartment(department.getIdDepartment());
                        Department response = departmentRepository.save(department);
                        return new ResponseEntity<>(response, HttpStatus.OK);
                    });
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDepartment(@PathVariable long id){
        try{
            departmentRepository.deleteById(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
