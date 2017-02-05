insert into USER (id_user,firstname,lastname,login,password,email,enabled,points) values (1,'Rafal', 'Klimonczyk', 'admin', 'admin','e',true,10);
insert into USER (id_user,firstname,lastname,login,password,email,enabled,points) values (2,'Bartek', 'Jankowski', 'nobody', 'nobody','e',true,10);
insert into USER (id_user,firstname,lastname,login,password,email,enabled,points) values (3,'Karol', 'Golabek', 'anyone', 'anyone','e',true,10);

insert into USER_ROLE (ID_ROLE, ID_USER, ROLE) values (1, 1, 'ROLE_ADMIN');
insert into USER_ROLE (ID_ROLE, ID_USER, ROLE) values (2, 1, 'ROLE_USER');
