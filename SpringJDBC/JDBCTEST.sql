create schema if not exists JDBCTEST;

use JDBCTEST;
CREATE TABLE Student(
   ID   INT NOT NULL AUTO_INCREMENT,
   NAME VARCHAR(20) NOT NULL,
   AGE  INT NOT NULL,
   PRIMARY KEY (ID)
);



DELIMITER $$

DROP PROCEDURE IF EXISTS `JDBCTEST`.`getRecord` $$
CREATE PROCEDURE `JDBCTEST`.`getRecord` (
IN in_id INTEGER,
OUT out_name VARCHAR(20),
OUT out_age  INTEGER)
BEGIN
   SELECT name, age
   INTO out_name, out_age
   FROM Student where id = in_id;
END $$

DELIMITER ;