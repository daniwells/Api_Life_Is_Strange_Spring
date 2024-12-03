CREATE TABLE IF NOT EXISTS relationships_characters (
    id serial,
    id_characters integer NOT NULL,
    id_relationships integer NOT NULL,
    FOREIGN KEY (id_characters) REFERENCES characters(id),
    FOREIGN KEY (id_relationships) REFERENCES relationships(id)
)