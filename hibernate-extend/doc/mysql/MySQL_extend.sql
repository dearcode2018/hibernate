/* MySQL */

/* 1.每个具体类(子类)一张表 */

/* 若存在先删除 */
DROP TABLE IF EXISTS worker_1;
/* 工人表 */
CREATE TABLE worker_1 (
  	`id` int(11) NOT NULL COMMENT '主键',
	name varchar(64) NULL COMMENT '姓名',
	sex varchar(10) NULL COMMENT '性别',
	age int(3) NULL COMMENT '年龄',
	wNo varchar(64) NULL COMMENT '工人编号',
	salary numeric(18, 2) NULL COMMENT '薪资',
 	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='worker_1表';

INSERT INTO worker_1 (id, name, sex, age, wNo, salary) VALUES (1, '张东', 'Female', 36, '20102536', 5600.50);
INSERT INTO worker_1 (id, name, sex, age, wNo, salary) VALUES (2, '黄飞', 'Female', 36, '20102554', 5600.50);

/* 若存在先删除 */
DROP TABLE IF EXISTS teacher_1;
/* 教师表 */
CREATE TABLE teacher_1 (
  	`id` int(11) NOT NULL COMMENT '主键',
	name varchar(64) NULL COMMENT '姓名',
	sex varchar(10) NULL COMMENT '性别',
	age int(3) NULL COMMENT '年龄',
	tNo varchar(64) NULL COMMENT '教师编号',
	school varchar(32) NULL COMMENT '学校',
 	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='teacher_1表';


INSERT INTO teacher_1 (id, name, sex, age, tNo, school) VALUES (1, '王菲', 'Female', 36, '2056862', '苏州科技学院');
INSERT INTO teacher_1 (id, name, sex, age, tNo, school) VALUES (2, '李林', 'Female', 36, '20188536', '中国人民大学');

/* 2.继承树一张表 (通过鉴别器来识别) */
/* 若存在先删除 */
DROP TABLE IF EXISTS people_2;
/* 教师表 */
CREATE TABLE people_2 (
  	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) NULL COMMENT '姓名',
	sex varchar(10) NULL COMMENT '性别',
	age int(3) NULL COMMENT '年龄',
	discriminator varchar(32) NULL COMMENT '鉴别器 teacher / worker',	
	wNo varchar(64) NULL COMMENT '工人编号',
	salary numeric(18, 2) NULL COMMENT '薪资',	
	tNo varchar(64) NULL COMMENT '教师编号',
	school varchar(32) NULL COMMENT '学校',
 	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='people_2表';

INSERT INTO people_2 (name, sex, age,discriminator, wNo, salary, tNo, school) 
VALUES ('黄飞虎', 'Female', 32,'worker', '20102666', 5600.50, '', '');
INSERT INTO people_2 (name, sex, age,discriminator, wNo, salary, tNo, school) 
VALUES ('吴畅', 'Male', 31,'worker', '20102886', 5600.50, '', '');

INSERT INTO people_2 (name, sex, age,discriminator, wNo, salary, tNo, school) 
VALUES ('黄飞虎', 'Female', 32, 'teacher', '', null, '20102658', '广州大学');
INSERT INTO people_2 (name, sex, age,discriminator, wNo, salary, tNo, school) 
VALUES ('吴畅', 'Male', 31, 'teacher', '', null, '20102886', '广东工业大学');

/* 3.每个子类一张表 */
/* 若存在先删除 */
DROP TABLE IF EXISTS people_3;
/* 工人表 */
CREATE TABLE people_3 (
  	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) NULL COMMENT '姓名',
	sex varchar(10) NULL COMMENT '性别',
	age int(3) NULL COMMENT '年龄',
 	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='people_3表';

INSERT INTO people_3 (id, name, sex, age) VALUES (1, '吴仲系', 'Male', 31);

INSERT INTO people_3 (id, name, sex, age) VALUES (2, '李浩', 'Male', 34);

INSERT INTO people_3 (id, name, sex, age) VALUES (3, '黄燕', 'Female', 27);

INSERT INTO people_3 (id, name, sex, age) VALUES (4, '徐涛', 'Male', 37);

/* 若存在先删除 */
DROP TABLE IF EXISTS worker_3;
/* 工人表 */
CREATE TABLE worker_3 (
  	`id` int(11) NOT NULL COMMENT '主键',
	wNo varchar(64) NULL COMMENT '工人编号',
	salary numeric(18, 2) NULL COMMENT '薪资',
 	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='worker_3表';

INSERT INTO worker_3 (id, wNo, salary) VALUES (1, '20102886', 5856.22);
INSERT INTO worker_3 (id, wNo, salary) VALUES (2, '20102886', 58962.33);
/* 若存在先删除 */
DROP TABLE IF EXISTS teacher_3;
/* 教师表 */
CREATE TABLE teacher_3 (
  	`id` int(11) NOT NULL COMMENT '主键',
	tNo varchar(64) NULL COMMENT '教师编号',
	school varchar(32) NULL COMMENT '学校',
 	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='teacher_3表';

INSERT INTO teacher_3 (id, tNo, school) VALUES (3, '2010233', '华南理工大学');
INSERT INTO teacher_3 (id, tNo, school) VALUES (4, '20102822', '广东工业大学');
