package com.ftc.foundation.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class DefaultParamsLoader {
	public static Properties getSysParams() {
		Properties p = null;
		try {
			String path = DefaultParamsLoader.class.getClassLoader().getResource("").toURI().getPath();
			InputStream in = new FileInputStream(new File(path + "config.properties"));
			p = new Properties();
			p.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void main(String[] args) {
		DefaultParamsLoader.getSysParams();
	}
}
