package com.ftc.freemall.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable{
	private static final long serialVersionUID = -2147397970766768563L;
	
	private String customerId;//客户ID
	private String mobilePhone;//手机号
	private double point;//积分
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
}
