package com.vince.cicafacebook.controllers;

import com.vince.cicafacebook.dto.CatDto;
import com.vince.cicafacebook.dto.UserDto;
import com.vince.cicafacebook.mappers.CatEntityDtoMapper;
import com.vince.cicafacebook.mappers.UserEntityDtoMapper;
import com.vince.cicafacebook.repositories.cat.CatRepository;
import com.vince.cicafacebook.repositories.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "cats")
@AllArgsConstructor
public class CatController {

    AuthHelper authHelper;
    CatRepository catRepository;
    CatEntityDtoMapper catMapper;

    @GetMapping
    public List<CatDto> findAllCats(){
        return catRepository.findAllWithRatings().stream().map(catMapper::entityToDto).toList();
    }
}
