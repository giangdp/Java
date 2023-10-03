create table client(
    id serial not null primary key,
    cpf varchar(11),
    name_client varchar(150),
    email varchar(50),
    cellphone_number(20)
)