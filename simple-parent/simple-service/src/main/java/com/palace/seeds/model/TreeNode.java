package com.palace.seeds.model;

public class TreeNode {

	/*
	drop table if exists seeds.treeNodeCusField;
	create table `treeNodeCusField`(
	    `id` bigint unsigned not null auto_increment comment '主键',
		`entId` BIGINT unsigned not null 	comment '企业id',
		`parentId` BIGINT unsigned not null comment '父id',
		`name` VARCHAR(32) NOT NULL COMMENT '字段在列中显示的中文名称',
		`field` VARCHAR(32) NOT NULL COMMENT '在数据库中保存的字段名称',
		`type` VARCHAR (32) NOT NULL DEFAULT 'strType' COMMENT '字段类型',
		`status` TINYINT DEFAULT 0 COMMENT '字段的状态，0：再用，1：关闭，',
		`theClass`  VARCHAR(32) DEFAULT '' COMMENT '显示的样式',
		`url` varchar(1024) DEFAULT '' ,
		`icon` VARCHAR(64) DEFAULT '' COMMENT 'icon',
		`action` VARCHAR(64) DEFAULT '' COMMENT '权限控制代码',
		`isHasChild` TINYINT DEFALUT 0 COMMENT '是否含有子节点，0没有，1含有',
		`left`  int,
		`right` int,
		
		`tableName` VARCHAR(32) NOT NULL COMMENT '子节点表名称',
		`condition` VARCHAR(256) DEFAULT '' COMMENT '子节点加载条件',
		
		`createTime` int DEFAULT 0 COMMENT '创建时间',
		primary key (id)
	)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;

	*/
		private Long id;
		private Long entId;
		//当前节点
		private Long parentId;
		private String name;
		private String field;
		private String type;
		private Integer status;
		private String theClass;
		private String url;
		private String icon;
		private String action;//节点权限
		private boolean isHasChild;//是否含有子节点
		private Integer left;
		private Integer right;
		
		//加载子节点
		private String tableName;//从哪个表加载子节点
		private String condition;//加载条件
		private String childType;//子节点类型
		
		private Integer createTime;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getEntId() {
			return entId;
		}

		public void setEntId(Long entId) {
			this.entId = entId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getTheClass() {
			return theClass;
		}

		public void setTheClass(String theClass) {
			this.theClass = theClass;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getAction() {
			return action;
		}

		public void setAction(String action) {
			this.action = action;
		}
		
		public boolean isHasChild() {
			return isHasChild;
		}

		public void setHasChild(boolean isHasChild) {
			this.isHasChild = isHasChild;
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public String getChildType() {
			return childType;
		}

		public void setChildType(String childType) {
			this.childType = childType;
		}

		public Integer getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Integer createTime) {
			this.createTime = createTime;
		}

		public Long getParentId() {
			return parentId;
		}

		public void setParentId(Long parentId) {
			this.parentId = parentId;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public Integer getLeft() {
			return left;
		}

		public void setLeft(Integer left) {
			this.left = left;
		}

		public Integer getRight() {
			return right;
		}

		public void setRight(Integer right) {
			this.right = right;
		}
		
		
}
