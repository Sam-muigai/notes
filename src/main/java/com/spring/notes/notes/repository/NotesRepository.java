package com.spring.notes.notes.repository;

import com.spring.notes.notes.model.Category;
import com.spring.notes.notes.model.Notes;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface NotesRepository extends ListCrudRepository<Notes, Integer> {

    Optional<List<Notes>> findAllByEmail(String email);

    Optional<List<Notes>> findAllByEmailAndCategory(String email,Category category);

}
