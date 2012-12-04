CREATE TABLE medias (
  id INTEGER NOT NULL PRIMARY KEY,
  name varchar(255)
);
CREATE INDEX medias_name ON medias(name);