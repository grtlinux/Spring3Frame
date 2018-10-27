USE SPRING;

CREATE TABLE IF NOT EXISTS ITEM(
	ITEM_ID INTEGER(5) AUTO_INCREMENT,
	ITEM_NAME VARCHAR(20) CHARACTER SET utf8,
	PRICE INTEGER(6),
	DESCRIPTION VARCHAR(50) CHARACTER SET utf8,
	PICTURE_URL VARCHAR(20),
	PRIMARY KEY (ITEM_ID)
);

ALTER TABLE ITEM ADD COLUMN PICTURE LONGBLOB;

TRUNCATE TABLE SALE_LINE;
TRUNCATE TABLE SALE;