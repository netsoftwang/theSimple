package com.palace.seeds.model;


/*`id` bigint unsigned not null auto_increment comment '主键',
`entId` bigint unsigned not null comment '企业id',
`tableName` varchar(64) commment '表名称',
`tableNameZh` varchar(64) comment '表中文名称',
`type` tinyint comment '表类型值,0为普通表，1为树类型表',
`status` tinyint comment '状态值,0再用,1冻结',
`associate` varchar(64) comment '关联存储表名称',
primary key (id)*/
public class Tables {

	private Long id;
	private Long entId;
	private String tableName;
	private String tableNameZh;
	private Integer type;
	private Integer status;
	private String associate;
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
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableNameZh() {
		return tableNameZh;
	}
	public void setTableNameZh(String tableNameZh) {
		this.tableNameZh = tableNameZh;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAssociate() {
		return associate;
	}
	public void setAssociate(String associate) {
		this.associate = associate;
	}
 
	
	
}
