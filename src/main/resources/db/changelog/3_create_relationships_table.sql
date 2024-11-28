CREATE TABLE IF NOT EXISTS relationships (
    id serial,
    name varchar(255) NOT NULL,
    relationship_type VARCHAR(255) NOT NULL,
    key_moments text[]
)