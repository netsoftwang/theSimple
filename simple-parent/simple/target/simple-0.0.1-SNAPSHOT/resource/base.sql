DROP TABLE IF EXISTS seeds.cusField;
CREATE TABLE seeds.cusField(
id  BIGINT UNSIGNED NOT NULL auto_increment COMMENT '主键id',
entId BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '改字段所属企业',
name VARCHAR(32) NOT NULL COMMENT '字段在列中显示的中文名称',
field VARCHAR(32) NOT NULL COMMENT '在数据库中保存的字段名称',
CFType VARCHAR (32) NOT NULL DEFAULT 'strType' COMMENT '字段类型',
CFTableName VARCHAR(32) NOT NULL COMMENT '表名称',
viewNum TINYINT  DEFAULT 0 COMMENT '该字段在列表中显示的顺序',
CFStatus TINYINT DEFAULT 0 COMMENT '字段的状态，0：再用，1：关闭，',
isShow  TINYINT DEFAULT 1 COMMENT '是否在列表中显示',
CFWidth TINYINT  DEFAULT 0 COMMENT '改字段在列表中显示的宽度',
inFormType VARCHAR(20) COMMENT'该字段的在编辑框中的类型，如textbox,numberbox, combox',
isUse TINYINT DEFAULT 1 COMMENT '是否在用',
isSearch TINYINT DEFAULT 0 COMMENT '该字段是否用于搜索,0：关闭，1：启用',
isMutiValSearch TINYINT DEFAULT 0 COMMENT '是否开启多值搜索，即搜索时是否出入多个值,如果开启有三个值，则参数形式 field1="val1",field2="val2",0：关闭，1：启用',
regexpForm VARCHAR(125) DEFAULT '' COMMENT '改字段的正则表达式',
searchType varchar(10) DEFAULT 'and' COMMENT '如果用于条件搜索是and还是or',
optionKV VARCHAR(32) DEFAULT '' COMMENT '如果该字段是下拉列表，则改列代表下拉列表中的值,参数形式为：key1:val1,key2:val2',
action VARCHAR(64) DEFAULT '' COMMENT '权限控制代码',
createTime int DEFAULT 0 COMMENT '创建时间',
PRIMARY KEY (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;

-- ------------------------------------------------------------
-- viewNumForm TINYINT DEFAULT 0 COMMENT '该字段在编辑框中显示的顺序',
-- isShowForm TINYINT DEFAULT 1 COMMENT '是否在表单中显示0：关闭，1：开启',
-- isEditForm TINYINT DEFAULT 1 COMMENT '在表单中是否可以编辑0:关闭，1：开启',
-- theClass  VARCHAR(32) DEFAULT '' COMMENT '显示的样式',
-- formTypeForm VARCHAR(32) DEFAULT 'text' COMMENT '表单类型',
-- groupIdFormId	BIGINT UNSIGNED DEFAULT 0 COMMENT '在表单中如果进行分组的话，表示本字段所属的组',
-- funcs VARCHAR(32) DEFAULT '' COMMENT '该字段的函数处理',
-- ------------------------------------------------------------
DROP TABLE if EXISTS seeds.treeNode;
create TABLE `treeNode`(
`id` bigint unsigned NOT NULL auto_increment COMMENT'主键',
`entId` bigint unsigned not null comment'企业id',
`uniquId` bigint unsigned not null  COMMENT '类型描述',
`parentId` bigint unsigned  COMMENT '上级节点',
`type` TINYINT NOT NULL DEFAULT 0 COMMENT '节点的类型',
`name` VARCHAR(32) COMMENT '名称',
`icon` VARCHAR(32) default '' COMMENT '图标',
`action` VARCHAR(32) COMMENT '权限',
`url` VARCHAR(255) COMMENT '关联地址',
`left` INT COMMENT '左值',
`right` INT COMMENT '右值',
PRIMARY KEY (id) 
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;

DROP TABLE if EXISTS seeds.tree;
create TABLE `tree`(
`id` bigint unsigned NOT NULL auto_increment COMMENT'主键',
`entId` bigint unsigned NOT NULL COMMENT '企业id',
`label` VARCHAR(32) COMMENT'显示名称',
`name` varchar(32) COMMENT '字段名称',
`des` varchar(128) COMMENT '描述',
PRIMARY KEY (id) 
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;


drop table if exists seeds.creadential;
create table `creadential`(
	`id` bigint unsigned not null auto_increment comment '主键',
	`logonId` varchar(32) not null unique comment'登录id',
	`password` varchar(128) not null comment'密码',
	`status` tinyint default 0 comment'状态',
	`createTime` int(11) comment'创建时间',
	primary key (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;

drop table if exists `seeds.action`;
create table `action`(
	`id` bigint unsigned not null auto_increment comment '主键',
	`entId` BIGINT unsigned not null 	comment '企业id',
	`actionVal` varchar(64) comment '权限代码',
	`actionGroup` varchar(32) comment '权限组',
	primary key (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;

drop table if exists seeds.role;
create table `role`(
	`id` bigint unsigned not null auto_increment comment '主键',
	`entId` BIGINT unsigned not null 	comment '企业id',
	`actionId` BIGINT unsigned comment '权限id',
	`userId` BIGINT unsigned comment '用户id',
	primary key (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;


drop table if exists seeds.treeNodeCusField;
create table `treeNodeCusField`(
`id` bigint unsigned not null auto_increment comment '主键',
	`entId` BIGINT unsigned not null 	comment '企业id',
	`name` VARCHAR(32) NOT NULL COMMENT '字段在列中显示的中文名称',
	`field` VARCHAR(32) NOT NULL COMMENT '在数据库中保存的字段名称',
	`type` VARCHAR (32) NOT NULL DEFAULT 'strType' COMMENT '字段类型',
	`tableName` VARCHAR(32) NOT NULL COMMENT '表名称',
	`status` TINYINT DEFAULT 0 COMMENT '字段的状态，0：再用，1：关闭，',
	`theClass`  VARCHAR(32) DEFAULT '' COMMENT '显示的样式',
	`funcs` VARCHAR(32) DEFAULT '' COMMENT '该字段的函数处理',
	`action` VARCHAR(64) DEFAULT '' COMMENT '权限控制代码',
	`createTime` int DEFAULT 0 COMMENT '创建时间',
	primary key (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;


/*定制表的表名称*/
drop table if exists seeds.tables;
create table `tables`(
	`id` bigint unsigned not null auto_increment comment '主键',
	`entId` bigint unsigned not null comment '企业id',
	`tableNameCF` varchar(64) comment '表名称',
	`tableNameZh` varchar(64) comment '表中文名称',
	`type` tinyint comment '表类型值,0为普通表，1为树类型表',
	`status` tinyint comment '状态值,0再用,1冻结',
	`associate` varchar(64) comment '关联存储表名称',
	primary key (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;

/*视图名称*/
drop table if exists seeds.viewTable;
create table `viewTable`(
`id` bigint unsigned not null auto_increment ,
`entId` bigint unsigned not null ,
`viewName` varchar(45) not null comment'视图名称',
`cusFieldId` bigint unsigned not null comment '地址字段的id'
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;


/*mysql测试*/
drop table if exists seeds.recordMsg;
create table `recordMsg`(
`id` bigint unsigned not null auto_increment comment '主键',
`uuid` varchar(32) comment 'uuid',
`age` bigint,
`count` BIGINT,
`add` varchar(32),
`text` varchar(1024) comment 'text',
`msg` varchar(1024) comment '文本信息',
`createTime` int comment'创建时间',
`updateTime` int comment '更新时间',
PRIMARY key (id)
)engine=innodb default charset=utf8 auto_increment=1;
