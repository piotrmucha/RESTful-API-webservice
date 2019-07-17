package com.piotrapplications.restservice.service;

import com.piotrapplications.restservice.entity.Audit_notes;

import java.util.List;

public interface Audit_notesService {
    List<Audit_notes> getHistoryofChanges(int id);
}
