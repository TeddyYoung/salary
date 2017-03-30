package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryDifferenceQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public SalaryDifferenceQuery() {
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

        public Criteria andSalaryDifferenceCodeIsNull() {
            addCriterion("salary_difference_code is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeIsNotNull() {
            addCriterion("salary_difference_code is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeEqualTo(String value) {
            addCriterion("salary_difference_code =", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeNotEqualTo(String value) {
            addCriterion("salary_difference_code <>", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeGreaterThan(String value) {
            addCriterion("salary_difference_code >", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("salary_difference_code >=", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeLessThan(String value) {
            addCriterion("salary_difference_code <", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeLessThanOrEqualTo(String value) {
            addCriterion("salary_difference_code <=", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeLike(String value) {
            addCriterion("salary_difference_code like", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeNotLike(String value) {
            addCriterion("salary_difference_code not like", value, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeIn(List<String> values) {
            addCriterion("salary_difference_code in", values, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeNotIn(List<String> values) {
            addCriterion("salary_difference_code not in", values, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeBetween(String value1, String value2) {
            addCriterion("salary_difference_code between", value1, value2, "salaryDifferenceCode");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceCodeNotBetween(String value1, String value2) {
            addCriterion("salary_difference_code not between", value1, value2, "salaryDifferenceCode");
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

        public Criteria andStaffNameIsNull() {
            addCriterion("staff_name is null");
            return (Criteria) this;
        }

        public Criteria andStaffNameIsNotNull() {
            addCriterion("staff_name is not null");
            return (Criteria) this;
        }

        public Criteria andStaffNameEqualTo(String value) {
            addCriterion("staff_name =", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotEqualTo(String value) {
            addCriterion("staff_name <>", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThan(String value) {
            addCriterion("staff_name >", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameGreaterThanOrEqualTo(String value) {
            addCriterion("staff_name >=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThan(String value) {
            addCriterion("staff_name <", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLessThanOrEqualTo(String value) {
            addCriterion("staff_name <=", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameLike(String value) {
            addCriterion("staff_name like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotLike(String value) {
            addCriterion("staff_name not like", value, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameIn(List<String> values) {
            addCriterion("staff_name in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotIn(List<String> values) {
            addCriterion("staff_name not in", values, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameBetween(String value1, String value2) {
            addCriterion("staff_name between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andStaffNameNotBetween(String value1, String value2) {
            addCriterion("staff_name not between", value1, value2, "staffName");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryIsNull() {
            addCriterion("salary_summary is null");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryIsNotNull() {
            addCriterion("salary_summary is not null");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryEqualTo(BigDecimal value) {
            addCriterion("salary_summary =", value, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryNotEqualTo(BigDecimal value) {
            addCriterion("salary_summary <>", value, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryGreaterThan(BigDecimal value) {
            addCriterion("salary_summary >", value, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_summary >=", value, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryLessThan(BigDecimal value) {
            addCriterion("salary_summary <", value, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_summary <=", value, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryIn(List<BigDecimal> values) {
            addCriterion("salary_summary in", values, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryNotIn(List<BigDecimal> values) {
            addCriterion("salary_summary not in", values, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_summary between", value1, value2, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalarySummaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_summary not between", value1, value2, "salarySummary");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveIsNull() {
            addCriterion("salary_difference_positive is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveIsNotNull() {
            addCriterion("salary_difference_positive is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveEqualTo(BigDecimal value) {
            addCriterion("salary_difference_positive =", value, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveNotEqualTo(BigDecimal value) {
            addCriterion("salary_difference_positive <>", value, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveGreaterThan(BigDecimal value) {
            addCriterion("salary_difference_positive >", value, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_difference_positive >=", value, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveLessThan(BigDecimal value) {
            addCriterion("salary_difference_positive <", value, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_difference_positive <=", value, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveIn(List<BigDecimal> values) {
            addCriterion("salary_difference_positive in", values, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveNotIn(List<BigDecimal> values) {
            addCriterion("salary_difference_positive not in", values, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_difference_positive between", value1, value2, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferencePositiveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_difference_positive not between", value1, value2, "salaryDifferencePositive");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeIsNull() {
            addCriterion("salary_difference_negative is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeIsNotNull() {
            addCriterion("salary_difference_negative is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeEqualTo(BigDecimal value) {
            addCriterion("salary_difference_negative =", value, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeNotEqualTo(BigDecimal value) {
            addCriterion("salary_difference_negative <>", value, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeGreaterThan(BigDecimal value) {
            addCriterion("salary_difference_negative >", value, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_difference_negative >=", value, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeLessThan(BigDecimal value) {
            addCriterion("salary_difference_negative <", value, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_difference_negative <=", value, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeIn(List<BigDecimal> values) {
            addCriterion("salary_difference_negative in", values, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeNotIn(List<BigDecimal> values) {
            addCriterion("salary_difference_negative not in", values, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_difference_negative between", value1, value2, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceNegativeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_difference_negative not between", value1, value2, "salaryDifferenceNegative");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNull() {
            addCriterion("approval_status is null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIsNotNull() {
            addCriterion("approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusEqualTo(String value) {
            addCriterion("approval_status =", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotEqualTo(String value) {
            addCriterion("approval_status <>", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThan(String value) {
            addCriterion("approval_status >", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("approval_status >=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThan(String value) {
            addCriterion("approval_status <", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLessThanOrEqualTo(String value) {
            addCriterion("approval_status <=", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusLike(String value) {
            addCriterion("approval_status like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotLike(String value) {
            addCriterion("approval_status not like", value, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusIn(List<String> values) {
            addCriterion("approval_status in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotIn(List<String> values) {
            addCriterion("approval_status not in", values, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusBetween(String value1, String value2) {
            addCriterion("approval_status between", value1, value2, "approvalStatus");
            return (Criteria) this;
        }

        public Criteria andApprovalStatusNotBetween(String value1, String value2) {
            addCriterion("approval_status not between", value1, value2, "approvalStatus");
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