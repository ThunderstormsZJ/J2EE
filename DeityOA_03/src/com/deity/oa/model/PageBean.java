package com.deity.oa.model;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable{
	//-----配置和参数-----
	private int currentPage;//当前页号
	private int pageSize;//一页的总记录数
	//-----读取数据库-----
	private List<T> recordList;//页面数据内容
	private int recordCount;//总记录数
	//-----计算-----
	private int pageCount;//总页数
	private int beginPageIndex;//开始的页码
	private int endPageIndex;//结束的页码
	public PageBean(int currentPage, int pageSize, List<T> recordList,int recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;
		
		//计算总页数
		pageCount = (recordCount+pageSize-1)/pageSize;
		//计算出开始的页码和结束的页码（显示5页）
		//如果不满5页
		if(pageCount<=5){
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}else{
		//超过5页
			//默认显示前两页后两页
			beginPageIndex = currentPage-2;
			endPageIndex = currentPage+2;
			//前面不满2页,显示前5页
			if(currentPage<3){
				beginPageIndex = 1;
				endPageIndex = 5;
			}
			//如果后面不满2页,显示后5页
			if(currentPage>pageCount-2){
				endPageIndex = pageCount;
				beginPageIndex = pageCount-4;
			}
			
		}
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getRecordList() {
		return recordList;
	}
	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}
