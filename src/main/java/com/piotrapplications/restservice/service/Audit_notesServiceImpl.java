package com.piotrapplications.restservice.service;

import com.piotrapplications.restservice.dao.Audit_notesDAO;
import com.piotrapplications.restservice.entity.Audit_notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class Audit_notesServiceImpl implements Audit_notesService {
    private Audit_notesDAO audit_notesDAO;
    @Autowired
    public Audit_notesServiceImpl( Audit_notesDAO audit) {
        this.audit_notesDAO = audit;
    }
    @Override
    @Transactional
    public List<Audit_notes> getHistoryofChanges(int id) {
        return audit_notesDAO.getHistoryofChanges(id);
    }
}
