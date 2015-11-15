package com.palace.seeds.model;

public class TreeNode {
	public static final String treeNode_Node_Key="nodeKey";
	public static final String treeNode_Node_Child_Key="nodeChildKey";
	public static final String treeNode_Node_AttrList_Key="nodeAttrListKey";
	
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
