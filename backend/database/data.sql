BEGIN TRANSACTION;

INSERT INTO categories (name) VALUES ('Size');
INSERT INTO categories (name) VALUES ('Crust');
INSERT INTO categories (name) VALUES ('Sauce');
INSERT INTO categories (name) VALUES ('Regular Toppings');
INSERT INTO categories (name) VALUES ('Premium Toppings');

--Size
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Personal', true); --1
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Small', true); --2
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Medium', true); --3
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'Large', true); --4
INSERT INTO choices (category_id, name, is_available) VALUES (1, 'X-Large', true); --5

--Crust
INSERT INTO choices (category_id, name, is_available) VALUES (2, 'Regular', true); --6
INSERT INTO choices (category_id, name, is_available) VALUES (2, 'Thin', true); --7
INSERT INTO choices (category_id, name, is_available) VALUES (2, 'Brooklyn', true); --8
INSERT INTO choices (category_id, name, is_available) VALUES (2, 'Chicago', true); --9


--Sauce
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'Marinara', true); --10
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'BBQ', true);
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'Garlic Parmesan', true);
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'Alfredo', true);
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'Pesto', true);


--Regular Topping
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Shredded Mozzarella', true); --15
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Parmesan', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Mushrooms', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Green Peppers', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Onions', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Banana Peppers', true); --20
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Jalapeno', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Diced Tomatoes', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Spinach', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Olives', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Anchovies', true); --25
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Pepperoni', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Sausage', true);
INSERT INTO choices (category_id, name, is_available) VALUES (4, 'Ham', true);

--Premium Topping
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Fresh Mozzarella', true);
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Feta', true); --30
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Goat Cheese', true);
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Artichokes', true);
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Roasted Red Peppers', true);
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Pineapple', true);
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Bacon', true); --35
INSERT INTO choices (category_id, name, is_available) VALUES (5, 'Philly Steak', true);

--No Sauce (if you insert any new choices ADD HERE)
INSERT INTO choices (category_id, name, is_available) VALUES (3, 'No Sauce', true);

--Specials
INSERT INTO specialty_pizza (name, description, is_available) VALUES ('Veggie Deluxe', 'Regular crust delight with marinara, shredded mozzarella, green peppers, spinach, olives, mushrooms, diced tomatoes, and artichokes.', true);
INSERT INTO specialty_pizza (name, description, is_available) VALUES ('Meat Lovers', 'Regular crust pizza with marinara, shredded mozzarella, pepperoni, sausage, ham, and bacon.', true);
INSERT INTO specialty_pizza (name, description, is_available) VALUES ('Hawaiian Choke', 'Thin crust delight with marinara, shredded mozzarella, pineapple, artichokes, ham, and bacon.', true);
INSERT INTO specialty_pizza (name, description, is_available) VALUES ('Pesto Margherita Pizza', 'Brooklyn crust with pesto, fresh mozzarella, diced tomatoes, sprinkled with parmesan.', true);
INSERT INTO specialty_pizza (name, description, is_available) VALUES ('The Al Capone', 'Chicago style pizza with marinara, shredded mozzarella, parmesan, sausage, pepperoni, mushrooms, artichokes, and anchovies.', true);



--Veggie Deluxe
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 6);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 10);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 15);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 18);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 23);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 24);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 17);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 22);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (1, 32);

--Meat Lovers
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 6);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 10);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 15);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 26);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 27);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 28);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (2, 35);

--Hawaiian Choke
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 7);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 10);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 15);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 34);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 32);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 28);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (3, 35);

--Pesto Margherita Pizza
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (4, 8);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (4, 14);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (4, 29);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (4, 22);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (4, 16);

--The Al Capone
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 9);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 10);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 15);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 16);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 27);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 26);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 17);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 32);
INSERT INTO choices_specialty_pizza (specialty_id, choice_id) VALUES (5, 25);



--Size-Price Table
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (1, 10.99, 7.99);
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (2, 12.99, 9.99);
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (3, 14.99, 11.99);
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (4, 16.99, 13.99);
INSERT INTO size_price (choice_id, custom_price, specialty_price) VALUES (5, 18.99, 15.99);

--Order 1
INSERT INTO orders (status, time_stamp, delivery, total) VALUES ('Pending', '2020-12-14 10:43:06', true, 14.99);

INSERT INTO delivery_information (order_id, name, phone_number, address, credit_card) VALUES (1, 'Jordan Benjamin', 5135551234, '23 Elm St.', 1234567890123456);

INSERT INTO pizza_orders (order_id, specialty_id, size_id) VALUES (1, 0, 3);

INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 6);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 10);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 15);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 17);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (1, 24);

--Order 2
INSERT INTO orders (status, time_stamp, delivery, total) VALUES ('Pending', '2020-12-15 10:43:06', false, 24.98);

INSERT INTO delivery_information (order_id, name, phone_number, credit_card) VALUES (2, 'David Mac', 5135555678, 1234567890123456);

INSERT INTO pizza_orders (order_id, specialty_id, size_id) VALUES (2, 0, 1);
INSERT INTO pizza_orders (order_id, specialty_id, size_id) VALUES (2, 3, 4);

INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (2, 8);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (2, 10);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (2, 15);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (2, 21);
INSERT INTO choices_custom_pizza (pizza_id, choice_id) VALUES (2, 25);

--Order 3
INSERT INTO orders (status, time_stamp, delivery, total) VALUES ('Ready', '2020-12-15 11:43:06', false, 11.99);

INSERT INTO delivery_information (order_id, name, phone_number, address, credit_card) VALUES (3, 'Megan Janes', 5135550123, '2100 Seacrest Dr.', 1234567890123456);

INSERT INTO pizza_orders (order_id, specialty_id, size_id) VALUES (3, 4, 3);

COMMIT;