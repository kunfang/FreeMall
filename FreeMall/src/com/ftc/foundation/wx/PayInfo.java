package com.ftc.foundation.wx;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.ftc.freemall.vo.OrderVO;

public class PayInfo implements Serializable {
	 private static final long serialVersionUID =1L;
	 private String appid;
	 private String mch_id;
	 private String device_info;
	 private String nonce_str;
	 private String sign;
	 private String body;
	 private String attach;
	 private String out_trade_no;
	 private int total_fee;
	 private String spbill_create_ip;
	 private String notify_url;
	 private String trade_type;
	 private String openid;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	@Override
	public String toString() {
		return "PayInfo {appid='" + appid + ", mch_id=" + mch_id
				+ ", device_info=" + device_info + ", nonce_str=" + nonce_str
				+ ", sign=" + sign + ", body=" + body + ", attach=" + attach
				+ ", out_trade_no=" + out_trade_no + ", total_fee=" + total_fee
				+ ", spbill_create_ip=" + spbill_create_ip + ", notify_url="
				+ notify_url + ", trade_type=" + trade_type + ", openid="
				+ openid + "]";
	}
	/**
	 * 创建统一下单的xml的java对象
	 * @param bizOrder 系统中的业务单号
	 * @param ip 用户的ip地址
	 * @param openId 用户的openId
	 * @return
	 */
	 public PayInfo createPayInfo(OrderVO oVo,String ip,String openId) {
	  PayInfo payInfo = new PayInfo();
	  payInfo.setAppid("appid");
	  payInfo.setDevice_info("WEB");
	  payInfo.setMch_id("mch_id");
	  payInfo.setNonce_str("");
	  payInfo.setBody("这里是某某白米饭的body");
	  payInfo.setAttach("ID");
	  payInfo.setOut_trade_no("");
	  payInfo.setTotal_fee(100);
	  payInfo.setSpbill_create_ip(ip);
	  payInfo.setNotify_url("");
	  payInfo.setTrade_type("JSAPI");
	  payInfo.setOpenid(openId);
	  return payInfo;
	 }
	 /**
	  * 封装统一下单信息
	  * @param payInfo
	  * @return
	  */
	 public Map<String, Object> MapPayInfo(PayInfo payInfo){
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("appid", "appid");
		 map.put("attach", payInfo.getAttach());
		 map.put("body", payInfo.getBody());
		 map.put("device_info", payInfo.getDevice_info());
		 map.put("mch_id", payInfo.getMch_id());
		 map.put("nonce_str", payInfo.getNonce_str());
		 map.put("notify_url", payInfo.getNotify_url());
		 map.put("openid", payInfo.getOpenid());
		 map.put("out_trade_no", payInfo.getOut_trade_no());
		 map.put("spbill_create_ip", payInfo.getSpbill_create_ip());
		 map.put("total_fee", payInfo.getTotal_fee());
		 map.put("trade_type", payInfo.getTrade_type());

		 return map;
	 }
}
