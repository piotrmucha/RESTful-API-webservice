# RESTful API webservice 
Webservice for managing and storing in database simple notes (without the UI part). Application was written in Java with JPA, Hibernate and Spring-boot.
##  What is required for running the project:
- You need to have JDK 1.8 and MySql Workbench installed
## Steps how to run scripts that will setup database for the project:
1) Log in to MySQL as the root user and execute create_user.sql script (you can find all scripts in [SQL_queries](SQL_queries/) directory).
2) Log in to MySql using username: **webUser** and password: **password** and execute create_database.sql script.
## 	Steps how to build and run the project:
1) Download project as zip file and extract this.
2) Make sure that you are in RESTful-API-webservice-master directory and type: 
       ```
           mvnw clean install 
        ``` to build the project.
3) Make sure that port 8080 is available for you and run application using command: ```
           java -jar target/restservice-0.0.1-SNAPSHOT.jar 
        ``` .
##	Example usages 

|HTTP METHOD|ENDPOINT|CRUD ACTION|
| ---- | ---------- |------------------|
| POST | /api/notes |Create a new notes|
| GET | /api/notes |Get a list of notes|
| GET | /api/notes/{noteId} |Read a single note|
| PUT | /api/notes |Update an existing note|
| DELETE | /api/notes/{noteId} |Delete an existing note|
| GET | /api/history/{noteId} |Read  history of changes for particular note|

[PostMan](https://www.getpostman.com/downloads/) is a good application to check the functionality. You can use, for example, the post method as shown in the image below.


![Alt text](https://i.paste.pics/32255ce8df88b101eac651ce7c749842.png "Example usage")



Or to update particular note you should do this:

![Alt text](https://i.paste.pics/700fa837f7832f9830ae8bf94eb8e0b4.png "Example usage")

And to delete the note with id=1

![Alt text](https://i.paste.pics/3026d67dc6735efea96c8fe9f9ade3f3.png "Example usage")

## To-do-list

 - [ ] <s>Create integration tests for each functionality using H2 in-memory database and JUnit test framework.</s>
 - [X] Move versioning management from sql triggers to java code using @PrePersist and @PreUpdate annotations.
 - [X] Create basic frontend configuration to manage notes using react.
 - [X] Create basic configuration to integration testing using testcontainers/docker.
 - [ ] Create integration tests for each functionality using mysql testcontainer and Junit test framewrok.
 

## Author

* **Piotr Mucha** - (https://github.com/piotrmucha)
