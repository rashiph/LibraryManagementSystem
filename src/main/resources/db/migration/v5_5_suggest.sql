CREATE TABLE IF NOT EXISTS suggest(
id bigint(20) NOT NULL AUTO_INCREMENT,
employeeId bigint(20) NOT NULL ,
bookName VARCHAR(50),
authorName VARCHAR(10),
edition INTEGER(20) ,
 PRIMARY KEY (id)
)   ;
