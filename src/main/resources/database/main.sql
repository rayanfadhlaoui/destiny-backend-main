-- Create a table for races
CREATE TABLE races (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

-- Create a table to store character information
CREATE TABLE characters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    birthdate VARCHAR(11),
    gender ENUM('m', 'f'),
    race_id INT,
    FOREIGN KEY (race_id) REFERENCES races(id),
);

ALTER TABLE characters ADD username VARCHAR(50);

INSERT INTO `races` (`name`) VALUES ("Orc");
INSERT INTO `races` (`name`) VALUES ("Human");
INSERT INTO `races` (`name`) VALUES ("Elf");
INSERT INTO `races` (`name`) VALUES ("Dwarf");
