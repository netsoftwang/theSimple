package com.palace.seeds.model;

/*DROP TABLE IF EXISTS seeds.cusField;
CREATE TABLE seeds.cusField(
id  BIGINT UNSIGNED NOT NULL auto_increment COMMENT '主键id',
entId BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '改字段所属企业',
name VARCHAR(32) NOT NULL COMMENT '字段在列中显示的中文名称',
field VARCHAR(32) NOT NULL COMMENT '在数据库中保存的字段名称',
type VARCHAR (32) NOT NULL DEFAULT 'strType' COMMENT '字段类型',
tableName VARCHAR(32) NOT NULL COMMENT '表名称',
viewNum TINYINT  DEFAULT 0 COMMENT '该字段在列表中显示的顺序',
status TINYINT DEFAULT 0 COMMENT '字段的状态，0：再用，1：关闭，',
isShow  TINYINT DEFAULT 1 COMMENT '是否在列表中显示',
width TINYINT  DEFAULT 0 COMMENT '改字段在列表中显示的宽度',
isUse TINYINT DEFAULT 1 COMMENT '是否在用',
isSearch TINYINT DEFAULT 0 COMMENT '该字段是否用于搜索,0：关闭，1：启用',
searchGroupId BIGINT UNSIGNED DEFAULT 0 COMMENT '如果该字段可以用来搜索，且属于一个搜索组，则字段表示搜索组id',
isMutiValSearch TINYINT DEFAULT 0 COMMENT '是否开启多值搜索，即搜索时是否出入多个值,如果开启有三个值，则参数形式 field1="val1",field2="val2",0：关闭，1：启用',
regexpForm VARCHAR(125) DEFAULT '' COMMENT '改字段的正则表达式',
viewNumForm TINYINT DEFAULT 0 COMMENT '该字段在编辑框中显示的顺序',
isShowForm TINYINT DEFAULT 1 COMMENT '是否在表单中显示0：关闭，1：开启',
isEditForm TINYINT DEFAULT 1 COMMENT '在表单中是否可以编辑0:关闭，1：开启',
formTypeForm VARCHAR(32) DEFAULT 'text' COMMENT '表单类型',
groupIdFormId	BIGINT UNSIGNED DEFAULT 0 COMMENT '在表单中如果进行分组的话，表示本字段所属的组',
optionKV VARCHAR(32) DEFAULT '' COMMENT '如果该字段是下拉列表，则改列代表下拉列表中的值,参数形式为：key1:val1,key2:val2',
theClass  VARCHAR(32) DEFAULT '' COMMENT '显示的样式',
func VARCHAR(32) DEFAULT '' COMMENT '该字段的函数处理',
action VARCHAR(64) DEFAULT '' COMMENT '权限控制代码',
createTime int DEFAULT 0 COMMENT '创建时间',
PRIMARY KEY (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 auto_increment=1;*/
public class CusField {

	private Long id;
	private Long entId;
	private String name;
	private String field;
	private String type;
	private String tableName;
	private Integer viewNum;
	private Integer status;
	private Integer isUse;
	private Integer isShow;
	private Integer width;
	private Integer isSearch;
	private Long searchGroupId;
	private Integer isMutiValSearch;
	private String regexpForm;
	private Integer viewNumForm;
	private Integer isShowForm;
	private Integer isEditForm;
	private String formTypeForm;
	private Long groupIdFormId;
	private String optionKV;
	private String  theClass;
	private String func;
	private String action;
	private Long createTime;
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
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getIsUse() {
		return isUse;
	}
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getIsSearch() {
		return isSearch;
	}
	public void setIsSearch(Integer isSearch) {
		this.isSearch = isSearch;
	}
	public Long getSearchGroupId() {
		return searchGroupId;
	}
	public void setSearchGroupId(Long searchGroupId) {
		this.searchGroupId = searchGroupId;
	}
	public Integer getIsMutiValSearch() {
		return isMutiValSearch;
	}
	public void setIsMutiValSearch(Integer isMutiValSearch) {
		this.isMutiValSearch = isMutiValSearch;
	}
	public String getRegexpForm() {
		return regexpForm;
	}
	public void setRegexpForm(String regexpForm) {
		this.regexpForm = regexpForm;
	}
	public Integer getViewNumForm() {
		return viewNumForm;
	}
	public void setViewNumForm(Integer viewNumForm) {
		this.viewNumForm = viewNumForm;
	}
	public Integer getIsShowForm() {
		return isShowForm;
	}
	public void setIsShowForm(Integer isShowForm) {
		this.isShowForm = isShowForm;
	}
	public Integer getIsEditForm() {
		return isEditForm;
	}
	public void setIsEditForm(Integer isEditForm) {
		this.isEditForm = isEditForm;
	}
	public String getFormTypeForm() {
		return formTypeForm;
	}
	public void setFormTypeForm(String formTypeForm) {
		this.formTypeForm = formTypeForm;
	}
	public Long getGroupIdFormId() {
		return groupIdFormId;
	}
	public void setGroupIdFormId(Long groupIdFormId) {
		this.groupIdFormId = groupIdFormId;
	}
	public String getOptionKV() {
		return optionKV;
	}
	public void setOptionKV(String optionKV) {
		this.optionKV = optionKV;
	}
	public String getTheClass() {
		return theClass;
	}
	public void setTheClass(String theClass) {
		this.theClass = theClass;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	
 
	
}
