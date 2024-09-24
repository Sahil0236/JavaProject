package com.test.demo.service;

import com.test.demo.dtos.AddressDTO;
import com.test.demo.model.Address;
import com.test.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDTO getAddressByID(Integer id) {
        Optional<Address> byId = addressRepository.findById(id);
        if (byId.isPresent()) {
            return convertAddressModelToDTO(byId.get());
        }
        return AddressDTO.builder()
                .street("Default Street")
                .country("Default Country")
                .city("Default City")
                .pin(00000)
                .build();
    }

    private AddressDTO convertAddressModelToDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .country(address.getCountry())
                .city(address.getCity())
                .pin(address.getPin())
                .build();
    }
}
