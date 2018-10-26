USE SPRING;

CREATE TABLE IF NOT EXISTS USER_ACCOUNT(
	USER_ID VARCHAR(20),
	USER_NAME VARCHAR(20),
	PASSWORD VARCHAR(20),
	POSTCODE VARCHAR(8),
	ADDRESS VARCHAR(50)  CHARACTER SET utf8,
	EMAIL VARCHAR(50),
	JOB VARCHAR(30) CHARACTER SET utf8,
	BIRTHDAY DATE,
	PRIMARY KEY (USER_ID)
);

DELETE FROM USER_ACCOUNT;
LOAD DATA LOCAL INFILE 'user.csv' 
INTO TABLE USER_ACCOUNT 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';
QUIT
