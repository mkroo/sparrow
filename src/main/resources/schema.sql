DROP TABLE IF EXISTS `account`;
DROP TABLE IF EXISTS `profile`;

CREATE TABLE IF NOT EXISTS `account` (
    `id` INT AUTO_INCREMENT,
    `oauth_provider` VARCHAR(255) NOT NULL,
    `oauth_id` VARCHAR(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    primary key (`id`)
);

CREATE TABLE IF NOT EXISTS `profile` (
    `id` INT AUTO_INCREMENT,
    `account_id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    primary key (`id`)
);
