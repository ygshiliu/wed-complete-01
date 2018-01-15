package com.atguigu.bean;

import java.util.List;

/**
 * 用来封装分页相关的信息
 * @author Miss 王 
 * @version 创建时间：2017年2月18日 下午5:30:16
 */
public class Page<T> {
	/**
	 * 显示的数据
	 */
	private List<T> list;
	/**
	 * 总记录数
	 */
	private int totalRecord;
	/**
	 * 分页开始的索引
	 */
	private int index;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 当前页
	 */
	private int pageNo;
	/**
	 * 每页显示的条数 
	 */
	private int pageSize;
	/**
	 * 请求地址
	 */
	private String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	/**
	 * 公式：（当前页-1）* 每页显示条数
	 * 举例：
	 * 当前页		每页显示条数		index
	 * 1			4			0
	 * 2			4			4
	 * 3			4			8
	 * 4			4			12
	 * 
	 * @return
	 */
	public int getIndex() {
		return (getPageNo() - 1)*getPageSize();
	}
/*	public void setIndex(int index) {
		this.index = index;
	}*/
	/**
	 * 总页数 = 总记录数  / 每页显示的条数;
	 * 
	 * 举例：
	 * 总记录数 	每页显示的条数		总页数
	 * 10		2				5
	 * 9		2				5
	 * 8		2				4
	 * 7		2				4
	 * 
	 * @return
	 */
	
	public int getTotalPage() {
		
		totalPage = getTotalRecord() / getPageSize();
		
		if(getTotalRecord()%getPageSize()!=0){
			totalPage++;
		}
		return totalPage;
	}
	/*public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
	public int getPageNo() {
		//如果当前页小于1，需要重新设置为1
		if(pageNo < 1){
			pageNo = 1;
		}
		//如果当前页大于总页数，需要重新设置当前页值就为总页数
		if(pageNo > getTotalPage()){
			pageNo = getTotalPage();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Page() {
		super();
	}
	public Page(List<T> list, int totalRecord, int index, int totalPage,
			int pageNo, int pageSize) {
		super();
		this.list = list;
		this.totalRecord = totalRecord;
		this.index = index;
		this.totalPage = totalPage;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "Page [list=" + list + ", totalRecord=" + totalRecord
				+ ", index=" + index + ", totalPage=" + totalPage + ", pageNo="
				+ pageNo + ", pageSize=" + pageSize + "]";
	}
	
	
	
}
