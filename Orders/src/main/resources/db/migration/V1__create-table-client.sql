create table client(
    id serial not null primary key,
    cpf varchar(11),
    name_client varchar(150),
    email varchar(50),
    cellphone_number varchar(20),
    neighborhood varchar(50),
    street varchar(50),
    cep varchar(8),
    number varchar(6)
)