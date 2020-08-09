CREATE TABLE users (
    id bigserial primary key,
    name varchar(255),
    age int
);

CREATE TABLE products (
    id bigserial primary key,
    name varchar(255),
    price int
);