package com.piotrapplications.restservice.entity;

import com.piotrapplications.restservice.listeners.NotesListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="notes")
@EntityListeners(NotesListener.class)
public class Notes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
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



    public Notes() {
    }

    public Notes(String title, String content, LocalDateTime created, LocalDateTime modified) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
