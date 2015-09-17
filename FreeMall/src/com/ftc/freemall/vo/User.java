package com.ftc.freemall.vo;
import java.util.Date;

public class User {
	private static final long serialVersionUID = 1L;
	private int userid;       //用户ID
	private String username;  //用户名
	private String password;  //密码
	private String mobile;  //手机号
	private int appearance;  //用户头像
	private Date timeStamp;  //创建日期
	private int isClient;    //0表示手机端,1代表终端
	private String email;    //邮箱地址
	private String bankNo;   //卡号
	private String trueName; //真实姓名
	private String bankName; //银行名称
	private String sex;      //用户性别  0：男  1：女
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getAppearance() {
		return appearance;
	}
	public void setAppearance(int appearance) {
		this.appearance = appearance;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getIsClient() {
		return isClient;
	}
	public void setIsClient(int isClient) {
		this.isClient = isClient;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
