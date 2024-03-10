CREATE TABLE IF NOT EXISTS employee
(
    id SERIAL NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    department VARCHAR(50) NOT NULL,
    salary DOUBLE PRECISION NOT NULL,
    PRIMARY KEY (id)
);
