/*DROP TABLE IF EXISTS HEROES;
DROP TABLE IF EXISTS WEAPONS;

CREATE TABLE HEROES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  realname VARCHAR(250) NOT NULL,
  superpower VARCHAR(250) NOT NULL
);

CREATE TABLE WEAPONS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  hero_id INT,
  FOREIGN KEY (hero_id) REFERENCES HEROES(id)
);

INSERT INTO HEROES (type, name, realname, superpower) VALUES
  ('hero', 'Spider-Man', 'Peter Parker', 'spider sense');

INSERT INTO WEAPONS (name, hero_id) VALUES ('spider web', 1);
INSERT INTO WEAPONS (name, hero_id) VALUES ('mechanical arms', 1);
 */