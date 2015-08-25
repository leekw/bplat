package com.pp.bplat.common.domain;

public class User extends Common {

    private static final long serialVersionUID = 4376521560491457021L;
    private String userId;
	private String userName;
	private String userTypeCode;
	private String userStatusCode;
	private String userPosOrgId;
	private String userPosOrgName;
	private String activeYn;
	private String telNo;
	private String address;
	private String email;
	private String userOwnOrgId;
	private String userOwnOrgName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTypeCode() {
		return userTypeCode;
	}
	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}
	public String getUserStatusCode() {
		return userStatusCode;
	}
	public void setUserStatusCode(String userStatusCode) {
		this.userStatusCode = userStatusCode;
	}
	public String getUserPosOrgId() {
		return userPosOrgId;
	}
	public void setUserPosOrgId(String userPosOrgId) {
		this.userPosOrgId = userPosOrgId;
	}
	public String getUserPosOrgName() {
		return userPosOrgName;
	}
	public void setUserPosOrgName(String userPosOrgName) {
		this.userPosOrgName = userPosOrgName;
	}
	public String getActiveYn() {
		return activeYn;
	}
	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserOwnOrgId() {
		return userOwnOrgId;
	}
	public void setUserOwnOrgId(String userOwnOrgId) {
		this.userOwnOrgId = userOwnOrgId;
	}
	public String getUserOwnOrgName() {
		return userOwnOrgName;
	}
	public void setUserOwnOrgName(String userOwnOrgName) {
		this.userOwnOrgName = userOwnOrgName;
	}
	

}