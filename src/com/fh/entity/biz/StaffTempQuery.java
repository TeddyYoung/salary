package com.fh.entity.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffTempQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StaffTempQuery() {
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

        public Criteria andStaffIdcardIsNull() {
            addCriterion("staff_idcard is null");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardIsNotNull() {
            addCriterion("staff_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardEqualTo(String value) {
            addCriterion("staff_idcard =", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardNotEqualTo(String value) {
            addCriterion("staff_idcard <>", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardGreaterThan(String value) {
            addCriterion("staff_idcard >", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("staff_idcard >=", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardLessThan(String value) {
            addCriterion("staff_idcard <", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardLessThanOrEqualTo(String value) {
            addCriterion("staff_idcard <=", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardLike(String value) {
            addCriterion("staff_idcard like", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardNotLike(String value) {
            addCriterion("staff_idcard not like", value, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardIn(List<String> values) {
            addCriterion("staff_idcard in", values, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardNotIn(List<String> values) {
            addCriterion("staff_idcard not in", values, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardBetween(String value1, String value2) {
            addCriterion("staff_idcard between", value1, value2, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffIdcardNotBetween(String value1, String value2) {
            addCriterion("staff_idcard not between", value1, value2, "staffIdcard");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNull() {
            addCriterion("staff_phone is null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIsNotNull() {
            addCriterion("staff_phone is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneEqualTo(String value) {
            addCriterion("staff_phone =", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotEqualTo(String value) {
            addCriterion("staff_phone <>", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThan(String value) {
            addCriterion("staff_phone >", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("staff_phone >=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThan(String value) {
            addCriterion("staff_phone <", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLessThanOrEqualTo(String value) {
            addCriterion("staff_phone <=", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneLike(String value) {
            addCriterion("staff_phone like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotLike(String value) {
            addCriterion("staff_phone not like", value, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneIn(List<String> values) {
            addCriterion("staff_phone in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotIn(List<String> values) {
            addCriterion("staff_phone not in", values, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneBetween(String value1, String value2) {
            addCriterion("staff_phone between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffPhoneNotBetween(String value1, String value2) {
            addCriterion("staff_phone not between", value1, value2, "staffPhone");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNull() {
            addCriterion("staff_sex is null");
            return (Criteria) this;
        }

        public Criteria andStaffSexIsNotNull() {
            addCriterion("staff_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSexEqualTo(String value) {
            addCriterion("staff_sex =", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotEqualTo(String value) {
            addCriterion("staff_sex <>", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThan(String value) {
            addCriterion("staff_sex >", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexGreaterThanOrEqualTo(String value) {
            addCriterion("staff_sex >=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThan(String value) {
            addCriterion("staff_sex <", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLessThanOrEqualTo(String value) {
            addCriterion("staff_sex <=", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexLike(String value) {
            addCriterion("staff_sex like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotLike(String value) {
            addCriterion("staff_sex not like", value, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexIn(List<String> values) {
            addCriterion("staff_sex in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotIn(List<String> values) {
            addCriterion("staff_sex not in", values, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexBetween(String value1, String value2) {
            addCriterion("staff_sex between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andStaffSexNotBetween(String value1, String value2) {
            addCriterion("staff_sex not between", value1, value2, "staffSex");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNull() {
            addCriterion("entry_date is null");
            return (Criteria) this;
        }

        public Criteria andEntryDateIsNotNull() {
            addCriterion("entry_date is not null");
            return (Criteria) this;
        }

        public Criteria andEntryDateEqualTo(String value) {
            addCriterion("entry_date =", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotEqualTo(String value) {
            addCriterion("entry_date <>", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThan(String value) {
            addCriterion("entry_date >", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateGreaterThanOrEqualTo(String value) {
            addCriterion("entry_date >=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThan(String value) {
            addCriterion("entry_date <", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLessThanOrEqualTo(String value) {
            addCriterion("entry_date <=", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateLike(String value) {
            addCriterion("entry_date like", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotLike(String value) {
            addCriterion("entry_date not like", value, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateIn(List<String> values) {
            addCriterion("entry_date in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotIn(List<String> values) {
            addCriterion("entry_date not in", values, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateBetween(String value1, String value2) {
            addCriterion("entry_date between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andEntryDateNotBetween(String value1, String value2) {
            addCriterion("entry_date not between", value1, value2, "entryDate");
            return (Criteria) this;
        }

        public Criteria andDutyCodeIsNull() {
            addCriterion("duty_code is null");
            return (Criteria) this;
        }

        public Criteria andDutyCodeIsNotNull() {
            addCriterion("duty_code is not null");
            return (Criteria) this;
        }

        public Criteria andDutyCodeEqualTo(String value) {
            addCriterion("duty_code =", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeNotEqualTo(String value) {
            addCriterion("duty_code <>", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeGreaterThan(String value) {
            addCriterion("duty_code >", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("duty_code >=", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeLessThan(String value) {
            addCriterion("duty_code <", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeLessThanOrEqualTo(String value) {
            addCriterion("duty_code <=", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeLike(String value) {
            addCriterion("duty_code like", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeNotLike(String value) {
            addCriterion("duty_code not like", value, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeIn(List<String> values) {
            addCriterion("duty_code in", values, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeNotIn(List<String> values) {
            addCriterion("duty_code not in", values, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeBetween(String value1, String value2) {
            addCriterion("duty_code between", value1, value2, "dutyCode");
            return (Criteria) this;
        }

        public Criteria andDutyCodeNotBetween(String value1, String value2) {
            addCriterion("duty_code not between", value1, value2, "dutyCode");
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

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryIsNull() {
            addCriterion("staff_category is null");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryIsNotNull() {
            addCriterion("staff_category is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryEqualTo(String value) {
            addCriterion("staff_category =", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotEqualTo(String value) {
            addCriterion("staff_category <>", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryGreaterThan(String value) {
            addCriterion("staff_category >", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("staff_category >=", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryLessThan(String value) {
            addCriterion("staff_category <", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryLessThanOrEqualTo(String value) {
            addCriterion("staff_category <=", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryLike(String value) {
            addCriterion("staff_category like", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotLike(String value) {
            addCriterion("staff_category not like", value, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryIn(List<String> values) {
            addCriterion("staff_category in", values, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotIn(List<String> values) {
            addCriterion("staff_category not in", values, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryBetween(String value1, String value2) {
            addCriterion("staff_category between", value1, value2, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andStaffCategoryNotBetween(String value1, String value2) {
            addCriterion("staff_category not between", value1, value2, "staffCategory");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNull() {
            addCriterion("contract_type is null");
            return (Criteria) this;
        }

        public Criteria andContractTypeIsNotNull() {
            addCriterion("contract_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractTypeEqualTo(String value) {
            addCriterion("contract_type =", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotEqualTo(String value) {
            addCriterion("contract_type <>", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThan(String value) {
            addCriterion("contract_type >", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contract_type >=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThan(String value) {
            addCriterion("contract_type <", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLessThanOrEqualTo(String value) {
            addCriterion("contract_type <=", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeLike(String value) {
            addCriterion("contract_type like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotLike(String value) {
            addCriterion("contract_type not like", value, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeIn(List<String> values) {
            addCriterion("contract_type in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotIn(List<String> values) {
            addCriterion("contract_type not in", values, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeBetween(String value1, String value2) {
            addCriterion("contract_type between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractTypeNotBetween(String value1, String value2) {
            addCriterion("contract_type not between", value1, value2, "contractType");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNull() {
            addCriterion("contract_period is null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIsNotNull() {
            addCriterion("contract_period is not null");
            return (Criteria) this;
        }

        public Criteria andContractPeriodEqualTo(String value) {
            addCriterion("contract_period =", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotEqualTo(String value) {
            addCriterion("contract_period <>", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThan(String value) {
            addCriterion("contract_period >", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("contract_period >=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThan(String value) {
            addCriterion("contract_period <", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLessThanOrEqualTo(String value) {
            addCriterion("contract_period <=", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodLike(String value) {
            addCriterion("contract_period like", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotLike(String value) {
            addCriterion("contract_period not like", value, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodIn(List<String> values) {
            addCriterion("contract_period in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotIn(List<String> values) {
            addCriterion("contract_period not in", values, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodBetween(String value1, String value2) {
            addCriterion("contract_period between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andContractPeriodNotBetween(String value1, String value2) {
            addCriterion("contract_period not between", value1, value2, "contractPeriod");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineIsNull() {
            addCriterion("agreement_deadline is null");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineIsNotNull() {
            addCriterion("agreement_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineEqualTo(String value) {
            addCriterion("agreement_deadline =", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineNotEqualTo(String value) {
            addCriterion("agreement_deadline <>", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineGreaterThan(String value) {
            addCriterion("agreement_deadline >", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineGreaterThanOrEqualTo(String value) {
            addCriterion("agreement_deadline >=", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineLessThan(String value) {
            addCriterion("agreement_deadline <", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineLessThanOrEqualTo(String value) {
            addCriterion("agreement_deadline <=", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineLike(String value) {
            addCriterion("agreement_deadline like", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineNotLike(String value) {
            addCriterion("agreement_deadline not like", value, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineIn(List<String> values) {
            addCriterion("agreement_deadline in", values, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineNotIn(List<String> values) {
            addCriterion("agreement_deadline not in", values, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineBetween(String value1, String value2) {
            addCriterion("agreement_deadline between", value1, value2, "agreementDeadline");
            return (Criteria) this;
        }

        public Criteria andAgreementDeadlineNotBetween(String value1, String value2) {
            addCriterion("agreement_deadline not between", value1, value2, "agreementDeadline");
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