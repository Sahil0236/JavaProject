package com.test.demo.service;

import com.test.demo.dtos.AddressDTO;

public interface AddressService {
    AddressDTO getAddressByID(Integer id);
}
