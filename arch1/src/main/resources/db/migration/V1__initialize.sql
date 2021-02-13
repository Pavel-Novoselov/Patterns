drop table if exists products cascade;
create table products (id BIGINT, title varchar(255), description varchar(5000), price numeric(8, 2), primary key(id));
insert into products
(id, title, description, price) values
(1, 'Cheese', 'Fresh cheese', 320.0),
(2, 'Milk', 'Fresh milk', 80.0),
(3, 'Apples', 'Fresh apples', 80.0),
(4, 'Bread', 'Fresh bread', 30.0);