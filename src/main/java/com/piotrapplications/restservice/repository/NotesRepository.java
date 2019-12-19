package com.piotrapplications.restservice.repository;

import com.piotrapplications.restservice.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Integer> {
  //  List<Notes> getAll();
    //Optional<Notes> getById(int id);

    //void save_update(Notes note);

    //void deleteById(int id);
}
