package com.test.demo.controller;

import com.test.demo.dtos.AddressDTO;
import com.test.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")

public class AddressController {

    @Autowired
    private AddressService addressService;



    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> getAddressByID(@PathVariable("id") Integer id){
        AddressDTO emp = addressService.getAddressByID(id);
        return ResponseEntity.ok(emp);

    }

}