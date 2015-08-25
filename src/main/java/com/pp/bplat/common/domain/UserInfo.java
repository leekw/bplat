package com.pp.bplat.common.domain;

import java.util.List;

public class UserInfo extends Common {

	private static final long serialVersionUID = -6520447484821580747L;

	private String ssoToken;
	private String loginId;
	private String loginPw;
	private String loginDt; // 로긴 일시
	private String userRowId; // 사용자 Row ID
	private String userName; // 사용자 이름
	private String adminDeptId; // KT관리부서 로우아이디
	private String deptId; // 부서 ID
	private String deptCode; // 부서 코드
	private String deptAuthTypeId; // 조직권한유형 ID
	private String deptType; // 부서유형
	private String deptSubType; // 부서상세유형
	private String deptLevel; // 부서레벨
	private String deptName; // 부서 명
	private String positionId; // 직위 ID
	private String positionName; // 직위 명
	private String adminEmployeeId; // KT담당자사원아이디
	private String employeeTypeCode; // 사원구분코드(직원:Employee, 협력사직원:Partner)
	private String employeeNum; // 사원번호
	private String oldEmployeeNum; // 구 사원번호
	private String storeId; // 매장아이디
	private String jobTitle; // ?
	private String primaryAccountId; // ?
	private String managerEmployeeId; // ?
	private String managerEmployeeName; // 부서 팀장 명
	private String loginIp;
	private String loginStatus;
	private String userEmail;
	private String userCellTelNo;
	private String userHomeTelNo;
	private String userWorkTelNo;
	private String ctiType; // CTI유형구분코드
	private String enterpriseFaxUserFlag; // 기업팩스사용자여부
	private String regionHeadCode; // 지역본부아이디
	private String deptHROrgType; // 조직특성구분코드
	private String headCode; // 본부조직아이디
	// 권한
	private List<Authority> authorities;
	// 예외권한
	private List<ExceptionAuthority> exceptionAuthorities;
	// 휴일근무권한 소유 여부
	private boolean haveHolidayWorkAuth;
	// 야간근무권한 소유 여부
	private boolean haveNightWorkAuth;
	// 보안등급
	private List<String> securityGrades;
	// 부서
	private List<Division> divisions;

	public String getSsoToken() {
		return ssoToken;
	}

	public void setSsoToken(String ssoToken) {
		this.ssoToken = ssoToken;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}

	public String getLoginDt() {
		return loginDt;
	}

	public void setLoginDt(String loginDt) {
		this.loginDt = loginDt;
	}

	public String getUserRowId() {
		return userRowId;
	}

	public void setUserRowId(String userRowId) {
		this.userRowId = userRowId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminDeptId() {
		return adminDeptId;
	}

	public void setAdminDeptId(String adminDeptId) {
		this.adminDeptId = adminDeptId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getDeptSubType() {
		return deptSubType;
	}

	public void setDeptSubType(String deptSubType) {
		this.deptSubType = deptSubType;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getAdminEmployeeId() {
		return adminEmployeeId;
	}

	public void setAdminEmployeeId(String adminEmployeeId) {
		this.adminEmployeeId = adminEmployeeId;
	}

	public String getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getOldEmployeeNum() {
		return oldEmployeeNum;
	}

	public void setOldEmployeeNum(String oldEmployeeNum) {
		this.oldEmployeeNum = oldEmployeeNum;
	}

	public String getEmployeeTypeCode() {
		return employeeTypeCode;
	}

	public void setEmployeeTypeCode(String employeeTypeCode) {
		this.employeeTypeCode = employeeTypeCode;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPrimaryAccountId() {
		return primaryAccountId;
	}

	public void setPrimaryAccountId(String primaryAccountId) {
		this.primaryAccountId = primaryAccountId;
	}

	public String getManagerEmployeeId() {
		return managerEmployeeId;
	}

	public void setManagerEmployeeId(String managerEmployeeId) {
		this.managerEmployeeId = managerEmployeeId;
	}

	public String getManagerEmployeeName() {
		return managerEmployeeName;
	}

	public void setManagerEmployeeName(String managerEmployeeName) {
		this.managerEmployeeName = managerEmployeeName;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserCellTelNo() {
		return userCellTelNo;
	}

	public void setUserCellTelNo(String userCellTelNo) {
		this.userCellTelNo = userCellTelNo;
	}

	public String getUserHomeTelNo() {
		return userHomeTelNo;
	}

	public void setUserHomeTelNo(String userHomeTelNo) {
		this.userHomeTelNo = userHomeTelNo;
	}

	public String getUserWorkTelNo() {
		return userWorkTelNo;
	}

	public void setUserWorkTelNo(String userWorkTelNo) {
		this.userWorkTelNo = userWorkTelNo;
	}

	public String getCtiType() {
		return ctiType;
	}

	public void setCtiType(String ctiType) {
		this.ctiType = ctiType;
	}

	public String getEnterpriseFaxUserFlag() {
		return enterpriseFaxUserFlag;
	}

	public void setEnterpriseFaxUserFlag(String enterpriseFaxUserFlag) {
		this.enterpriseFaxUserFlag = enterpriseFaxUserFlag;
	}

	public String getRegionHeadCode() {
		return regionHeadCode;
	}

	public void setRegionHeadCode(String regionHeadCode) {
		this.regionHeadCode = regionHeadCode;
	}

	public String getDeptHROrgType() {
		return deptHROrgType;
	}

	public void setDeptHROrgType(String deptHROrgType) {
		this.deptHROrgType = deptHROrgType;
	}

	public String getHeadCode() {
		return headCode;
	}

	public void setHeadCode(String headCode) {
		this.headCode = headCode;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public List<ExceptionAuthority> getExceptionAuthorities() {
		return exceptionAuthorities;
	}

	public void setExceptionAuthorities(List<ExceptionAuthority> exceptionAuthorities) {
		this.exceptionAuthorities = exceptionAuthorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public boolean isHaveHolidayWorkAuth() {
		return haveHolidayWorkAuth;
	}

	public void setHaveHolidayWorkAuth(boolean haveHolidayWorkAuth) {
		this.haveHolidayWorkAuth = haveHolidayWorkAuth;
	}

	public boolean isHaveNightWorkAuth() {
		return haveNightWorkAuth;
	}

	public void setHaveNightWorkAuth(boolean haveNightWorkAuth) {
		this.haveNightWorkAuth = haveNightWorkAuth;
	}

	public List<String> getSecurityGrades() {
		return securityGrades;
	}

	public void setSecurityGrades(List<String> securityGrades) {
		this.securityGrades = securityGrades;
	}

	public List<Division> getDivisions() {
		return divisions;
	}

	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	public String getDeptAuthTypeId() {
		return deptAuthTypeId;
	}

	public void setDeptAuthTypeId(String deptAuthTypeId) {
		this.deptAuthTypeId = deptAuthTypeId;
	}
}
