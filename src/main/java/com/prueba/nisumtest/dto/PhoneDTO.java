package com.prueba.nisumtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PhoneDTO {

    @JsonIgnoreProperties
    private Integer id;
    private String number;
    private String citycode;
    private String contrycode;

}
