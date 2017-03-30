package com.fh.entity.system;

import java.io.Serializable;
import java.util.Date;

import com.fh.entity.biz.District;
import com.fh.entity.biz.Station;

/**
 * 用户表拓展 
 * @author lijn
 *
 */
public class StoreEmployeeVO implements Serializable {
	/**
	 * 主键id（自增长）
	 */
    private Long id;

    /**
     * 用户账号
     */
    private String userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String userpwd;

    /**
     * 用户状态
     */
    private String del;

    /**
     * 是否在线(0:在线; 1:下线)
     */
    private String online;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createdate;

    /**
     * 操作者姓名
     */
    private String operator;

    /**
     * 修改日期
     */
    private Date changedate;

    /**
     * 角色编号
     */
    private String storePart;

    /**
     * 角色名称
     */
    private String storePartName;
    
    /**
     * 归属上级角色
     */
    private String pStorePart;
    
    /**
     * 部门编号
     */
    private String organiseId;
    
    /**
     * 部门名称
     */
    private String organiseName;
    
    /**
     * 关联区域编号
     */
    private String districtCode;
    /**
     * 关联区域名称
     */
    private String districtName;
    
    /**
     * 关联区域对象
     */
    private District district;
    
    /**
     * 关联油站编号
     */
    private String stationCode;
    /**
     * 关联油站名称
     */
    private String stationName;
    
    /**
     * 关联油站对象
     */
    private Station station;
    
    /**
     * 关联部门下级编号
     */
    private String subOrganiseIdStr;
    
    

    private static final long serialVersionUID = 1L;


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getStorePart() {
		return storePart;
	}


	public String getSubOrganiseIdStr() {
		return subOrganiseIdStr;
	}


	public void setSubOrganiseIdStr(String subOrganiseIdStr) {
		this.subOrganiseIdStr = subOrganiseIdStr;
	}


	public String getUserpwd() {
		return userpwd;
	}


	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	public String getDel() {
		return del;
	}


	public void setDel(String del) {
		this.del = del;
	}


	public String getOnline() {
		return online;
	}


	public void setOnline(String online) {
		this.online = online;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getCreatedate() {
		return createdate;
	}


	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public Date getChangedate() {
		return changedate;
	}


	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}


	public String getDistrictName() {
		return districtName;
	}

	public String getOrganiseId() {
		return organiseId;
	}


	public void setOrganiseId(String organiseId) {
		this.organiseId = organiseId;
	}


	public String getOrganiseName() {
		return organiseName;
	}


	public void setOrganiseName(String organiseName) {
		this.organiseName = organiseName;
	}


	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}


	public String getStationName() {
		return stationName;
	}


	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


	public void setStorePart(String storePart) {
		this.storePart = storePart;
	}


	public String getStorePartName() {
		return storePartName;
	}


	public void setStorePartName(String storePartName) {
		this.storePartName = storePartName;
	}


	public String getpStorePart() {
		return pStorePart;
	}


	public void setpStorePart(String pStorePart) {
		this.pStorePart = pStorePart;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}


	public String getStationCode() {
		return stationCode;
	}


	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}


	public Station getStation() {
		return station;
	}


	public void setStation(Station station) {
		this.station = station;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}