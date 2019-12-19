package com.piotrapplications.restservice.services;

import com.piotrapplications.restservice.entity.Notes;
import com.piotrapplications.restservice.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {
    private  NotesRepository notesRepository;
    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }
    @Override
    public List<Notes> getAll() {
        return notesRepository.findAll();
    }

    @Override
    public Optional<Notes> getById(int id) {
        return notesRepository.findById(id);
    }

    @Override
    public void save_update(Notes note) {
        notesRepository.save(note);
    }

    @Override
    public void deleteById(int id) {
        notesRepository.deleteById(id);
    }
}
