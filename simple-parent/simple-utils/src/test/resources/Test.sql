DROP DATABASE IF EXISTS `nlsm`;
CREATE DATABASE `nlsm` default character set `utf8` COLLATE `utf8_general_ci`;
USE `nlsm`;
 
 
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` int NOT NULL auto_increment,
  `province` varchar(64) NOT NULL COMMENT '省/直辖市名称',
  `pcode` varchar(24) NOT NULL COMMENT '省/直辖市编码,例如北京市518000',
  `city` varchar(64) NOT NULL COMMENT '',
  `ccode` varchar(24) NOT NULL COMMENT '',
  `district` varchar(64) NOT NULL COMMENT '',
  `dcode` varchar(12) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

 

DROP TABLE IF EXISTS `nodeInfo`;
CREATE TABLE `nodeInfo` (
  `id` int NOT NULL auto_increment,
  `uuid` varchar(48),
  `websitedomainname` varchar(128) COMMENT '网站域名',
  `x` decimal(12,6) DEFAULT 0.0 COMMENT '经度',
  `y` decimal(12,6) DEFAULT 0.0 COMMENT '纬度',
  `code` varchar(24) DEFAULT '' COMMENT '网站所在地编码 ',
  `netaddress` varchar(128) DEFAULT '' COMMENT '网站位置',
  `institution` varchar(128) NOT NULL COMMENT '所属单位名称',
  `devicenum` int DEFAULT 0 COMMENT '设备数量',
  `principal` varchar(50) DEFAULT NULL COMMENT '责任人',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `linkstatus` int DEFAULT '0' COMMENT '链接状态 0:链接 1:失联',
  `type` int default 0 COMMENT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
DROP TABLE IF EXISTS `platInfo`;
CREATE TABLE `platInfo` (
  `id` int NOT NULL auto_increment,
  `platMac` varchar(48) not null comment '',
  `nodeInfoId` int COMMENT '所属单位',
  `org` int not null comment 'orgid',
  `serverName` varchar(128) comment'自定义名称',
  `platName` varchar(64) comment'平台名称',
  `sysName` varchar(64) comment '系统名称',
  `sysType` varchar(32) comment '系统类型',
  `ip`        varchar(17) comment 'ip',
  `status` varchar(4) DEFAULT '00' COMMENT '第一位 平台运行状态 0：初始 1：调试 2：运行；第二位 1：链接 2：断开',
  index     `platMac_index`(`platMac`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 

DROP TABLE IF EXISTS `processControlStat`;
CREATE TABLE `processControlStat` (
  `id` int NOT NULL auto_increment,
  `platMac` varchar(52) NOT NULL COMMENT '客户端标识',
  `riskLevelLow` int NOT NULL  DEFAULT 0 COMMENT '低风险',
  `riskLevelMidd` int NOT NULL DEFAULT 0 COMMENT '中风险',
  `riskLevelHigh` int NOT NULL DEFAULT 0 COMMENT '高风险',
  `signResSucc` int NOT NULL DEFAULT 0 COMMENT '验签成功',
  `signResError`  int NOT NULL DEFAULT 0 COMMENT '验签失败',
  `operationSucc`  int NOT NULL DEFAULT 0 COMMENT '操作成功',
  `operationError`  int NOT NULL DEFAULT 0 COMMENT '操作失败',
  `count`  int NOT NULL DEFAULT 0 COMMENT '记录总数',
  `bTime`  int NOT NULL DEFAULT 0 COMMENT '记录时间',
  `bDay`   int not null default 0 ,
  PRIMARY KEY (`id`),
  index `platMac_index`(`platMac`),
  index `bDay_index`(`bDay`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
DROP TABLE IF EXISTS `processControl`;
CREATE TABLE `processControl` (
  `id` int NOT NULL auto_increment,
  `logType` int comment '日志类型',
  `platMac` varchar(52) NOT NULL COMMENT '客户端标识',
  `fatherPro`  varchar(1024) COMMENT '父进程',
  `subPro` varchar(1024) COMMENT '子进程',
  `dwchecksum` varchar(128) COMMENT 'sum',
  `riskLevel` int COMMENT '风险等级',
  `illegalProgram`  varchar(1024) COMMENT '不合法程序',
  `fileSize`  int  COMMENT '文件大小',
  `signCompany`  varchar(256) COMMENT '验签公司',
  `signCheck`  int  COMMENT '验签结果',
  `happendTime`  int  COMMENT '记录时间',
  `operationRes` int COMMENT '操作结果',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
 
DROP TABLE IF EXISTS `fileAccessStat`;
CREATE TABLE `fileAccessStat` (
  `id` int NOT NULL auto_increment,
  `platMac` varchar(52) NOT NULL COMMENT '客户端标识',
  `riskLevelLow` int NOT NULL  DEFAULT 0 COMMENT '低风险',
  `riskLevelMidd` int NOT NULL DEFAULT 0 COMMENT '中风险',
  `riskLevelHigh` int NOT NULL DEFAULT 0 COMMENT '高风险',
  `signResSucc` int NOT NULL DEFAULT 0 COMMENT '验签成功',
  `signResError`  int NOT NULL DEFAULT 0 COMMENT '验签失败',
  `operationSucc`  int NOT NULL DEFAULT 0 COMMENT '操作成功',
  `operationError`  int NOT NULL DEFAULT 0 COMMENT '操作失败',
  `count`  int NOT NULL DEFAULT 0 COMMENT '记录总数',
  `bTime`  int NOT NULL DEFAULT 0 COMMENT '记录时间',
   `bDay`   int not null default 0 ,
  PRIMARY KEY (`id`),
  index `platMac_index`(`platMac`),
  index `bDay_index`(`bDay`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
DROP TABLE IF EXISTS `fileAccess`;
CREATE TABLE `fileAccess` (
  `id` int NOT NULL auto_increment,
  `logType` int comment '日志类型',
  `platMac` varchar(52) NOT NULL COMMENT '客户端标识',
  `riskLevel` int COMMENT '风险等级',
  `protectedFile` varchar(1024) comment'受保护文件',
  `illegalProgram`  varchar(1024) COMMENT '不合法程序',
  `fileSize`  int  COMMENT '文件大小',
  `signCompany`  varchar(256) COMMENT '验签公司',
  `signCheck`  int  COMMENT '验签结果',
  `happendTime`  int  COMMENT '记录时间',
  `operationRes` int COMMENT'操作结果',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
 
DROP TABLE IF EXISTS `userLoginStat`;
CREATE TABLE `userLoginStat` (
  `id` int NOT NULL auto_increment,
  `platMac` varchar(52) NOT NULL COMMENT '客户端标识',
  `operationSucc`  int NOT NULL DEFAULT 0 COMMENT '操作成功',
  `operationError`  int NOT NULL DEFAULT 0 COMMENT '操作失败',
  `count`  int NOT NULL DEFAULT 0 COMMENT '记录总数',
  `bTime`  int NOT NULL DEFAULT 0 COMMENT '记录时间',
  `bDay`   int not null default 0 ,
  PRIMARY KEY (`id`),
  index `platMac_index`(`platMac`),
  index `bDay_index`(`bDay`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
DROP TABLE IF EXISTS `userLogin`;
CREATE TABLE `userLogin` (
  `id` int NOT NULL auto_increment,
  `logType` int comment '日志类型',
  `platMac` varchar(52) NOT NULL COMMENT '客户端标识',
  `platName` varchar(128) COMMENT '平台名称',
  `userName` varchar(256) comment'用户名称',
  `clientIp` varchar(48) COMMENT '客户端ip',
  `protectedFile` varchar(1024) comment'受保护文件',
  `illegalProgram`  varchar(1024) COMMENT '不合法程序',
  `fileSize`  int  COMMENT '文件大小',
  `signCompany`  varchar(256) COMMENT '验签公司',
  `result`  int  COMMENT '登录结果',
  `happendTime`  int  COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
 
DROP TABLE IF EXISTS `nodeInfoStat`;
CREATE TABLE `nodeInfoStat` (
  `id` int NOT NULL auto_increment,
  `nodeId` int not null COMMENT '节点id',
  `riskLevelLow` int NOT NULL  DEFAULT 0 COMMENT '低风险',
  `riskLevelMidd` int NOT NULL DEFAULT 0 COMMENT '中风险',
  `riskLevelHigh` int NOT NULL DEFAULT 0 COMMENT '高风险',
  `signResSucc` int NOT NULL DEFAULT 0 COMMENT '验签成功',
  `signResError`  int NOT NULL DEFAULT 0 COMMENT '验签失败',
  `operationSucc`  int NOT NULL DEFAULT 0 COMMENT '操作成功',
  `operationError`  int NOT NULL DEFAULT 0 COMMENT '操作失败',
  `count`  int NOT NULL DEFAULT 0 COMMENT '记录总数',
  `bTime`  int NOT NULL DEFAULT 0 COMMENT '记录时间',
  `bDay`   int not null default 0 ,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `conf`;
CREATE TABLE `conf` (
  `id`         int NOT NULL auto_increment,
  `red`     int  NOT NULL comment '风险等级高',
  `yellow`     int  NOT NULL comment '风险等级中',
  `blue`     int  NOT NULL comment '风险等级低',
  `min`     int  not null ,
  `max`     int  not null,
  `lostlinkTime` int(11) DEFAULT 10 COMMENT '默认失联时长(分钟)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
insert into conf(red,yellow,blue,max,min) values(600,400,200,600,0);
 
 