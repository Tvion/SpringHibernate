CREATE TABLE public.purchase
(
  purchase_id SERIAL PRIMARY KEY NOT NULL,
  date DATE,
  seller INT NOT NULL,
  customer INT NOT NULL,
  book INT NOT NULL,
  amount INT NOT NULL,
  cost INT NOT NULL,
  CONSTRAINT purchase_customers_customer_id_fk FOREIGN KEY (customer) REFERENCES customers (customer_id),
  CONSTRAINT purchase_shop_shop_id_fk FOREIGN KEY (seller) REFERENCES shop (shop_id),
  CONSTRAINT purchase_books_book_id_fk FOREIGN KEY (book) REFERENCES books (book_id)
);
CREATE UNIQUE INDEX purchase_purchase_id_uindex ON public.purchase (purchase_id);

INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-02-23',2,3,1,3,21000*3);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-08-12',6,6,2,13,2342*13);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-08-21',8,2,6,1,876);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-01-02',1,10,3,4,231*4);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-06-14',7,8,3,2,231*2);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-05-17',10,5,2,1,2342);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-02-01',15,11,11,3,68643*3);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-01-03',17,6,2,5,2342*5);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-10-17',12,4,2,1,2342);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-11-11',3,4,3,1,231);
INSERT INTO purchase(date, seller, customer, book, amount, cost) VALUES ('2018-11-11',8,4,7,1,23000);