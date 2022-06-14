package com.prueba.nisumtest.controller;

import com.prueba.nisumtest.dto.UserDTO;
import com.prueba.nisumtest.payload.MessageResponse;
import com.prueba.nisumtest.service.UserService;
import com.prueba.nisumtest.util.JWTTokenUtil;
import com.prueba.nisumtest.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTokenUtil jwtTokenUtil;
    @Autowired
    private MessageResponse messageResponse;
    @Autowired
    private UserUtils userUtils;

    @PostMapping(value = "/user")
    public ResponseEntity<Object> postUser(@RequestBody UserDTO userDTO){
        messageResponse.setMessage("Usuario no registrado");

        if(!userUtils.validEmail(userDTO.getEmail())){
            messageResponse.setMessage("Correo Invalido");
            return ResponseEntity.ok().body(messageResponse);
        }
        if(!userUtils.validPass(userDTO.getPassword())){
            messageResponse.setMessage("Password invalida");
            return ResponseEntity.ok().body(messageResponse);
        }

        userDTO.setToken(jwtTokenUtil.getJWTToken(userDTO.getName()));
        UserDTO user = userService.create(userDTO);
        if(user != null){
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .buildAndExpand()
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(user);
        }
        return ResponseEntity.ok().body(messageResponse);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<Object> getUsers(){
        messageResponse.setMessage("Sin registros");
        List<UserDTO> userDTOS = getAllUser();
        if(userDTOS.size() != 0){

            return ResponseEntity.status(200)
                    .body(userDTOS);
        }
        return ResponseEntity.ok().body(messageResponse);
    }

    private List<UserDTO> getAllUser(){
        return userService.findAll();
    }

}
