DROP TABLE IF EXISTS categories CASCADE;
DROP TABLE IF EXISTS choices CASCADE;

DROP SEQUENCE IF EXISTS categories_category_id_seq;
DROP SEQUENCE IF EXISTS choices_choice_id_seq;

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
isAvaibale boolean,
CONSTRAINT pk_choices_choice_id PRIMARY KEY (choice_id),
CONSTRAINT fk_choices_category_id FOREIGN KEY (category_id) REFERENCES categories (category_id)
);