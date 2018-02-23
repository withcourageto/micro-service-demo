USE blog_user;


CREATE TABLE user (
  id          INTEGER PRIMARY KEY AUTO_INCREMENT,
  username    VARCHAR(50),
  password    VARCHAR(50),
  create_date DATETIME,
  is_deleted  TINYINT,
  type        TINYINT COMMENT '0: admin,1: general user',
  is_disabled TINYINT
);

INSERT INTO user (username, password) VALUES ('admin', 'admin');





