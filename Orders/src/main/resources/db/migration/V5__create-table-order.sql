CREATE TABLE orders (
    id_order int PRIMARY KEY,
    id_product int NOT NULL,
    id_client int NOT NULL,
    id_time int NOT NULL,
    FOREIGN KEY (id_product) REFERENCES product(id_product), 
    FOREIGN KEY (id_client) REFERENCES client(id_client),   
    FOREIGN KEY (id_time) REFERENCES time(id_time)         
)
