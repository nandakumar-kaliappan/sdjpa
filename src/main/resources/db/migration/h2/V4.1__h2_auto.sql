DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS author;

CREATE TABLE book(
    id IDENTITY NOT NULL,
    isbn varchar(255),
    publisher varchar(255),
    title varchar(255),
    primary key (id)
)

CREATE TABLE author(
    id IDENTITY NOT NULL,
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
)