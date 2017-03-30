package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AreaQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public AreaQuery() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementIsNull() {
            addCriterion("area_meal_supplement is null");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementIsNotNull() {
            addCriterion("area_meal_supplement is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementEqualTo(BigDecimal value) {
            addCriterion("area_meal_supplement =", value, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementNotEqualTo(BigDecimal value) {
            addCriterion("area_meal_supplement <>", value, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementGreaterThan(BigDecimal value) {
            addCriterion("area_meal_supplement >", value, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("area_meal_supplement >=", value, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementLessThan(BigDecimal value) {
            addCriterion("area_meal_supplement <", value, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementLessThanOrEqualTo(BigDecimal value) {
            addCriterion("area_meal_supplement <=", value, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementIn(List<BigDecimal> values) {
            addCriterion("area_meal_supplement in", values, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementNotIn(List<BigDecimal> values) {
            addCriterion("area_meal_supplement not in", values, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area_meal_supplement between", value1, value2, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaMealSupplementNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area_meal_supplement not between", value1, value2, "areaMealSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementIsNull() {
            addCriterion("area_house_supplement is null");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementIsNotNull() {
            addCriterion("area_house_supplement is not null");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementEqualTo(BigDecimal value) {
            addCriterion("area_house_supplement =", value, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementNotEqualTo(BigDecimal value) {
            addCriterion("area_house_supplement <>", value, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementGreaterThan(BigDecimal value) {
            addCriterion("area_house_supplement >", value, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("area_house_supplement >=", value, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementLessThan(BigDecimal value) {
            addCriterion("area_house_supplement <", value, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementLessThanOrEqualTo(BigDecimal value) {
            addCriterion("area_house_supplement <=", value, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementIn(List<BigDecimal> values) {
            addCriterion("area_house_supplement in", values, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementNotIn(List<BigDecimal> values) {
            addCriterion("area_house_supplement not in", values, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area_house_supplement between", value1, value2, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaHouseSupplementNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area_house_supplement not between", value1, value2, "areaHouseSupplement");
            return (Criteria) this;
        }

        public Criteria andAreaLevelIsNull() {
            addCriterion("area_level is null");
            return (Criteria) this;
        }

        public Criteria andAreaLevelIsNotNull() {
            addCriterion("area_level is not null");
            return (Criteria) this;
        }

        public Criteria andAreaLevelEqualTo(String value) {
            addCriterion("area_level =", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelNotEqualTo(String value) {
            addCriterion("area_level <>", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelGreaterThan(String value) {
            addCriterion("area_level >", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelGreaterThanOrEqualTo(String value) {
            addCriterion("area_level >=", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelLessThan(String value) {
            addCriterion("area_level <", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelLessThanOrEqualTo(String value) {
            addCriterion("area_level <=", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelLike(String value) {
            addCriterion("area_level like", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelNotLike(String value) {
            addCriterion("area_level not like", value, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelIn(List<String> values) {
            addCriterion("area_level in", values, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelNotIn(List<String> values) {
            addCriterion("area_level not in", values, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelBetween(String value1, String value2) {
            addCriterion("area_level between", value1, value2, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andAreaLevelNotBetween(String value1, String value2) {
            addCriterion("area_level not between", value1, value2, "areaLevel");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeIsNull() {
            addCriterion("father_area_code is null");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeIsNotNull() {
            addCriterion("father_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeEqualTo(String value) {
            addCriterion("father_area_code =", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeNotEqualTo(String value) {
            addCriterion("father_area_code <>", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeGreaterThan(String value) {
            addCriterion("father_area_code >", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("father_area_code >=", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeLessThan(String value) {
            addCriterion("father_area_code <", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("father_area_code <=", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeLike(String value) {
            addCriterion("father_area_code like", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeNotLike(String value) {
            addCriterion("father_area_code not like", value, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeIn(List<String> values) {
            addCriterion("father_area_code in", values, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeNotIn(List<String> values) {
            addCriterion("father_area_code not in", values, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeBetween(String value1, String value2) {
            addCriterion("father_area_code between", value1, value2, "fatherAreaCode");
            return (Criteria) this;
        }

        public Criteria andFatherAreaCodeNotBetween(String value1, String value2) {
            addCriterion("father_area_code not between", value1, value2, "fatherAreaCode");
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