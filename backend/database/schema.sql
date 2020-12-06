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
name varchar NOT NULL,
is_available boolean,
CONSTRAINT pk_choices_choice_id PRIMARY KEY (choice_id),
CONSTRAINT fk_choices_category_id FOREIGN KEY (category_id) REFERENCES categories (category_id)
);


COMMIT TRANSACTION;
