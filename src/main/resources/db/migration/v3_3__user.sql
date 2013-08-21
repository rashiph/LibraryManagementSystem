CREATE TABLE IF NOT EXISTS users(
employeeId bigint(20) NOT NULL ,
userName VARCHAR(50),
password VARCHAR(10),
isAdmin Boolean,
isActive Boolean,
PRIMARY KEY(employeeId)

);
