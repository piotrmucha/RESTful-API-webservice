package com.piotrapplications.restservice.rest;

import com.piotrapplications.restservice.entity.AuditNotes;
import com.piotrapplications.restservice.entity.Notes;
import com.piotrapplications.restservice.services.AuditNotesService;
import com.piotrapplications.restservice.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotesRestController {
    private NotesService notesService;
    private AuditNotesService audit_notesService;

    @Autowired
    public NotesRestController(NotesService notesService, AuditNotesService auditNotesService) {
        this.notesService = notesService;
        this.audit_notesService = auditNotesService;
    }

    @GetMapping("/history/{noteId}")
    public List<AuditNotes> getHistoryofChanges(@PathVariable int noteId) {
        return audit_notesService.getHistoryofChanges(noteId);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Notes>> getAll() {

        return ResponseEntity.status(200).body(notesService.getAll());
    }

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<Notes> getNote(@PathVariable int noteId) {
        Optional<Notes> note = notesService.getById(noteId);
        return note.map(notes -> ResponseEntity.status(HttpStatus.OK).body(notes))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

    }

    @PostMapping("/notes")
    @ResponseBody
    public ResponseEntity<String> addNote(@RequestBody Notes note) {
        //Checks if required fields are filled and returns appropriate HTTP status
        if (note.getContent() == null || note.getTitle() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
        note.setId(0); // when user post note with id, this line force to adding new notes by setting id on 0
        notesService.save_update(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    @PutMapping("/notes")
    @ResponseBody
    public ResponseEntity<String> updateNote(@RequestBody Notes note) {

        //Checks if required fields are filled and returns appropriate HTTP status
        if (note.getContent() == null || note.getTitle() == null || note.getId() == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
        Optional<Notes> check = notesService.getById(note.getId());
        if (!check.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Note not found");
        }
        Notes retrievedNotes = check.get();
        note.setVersion(retrievedNotes.getVersion());
        note.setModified(retrievedNotes.getModified());
        note.setCreated(retrievedNotes.getCreated());
        notesService.save_update(note);
        return ResponseEntity.status(HttpStatus.OK).body(null);

    }

    @DeleteMapping("/notes/{noteId}")
    @ResponseBody
    public ResponseEntity<String> deleteNote(@PathVariable int noteId) {

        Optional<Notes> check = notesService.getById(noteId);


        if (!check.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
        }

        notesService.deleteById(noteId);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
