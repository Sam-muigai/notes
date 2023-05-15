package com.spring.notes.notes.service;


import com.spring.notes.notes.model.Category;
import com.spring.notes.notes.model.Notes;
import com.spring.notes.notes.repository.NotesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository repository;


    public NotesService(NotesRepository repository) {
        this.repository = repository;
    }

    public List<Notes> getAllNotes() {
        return repository.findAll();
    }


    public void addNote(Notes notes) {
        repository.save(notes);
    }


    public Optional<Notes> getNote(Integer id) {
        return repository.findById(id);
    }

    public Optional<List<Notes>> getNotesByEmail(String email) {
        return repository.findAllByEmail(email);
    }

    public void updateNotes(Integer id, Notes note){
        Notes noteToUpdate = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
        noteToUpdate.setCategory(note.getCategory());
        noteToUpdate.setTitle(note.getTitle());
        noteToUpdate.setEmail(note.getEmail());
        noteToUpdate.setDescription(note.getDescription());
        repository.save(noteToUpdate);
    }

    public void deleteNote(Integer id){
        repository.deleteById(id);
    }

    public Optional<List<Notes>> getNotesByCategory(String email, Category category){
        return repository.findAllByEmailAndCategory(email,category);
    }
}

