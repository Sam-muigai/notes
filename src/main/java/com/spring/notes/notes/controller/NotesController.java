package com.spring.notes.notes.controller;

import com.spring.notes.notes.model.Category;
import com.spring.notes.notes.model.Notes;
import com.spring.notes.notes.service.NotesService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("v1/notes")
@CrossOrigin
public class NotesController {


    private final NotesService service;


    public NotesController(NotesService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Notes> getAllNotes() {
        return service.getAllNotes();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("")
    public void addNote(@RequestBody Notes note) {
        service.addNote(note);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Notes getNoteById(@PathVariable Integer id) {
        return service.getNote(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/self/{email}")
    public List<Notes> getNotesByEmail(@PathVariable String email) {
        return service.getNotesByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public void updateNotes(@PathVariable Integer id,@RequestBody Notes notes) {
        service.updateNotes(id,notes);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id){
        service.deleteNote(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{email}/{category}")
    public List<Notes> getNotesByEmailAndCategory(@PathVariable String email, @PathVariable Category category){
        return service.getNotesByCategory(email,category)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

}
