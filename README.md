# food-truck-backend
This is the backend of our Food Truck App

### Getting Started 

1. Clone repo
```zsh
git clone git@github.com:aMotherFox/food-truck-backend.git
```
2. Add pom as Maven project
3. Run initialize-local-db.sql script ONCE
```sql
-- must be in psql, not bash
\i initialize-local-db.sql -- this runs the script to access our shared DB
```
4. Run project by clicking play button on the FoodTruckBackendApplication.java