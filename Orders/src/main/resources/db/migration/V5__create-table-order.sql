create table order(
    id_order serial not null primary key,
    id_product int not null foreign key,
    id_client int not null foreign key,
    id_time int not null foreign key
)