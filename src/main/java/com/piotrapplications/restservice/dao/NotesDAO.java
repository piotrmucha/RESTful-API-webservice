package com.piotrapplications.restservice.dao;

import com.piotrapplications.restservice.entity.Notes;

import java.util.List;

public interface NotesDAO {
     List<Notes> getAll();
     Notes getById(int id);

     void save_update(Notes note);

     void deleteById(int id);
}
