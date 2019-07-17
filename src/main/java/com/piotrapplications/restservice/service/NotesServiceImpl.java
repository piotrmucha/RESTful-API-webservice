package com.piotrapplications.restservice.service;

import com.piotrapplications.restservice.dao.NotesDAO;
import com.piotrapplications.restservice.entity.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class NotesServiceImpl implements NotesService {
    private NotesDAO notesDao;
    @Autowired
    public NotesServiceImpl(NotesDAO notesDao) {
        this.notesDao = notesDao;
    }

    @Override
    @Transactional
    public List<Notes> getAll() {
        return notesDao.getAll();
    }

    @Override
    @Transactional
    public Notes getById(int id) {

        return notesDao.getById(id);
    }

    @Override
    @Transactional
    public void save_update(Notes note) {
        notesDao.save_update(note);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
            notesDao.deleteById(id);
    }
}
