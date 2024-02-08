package com.vince.cicafacebook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="session")
public class SessionCheckController {
    @GetMapping
    public void check(){

    }
}
