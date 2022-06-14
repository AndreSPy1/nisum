package com.prueba.nisumtest.service;

import com.prueba.nisumtest.dto.UserDTO;
import com.prueba.nisumtest.model.User;
import com.prueba.nisumtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements Crud<UserDTO>{
    @Autowired
    private UserRepository userRepository;
    private ModelMapper mapper = new ModelMapper();

    @Override
    public UserDTO create(UserDTO object) {
        object.setCreated(new Date());
        object.setLast_login(object.getCreated());
        object.setIsactive(true);
        User user = mapper.map(object, User.class);
        UserDTO userDTO = mapper.map(userRepository.save(user), UserDTO.class);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll(){
        List<User> users = mapper.map(userRepository.findAll(), List.class);
        List<UserDTO> userDTOS = mapper.map(users, List.class);
        return userDTOS;
    }

}
