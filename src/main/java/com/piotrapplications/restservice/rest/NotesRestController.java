package com.piotrapplications.restservice.rest;

import com.piotrapplications.restservice.entity.Audit_notes;
import com.piotrapplications.restservice.entity.Notes;
import com.piotrapplications.restservice.service.Audit_notesService;
import com.piotrapplications.restservice.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesRestController {
    private NotesService notesService;
    private Audit_notesService audit_notesService;

    @Autowired
    public NotesRestController(NotesService notesService, Audit_notesService audit_notesService) {
        this.notesService = notesService;
        this.audit_notesService = audit_notesService;
    }

    @GetMapping("/history/{noteId}")
    public List<Audit_notes> getHistoryofChanges(@PathVariable int noteId) {
        return audit_notesService.getHistoryofChanges(noteId);
    }

    @GetMapping("/notes")
    public List<Notes> getAll() {
        return notesService.getAll();
    }

    @GetMapping("/notes/{noteId}")
    public Notes getNote(@PathVariable int noteId) {

        Notes note = notesService.getById(noteId);

        return note;
    }

    @PostMapping("/notes")
    public void addNote(@RequestBody Notes note) {
        note.setId(0); // when user post note with id, this line force to adding new notes by setting id on 0
        notesService.save_update(note);

    }

    @PutMapping("/notes")
    public void updateNote(@RequestBody Notes note) {

        notesService.save_update(note);

    }

    @DeleteMapping("/notes/{noteId}")
    public String deleteEmployee(@PathVariable int noteId) {

        Notes note = notesService.getById(noteId);


        if (note == null) {
            throw new RuntimeException("Note id not found - " + noteId);
        }

        notesService.deleteById(noteId);

        return "Deleted note id - " + noteId;
    }
}
