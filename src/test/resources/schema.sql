INSERT INTO `permissions` (`id`, `permission`)
VALUES (1, 'user:read'),
       (2, 'user:write'),
       (3, 'support:read'),
       (4, 'support:write'),
       (5, 'admin:read'),
       (6, 'admin:write');

INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'USER'),
       (2, 'SUPPORT'),
       (3, 'ADMIN');

INSERT INTO `role_permission` (`role_id`, `permission_id`)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (1, 2),
       (2, 2),
       (3, 2),
       (2, 3),
       (3, 3),
       (2, 4),
       (3, 4),
       (3, 5),
       (3, 6);

INSERT INTO `users` (`id`, `email`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`,
                     `is_enabled`, `password`, `username`, `role_id`)
VALUES (1, 'test@gmail.com', b'1', b'1', b'1', b'1', '$2a$10$zTBMNrhpC3QvJRlogKYNz.rq2J7YUoZEBzuyGe5fYnPK3DbSilhAy',
        'testuser', 1),
       (2, 'test@gmail.com', b'1', b'1', b'1', b'1', '$2a$10$ma.1ZxlNtmlaEE1spLg9Wu7vATLpiqIX7HtFc/uSsHtBkJV4RL6z2',
        'admin', 3),
       (3, 'test@gmail.com', b'0', b'0', b'0', b'1', '$2a$10$bpVNE6D2yBXCB7xVoC3nce.15XS0EvwcJNkctVCpD7LdzDzg15fOa',
        'supporter', 2);

