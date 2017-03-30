package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceManagementQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public AttendanceManagementQuery() {
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

        public Criteria andStationCodeIsNull() {
            addCriterion("station_code is null");
            return (Criteria) this;
        }

        public Criteria andStationCodeIsNotNull() {
            addCriterion("station_code is not null");
            return (Criteria) this;
        }

        public Criteria andStationCodeEqualTo(String value) {
            addCriterion("station_code =", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotEqualTo(String value) {
            addCriterion("station_code <>", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThan(String value) {
            addCriterion("station_code >", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("station_code >=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThan(String value) {
            addCriterion("station_code <", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLessThanOrEqualTo(String value) {
            addCriterion("station_code <=", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeLike(String value) {
            addCriterion("station_code like", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotLike(String value) {
            addCriterion("station_code not like", value, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeIn(List<String> values) {
            addCriterion("station_code in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotIn(List<String> values) {
            addCriterion("station_code not in", values, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeBetween(String value1, String value2) {
            addCriterion("station_code between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andStationCodeNotBetween(String value1, String value2) {
            addCriterion("station_code not between", value1, value2, "stationCode");
            return (Criteria) this;
        }

        public Criteria andWorkingDayIsNull() {
            addCriterion("working_day is null");
            return (Criteria) this;
        }

        public Criteria andWorkingDayIsNotNull() {
            addCriterion("working_day is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingDayEqualTo(BigDecimal value) {
            addCriterion("working_day =", value, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayNotEqualTo(BigDecimal value) {
            addCriterion("working_day <>", value, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayGreaterThan(BigDecimal value) {
            addCriterion("working_day >", value, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("working_day >=", value, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayLessThan(BigDecimal value) {
            addCriterion("working_day <", value, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("working_day <=", value, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayIn(List<BigDecimal> values) {
            addCriterion("working_day in", values, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayNotIn(List<BigDecimal> values) {
            addCriterion("working_day not in", values, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("working_day between", value1, value2, "workingDay");
            return (Criteria) this;
        }

        public Criteria andWorkingDayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("working_day not between", value1, value2, "workingDay");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanIsNull() {
            addCriterion("is_staManage_foreman is null");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanIsNotNull() {
            addCriterion("is_staManage_foreman is not null");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanEqualTo(String value) {
            addCriterion("is_staManage_foreman =", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotEqualTo(String value) {
            addCriterion("is_staManage_foreman <>", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanGreaterThan(String value) {
            addCriterion("is_staManage_foreman >", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanGreaterThanOrEqualTo(String value) {
            addCriterion("is_staManage_foreman >=", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanLessThan(String value) {
            addCriterion("is_staManage_foreman <", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanLessThanOrEqualTo(String value) {
            addCriterion("is_staManage_foreman <=", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanLike(String value) {
            addCriterion("is_staManage_foreman like", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotLike(String value) {
            addCriterion("is_staManage_foreman not like", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanIn(List<String> values) {
            addCriterion("is_staManage_foreman in", values, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotIn(List<String> values) {
            addCriterion("is_staManage_foreman not in", values, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanBetween(String value1, String value2) {
            addCriterion("is_staManage_foreman between", value1, value2, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotBetween(String value1, String value2) {
            addCriterion("is_staManage_foreman not between", value1, value2, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsInternshipIsNull() {
            addCriterion("is_internship is null");
            return (Criteria) this;
        }

        public Criteria andIsInternshipIsNotNull() {
            addCriterion("is_internship is not null");
            return (Criteria) this;
        }

        public Criteria andIsInternshipEqualTo(String value) {
            addCriterion("is_internship =", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipNotEqualTo(String value) {
            addCriterion("is_internship <>", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipGreaterThan(String value) {
            addCriterion("is_internship >", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipGreaterThanOrEqualTo(String value) {
            addCriterion("is_internship >=", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipLessThan(String value) {
            addCriterion("is_internship <", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipLessThanOrEqualTo(String value) {
            addCriterion("is_internship <=", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipLike(String value) {
            addCriterion("is_internship like", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipNotLike(String value) {
            addCriterion("is_internship not like", value, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipIn(List<String> values) {
            addCriterion("is_internship in", values, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipNotIn(List<String> values) {
            addCriterion("is_internship not in", values, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipBetween(String value1, String value2) {
            addCriterion("is_internship between", value1, value2, "isInternship");
            return (Criteria) this;
        }

        public Criteria andIsInternshipNotBetween(String value1, String value2) {
            addCriterion("is_internship not between", value1, value2, "isInternship");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingIsNull() {
            addCriterion("after_intership_working is null");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingIsNotNull() {
            addCriterion("after_intership_working is not null");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingEqualTo(BigDecimal value) {
            addCriterion("after_intership_working =", value, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingNotEqualTo(BigDecimal value) {
            addCriterion("after_intership_working <>", value, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingGreaterThan(BigDecimal value) {
            addCriterion("after_intership_working >", value, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("after_intership_working >=", value, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingLessThan(BigDecimal value) {
            addCriterion("after_intership_working <", value, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingLessThanOrEqualTo(BigDecimal value) {
            addCriterion("after_intership_working <=", value, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingIn(List<BigDecimal> values) {
            addCriterion("after_intership_working in", values, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingNotIn(List<BigDecimal> values) {
            addCriterion("after_intership_working not in", values, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("after_intership_working between", value1, value2, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andAfterIntershipWorkingNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("after_intership_working not between", value1, value2, "afterIntershipWorking");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutIsNull() {
            addCriterion("peacetime_timeout is null");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutIsNotNull() {
            addCriterion("peacetime_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutEqualTo(BigDecimal value) {
            addCriterion("peacetime_timeout =", value, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutNotEqualTo(BigDecimal value) {
            addCriterion("peacetime_timeout <>", value, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutGreaterThan(BigDecimal value) {
            addCriterion("peacetime_timeout >", value, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("peacetime_timeout >=", value, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutLessThan(BigDecimal value) {
            addCriterion("peacetime_timeout <", value, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("peacetime_timeout <=", value, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutIn(List<BigDecimal> values) {
            addCriterion("peacetime_timeout in", values, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutNotIn(List<BigDecimal> values) {
            addCriterion("peacetime_timeout not in", values, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("peacetime_timeout between", value1, value2, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andPeacetimeTimeoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("peacetime_timeout not between", value1, value2, "peacetimeTimeout");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeIsNull() {
            addCriterion("holiday_overtime is null");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeIsNotNull() {
            addCriterion("holiday_overtime is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime =", value, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeNotEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime <>", value, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeGreaterThan(BigDecimal value) {
            addCriterion("holiday_overtime >", value, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime >=", value, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeLessThan(BigDecimal value) {
            addCriterion("holiday_overtime <", value, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("holiday_overtime <=", value, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeIn(List<BigDecimal> values) {
            addCriterion("holiday_overtime in", values, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeNotIn(List<BigDecimal> values) {
            addCriterion("holiday_overtime not in", values, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("holiday_overtime between", value1, value2, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andHolidayOvertimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("holiday_overtime not between", value1, value2, "holidayOvertime");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnIsNull() {
            addCriterion("family_reunion_dinner_on is null");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnIsNotNull() {
            addCriterion("family_reunion_dinner_on is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnEqualTo(BigDecimal value) {
            addCriterion("family_reunion_dinner_on =", value, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnNotEqualTo(BigDecimal value) {
            addCriterion("family_reunion_dinner_on <>", value, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnGreaterThan(BigDecimal value) {
            addCriterion("family_reunion_dinner_on >", value, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("family_reunion_dinner_on >=", value, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnLessThan(BigDecimal value) {
            addCriterion("family_reunion_dinner_on <", value, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("family_reunion_dinner_on <=", value, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnIn(List<BigDecimal> values) {
            addCriterion("family_reunion_dinner_on in", values, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnNotIn(List<BigDecimal> values) {
            addCriterion("family_reunion_dinner_on not in", values, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("family_reunion_dinner_on between", value1, value2, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andFamilyReunionDinnerOnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("family_reunion_dinner_on not between", value1, value2, "familyReunionDinnerOn");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneIsNull() {
            addCriterion("on_the_spring_festiva_one is null");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneIsNotNull() {
            addCriterion("on_the_spring_festiva_one is not null");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_one =", value, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneNotEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_one <>", value, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneGreaterThan(BigDecimal value) {
            addCriterion("on_the_spring_festiva_one >", value, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_one >=", value, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneLessThan(BigDecimal value) {
            addCriterion("on_the_spring_festiva_one <", value, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneLessThanOrEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_one <=", value, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneIn(List<BigDecimal> values) {
            addCriterion("on_the_spring_festiva_one in", values, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneNotIn(List<BigDecimal> values) {
            addCriterion("on_the_spring_festiva_one not in", values, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("on_the_spring_festiva_one between", value1, value2, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaOneNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("on_the_spring_festiva_one not between", value1, value2, "onTheSpringFestivaOne");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoIsNull() {
            addCriterion("on_the_spring_festiva_two is null");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoIsNotNull() {
            addCriterion("on_the_spring_festiva_two is not null");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_two =", value, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoNotEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_two <>", value, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoGreaterThan(BigDecimal value) {
            addCriterion("on_the_spring_festiva_two >", value, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_two >=", value, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoLessThan(BigDecimal value) {
            addCriterion("on_the_spring_festiva_two <", value, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("on_the_spring_festiva_two <=", value, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoIn(List<BigDecimal> values) {
            addCriterion("on_the_spring_festiva_two in", values, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoNotIn(List<BigDecimal> values) {
            addCriterion("on_the_spring_festiva_two not in", values, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("on_the_spring_festiva_two between", value1, value2, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andOnTheSpringFestivaTwoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("on_the_spring_festiva_two not between", value1, value2, "onTheSpringFestivaTwo");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureIsNull() {
            addCriterion("month_departure is null");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureIsNotNull() {
            addCriterion("month_departure is not null");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureEqualTo(BigDecimal value) {
            addCriterion("month_departure =", value, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureNotEqualTo(BigDecimal value) {
            addCriterion("month_departure <>", value, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureGreaterThan(BigDecimal value) {
            addCriterion("month_departure >", value, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_departure >=", value, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureLessThan(BigDecimal value) {
            addCriterion("month_departure <", value, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_departure <=", value, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureIn(List<BigDecimal> values) {
            addCriterion("month_departure in", values, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureNotIn(List<BigDecimal> values) {
            addCriterion("month_departure not in", values, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_departure between", value1, value2, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andMonthDepartureNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_departure not between", value1, value2, "monthDeparture");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveIsNull() {
            addCriterion("casual_leave is null");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveIsNotNull() {
            addCriterion("casual_leave is not null");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveEqualTo(BigDecimal value) {
            addCriterion("casual_leave =", value, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveNotEqualTo(BigDecimal value) {
            addCriterion("casual_leave <>", value, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveGreaterThan(BigDecimal value) {
            addCriterion("casual_leave >", value, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("casual_leave >=", value, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveLessThan(BigDecimal value) {
            addCriterion("casual_leave <", value, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("casual_leave <=", value, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveIn(List<BigDecimal> values) {
            addCriterion("casual_leave in", values, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveNotIn(List<BigDecimal> values) {
            addCriterion("casual_leave not in", values, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("casual_leave between", value1, value2, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andCasualLeaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("casual_leave not between", value1, value2, "casualLeave");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNull() {
            addCriterion("absenteeism is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIsNotNull() {
            addCriterion("absenteeism is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismEqualTo(BigDecimal value) {
            addCriterion("absenteeism =", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotEqualTo(BigDecimal value) {
            addCriterion("absenteeism <>", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThan(BigDecimal value) {
            addCriterion("absenteeism >", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("absenteeism >=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThan(BigDecimal value) {
            addCriterion("absenteeism <", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismLessThanOrEqualTo(BigDecimal value) {
            addCriterion("absenteeism <=", value, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismIn(List<BigDecimal> values) {
            addCriterion("absenteeism in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotIn(List<BigDecimal> values) {
            addCriterion("absenteeism not in", values, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("absenteeism between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("absenteeism not between", value1, value2, "absenteeism");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIsNull() {
            addCriterion("sick_leave is null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIsNotNull() {
            addCriterion("sick_leave is not null");
            return (Criteria) this;
        }

        public Criteria andSickLeaveEqualTo(BigDecimal value) {
            addCriterion("sick_leave =", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotEqualTo(BigDecimal value) {
            addCriterion("sick_leave <>", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveGreaterThan(BigDecimal value) {
            addCriterion("sick_leave >", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sick_leave >=", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveLessThan(BigDecimal value) {
            addCriterion("sick_leave <", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sick_leave <=", value, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveIn(List<BigDecimal> values) {
            addCriterion("sick_leave in", values, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotIn(List<BigDecimal> values) {
            addCriterion("sick_leave not in", values, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sick_leave between", value1, value2, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andSickLeaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sick_leave not between", value1, value2, "sickLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIsNull() {
            addCriterion("annual_leave is null");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIsNotNull() {
            addCriterion("annual_leave is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveEqualTo(BigDecimal value) {
            addCriterion("annual_leave =", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotEqualTo(BigDecimal value) {
            addCriterion("annual_leave <>", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveGreaterThan(BigDecimal value) {
            addCriterion("annual_leave >", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_leave >=", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveLessThan(BigDecimal value) {
            addCriterion("annual_leave <", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_leave <=", value, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveIn(List<BigDecimal> values) {
            addCriterion("annual_leave in", values, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotIn(List<BigDecimal> values) {
            addCriterion("annual_leave not in", values, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_leave between", value1, value2, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andAnnualLeaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_leave not between", value1, value2, "annualLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveIsNull() {
            addCriterion("marriage_leave is null");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveIsNotNull() {
            addCriterion("marriage_leave is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveEqualTo(BigDecimal value) {
            addCriterion("marriage_leave =", value, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveNotEqualTo(BigDecimal value) {
            addCriterion("marriage_leave <>", value, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveGreaterThan(BigDecimal value) {
            addCriterion("marriage_leave >", value, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("marriage_leave >=", value, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveLessThan(BigDecimal value) {
            addCriterion("marriage_leave <", value, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("marriage_leave <=", value, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveIn(List<BigDecimal> values) {
            addCriterion("marriage_leave in", values, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveNotIn(List<BigDecimal> values) {
            addCriterion("marriage_leave not in", values, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marriage_leave between", value1, value2, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMarriageLeaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marriage_leave not between", value1, value2, "marriageLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIsNull() {
            addCriterion("maternity_leave is null");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIsNotNull() {
            addCriterion("maternity_leave is not null");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveEqualTo(BigDecimal value) {
            addCriterion("maternity_leave =", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotEqualTo(BigDecimal value) {
            addCriterion("maternity_leave <>", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveGreaterThan(BigDecimal value) {
            addCriterion("maternity_leave >", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("maternity_leave >=", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveLessThan(BigDecimal value) {
            addCriterion("maternity_leave <", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("maternity_leave <=", value, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveIn(List<BigDecimal> values) {
            addCriterion("maternity_leave in", values, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotIn(List<BigDecimal> values) {
            addCriterion("maternity_leave not in", values, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maternity_leave between", value1, value2, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andMaternityLeaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maternity_leave not between", value1, value2, "maternityLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIsNull() {
            addCriterion("funeral_leave is null");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIsNotNull() {
            addCriterion("funeral_leave is not null");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveEqualTo(BigDecimal value) {
            addCriterion("funeral_leave =", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotEqualTo(BigDecimal value) {
            addCriterion("funeral_leave <>", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveGreaterThan(BigDecimal value) {
            addCriterion("funeral_leave >", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("funeral_leave >=", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveLessThan(BigDecimal value) {
            addCriterion("funeral_leave <", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveLessThanOrEqualTo(BigDecimal value) {
            addCriterion("funeral_leave <=", value, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveIn(List<BigDecimal> values) {
            addCriterion("funeral_leave in", values, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotIn(List<BigDecimal> values) {
            addCriterion("funeral_leave not in", values, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("funeral_leave between", value1, value2, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andFuneralLeaveNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("funeral_leave not between", value1, value2, "funeralLeave");
            return (Criteria) this;
        }

        public Criteria andDaysOffIsNull() {
            addCriterion("days_off is null");
            return (Criteria) this;
        }

        public Criteria andDaysOffIsNotNull() {
            addCriterion("days_off is not null");
            return (Criteria) this;
        }

        public Criteria andDaysOffEqualTo(BigDecimal value) {
            addCriterion("days_off =", value, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffNotEqualTo(BigDecimal value) {
            addCriterion("days_off <>", value, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffGreaterThan(BigDecimal value) {
            addCriterion("days_off >", value, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("days_off >=", value, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffLessThan(BigDecimal value) {
            addCriterion("days_off <", value, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffLessThanOrEqualTo(BigDecimal value) {
            addCriterion("days_off <=", value, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffIn(List<BigDecimal> values) {
            addCriterion("days_off in", values, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffNotIn(List<BigDecimal> values) {
            addCriterion("days_off not in", values, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("days_off between", value1, value2, "daysOff");
            return (Criteria) this;
        }

        public Criteria andDaysOffNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("days_off not between", value1, value2, "daysOff");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsIsNull() {
            addCriterion("verbal_warnings is null");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsIsNotNull() {
            addCriterion("verbal_warnings is not null");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsEqualTo(BigDecimal value) {
            addCriterion("verbal_warnings =", value, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsNotEqualTo(BigDecimal value) {
            addCriterion("verbal_warnings <>", value, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsGreaterThan(BigDecimal value) {
            addCriterion("verbal_warnings >", value, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("verbal_warnings >=", value, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsLessThan(BigDecimal value) {
            addCriterion("verbal_warnings <", value, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("verbal_warnings <=", value, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsIn(List<BigDecimal> values) {
            addCriterion("verbal_warnings in", values, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsNotIn(List<BigDecimal> values) {
            addCriterion("verbal_warnings not in", values, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("verbal_warnings between", value1, value2, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andVerbalWarningsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("verbal_warnings not between", value1, value2, "verbalWarnings");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningIsNull() {
            addCriterion("written_warning is null");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningIsNotNull() {
            addCriterion("written_warning is not null");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningEqualTo(BigDecimal value) {
            addCriterion("written_warning =", value, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningNotEqualTo(BigDecimal value) {
            addCriterion("written_warning <>", value, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningGreaterThan(BigDecimal value) {
            addCriterion("written_warning >", value, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("written_warning >=", value, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningLessThan(BigDecimal value) {
            addCriterion("written_warning <", value, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningLessThanOrEqualTo(BigDecimal value) {
            addCriterion("written_warning <=", value, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningIn(List<BigDecimal> values) {
            addCriterion("written_warning in", values, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningNotIn(List<BigDecimal> values) {
            addCriterion("written_warning not in", values, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("written_warning between", value1, value2, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andWrittenWarningNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("written_warning not between", value1, value2, "writtenWarning");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentIsNull() {
            addCriterion("major_accident is null");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentIsNotNull() {
            addCriterion("major_accident is not null");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentEqualTo(BigDecimal value) {
            addCriterion("major_accident =", value, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentNotEqualTo(BigDecimal value) {
            addCriterion("major_accident <>", value, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentGreaterThan(BigDecimal value) {
            addCriterion("major_accident >", value, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("major_accident >=", value, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentLessThan(BigDecimal value) {
            addCriterion("major_accident <", value, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("major_accident <=", value, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentIn(List<BigDecimal> values) {
            addCriterion("major_accident in", values, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentNotIn(List<BigDecimal> values) {
            addCriterion("major_accident not in", values, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("major_accident between", value1, value2, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andMajorAccidentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("major_accident not between", value1, value2, "majorAccident");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateIsNull() {
            addCriterion("is_accomodate is null");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateIsNotNull() {
            addCriterion("is_accomodate is not null");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateEqualTo(String value) {
            addCriterion("is_accomodate =", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateNotEqualTo(String value) {
            addCriterion("is_accomodate <>", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateGreaterThan(String value) {
            addCriterion("is_accomodate >", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateGreaterThanOrEqualTo(String value) {
            addCriterion("is_accomodate >=", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateLessThan(String value) {
            addCriterion("is_accomodate <", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateLessThanOrEqualTo(String value) {
            addCriterion("is_accomodate <=", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateLike(String value) {
            addCriterion("is_accomodate like", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateNotLike(String value) {
            addCriterion("is_accomodate not like", value, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateIn(List<String> values) {
            addCriterion("is_accomodate in", values, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateNotIn(List<String> values) {
            addCriterion("is_accomodate not in", values, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateBetween(String value1, String value2) {
            addCriterion("is_accomodate between", value1, value2, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsAccomodateNotBetween(String value1, String value2) {
            addCriterion("is_accomodate not between", value1, value2, "isAccomodate");
            return (Criteria) this;
        }

        public Criteria andIsBoarderIsNull() {
            addCriterion("is_boarder is null");
            return (Criteria) this;
        }

        public Criteria andIsBoarderIsNotNull() {
            addCriterion("is_boarder is not null");
            return (Criteria) this;
        }

        public Criteria andIsBoarderEqualTo(String value) {
            addCriterion("is_boarder =", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderNotEqualTo(String value) {
            addCriterion("is_boarder <>", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderGreaterThan(String value) {
            addCriterion("is_boarder >", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderGreaterThanOrEqualTo(String value) {
            addCriterion("is_boarder >=", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderLessThan(String value) {
            addCriterion("is_boarder <", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderLessThanOrEqualTo(String value) {
            addCriterion("is_boarder <=", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderLike(String value) {
            addCriterion("is_boarder like", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderNotLike(String value) {
            addCriterion("is_boarder not like", value, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderIn(List<String> values) {
            addCriterion("is_boarder in", values, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderNotIn(List<String> values) {
            addCriterion("is_boarder not in", values, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderBetween(String value1, String value2) {
            addCriterion("is_boarder between", value1, value2, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andIsBoarderNotBetween(String value1, String value2) {
            addCriterion("is_boarder not between", value1, value2, "isBoarder");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueIsNull() {
            addCriterion("splendor_card_blue is null");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueIsNotNull() {
            addCriterion("splendor_card_blue is not null");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueEqualTo(BigDecimal value) {
            addCriterion("splendor_card_blue =", value, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueNotEqualTo(BigDecimal value) {
            addCriterion("splendor_card_blue <>", value, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueGreaterThan(BigDecimal value) {
            addCriterion("splendor_card_blue >", value, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("splendor_card_blue >=", value, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueLessThan(BigDecimal value) {
            addCriterion("splendor_card_blue <", value, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("splendor_card_blue <=", value, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueIn(List<BigDecimal> values) {
            addCriterion("splendor_card_blue in", values, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueNotIn(List<BigDecimal> values) {
            addCriterion("splendor_card_blue not in", values, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("splendor_card_blue between", value1, value2, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBlueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("splendor_card_blue not between", value1, value2, "splendorCardBlue");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenIsNull() {
            addCriterion("splendor_card_green is null");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenIsNotNull() {
            addCriterion("splendor_card_green is not null");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenEqualTo(BigDecimal value) {
            addCriterion("splendor_card_green =", value, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenNotEqualTo(BigDecimal value) {
            addCriterion("splendor_card_green <>", value, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenGreaterThan(BigDecimal value) {
            addCriterion("splendor_card_green >", value, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("splendor_card_green >=", value, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenLessThan(BigDecimal value) {
            addCriterion("splendor_card_green <", value, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("splendor_card_green <=", value, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenIn(List<BigDecimal> values) {
            addCriterion("splendor_card_green in", values, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenNotIn(List<BigDecimal> values) {
            addCriterion("splendor_card_green not in", values, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("splendor_card_green between", value1, value2, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andSplendorCardGreenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("splendor_card_green not between", value1, value2, "splendorCardGreen");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleIsNull() {
            addCriterion("part_time_scale is null");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleIsNotNull() {
            addCriterion("part_time_scale is not null");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleEqualTo(BigDecimal value) {
            addCriterion("part_time_scale =", value, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleNotEqualTo(BigDecimal value) {
            addCriterion("part_time_scale <>", value, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleGreaterThan(BigDecimal value) {
            addCriterion("part_time_scale >", value, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("part_time_scale >=", value, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleLessThan(BigDecimal value) {
            addCriterion("part_time_scale <", value, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("part_time_scale <=", value, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleIn(List<BigDecimal> values) {
            addCriterion("part_time_scale in", values, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleNotIn(List<BigDecimal> values) {
            addCriterion("part_time_scale not in", values, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("part_time_scale between", value1, value2, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andPartTimeScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("part_time_scale not between", value1, value2, "partTimeScale");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceIsNull() {
            addCriterion("month_performance is null");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceIsNotNull() {
            addCriterion("month_performance is not null");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceEqualTo(BigDecimal value) {
            addCriterion("month_performance =", value, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceNotEqualTo(BigDecimal value) {
            addCriterion("month_performance <>", value, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceGreaterThan(BigDecimal value) {
            addCriterion("month_performance >", value, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_performance >=", value, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceLessThan(BigDecimal value) {
            addCriterion("month_performance <", value, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_performance <=", value, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceIn(List<BigDecimal> values) {
            addCriterion("month_performance in", values, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceNotIn(List<BigDecimal> values) {
            addCriterion("month_performance not in", values, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_performance between", value1, value2, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andMonthPerformanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_performance not between", value1, value2, "monthPerformance");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleIsNull() {
            addCriterion("manager_bonus_scale is null");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleIsNotNull() {
            addCriterion("manager_bonus_scale is not null");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleEqualTo(BigDecimal value) {
            addCriterion("manager_bonus_scale =", value, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleNotEqualTo(BigDecimal value) {
            addCriterion("manager_bonus_scale <>", value, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleGreaterThan(BigDecimal value) {
            addCriterion("manager_bonus_scale >", value, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manager_bonus_scale >=", value, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleLessThan(BigDecimal value) {
            addCriterion("manager_bonus_scale <", value, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manager_bonus_scale <=", value, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleIn(List<BigDecimal> values) {
            addCriterion("manager_bonus_scale in", values, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleNotIn(List<BigDecimal> values) {
            addCriterion("manager_bonus_scale not in", values, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manager_bonus_scale between", value1, value2, "managerBonusScale");
            return (Criteria) this;
        }

        public Criteria andManagerBonusScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manager_bonus_scale not between", value1, value2, "managerBonusScale");
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