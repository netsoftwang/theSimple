package com.palace.seeds.model;

public class User {
	private Long id;
	private Long entId;
	private String logonId;
	private String pwd;
	private String userName;
	private String userNameZh;
	private Long logonTime;
	private Role role;
	private String serial;
	
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getLogonId() {
		return logonId;
	}
	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getEntId() {
		return entId;
	}
	public void setEntId(Long entId) {
		this.entId = entId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNameZh() {
		return userNameZh;
	}
	public void setUserNameZh(String userNameZh) {
		this.userNameZh = userNameZh;
	}
	public Long getLogonTime() {
		return logonTime;
	}
	public void setLogonTime(Long logonTime) {
		this.logonTime = logonTime;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	
}
