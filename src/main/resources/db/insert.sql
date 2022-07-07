INSERT INTO authorities(authority)
VALUES ('ROLE_USER');
INSERT INTO authorities(authority)
VALUES ('ROLE_ADMIN');

INSERT INTO users (username, enabled, password, authority_id)
VALUES ('root', TRUE, '$2a$10$HkLMPYQ377etGNud22Rs3OkbFQQc1FsiEZhF0LGr0dnXH2k1zZCNW',
        (SELECT id FROM authorities WHERE authority = 'ROLE_ADMIN'));