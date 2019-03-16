create table title
(
  id serial
    constraint title_pk
      primary key,
  title text not null,
  description text not null
);
