package com.test.demo.service;

import com.test.demo.dtos.CountryDTO;
import com.test.demo.model.Country;
import com.test.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryDTO getCountryByID(Integer id) {
        Optional<Country> countryOpt = countryRepository.findById(id);
        if (countryOpt.isPresent()) {
            return convertCountryModelToDTO(countryOpt.get());
        }
        return CountryDTO.builder()
                .name("Default Country")
                .build();
    }

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries.stream()
                .map(this::convertCountryModelToDTO)
                .collect(Collectors.toList());
    }

    private CountryDTO convertCountryModelToDTO(Country country) {
        return CountryDTO.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}
