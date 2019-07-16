package com.piotrapplications.restservice.rest;

import com.piotrapplications.restservice.dao.NotesDAO;
import com.piotrapplications.restservice.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesRestController {
    private NotesDAO notesDAO;

    @Autowired
    public NotesRestController(NotesDAO notesDAO) {
        this.notesDAO = notesDAO;
    }

    @GetMapping("/notes")
    public List<Notes> getAll() {
        return notesDAO.getAll();
    }
}
