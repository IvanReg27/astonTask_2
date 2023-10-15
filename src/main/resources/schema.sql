CREATE TABLE my_table (
                          id INT PRIMARY KEY,
                          name VARCHAR(120),
                          email VARCHAR(220),
                          country VARCHAR(120),
                          cities_id INT
);

INSERT INTO my_table (id, name, email, country, cities_id)
VALUES
    (1, 'Ivan', 'makhorin0088@gmail.com', 'Russia', 1),
    (2, 'Maria', 'makhorina0089@gmail.com', 'Russia', 2),
    (3, 'Pety', 'pety0084@gmail.com', 'Russia', 2),
    (4, 'Egor', 'egor0084@gmail.com', 'Russia', 1),
    (5, 'Slava', 'slava0088@gmail.com', 'Russia', 1),
    (6, 'Anton', 'anton0085@gmail.com', 'Russia', 1);