USE SPRING;
CREATE TABLE IF NOT EXISTS TEAM(
    TEAM_ID MEDIUMINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL
);

DELETE FROM TEAM;
LOAD DATA LOCAL INFILE 'team.csv' 
INTO TABLE TEAM 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';
QUIT