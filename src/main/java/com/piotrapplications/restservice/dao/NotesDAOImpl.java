package com.piotrapplications.restservice.dao;

import com.piotrapplications.restservice.entity.Notes;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class NotesDAOImpl implements NotesDAO {
    private EntityManager entityManager;
    @Autowired
    public NotesDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public List<Notes> getAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Notes> theQuery =
                currentSession.createQuery(" FROM Notes ", Notes.class);

        List<Notes> resultList = theQuery.getResultList();

        return resultList;
    }
}
