package com.test.demo.dtos;

import com.test.demo.model.Country;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDTO {
    private Integer id;
    private String name;
}
