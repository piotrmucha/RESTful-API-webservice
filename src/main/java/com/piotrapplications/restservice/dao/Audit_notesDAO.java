package com.piotrapplications.restservice.dao;


import com.piotrapplications.restservice.entity.Audit_notes;

import java.util.List;

public interface Audit_notesDAO {
    List<Audit_notes> getHistoryofChanges(int id);
}
