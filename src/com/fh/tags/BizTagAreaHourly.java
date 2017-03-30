package com.fh.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.fh.common.filter.RequestFilter;
import com.fh.dao.biz.AreaHourlyDao;
import com.fh.entity.biz.AreaHourly;
import com.fh.entity.biz.AreaHourlyQuery;
import com.fh.entity.biz.AreaHourlyQuery.Criteria;

/**
 * 业务标签 : 时新设置 
 * @author lijn
 *
 */
public class BizTagAreaHourly extends SimpleTagSupport {
	
	private String areaCode;
	private String dutyCode;
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setDutyCode(String dutyCode) {
		this.dutyCode = dutyCode;
	}



	public void doTag() throws JspException, IOException {
		if (dutyCode != null && !"".equals(dutyCode)) {
			if (areaCode != null && !"".equals(areaCode)) {
				PageContext pageContext = (PageContext) getJspContext();
				//从RequestFilter过滤器中的线程上获取request对象
				HttpServletRequest request = RequestFilter.threadLocalRequest.get();
				//Web工具类WebApplicationContextUtils直接获取容器中的Bean实例并调用其方法
				ApplicationContext applicationContext = WebApplicationContextUtils
						.getWebApplicationContext(request.getSession()
								.getServletContext());
				AreaHourlyDao areaHourlyDao = (AreaHourlyDao) applicationContext
						.getBean("areaHourlyDao");
				//条件查询
				AreaHourlyQuery areaHourlyQuery = new AreaHourlyQuery();
				Criteria createCriteria = areaHourlyQuery.createCriteria();
				
					createCriteria.andDutyCodeEqualTo(dutyCode);
				
				
					createCriteria.andAreaCodeEqualTo(areaCode);
				
				List<AreaHourly> dataList = areaHourlyDao
						.selectByExample(areaHourlyQuery);
				if (dataList != null && dataList.size() > 0) {
					for (AreaHourly areaHourly : dataList) {
						pageContext.setAttribute("areaHourlyTag", areaHourly);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
				pageContext.removeAttribute("areaHourlyTag");
			}
		}
	}	
}
