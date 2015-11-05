package com.ftc.freemall.vo;

import java.io.Serializable;
import java.util.Date;

public class OrderVO implements Serializable{
	private static final long serialVersionUID = -3187216619156848990L;
	
	private int orderID;//订单ID
	private String receiverName; //收货人姓名
	private String regionCode;//省份
	private String cityCode;//城市
	private String countyCode;//区县
	private String address;//详细地址
	private String receiverMobile;//手机号
	private Date createDate;//创建时间
	private Integer prodID; //产品ID
	private String prodName; // 产品名称
	private String price;
	private String isPaid; //是否已付款
	private String openId; //微信用户OPenid
	private String orderCode; //订单号
	private String beginTime;
	private String paidOk;	//是否支付完成
	
	public String getPaidOk() {
		return paidOk;
	}

	public void setPaidOk(String paidOk) {
		this.paidOk = paidOk;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	private String endTime;
	
	private String agentName;
	private Integer agentID;
	
	
	
	
	/*private String openid; // 微信id
	
	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}*/

	public Integer getAgentID() {
		return agentID;
	}

	public void setAgentID(Integer agentID) {
		this.agentID = agentID;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean checkInfo () {
		
		return orderID==0||receiverName==null||regionCode==null||cityCode==null||countyCode==null||address==null||receiverMobile==null||prodName==null||prodID==0;
	}
	
	public Integer getProdID() {
		return prodID;
	}
	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReceiverMobile() {
		return receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
