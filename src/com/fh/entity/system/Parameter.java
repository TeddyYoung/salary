package com.fh.entity.system;

import java.io.Serializable;

public class Parameter implements Serializable {
	
	/**
	 * 序号
	 */
    private Integer id;

    /**
     * 参数的key
     */
    private String parameterKey;

    /**
     * 参数的值
     */
    private String parameterValue;

    /**
     * 参数的类型(1:系统参数; 2:业务参数)
     */
    private String parameterType;

    /**
     * 参数的类型名称
     */
    private String parameterTypeName;

    private static final long serialVersionUID = 1L;
    /**
     *  参数的类型1:系统参数
     */
    public static final String PARAMETER_TYPE_SYS = "1";
    /**
     *  参数的类型 2:业务参数
     */
    public static final String PARAMETER_TYPE_BIZ = "2";
    /**
     * 达标率上限
     */
    public static final String KEY_STANDARD_LIMIT = "standard_limit";
    
    public static final String KEY_NON_OIL_STANDARD_LIMIT = "non_oil_standard_limit";
    /**
     * 薪资计算日
     */
    public static final String KEY_SALARY_DAY = "salaryDay";
    /**
     * 考勤是否可多次提交
     */
    public static String KEY_ATTEN_RESUBMIT = "atten_resubmit";
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParameterKey() {
        return parameterKey;
    }

    public void setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey == null ? null : parameterKey.trim();
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue == null ? null : parameterValue.trim();
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType == null ? null : parameterType.trim();
    }

    public String getParameterTypeName() {
        return parameterTypeName;
    }

    public void setParameterTypeName(String parameterTypeName) {
        this.parameterTypeName = parameterTypeName == null ? null : parameterTypeName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parameterKey=").append(parameterKey);
        sb.append(", parameterValue=").append(parameterValue);
        sb.append(", parameterType=").append(parameterType);
        sb.append(", parameterTypeName=").append(parameterTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}