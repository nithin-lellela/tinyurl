drop database tinyurldb;
drop user test;
create user test with password 'root';
create database tinyurldb with template=template0 owner=test;
\connect tinyurldb;
alter default privileges grant all on tables to test;
alter default privileges grant all on sequences to test;

create table users(
    user_id integer primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(30) not null,
    password text not null
);

create table tiny_url(
    id integer primary key not null,
    user_id integer not null,
    short_url varchar(20) not null,
    original_url varchar(20000) not null
);

alter table tiny_url add constraint tiny_url_fk
foreign key (user_id) references users(user_id);

create sequence users_seq increment 1 start 1;
create sequence tiny_url_seq increment 1 start 1;
