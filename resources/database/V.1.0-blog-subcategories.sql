CREATE SCHEMA IF NOT EXISTS blog_db;

CREATE TABLE blog_db.subcategories (
  code varchar(25) NOT NULL,
  name varchar(25) NOT NULL,
  category_code varchar(25) NOT NULL,
  state varchar(25) NOT NULL,
  PRIMARY KEY (code),
  UNIQUE KEY `BLOG_DB_SUBCATEGORIES_UNIQUE_NAME` (`name`)
);