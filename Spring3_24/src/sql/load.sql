DELETE FROM RESERVATION;

DELETE FROM TICKET;

DELETE FROM RANK;

DELETE FROM EVENT;

DELETE FROM USER;

LOAD DATA LOCAL INFILE 'user.csv' 
INTO TABLE USER 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

LOAD DATA LOCAL INFILE 'event.csv' 
INTO TABLE EVENT 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

LOAD DATA LOCAL INFILE 'rank.csv' 
INTO TABLE RANK 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

LOAD DATA LOCAL INFILE 'ticket.csv' 
INTO TABLE TICKET 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

LOAD DATA LOCAL INFILE 'reservation.csv' 
INTO TABLE RESERVATION 
FIELDS TERMINATED BY ',' 
LINES TERMINATED BY '\r\n';

QUIT
