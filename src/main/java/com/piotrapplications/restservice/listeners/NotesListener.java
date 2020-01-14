package com.piotrapplications.restservice.listeners;

import com.piotrapplications.restservice.entity.AuditNotes;
import com.piotrapplications.restservice.entity.Notes;
import com.piotrapplications.restservice.repository.AuditNotesRepository;
import com.piotrapplications.restservice.services.AuditNotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
@Component
public class NotesListener {

    private static AuditNotesRepository auditNotesRepository;
    @Autowired
    public void init(AuditNotesRepository audit)
    {
        NotesListener.auditNotesRepository = audit;
    }

    @PrePersist
    public void prePersist(Notes note) {
        LocalDateTime local = LocalDateTime.now();
        note.setCreated(local);
        note.setModified(local);
        note.setVersion(1);
    }
    @PostPersist
    public void postPersist(Notes note) {
        insertToAudit(note);
    }
    @PreUpdate
    public void preUpdate (Notes note) {
        LocalDateTime local = LocalDateTime.now();
        note.setModified(local);
        note.setVersion(note.getVersion() + 1);
        insertToAudit(note);
    }
    private void insertToAudit(Notes note) {
        AuditNotes auditNotes = new AuditNotes();
        auditNotes.setContent(note.getContent());
        auditNotes.setTitle(note.getTitle());
        auditNotes.setReferenced_id(note.getId());
        auditNotes.setCreated(note.getCreated());
        auditNotes.setModified(note.getModified());
        auditNotes.setVersion(note.getVersion());
        auditNotesRepository.save(auditNotes);
    }
}
