package com.pp.bplat.common.domain;

import java.util.Collection;


public class UserDetail extends User {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -272918390456947755L;
	private UserInfo userInfo;
	
	

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}