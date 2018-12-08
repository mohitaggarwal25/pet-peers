create schema pet;

use pet;

create table pet_user(id int(5) not null auto_increment,
user_name varchar(55) not null unique,
user_passwd varchar(55) not null,
primary key (id));

create table pets (
id int(5) not null auto_increment,
pet_name varchar(55) not null,
pet_age int(2),
pet_place varchar(55),
pet_ownerid int(5) null,
foreign key (pet_ownerid) references pet_user(id)
on delete cascade,
primary key(id));