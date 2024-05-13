DROP TABLE IF EXISTS `invitation`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `team`;

-- USER
CREATE TABLE `users`
(
    `user_id`            BIGINT       NOT NULL auto_increment,
    `user_name`          CHAR(7)      NOT NULL,
    `user_email`         VARCHAR(255) NOT NULL,
    `user_phone`         VARCHAR(255) NOT NULL,
    `created_at`         TIMESTAMP    NOT NULL DEFAULT now(),
    `updated_at`         TIMESTAMP    NOT NULL DEFAULT now(),
    PRIMARY KEY (`user_id`)
) engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- GROUP
CREATE TABLE `team`
(
    `group_id`           BIGINT       NOT NULL auto_increment,
    `group_name`         VARCHAR(255) NOT NULL,
    `manager_id`         BIGINT       NOT NULL,
    `created_at`         TIMESTAMP    NOT NULL DEFAULT now(),
    `updated_at`         TIMESTAMP    NOT NULL DEFAULT now(),
    PRIMARY KEY (`group_id`)
) engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- INVATATION
CREATE TABLE `invitation`
(
    `invitation_id`      BIGINT       NOT NULL auto_increment,
    `group_id`           BIGINT       NOT NULL,
    `member_id`          BIGINT       NOT NULL,
    `message`            VARCHAR(255) NOT NULL,
    `status`             VARCHAR(255) NOT NULL,
    `created_at`         TIMESTAMP    NOT NULL DEFAULT now(),
    `updated_at`         TIMESTAMP    NOT NULL DEFAULT now(),
    PRIMARY KEY (`invitation_id`)
) engine=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;