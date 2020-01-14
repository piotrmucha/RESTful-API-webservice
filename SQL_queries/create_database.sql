CREATE DATABASE  IF NOT EXISTS webDatabase;
use webDatabase;

CREATE TABLE notes (
                       id int(11) NOT NULL AUTO_INCREMENT,
                       version int(20) default NULL ,
                       Title varchar(45) NOT NULL,
                       Content varchar(200) NOT NULL,
                       Created DATETIME default NULL,
                       Modified DATETIME default NULL,
                       PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE audit_notes (
                             id_audit int(11) NOT NULL AUTO_INCREMENT,
                             referenced_notes_id INT,
                             version int(20) default NULL ,
                             Title varchar(45) default NULL,
                             Content varchar(200) default NULL,
                             Created DATETIME default NULL,
                             Modified DATETIME default NULL,
                             PRIMARY KEY (id_audit)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


