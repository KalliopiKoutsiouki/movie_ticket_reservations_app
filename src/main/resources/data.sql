-- USERS
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) values ('emcbeath0@yahoo.com', 'Elle', 'McBeath', 'adminUser', '$2a$10$pZ2bf1ssb/ye9v7oVa5Mt.Gf/Yn6vs27UjqYLe3ukzrci9Q1MRmDG');
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) values ('oplaunch1@multiply.com', 'Otho', 'Plaunch', 'simpleUser', '$2a$10$lW1Qj4Aw0ZOL2R6A1MCgDOye4UhdjNNgeGjCo0PDGevHsWQp9PNse');
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) values ('randomMail@random.com', 'Titto', 'Tatta', 'checkerUser', '$2a$10$zT4nGHtzYV5l5FBpo72LleBAUlz6nue.G1OzzzEDm2inRWKZmeySK');
-- USER_ROLES
insert into USER_ROLES (USER_ID, USERROLES) values (1, 'ROLE_ADMIN');
insert into USER_ROLES (USER_ID, USERROLES) values (2, 'ROLE_USER');
insert into USER_ROLES (USER_ID, USERROLES) values (3, 'ROLE_USER');

-- DATERANGE
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (1, '2024-03-17', '2024-09-15');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (2, '2024-03-03', '2024-09-17');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (3, '2024-08-13', '2024-10-16');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (4, '2024-08-02', '2024-11-07');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (5, '2024-04-22', '2024-11-17');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (6, '2024-04-14', '2024-11-23');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (7, '2024-03-26', '2024-10-29');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (8, '2023-03-01', '2024-10-07');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (9, '2024-03-01', '2024-08-28');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (10, '2024-09-29', '2024-12-16');

-- HALL
insert into HALL ( NAME) values ('Aithousa 1');
insert into HALL ( NAME) values ('Aithousa 2');
insert into HALL ( NAME) values ('Aithousa 3');
insert into HALL ( NAME) values ('Aithousa 4');
insert into HALL ( NAME) values ('Aithousa 5');
insert into HALL ( NAME) values ('Aithousa 6');
insert into HALL ( NAME) values ('Aithousa 7');

-- HOUR
insert into HOURS ( FROM_HOUR, TO_HOUR) values ( '6:00 PM', '8:00 PM');
insert into HOURS ( FROM_HOUR, TO_HOUR) values ( '8:00 PM', '10:00 PM');
insert into HOURS ( FROM_HOUR, TO_HOUR) values ( '10:00 PM', '12:00 PM');
insert into HOURS ( FROM_HOUR, TO_HOUR) values ( '4:00 PM', '6:00 AM');
insert into HOURS ( FROM_HOUR, TO_HOUR) values ('2:00 PM', '4:00 AM');

-- HALL_HOUR
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (4, 2, 3);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (46, 2, 4);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (80, 2, 1);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (49, 2, 5);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 38, 2, 2);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 48, 4, 3);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 11, 4, 2);
insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 91, 4, 1);
insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 70, 4, 5);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 30, 4, 4);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 79, 1, 5);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 59, 1, 4);
insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 32, 1, 1);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 14, 1, 3);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 2, 5, 2);
insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 95, 5, 1);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 71, 3, 4);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 10, 3, 2);
insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 49, 3, 3);

-- MOVIES
-- insert into MOVIE ( NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values ( 'Matrix', 'Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix? ', 2, 5, 'matrix.jpg');
-- insert into MOVIE ( NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values ( 'Blood and Wine (Blood & Wine)', 'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sita dapibus.', 8, 3, 'blood&wine.jpg');
-- insert into MOVIE ( NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values ( 'Rare Breed, The', 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis', 9, 1, 'rareBreed.jpg');
-- insert into MOVIE ( NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values ( 'I Shot a Man in Vegas', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', 4, 4, 'vegas.jpg');
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (5, 'Kalevala - Uusi aika', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pedebero quis orci.', 6, 4);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (6, 'Shooting Dogs (a.k.a. Beyond the Gates)', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus', 10, 5);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (7, 'Winners and Sinners (Qi mou miao ji: Wu fu xing)', 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet.', 6, 2);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (8, 'Startup.com', 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 7, 3);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (9, 'What the #$*! Do We Know!? (a.k.a. What the Bleep Do We Know!?)', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.gue.', 1, 1);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (10, 'Wavelength', 'In hac habitasse platea dictumst.', 10, 5);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (1, 'Matrix', 'Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix?', 'matrix.jpg', 1, 2, 8.5, 'Lana Wachowski, Lilly Wachowski', 1999);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (2, 'Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'inception.jpg', 2, 8, 9.0, 'Christopher Nolan', 2010);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (3, 'Interstellar', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.', 'interstellar.jpg', 3, 9, 8.6, 'Christopher Nolan', 2014);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (4, 'The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.', 'dark_knight.jpg', 4, 4, 9.0, 'Christopher Nolan', 2008);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (5, 'Avengers: Endgame', 'After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more.', 'endgame.jpg', 5, 6, 8.4, 'Anthony Russo, Joe Russo', 2019);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (6, 'Eternal Sunshine of the Spotless Mind', 'When their relationship turns sour, a couple undergoes a medical procedure to have each other erased from their memories.', 'eternal_sunshine.jpg', 6, 10, 8.3, 'Michel Gondry', 2004);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, DIRECTOR, RELEASE_YEAR)
VALUES (7, 'The Grand Budapest Hotel', 'A writer encounters the owner of an aging high-class hotel, who tells him of his early years serving as a lobby boy in the hotels glorious years under an exceptional concierge.', 'grand_budapest.jpg', 7, 3, 8.1, 'Wes Anderson', 2014);

-- Insert into MOVIE_GENRE join table
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (1, 'ACTION'); -- Matrix is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (1, 'SCIENCE_FICTION'); -- Matrix is Sci-Fi
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (2, 'ACTION'); -- Inception is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (2, 'SCIENCE_FICTION'); -- Inception is Sci-Fi
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (3, 'SCIENCE_FICTION'); -- Interstellar is Sci-Fi
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (3, 'DRAMA'); -- Interstellar is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (4, 'ACTION'); -- The Dark Knight is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (4, 'DRAMA'); -- The Dark Knight is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (5, 'ACTION'); -- Avengers: Endgame is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (5, 'SCIENCE_FICTION'); -- Avengers: Endgame is Sci-Fi
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (6, 'ROMANCE'); -- Eternal Sunshine is Romance
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (6, 'DRAMA'); -- Eternal Sunshine is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (6, 'SCIENCE_FICTION'); -- Eternal Sunshine is Sci-Fi (due to the memory erasure concept)
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (7, 'COMEDY'); -- The Grand Budapest Hotel is Comedy
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (7, 'DRAMA'); -- The Grand Budapest Hotel is Drama