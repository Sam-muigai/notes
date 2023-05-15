package com.spring.notes.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "nc")
public record NotesConfigurationProperties(String welcomeMessage,String about) {
}
