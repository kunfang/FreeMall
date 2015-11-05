package com.ftc.foundation.wx;

import java.util.HashMap;
import java.util.Map;

import com.ftc.foundation.config.DefaultParams;
import com.ftc.foundation.http.HttpRequester;
import com.ftc.foundation.http.HttpRespons;

import net.sf.json.JSONObject;

/**
 * 
 * @author JenkGan
 * @date 2015-10-20
 *
 */
public class WxCreateMenu {
	
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 创建菜单
	 * 
	 * @param menu 菜单实例
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Object menu,String accessToken) {
		
		HttpRequester requester = new HttpRequester();
		requester.setDefaultContentEncoding("utf-8");
		int result = 0;
		HttpRespons response = null;
		try {
		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String Menu = menu.toString();
		url = url+"&"+Menu;
		response =  requester.sendGet(url);
		JSONObject jsonObject = JSONObject.fromObject(response.getContent());		
		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
			//	log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 调用接口创建菜单
		
		// JSONObject jsonObject		//httpRequest(url, "POST", jsonMenu);

		

		return result;
	}
	
	public static String getAccessToken(){
		HttpRequester requester = new HttpRequester();
		requester.setDefaultContentEncoding("utf-8");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("grant_type", "client_credential");
		params.put("appid", "wx54ab066d3e0e8fe7");
		params.put("secret", "558fc80fd023e3fdc19de019d04c3e85");
		HttpRespons response = null;
		try {
		response = requester.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
		JSONObject json = JSONObject.fromObject(response.getContent());
		String access_token = (String)json.get("access_token");
		return access_token;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		
		String accessToken = "Uvfz3UTWRehK3vTHni9HtrRITxLMkS54ga9H49mMJSTHo9PUiu926dmZG1gCbpiQdFC9lwvGH_JPhaifdEkbKSwOEnxU3P5-KUwxlhDB8N0";
				//"Uvfz3UTWRehK3vTHni9HtrRITxLMkS54ga9H49mMJSTHo9PUiu926dmZG1gCbpiQdFC9lwvGH_JPhaifdEkbKSwOEnxU3P5-KUwxlhDB8N0";
				//getAccessToken();
		System.out.println(accessToken);
		int result = WeixinUtil.createMenu(getMenu(), accessToken);

		if (0 == result)
			System.out.println("菜单创建成功！");
		else
			System.out.println("菜单创建失败，错误码：" + result);
//			log.info("菜单创建失败，错误码：" + result);
	//	System.out.println(getAccessToken());
//		https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=Uvfz3UTWRehK3vTHni9HtrRITxLMkS54ga9H49mMJSTHo9PUiu926dmZG1gCbpiQdFC9lwvGH_JPhaifdEkbKSwOEnxU3P5-KUwxlhDB8N0
	}
	
	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		CommonButton btn11 = new CommonButton();
		btn11.setName("往期回顾");
		btn11.setType("view");
		btn11.setUrl("http://www.ft-tech.cn/FreeMall/lingyh/item3.html");
		//http://www.ft-tech.cn/FreeMall/lingyh/item3test.html
		//http://139.196.20.9/FreeMall/lingyh/item3test.html
		CommonButton btn12 = new CommonButton();
		btn12.setName("公交查询");
		btn12.setType("click");
		btn12.setKey("12");

		CommonButton btn13 = new CommonButton();
		btn13.setName("周边搜索");
		btn13.setType("click");
		btn13.setKey("13");

		CommonButton btn14 = new CommonButton();
		btn14.setName("历史上的今天");
		btn14.setType("click");
		btn14.setKey("14");

		CommonButton btn21 = new CommonButton();
		btn21.setName("保密协议");
		btn21.setType("view");
		btn21.setUrl("http://www.ft-tech.cn/FreeMall/lingyh/item7.html");

		CommonButton btn22 = new CommonButton();
		btn22.setName("经典游戏");
		btn22.setType("click");
		btn22.setKey("22");

		CommonButton btn23 = new CommonButton();
		btn23.setName("美女电台");
		btn23.setType("click");
		btn23.setKey("23");

		CommonButton btn24 = new CommonButton();
		btn24.setName("人脸识别");
		btn24.setType("click");
		btn24.setKey("24");

		CommonButton btn25 = new CommonButton();
		btn25.setName("聊天唠嗑");
		btn25.setType("click");
		btn25.setKey("25");


		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("往期回顾");
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("客户服务");
		mainBtn2.setSub_button(new CommonButton[] { btn21 });

		/**
		 * 这是公众号xiaoqrobot目前的菜单结构，每个一级菜单都有二级菜单项<br>
		 * 
		 * 在某个一级菜单下没有二级菜单的情况，menu该如何定义呢？<br>
		 * 比如，第三个一级菜单项不是"更多体验"，而直接是"幽默笑话"，那么menu应该这样定义：<br>
		 * menu.setButton(new Button[] { mainBtn1, mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { btn11,mainBtn2});

		return menu;
	}


}
