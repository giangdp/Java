create table user(
    id serial primary key not null,
    login varchar (75) not null,
    password varchar(50) not null unique,
    role varchar not null
)