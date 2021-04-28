DROP TABLE IF EXISTS vehicle;

CREATE TABLE vehicle (
                         id INT AUTO_INCREMENT,
                         brand VARCHAR(250) NOT NULL,
                         model VARCHAR(250) NOT NULL,
                         color VARCHAR(250) NOT NULL,
                         PRIMARY KEY(id)
);