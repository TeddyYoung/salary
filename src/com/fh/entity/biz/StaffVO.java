package com.fh.entity.biz;

/**
 * 油站员工 拓展类
 * @author lijn
 *
 */
public class StaffVO  extends Staff {
    
    /**
     * 标识员工职务类型  0- 普通员工 1- 油站会计  2 - 油站经理  3 - 其他
     */
    private Integer flag;
    
    /**
     * 标识当前用户是否可以  对该员工进行申请  0- 可以  1- 不可以
     */
    private Integer isAvailable;
    
    /**
     * 机构编号
     */
    private String organiseId;
    
    /**
     * 机构名称
     */
    private String organiseName;
    
    /**
     * 职务名称
     */
    private String dutyName;
    
    /**
     * 职务编号
     */
    private String newDutyCode;
    

    private static final long serialVersionUID = 1L;


	public Integer getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
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


	public String getDutyName() {
		return dutyName;
	}


	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}


	public Integer getFlag() {
		return flag;
	}


	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	public String getNewDutyCode() {
		return newDutyCode;
	}


	public void setNewDutyCode(String newDutyCode) {
		this.newDutyCode = newDutyCode;
	}
	
	

}