-- I generated all the data by using this site - http://www.mockaroo.com/
-- USERs important to application develop admins and users with normal passwords
insert into USER (user_id,firstname,lastname,login,password,email,enabled) values (1,'Admin', 'Admin', 'admin', '$2a$10$4vCT6g143m0X7n3LG5ifWeFHVCh.KB1JYJOJmvFLZNS26Alob8vRu','admin@admin.com',true);
insert into USER (user_id,firstname,lastname,login,password,email,enabled) values (2,'USER', 'USER', 'user', '$2a$10$Q21eCZAOyvpu0xzV48OqUucac6dnJZICQTxtprgBn.EQygCN3exZa','user@user.com',true);
insert into USER (user_id,firstname,lastname,login,password,email,enabled) values (3,'Admin2', 'Admin2', 'admin2', 'admin','admin2@admin.com',false);
insert into USER (user_id,firstname,lastname,login,password,email,enabled) values (4,'USER2', 'USER2', 'user2', 'user','user@user.com',false);
-- Other users
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (5, 'Mildred', 'Woods', 'John', 'B7Rx3Fd', 'janiu25@gmail.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (6, 'Margaret', 'Chavez', 'Rebecca', 'xBkxbL8', 'rchavez1@cnbc.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (7, 'Maria', 'Owens', 'Janet', 'eoIfKuWk', 'jowens2@macromedia.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (8, 'Timothy', 'Armstrong', 'Martin', '1093ZyY', 'marmstrong3@disqus.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (9, 'Ruth', 'Jenkins', 'Laura', 'hYRpSEz5y2', 'ljenkins4@cnbc.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (10, 'Ann', 'Murphy', 'Brian', '0GmSmOQQV', 'bmurphy5@surveymonkey.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (11, 'Carl', 'Hawkins', 'Carl', 'Y8PBn9FPe', 'chawkins6@microsoft.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (12, 'Charles', 'Ray', 'Kevin', 'uHM2JVoQUn', 'kray7@skyrock.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (13, 'Sandra', 'Taylor', 'Joyce', 's51fjHYhLtjz', 'jtaylor8@t-online.de', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (14, 'Lisa', 'Greene', 'Earl', 'rgj5lF3XMUv', 'egreene9@cyberchimps.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (15, 'Virginia', 'Bryant', 'Pamela', 'Re4JrN7M56', 'pbryanta@illinois.edu', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (16, 'Anthony', 'Porter', 'Gloria', '4sRgz7GK23uz', 'gporterb@blogtalkradio.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (17, 'Janet', 'Phillips', 'Annie', 'GkakJh0p67', 'aphillipsc@netlog.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (18, 'Lori', 'Fields', 'Steve', '7E13bt2i', 'sfieldsd@desdev.cn', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (19, 'Christine', 'Welch', 'Frances', 'kTEPwT', 'fwelche@wikia.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (20, 'Shirley', 'Wheeler', 'Virginia', 'kSfOY8PX', 'vwheelerf@google.com.br', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (21, 'Chris', 'Arnold', 'Janice', '14Bpgxh', 'jarnoldg@imageshack.us', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (22, 'Bonnie', 'Bishop', 'Betty', 'SZ19pY', 'bbishoph@trellian.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (23, 'Martha', 'Mcdonald', 'Ashley', '1sHreJ', 'amcdonaldi@google.co.uk', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (24, 'Henry', 'Harris', 'Rachel', '05xrN8a2t', 'rharrisj@kickstarter.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (25, 'Juan', 'Harris', 'Rose', 'Sbi34f8am', 'rharrisk@reference.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (26, 'Karen', 'Butler', 'Kathy', '8xRCi0rghiAm', 'kbutlerl@mtv.com', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (27, 'Robert', 'Jordan', 'Patricia', 'fgh8wZ', 'pjordanm@cam.ac.uk', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (28, 'Donald', 'Wright', 'Harry', 'xOhaL2iG7ttr', 'hwrightn@networksolutions.com', true);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (29, 'Marilyn', 'Gray', 'Sara', '1zGyHfiSf', 'sgrayo@simplemachines.org', false);
insert into USER (user_id, firstname, lastname, login, password, email, enabled) values (30, 'Gregory', 'Porter', 'Henry', 'J3Nttmbndhvh', 'hportero@zdnet.com', false);

-- FRIENDSHIP RELATIONS USER WITH USER

insert into FRIENDSHIP (user_id, friend_id) values (1, 5);
insert into FRIENDSHIP (user_id, friend_id) values (1, 6);
insert into FRIENDSHIP (user_id, friend_id) values (1, 7);
insert into FRIENDSHIP (user_id, friend_id) values (1, 8);
insert into FRIENDSHIP (user_id, friend_id) values (2, 9);

insert into FRIENDSHIP (user_id, friend_id) values (4, 10);
insert into FRIENDSHIP (user_id, friend_id) values (4, 11);
insert into FRIENDSHIP (user_id, friend_id) values (4, 12);
insert into FRIENDSHIP (user_id, friend_id) values (4, 5);
insert into FRIENDSHIP (user_id, friend_id) values (4, 6);

insert into FRIENDSHIP (user_id, friend_id) values (5, 15);
insert into FRIENDSHIP (user_id, friend_id) values (5, 16);
insert into FRIENDSHIP (user_id, friend_id) values (5, 17);
insert into FRIENDSHIP (user_id, friend_id) values (5, 18);
insert into FRIENDSHIP (user_id, friend_id) values (5, 19);

insert into FRIENDSHIP (user_id, friend_id) values (6, 10);
insert into FRIENDSHIP (user_id, friend_id) values (6, 5);
insert into FRIENDSHIP (user_id, friend_id) values (6, 15);
insert into FRIENDSHIP (user_id, friend_id) values (6, 20);
insert into FRIENDSHIP (user_id, friend_id) values (6, 21);


-- USER roles for important users
insert into USER_ROLE (role_id, user_id, role) values (1, 1, 'ROLE_ADMIN');
insert into USER_ROLE (role_id, user_id, role) values (2, 2, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (3, 3, 'ROLE_ADMIN');
insert into USER_ROLE (role_id, user_id, role) values (4, 4, 'ROLE_USER');

-- Other users

insert into USER_ROLE (role_id, user_id, role) values (5, 5, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (6, 6, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (7, 7, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (8, 8, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (9, 9, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (10, 10, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (11, 11, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (12, 12, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (13, 13, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (14, 14, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (15, 15, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (16, 16, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (17, 17, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (18, 18, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (19, 19, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (20, 20, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (21, 21, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (22, 22, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (23, 23, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (24, 24, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (25, 25, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (26, 26, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (27, 27, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (28, 28, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (29, 29, 'ROLE_USER');
insert into USER_ROLE (role_id, user_id, role) values (30, 30, 'ROLE_USER');

-- GROUPS
insert into FRIENDS_GROUP (group_id, name) values (1, 'ADMINS');
insert into FRIENDS_GROUP (group_id, name) values (2, 'USERS');
insert into FRIENDS_GROUP (group_id, name) values (3, 'AGHPKTEAM');
insert into FRIENDS_GROUP (group_id, name) values (4, 'HOMOSEXUALS');
insert into FRIENDS_GROUP (group_id, name) values (5, 'NIGGAS');
insert into FRIENDS_GROUP (group_id, name) values (6, 'WIKINGS');


-- USER HAS GROUP
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (1, 1);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (2, 2);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (3, 1);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (4, 2);

insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (5, 3);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (6, 3);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (7, 3);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (8, 3);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (9, 3);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (10, 3);

insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (11, 4);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (12, 4);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (13, 4);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (14, 4);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (15, 4);

insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (16, 5);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (17, 5);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (18, 5);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (19, 5);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (20, 5);

insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (21, 6);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (22, 6);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (23, 6);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (24, 6);
insert into USER_GROUPS_MEMBERSHIP (user_id, group_id) values (25, 6);

-- rest of users will not be related with any group (25-30>

-- CHALLENGES!
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (1, 'Beer Chaenge', 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam .', 'DONE', 'SPORT',  'POINTS', 'SMALL', 1);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (2, 'Ice bucket challenge', 'Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, ', 'IN_PROGRESS','SPORT',  'POINTS', 'SMALL', 2);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (3, 'Runmagedon challenge', 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nislvehicula condimentum. Curabitur in libero ut massa volutpat convallis. vehicula condimentum. Curabitur in libe', 'DONE', 'SPORT',  'POINTS', 'SMALL', 3);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (4, 'Seicento money', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molesvehicula condimentum. Curabitur in libero ut ma', 'DONE', 'SPORT', 'POINTS', 'MEDIUM', 4);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (5, 'PushUps challenge', 'Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisvehicula condimentum. Curabitur in libero ut massa volutpat convallisvehicula condimentum. Curabitur mass.', 'IN_PROGRESS', 'SPORT', 'POINTS', 'MEDIUM', 5);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (6, 'Two girls one jar challenge', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam culis justo. In hac habitasse', 'IN_PROGRESS', 'SPORT', 'POINTS', 'MEDIUM', 6);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (7, 'Sing something challenge', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purust non, pretium quis, lectus. Suspendisse potenti.', 'IN_PROGRESS', 'SPORT',  'POINTS', 'MEDIUM', 7);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (8, 'Rafal to gej challenge', 'Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mm vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida ', 'DONE', 'SPORT',  'POINTS', 'BIG', 8);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (9, 'Eat bananas ', 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus. Phasellus in felis. Donec semper savehiculaimentum. Curabitur in libero ut massa volutpat convallispien aui.', 'IN_PROGRESS', 'SPORT',  'POINTS', 'BIG', 9);
insert into CHALLENGE (challenge_id, name, description, status, category, reward_type, reward_quantity, creator_id) values (10, 'Karol to gej, potwierdzone info', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ','IN_PROGRESS' ,'SPORT',  'POINTS', 'BIG', 10);

-- CHALLENGES USERS
insert into CHALLENGES_USERS (challenge_id, user_id) values (1, 1);
insert into CHALLENGES_USERS (challenge_id, user_id) values (1, 2);
insert into CHALLENGES_USERS (challenge_id, user_id) values (1, 3);
insert into CHALLENGES_USERS (challenge_id, user_id) values (1, 4);
insert into CHALLENGES_USERS (challenge_id, user_id) values (1, 5);

insert into CHALLENGES_USERS (challenge_id, user_id) values (2, 5);
insert into CHALLENGES_USERS (challenge_id, user_id) values (2, 1);
insert into CHALLENGES_USERS (challenge_id, user_id) values (2, 6);
insert into CHALLENGES_USERS (challenge_id, user_id) values (2, 7);
insert into CHALLENGES_USERS (challenge_id, user_id) values (2, 8);
insert into CHALLENGES_USERS (challenge_id, user_id) values (2, 9);

insert into CHALLENGES_USERS (challenge_id, user_id) values (3, 10);
insert into CHALLENGES_USERS (challenge_id, user_id) values (3, 11);
insert into CHALLENGES_USERS (challenge_id, user_id) values (3, 12);
insert into CHALLENGES_USERS (challenge_id, user_id) values (3, 13);
insert into CHALLENGES_USERS (challenge_id, user_id) values (3, 14);

insert into CHALLENGES_USERS (challenge_id, user_id) values (4, 2);
insert into CHALLENGES_USERS (challenge_id, user_id) values (4, 3);
insert into CHALLENGES_USERS (challenge_id, user_id) values (4, 6);
insert into CHALLENGES_USERS (challenge_id, user_id) values (4, 7);
insert into CHALLENGES_USERS (challenge_id, user_id) values (4, 10);

insert into CHALLENGES_USERS (challenge_id, user_id) values (5, 20);
insert into CHALLENGES_USERS (challenge_id, user_id) values (5, 21);
insert into CHALLENGES_USERS (challenge_id, user_id) values (5, 22);
insert into CHALLENGES_USERS (challenge_id, user_id) values (5, 23);
insert into CHALLENGES_USERS (challenge_id, user_id) values (5, 24);


insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, USER_ID) values (1, 10, 'MAIN', 1);
insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, USER_ID) values (2, 20, 'BASIC', 1);
insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, USER_ID) values (3, 30, 'STAR', 1);
insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, USER_ID) values (4, 0, 'MAIN', 2);
insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, USER_ID) values (5, 0, 'BASIC', 2);
insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, CHALLENGE_ID) values (6, 10, 'MAIN', 1);
insert into POINT (POINT_ID, QUANTITY, POINT_TYPE, CHALLENGE_ID) values (7, 20, 'BASIC', 2);
