package com.piotrapplications.restservice.service;

import com.piotrapplications.restservice.entity.AuditNotes;

import java.util.List;

public interface AuditNotesService {
    List<AuditNotes> getHistoryofChanges(int id);
}
