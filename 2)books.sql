CREATE TABLE public.books
(
    book_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR NOT NULL,
    cost INT NOT NULL,
    storage VARCHAR NOT NULL,
    amount INT NOT NULL
);
CREATE UNIQUE INDEX books_book_id_uindex ON public.books (book_id);

INSERT INTO books (name, cost, storage, amount) VALUES ('AAndB', 21000,'Sovetskiy',10);
INSERT INTO books (name, cost, storage, amount) VALUES ('1984', 2342,'Nizhegorodskiy',32);
INSERT INTO books (name, cost, storage, amount) VALUES ('SadWindows', 231,'Sormovskiy',5);
INSERT INTO books (name, cost, storage, amount) VALUES ('How', 21,'Sovetskiy',43);
INSERT INTO books (name, cost, storage, amount) VALUES ('I', 342,'Sormovskiy',56);
INSERT INTO books (name, cost, storage, amount) VALUES ('Can', 876,'Leninskiy',3);
INSERT INTO books (name, cost, storage, amount) VALUES ('Rename', 23000,'Nizhegorodskiy',45);
INSERT INTO books (name, cost, storage, amount) VALUES ('It', 654,'Sovetskiy',83);
INSERT INTO books (name, cost, storage, amount) VALUES ('Fast', 384,'Sormovskiy',12);
INSERT INTO books (name, cost, storage, amount) VALUES ('Ecxept', 2345,'Autozavodskiy',4);
INSERT INTO books (name, cost, storage, amount) VALUES ('Given', 68643,'Nizhegorodskiy',45);
INSERT INTO books (name, cost, storage, amount) VALUES ('One', 3432,'Autozavodskiy',50);
INSERT INTO books (name, cost, storage, amount) VALUES ('WindowsAndAnother', 565,'Sormovskiy',15);
INSERT INTO books (name, cost, storage, amount) VALUES ('Word', 3245,'Nizhegorodskiy',20);
INSERT INTO books (name, cost, storage, amount) VALUES ('Name', 5677,'Nizhegorodskiy',34);
INSERT INTO books (name, cost, storage, amount) VALUES ('To', 675,'Sormovskiy',4);
INSERT INTO books (name, cost, storage, amount) VALUES ('One', 10000,'Nizhegorodskiy',8);
INSERT INTO books (name, cost, storage, amount) VALUES ('Book', 5700,'Sormovskiy',15);
INSERT INTO books (name, cost, storage, amount) VALUES ('That', 456,'Leninskiy',16);
INSERT INTO books (name, cost, storage, amount) VALUES ('Is', 875,'Nizhegorodskiy',23);
INSERT INTO books (name, cost, storage, amount) VALUES ('Not', 2001,'Sormovskiy',42);
INSERT INTO books (name, cost, storage, amount) VALUES ('So', 9678,'Autozavodskiy',67);
INSERT INTO books (name, cost, storage, amount) VALUES ('Stupid', 8757,'Leninskiy',31);
INSERT INTO books (name, cost, storage, amount) VALUES ('Decision', 678,'Autozavodskiy',13);
INSERT INTO books (name, cost, storage, amount) VALUES ('AaandB', 20001,'Nizhegorodskiy',5);

COMMIT