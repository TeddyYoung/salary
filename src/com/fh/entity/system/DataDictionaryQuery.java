package com.fh.entity.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDictionaryQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public DataDictionaryQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodetypeIsNull() {
            addCriterion("codeType is null");
            return (Criteria) this;
        }

        public Criteria andCodetypeIsNotNull() {
            addCriterion("codeType is not null");
            return (Criteria) this;
        }

        public Criteria andCodetypeEqualTo(String value) {
            addCriterion("codeType =", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeNotEqualTo(String value) {
            addCriterion("codeType <>", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeGreaterThan(String value) {
            addCriterion("codeType >", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeGreaterThanOrEqualTo(String value) {
            addCriterion("codeType >=", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeLessThan(String value) {
            addCriterion("codeType <", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeLessThanOrEqualTo(String value) {
            addCriterion("codeType <=", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeLike(String value) {
            addCriterion("codeType like", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeNotLike(String value) {
            addCriterion("codeType not like", value, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeIn(List<String> values) {
            addCriterion("codeType in", values, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeNotIn(List<String> values) {
            addCriterion("codeType not in", values, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeBetween(String value1, String value2) {
            addCriterion("codeType between", value1, value2, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodetypeNotBetween(String value1, String value2) {
            addCriterion("codeType not between", value1, value2, "codetype");
            return (Criteria) this;
        }

        public Criteria andCodenameIsNull() {
            addCriterion("codeName is null");
            return (Criteria) this;
        }

        public Criteria andCodenameIsNotNull() {
            addCriterion("codeName is not null");
            return (Criteria) this;
        }

        public Criteria andCodenameEqualTo(String value) {
            addCriterion("codeName =", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotEqualTo(String value) {
            addCriterion("codeName <>", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameGreaterThan(String value) {
            addCriterion("codeName >", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameGreaterThanOrEqualTo(String value) {
            addCriterion("codeName >=", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameLessThan(String value) {
            addCriterion("codeName <", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameLessThanOrEqualTo(String value) {
            addCriterion("codeName <=", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameLike(String value) {
            addCriterion("codeName like", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotLike(String value) {
            addCriterion("codeName not like", value, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameIn(List<String> values) {
            addCriterion("codeName in", values, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotIn(List<String> values) {
            addCriterion("codeName not in", values, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameBetween(String value1, String value2) {
            addCriterion("codeName between", value1, value2, "codename");
            return (Criteria) this;
        }

        public Criteria andCodenameNotBetween(String value1, String value2) {
            addCriterion("codeName not between", value1, value2, "codename");
            return (Criteria) this;
        }

        public Criteria andValuetypeIsNull() {
            addCriterion("valueType is null");
            return (Criteria) this;
        }

        public Criteria andValuetypeIsNotNull() {
            addCriterion("valueType is not null");
            return (Criteria) this;
        }

        public Criteria andValuetypeEqualTo(String value) {
            addCriterion("valueType =", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotEqualTo(String value) {
            addCriterion("valueType <>", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeGreaterThan(String value) {
            addCriterion("valueType >", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeGreaterThanOrEqualTo(String value) {
            addCriterion("valueType >=", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeLessThan(String value) {
            addCriterion("valueType <", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeLessThanOrEqualTo(String value) {
            addCriterion("valueType <=", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeLike(String value) {
            addCriterion("valueType like", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotLike(String value) {
            addCriterion("valueType not like", value, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeIn(List<String> values) {
            addCriterion("valueType in", values, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotIn(List<String> values) {
            addCriterion("valueType not in", values, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeBetween(String value1, String value2) {
            addCriterion("valueType between", value1, value2, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuetypeNotBetween(String value1, String value2) {
            addCriterion("valueType not between", value1, value2, "valuetype");
            return (Criteria) this;
        }

        public Criteria andValuenameIsNull() {
            addCriterion("valueName is null");
            return (Criteria) this;
        }

        public Criteria andValuenameIsNotNull() {
            addCriterion("valueName is not null");
            return (Criteria) this;
        }

        public Criteria andValuenameEqualTo(String value) {
            addCriterion("valueName =", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameNotEqualTo(String value) {
            addCriterion("valueName <>", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameGreaterThan(String value) {
            addCriterion("valueName >", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameGreaterThanOrEqualTo(String value) {
            addCriterion("valueName >=", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameLessThan(String value) {
            addCriterion("valueName <", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameLessThanOrEqualTo(String value) {
            addCriterion("valueName <=", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameLike(String value) {
            addCriterion("valueName like", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameNotLike(String value) {
            addCriterion("valueName not like", value, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameIn(List<String> values) {
            addCriterion("valueName in", values, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameNotIn(List<String> values) {
            addCriterion("valueName not in", values, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameBetween(String value1, String value2) {
            addCriterion("valueName between", value1, value2, "valuename");
            return (Criteria) this;
        }

        public Criteria andValuenameNotBetween(String value1, String value2) {
            addCriterion("valueName not between", value1, value2, "valuename");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeIsNull() {
            addCriterion("sys_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeIsNotNull() {
            addCriterion("sys_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeEqualTo(Date value) {
            addCriterion("sys_create_time =", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeNotEqualTo(Date value) {
            addCriterion("sys_create_time <>", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeGreaterThan(Date value) {
            addCriterion("sys_create_time >", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_create_time >=", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeLessThan(Date value) {
            addCriterion("sys_create_time <", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_create_time <=", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeIn(List<Date> values) {
            addCriterion("sys_create_time in", values, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeNotIn(List<Date> values) {
            addCriterion("sys_create_time not in", values, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeBetween(Date value1, Date value2) {
            addCriterion("sys_create_time between", value1, value2, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_create_time not between", value1, value2, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeIsNull() {
            addCriterion("sys_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeIsNotNull() {
            addCriterion("sys_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeEqualTo(Date value) {
            addCriterion("sys_update_time =", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeNotEqualTo(Date value) {
            addCriterion("sys_update_time <>", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeGreaterThan(Date value) {
            addCriterion("sys_update_time >", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sys_update_time >=", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeLessThan(Date value) {
            addCriterion("sys_update_time <", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sys_update_time <=", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeIn(List<Date> values) {
            addCriterion("sys_update_time in", values, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeNotIn(List<Date> values) {
            addCriterion("sys_update_time not in", values, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("sys_update_time between", value1, value2, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sys_update_time not between", value1, value2, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}