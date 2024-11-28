CREATE TABLE IF NOT EXISTS characters (
    id serial,
    name varchar(255) NOT NULL,
    age int NOT NULL,
    description text NOT NULL
)