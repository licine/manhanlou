-- 创建满汉楼数据库
CREATE DATABASE if not exists mhl;

-- 切换库
use mhl;

-- 创建表
-- 用户表 Employee 表（主键id，empId，name，pwd，job，。。。）
CREATE TABLE if not exists Employee(
                                       id INT PRIMARY KEY AUTO_INCREMENT,	# 自增
                                       empId VARCHAR(50) UNIQUE NOT NULL DEFAULT '',	# 员工号
    pwd char(32) NOT NULL DEFAULT '',	# 密码md5
    `name` VARCHAR(50) NOT NULL DEFAULT '',	# 姓名
    job VARCHAR(50) NOT NULL DEFAULT ''	# 岗位

    )CHARSET=utf8;

-- 添加测试数据
INSERT INTO Employee(empId,`name`,job) VALUES('1001','小一','经理');
INSERT INTO Employee(empId,`name`,job) VALUES('1002','小二','副经理');
INSERT INTO Employee(empId,`name`,job) VALUES('1003','小三','收银员');
INSERT INTO Employee(empId,`name`,job) VALUES('1004','小四','工程师');

-- 创建餐桌表 dinningTable（id，state，orderName，orderTel）
CREATE TABLE if not exists dinningTable(
                                           id int PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键',
                                           state VARCHAR(50) not null DEFAULT('') COMMENT '餐桌状态',
    orderName VARCHAR(50) not null DEFAULT('') COMMENT '预定人姓名',
    orderTel VARCHAR(11) not null DEFAULT('') COMMENT '预订人电话'
    ) CHARSET=utf8;

-- 添加测试数据
INSERT INTO dinningTable(state) VALUES('空');
INSERT INTO dinningTable(state) VALUES('空');
INSERT INTO dinningTable(state) VALUES('空');

-- 创建 menu 菜品表（id, name, type, price）
CREATE TABLE if not exists menu(
                                   id int PRIMARY KEY AUTO_INCREMENT COMMENT '主键自增',
                                   `name` VARCHAR(50) not null DEFAULT('') COMMENT '菜名',
    type VARCHAR(50) not null DEFAULT('') COMMENT '菜品类型',
    price DOUBLE NOT NULL DEFAULT(0) COMMENT '价格'
    )CHARSET=utf8;


-- 添加测试数据
insert into menu values(null, '八宝饭', '主食', 9);
insert into menu values(null, '叉烧包', '主食', 5);
insert into menu values(null, '宫保鸡丁', '热菜', 9);
insert into menu values(null, '山药拨鱼', '凉菜', 9);
insert into menu values(null, '银丝卷', '甜食', 9);
insert into menu values(null, '水煮鱼', '热菜', 9);
insert into menu values(null, '甲鱼汤', '汤类', 9);
insert into menu values(null, '鸡蛋汤', '汤类', 9);

-- bill 账单表（id, billId, menuId, nums, money, dinningTabkeId, billDate, state）
-- // 账单流水，考虑可以分开结账，并考虑将来分别统计各个不同菜品的销售情况
CREATE TABLE if not exists bill(
                                   id int primary key AUTO_INCREMENT comment '主键自增',
                                   billId varchar(50) unique not null DEFAULT '' comment '账单编号 可以按照自己的规则生成UUID',
    menuId int not null default 0 comment '菜品编号',
    nums int not null default 0 comment '份数',
    money double not null default 0 comment '金额',
    dinningTableId int not null default 0 comment '餐桌编号',
    billDate DATETIME not null default CURRENT_TIMESTAMP comment '订单日期',
    state varchar(50) not null default '' comment '状态 未结帐 已结账 挂单',
    foreign key (menuId) references menu(id),
    foreign key (dinningTableId) references dinningtable(id)
    )charset=utf8;

-- 登录表 （id, empId, pwd）
CREATE table if not EXISTS login(
                                    id int primary key AUTO_INCREMENT,
                                    empId varchar(50) unique not null DEFAULT(0) COMMENT '员工号',
    pwd varchar(50) not null DEFAULT('') comment '密码',
    foreign key (empId) references employee(empId)
    )charset=utf8;

-- 添加测试数据
insert INTO login VALUES(null, '1001', md5('123'));
insert INTO login VALUES(null, '1002', md5('123'));
insert INTO login VALUES(null, '1003', md5('123'));
insert INTO login VALUES(null, '1004', md5('123'));
