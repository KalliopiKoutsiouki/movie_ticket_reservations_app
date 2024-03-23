-- USERS
insert into USERS (ID, EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) values (1, 'emcbeath0@yahoo.com', 'Elle', 'McBeath', 'test1', '$2a$10$pZ2bf1ssb/ye9v7oVa5Mt.Gf/Yn6vs27UjqYLe3ukzrci9Q1MRmDG');
insert into USERS (ID, EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) values (2, 'oplaunch1@multiply.com', 'Otho', 'Plaunch', 'test2', '$2a$10$lW1Qj4Aw0ZOL2R6A1MCgDOye4UhdjNNgeGjCo0PDGevHsWQp9PNse');

-- USER_ROLES
insert into USER_ROLES (USER_ID, USERROLES) values (1, 'ROLE_USER');
insert into USER_ROLES (USER_ID, USERROLES) values (2, 'ROLE_USER');

-- DATERANGE
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (1, '2024-03-17', '2023-05-15');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (2, '2024-03-03', '2023-06-17');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (3, '2023-05-13', '2024-07-16');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (4, '2023-05-02', '2023-07-07');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (5, '2023-04-22', '2024-06-17');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (6, '2024-04-14', '2023-06-23');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (7, '2023-03-26', '2023-04-29');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (8, '2023-03-01', '2023-04-07');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (9, '2023-03-01', '2023-07-28');
insert into DATERANGE (ID, FROM_DATE, TO_DATE) values (10, '2023-06-29', '2024-08-16');

-- HALL
insert into HALL (ID, NAME) values (1, 'Αίθουσα 1');
insert into HALL (ID, NAME) values (2, 'Αίθουσα 2');
insert into HALL (ID, NAME) values (3, 'Αίθουσα 3');
insert into HALL (ID, NAME) values (4, 'Αίθουσα 4');
insert into HALL (ID, NAME) values (5, 'Αίθουσα 5');

-- HOUR
insert into HOURS (ID, FROM_HOUR, TO_HOUR) values (1, '6:00 PM', '8:00 PM');
insert into HOURS (ID, FROM_HOUR, TO_HOUR) values (2, '8:00 PM', '10:00 PM');
insert into HOURS (ID, FROM_HOUR, TO_HOUR) values (3, '10:00 PM', '12:00 PM');
insert into HOURS (ID, FROM_HOUR, TO_HOUR) values (4, '4:00 PM', '6:00 AM');
insert into HOURS (ID, FROM_HOUR, TO_HOUR) values (5, '2:00 PM', '4:00 AM');

-- HALL_HOUR
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (1, 4, 2, 3);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (2, 48, 4, 3);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (3, 46, 2, 4);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (4, 11, 4, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (5, 79, 1, 5);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (6, 2, 5, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (7, 80, 2, 1);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (8, 71, 3, 4);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (9, 10, 3, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (10, 36, 2, 3);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (11, 91, 4, 1);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (12, 64, 5, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (13, 1, 4, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (14, 59, 1, 4);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (15, 32, 1, 1);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (16, 74, 5, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (17, 49, 2, 5);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (18, 70, 4, 5);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (19, 30, 4, 4);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (20, 88, 3, 2);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (21, 95, 5, 1);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (22, 5, 4, 3);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (23, 49, 3, 3);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (24, 14, 1, 3);
insert into HALL_HOUR (ID, CAPACITY, HALL_ID, HOUR_ID) values (25, 38, 2, 2);

-- MOVIES
insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values (1, 'Matrix', 'Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix? ', 2, 5, 'matrix.jpg');
insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values (2, 'Blood and Wine (Blood & Wine)', 'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sita dapibus.', 8, 3, 'blood&wine.jpg');
insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values (3, 'Rare Breed, The', 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis', 9, 1, 'rareBreed.jpg');
insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID, PICTURE_URL) values (4, 'I Shot a Man in Vegas', 'Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', 4, 4, 'vegas.jpg');
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (5, 'Kalevala - Uusi aika', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pedebero quis orci.', 6, 4);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (6, 'Shooting Dogs (a.k.a. Beyond the Gates)', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus', 10, 5);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (7, 'Winners and Sinners (Qi mou miao ji: Wu fu xing)', 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet.', 6, 2);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (8, 'Startup.com', 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 7, 3);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (9, 'What the #$*! Do We Know!? (a.k.a. What the Bleep Do We Know!?)', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy.gue.', 1, 1);
-- insert into MOVIE (ID, NAME, DESCRIPTION, DATERANGE_ID, HALL_ID) values (10, 'Wavelength', 'In hac habitasse platea dictumst.', 10, 5);
