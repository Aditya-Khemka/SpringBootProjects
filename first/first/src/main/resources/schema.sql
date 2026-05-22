CREATE TABLE IF NOT EXISTS Run (
    id INT PRIMARY KEY,
    title varchar(250) NOT NULL,
    start_time timestamp NOT NULL,
    end_time timestamp NOT NULL,
    distance DECIMAL (10,5) NOT NULL,
    location varchar(10) NOT NULL,
    version INTEGER
);