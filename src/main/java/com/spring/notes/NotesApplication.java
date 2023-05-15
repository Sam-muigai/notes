package com.spring.notes;

import com.spring.notes.config.NotesConfigurationProperties;
import com.spring.notes.notes.model.Category;
import com.spring.notes.notes.model.Notes;
import com.spring.notes.notes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jdbc.core.JdbcTemplate;


@EnableConfigurationProperties(NotesConfigurationProperties.class)
@SpringBootApplication
public class NotesApplication{


    public static void main(String[] args) {
        SpringApplication.run(NotesApplication.class, args);
    }


}
