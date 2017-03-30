package com.fh.entity.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffTransferQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StaffTransferQuery() {
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

        public Criteria andTransferCodeIsNull() {
            addCriterion("transfer_code is null");
            return (Criteria) this;
        }

        public Criteria andTransferCodeIsNotNull() {
            addCriterion("transfer_code is not null");
            return (Criteria) this;
        }

        public Criteria andTransferCodeEqualTo(String value) {
            addCriterion("transfer_code =", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeNotEqualTo(String value) {
            addCriterion("transfer_code <>", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeGreaterThan(String value) {
            addCriterion("transfer_code >", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_code >=", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeLessThan(String value) {
            addCriterion("transfer_code <", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeLessThanOrEqualTo(String value) {
            addCriterion("transfer_code <=", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeLike(String value) {
            addCriterion("transfer_code like", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeNotLike(String value) {
            addCriterion("transfer_code not like", value, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeIn(List<String> values) {
            addCriterion("transfer_code in", values, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeNotIn(List<String> values) {
            addCriterion("transfer_code not in", values, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeBetween(String value1, String value2) {
            addCriterion("transfer_code between", value1, value2, "transferCode");
            return (Criteria) this;
        }

        public Criteria andTransferCodeNotBetween(String value1, String value2) {
            addCriterion("transfer_code not between", value1, value2, "transferCode");
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

        public Criteria andBeforeStationCodeIsNull() {
            addCriterion("before_station_code is null");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeIsNotNull() {
            addCriterion("before_station_code is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeEqualTo(String value) {
            addCriterion("before_station_code =", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeNotEqualTo(String value) {
            addCriterion("before_station_code <>", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeGreaterThan(String value) {
            addCriterion("before_station_code >", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("before_station_code >=", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeLessThan(String value) {
            addCriterion("before_station_code <", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeLessThanOrEqualTo(String value) {
            addCriterion("before_station_code <=", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeLike(String value) {
            addCriterion("before_station_code like", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeNotLike(String value) {
            addCriterion("before_station_code not like", value, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeIn(List<String> values) {
            addCriterion("before_station_code in", values, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeNotIn(List<String> values) {
            addCriterion("before_station_code not in", values, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeBetween(String value1, String value2) {
            addCriterion("before_station_code between", value1, value2, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeStationCodeNotBetween(String value1, String value2) {
            addCriterion("before_station_code not between", value1, value2, "beforeStationCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeIsNull() {
            addCriterion("before_duty_code is null");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeIsNotNull() {
            addCriterion("before_duty_code is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeEqualTo(String value) {
            addCriterion("before_duty_code =", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeNotEqualTo(String value) {
            addCriterion("before_duty_code <>", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeGreaterThan(String value) {
            addCriterion("before_duty_code >", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("before_duty_code >=", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeLessThan(String value) {
            addCriterion("before_duty_code <", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeLessThanOrEqualTo(String value) {
            addCriterion("before_duty_code <=", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeLike(String value) {
            addCriterion("before_duty_code like", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeNotLike(String value) {
            addCriterion("before_duty_code not like", value, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeIn(List<String> values) {
            addCriterion("before_duty_code in", values, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeNotIn(List<String> values) {
            addCriterion("before_duty_code not in", values, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeBetween(String value1, String value2) {
            addCriterion("before_duty_code between", value1, value2, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andBeforeDutyCodeNotBetween(String value1, String value2) {
            addCriterion("before_duty_code not between", value1, value2, "beforeDutyCode");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateIsNull() {
            addCriterion("staff_transfer_date is null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateIsNotNull() {
            addCriterion("staff_transfer_date is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateEqualTo(String value) {
            addCriterion("staff_transfer_date =", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateNotEqualTo(String value) {
            addCriterion("staff_transfer_date <>", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateGreaterThan(String value) {
            addCriterion("staff_transfer_date >", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateGreaterThanOrEqualTo(String value) {
            addCriterion("staff_transfer_date >=", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateLessThan(String value) {
            addCriterion("staff_transfer_date <", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateLessThanOrEqualTo(String value) {
            addCriterion("staff_transfer_date <=", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateLike(String value) {
            addCriterion("staff_transfer_date like", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateNotLike(String value) {
            addCriterion("staff_transfer_date not like", value, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateIn(List<String> values) {
            addCriterion("staff_transfer_date in", values, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateNotIn(List<String> values) {
            addCriterion("staff_transfer_date not in", values, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateBetween(String value1, String value2) {
            addCriterion("staff_transfer_date between", value1, value2, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferDateNotBetween(String value1, String value2) {
            addCriterion("staff_transfer_date not between", value1, value2, "staffTransferDate");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlIsNull() {
            addCriterion("staff_transfer_url is null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlIsNotNull() {
            addCriterion("staff_transfer_url is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlEqualTo(String value) {
            addCriterion("staff_transfer_url =", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlNotEqualTo(String value) {
            addCriterion("staff_transfer_url <>", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlGreaterThan(String value) {
            addCriterion("staff_transfer_url >", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlGreaterThanOrEqualTo(String value) {
            addCriterion("staff_transfer_url >=", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlLessThan(String value) {
            addCriterion("staff_transfer_url <", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlLessThanOrEqualTo(String value) {
            addCriterion("staff_transfer_url <=", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlLike(String value) {
            addCriterion("staff_transfer_url like", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlNotLike(String value) {
            addCriterion("staff_transfer_url not like", value, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlIn(List<String> values) {
            addCriterion("staff_transfer_url in", values, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlNotIn(List<String> values) {
            addCriterion("staff_transfer_url not in", values, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlBetween(String value1, String value2) {
            addCriterion("staff_transfer_url between", value1, value2, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andStaffTransferUrlNotBetween(String value1, String value2) {
            addCriterion("staff_transfer_url not between", value1, value2, "staffTransferUrl");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeIsNull() {
            addCriterion("after_station_code is null");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeIsNotNull() {
            addCriterion("after_station_code is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeEqualTo(String value) {
            addCriterion("after_station_code =", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeNotEqualTo(String value) {
            addCriterion("after_station_code <>", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeGreaterThan(String value) {
            addCriterion("after_station_code >", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("after_station_code >=", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeLessThan(String value) {
            addCriterion("after_station_code <", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeLessThanOrEqualTo(String value) {
            addCriterion("after_station_code <=", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeLike(String value) {
            addCriterion("after_station_code like", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeNotLike(String value) {
            addCriterion("after_station_code not like", value, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeIn(List<String> values) {
            addCriterion("after_station_code in", values, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeNotIn(List<String> values) {
            addCriterion("after_station_code not in", values, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeBetween(String value1, String value2) {
            addCriterion("after_station_code between", value1, value2, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterStationCodeNotBetween(String value1, String value2) {
            addCriterion("after_station_code not between", value1, value2, "afterStationCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeIsNull() {
            addCriterion("after_duty_code is null");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeIsNotNull() {
            addCriterion("after_duty_code is not null");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeEqualTo(String value) {
            addCriterion("after_duty_code =", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeNotEqualTo(String value) {
            addCriterion("after_duty_code <>", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeGreaterThan(String value) {
            addCriterion("after_duty_code >", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("after_duty_code >=", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeLessThan(String value) {
            addCriterion("after_duty_code <", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeLessThanOrEqualTo(String value) {
            addCriterion("after_duty_code <=", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeLike(String value) {
            addCriterion("after_duty_code like", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeNotLike(String value) {
            addCriterion("after_duty_code not like", value, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeIn(List<String> values) {
            addCriterion("after_duty_code in", values, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeNotIn(List<String> values) {
            addCriterion("after_duty_code not in", values, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeBetween(String value1, String value2) {
            addCriterion("after_duty_code between", value1, value2, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andAfterDutyCodeNotBetween(String value1, String value2) {
            addCriterion("after_duty_code not between", value1, value2, "afterDutyCode");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseIsNull() {
            addCriterion("staff_transfer_cause is null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseIsNotNull() {
            addCriterion("staff_transfer_cause is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseEqualTo(String value) {
            addCriterion("staff_transfer_cause =", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseNotEqualTo(String value) {
            addCriterion("staff_transfer_cause <>", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseGreaterThan(String value) {
            addCriterion("staff_transfer_cause >", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseGreaterThanOrEqualTo(String value) {
            addCriterion("staff_transfer_cause >=", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseLessThan(String value) {
            addCriterion("staff_transfer_cause <", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseLessThanOrEqualTo(String value) {
            addCriterion("staff_transfer_cause <=", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseLike(String value) {
            addCriterion("staff_transfer_cause like", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseNotLike(String value) {
            addCriterion("staff_transfer_cause not like", value, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseIn(List<String> values) {
            addCriterion("staff_transfer_cause in", values, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseNotIn(List<String> values) {
            addCriterion("staff_transfer_cause not in", values, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseBetween(String value1, String value2) {
            addCriterion("staff_transfer_cause between", value1, value2, "staffTransferCause");
            return (Criteria) this;
        }

        public Criteria andStaffTransferCauseNotBetween(String value1, String value2) {
            addCriterion("staff_transfer_cause not between", value1, value2, "staffTransferCause");
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