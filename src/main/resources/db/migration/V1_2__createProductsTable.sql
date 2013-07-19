CREATE TABLE IF NOT EXISTS products(
  productId INTEGER SERIAL DEFAULT VALUE UNIQUE NOT NULL,
  productName VARCHAR(100),
  unitPrice FLOAT(6,2),
  vendorId INTEGER,
  productUnit VARCHAR(15)

);