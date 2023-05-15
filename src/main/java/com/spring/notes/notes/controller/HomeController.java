package com.spring.notes.notes.controller;


import com.spring.notes.config.NotesConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final NotesConfigurationProperties properties;


    public HomeController(NotesConfigurationProperties properties) {
        this.properties = properties;
    }


    @GetMapping("/")
    public NotesConfigurationProperties home(){
        return properties;
    }

}
