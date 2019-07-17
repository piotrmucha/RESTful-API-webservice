CREATE DATABASE  IF NOT EXISTS `webDatabase`;
USE `webDatabase`;

DROP TABLE IF EXISTS `Notes`;

CREATE TABLE `Notes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(20) default NULL ,
  `Title` varchar(45) NOT NULL,
  `Content` varchar(200) NOT NULL,
  `Created` DATETIME default NULL,
  `Modified` DATETIME default NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `audit_notes`;

CREATE TABLE `audit_notes` (
	`id_audit`int(11) NOT NULL AUTO_INCREMENT,
	/** this column refering the id 
		of the notes table **/
	`referenced_notes_id` INT,
    `version` int(20) default NULL ,
	`Title` varchar(45) default NULL,
    `Content` varchar(200) default NULL,
	`Created` DATETIME default NULL,
  `Modified` DATETIME default NULL,
  PRIMARY KEY (`id_audit`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DELIMITER $$
CREATE TRIGGER `update_date` BEFORE INSERT ON `Notes` 
FOR EACH ROW BEGIN
	Set NEW.Created = SysDate();
    Set NEW.Modified = SysDate();
    Set NEW.version = 1;
  END$$;
  DELIMITER ;
  DELIMITER $$
  
CREATE TRIGGER `insert_to_audit` AFTER INSERT ON `Notes` 
FOR EACH ROW BEGIN
     INSERT INTO `audit_notes` 
		(`referenced_notes_id`, `version`, 
		`Title`, `Content`, `Created`,`Modified`) 
	VALUES(NEW.`id`, NEW.`version`, 
		NEW.`Title`, NEW.`Content`, NEW.`Created`, NEW.`MODIFIED`);
  END$$;
  DELIMITER ;
DELIMITER $$

CREATE TRIGGER `audit_notes_entry` BEFORE UPDATE ON `Notes` 
FOR EACH ROW BEGIN
    Set NEW.Modified = SysDate();
    Set New.Created = Old.Created;
    Set NEW.version = OLD.version +1;
    INSERT INTO `audit_notes` 
		(`referenced_notes_id`, `version`, 
		`Title`, `Content`, `Created`,`Modified`) 
	VALUES(NEW.`id`, NEW.`version`, 
		NEW.`Title`, NEW.`Content`, NEW.`Created`, NEW.`MODIFIED`);
  END$$;
  DELIMITER ;
