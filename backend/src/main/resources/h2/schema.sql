CREATE TABLE stations (
  name VARCHAR(100) PRIMARY KEY NOT NULL
);

CREATE TABLE trains (
  id          INT PRIMARY KEY NOT NULL,
  count_seats INT             NOT NULL
);

CREATE TABLE schedules (
  id           INT IDENTITY PRIMARY KEY   NOT NULL,
  train_id     INT REFERENCES trains (id) NOT NULL,
  arrival_time TIME                       NOT NULL,
  station_name VARCHAR(100) REFERENCES stations (name)
);

CREATE TABLE passengers (
  id         INT IDENTITY PRIMARY KEY  NOT NULL,
  name       VARCHAR(100)              NOT NULL,
  last_name  VARCHAR(100)              NOT NULL,
  birth_date DATE                      NOT NULL
);
CREATE TABLE ticket (
  id        INT IDENTITY PRIMARY KEY   NOT NULL,
  traint_id INT REFERENCES trains (id) NOT NULL,
  pass_id   INT REFERENCES passengers (id)
);