drop table book;

create table if not exists book(
    id bigint auto_increment primary key,
    name varchar(255) not null
);
