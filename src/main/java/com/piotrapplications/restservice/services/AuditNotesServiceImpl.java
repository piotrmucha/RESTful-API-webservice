package com.piotrapplications.restservice.services;

import com.piotrapplications.restservice.entity.AuditNotes;
import com.piotrapplications.restservice.repository.AuditNotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditNotesServiceImpl implements AuditNotesService {
    AuditNotesRepository auditNotesRepository;

    public AuditNotesServiceImpl(AuditNotesRepository auditNotesRepository) {
        this.auditNotesRepository = auditNotesRepository;
    }

    @Override
    public List<AuditNotes> getHistoryofChanges(int id) {
        return auditNotesRepository.getHistoryofChanges(id);
    }
}
