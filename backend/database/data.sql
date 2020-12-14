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

INSERT INTO specialty_pizza (name, description, is_available) VALUES ('Veggie Deluxe', 'Large, regular crust delight with marinara, mushrooms, and artichokes.', true);

INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 4);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 6);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 7);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 8);

INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (1, 12.99, 9.99);
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (2, 14.99, 11.99);
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (3, 16.99, 13.99);

INSERT INTO orders (status, time_stamp, delivery, total) VALUES ('pending', '2020-12-14 10:43:06', true, 16.99);

INSERT INTO delivery_information (order_id, name, phone_number, address, credit_card) VALUES (1, 'Jordan Benjamin', 123456789, '123 Street St.', 1234567890123456);

INSERT INTO pizza_orders (order_id, specialty_id, size_id) VALUES (1, null, 3);

INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 4);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 6);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 7);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 8);

COMMIT;