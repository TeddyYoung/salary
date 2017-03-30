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
import com.fh.dao.biz.AreaDao;
import com.fh.dao.biz.DutyDao;
import com.fh.dao.biz.StationDao;
import com.fh.dao.biz.StationLevelDao;
import com.fh.dao.system.DepPartDao;
import com.fh.dao.system.OrganiseCODao;
import com.fh.entity.biz.Area;
import com.fh.entity.biz.AreaQuery;
import com.fh.entity.biz.District;
import com.fh.entity.biz.Duty;
import com.fh.entity.biz.DutyQuery;
import com.fh.entity.biz.Station;
import com.fh.entity.biz.StationLevel;
import com.fh.entity.biz.StationLevelQuery;
import com.fh.entity.biz.StationQuery;
import com.fh.entity.system.DepPart;
import com.fh.entity.system.DepPartQuery;
import com.fh.entity.system.OrganiseCO;
import com.fh.entity.system.OrganiseCOQuery;

/**
 * 业务标签
 * @author lijn
 *
 */
public class BizTag extends SimpleTagSupport {
	//类型  要查询的类的标识
	private String type;
	//编号  数据编号 可精确到一条记录
	private String code;
	
	public void setType(String type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void doTag() throws JspException, IOException {
		if (code != null && !"".equals(code)) {
			//从RequestFilter过滤器中的线程上获取request对象
			HttpServletRequest request = RequestFilter.threadLocalRequest.get();
			//Web工具类WebApplicationContextUtils直接获取容器中的Bean实例并调用其方法
			ApplicationContext applicationContext = WebApplicationContextUtils
					.getWebApplicationContext(request.getSession()
							.getServletContext());
			PageContext pageContext = (PageContext) getJspContext();
			if ("duty".equals(type)) {
				//查询职务
				DutyQuery dutyQuery = new DutyQuery();
				if (!"all".equals(code)) {
					dutyQuery.createCriteria().andDutyCodeEqualTo(code);
				}
				dutyQuery.setOrderByClause("sort");
				DutyDao dutyDao = (DutyDao) applicationContext
						.getBean("dutyDao");
				List<Duty> dutyList = dutyDao.selectByExample(dutyQuery);
				if (dutyList != null && dutyList.size() > 0) {
					for (Duty duty : dutyList) {
						pageContext.setAttribute("obj", duty);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
			} else if ("station".equals(type)) {
				//查询油站
				StationQuery stationQuery = new StationQuery();
				if (!"all".equals(code)) {
					stationQuery.createCriteria().andStationCodeEqualTo(code);
				}
				StationDao stationDao = (StationDao) applicationContext
						.getBean("stationDao");
				List<Station> stationList = stationDao
						.selectByExample(stationQuery);
				if (stationList != null && stationList.size() > 0) {
					for (Station station : stationList) {
						pageContext.setAttribute("obj", station);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
			} else if ("stationLevel".equals(type)) {
				//查询油站星级
				StationLevelQuery stationLevelQuery = new StationLevelQuery();
				if (!"all".equals(code)) {
					stationLevelQuery.createCriteria()
					.andStationLevelCodeEqualTo(code);
				}
				StationLevelDao stationLevelDao = (StationLevelDao) applicationContext
						.getBean("stationLevelDao");
				List<StationLevel> stationLevelList = stationLevelDao
						.selectByExample(stationLevelQuery);
				if (stationLevelList != null && stationLevelList.size() > 0) {
					for (StationLevel stationLevel : stationLevelList) {
						pageContext.setAttribute("obj", stationLevel);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
			} else if ("area".equals(type)) {
				//查询地区
				AreaQuery areaQuery = new AreaQuery();
				if (!"all".equals(code)) {
					areaQuery.createCriteria().andAreaCodeEqualTo(code);
				}
				AreaDao areaDao = (AreaDao) applicationContext
						.getBean("areaDao");
				List<Area> areaList = areaDao.selectByExample(areaQuery);
				if (areaList != null && areaList.size() > 0) {
					for (Area area : areaList) {
						pageContext.setAttribute("obj", area);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
			} else if ("district".equals(type)) {
				//查询区域
//				DistrictQuery districtQuery = new DistrictQuery();
				OrganiseCOQuery organiseCOQuery = new OrganiseCOQuery();
				if (!"all".equals(code)) {
//					districtQuery.createCriteria().andDistrictCodeEqualTo(code);
					organiseCOQuery.createCriteria().andOrganiseIdEqualTo(code);
				} else {
					organiseCOQuery.createCriteria().andPOrganiseIdEqualTo("Z001");
				}
//				DistrictDao districtDao = (DistrictDao) applicationContext.getBean("districtDao");
				OrganiseCODao organiseCODao = (OrganiseCODao) applicationContext.getBean("organiseCODao");
//				List<District> districtList = districtDao.selectByExample(districtQuery);
				List<OrganiseCO> organiseCOList = organiseCODao.selectByExample(organiseCOQuery);
				
//				if (districtList != null && districtList.size() > 0) {
//					for (District district : districtList) {
//						pageContext.setAttribute("obj", district);
//						//输出主题内容
//						getJspBody().invoke(null);
//					}
//				}
				
				if (organiseCOList != null && organiseCOList.size() > 0) {
					for (OrganiseCO organiseCO : organiseCOList) {
						pageContext.setAttribute("obj", organiseCO);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
			} else if ("depPart".equals(type)) {
				//查询角色
				DepPartQuery depPartQuery = new DepPartQuery();
				if (!"all".equals(code)) {
					depPartQuery.createCriteria().andStorePartEqualTo(code);
				}
				DepPartDao depPartDao = (DepPartDao) applicationContext
						.getBean("depPartDao");
				List<DepPart> depPartList = depPartDao.selectByExample(depPartQuery);
				if (depPartList != null && depPartList.size() > 0) {
					for (DepPart depPart : depPartList) {
						pageContext.setAttribute("obj", depPart);
						//输出主题内容
						getJspBody().invoke(null);
					}
				}
			}
			pageContext.removeAttribute("obj");
		}else {
			//输出主题内容
			getJspBody().invoke(null);
		}
	}
}
