package com.test.demo.controller;

import com.test.demo.dtos.DepartmentDTO;
import com.test.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/department")

public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentByID(@PathVariable("id") Integer id){
        DepartmentDTO emp = departmentService.getDepartmentByID(id);
        return ResponseEntity.ok(emp);

    }

}