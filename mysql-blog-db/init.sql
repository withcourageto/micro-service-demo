
use b_blog;

create TABLE blog(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  title VARCHAR(50),
  content TEXT,

  author_id INTEGER,
  author_name VARCHAR(50),

  -- 这两个字段应该拆表 以提高并发下的性能
  visit_count long comment '浏览数',
  like_count int COMMENT '点赞数',

  create_date DATETIME,
  is_deleted TINYINT,
  is_disabled TINYINT
);





