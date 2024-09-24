package com.test.demo.controller;

import com.test.demo.dtos.CountryDTO;
import com.test.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/country")

public class CountryController {

    @Autowired
    private CountryService countryService;



    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> getCountryByID(@PathVariable("id") Integer id){
        CountryDTO emp = countryService.getCountryByID(id);
        return ResponseEntity.ok(emp);

    }


}