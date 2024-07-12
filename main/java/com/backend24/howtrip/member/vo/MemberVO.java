package com.backend24.howtrip.member.vo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String userId;
	private String userPw;
	private String name;
	private Date birth;
	private String gender;
	private String email;	
	private String tel;
	private Timestamp joinDate;
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getUserPw() {
		return userPw;
	}



	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Date getBirth() {
		return birth;
	}



	public void setBirth(Date birth) {
		this.birth = birth;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public Timestamp getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPw=" + userPw + ", name=" + name + ", birth=" + birth + ", gender="
				+ gender + ", email=" + email + ", tel=" + tel + ", joinDate=" + joinDate + "]";
	}


}