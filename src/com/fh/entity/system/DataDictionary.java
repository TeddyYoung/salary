package com.fh.entity.system;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典实体类
 * @author lijn
 *
 */
public class DataDictionary implements Serializable {
    /**
     * 主键Id
     */
    private Integer id;

    /**
     * 标签类型
     */
    private String codetype;

    /**
     * 标签内容
     */
    private String codename;

    /**
     * 值类型
     */
    private String valuetype;

    /**
     * 值内容
     */
    private String valuename;

    /**
     * 创建日期
     */
    private Date sysCreateTime;

    /**
     * 更新日期
     */
    private Date sysUpdateTime;

    /**
     * 备注
     */
    private String remark;
    /**
     * codeType-挑战奖金类型
     */
    public static final String CT_CHALLENGE_BONUS_TYPE = "challenge_bonus_type";
    /**
     * codeType-挑战奖金类型
     */
    public static final String CT_BONUS_TYPE = "bonus_type";
    /**
     * codeType-扣款类型
     */
    public static final String CT_DEDUCTIONS_TYPE = "deductions_type";
    

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodetype() {
        return codetype;
    }

    public void setCodetype(String codetype) {
        this.codetype = codetype == null ? null : codetype.trim();
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename == null ? null : codename.trim();
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype == null ? null : valuetype.trim();
    }

    public String getValuename() {
        return valuename;
    }

    public void setValuename(String valuename) {
        this.valuename = valuename == null ? null : valuename.trim();
    }

    public Date getSysCreateTime() {
        return sysCreateTime;
    }

    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", codetype=").append(codetype);
        sb.append(", codename=").append(codename);
        sb.append(", valuetype=").append(valuetype);
        sb.append(", valuename=").append(valuename);
        sb.append(", sysCreateTime=").append(sysCreateTime);
        sb.append(", sysUpdateTime=").append(sysUpdateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}