package com.test.demo.service;

import com.test.demo.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getEmployeeByID(Integer id);
    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeesByCountryAndDept(String countryName, String deptName); // Add this line
}
