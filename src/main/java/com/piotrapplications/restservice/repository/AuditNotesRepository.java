package com.piotrapplications.restservice.repository;

import com.piotrapplications.restservice.entity.AuditNotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditNotesRepository extends JpaRepository<AuditNotes, Integer> {
    @Query(" FROM AuditNotes where referenced_notes_id=:id order by referenced_notes_id,version asc")
    List<AuditNotes> getHistoryofChanges(@Param("id")int id);
}
