DROP DATABASE if exists food_truck_db;
CREATE DATABASE food_truck_db;

DROP USER if exists admin_user;
CREATE ROLE admin_user WITH LOGIN PASSWORD '1234';