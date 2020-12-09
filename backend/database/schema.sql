BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS choices CASCADE;
DROP SEQUENCE IF EXISTS categories_category_id_seq;
DROP SEQUENCE IF EXISTS choices_choice_id_seq;

CREATE TABLE users (
	user_id serial,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE categories_category_id_seq
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE TABLE categories (
category_id serial NOT NULL,
name varchar NOT NULL,
CONSTRAINT pk_categories_category_id PRIMARY KEY (category_id)
);

CREATE SEQUENCE choices_choice_id_seq
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE TABLE choices (
choice_id serial NOT NULL,
category_id int NOT NULL,
name varchar NOT NULL UNIQUE,
is_available boolean,
CONSTRAINT pk_choices_choice_id PRIMARY KEY (choice_id),
CONSTRAINT fk_choices_category_id FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

CREATE SEQUENCE specialty_id_seq
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;

CREATE TABLE specialty_pizza (
specialty_id serial NOT NULL,
name varchar NOT NULL UNIQUE,
description varchar NOT NULL,
price numeric NOT NULL,
is_available boolean,
CONSTRAINT pk_specialty_id PRIMARY KEY (specialty_id)
);

CREATE TABLE choices_specialty_pizza (
specialty_id int NOT NULL,
choice_id int NOT NULL,
CONSTRAINT fk_choices_choice_id FOREIGN KEY (choice_id) REFERENCES choices (choice_id),
CONSTRAINT fk_specialty_pizza_specialty_id FOREIGN KEY (specialty_id) REFERENCES specialty_pizza (specialty_id)
);

COMMIT TRANSACTION;
