package com.piotrapplications.restservice.dao;


import com.piotrapplications.restservice.entity.AuditNotes;

import java.util.List;

public interface AuditNotesDAO {
    List<AuditNotes> getHistoryofChanges(int id);
}
