CREATE TABLE `user` (
  `user_id`    integer(10) NOT NULL,
  `api_token`  varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY (`api_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
                         `role_id`    integer(10) NOT NULL,
                         `role_name`  varchar(255) NOT NULL,
                         `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`role_id`),
                         UNIQUE KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `j_user_role` (
                               `user_id`    integer(10) NOT NULL,
                               `role_id`    integer(10) NOT NULL,
                               `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               PRIMARY KEY (`user_id`,`role_id`)
);

INSERT INTO user (user_id,api_token) VALUES (1,'WDGL7mGX4j'),(2,'CT/FrUY667');
INSERT INTO role (role_id,role_name) VALUES (1,'test1'),(2,'test2'),(3,'test3');