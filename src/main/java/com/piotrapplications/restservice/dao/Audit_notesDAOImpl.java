package com.piotrapplications.restservice.dao;

import com.piotrapplications.restservice.entity.Audit_notes;
import com.piotrapplications.restservice.entity.Notes;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class Audit_notesDAOImpl implements Audit_notesDAO {
    private EntityManager entityManager;
    @Autowired
    public Audit_notesDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Audit_notes> getHistoryofChanges(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Audit_notes> theQuery = currentSession.createQuery(" FROM Audit_notes where referenced_notes_id=:id order by referenced_notes_id,version asc", Audit_notes.class);
        theQuery.setParameter("id", id);
        List<Audit_notes> resultList = theQuery.getResultList();

        return resultList;
    }
}
