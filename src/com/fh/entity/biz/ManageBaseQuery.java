package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageBaseQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ManageBaseQuery() {
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

        public Criteria andStaffCodeIsNull() {
            addCriterion("staff_code is null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIsNotNull() {
            addCriterion("staff_code is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCodeEqualTo(String value) {
            addCriterion("staff_code =", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotEqualTo(String value) {
            addCriterion("staff_code <>", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThan(String value) {
            addCriterion("staff_code >", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeGreaterThanOrEqualTo(String value) {
            addCriterion("staff_code >=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThan(String value) {
            addCriterion("staff_code <", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLessThanOrEqualTo(String value) {
            addCriterion("staff_code <=", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeLike(String value) {
            addCriterion("staff_code like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotLike(String value) {
            addCriterion("staff_code not like", value, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeIn(List<String> values) {
            addCriterion("staff_code in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotIn(List<String> values) {
            addCriterion("staff_code not in", values, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeBetween(String value1, String value2) {
            addCriterion("staff_code between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStaffCodeNotBetween(String value1, String value2) {
            addCriterion("staff_code not between", value1, value2, "staffCode");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNull() {
            addCriterion("station_name is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("station_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("station_name =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("station_name <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("station_name >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_name >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("station_name <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("station_name <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("station_name like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("station_name not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("station_name in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("station_name not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("station_name between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("station_name not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andDutyNameIsNull() {
            addCriterion("duty_name is null");
            return (Criteria) this;
        }

        public Criteria andDutyNameIsNotNull() {
            addCriterion("duty_name is not null");
            return (Criteria) this;
        }

        public Criteria andDutyNameEqualTo(String value) {
            addCriterion("duty_name =", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotEqualTo(String value) {
            addCriterion("duty_name <>", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameGreaterThan(String value) {
            addCriterion("duty_name >", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameGreaterThanOrEqualTo(String value) {
            addCriterion("duty_name >=", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameLessThan(String value) {
            addCriterion("duty_name <", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameLessThanOrEqualTo(String value) {
            addCriterion("duty_name <=", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameLike(String value) {
            addCriterion("duty_name like", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotLike(String value) {
            addCriterion("duty_name not like", value, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameIn(List<String> values) {
            addCriterion("duty_name in", values, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotIn(List<String> values) {
            addCriterion("duty_name not in", values, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameBetween(String value1, String value2) {
            addCriterion("duty_name between", value1, value2, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNameNotBetween(String value1, String value2) {
            addCriterion("duty_name not between", value1, value2, "dutyName");
            return (Criteria) this;
        }

        public Criteria andDutyNatureIsNull() {
            addCriterion("duty_nature is null");
            return (Criteria) this;
        }

        public Criteria andDutyNatureIsNotNull() {
            addCriterion("duty_nature is not null");
            return (Criteria) this;
        }

        public Criteria andDutyNatureEqualTo(String value) {
            addCriterion("duty_nature =", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureNotEqualTo(String value) {
            addCriterion("duty_nature <>", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureGreaterThan(String value) {
            addCriterion("duty_nature >", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureGreaterThanOrEqualTo(String value) {
            addCriterion("duty_nature >=", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureLessThan(String value) {
            addCriterion("duty_nature <", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureLessThanOrEqualTo(String value) {
            addCriterion("duty_nature <=", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureLike(String value) {
            addCriterion("duty_nature like", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureNotLike(String value) {
            addCriterion("duty_nature not like", value, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureIn(List<String> values) {
            addCriterion("duty_nature in", values, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureNotIn(List<String> values) {
            addCriterion("duty_nature not in", values, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureBetween(String value1, String value2) {
            addCriterion("duty_nature between", value1, value2, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyNatureNotBetween(String value1, String value2) {
            addCriterion("duty_nature not between", value1, value2, "dutyNature");
            return (Criteria) this;
        }

        public Criteria andDutyLevelIsNull() {
            addCriterion("duty_level is null");
            return (Criteria) this;
        }

        public Criteria andDutyLevelIsNotNull() {
            addCriterion("duty_level is not null");
            return (Criteria) this;
        }

        public Criteria andDutyLevelEqualTo(String value) {
            addCriterion("duty_level =", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelNotEqualTo(String value) {
            addCriterion("duty_level <>", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelGreaterThan(String value) {
            addCriterion("duty_level >", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelGreaterThanOrEqualTo(String value) {
            addCriterion("duty_level >=", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelLessThan(String value) {
            addCriterion("duty_level <", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelLessThanOrEqualTo(String value) {
            addCriterion("duty_level <=", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelLike(String value) {
            addCriterion("duty_level like", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelNotLike(String value) {
            addCriterion("duty_level not like", value, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelIn(List<String> values) {
            addCriterion("duty_level in", values, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelNotIn(List<String> values) {
            addCriterion("duty_level not in", values, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelBetween(String value1, String value2) {
            addCriterion("duty_level between", value1, value2, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andDutyLevelNotBetween(String value1, String value2) {
            addCriterion("duty_level not between", value1, value2, "dutyLevel");
            return (Criteria) this;
        }

        public Criteria andPostSalaryIsNull() {
            addCriterion("post_salary is null");
            return (Criteria) this;
        }

        public Criteria andPostSalaryIsNotNull() {
            addCriterion("post_salary is not null");
            return (Criteria) this;
        }

        public Criteria andPostSalaryEqualTo(BigDecimal value) {
            addCriterion("post_salary =", value, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryNotEqualTo(BigDecimal value) {
            addCriterion("post_salary <>", value, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryGreaterThan(BigDecimal value) {
            addCriterion("post_salary >", value, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("post_salary >=", value, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryLessThan(BigDecimal value) {
            addCriterion("post_salary <", value, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("post_salary <=", value, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryIn(List<BigDecimal> values) {
            addCriterion("post_salary in", values, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryNotIn(List<BigDecimal> values) {
            addCriterion("post_salary not in", values, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_salary between", value1, value2, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPostSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_salary not between", value1, value2, "postSalary");
            return (Criteria) this;
        }

        public Criteria andPhoneCostIsNull() {
            addCriterion("phone_cost is null");
            return (Criteria) this;
        }

        public Criteria andPhoneCostIsNotNull() {
            addCriterion("phone_cost is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneCostEqualTo(BigDecimal value) {
            addCriterion("phone_cost =", value, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostNotEqualTo(BigDecimal value) {
            addCriterion("phone_cost <>", value, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostGreaterThan(BigDecimal value) {
            addCriterion("phone_cost >", value, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("phone_cost >=", value, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostLessThan(BigDecimal value) {
            addCriterion("phone_cost <", value, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("phone_cost <=", value, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostIn(List<BigDecimal> values) {
            addCriterion("phone_cost in", values, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostNotIn(List<BigDecimal> values) {
            addCriterion("phone_cost not in", values, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("phone_cost between", value1, value2, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPhoneCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("phone_cost not between", value1, value2, "phoneCost");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientIsNull() {
            addCriterion("performance_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientIsNotNull() {
            addCriterion("performance_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientEqualTo(BigDecimal value) {
            addCriterion("performance_coefficient =", value, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("performance_coefficient <>", value, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientGreaterThan(BigDecimal value) {
            addCriterion("performance_coefficient >", value, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("performance_coefficient >=", value, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientLessThan(BigDecimal value) {
            addCriterion("performance_coefficient <", value, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("performance_coefficient <=", value, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientIn(List<BigDecimal> values) {
            addCriterion("performance_coefficient in", values, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("performance_coefficient not in", values, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance_coefficient between", value1, value2, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andPerformanceCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance_coefficient not between", value1, value2, "performanceCoefficient");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesIsNull() {
            addCriterion("job_subsidies is null");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesIsNotNull() {
            addCriterion("job_subsidies is not null");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesEqualTo(BigDecimal value) {
            addCriterion("job_subsidies =", value, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesNotEqualTo(BigDecimal value) {
            addCriterion("job_subsidies <>", value, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesGreaterThan(BigDecimal value) {
            addCriterion("job_subsidies >", value, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("job_subsidies >=", value, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesLessThan(BigDecimal value) {
            addCriterion("job_subsidies <", value, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("job_subsidies <=", value, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesIn(List<BigDecimal> values) {
            addCriterion("job_subsidies in", values, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesNotIn(List<BigDecimal> values) {
            addCriterion("job_subsidies not in", values, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("job_subsidies between", value1, value2, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andJobSubsidiesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("job_subsidies not between", value1, value2, "jobSubsidies");
            return (Criteria) this;
        }

        public Criteria andBonusBaseIsNull() {
            addCriterion("bonus_base is null");
            return (Criteria) this;
        }

        public Criteria andBonusBaseIsNotNull() {
            addCriterion("bonus_base is not null");
            return (Criteria) this;
        }

        public Criteria andBonusBaseEqualTo(BigDecimal value) {
            addCriterion("bonus_base =", value, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseNotEqualTo(BigDecimal value) {
            addCriterion("bonus_base <>", value, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseGreaterThan(BigDecimal value) {
            addCriterion("bonus_base >", value, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus_base >=", value, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseLessThan(BigDecimal value) {
            addCriterion("bonus_base <", value, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bonus_base <=", value, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseIn(List<BigDecimal> values) {
            addCriterion("bonus_base in", values, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseNotIn(List<BigDecimal> values) {
            addCriterion("bonus_base not in", values, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus_base between", value1, value2, "bonusBase");
            return (Criteria) this;
        }

        public Criteria andBonusBaseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bonus_base not between", value1, value2, "bonusBase");
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

        public Criteria andStandardRateIsNull() {
            addCriterion("standard_rate is null");
            return (Criteria) this;
        }

        public Criteria andStandardRateIsNotNull() {
            addCriterion("standard_rate is not null");
            return (Criteria) this;
        }

        public Criteria andStandardRateEqualTo(BigDecimal value) {
            addCriterion("standard_rate =", value, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateNotEqualTo(BigDecimal value) {
            addCriterion("standard_rate <>", value, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateGreaterThan(BigDecimal value) {
            addCriterion("standard_rate >", value, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("standard_rate >=", value, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateLessThan(BigDecimal value) {
            addCriterion("standard_rate <", value, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("standard_rate <=", value, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateIn(List<BigDecimal> values) {
            addCriterion("standard_rate in", values, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateNotIn(List<BigDecimal> values) {
            addCriterion("standard_rate not in", values, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("standard_rate between", value1, value2, "standardRate");
            return (Criteria) this;
        }

        public Criteria andStandardRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("standard_rate not between", value1, value2, "standardRate");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionIsNull() {
            addCriterion("phone_cost_detection is null");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionIsNotNull() {
            addCriterion("phone_cost_detection is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionEqualTo(String value) {
            addCriterion("phone_cost_detection =", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionNotEqualTo(String value) {
            addCriterion("phone_cost_detection <>", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionGreaterThan(String value) {
            addCriterion("phone_cost_detection >", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionGreaterThanOrEqualTo(String value) {
            addCriterion("phone_cost_detection >=", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionLessThan(String value) {
            addCriterion("phone_cost_detection <", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionLessThanOrEqualTo(String value) {
            addCriterion("phone_cost_detection <=", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionLike(String value) {
            addCriterion("phone_cost_detection like", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionNotLike(String value) {
            addCriterion("phone_cost_detection not like", value, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionIn(List<String> values) {
            addCriterion("phone_cost_detection in", values, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionNotIn(List<String> values) {
            addCriterion("phone_cost_detection not in", values, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionBetween(String value1, String value2) {
            addCriterion("phone_cost_detection between", value1, value2, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andPhoneCostDetectionNotBetween(String value1, String value2) {
            addCriterion("phone_cost_detection not between", value1, value2, "phoneCostDetection");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesIsNull() {
            addCriterion("station_staff_bonuses is null");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesIsNotNull() {
            addCriterion("station_staff_bonuses is not null");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesEqualTo(BigDecimal value) {
            addCriterion("station_staff_bonuses =", value, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesNotEqualTo(BigDecimal value) {
            addCriterion("station_staff_bonuses <>", value, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesGreaterThan(BigDecimal value) {
            addCriterion("station_staff_bonuses >", value, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("station_staff_bonuses >=", value, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesLessThan(BigDecimal value) {
            addCriterion("station_staff_bonuses <", value, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("station_staff_bonuses <=", value, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesIn(List<BigDecimal> values) {
            addCriterion("station_staff_bonuses in", values, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesNotIn(List<BigDecimal> values) {
            addCriterion("station_staff_bonuses not in", values, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("station_staff_bonuses between", value1, value2, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andStationStaffBonusesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("station_staff_bonuses not between", value1, value2, "stationStaffBonuses");
            return (Criteria) this;
        }

        public Criteria andYearMonthIsNull() {
            addCriterion("year_month is null");
            return (Criteria) this;
        }

        public Criteria andYearMonthIsNotNull() {
            addCriterion("year_month is not null");
            return (Criteria) this;
        }

        public Criteria andYearMonthEqualTo(String value) {
            addCriterion("year_month =", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotEqualTo(String value) {
            addCriterion("year_month <>", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthGreaterThan(String value) {
            addCriterion("year_month >", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthGreaterThanOrEqualTo(String value) {
            addCriterion("year_month >=", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthLessThan(String value) {
            addCriterion("year_month <", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthLessThanOrEqualTo(String value) {
            addCriterion("year_month <=", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthLike(String value) {
            addCriterion("year_month like", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotLike(String value) {
            addCriterion("year_month not like", value, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthIn(List<String> values) {
            addCriterion("year_month in", values, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotIn(List<String> values) {
            addCriterion("year_month not in", values, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthBetween(String value1, String value2) {
            addCriterion("year_month between", value1, value2, "yearMonth");
            return (Criteria) this;
        }

        public Criteria andYearMonthNotBetween(String value1, String value2) {
            addCriterion("year_month not between", value1, value2, "yearMonth");
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