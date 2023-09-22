DROP TABLE IF EXISTS customer_info;
CREATE TABLE customer_info (
  id bigserial PRIMARY KEY,
  age int,
  email varchar(255) NOT NULL UNIQUE,
  password varchar(255),
  username varchar(255),
  is_delete char(1) DEFAULT 'N'
);