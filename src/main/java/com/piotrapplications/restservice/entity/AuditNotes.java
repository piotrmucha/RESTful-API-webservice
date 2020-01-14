package com.piotrapplications.restservice.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="audit_notes")
public class AuditNotes{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_audit")
    private int id;
    @Column(name="referenced_notes_id")
    private int referenced_id;
    @Column(name="version")
    private int version;
    @Column(name="Title")
    private String title;
    @Column(name="Content")
    private String content;
    @Column(name = "Created", columnDefinition="DATETIME")
    private LocalDateTime created;
    @Column(name = "Modified", columnDefinition="DATETIME")
    private LocalDateTime modified;

    public AuditNotes() {
    }

    public AuditNotes(int referenced_id, int version, String title, String content, LocalDateTime created, LocalDateTime modified) {
        this.referenced_id = referenced_id;
        this.version = version;
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReferenced_id() {
        return referenced_id;
    }

    public void setReferenced_id(int referenced_id) {
        this.referenced_id = referenced_id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Audit_notes{" +
                "id=" + id +
                ", referenced_id=" + referenced_id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
