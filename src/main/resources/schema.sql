create table USER (
  ID_USER NUMBER auto_increment,
  LOGIN varchar(256),
  FIRSTNAME varchar(256),
  LASTNAME varchar(256),
  PASSWORD varchar(256),
  EMAIL varchar(256),
  ENABLED boolean,
  POINTS NUMBER
);

create table USERS_USERS (
  ID_USER NUMBER,
  ID_FRIEND NUMBER
);

create table USER_ROLE (
  ID_ROLE NUMBER auto_increment,
  ID_USER NUMBER,
  ROLE varchar(255)
);

create table USER_HAS_GROUP (
  ID_USER NUMBER,
  ID_GROUP NUMBER
);

create table CHALLENGE (
  ID_CHALLENGE NUMBER auto_increment,
  NAME varchar(255),
  DESCRIPTION varchar(255),
  STATUS varchar(255),
  CATEGORY varchar(255),
  POINTS NUMBER,
  REWARD_TYPE varchar(255),
  REWARD_QUANTITY varchar(255),
  ID_CREATOR NUMBER
);

create table "GROUP" (
  ID_GROUP NUMBER,
  NAME varchar(45)
);

create table CHALLENGES_USERS (
  ID_CHALLENGE NUMBER,
  ID_USER NUMBER
);




