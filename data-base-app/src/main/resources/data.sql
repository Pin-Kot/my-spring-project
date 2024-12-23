INSERT INTO car (car_id, brand, model, year, mileage, engine_type, engine_capacity, transmission_type, body_type, custom_status) VALUES
('62298098-dc52-4de0-b33c-8a139985aac0', 'Toyota', 'Camry', 2020, 15000, 'GASOLINE', 2500, 'MANUAL', 'SEDAN', 'CLEARED'),
('74c9481c-e18b-4f97-92ac-5d423a6a1838', 'Honda', 'Prius', 2019, 20000, 'HYBRID', 1500, 'AUTO', 'HATCHBACK', 'CLEARED'),
('12273ce5-c9ab-43c8-bcd1-ae12f7077978', 'Volkswagen', 'Passat', 2015, 250000, 'DIESEL', 1800, 'MANUAL', 'UNIVERSAL', 'CLEARED'),
('355c44e0-d793-4ccb-ba75-f2317576a29f', 'BMW', 'i3', 2023, 30000, 'ELECTRIC', 0, 'AUTO', 'COOUPE', 'NOT_CLEARED');

INSERT INTO users (user_id, login, password, nickname, mobile_phone, balance) VALUES
('0adec151-2959-4256-ba3b-3227d5327b13', 'jdoe', 'password1', 'John', '+375291111111', 100.00),
('e6a72750-b3b5-41ac-9c3f-2bd753419bba', 'asmith', 'password2', 'Alice', '+375251010101', 100.00),
('4010ec37-1fa9-4ea0-a092-08a3254548f7', 'bwilson', 'password3', 'Bob', '+375447777777', 100.00),
('25d43175-c5ea-41be-8e26-e780167416b0', 'cjohnson', 'password4', 'Cathy', '+375297878787', 100.00);

INSERT INTO advertisement (advertisement_id, start_date, contact_phone, price, rank, region_type, advert_status, car_id, user_id) VALUES
(UUID(), CURRENT_DATE, '+375291111111', 35000.00, 0, 'GOMEL_REGION', 'STANDARD', (SELECT car_id FROM car LIMIT 1), (SELECT user_id FROM users LIMIT 1)),
(UUID(), CURRENT_DATE, '+375251010101', 27999.00, 0, 'GRODNO_REGION', 'STANDARD', (SELECT car_id FROM car LIMIT 1 OFFSET 1), (SELECT user_id FROM users LIMIT 1 OFFSET 1)),
(UUID(), CURRENT_DATE, '+375447777777', 25000.00, 0, 'BREST_REGION', 'STANDARD', (SELECT car_id FROM car LIMIT 1 OFFSET 2), (SELECT user_id FROM users LIMIT 1 OFFSET 2)),
(UUID(), CURRENT_DATE, '+375297878787', 40000.00, 1, 'MINSK_REGION', 'PREMIUM', (SELECT car_id FROM car LIMIT 1 OFFSET 3), (SELECT user_id FROM users LIMIT 1 OFFSET 3));

INSERT INTO comment (comment_id, created, content, user_id, advertisement_id) VALUES
(UUID(), CURRENT_TIMESTAMP, 'Great car!', (SELECT user_id FROM users LIMIT 1), (SELECT advertisement_id FROM advertisement LIMIT 1)),
(UUID(), CURRENT_TIMESTAMP, 'Very reliable.', (SELECT user_id FROM users LIMIT 1 OFFSET 1), (SELECT advertisement_id FROM advertisement LIMIT 1 OFFSET 1)),
(UUID(), CURRENT_TIMESTAMP, 'Not as expected.', (SELECT user_id FROM users LIMIT 1 OFFSET 2), (SELECT advertisement_id FROM advertisement LIMIT 1 OFFSET 2)),
(UUID(), CURRENT_TIMESTAMP, 'Good value for money.', (SELECT user_id FROM users LIMIT 1 OFFSET 3), (SELECT advertisement_id FROM advertisement LIMIT 1 OFFSET 3));

INSERT INTO card (card_id, holder_name, number, amount) VALUES
(UUID(), 'John Doe', '1234-5678-1234-5678', 1000.00),
(UUID(), 'Alice Smith', '2345-6789-2345-6789', 500.00),
(UUID(), 'Bob Wilson', '3456-7890-3456-7890', 750.00),
(UUID(), 'Cathy Johnson', '4567-8901-4567-8901', 300.00);

INSERT INTO user_favorites (user_id, advertisement_id) VALUES
((SELECT user_id FROM users LIMIT 1 OFFSET 3), (SELECT advertisement_id FROM advertisement LIMIT 1 OFFSET 1)),
((SELECT user_id FROM users LIMIT 1 OFFSET 3), (SELECT advertisement_id FROM advertisement LIMIT 1 OFFSET 2)),
((SELECT user_id FROM users LIMIT 1 OFFSET 3), (SELECT advertisement_id FROM advertisement LIMIT 1 OFFSET 3));
