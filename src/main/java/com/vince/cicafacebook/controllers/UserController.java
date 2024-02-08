package com.vince.cicafacebook.controllers;

import com.vince.cicafacebook.dto.UserDto;
import com.vince.cicafacebook.mappers.UserEntityDtoMapper;
import com.vince.cicafacebook.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="users")
@AllArgsConstructor
public class UserController {

    AuthHelper authHelper;
    UserRepository userRepository;
    UserEntityDtoMapper userMapper;

    @GetMapping(path="{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return userMapper.entityToDto(userRepository.findEager(id));
    }
}
