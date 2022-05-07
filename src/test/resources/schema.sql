SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT;
SET NAMES utf8;
SET NAMES utf8mb4;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0;

CREATE DATABASE IF NOT EXISTS `my_garage`;
USE `my_garage`;

CREATE TABLE IF NOT EXISTS `permissions`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `permission` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8;

DELETE
FROM `permissions`;

INSERT INTO `permissions` (`id`, `permission`)
VALUES (1, 'user:read'),
       (2, 'user:write'),
       (3, 'support:read'),
       (4, 'support:write'),
       (5, 'admin:read'),
       (6, 'admin:write');
ALTER TABLE `permissions`
    ENABLE KEYS;

CREATE TABLE IF NOT EXISTS `roles`
(
    `id`   bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

DELETE
FROM `roles`;
ALTER TABLE `roles`
    DISABLE KEYS;
INSERT INTO `roles` (`id`, `name`)
VALUES (1, 'USER'),
       (2, 'SUPPORT'),
       (3, 'ADMIN');
ALTER TABLE `roles`
    ENABLE KEYS;

CREATE TABLE IF NOT EXISTS `role_permission`
(
    `role_id`       bigint(20) NOT NULL,
    `permission_id` bigint(20) NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`),
    KEY `FK2xn8qv4vw30i04xdxrpvn3bdi` (`permission_id`),
    CONSTRAINT `FK2xn8qv4vw30i04xdxrpvn3bdi` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
    CONSTRAINT `FKtfgq8q9blrp0pt1pvggyli3v9` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DELETE
FROM `role_permission`;
ALTER TABLE `role_permission`
    DISABLE KEYS;
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
ALTER TABLE `role_permission`
    ENABLE KEYS;

CREATE TABLE IF NOT EXISTS `users`
(
    `id`                         bigint(20) NOT NULL AUTO_INCREMENT,
    `email`                      varchar(255) DEFAULT NULL,
    `is_account_non_expired`     bit(1)     NOT NULL,
    `is_account_non_locked`      bit(1)     NOT NULL,
    `is_credentials_non_expired` bit(1)     NOT NULL,
    `is_enabled`                 bit(1)     NOT NULL,
    `password`                   varchar(255) DEFAULT NULL,
    `username`                   varchar(255) DEFAULT NULL,
    `role_id`                    bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`),
    CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

DELETE
FROM `users`;
ALTER TABLE `users`
    DISABLE KEYS;
INSERT INTO `users` (`id`, `email`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`,
                     `is_enabled`, `password`, `username`, `role_id`)
VALUES (1, 'test@gmail.com', b'1', b'1', b'1', b'1', '$2a$10$zTBMNrhpC3QvJRlogKYNz.rq2J7YUoZEBzuyGe5fYnPK3DbSilhAy',
        'testuser', 1),
       (2, 'test@gmail.com', b'1', b'1', b'1', b'1', '$2a$10$ma.1ZxlNtmlaEE1spLg9Wu7vATLpiqIX7HtFc/uSsHtBkJV4RL6z2',
        'admin', 3),
       (3, 'test@gmail.com', b'0', b'0', b'0', b'1', '$2a$10$bpVNE6D2yBXCB7xVoC3nce.15XS0EvwcJNkctVCpD7LdzDzg15fOa',
        'supporter', 2);
ALTER TABLE `users`
    ENABLE KEYS;

SET SQL_MODE = IFNULL(@OLD_SQL_MODE, '');
SET FOREIGN_KEY_CHECKS = IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1);
SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT;
SET SQL_NOTES = IFNULL(@OLD_SQL_NOTES, 1);
