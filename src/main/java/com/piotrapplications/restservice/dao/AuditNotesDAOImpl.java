package com.piotrapplications.restservice.dao;

import com.piotrapplications.restservice.entity.AuditNotes;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class AuditNotesDAOImpl implements AuditNotesDAO {
    private EntityManager entityManager;
    @Autowired
    public AuditNotesDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<AuditNotes> getHistoryofChanges(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<AuditNotes> theQuery = currentSession.createQuery(" FROM AuditNotes where referenced_notes_id=:id order by referenced_notes_id,version asc", AuditNotes.class);
        theQuery.setParameter("id", id);
        List<AuditNotes> resultList = theQuery.getResultList();

        return resultList;
    }
}
