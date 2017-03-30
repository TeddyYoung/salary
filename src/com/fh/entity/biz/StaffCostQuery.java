package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffCostQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StaffCostQuery() {
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

        public Criteria andStaffCostYearMonthIsNull() {
            addCriterion("staff_cost_year_month is null");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthIsNotNull() {
            addCriterion("staff_cost_year_month is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthEqualTo(String value) {
            addCriterion("staff_cost_year_month =", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthNotEqualTo(String value) {
            addCriterion("staff_cost_year_month <>", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthGreaterThan(String value) {
            addCriterion("staff_cost_year_month >", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthGreaterThanOrEqualTo(String value) {
            addCriterion("staff_cost_year_month >=", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthLessThan(String value) {
            addCriterion("staff_cost_year_month <", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthLessThanOrEqualTo(String value) {
            addCriterion("staff_cost_year_month <=", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthLike(String value) {
            addCriterion("staff_cost_year_month like", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthNotLike(String value) {
            addCriterion("staff_cost_year_month not like", value, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthIn(List<String> values) {
            addCriterion("staff_cost_year_month in", values, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthNotIn(List<String> values) {
            addCriterion("staff_cost_year_month not in", values, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthBetween(String value1, String value2) {
            addCriterion("staff_cost_year_month between", value1, value2, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostYearMonthNotBetween(String value1, String value2) {
            addCriterion("staff_cost_year_month not between", value1, value2, "staffCostYearMonth");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundIsNull() {
            addCriterion("staff_cost_acc_fund is null");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundIsNotNull() {
            addCriterion("staff_cost_acc_fund is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundEqualTo(BigDecimal value) {
            addCriterion("staff_cost_acc_fund =", value, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundNotEqualTo(BigDecimal value) {
            addCriterion("staff_cost_acc_fund <>", value, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundGreaterThan(BigDecimal value) {
            addCriterion("staff_cost_acc_fund >", value, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_acc_fund >=", value, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundLessThan(BigDecimal value) {
            addCriterion("staff_cost_acc_fund <", value, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundLessThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_acc_fund <=", value, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundIn(List<BigDecimal> values) {
            addCriterion("staff_cost_acc_fund in", values, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundNotIn(List<BigDecimal> values) {
            addCriterion("staff_cost_acc_fund not in", values, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_acc_fund between", value1, value2, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostAccFundNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_acc_fund not between", value1, value2, "staffCostAccFund");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentIsNull() {
            addCriterion("staff_cost_endowment is null");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentIsNotNull() {
            addCriterion("staff_cost_endowment is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentEqualTo(BigDecimal value) {
            addCriterion("staff_cost_endowment =", value, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentNotEqualTo(BigDecimal value) {
            addCriterion("staff_cost_endowment <>", value, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentGreaterThan(BigDecimal value) {
            addCriterion("staff_cost_endowment >", value, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_endowment >=", value, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentLessThan(BigDecimal value) {
            addCriterion("staff_cost_endowment <", value, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_endowment <=", value, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentIn(List<BigDecimal> values) {
            addCriterion("staff_cost_endowment in", values, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentNotIn(List<BigDecimal> values) {
            addCriterion("staff_cost_endowment not in", values, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_endowment between", value1, value2, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostEndowmentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_endowment not between", value1, value2, "staffCostEndowment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentIsNull() {
            addCriterion("staff_cost_unemployment is null");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentIsNotNull() {
            addCriterion("staff_cost_unemployment is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentEqualTo(BigDecimal value) {
            addCriterion("staff_cost_unemployment =", value, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentNotEqualTo(BigDecimal value) {
            addCriterion("staff_cost_unemployment <>", value, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentGreaterThan(BigDecimal value) {
            addCriterion("staff_cost_unemployment >", value, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_unemployment >=", value, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentLessThan(BigDecimal value) {
            addCriterion("staff_cost_unemployment <", value, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_unemployment <=", value, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentIn(List<BigDecimal> values) {
            addCriterion("staff_cost_unemployment in", values, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentNotIn(List<BigDecimal> values) {
            addCriterion("staff_cost_unemployment not in", values, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_unemployment between", value1, value2, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostUnemploymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_unemployment not between", value1, value2, "staffCostUnemployment");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalIsNull() {
            addCriterion("staff_cost_medical is null");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalIsNotNull() {
            addCriterion("staff_cost_medical is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalEqualTo(BigDecimal value) {
            addCriterion("staff_cost_medical =", value, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalNotEqualTo(BigDecimal value) {
            addCriterion("staff_cost_medical <>", value, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalGreaterThan(BigDecimal value) {
            addCriterion("staff_cost_medical >", value, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_medical >=", value, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalLessThan(BigDecimal value) {
            addCriterion("staff_cost_medical <", value, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("staff_cost_medical <=", value, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalIn(List<BigDecimal> values) {
            addCriterion("staff_cost_medical in", values, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalNotIn(List<BigDecimal> values) {
            addCriterion("staff_cost_medical not in", values, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_medical between", value1, value2, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andStaffCostMedicalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("staff_cost_medical not between", value1, value2, "staffCostMedical");
            return (Criteria) this;
        }

        public Criteria andTotalIsNull() {
            addCriterion("total is null");
            return (Criteria) this;
        }

        public Criteria andTotalIsNotNull() {
            addCriterion("total is not null");
            return (Criteria) this;
        }

        public Criteria andTotalEqualTo(BigDecimal value) {
            addCriterion("total =", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotEqualTo(BigDecimal value) {
            addCriterion("total <>", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThan(BigDecimal value) {
            addCriterion("total >", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total >=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThan(BigDecimal value) {
            addCriterion("total <", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total <=", value, "total");
            return (Criteria) this;
        }

        public Criteria andTotalIn(List<BigDecimal> values) {
            addCriterion("total in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotIn(List<BigDecimal> values) {
            addCriterion("total not in", values, "total");
            return (Criteria) this;
        }

        public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total between", value1, value2, "total");
            return (Criteria) this;
        }

        public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total not between", value1, value2, "total");
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