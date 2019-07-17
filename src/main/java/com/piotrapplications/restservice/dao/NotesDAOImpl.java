package com.piotrapplications.restservice.dao;

import com.piotrapplications.restservice.entity.Notes;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class NotesDAOImpl implements NotesDAO {
    private EntityManager entityManager;
    @Autowired
    public NotesDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    public List<Notes> getAll() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Notes> theQuery = currentSession.createQuery(" FROM Notes ", Notes.class);

        List<Notes> resultList = theQuery.getResultList();

        return resultList;
    }

    @Override
    public Notes getById(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Notes note = currentSession.get(Notes.class, id);
        return note;
    }

    @Override
    public void save_update(Notes note) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.merge(note);
    }

    @Override
    public void deleteById(int idToDelete) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery(
                        "delete from Notes where id=:idToDelete");
        theQuery.setParameter("idToDelete", idToDelete);
        theQuery.executeUpdate();
    }
}
