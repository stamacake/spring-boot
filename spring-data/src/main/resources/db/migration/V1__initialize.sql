create table books (id bigserial primary key, title varchar(255), description varchar(5000), price numeric(8, 2), publish_year int, genre text);
insert into books (title, description, price, publish_year, genre) values
('Harry Potter 1', 'Description 1', 300.0, 2000, 'FANTASY'),
('Harry Potter 2', 'Description 2', 400.0, 2001, 'FANTASTIC'),
('Harry Potter 3', 'Description 3', 500.0, 2002, 'FANTASY'),
('Harry Potter 4', 'Description 4', 700.0, 2007, 'FANTASY'),
('Harry Potter 5', 'Description 5', 440.0, 2004, 'FANTASTIC'),
('Harry Potter 6', 'Description 6', 650.0, 2007, 'FANTASY'),
('Harry Potter 7', 'Description 7', 200.0, 2006, 'FANTASTIC'),
('LOTR 1', 'Description 8', 1200.0, 2006, 'FANTASTIC'),
('LOTR 2', 'Description 9', 900.0, 2004, 'MYSTERY'),
('LOTR 3', 'Description 10', 600.0, 2001, 'FANTASTIC'),
('Hobbit', 'Description 11', 500.0, 2001, 'MYSTERY');