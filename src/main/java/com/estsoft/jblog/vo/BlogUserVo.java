package com.estsoft.jblog.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BlogUserVo {
	private long userNo;
	@NotEmpty
	@Length(min = 2, max = 10)
	private String userName;
	@NotEmpty
	@Length(min = 8, max = 20)
	private String password;
	private String regDate;
	
	public long getUserNo() {
		return userNo;
	}
	public void setUserNo(long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "blogUserVo [userNo=" + userNo + ", userName=" + userName + ", password=" + password + ", regDate="
				+ regDate + "]";
	}

}
