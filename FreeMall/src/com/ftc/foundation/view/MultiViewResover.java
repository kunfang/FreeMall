package com.ftc.foundation.view;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**
 * 
 * @author kun.fang
 * @version 1.0
 * @description: 多视图解析器
 */
public class MultiViewResover implements ViewResolver {
	
	private Map<String, ViewResolver> resolvers;
	
	public Map<String, ViewResolver> getResolvers() {
		return resolvers;
	}

	public void setResolvers(Map<String, ViewResolver> resolvers) {
		this.resolvers = resolvers;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		int n = viewName.lastIndexOf(".");
		
		// 如果为空，返回JspView
		
		if (n == -1) {
			return resolvers.get("jsp").resolveViewName(viewName, locale);
		}
		
		String suffix = viewName.substring(n+1);
		ViewResolver resolver = resolvers.get(suffix);
		
		viewName = viewName.substring(0, n);
		
		if (resolver != null) {
			return resolver.resolveViewName(viewName, locale);
		}
				
		return null;
	}
	
}
