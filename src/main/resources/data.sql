-- USERS
insert into USERS (EMAIL, FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD ) values ('emcbeath0@yahoo.com', 'Elle', 'McBeath', 'adminUser', '$2a$10$pZ2bf1ssb/ye9v7oVa5Mt.Gf/Yn6vs27UjqYLe3ukzrci9Q1MRmDG');
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

-- -- HALL_HOUR
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (4, 2, 3);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (46, 2, 4);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (80, 2, 1);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values (49, 2, 5);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 38, 2, 2);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 48, 4, 3);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 11, 4, 2);
-- insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 91, 4, 1);
-- insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 70, 4, 5);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 30, 4, 4);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 79, 1, 5);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 59, 1, 4);
-- insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 32, 1, 1);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 14, 1, 3);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 2, 5, 2);
-- insert into HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID) values ( 95, 5, 1);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 71, 3, 4);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 10, 3, 2);
-- insert into HALL_HOUR ( CAPACITY, HALL_ID, HOUR_ID) values ( 49, 3, 3);



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
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (1, 'Matrix', 'Neo (Keanu Reeves) believes that Morpheus (Laurence Fishburne), an elusive figure considered to be the most dangerous man alive, can answer his question -- What is the Matrix?', 'matrix.jpg', 1, 2, 8.5, 16, 1999);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (2, 'Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'inception.jpg', 2, 8, 9.0, 13, 2010);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (3, 'Interstellar', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival.', 'interstellar.jpg', 3, 9, 8.6, 10, 2014);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (4, 'The Dark Knight', 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.', 'dark_knight.jpg', 4, 4, 9.0, 13, 2008);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (5, 'Avengers: Endgame', 'After the devastating events of Avengers: Infinity War, the universe is in ruins. With the help of remaining allies, the Avengers assemble once more.', 'endgame.jpg', 5, 6, 8.4, 13, 2019);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (6, 'Eternal Sunshine of the Spotless Mind', 'When their relationship turns sour, a couple undergoes a medical procedure to have each other erased from their memories.', 'eternal_sunshine.jpg', 6, 10, 8.3, 16, 2004);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (7, 'The Grand Budapest Hotel', 'A writer encounters the owner of an aging high-class hotel, who tells him of his early years serving as a lobby boy in the hotels glorious years under an exceptional concierge.', 'grand_budapest.jpg', 7, 3, 8.1, 16, 2014);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (8, 'Finding Nemo', 'After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.', 'finding_nemo.jpg', 7, 5, 8.1, 0, 2003);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (9, 'Schindlers List', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.', 'schindlers_list.jpg', 4, 2, 8.9, 16, 1993);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (10, 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.', 'shawshank_redemption.jpg', 5, 7, 9.3, 16, 1994);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (11, 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster, and his wife intertwine in four tales of violence and redemption.', 'pulp_fiction.jpg', 2, 1, 8.9, 18, 1994);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (12, 'Coco', 'Aspiring musician Miguel, confronted with his family’s ancestral ban on music, enters the Land of the Dead to find his great-great-grandfather, a legendary singer.', 'coco.jpg', 1, 3, 8.4, 0, 2017);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (13, 'Gladiator', 'A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery.', 'gladiator.jpg', 7, 4, 8.5, 16, 2000);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (14, 'Spirited Away', 'During her family’s move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, where humans are changed into beasts.', 'spirited_away.jpg', 3, 6, 8.6, 0, 2001);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (15, 'Parasite', 'Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.', 'parasite.jpg', 1, 5, 8.6, 16, 2019);
INSERT INTO MOVIE (id, NAME, DESCRIPTION, PICTURE_URL, HALL_ID, DATERANGE_ID, POPULARITY, AGE_RATING, RELEASE_YEAR)
VALUES (16, 'The Lion King', 'Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.', 'lion_king.jpg', 6, 2, 8.5, 0, 1994);

-- Insert into MOVIE_GENRE join table
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (1, 'ACTION'); -- Matrix is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (1, 'SCIENCE_FICTION'); -- Matrix is Sci-Fi

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (2, 'ACTION'); -- Inception is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (2, 'SCIENCE_FICTION'); -- Inception is Sci-Fi

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (3, 'SCIENCE_FICTION'); -- Interstellar is Sci-Fi
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (3, 'DRAMA'); -- Interstellar is Drama

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (4, 'ACTION'); -- The Dark Knight is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (4, 'DRAMA');
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (4, 'SCIENCE_FICTION');-- The Dark Knight is Drama

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (5, 'ACTION'); -- Avengers: Endgame is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (5, 'SCIENCE_FICTION'); -- Avengers: Endgame is Sci-Fi

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (6, 'ROMANCE'); -- Eternal Sunshine is Romance
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (6, 'DRAMA'); -- Eternal Sunshine is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (6, 'SCIENCE_FICTION'); -- Eternal Sunshine is Sci-Fi (due to the memory erasure concept)

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (7, 'COMEDY'); -- The Grand Budapest Hotel is Comedy
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (7, 'DRAMA'); -- The Grand Budapest Hotel is Drama

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (8, 'ANIMATION'); -- Finding Nemo is Animation
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (8, 'ADVENTURE'); -- Finding Nemo is Adventure
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (8, 'FAMILY'); -- Finding Nemo is Family
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (8, 'FANTASY');

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (9, 'DRAMA'); -- Schindler's List is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (9, 'HISTORICAL'); -- Schindler's List is History
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (9, 'BIOGRAPHY'); -- Schindler's List is Biography

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (10, 'DRAMA'); -- The Shawshank Redemption is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (10, 'CRIME'); -- The Shawshank Redemption is Crime

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (11, 'DRAMA'); -- Pulp Fiction is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (11, 'CRIME'); -- Pulp Fiction is Crime
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (11, 'THRILLER'); -- Pulp Fiction is Thriller

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (12, 'ANIMATION'); -- Coco is Animation
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (12, 'ADVENTURE'); -- Coco is Adventure
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (12, 'FAMILY'); -- Coco is Family
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (12, 'FANTASY'); -- Coco is Fantasy

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (13, 'ACTION'); -- Gladiator is Action
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (13, 'DRAMA'); -- Gladiator is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (13, 'ADVENTURE'); -- Gladiator is Adventure

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (14, 'ANIMATION'); -- Spirited Away is Animation
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (14, 'ADVENTURE'); -- Spirited Away is Adventure
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (14, 'FANTASY'); -- Spirited Away is Fantasy
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (14, 'FAMILY'); -- Spirited Away is Family

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (15, 'DRAMA'); -- Parasite is Drama
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (15, 'THRILLER'); -- Parasite is Thriller

INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (16, 'ANIMATION'); -- The Lion King is Animation
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (16, 'ADVENTURE'); -- The Lion King is Adventure
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (16, 'FAMILY');-- The Lion King is Family
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (16, 'FANTASY');-- The Lion King is Family
INSERT INTO MOVIE_GENRE (MOVIE_ID, GENRE) VALUES (16, 'DRAMA'); -- The Lion King is Drama


-- HALL_HOUR
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (4, 2, 3, 2);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (46, 2, 4, 2);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (80, 2, 1, 2);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (49, 2, 5, 2);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (38, 2, 2, 2);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (48, 4, 3, 4);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (11, 4, 2, 4);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (91, 4, 1, 4);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (70, 4, 5, 4);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (30, 4, 4, 4);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (79, 1, 5, 1);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (59, 1, 4, 1);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (32, 1, 1, 1);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (14, 1, 3, 1);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (2, 5, 2, 5);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (95, 5, 1, 5);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (71, 3, 4, 3);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (10, 3, 2, 3);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (49, 3, 3, 3);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (91, 6, 1, 6);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (70, 6, 5, 6);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (30, 6, 4, 6);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (79, 7, 5, 7);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (59, 7, 4, 7);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (32, 7, 1, 7);
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (14, 7, 3, 7);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (80, 4, 5, 9); -- Schindlers List
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (90, 4, 3, 9);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (100, 5, 2, 10); -- The Shawshank Redemption
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (110, 5, 4, 10);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (120, 2, 1, 11); -- Pulp Fiction
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (130, 2, 2, 11);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (140, 1, 3, 12); -- Coco
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (150, 1, 4, 12);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (160, 7, 2, 13); -- Gladiator
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (170, 7, 5, 13);

INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (180, 3, 1, 14); -- Spirited Away
INSERT INTO HALL_HOUR (CAPACITY, HALL_ID, HOUR_ID, MOVIE_ID) VALUES (190, 3, 3, 14);