create table USER (
  ID_USER NUMBER,
  LOGIN varchar(256),
  FIRSTNAME varchar(256),
  LASTNAME varchar(256),
  PASSWORD varchar(256),
  EMAIL varchar(256),
  ENABLED boolean,
  POINTS NUMBER
}

create table CHALLENGE{
  ID_CHALLENGE NUMBER,
  NAME varchar(255),
  DESCRIPTION varchar(255), //chuja nie varchar
  STATUS varchar(255),
  CATEGORY varchar(255),
  POINTS varchar(255),
  REWARD_TYPE varchar(255),
  REWARD_QUANTITY varchar(255),
  CREATOR_ID NUMBER
};