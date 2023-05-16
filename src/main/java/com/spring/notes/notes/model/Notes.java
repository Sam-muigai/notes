package com.spring.notes.notes.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String title;
    private String description;
    private Category category;

    public Notes(){

    }

    public Notes( String title, String email, String description, Category category) {
        this.email = email;
        this.title = title;
        this.description = description;
        this.category = category;
    }
}
