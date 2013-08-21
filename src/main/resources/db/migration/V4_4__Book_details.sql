CREATE  TABLE book_details (
   id bigint(20) NOT NULL AUTO_INCREMENT,
  book_id bigint(20) NOT NULL ,
  dateOfPurchase DATE NOT NULL ,
  IsActive BIT NOT NULL ,
  PRIMARY KEY (id)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8