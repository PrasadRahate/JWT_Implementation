package com.jwt.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class HelloController {


    @RequestMapping("/hello")
    public String getMyHello(){
        return "hello world" ;
    }
}
