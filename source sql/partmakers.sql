-----
-- Test and drop table if exists
BEGIN
	EXECUTE IMMEDIATE 'drop table partmakers';

EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/


-----
-- create the new partmakers table
CREATE TABLE PARTMAKERS
	(name varchar(30) NOT NULL PRIMARY KEY);


-----
-- Add the necessary records to the table

-- INSERT INTO PARTMAKERS VALUES ('RADCRX');
INSERT INTO PARTMAKERS VALUES ('RDIMARS');
INSERT INTO PARTMAKERS VALUES ('RDIMBEH');
INSERT INTO PARTMAKERS VALUES ('RDIMDAN');
INSERT INTO PARTMAKERS VALUES ('RDIMMOD');

commit;
