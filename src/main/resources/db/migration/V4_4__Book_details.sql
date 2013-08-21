CREATE  TABLE book_details (
  id INT(11) NOT NULL ,
  book_id INT(11) NOT NULL ,
  dateOfPurchase DATE NOT NULL ,
  IsActive BIT NOT NULL ,
  PRIMARY KEY (id) )