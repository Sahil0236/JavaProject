package com.test.demo.controller;

import com.test.demo.dtos.EmployeeDTO;
import com.test.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@PathVariable("id") Integer id) {
        EmployeeDTO emp = employeeService.getEmployeeByID(id);
        return ResponseEntity.ok(emp);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByCountryAndDept(
            @RequestParam String countryName,
            @RequestParam(required = false) String deptName) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByCountryAndDept(countryName, deptName);
        return ResponseEntity.ok(employees);
    }

}
