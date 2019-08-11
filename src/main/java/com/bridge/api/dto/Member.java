package com.bridge.api.dto;

import java.util.Date;

public class Member {
	private Long nMemberSeq;
	private String sId;
	private String sEmail;
	private String sName;
	private String sNickName;
	private String sBirthDate;
	private Date dtJoinDate;
	private String sPassword;
	private int nSex;

	public Long getnMemberSeq() {
		return nMemberSeq;
	}
	public void setnMemberSeq(Long nMemberSeq) {
		this.nMemberSeq = nMemberSeq;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsNickName() {
		return sNickName;
	}
	public void setsNickName(String sNickName) {
		this.sNickName = sNickName;
	}
	public String getsBirthDate() {
		return sBirthDate;
	}
	public void setsBirthDate(String sBirthDate) {
		this.sBirthDate = sBirthDate;
	}
	public Date getDtJoinDate() {
		return dtJoinDate;
	}
	public void setDtJoinDate(Date dtJoinDate) {
		this.dtJoinDate = dtJoinDate;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public int getnSex() {
		return nSex;
	}
	public void setnSex(int nSex) {
		this.nSex = nSex;
	}
}
