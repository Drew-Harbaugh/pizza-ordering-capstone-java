BEGIN TRANSACTION;

INSERT INTO categories (name) VALUES ('Size');
INSERT INTO categories (name) VALUES ('Crust');
INSERT INTO categories (name) VALUES ('Sauce');
INSERT INTO categories (name) VALUES ('Regular Toppings');
INSERT INTO categories (name) VALUES ('Premium Toppings');

INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Small', true);
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Medium', true);
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Large', true);
INSERT INTO choices (category_id, name, is_available) VALUES (2, 'Regular', true);
INSERT INTO choices (category_id, name, is_available) VALUES (2, 'Thin', true);
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'Marinara', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Mushrooms', true);
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Artichokes', true);

COMMIT;