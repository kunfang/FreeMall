package com.ftc.freemall.vo;

import java.io.Serializable;
import java.util.Date;

public class VerifiCodeVO implements Serializable{
	private static final long serialVersionUID = -1273594022593002606L;
	
	private int codeid;
	private String phone;
	private String verificode;
	private Date createdate;
	public int getCodeid() {
		return codeid;
	}
	public void setCodeid(int codeid) {
		this.codeid = codeid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVerificode() {
		return verificode;
	}
	public void setVerificode(String verificode) {
		this.verificode = verificode;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}
