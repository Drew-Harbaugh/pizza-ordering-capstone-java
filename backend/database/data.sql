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

INSERT INTO specialty_pizza (name, description, price, is_available) VALUES ('Veggie Deluxe', 'Large, regular crust delight with marinara, mushrooms, and artichokes.', 19.99, true);

INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 4);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 6);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 7);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 8);

COMMIT;