package com.test.demo.service;

import com.test.demo.dtos.AddressDTO;
import com.test.demo.dtos.CountryDTO;
import com.test.demo.dtos.DepartmentDTO;
import com.test.demo.dtos.EmployeeDTO;
import com.test.demo.model.Employee;
import com.test.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO getEmployeeByID(Integer id) {
        Optional<Employee> byId = employeeRepository.findById(id);
        if (byId.isPresent()) {
            return convertEmployeeModelToDTO(byId.get());
        }
        return EmployeeDTO.builder()
                .name("John")
                .age(25)
                .salary(50000.0)
                .build(); // Default values if employee not found
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll(); // Fetch all employees
        return employees.stream()
                .map(this::convertEmployeeModelToDTO) // Convert to DTOs
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByCountryAndDept(String countryName, String deptName) {
        List<Employee> employees = employeeRepository.findByCountryNameAndOptionalDeptName(countryName, deptName);
        return employees.stream()
                .map(this::convertEmployeeModelToDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertEmployeeModelToDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary())
                .age(employee.getAge())
                .dept(employee.getDept() != null ?
                        DepartmentDTO.builder()
                                .id(employee.getDept().getDepId())
                                .dept(employee.getDept().getName())
                                .build() : null) // Set department if available
                .country(employee.getCountry() != null ?
                        CountryDTO.builder()
                                .id(employee.getCountry().getId())
                                .name(employee.getCountry().getName())
                                .build() : null) // Set country if available
                .address(employee.getAddress() != null ?
                        AddressDTO.builder()
                                .id(employee.getAddress().getId())
                                .street(employee.getAddress().getStreet())
                                .city(employee.getAddress().getCity())
                                .country(employee.getAddress().getCountry())
                                .pin(employee.getAddress().getPin())
                                .build() : null)
                .build();
    }
}
