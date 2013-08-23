CREATE TABLE IF NOT EXISTS issued_books(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  bookId bigint(20) NOT NULL,
  employeeId INTEGER NOT NULL,
  issueDate DATE,
  returnedDate DATE,
  isActive BOOLEAN,
  PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
