package com.test.demo.service;

import com.test.demo.dtos.CountryDTO;

import java.util.List;

public interface CountryService {
    CountryDTO getCountryByID(Integer id);
    List<CountryDTO> getAllCountries(); // Ensure this method is declared
}
