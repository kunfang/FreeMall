package com.ftc.foundation.view;
/**
 *@author     [Jenk]
 *@version     [1.0]
 *@createdate  [2015-07-01]
 *@since       [MySQL分页]
 *@description  [分页类]
 */
import java.util.HashMap;
import java.util.List;

public class PageUtil {
	private static final long serialVersionUID = 1L;
	private int totalPage = 0; //总页数
	private int curPage =0  ;	//当前页
	private int totalCount = 0;	//总条数
	private int pageSize = 12;	//每页多少条 ,默认12条
	
	
	/**
     *@param  [ curPage,totalCount,pageSize] [当前页,总条数, 每页显示大小]
     *@return  [分页对象]
     *@description [分页]
     */
	public HashMap<String, Integer> getPageList(int curPage, int totalCount, int pageSize){
		
		if (curPage==0 && totalCount>0) {
			this.curPage = 1;
		}else {
			this.curPage = curPage;
		}
		
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("totalPage", (int)Math.ceil((double)totalCount/(double)(pageSize==0?this.pageSize:pageSize)));
		hMap.put("curPage", this.curPage);
		hMap.put("totalCount", totalCount);
		hMap.put("pageSize", pageSize==0?this.pageSize:pageSize);
		System.out.println("debug-----pageinfo: totalPage:"+hMap.get("totalPage")+", curPage:"+
				hMap.get("curPage")+", totalCount:"+hMap.get("totalCount")+", pageSize:"+hMap.get("pageSize"));
		return hMap;
	} 
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}


	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurPage() {		
		return curPage==0?1:curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	
	public PageUtil() {
		super();
	}


	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	}
