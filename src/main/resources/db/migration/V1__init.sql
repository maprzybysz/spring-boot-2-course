DROP TABLE IF EXISTS vehicle;

CREATE TABLE vehicle (
                         id LONG AUTO_INCREMENT PRIMARY KEY,
                         brand VARCHAR(250) NOT NULL,
                         model VARCHAR(250) NOT NULL,
                         color VARCHAR(250) NOT NULL
);