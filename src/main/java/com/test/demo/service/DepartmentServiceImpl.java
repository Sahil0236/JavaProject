package com.test.demo.service;

import com.test.demo.dtos.DepartmentDTO;
import com.test.demo.model.Department;
import com.test.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO getDepartmentByID(Integer id) {
        Optional<Department> byId = departmentRepository.findById(id);
        if (byId.isPresent()) {
            return convertDepartmentModelToDTO(byId.get());
        }
        return DepartmentDTO.builder()
                .id(1)
                .dept("Unknown Department")
                .build();
    }

    private DepartmentDTO convertDepartmentModelToDTO(Department department) {
        return DepartmentDTO.builder()
                .id(department.getDepId())
                .dept(department.getName())
                .build();
    }
}
