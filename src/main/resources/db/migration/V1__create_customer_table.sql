create TABLE customer (
    id SERIAL PRIMARY KEY,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(50) not null unique,
    password varchar(50) not null
);