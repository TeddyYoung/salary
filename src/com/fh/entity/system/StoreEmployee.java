package com.fh.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fh.entity.biz.District;
import com.fh.entity.biz.Station;

/**
 * 用户表
 * @author zhang_yu
 *
 */
public class StoreEmployee implements Serializable {
	
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
     * 关联区域编号
     */
    private String districtCode;
    
    /**
     * 附加区域对象
     */
    private District district;
    
    /**
     * 附加油站对象
     */
    private Station station;

    /**
     * 关联油站编号
     */
    private String stationCode;
    
    /**
     * 关联部门编号
     */
    private String organiseId;
    
    /**
     * 关联角色编号
     */
    private String depPartCode;
    
    /**
     * 关联部门下级编号
     */
    private String subOrganiseIdStr;
    
    /**
     * 拓展属性 ： 部门角色
     */
    private List<DepPart> depParts = new ArrayList<DepPart>();
    
    /**
     * 拓展属性：角色
     */
    private DepPart depPart;
    
    /**
     * 拓展属性：机构
     */
    private OrganiseCO organiseCO;
    
    private String newPassword;// 新密码（瞬态字段）
    
    private String checkPassword;// 确认新密码（瞬态字段）

    private static final long serialVersionUID = 1L;

    public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public DepPart getDepPart() {
		return depPart;
	}

	public void setDepPart(DepPart depPart) {
		this.depPart = depPart;
	}

	public OrganiseCO getOrganiseCO() {
		return organiseCO;
	}

	public void setOrganiseCO(OrganiseCO organiseCO) {
		this.organiseCO = organiseCO;
	}

	public String getDepPartCode() {
		return depPartCode;
	}

	public void setDepPartCode(String depPartCode) {
		this.depPartCode = depPartCode;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public String getSubOrganiseIdStr() {
		return subOrganiseIdStr;
	}

	public void setSubOrganiseIdStr(String subOrganiseIdStr) {
		this.subOrganiseIdStr = subOrganiseIdStr;
	}

	public String getOrganiseId() {
		return organiseId;
	}

	public void setOrganiseId(String organiseId) {
		this.organiseId = organiseId;
	}

	public List<DepPart> getDepParts() {
		return depParts;
	}

	public void setDepParts(List<DepPart> depParts) {
		this.depParts = depParts;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del == null ? null : del.trim();
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online == null ? null : online.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode == null ? null : stationCode.trim();
    }

	public String toString() {
		return "StoreEmployee [id=" + id + ", userid=" + userid + ", username="
				+ username + ", userpwd=" + userpwd + ", del=" + del
				+ ", online=" + online + ", email=" + email + ", phone="
				+ phone + ", createdate=" + createdate + ", operator="
				+ operator + ", changedate=" + changedate + ", districtCode="
				+ districtCode + ", stationCode=" + stationCode + "]";
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

}