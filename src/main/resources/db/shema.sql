CREATE TABLE authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int          not null,
    foreign key (authority_id) references authorities (id)
);

CREATE TABLE posts
(
    id          serial primary key,
    name        VARCHAR(256),
    created     timestamp,
    updated     timestamp,
    description text,
    user_id     int not null,
    foreign key (user_id) references users (id)
);

CREATE TABLE answers
(
    id      serial primary key,
    created timestamp,
    text    VARCHAR(256),
    user_id int not null,
    post_id int not null,
    foreign key (post_id) references posts (id),
    foreign key (user_id) references users (id)
);

INSERT INTO authorities(authority)
values ('ROLE_USER');
INSERT INTO authorities(authority)
values ('ROLE_ADMIN');

insert into users (username, enabled, password, authority_id)
values ('root', true, '$2a$10$HkLMPYQ377etGNud22Rs3OkbFQQc1FsiEZhF0LGr0dnXH2k1zZCNW',
        (select id from authorities where authority = 'ROLE_ADMIN'));



