DROP TABLE simpsons_character IF EXISTS;

CREATE TABLE simpsons_character (
    _id VARCHAR     PRIMARY KEY NOT NULL,
    first_name      VARCHAR,
    last_name       VARCHAR,
    picture         VARCHAR,
    age             NUMBER
)
