package com.piotrapplications.restservice;

import com.piotrapplications.restservice.entity.Notes;
import com.piotrapplications.restservice.services.AuditNotesService;
import com.piotrapplications.restservice.services.NotesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
//@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration-test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan
public class RestserviceApplicationTests {
    @Autowired
    private NotesService notesService;
    @Autowired
    private AuditNotesService auditNotesService;
    @PersistenceContext
    EntityManager entityManager ;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void saveNoteStatusResponse() {
        Notes note = new Notes();
        String s = "sor";
        note.setContent("exampleContent");
        note.setTitle("exampleTitle");
        note.setId(0);
        ResponseEntity<String> response = restTemplate.postForEntity("/api/notes", note, String.class);
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
    }
    @Test
    public void deleteNoteStatusResponse () {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("/api/notes/1", HttpMethod.DELETE, entity, String.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    @Test
    public void getNotExistingNoteStatusResponse() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/notes/1",String.class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
    @Test
    public void triggersInJavaTest() {

    }

}
