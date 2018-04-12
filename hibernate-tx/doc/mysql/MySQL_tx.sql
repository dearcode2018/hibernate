/* MySQL */

/* many to one */

/* 创建表 */
DROP TABLE IF EXISTS user_tx;
CREATE TABLE user_tx (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	version int(11)  NULL COMMENT '版本',
	name varchar(64) COMMENT '用户姓名',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='tx用户表';

/* 添加数据 */
INSERT INTO user_tx (name, version, birthday) 
VALUES ('徐明', 1, '1973-01-16');

INSERT INTO user_tx (name, version, birthday) 
VALUES ('王洁', 1, '1987-02-18');
