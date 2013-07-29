CREATE TABLE IF NOT EXISTS books(
   id INTEGER SERIAL DEFAULT VALUE UNIQUE NOT NULL,
   name VARCHAR(50),
   author VARCHAR(50),
   category VARCHAR(50),
   edition INTEGER(50),
   price FLOAT(10),
   dateOfPurchase DATE(50),
   vendor VARCHAR(50),
   createdDate DATE(50),
   createdBy VARCHAR(50),
   updatedDate DATE(50),
   updatedBy VARCHAR(50),
   isActive VARCHAR(50)
);
