DROP TABLE simpsons_character IF EXISTS;

CREATE TABLE simpsons_character (
    _id VARCHAR     PRIMARY KEY NOT NULL,
    first_name      VARCHAR,
    last_name       VARCHAR,
    picture         VARCHAR,
    age             NUMBER
);

DROP TABLE simpsons_quotes IF EXISTS;

CREATE TABLE simpsons_quotes (
    _id         VARCHAR     PRIMARY KEY NOT NULL,
    character   VARCHAR,
    quote       VARCHAR(1000)
);
