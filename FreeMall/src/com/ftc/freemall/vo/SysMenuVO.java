package com.ftc.freemall.vo;

import java.io.Serializable;

/**
 * 系统菜单表 T_ASSESS_SYS_MENU
 * @author 
 */

public class SysMenuVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String menuId; //菜单ID
	private String menuNme; //菜单名称
	private String menuUrl; //菜单访问地址
	private Float menuLevel; //菜单级别
	private String parentId; //上级菜单ID
	private String className; //菜单样式
	
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMenuId(){
	  return menuId;
	}

	public void  setMenuId(String menuId){
	  this.menuId = menuId;
	}

	public String getMenuNme(){	
	if(!"".equals(menuNme)&& menuNme!=null){
		return menuNme.trim();
	}else{
	   return menuNme;
	}
	}

	public void  setMenuNme(String menuNme){
	  this.menuNme = menuNme;
	}

	public String getMenuUrl(){
		if(!"".equals(menuUrl)&& menuUrl!=null){
			return menuUrl.trim();
		}else{
			return menuUrl;
		}
	  
	}

	public void  setMenuUrl(String menuUrl){
	  this.menuUrl = menuUrl;
	}

	public Float getMenuLevel(){
	  return menuLevel;
	}

	public void  setMenuLevel(Float menuLevel){
	  this.menuLevel = menuLevel;
	}

	
	public String getParentId(){
	  return parentId;
	}

	public void  setParentId(String parentId){
	  this.parentId = parentId;
	}

	
	@Override
	public String toString() {
		return "AssessSysMenuVO [menuId=" + menuId + ", menuLevel=" + menuLevel
				+ ", menuNme=" + menuNme + ", menuUrl=" + menuUrl  + ", parentId=" + parentId + "]";
	}

}
