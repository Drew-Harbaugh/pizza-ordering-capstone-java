BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS choices CASCADE;
DROP TABLE IF EXISTS prices CASCADE;

--User Tables

CREATE TABLE users (
	user_id serial,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

--Menu Tables


CREATE TABLE categories (
category_id serial NOT NULL,
name varchar NOT NULL,
CONSTRAINT pk_categories_category_id PRIMARY KEY (category_id)
);


CREATE TABLE choices (
choice_id serial NOT NULL,
category_id int NOT NULL,
name varchar NOT NULL UNIQUE,
is_available boolean,
CONSTRAINT pk_choices_choice_id PRIMARY KEY (choice_id),
CONSTRAINT fk_choices_category_id FOREIGN KEY (category_id) REFERENCES categories (category_id)
);


CREATE TABLE specialty_pizza (
specialty_id serial NOT NULL,
name varchar NOT NULL UNIQUE,
description varchar NOT NULL,
is_available boolean,
picture varchar,
CONSTRAINT pk_specialty_id PRIMARY KEY (specialty_id)
);

CREATE TABLE choices_specialty_pizza (
specialty_id int NOT NULL,
choice_id int NOT NULL,
CONSTRAINT fk_choices_choice_id FOREIGN KEY (choice_id) REFERENCES choices (choice_id),
CONSTRAINT fk_specialty_pizza_specialty_id FOREIGN KEY (specialty_id) REFERENCES specialty_pizza (specialty_id)
);

--Order Tables


CREATE TABLE orders (
order_id serial NOT NULL,
status varchar NOT NULL,
time_stamp timestamp NOT NULL,
delivery boolean NOT NULL,
total money NOT NULL,
CONSTRAINT pk_order_id PRIMARY KEY (order_id)
);




CREATE TABLE pizza_orders (
pizza_id serial PRIMARY KEY,
order_id int NOT NULL,
specialty_id int,
size_id int NOT NULL,
CONSTRAINT fk_orders_order_id FOREIGN KEY (order_id) REFERENCES orders (order_id),
CONSTRAINT fk_choices_choice_id FOREIGN KEY (size_id) REFERENCES choices (choice_id) 
);



CREATE TABLE size_price (
choice_id int NOT NULL,
custom_price money,
specialty_price money,
CONSTRAINT fk_choices_choice_id FOREIGN KEY (choice_id) REFERENCES choices (choice_id)
);



CREATE TABLE delivery_information (
order_id int NOT NULL,
name varchar NOT NULL,
phone_number numeric NOT NULL,
address varchar, 
credit_card numeric,
CONSTRAINT fk_orders_order_id FOREIGN KEY (order_id) REFERENCES orders (order_id)
);


CREATE TABLE choices_custom_pizza (
pizza_id int NOT NULL,
choice_id int NOT NULL,
CONSTRAINT fk_choices_choice_id FOREIGN KEY (choice_id) REFERENCES choices (choice_id),
CONSTRAINT fk_pizza_orders_pizza_id FOREIGN KEY (pizza_id) REFERENCES pizza_orders (pizza_id)
);











COMMIT TRANSACTION;
