CREATE TABLE authorities
(
    id        SERIAL PRIMARY KEY,
    authority VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    username     VARCHAR(50)  NOT NULL UNIQUE,
    password     VARCHAR(100) NOT NULL,
    enabled      BOOLEAN DEFAULT TRUE,
    authority_id INT          NOT NULL,
    FOREIGN KEY (authority_id) REFERENCES authorities (id)
);

CREATE TABLE posts
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(256),
    created     TIMESTAMP,
    updated     TIMESTAMP,
    description TEXT,
    user_id     INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE answers
(
    id      SERIAL PRIMARY KEY ,
    created TIMESTAMP,
    text    VARCHAR(256),
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    FOREIGN KEY (post_id) REFERENCES posts (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);



