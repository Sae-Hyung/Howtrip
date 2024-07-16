package com.backend24.howtrip.member.vo;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String memberId;
	private String memberPw;
	private String name;
	private Date birth;
	private String gender;
	private String email;	
	private String phone;
	private Timestamp joinDate;
	
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	public String getMemberPw() {
		return memberPw;
	}



	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
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



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Timestamp getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", birth=" + birth + ", gender="
				+ gender + ", email=" + email + ", tel=" + phone + ", joinDate=" + joinDate + "]";
	}


}