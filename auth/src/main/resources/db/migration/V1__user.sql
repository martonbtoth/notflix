create table "user"
(
  id serial
    constraint title_pk
      primary key,
  username text not null,
  password text not null
);
