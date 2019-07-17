package com.piotrapplications.restservice.service;

import com.piotrapplications.restservice.dao.AuditNotesDAO;
import com.piotrapplications.restservice.entity.AuditNotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class AuditNotesServiceImpl implements AuditNotesService {
    private AuditNotesDAO audit_notesDAO;
    @Autowired
    public AuditNotesServiceImpl(AuditNotesDAO audit) {
        this.audit_notesDAO = audit;
    }
    @Override
    @Transactional
    public List<AuditNotes> getHistoryofChanges(int id) {
        return audit_notesDAO.getHistoryofChanges(id);
    }
}
