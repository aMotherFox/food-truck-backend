create TABLE appetizer (
    id SERIAL PRIMARY KEY,
    name varchar(50) not null unique,
    price INTEGER not null
);