package com.fh.entity.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StaffQuery() {
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

        public Criteria andStaffPhotoIsNull() {
            addCriterion("staff_photo is null");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoIsNotNull() {
            addCriterion("staff_photo is not null");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoEqualTo(String value) {
            addCriterion("staff_photo =", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoNotEqualTo(String value) {
            addCriterion("staff_photo <>", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoGreaterThan(String value) {
            addCriterion("staff_photo >", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("staff_photo >=", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoLessThan(String value) {
            addCriterion("staff_photo <", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoLessThanOrEqualTo(String value) {
            addCriterion("staff_photo <=", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoLike(String value) {
            addCriterion("staff_photo like", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoNotLike(String value) {
            addCriterion("staff_photo not like", value, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoIn(List<String> values) {
            addCriterion("staff_photo in", values, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoNotIn(List<String> values) {
            addCriterion("staff_photo not in", values, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoBetween(String value1, String value2) {
            addCriterion("staff_photo between", value1, value2, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffPhotoNotBetween(String value1, String value2) {
            addCriterion("staff_photo not between", value1, value2, "staffPhoto");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIsNull() {
            addCriterion("staff_status is null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIsNotNull() {
            addCriterion("staff_status is not null");
            return (Criteria) this;
        }

        public Criteria andStaffStatusEqualTo(String value) {
            addCriterion("staff_status =", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotEqualTo(String value) {
            addCriterion("staff_status <>", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusGreaterThan(String value) {
            addCriterion("staff_status >", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusGreaterThanOrEqualTo(String value) {
            addCriterion("staff_status >=", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLessThan(String value) {
            addCriterion("staff_status <", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLessThanOrEqualTo(String value) {
            addCriterion("staff_status <=", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusLike(String value) {
            addCriterion("staff_status like", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotLike(String value) {
            addCriterion("staff_status not like", value, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusIn(List<String> values) {
            addCriterion("staff_status in", values, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotIn(List<String> values) {
            addCriterion("staff_status not in", values, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusBetween(String value1, String value2) {
            addCriterion("staff_status between", value1, value2, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffStatusNotBetween(String value1, String value2) {
            addCriterion("staff_status not between", value1, value2, "staffStatus");
            return (Criteria) this;
        }

        public Criteria andStaffInDateIsNull() {
            addCriterion("staff_in_date is null");
            return (Criteria) this;
        }

        public Criteria andStaffInDateIsNotNull() {
            addCriterion("staff_in_date is not null");
            return (Criteria) this;
        }

        public Criteria andStaffInDateEqualTo(String value) {
            addCriterion("staff_in_date =", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateNotEqualTo(String value) {
            addCriterion("staff_in_date <>", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateGreaterThan(String value) {
            addCriterion("staff_in_date >", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateGreaterThanOrEqualTo(String value) {
            addCriterion("staff_in_date >=", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateLessThan(String value) {
            addCriterion("staff_in_date <", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateLessThanOrEqualTo(String value) {
            addCriterion("staff_in_date <=", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateLike(String value) {
            addCriterion("staff_in_date like", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateNotLike(String value) {
            addCriterion("staff_in_date not like", value, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateIn(List<String> values) {
            addCriterion("staff_in_date in", values, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateNotIn(List<String> values) {
            addCriterion("staff_in_date not in", values, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateBetween(String value1, String value2) {
            addCriterion("staff_in_date between", value1, value2, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffInDateNotBetween(String value1, String value2) {
            addCriterion("staff_in_date not between", value1, value2, "staffInDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateIsNull() {
            addCriterion("staff_out_date is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateIsNotNull() {
            addCriterion("staff_out_date is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateEqualTo(String value) {
            addCriterion("staff_out_date =", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateNotEqualTo(String value) {
            addCriterion("staff_out_date <>", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateGreaterThan(String value) {
            addCriterion("staff_out_date >", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateGreaterThanOrEqualTo(String value) {
            addCriterion("staff_out_date >=", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateLessThan(String value) {
            addCriterion("staff_out_date <", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateLessThanOrEqualTo(String value) {
            addCriterion("staff_out_date <=", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateLike(String value) {
            addCriterion("staff_out_date like", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateNotLike(String value) {
            addCriterion("staff_out_date not like", value, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateIn(List<String> values) {
            addCriterion("staff_out_date in", values, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateNotIn(List<String> values) {
            addCriterion("staff_out_date not in", values, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateBetween(String value1, String value2) {
            addCriterion("staff_out_date between", value1, value2, "staffOutDate");
            return (Criteria) this;
        }

        public Criteria andStaffOutDateNotBetween(String value1, String value2) {
            addCriterion("staff_out_date not between", value1, value2, "staffOutDate");
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

        public Criteria andStaffBankcardIsNull() {
            addCriterion("staff_bankcard is null");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardIsNotNull() {
            addCriterion("staff_bankcard is not null");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardEqualTo(String value) {
            addCriterion("staff_bankcard =", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardNotEqualTo(String value) {
            addCriterion("staff_bankcard <>", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardGreaterThan(String value) {
            addCriterion("staff_bankcard >", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardGreaterThanOrEqualTo(String value) {
            addCriterion("staff_bankcard >=", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardLessThan(String value) {
            addCriterion("staff_bankcard <", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardLessThanOrEqualTo(String value) {
            addCriterion("staff_bankcard <=", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardLike(String value) {
            addCriterion("staff_bankcard like", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardNotLike(String value) {
            addCriterion("staff_bankcard not like", value, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardIn(List<String> values) {
            addCriterion("staff_bankcard in", values, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardNotIn(List<String> values) {
            addCriterion("staff_bankcard not in", values, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardBetween(String value1, String value2) {
            addCriterion("staff_bankcard between", value1, value2, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankcardNotBetween(String value1, String value2) {
            addCriterion("staff_bankcard not between", value1, value2, "staffBankcard");
            return (Criteria) this;
        }

        public Criteria andStaffBankIsNull() {
            addCriterion("staff_bank is null");
            return (Criteria) this;
        }

        public Criteria andStaffBankIsNotNull() {
            addCriterion("staff_bank is not null");
            return (Criteria) this;
        }

        public Criteria andStaffBankEqualTo(String value) {
            addCriterion("staff_bank =", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankNotEqualTo(String value) {
            addCriterion("staff_bank <>", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankGreaterThan(String value) {
            addCriterion("staff_bank >", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankGreaterThanOrEqualTo(String value) {
            addCriterion("staff_bank >=", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankLessThan(String value) {
            addCriterion("staff_bank <", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankLessThanOrEqualTo(String value) {
            addCriterion("staff_bank <=", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankLike(String value) {
            addCriterion("staff_bank like", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankNotLike(String value) {
            addCriterion("staff_bank not like", value, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankIn(List<String> values) {
            addCriterion("staff_bank in", values, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankNotIn(List<String> values) {
            addCriterion("staff_bank not in", values, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankBetween(String value1, String value2) {
            addCriterion("staff_bank between", value1, value2, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffBankNotBetween(String value1, String value2) {
            addCriterion("staff_bank not between", value1, value2, "staffBank");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseIsNull() {
            addCriterion("staff_out_cause is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseIsNotNull() {
            addCriterion("staff_out_cause is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseEqualTo(String value) {
            addCriterion("staff_out_cause =", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseNotEqualTo(String value) {
            addCriterion("staff_out_cause <>", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseGreaterThan(String value) {
            addCriterion("staff_out_cause >", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseGreaterThanOrEqualTo(String value) {
            addCriterion("staff_out_cause >=", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseLessThan(String value) {
            addCriterion("staff_out_cause <", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseLessThanOrEqualTo(String value) {
            addCriterion("staff_out_cause <=", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseLike(String value) {
            addCriterion("staff_out_cause like", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseNotLike(String value) {
            addCriterion("staff_out_cause not like", value, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseIn(List<String> values) {
            addCriterion("staff_out_cause in", values, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseNotIn(List<String> values) {
            addCriterion("staff_out_cause not in", values, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseBetween(String value1, String value2) {
            addCriterion("staff_out_cause between", value1, value2, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutCauseNotBetween(String value1, String value2) {
            addCriterion("staff_out_cause not between", value1, value2, "staffOutCause");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeIsNull() {
            addCriterion("staff_out_type is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeIsNotNull() {
            addCriterion("staff_out_type is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeEqualTo(String value) {
            addCriterion("staff_out_type =", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeNotEqualTo(String value) {
            addCriterion("staff_out_type <>", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeGreaterThan(String value) {
            addCriterion("staff_out_type >", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeGreaterThanOrEqualTo(String value) {
            addCriterion("staff_out_type >=", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeLessThan(String value) {
            addCriterion("staff_out_type <", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeLessThanOrEqualTo(String value) {
            addCriterion("staff_out_type <=", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeLike(String value) {
            addCriterion("staff_out_type like", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeNotLike(String value) {
            addCriterion("staff_out_type not like", value, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeIn(List<String> values) {
            addCriterion("staff_out_type in", values, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeNotIn(List<String> values) {
            addCriterion("staff_out_type not in", values, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeBetween(String value1, String value2) {
            addCriterion("staff_out_type between", value1, value2, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutTypeNotBetween(String value1, String value2) {
            addCriterion("staff_out_type not between", value1, value2, "staffOutType");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlIsNull() {
            addCriterion("staff_out_url is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlIsNotNull() {
            addCriterion("staff_out_url is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlEqualTo(String value) {
            addCriterion("staff_out_url =", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlNotEqualTo(String value) {
            addCriterion("staff_out_url <>", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlGreaterThan(String value) {
            addCriterion("staff_out_url >", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlGreaterThanOrEqualTo(String value) {
            addCriterion("staff_out_url >=", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlLessThan(String value) {
            addCriterion("staff_out_url <", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlLessThanOrEqualTo(String value) {
            addCriterion("staff_out_url <=", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlLike(String value) {
            addCriterion("staff_out_url like", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlNotLike(String value) {
            addCriterion("staff_out_url not like", value, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlIn(List<String> values) {
            addCriterion("staff_out_url in", values, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlNotIn(List<String> values) {
            addCriterion("staff_out_url not in", values, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlBetween(String value1, String value2) {
            addCriterion("staff_out_url between", value1, value2, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andStaffOutUrlNotBetween(String value1, String value2) {
            addCriterion("staff_out_url not between", value1, value2, "staffOutUrl");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryIsNull() {
            addCriterion("out_staff_category is null");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryIsNotNull() {
            addCriterion("out_staff_category is not null");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryEqualTo(String value) {
            addCriterion("out_staff_category =", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryNotEqualTo(String value) {
            addCriterion("out_staff_category <>", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryGreaterThan(String value) {
            addCriterion("out_staff_category >", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("out_staff_category >=", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryLessThan(String value) {
            addCriterion("out_staff_category <", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryLessThanOrEqualTo(String value) {
            addCriterion("out_staff_category <=", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryLike(String value) {
            addCriterion("out_staff_category like", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryNotLike(String value) {
            addCriterion("out_staff_category not like", value, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryIn(List<String> values) {
            addCriterion("out_staff_category in", values, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryNotIn(List<String> values) {
            addCriterion("out_staff_category not in", values, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryBetween(String value1, String value2) {
            addCriterion("out_staff_category between", value1, value2, "outStaffCategory");
            return (Criteria) this;
        }

        public Criteria andOutStaffCategoryNotBetween(String value1, String value2) {
            addCriterion("out_staff_category not between", value1, value2, "outStaffCategory");
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

        public Criteria andTransferDutyCodeIsNull() {
            addCriterion("transfer_duty_code is null");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeIsNotNull() {
            addCriterion("transfer_duty_code is not null");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeEqualTo(String value) {
            addCriterion("transfer_duty_code =", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeNotEqualTo(String value) {
            addCriterion("transfer_duty_code <>", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeGreaterThan(String value) {
            addCriterion("transfer_duty_code >", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_duty_code >=", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeLessThan(String value) {
            addCriterion("transfer_duty_code <", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeLessThanOrEqualTo(String value) {
            addCriterion("transfer_duty_code <=", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeLike(String value) {
            addCriterion("transfer_duty_code like", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeNotLike(String value) {
            addCriterion("transfer_duty_code not like", value, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeIn(List<String> values) {
            addCriterion("transfer_duty_code in", values, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeNotIn(List<String> values) {
            addCriterion("transfer_duty_code not in", values, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeBetween(String value1, String value2) {
            addCriterion("transfer_duty_code between", value1, value2, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferDutyCodeNotBetween(String value1, String value2) {
            addCriterion("transfer_duty_code not between", value1, value2, "transferDutyCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeIsNull() {
            addCriterion("transfer_station_code is null");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeIsNotNull() {
            addCriterion("transfer_station_code is not null");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeEqualTo(String value) {
            addCriterion("transfer_station_code =", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeNotEqualTo(String value) {
            addCriterion("transfer_station_code <>", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeGreaterThan(String value) {
            addCriterion("transfer_station_code >", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_station_code >=", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeLessThan(String value) {
            addCriterion("transfer_station_code <", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeLessThanOrEqualTo(String value) {
            addCriterion("transfer_station_code <=", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeLike(String value) {
            addCriterion("transfer_station_code like", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeNotLike(String value) {
            addCriterion("transfer_station_code not like", value, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeIn(List<String> values) {
            addCriterion("transfer_station_code in", values, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeNotIn(List<String> values) {
            addCriterion("transfer_station_code not in", values, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeBetween(String value1, String value2) {
            addCriterion("transfer_station_code between", value1, value2, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andTransferStationCodeNotBetween(String value1, String value2) {
            addCriterion("transfer_station_code not between", value1, value2, "transferStationCode");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusIsNull() {
            addCriterion("staff_transfer_status is null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusIsNotNull() {
            addCriterion("staff_transfer_status is not null");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusEqualTo(String value) {
            addCriterion("staff_transfer_status =", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusNotEqualTo(String value) {
            addCriterion("staff_transfer_status <>", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusGreaterThan(String value) {
            addCriterion("staff_transfer_status >", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusGreaterThanOrEqualTo(String value) {
            addCriterion("staff_transfer_status >=", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusLessThan(String value) {
            addCriterion("staff_transfer_status <", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusLessThanOrEqualTo(String value) {
            addCriterion("staff_transfer_status <=", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusLike(String value) {
            addCriterion("staff_transfer_status like", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusNotLike(String value) {
            addCriterion("staff_transfer_status not like", value, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusIn(List<String> values) {
            addCriterion("staff_transfer_status in", values, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusNotIn(List<String> values) {
            addCriterion("staff_transfer_status not in", values, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusBetween(String value1, String value2) {
            addCriterion("staff_transfer_status between", value1, value2, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffTransferStatusNotBetween(String value1, String value2) {
            addCriterion("staff_transfer_status not between", value1, value2, "staffTransferStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusIsNull() {
            addCriterion("staff_out_status is null");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusIsNotNull() {
            addCriterion("staff_out_status is not null");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusEqualTo(String value) {
            addCriterion("staff_out_status =", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusNotEqualTo(String value) {
            addCriterion("staff_out_status <>", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusGreaterThan(String value) {
            addCriterion("staff_out_status >", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusGreaterThanOrEqualTo(String value) {
            addCriterion("staff_out_status >=", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusLessThan(String value) {
            addCriterion("staff_out_status <", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusLessThanOrEqualTo(String value) {
            addCriterion("staff_out_status <=", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusLike(String value) {
            addCriterion("staff_out_status like", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusNotLike(String value) {
            addCriterion("staff_out_status not like", value, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusIn(List<String> values) {
            addCriterion("staff_out_status in", values, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusNotIn(List<String> values) {
            addCriterion("staff_out_status not in", values, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusBetween(String value1, String value2) {
            addCriterion("staff_out_status between", value1, value2, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffOutStatusNotBetween(String value1, String value2) {
            addCriterion("staff_out_status not between", value1, value2, "staffOutStatus");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeIsNull() {
            addCriterion("staff_check_type is null");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeIsNotNull() {
            addCriterion("staff_check_type is not null");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeEqualTo(String value) {
            addCriterion("staff_check_type =", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeNotEqualTo(String value) {
            addCriterion("staff_check_type <>", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeGreaterThan(String value) {
            addCriterion("staff_check_type >", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeGreaterThanOrEqualTo(String value) {
            addCriterion("staff_check_type >=", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeLessThan(String value) {
            addCriterion("staff_check_type <", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeLessThanOrEqualTo(String value) {
            addCriterion("staff_check_type <=", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeLike(String value) {
            addCriterion("staff_check_type like", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeNotLike(String value) {
            addCriterion("staff_check_type not like", value, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeIn(List<String> values) {
            addCriterion("staff_check_type in", values, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeNotIn(List<String> values) {
            addCriterion("staff_check_type not in", values, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeBetween(String value1, String value2) {
            addCriterion("staff_check_type between", value1, value2, "staffCheckType");
            return (Criteria) this;
        }

        public Criteria andStaffCheckTypeNotBetween(String value1, String value2) {
            addCriterion("staff_check_type not between", value1, value2, "staffCheckType");
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