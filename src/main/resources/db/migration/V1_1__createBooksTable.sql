CREATE TABLE IF NOT EXISTS books(
   id INTEGER SERIAL DEFAULT VALUE UNIQUE NOT NULL,
   name VARCHAR(50),
   author VARCHAR(50),
   category VARCHAR(50),
   edition INTEGER(50),
   price FLOAT(10),
   dateOfPurchase DATE,
   vendor VARCHAR(50),
   createdDate DATE,
   createdBy VARCHAR(50),
   updatedDate DATE,
   updatedBy VARCHAR(50),
   isActive BOOLEAN
);
