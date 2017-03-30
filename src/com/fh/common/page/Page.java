package com.fh.common.page;

import java.util.List;

import com.fh.common.SysConstant;

/**
 * 分页类, 封装了所有分页的有关数据
 * @author zhang_yu
 *
 */
public class Page {

	private List records;                                 //要显示的分页记录
	private int pageNum;                                  //当前页码(用户要看的页码)
	private int totalPage;                                //总页数(尾页)
	private int totalRecordsNum;                          //总记录条数
	private int pageSize = SysConstant.CURRENT_PAGE_SIZE; //每页显示的记录条数
	private int startIndex;                               //开始查询记录的索引
	private int prevPageNum;                              //上一页页码
	private int nextPageNum;                              //下一页页码
	 
	public Page() {}

	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecordsNum() {
		return totalRecordsNum;
	}
	public void setTotalRecordsNum(int totalRecordsNum) {
		
		this.totalRecordsNum = totalRecordsNum;
		
		if (0 == pageNum) {                                              //如果用户没有选择想要看的页数, 默认显示第1页
			pageNum = 1;
		}
		
		this.totalPage = this.totalRecordsNum % this.pageSize == 0 ? 
						 this.totalRecordsNum / this.pageSize : 
					     this.totalRecordsNum / this.pageSize + 1;       //计算总页数
		
		startIndex = (pageNum - 1) * this.pageSize;                      //计算每页开始查询的索引
		prevPageNum = pageNum - 1 > 0 ? pageNum - 1 : 1;                 //计算上一页的页数
		nextPageNum = pageNum + 1 > totalPage ? totalPage : pageNum + 1; //计算下一页的页数
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getPrevPageNum() {
		return prevPageNum;
	}
	public void setPrevPageNum(int prevPageNum) {
		this.prevPageNum = prevPageNum;
	}
	public int getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	 
}
