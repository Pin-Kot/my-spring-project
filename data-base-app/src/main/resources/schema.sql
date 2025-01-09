-- Создание таблицы car
CREATE TABLE car (
    car_id UUID PRIMARY KEY,
    brand VARCHAR(255),
    model VARCHAR(255),
    "year" INT,
    mileage INT,
    engine_type VARCHAR(255),
    engine_capacity INT,
    transmission_type VARCHAR(255),
    body_type VARCHAR(255),
    custom_status VARCHAR(255)
);

-- Создание таблицы users
CREATE TABLE users (
    user_id UUID PRIMARY KEY,
    login VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    nickname VARCHAR(255),
    mobile_phone VARCHAR(13),
    email VARCHAR(255),
    balance DECIMAL(10, 2)
);

-- Создание таблицы advertisement
CREATE TABLE advertisement (
    advertisement_id UUID PRIMARY KEY,
    start_date DATE,
    contact_phone VARCHAR(255),
    price DECIMAL(10, 2),
    rank INT,
    region_type VARCHAR(255),
    advert_status VARCHAR(255),
    car_id UUID NOT NULL,
    user_id UUID NOT NULL,
    FOREIGN KEY (car_id) REFERENCES car(car_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Создание таблицы comment
CREATE TABLE comment (
    comment_id UUID PRIMARY KEY,
    created TIMESTAMP WITH TIME ZONE,
    content VARCHAR(255),
    user_id UUID NOT NULL,
    advertisement_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (advertisement_id) REFERENCES advertisement(advertisement_id) ON DELETE CASCADE
);

-- Создание таблицы card
CREATE TABLE card (
    card_id UUID PRIMARY KEY,
    holder_name VARCHAR(255),
    number VARCHAR(255),
    amount DECIMAL(10, 2)
);

-- Создание таблицы для хранения избранных объявлений пользователей
CREATE TABLE user_favorites (
    user_id UUID NOT NULL,
    advertisement_id UUID NOT NULL,
    PRIMARY KEY (user_id, advertisement_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (advertisement_id) REFERENCES advertisement(advertisement_id) ON DELETE CASCADE
);