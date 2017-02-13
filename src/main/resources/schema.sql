create table USER (
  USER_ID NUMBER auto_increment,
  LOGIN varchar(256),
  FIRSTNAME varchar(256),
  LASTNAME varchar(256),
  PASSWORD varchar(256),
  EMAIL varchar(256),
  ENABLED boolean,
  POINTS NUMBER
);

create table FRIENDSHIP (
  USER_ID NUMBER,
  FRIEND_ID NUMBER
);

create table USER_ROLE (
  ROLE_ID NUMBER auto_increment,
  USER_ID NUMBER,
  ROLE varchar(255),
  FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
);

create table USER_GROUPS_MEMBERSHIP (
  USER_ID NUMBER,
  GROUP_ID NUMBER
);

create table CHALLENGE (
  CHALLENGE_ID NUMBER auto_increment,
  NAME varchar(255),
  DESCRIPTION varchar(255),
  STATUS varchar(255),
  CATEGORY varchar(255),
  POINTS NUMBER,
  REWARD_TYPE varchar(255),
  REWARD_QUANTITY varchar(255),
  CREATOR_ID NUMBER
);

create table "GROUP" (
  GROUP_ID NUMBER,
  NAME varchar(45)
);

create table CHALLENGES_USERS (
  CHALLENGE_ID NUMBER,
  USER_ID NUMBER
);




