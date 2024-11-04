DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
    `id` INT AUTO_INCREMENT,
    `oauth_provider` VARCHAR(255) NOT NULL,
    `oauth_id` VARCHAR(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    primary key (`id`)
);

DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
    `id` INT AUTO_INCREMENT,
    `account_id` INT NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    primary key (`id`)
);

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
    `id` INT AUTO_INCREMENT,
    `sender_id` INT NOT NULL,
    `channel_id` INT NOT NULL,
    `content` TEXT NOT NULL,
    `created_at` datetime NOT NULL,
    `updated_at` datetime NOT NULL,
    primary key (`id`)
);
