create table product(
    id_product serial not null primary key,
    name_product varchar(50),
    price double(10),
    description varchar(500)
)