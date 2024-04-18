package com.laptrinhjava.model;

import java.util.Date;

public class UserModel extends AbstractModel<UserModel> {

	private String userName;
	private String fullName;
	private String password;
	private String thumbnail;
	private int status;
	private Long roleid;
	private RoleModel role = new RoleModel();
	private String email;
	private String authentication;
	private Date time;
	private int statusAuthen;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getStatusAuthen() {
		return statusAuthen;
	}

	public void setStatusAuthen(int statusAuthen) {
		this.statusAuthen = statusAuthen;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", fullName=" + fullName + ", password=" + password + ", thumbnail="
				+ thumbnail + ", status=" + status + ", roleid=" + roleid + ", role=" + role + ", email=" + email
				+ ", authentication=" + authentication + ", time=" + time + ", statusAuthen=" + statusAuthen + "]";
	}

}
