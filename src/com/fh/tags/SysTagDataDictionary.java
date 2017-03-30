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
import com.fh.dao.system.DataDictionaryDao;
import com.fh.entity.system.DataDictionary;
import com.fh.entity.system.DataDictionaryQuery;
import com.fh.entity.system.DataDictionaryQuery.Criteria;

/**
 * 系统标签
 * @author lijn
 *
 */
public class SysTagDataDictionary extends SimpleTagSupport {
	
	private String codeType;
	private String valueType;
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public void setvalueType(String valueType) {
		this.valueType = valueType;
	}

	public void doTag() throws JspException, IOException {
		if (valueType != null && !"".equals(valueType)) {
			PageContext pageContext = (PageContext) getJspContext();
			//从RequestFilter过滤器中的线程上获取request对象
			HttpServletRequest request = RequestFilter.threadLocalRequest.get();
			//Web工具类WebApplicationContextUtils直接获取容器中的Bean实例并调用其方法
			ApplicationContext applicationContext = WebApplicationContextUtils
					.getWebApplicationContext(request.getSession()
							.getServletContext());
			DataDictionaryDao dataDictionaryDao = (DataDictionaryDao) applicationContext
					.getBean("dataDictionaryDao");
			//条件查询
			DataDictionaryQuery dataDictionaryQuery = new DataDictionaryQuery();
			Criteria createCriteria = dataDictionaryQuery.createCriteria();
			if (!"all".equals(valueType)) {
				createCriteria.andValuetypeEqualTo(valueType);
			}
			if (codeType != null && !"".equals(codeType)) {
				createCriteria.andCodetypeEqualTo(codeType);
			}
			List<DataDictionary> dataList = dataDictionaryDao
					.selectByExample(dataDictionaryQuery);
			if (dataList != null && dataList.size() > 0) {
				for (DataDictionary dataDictionary : dataList) {
					pageContext.setAttribute("dataDictionary", dataDictionary);
					//输出主题内容
					getJspBody().invoke(null);
				}
			}
			pageContext.removeAttribute("dataDictionary");
		}
	}
}
