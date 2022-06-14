package com.prueba.nisumtest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    @JsonIgnoreProperties
    private Integer id;
    private String name;
    private String email;
    private String password;
    private List<PhoneDTO> phones;
    @JsonIgnoreProperties
    private Date created;
    @JsonIgnoreProperties
    private Date modified;
    @JsonIgnoreProperties
    private Date last_login;
    @JsonIgnoreProperties
    private String token;
    @JsonIgnoreProperties
    private boolean isactive;

}
