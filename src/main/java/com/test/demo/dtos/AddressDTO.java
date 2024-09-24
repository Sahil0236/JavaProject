package com.test.demo.dtos;

import com.test.demo.model.Department;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private Integer id;
    private String street;
    private String country;
    private String city;
    private Integer pin;
}
