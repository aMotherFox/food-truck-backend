create TABLE appetizer (
    id SERIAL PRIMARY KEY,
    name varchar(100) not null unique,
    description varchar(160) not null unique,
    price integer not null
);