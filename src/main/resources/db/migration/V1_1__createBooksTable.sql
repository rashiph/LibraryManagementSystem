CREATE TABLE IF NOT EXISTS books(
   id bigint(20) NOT NULL AUTO_INCREMENT,
   name VARCHAR(50),
   author VARCHAR(50),
   category VARCHAR(50),
   edition INTEGER(50),
   price FLOAT(10),
   vendor VARCHAR(50),
   createdDate DATE,
   createdBy VARCHAR(50),
   updatedDate DATE,
   updatedBy VARCHAR(50),
   isActive BIT,
   PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8
