package com.fh.entity.system;

import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {
	
	/**
	 * 日志编号
	 */
    private Long id;

    /**
     * 操作者
     */
    private String operator;

    /**
     * 操作时间
     */
    private Date operatorTime;

    /**
     * 操作类型(0:增; 1:删; 2:改; 3:查)
     */
    private String operatorType;

    /**
     * 操作的菜单
     */
    private String operatorMenu;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType == null ? null : operatorType.trim();
    }

    public String getOperatorMenu() {
        return operatorMenu;
    }

    public void setOperatorMenu(String operatorMenu) {
        this.operatorMenu = operatorMenu == null ? null : operatorMenu.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", operator=").append(operator);
        sb.append(", operatorTime=").append(operatorTime);
        sb.append(", operatorType=").append(operatorType);
        sb.append(", operatorMenu=").append(operatorMenu);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}