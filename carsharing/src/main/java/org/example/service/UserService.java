package org.example.service;


import org.example.model.User;
import org.example.request.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean registerUser(UserDto userDto);

}
