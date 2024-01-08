CREATE TABLE IF NOT EXISTS Products(id INT auto_increment PRIMARY KEY,
                                    name VARCHAR(255),
                                    price DOUBLE,
                                    description VARCHAR (355),
                                    category INT,
                                    images[] VARCHAR(400),
                                    admissionDate TIMESTAMP WITHOUT TIME ZONE);

CREATE TABLE IF NOT EXISTS Category(id INT auto_increment PRIMARY KEY, name VARCHAR(255));

CREATE TABLE IF NOT EXISTS Users(id INT auto_increment PRIMARY KEY,
                                name VARCHAR(255),
                                email VARCHAR (255),
                                password VARCHAR(255),
                                role VARCHAR(255),
                                avatarImg VARCHAR(255));

CREATE TABLE IF NOT EXISTS Products_Category(idProduct INT, idCategory INT)
