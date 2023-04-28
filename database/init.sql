CREATE DATABASE videostore;

\c videostore

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID DEFAULT uuid_generate_v4 (),
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movies (
    id UUID DEFAULT uuid_generate_v4 (),
    title VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    release_year INTEGER NOT NULL,
    available BOOLEAN DEFAULT true,
    PRIMARY KEY (id)
);

CREATE TABLE rentals (
    id UUID DEFAULT uuid_generate_v4 (),
    user_id UUID NOT NULL,
    movie_id UUID NOT NULL,
    rental_date DATE DEFAULT CURRENT_DATE,
    return_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

INSERT INTO users (username, password, role)
VALUES
('user1', 'password1', 'USER'),
('user2', 'password2', 'USER'),
('user3', 'password3', 'USER'),
('user4', 'password4', 'USER'),
('user5', 'password5', 'USER'),
('admin', 'password', 'ADMIN');

-- Save the IDs of the users to use them when creating the rentals
DO $$
DECLARE
    user1_id UUID = (SELECT id FROM users WHERE username = 'user1');
    user2_id UUID = (SELECT id FROM users WHERE username = 'user2');
    user3_id UUID = (SELECT id FROM users WHERE username = 'user3');
    user4_id UUID = (SELECT id FROM users WHERE username = 'user4');
    user5_id UUID = (SELECT id FROM users WHERE username = 'user5');
BEGIN
    INSERT INTO movies (title, director, release_year)
    VALUES
    ('Movie1', 'Director1', 2000),
    ('Movie2', 'Director2', 2001),
    ('Movie3', 'Director3', 2002),
    ('Movie4', 'Director4', 2003),
    ('Movie5', 'Director5', 2004),
    ('Movie6', 'Director6', 2005),
    ('Movie7', 'Director7', 2006),
    ('Movie8', 'Director8', 2007),
    ('Movie9', 'Director9', 2008),
    ('Movie10', 'Director10', 2009),
    ('Movie11', 'Director11', 2010),
    ('Movie12', 'Director12', 2011),
    ('Movie13', 'Director13', 2012),
    ('Movie14', 'Director14', 2013),
    ('Movie15', 'Director15', 2014),
    ('Movie16', 'Director16', 2015),
    ('Movie17', 'Director17', 2016),
    ('Movie18', 'Director18', 2017),
    ('Movie19', 'Director19', 2018),
    ('Movie20', 'Director20', 2019);

    INSERT INTO rentals (user_id, movie_id, rental_date, return_date)
    VALUES
    (user1_id, (SELECT id FROM movies WHERE title = 'Movie1'), '2023-01-01', '2023-01-10'),
        -- Continued from the last script
    (user1_id, (SELECT id FROM movies WHERE title = 'Movie2'), '2023-02-01', '2023-02-10'),
    (user2_id, (SELECT id FROM movies WHERE title = 'Movie3'), '2023-03-01', '2023-03-10'),
    (user2_id, (SELECT id FROM movies WHERE title = 'Movie4'), '2023-04-01', '2023-04-10'),
    (user3_id, (SELECT id FROM movies WHERE title = 'Movie5'), '2023-05-01', '2023-05-10'),
    (user3_id, (SELECT id FROM movies WHERE title = 'Movie6'), '2023-06-01', '2023-06-10'),
    (user4_id, (SELECT id FROM movies WHERE title = 'Movie7'), '2023-07-01', '2023-07-10'),
    (user4_id, (SELECT id FROM movies WHERE title = 'Movie8'), '2023-08-01', '2023-08-10'),
    (user5_id, (SELECT id FROM movies WHERE title = 'Movie9'), '2023-09-01', '2023-09-10'),
    (user5_id, (SELECT id FROM movies WHERE title = 'Movie10'), '2023-10-01', '2023-10-10'),
    (user1_id, (SELECT id FROM movies WHERE title = 'Movie11'), '2023-11-01', '2023-11-10'),
    (user1_id, (SELECT id FROM movies WHERE title = 'Movie12'), '2023-12-01', '2023-12-10'),
    (user2_id, (SELECT id FROM movies WHERE title = 'Movie13'), '2023-01-15', '2023-01-25'),
    (user2_id, (SELECT id FROM movies WHERE title = 'Movie14'), '2023-02-15', '2023-02-25'),
    (user3_id, (SELECT id FROM movies WHERE title = 'Movie15'), '2023-03-15', '2023-03-25'),
    (user3_id, (SELECT id FROM movies WHERE title = 'Movie16'), '2023-04-15', '2023-04-25'),
    (user4_id, (SELECT id FROM movies WHERE title = 'Movie17'), '2023-05-15', '2023-05-25'),
    (user4_id, (SELECT id FROM movies WHERE title = 'Movie18'), '2023-06-15', '2023-06-25'),
    (user5_id, (SELECT id FROM movies WHERE title = 'Movie19'), '2023-07-15', '2023-07-25'),
    (user5_id, (SELECT id FROM movies WHERE title = 'Movie20'), '2023-08-15', '2023-08-25');
END $$;

