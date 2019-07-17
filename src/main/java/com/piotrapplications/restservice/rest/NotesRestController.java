package com.piotrapplications.restservice.rest;

import com.piotrapplications.restservice.entity.Audit_notes;
import com.piotrapplications.restservice.entity.Notes;
import com.piotrapplications.restservice.service.Audit_notesService;
import com.piotrapplications.restservice.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public ResponseEntity addNote(@RequestBody Notes note) {
        //Checks if required fields are filled and returns appropriate HTTP status
        if (note.getContent() == null || note.getTitle() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
        note.setId(0); // when user post note with id, this line force to adding new notes by setting id on 0
        notesService.save_update(note);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @PutMapping("/notes")
    @ResponseBody
    public ResponseEntity updateNote(@RequestBody Notes note) {

        //Checks if required fields are filled and returns appropriate HTTP status
        if (note.getContent() == null || note.getTitle() == null || note.getId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
        Notes check = notesService.getById(note.getId());
        if (check == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Note not found");
        }
        notesService.save_update(note);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @DeleteMapping("/notes/{noteId}")
    @ResponseBody
    public ResponseEntity deleteNote(@PathVariable int noteId) {

        Notes check = notesService.getById(noteId);


        if (check == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Note not found");
        }

        notesService.deleteById(noteId);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
