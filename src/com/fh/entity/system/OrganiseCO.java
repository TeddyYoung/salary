package com.fh.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门表实体类
 * @author lijn
 *
 */
public class OrganiseCO implements Serializable {
    /**
     * 部门编号
     */
    private String organiseId;

    /**
     * 部门父ID
     */
    private String pOrganiseId;

    /**
     * 部门名称
     */
    private String organiseName;

    /**
     * 部门类型 ID
     */
    private String organiseTypeId;

    /**
     * 部门所在城市
     */
    private String city;

    private String coid;

    private String sapFactoryCode;

    private String cardSystemCode;

    private String managerRegionid;

    private String placeRegionid;

    private String priceRegionid;

    private String diff;
    
    private String sort;
    
    /**
     * 拓展属性： 下级部门
     */
    private List<OrganiseCO> subOrganiseCO=new ArrayList<OrganiseCO>();

    private static final long serialVersionUID = 1L;

    public String getOrganiseId() {
        return organiseId;
    }

    public void setOrganiseId(String organiseId) {
        this.organiseId = organiseId == null ? null : organiseId.trim();
    }

    public String getpOrganiseId() {
        return pOrganiseId;
    }

    public void setpOrganiseId(String pOrganiseId) {
        this.pOrganiseId = pOrganiseId == null ? null : pOrganiseId.trim();
    }

    public String getOrganiseName() {
        return organiseName;
    }

    public void setOrganiseName(String organiseName) {
        this.organiseName = organiseName == null ? null : organiseName.trim();
    }

    public String getOrganiseTypeId() {
        return organiseTypeId;
    }

    public void setOrganiseTypeId(String organiseTypeId) {
        this.organiseTypeId = organiseTypeId == null ? null : organiseTypeId.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public List<OrganiseCO> getSubOrganiseCO() {
		return subOrganiseCO;
	}

	public void setSubOrganiseCO(List<OrganiseCO> subOrganiseCO) {
		this.subOrganiseCO = subOrganiseCO;
	}

	public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid == null ? null : coid.trim();
    }

    public String getSapFactoryCode() {
        return sapFactoryCode;
    }

    public void setSapFactoryCode(String sapFactoryCode) {
        this.sapFactoryCode = sapFactoryCode == null ? null : sapFactoryCode.trim();
    }

    public String getCardSystemCode() {
        return cardSystemCode;
    }

    public void setCardSystemCode(String cardSystemCode) {
        this.cardSystemCode = cardSystemCode == null ? null : cardSystemCode.trim();
    }

    public String getManagerRegionid() {
        return managerRegionid;
    }

    public void setManagerRegionid(String managerRegionid) {
        this.managerRegionid = managerRegionid == null ? null : managerRegionid.trim();
    }

    public String getPlaceRegionid() {
        return placeRegionid;
    }

    public void setPlaceRegionid(String placeRegionid) {
        this.placeRegionid = placeRegionid == null ? null : placeRegionid.trim();
    }

    public String getPriceRegionid() {
        return priceRegionid;
    }

    public void setPriceRegionid(String priceRegionid) {
        this.priceRegionid = priceRegionid == null ? null : priceRegionid.trim();
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff == null ? null : diff.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", organiseId=").append(organiseId);
        sb.append(", pOrganiseId=").append(pOrganiseId);
        sb.append(", organiseName=").append(organiseName);
        sb.append(", organiseTypeId=").append(organiseTypeId);
        sb.append(", city=").append(city);
        sb.append(", coid=").append(coid);
        sb.append(", sapFactoryCode=").append(sapFactoryCode);
        sb.append(", cardSystemCode=").append(cardSystemCode);
        sb.append(", managerRegionid=").append(managerRegionid);
        sb.append(", placeRegionid=").append(placeRegionid);
        sb.append(", priceRegionid=").append(priceRegionid);
        sb.append(", diff=").append(diff);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}