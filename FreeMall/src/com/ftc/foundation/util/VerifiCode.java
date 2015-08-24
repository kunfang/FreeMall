package com.ftc.foundation.util;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.ftc.foundation.config.DefaultParams;

public class VerifiCode {	
	private static CCPRestSmsSDK sendAPI;
	
	public synchronized static CCPRestSmsSDK getInstance() {
		if (sendAPI == null) {
			sendAPI = new CCPRestSmsSDK();
			sendAPI.init(DefaultParams.findParam("verificode.url"), DefaultParams.findParam("verificode.port"));
			sendAPI.setAccount(DefaultParams.findParam("verificode.accountsid"), DefaultParams.findParam("verificode.authtoken"));
			sendAPI.setAppId(DefaultParams.findParam("verificode.appid"));
		}
		return sendAPI;
	}
	
	public static String getVerifiCode() {
		int code = (int) (Math.random()*9000+1000);
		return code+"";
	}
	
	public static void main(String[] args) {
		System.out.println(getVerifiCode());
	}
}