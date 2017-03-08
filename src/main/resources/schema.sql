create table USER (
  USER_ID BIGINT(19) auto_increment,
  AUDIT_CD TIMESTAMP,
  AUDIT_RD TIMESTAMP,
  AUDIT_MD TIMESTAMP,
  LOGIN varchar(256),
  FIRSTNAME varchar(256),
  LASTNAME varchar(256),
  PASSWORD varchar(256),
  EMAIL varchar(256),
  ENABLED boolean,
  POINTS BIGINT(19)
);

create table FRIENDSHIP (
  USER_ID BIGINT(19),
  FRIEND_ID BIGINT(19)
);

create table USER_ROLE (
  ROLE_ID BIGINT(19) auto_increment,
  USER_ID BIGINT(19),
  ROLE varchar(255),
  FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
);

create table USER_GROUPS_MEMBERSHIP (
  USER_ID BIGINT(19),
  GROUP_ID BIGINT(19)
);

create table CHALLENGE (
  CHALLENGE_ID BIGINT(19) auto_increment,
    AUDIT_CD TIMESTAMP,
  AUDIT_RD TIMESTAMP,
  AUDIT_MD TIMESTAMP,
  NAME varchar(255),
  DESCRIPTION varchar(255),
  STATUS varchar(255),
  CATEGORY varchar(255),
  POINTS BIGINT(19),
  REWARD_TYPE varchar(255),
  REWARD_QUANTITY varchar(255),
  CREATOR_ID BIGINT(19)
);

create table FRIENDS_GROUP (
  GROUP_ID BIGINT(19) ,
    AUDIT_CD TIMESTAMP,
  AUDIT_RD TIMESTAMP,
  AUDIT_MD TIMESTAMP,
  NAME varchar(45)
);

create table CHALLENGES_USERS (
  CHALLENGE_ID BIGINT(19),
  USER_ID BIGINT(19)
);




