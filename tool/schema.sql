CREATE TABLE `user` (
  `user_id`    integer(10) NOT NULL,
  `api_token`  varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY (`api_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `authority` (
                         `authority_id`    integer(10) NOT NULL,
                         `authority_name`  varchar(255) NOT NULL,
                         `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (`authority_id`),
                         UNIQUE KEY (`authority_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `j_user_authority` (
                               `user_id`    integer(10) NOT NULL,
                               `authority_id`    integer(10) NOT NULL,
                               `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               PRIMARY KEY (`user_id`,`authority_id`)
);

INSERT INTO user (user_id,api_token) VALUES (1,'WDGL7mGX4j'),(2,'CT/FrUY667');
INSERT INTO authority (authority_id,authority_name) VALUES (1,'test1'),(2,'test2'),(3,'test3');
INSERT INTO j_user_authority (user_id, authority_id) VALUES (1,1),(1,2),(2,3);