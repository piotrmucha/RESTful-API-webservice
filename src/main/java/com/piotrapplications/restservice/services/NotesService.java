package com.piotrapplications.restservice.services;

import com.piotrapplications.restservice.entity.Notes;

import java.util.List;
import java.util.Optional;

public interface NotesService {
    List<Notes> getAll();
    Optional<Notes> getById(int id);

    void save_update(Notes note);

    void deleteById(int id);
}
