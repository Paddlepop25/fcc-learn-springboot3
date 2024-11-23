-- creates table in h2 db on application start
-- check in http://localhost:8080/h2-console
CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title varchar(250) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    miles INT NOT NULL,
    location varchar(10) NOT NULL,
    PRIMARY KEY (id)
);