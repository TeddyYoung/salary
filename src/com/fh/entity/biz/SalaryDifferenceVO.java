package com.fh.entity.biz;

import java.io.Serializable;
import java.util.List;

/**
 * 薪资差异VO封装类
 * @author zhang_yu
 *
 */
@SuppressWarnings("serial")
public class SalaryDifferenceVO implements Serializable{

	private List<SalaryDifference> salaryDifferenceList;

	public List<SalaryDifference> getSalaryDifferenceList() {
		return salaryDifferenceList;
	}

	public void setSalaryDifferenceList(List<SalaryDifference> salaryDifferenceList) {
		this.salaryDifferenceList = salaryDifferenceList;
	}
	
}
