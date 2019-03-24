create table user_title_progress
(
  id       bigserial
    constraint user_title_progress_pk
      primary key,
  title_id bigint  not null,
  user_id  bigint  not null
    constraint user_title_progress_user_id_fk
      references "user",
  progress bigint  not null,
  watched  boolean not null
);

create unique index user_title_progress_title_id_user_id_uindex
  on user_title_progress (title_id, user_id);

