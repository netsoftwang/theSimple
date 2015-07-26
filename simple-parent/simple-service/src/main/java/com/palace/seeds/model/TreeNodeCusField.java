package com.palace.seeds.model;


/*	`id` bigint not unsigned not null auto_increment '主键',
	`entId` bigint unsigned not null comment '企业id',
	`name` VARCHAR(32) NOT NULL COMMENT '字段在列中显示的中文名称',
	`field` VARCHAR(32) NOT NULL COMMENT '在数据库中保存的字段名称',
	`type` VARCHAR (32) NOT NULL DEFAULT 'strType' COMMENT '字段类型',
	`tableName` VARCHAR(32) NOT NULL COMMENT '表名称',
	`status` TINYINT DEFAULT 0 COMMENT '字段的状态，0：再用，1：关闭，',
	`theClass`  VARCHAR(32) DEFAULT '' COMMENT '显示的样式',
	`funcs` VARCHAR(32) DEFAULT '' COMMENT '该字段的函数处理',
	`action` VARCHAR(64) DEFAULT '' COMMENT '权限控制代码',
	`createTime` int DEFAULT 0 COMMENT '创建时间',*/
public class TreeNodeCusField {

	private Long id;
	private Long entId;
	private String name;
	private String field;
	private String type;
	private String tableName;
	private Integer status;
	private String theClass;
	private String funcs;
	private String action;
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
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
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
	public String getFuncs() {
		return funcs;
	}
	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	
	
}
