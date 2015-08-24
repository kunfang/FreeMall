package com.ftc.foundation.config;

import java.util.Properties;

public class DefaultParams {
	private static Properties params = new Properties();
	
	public static String findParam (String key) {
		if (params.isEmpty()) {
			params = DefaultParamsLoader.getSysParams();
		}
		return (String)params.get(key);
	}
	
	public static void main(String[] args) {
		System.out.println(DefaultParams.findParam("verificode.accountsid"));
	}
}
