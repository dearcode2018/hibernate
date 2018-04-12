/* MySQL */

/* 移除数据库 */
/* DROP DATABASE IF EXISTS hibernate; */
/* 创建数据库 */
/* CREATE DATABASE hibernate CHARACTER SET 'UTF8';    */
/* 使用数据库 */
/* USE hibernate;  */

/* one to one_01 */
/* 创建表 */
DROP TABLE IF EXISTS person_01;
CREATE TABLE person_01 (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '姓名',
	photoUrl varchar(255) COMMENT '证件照片url',
	gender varchar(15) COMMENT '性别 : UNKNOW(未知), MALE(男), FEMALE-(女)',
	nation varchar(32) COMMENT '民族',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '住址',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人信息表';

/* 添加数据 */
INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('徐明', null, 'MALE', '汉族', '1973-01-16', '广东省广州市天河区平云路11号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('王洁', null, 'FEMALE', '回族', '1987-02-18', '新疆自治区乌鲁木齐市五山区天长路22号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('邝边', null, 'UNKNOW', '壮族', '1983-04-15', '广西省玉林市玉山区广平路13号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('刘雨', null, 'FEMALE', '汉族', '1980-12-13', '江西省上饶市天水区青山路19号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('赵备', null, 'UNKNOW', '汉族', '1992-12-31', '广东省广州市越秀区清水路17号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('卡扎尔-龙华', null, 'MALE', '臧族', '1979-08-11', '西藏自治区拉萨市东口区江北路24号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('牛芳', null, 'FEMALE', '汉族', '1968-01-18', '江苏省苏州市苏南区南江路89号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('伊尔民', null, 'UNKNOW', '臧族', '1980-03-19', '云南省省昆明市昆山区海平路46号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('沙尔塔', null, 'FEMALE', '维吾尔族', '1976-09-08', '陕西省西安市汉水区西北路104号');

INSERT INTO person_01 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('郑飞', null, 'MALE', '壮族', '1984-02-05', '四川省成都市天都区天府路463号');


/* 创建表 */
DROP TABLE IF EXISTS idCard_01;
CREATE TABLE idCard_01 (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	title varchar(32) COMMENT '身份证标题, 例如 : 中华人民共和国 - 居民身份证',
	cardNo varchar(64) COMMENT '身份证号',
	issuingAuthority varchar(32) COMMENT '签发机关 (Xx市公安局)',
	effectiveDate datetime COMMENT '生效日期 yyyy-MM-dd',
	expiryDate datetime COMMENT '失效日期 yyyy-MM-dd',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证表';


INSERT INTO idCard_01 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '55122519730503881X', '上海市公安局', '2000-01-02', '2010-01-02');
INSERT INTO idCard_01 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '65122519860503886X', '杭州市公安局', '2011-03-02', '2021-03-02');
INSERT INTO idCard_01 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '25122519890503883X', '湛江市公安局', '1993-11-05', '2003-11-05');
INSERT INTO idCard_01 (title, cardNo, issuingAuthority, effectiveDate, expiryDate,) 
VALUES ('中华人民共和国 - 居民身份证', '14122519870503882X', '无锡市公安局', '2002-06-02', '2012-06-02');
INSERT INTO idCard_01 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '88122519860503881X', '天津市公安局', '2014-01-07', '2024-01-07');
INSERT INTO idCard_01 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '40122519960503887X', '深圳市公安局', '2013-01-02', '2023-01-02');

/* one to one_02 */
/* 创建表 */
DROP TABLE IF EXISTS person_02;
CREATE TABLE person_02 (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '姓名',
	photoUrl varchar(255) COMMENT '证件照片url',
	gender varchar(15) COMMENT '性别 : UNKNOW(未知), MALE(男), FEMALE-(女)',
	nation varchar(32) COMMENT '民族',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '住址',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人信息表';

/* 添加数据 */
INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('徐明', null, 'MALE', '汉族', '1973-01-16', '广东省广州市天河区平云路11号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('王洁', null, 'FEMALE', '回族', '1987-02-18', '新疆自治区乌鲁木齐市五山区天长路22号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('邝边', null, 'UNKNOW', '壮族', '1983-04-15', '广西省玉林市玉山区广平路13号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('刘雨', null, 'FEMALE', '汉族', '1980-12-13', '江西省上饶市天水区青山路19号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('赵备', null, 'UNKNOW', '汉族', '1992-12-31', '广东省广州市越秀区清水路17号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('卡扎尔-龙华', null, 'MALE', '臧族', '1979-08-11', '西藏自治区拉萨市东口区江北路24号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('牛芳', null, 'FEMALE', '汉族', '1968-01-18', '江苏省苏州市苏南区南江路89号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('伊尔民', null, 'UNKNOW', '臧族', '1980-03-19', '云南省省昆明市昆山区海平路46号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('沙尔塔', null, 'FEMALE', '维吾尔族', '1976-09-08', '陕西省西安市汉水区西北路104号');

INSERT INTO person_02 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('郑飞', null, 'MALE', '壮族', '1984-02-05', '四川省成都市天都区天府路463号');


/* 创建表 */
DROP TABLE IF EXISTS idCard_02;
CREATE TABLE idCard_02 (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	title varchar(32) COMMENT '身份证标题, 例如 : 中华人民共和国 - 居民身份证',
	cardNo varchar(64) COMMENT '身份证号',
	issuingAuthority varchar(32) COMMENT '签发机关 (Xx市公安局)',
	effectiveDate datetime COMMENT '生效日期 yyyy-MM-dd',
	expiryDate datetime COMMENT '失效日期 yyyy-MM-dd',
	personId int(11) COMMENT '身份证持有者的id',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证表';


INSERT INTO idCard_02 (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '55122519730503881X', '上海市公安局', '2000-01-02', '2010-01-02', 1);
INSERT INTO idCard_02 (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '65122519860503886X', '杭州市公安局', '2011-03-02', '2021-03-02', 2);
INSERT INTO idCard_02 (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '25122519890503883X', '湛江市公安局', '1993-11-05', '2003-11-05', 3);
INSERT INTO idCard_02 (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '14122519870503882X', '无锡市公安局', '2002-06-02', '2012-06-02', 4);
INSERT INTO idCard_02 (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '88122519860503881X', '天津市公安局', '2014-01-07', '2024-01-07', 5);
INSERT INTO idCard_02 (title, cardNo, issuingAuthority, effectiveDate, expiryDate, personId) 
VALUES ('中华人民共和国 - 居民身份证', '40122519960503887X', '深圳市公安局', '2013-01-02', '2023-01-02', 6);

 

 /* one to one_03 */
 /* 创建表 */
DROP TABLE IF EXISTS person_03;
CREATE TABLE person_03 (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '姓名',
	photoUrl varchar(255) COMMENT '证件照片url',
	gender varchar(15) COMMENT '性别 : UNKNOW(未知), MALE(男), FEMALE-(女)',
	nation varchar(32) COMMENT '民族',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '住址',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人信息表';

/* 添加数据 */
INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('徐明', null, 'MALE', '汉族', '1973-01-16', '广东省广州市天河区平云路11号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('王洁', null, 'FEMALE', '回族', '1987-02-18', '新疆自治区乌鲁木齐市五山区天长路22号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('邝边', null, 'UNKNOW', '壮族', '1983-04-15', '广西省玉林市玉山区广平路13号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('刘雨', null, 'FEMALE', '汉族', '1980-12-13', '江西省上饶市天水区青山路19号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('赵备', null, 'UNKNOW', '汉族', '1992-12-31', '广东省广州市越秀区清水路17号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('卡扎尔-龙华', null, 'MALE', '臧族', '1979-08-11', '西藏自治区拉萨市东口区江北路24号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('牛芳', null, 'FEMALE', '汉族', '1968-01-18', '江苏省苏州市苏南区南江路89号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('伊尔民', null, 'UNKNOW', '臧族', '1980-03-19', '云南省省昆明市昆山区海平路46号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('沙尔塔', null, 'FEMALE', '维吾尔族', '1976-09-08', '陕西省西安市汉水区西北路104号');

INSERT INTO person_03 (name, photoUrl, gender, nation, birthday, address) 
VALUES ('郑飞', null, 'MALE', '壮族', '1984-02-05', '四川省成都市天都区天府路463号');


/* 创建表 */
DROP TABLE IF EXISTS idCard_03;
CREATE TABLE idCard_03 (
	id int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	title varchar(32) COMMENT '身份证标题, 例如 : 中华人民共和国 - 居民身份证',
	cardNo varchar(64) COMMENT '身份证号',
	issuingAuthority varchar(32) COMMENT '签发机关 (Xx市公安局)',
	effectiveDate datetime COMMENT '生效日期 yyyy-MM-dd',
	expiryDate datetime COMMENT '失效日期 yyyy-MM-dd',
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证表';


INSERT INTO idCard_03 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '55122519730503881X', '上海市公安局', '2000-01-02', '2010-01-02');
INSERT INTO idCard_03 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '65122519860503886X', '杭州市公安局', '2011-03-02', '2021-03-02');
INSERT INTO idCard_03 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '25122519890503883X', '湛江市公安局', '1993-11-05', '2003-11-05');
INSERT INTO idCard_03 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '14122519870503882X', '无锡市公安局', '2002-06-02', '2012-06-02');
INSERT INTO idCard_03 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '88122519860503881X', '天津市公安局', '2014-01-07', '2024-01-07');
INSERT INTO idCard_03 (title, cardNo, issuingAuthority, effectiveDate, expiryDate) 
VALUES ('中华人民共和国 - 居民身份证', '40122519960503887X', '深圳市公安局', '2013-01-02', '2023-01-02');

/* 第三种方式通过 中间表来建立关系， */
CREATE TABLE person_card (
	personId int not null,
	cardId int not null,
	PRIMARY KEY (personId, cardId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='身份证表';

/* 添加联合唯一性约束 */
 ALTER TABLE person_card ADD CONSTRAINT un_person_card UNIQUE (personId, cardId);
 
 
 

/* many to one */

/* 创建表 */
DROP TABLE IF EXISTS custom;
CREATE TABLE custom (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '客户姓名',
	balance numeric(9, 2) COMMENT '帐户余额',
	address varchar(255) COMMENT '客户状态 (0-无效, 1-未激活, 2-正常)',
	status numeric(2) COMMENT '地址',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

/* 添加数据 */
INSERT INTO custom (name, balance, status, address) VALUES ('徐明', 254.21, 1, '新疆自治区乌鲁木齐市五山区天长路22号');

INSERT INTO custom (name, balance, status, address) VALUES ('王洁', 6942.47, 0, '广东省广州市天河区平云路11号');

INSERT INTO custom (name, balance, status, address) VALUES ('邝边', 0.00, 2, '江西省上饶市天水区青山路19号');

INSERT INTO custom (name, balance, status, address) VALUES ('刘雨', 221.01, 1, '广西省玉林市玉山区广平路13号');

INSERT INTO custom (name, balance, status, address) VALUES ('赵备', 10.15, 2, '广东省广州市越秀区清水路17号');

INSERT INTO custom (name, balance, status, address) VALUES ('卡扎尔-龙华', 19.11, 2, '西藏自治区拉萨市东口区江北路24号');

INSERT INTO custom (name, balance, status, address) VALUES ('牛芳', 294.41, 0, '云南省省昆明市昆山区海平路46号');

INSERT INTO custom (name, balance, status, address) VALUES ('伊尔民', 358.71, 0, '江苏省苏州市苏南区南江路89号');

INSERT INTO custom (name, balance, status, address) VALUES ('沙尔塔', 124.01, 1, '四川省成都市天都区天府路463号');

INSERT INTO custom (name, balance, status, address) VALUES ('郑飞', 239.10, 1, '陕西省西安市汉水区西北路104号');


/* 创建表 */
DROP TABLE IF EXISTS item;
CREATE TABLE item (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) COMMENT '定单名称',
	orderTs timestamp COMMENT '下单时间戳 yyyy-MM-dd HH:mm:ss',
	monetary numeric(7, 2) COMMENT '消费金额',
	remark varchar(64) COMMENT '备注',
	customId numeric COMMENT '客户id',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/* 添加约束 */
ALTER TABLE item ADD CONSTRAINT fk_item_studentId FOREIGN KEY(id) REFERENCES custom(id);

/* many to many */

/* 若存在先删除 */
DROP TABLE IF EXISTS student;
/* 学生表 */
CREATE TABLE student (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) NOT NULL COMMENT '姓名',
	gender numeric(2) COMMENT '性别 : 0-未知, 1-男(male), 2-女(female)',
	credit numeric(5, 2) COMMENT '学分',
	birthday datetime COMMENT '出生日期 yyyy-MM-dd',
	address varchar(255) COMMENT '地址',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表';

/* 添加数据 */
INSERT INTO student (name, gender, credit, birthday, address) VALUES ('王菲', 2, 12.5, '1980-02-23', '浙江省杭州市东风路23号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('张国焘', 1, 34.4, '1979-01-29', '浙江省宁波市长龙路135号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('温峥嵘', 2, 11.0, '1983-10-01', '上海市浦东新区南埔路93号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('李丽', 2, 13.4, '1981-09-02', '上海市徐汇区南京路49号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('李建', 1, 21.8, '1989-02-04', '吉林省延吉市解放路189号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('王龙云', 1, 29.9, '1985-09-13', '吉林省长春市青年路243号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('欧阳震华', 1, 25.0, '1983-02-18', '广东省广州市体育西路935号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('程华', 2, 30.1, '1978-07-20', '广东省深圳市新田路路73号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('陈明', 0, 26.8, '1988-04-13', '广西省北海市长兴路路101号');

INSERT INTO student (name, gender, credit, birthday, address) VALUES ('何云', 0, 41.3, '1981-04-16', '广西省贵港市东平路321号');

/* 若存在先删除 */
DROP TABLE IF EXISTS course;
/* 课程表 */
CREATE TABLE course (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	name varchar(64) NOT NULL COMMENT '课程名称',
	credit numeric(5, 2) COMMENT '课程的学分',
	description varchar(128) COMMENT '课程描述',
	PRIMARY KEY (`id`)	
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

/* 添加数据 */
INSERT INTO course (name, credit, description) VALUES ('数学', 5.5, '大学数学课程');

INSERT INTO course (name, credit, description) VALUES ('语文', 3.5, '大学语文课程');

INSERT INTO course (name, credit, description) VALUES ('高等几何', 2.5, '大学高等几何课程');

INSERT INTO course (name, credit, description) VALUES ('线性代数', 1.5, '大学线性代数课程');

INSERT INTO course (name, credit, description) VALUES ('物理', 4.0, '大学物理课程');

/* student 和 course 关系关联表 (中间表) (many to many) */
DROP TABLE IF EXISTS student_course;
CREATE TABLE student_course (
	studentId int(11) COMMENT '学生id',
	courseId int(11) COMMENT '课程id',
	PRIMARY KEY (studentId,courseId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='student 和 course 关系关联表 (中间表)';

/* 联合唯一 union unique */
ALTER TABLE student_course ADD CONSTRAINT uu_student_course_courseId UNIQUE(studentId, courseId);


