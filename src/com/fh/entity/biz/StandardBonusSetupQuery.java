package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StandardBonusSetupQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StandardBonusSetupQuery() {
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

        public Criteria andStartRateIsNull() {
            addCriterion("start_rate is null");
            return (Criteria) this;
        }

        public Criteria andStartRateIsNotNull() {
            addCriterion("start_rate is not null");
            return (Criteria) this;
        }

        public Criteria andStartRateEqualTo(BigDecimal value) {
            addCriterion("start_rate =", value, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateNotEqualTo(BigDecimal value) {
            addCriterion("start_rate <>", value, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateGreaterThan(BigDecimal value) {
            addCriterion("start_rate >", value, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("start_rate >=", value, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateLessThan(BigDecimal value) {
            addCriterion("start_rate <", value, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("start_rate <=", value, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateIn(List<BigDecimal> values) {
            addCriterion("start_rate in", values, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateNotIn(List<BigDecimal> values) {
            addCriterion("start_rate not in", values, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_rate between", value1, value2, "startRate");
            return (Criteria) this;
        }

        public Criteria andStartRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("start_rate not between", value1, value2, "startRate");
            return (Criteria) this;
        }

        public Criteria andEndRateIsNull() {
            addCriterion("end_rate is null");
            return (Criteria) this;
        }

        public Criteria andEndRateIsNotNull() {
            addCriterion("end_rate is not null");
            return (Criteria) this;
        }

        public Criteria andEndRateEqualTo(BigDecimal value) {
            addCriterion("end_rate =", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateNotEqualTo(BigDecimal value) {
            addCriterion("end_rate <>", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateGreaterThan(BigDecimal value) {
            addCriterion("end_rate >", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("end_rate >=", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateLessThan(BigDecimal value) {
            addCriterion("end_rate <", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("end_rate <=", value, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateIn(List<BigDecimal> values) {
            addCriterion("end_rate in", values, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateNotIn(List<BigDecimal> values) {
            addCriterion("end_rate not in", values, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_rate between", value1, value2, "endRate");
            return (Criteria) this;
        }

        public Criteria andEndRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("end_rate not between", value1, value2, "endRate");
            return (Criteria) this;
        }

        public Criteria andBonusAmtIsNull() {
            addCriterion("bonus_amt is null");
            return (Criteria) this;
        }

        public Criteria andBonusAmtIsNotNull() {
            addCriterion("bonus_amt is not null");
            return (Criteria) this;
        }

        public Criteria andBonusAmtEqualTo(BigDecimal value) {
            addCriterion("bonus_amt =", value, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtNotEqualTo(BigDecimal value) {
            addCriterion("bonus_amt <>", value, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtGreaterThan(BigDecimal value) {
            addCriterion("bonus_amt >", value, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus_amt >=", value, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtLessThan(BigDecimal value) {
            addCriterion("bonus_amt <", value, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus_amt <=", value, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtIn(List<BigDecimal> values) {
            addCriterion("bonus_amt in", values, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtNotIn(List<BigDecimal> values) {
            addCriterion("bonus_amt not in", values, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus_amt between", value1, value2, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus_amt not between", value1, value2, "bonusAmt");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientIsNull() {
            addCriterion("bonus_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientIsNotNull() {
            addCriterion("bonus_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientEqualTo(BigDecimal value) {
            addCriterion("bonus_coefficient =", value, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("bonus_coefficient <>", value, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientGreaterThan(BigDecimal value) {
            addCriterion("bonus_coefficient >", value, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus_coefficient >=", value, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientLessThan(BigDecimal value) {
            addCriterion("bonus_coefficient <", value, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus_coefficient <=", value, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientIn(List<BigDecimal> values) {
            addCriterion("bonus_coefficient in", values, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("bonus_coefficient not in", values, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus_coefficient between", value1, value2, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andBonusCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus_coefficient not between", value1, value2, "bonusCoefficient");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeIsNull() {
            addCriterion("standard_bonus_type is null");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeIsNotNull() {
            addCriterion("standard_bonus_type is not null");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeEqualTo(String value) {
            addCriterion("standard_bonus_type =", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeNotEqualTo(String value) {
            addCriterion("standard_bonus_type <>", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeGreaterThan(String value) {
            addCriterion("standard_bonus_type >", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeGreaterThanOrEqualTo(String value) {
            addCriterion("standard_bonus_type >=", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeLessThan(String value) {
            addCriterion("standard_bonus_type <", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeLessThanOrEqualTo(String value) {
            addCriterion("standard_bonus_type <=", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeLike(String value) {
            addCriterion("standard_bonus_type like", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeNotLike(String value) {
            addCriterion("standard_bonus_type not like", value, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeIn(List<String> values) {
            addCriterion("standard_bonus_type in", values, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeNotIn(List<String> values) {
            addCriterion("standard_bonus_type not in", values, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeBetween(String value1, String value2) {
            addCriterion("standard_bonus_type between", value1, value2, "standardBonusType");
            return (Criteria) this;
        }

        public Criteria andStandardBonusTypeNotBetween(String value1, String value2) {
            addCriterion("standard_bonus_type not between", value1, value2, "standardBonusType");
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