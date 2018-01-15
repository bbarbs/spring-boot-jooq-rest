/*
  Just for demonstration only, to test JOOQ capability.
 */

DROP SCHEMA IF EXISTS My_Schema;

CREATE SCHEMA IF NOT EXISTS My_Schema AUTHORIZATION test;

DROP TABLE IF EXISTS My_Schema.Customer;
DROP TABLE IF EXISTS My_Schema.Address;
DROP TABLE IF EXISTS My_Schema.Passport;
DROP TABLE IF EXISTS My_Schema.Items_Orders;
DROP TABLE IF EXISTS My_Schema.Items;
DROP TABLE IF EXISTS My_Schema.Orders;

CREATE TABLE IF NOT EXISTS My_Schema.Customer (
  id        INT AUTO_INCREMENT PRIMARY KEY ,
  firstname VARCHAR(50) ,
  lastname  VARCHAR(50)
);

/*
  One to One relationship with Customer table, added UNIQUE constraint
  One Customer to One Passport and vice versa
 */
CREATE TABLE IF NOT EXISTS My_Schema.Passport (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  passport_number VARCHAR(100) ,
  fk_cust_id INT ,
  FOREIGN KEY (fk_cust_id) REFERENCES My_Schema.Customer (id) ON DELETE CASCADE ,
  UNIQUE (fk_cust_id)
);

/*
  One to Many and Many to One relationship with Customer table
  One Customer to Many Address and vice versa
 */
CREATE TABLE IF NOT EXISTS My_Schema.Address (
  id        INT AUTO_INCREMENT PRIMARY KEY ,
  address   VARCHAR(200) ,
  type      VARCHAR(50) ,
  fk_cust_id   INT ,
  FOREIGN KEY (fk_cust_id) REFERENCES My_Schema.Customer (id) ON DELETE CASCADE
);

/*
  Many to Many relationship.
 */
CREATE TABLE IF NOT EXISTS My_Schema.Items_Orders (
  order_id INT ,
  item_id INT
);

CREATE TABLE IF NOT EXISTS My_Schema.Orders (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  date_order DATETIME ,
  status VARCHAR(50) ,
  amount DECIMAL(19, 4) ,
  fk_cust_id INT ,
  FOREIGN KEY (fk_cust_id) REFERENCES My_Schema.Customer (id)
);

CREATE TABLE IF NOT EXISTS My_Schema.Items (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  code VARCHAR(50) ,
  item_name VARCHAR(100) ,
  description VARCHAR(300)
);

