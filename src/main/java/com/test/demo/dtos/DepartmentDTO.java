package com.test.demo.dtos;

import com.test.demo.model.Department;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDTO {
    private Integer id;
    private String dept;
}
