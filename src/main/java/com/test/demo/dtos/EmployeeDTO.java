package com.test.demo.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeDTO {
    private Integer id;
    private String name;
    private Double salary;
    private Integer age;
    private DepartmentDTO dept;
    private CountryDTO country;
    private AddressDTO address;
}
