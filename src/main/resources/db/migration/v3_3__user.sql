CREATE TABLE IF NOT EXISTS users(
id INTEGER SERIAL DEFAULT VALUE NOT NULL ,
employeeId INTEGER(50),
userName VARCHAR(50),
password VARCHAR(10),
isAdmin Boolean,
isActive Boolean
);
