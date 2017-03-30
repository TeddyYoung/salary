package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinalSalaryQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public FinalSalaryQuery() {
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

        public Criteria andAssociatedDataOneIsNull() {
            addCriterion("associated_data_one is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneIsNotNull() {
            addCriterion("associated_data_one is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneEqualTo(String value) {
            addCriterion("associated_data_one =", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneNotEqualTo(String value) {
            addCriterion("associated_data_one <>", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneGreaterThan(String value) {
            addCriterion("associated_data_one >", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneGreaterThanOrEqualTo(String value) {
            addCriterion("associated_data_one >=", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneLessThan(String value) {
            addCriterion("associated_data_one <", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneLessThanOrEqualTo(String value) {
            addCriterion("associated_data_one <=", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneLike(String value) {
            addCriterion("associated_data_one like", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneNotLike(String value) {
            addCriterion("associated_data_one not like", value, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneIn(List<String> values) {
            addCriterion("associated_data_one in", values, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneNotIn(List<String> values) {
            addCriterion("associated_data_one not in", values, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneBetween(String value1, String value2) {
            addCriterion("associated_data_one between", value1, value2, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataOneNotBetween(String value1, String value2) {
            addCriterion("associated_data_one not between", value1, value2, "associatedDataOne");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoIsNull() {
            addCriterion("associated_data_two is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoIsNotNull() {
            addCriterion("associated_data_two is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoEqualTo(String value) {
            addCriterion("associated_data_two =", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoNotEqualTo(String value) {
            addCriterion("associated_data_two <>", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoGreaterThan(String value) {
            addCriterion("associated_data_two >", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoGreaterThanOrEqualTo(String value) {
            addCriterion("associated_data_two >=", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoLessThan(String value) {
            addCriterion("associated_data_two <", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoLessThanOrEqualTo(String value) {
            addCriterion("associated_data_two <=", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoLike(String value) {
            addCriterion("associated_data_two like", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoNotLike(String value) {
            addCriterion("associated_data_two not like", value, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoIn(List<String> values) {
            addCriterion("associated_data_two in", values, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoNotIn(List<String> values) {
            addCriterion("associated_data_two not in", values, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoBetween(String value1, String value2) {
            addCriterion("associated_data_two between", value1, value2, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataTwoNotBetween(String value1, String value2) {
            addCriterion("associated_data_two not between", value1, value2, "associatedDataTwo");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeIsNull() {
            addCriterion("associated_data_three is null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeIsNotNull() {
            addCriterion("associated_data_three is not null");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeEqualTo(String value) {
            addCriterion("associated_data_three =", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeNotEqualTo(String value) {
            addCriterion("associated_data_three <>", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeGreaterThan(String value) {
            addCriterion("associated_data_three >", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeGreaterThanOrEqualTo(String value) {
            addCriterion("associated_data_three >=", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeLessThan(String value) {
            addCriterion("associated_data_three <", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeLessThanOrEqualTo(String value) {
            addCriterion("associated_data_three <=", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeLike(String value) {
            addCriterion("associated_data_three like", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeNotLike(String value) {
            addCriterion("associated_data_three not like", value, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeIn(List<String> values) {
            addCriterion("associated_data_three in", values, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeNotIn(List<String> values) {
            addCriterion("associated_data_three not in", values, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeBetween(String value1, String value2) {
            addCriterion("associated_data_three between", value1, value2, "associatedDataThree");
            return (Criteria) this;
        }

        public Criteria andAssociatedDataThreeNotBetween(String value1, String value2) {
            addCriterion("associated_data_three not between", value1, value2, "associatedDataThree");
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

        public Criteria andStationLevelNameIsNull() {
            addCriterion("station_level_name is null");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameIsNotNull() {
            addCriterion("station_level_name is not null");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameEqualTo(String value) {
            addCriterion("station_level_name =", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameNotEqualTo(String value) {
            addCriterion("station_level_name <>", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameGreaterThan(String value) {
            addCriterion("station_level_name >", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("station_level_name >=", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameLessThan(String value) {
            addCriterion("station_level_name <", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameLessThanOrEqualTo(String value) {
            addCriterion("station_level_name <=", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameLike(String value) {
            addCriterion("station_level_name like", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameNotLike(String value) {
            addCriterion("station_level_name not like", value, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameIn(List<String> values) {
            addCriterion("station_level_name in", values, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameNotIn(List<String> values) {
            addCriterion("station_level_name not in", values, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameBetween(String value1, String value2) {
            addCriterion("station_level_name between", value1, value2, "stationLevelName");
            return (Criteria) this;
        }

        public Criteria andStationLevelNameNotBetween(String value1, String value2) {
            addCriterion("station_level_name not between", value1, value2, "stationLevelName");
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
            addCriterion("is_stamanage_foreman is null");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanIsNotNull() {
            addCriterion("is_stamanage_foreman is not null");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanEqualTo(String value) {
            addCriterion("is_stamanage_foreman =", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotEqualTo(String value) {
            addCriterion("is_stamanage_foreman <>", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanGreaterThan(String value) {
            addCriterion("is_stamanage_foreman >", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanGreaterThanOrEqualTo(String value) {
            addCriterion("is_stamanage_foreman >=", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanLessThan(String value) {
            addCriterion("is_stamanage_foreman <", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanLessThanOrEqualTo(String value) {
            addCriterion("is_stamanage_foreman <=", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanLike(String value) {
            addCriterion("is_stamanage_foreman like", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotLike(String value) {
            addCriterion("is_stamanage_foreman not like", value, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanIn(List<String> values) {
            addCriterion("is_stamanage_foreman in", values, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotIn(List<String> values) {
            addCriterion("is_stamanage_foreman not in", values, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanBetween(String value1, String value2) {
            addCriterion("is_stamanage_foreman between", value1, value2, "isStamanageForeman");
            return (Criteria) this;
        }

        public Criteria andIsStamanageForemanNotBetween(String value1, String value2) {
            addCriterion("is_stamanage_foreman not between", value1, value2, "isStamanageForeman");
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

        public Criteria andProbationCoefficientIsNull() {
            addCriterion("probation_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientIsNotNull() {
            addCriterion("probation_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientEqualTo(BigDecimal value) {
            addCriterion("probation_coefficient =", value, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("probation_coefficient <>", value, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientGreaterThan(BigDecimal value) {
            addCriterion("probation_coefficient >", value, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("probation_coefficient >=", value, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientLessThan(BigDecimal value) {
            addCriterion("probation_coefficient <", value, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("probation_coefficient <=", value, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientIn(List<BigDecimal> values) {
            addCriterion("probation_coefficient in", values, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("probation_coefficient not in", values, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("probation_coefficient between", value1, value2, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andProbationCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("probation_coefficient not between", value1, value2, "probationCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientIsNull() {
            addCriterion("working_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientIsNotNull() {
            addCriterion("working_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientEqualTo(BigDecimal value) {
            addCriterion("working_coefficient =", value, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("working_coefficient <>", value, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientGreaterThan(BigDecimal value) {
            addCriterion("working_coefficient >", value, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("working_coefficient >=", value, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientLessThan(BigDecimal value) {
            addCriterion("working_coefficient <", value, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("working_coefficient <=", value, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientIn(List<BigDecimal> values) {
            addCriterion("working_coefficient in", values, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("working_coefficient not in", values, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("working_coefficient between", value1, value2, "workingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWorkingCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("working_coefficient not between", value1, value2, "workingCoefficient");
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

        public Criteria andPostManHourIsNull() {
            addCriterion("post_man_hour is null");
            return (Criteria) this;
        }

        public Criteria andPostManHourIsNotNull() {
            addCriterion("post_man_hour is not null");
            return (Criteria) this;
        }

        public Criteria andPostManHourEqualTo(BigDecimal value) {
            addCriterion("post_man_hour =", value, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourNotEqualTo(BigDecimal value) {
            addCriterion("post_man_hour <>", value, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourGreaterThan(BigDecimal value) {
            addCriterion("post_man_hour >", value, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("post_man_hour >=", value, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourLessThan(BigDecimal value) {
            addCriterion("post_man_hour <", value, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourLessThanOrEqualTo(BigDecimal value) {
            addCriterion("post_man_hour <=", value, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourIn(List<BigDecimal> values) {
            addCriterion("post_man_hour in", values, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourNotIn(List<BigDecimal> values) {
            addCriterion("post_man_hour not in", values, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_man_hour between", value1, value2, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostManHourNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_man_hour not between", value1, value2, "postManHour");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryIsNull() {
            addCriterion("post_hour_salary is null");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryIsNotNull() {
            addCriterion("post_hour_salary is not null");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryEqualTo(BigDecimal value) {
            addCriterion("post_hour_salary =", value, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryNotEqualTo(BigDecimal value) {
            addCriterion("post_hour_salary <>", value, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryGreaterThan(BigDecimal value) {
            addCriterion("post_hour_salary >", value, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("post_hour_salary >=", value, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryLessThan(BigDecimal value) {
            addCriterion("post_hour_salary <", value, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("post_hour_salary <=", value, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryIn(List<BigDecimal> values) {
            addCriterion("post_hour_salary in", values, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryNotIn(List<BigDecimal> values) {
            addCriterion("post_hour_salary not in", values, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_hour_salary between", value1, value2, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andPostHourSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_hour_salary not between", value1, value2, "postHourSalary");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusIsNull() {
            addCriterion("manage_post_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusIsNotNull() {
            addCriterion("manage_post_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusEqualTo(BigDecimal value) {
            addCriterion("manage_post_oil_bonus =", value, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("manage_post_oil_bonus <>", value, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusGreaterThan(BigDecimal value) {
            addCriterion("manage_post_oil_bonus >", value, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_post_oil_bonus >=", value, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusLessThan(BigDecimal value) {
            addCriterion("manage_post_oil_bonus <", value, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_post_oil_bonus <=", value, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusIn(List<BigDecimal> values) {
            addCriterion("manage_post_oil_bonus in", values, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("manage_post_oil_bonus not in", values, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_post_oil_bonus between", value1, value2, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_post_oil_bonus not between", value1, value2, "managePostOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusIsNull() {
            addCriterion("first_tier_staff_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusIsNotNull() {
            addCriterion("first_tier_staff_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_oil_bonus =", value, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_oil_bonus <>", value, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusGreaterThan(BigDecimal value) {
            addCriterion("first_tier_staff_oil_bonus >", value, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_oil_bonus >=", value, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusLessThan(BigDecimal value) {
            addCriterion("first_tier_staff_oil_bonus <", value, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_oil_bonus <=", value, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusIn(List<BigDecimal> values) {
            addCriterion("first_tier_staff_oil_bonus in", values, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("first_tier_staff_oil_bonus not in", values, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_tier_staff_oil_bonus between", value1, value2, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_tier_staff_oil_bonus not between", value1, value2, "firstTierStaffOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusIsNull() {
            addCriterion("manage_post_non_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusIsNotNull() {
            addCriterion("manage_post_non_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusEqualTo(BigDecimal value) {
            addCriterion("manage_post_non_oil_bonus =", value, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("manage_post_non_oil_bonus <>", value, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusGreaterThan(BigDecimal value) {
            addCriterion("manage_post_non_oil_bonus >", value, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_post_non_oil_bonus >=", value, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusLessThan(BigDecimal value) {
            addCriterion("manage_post_non_oil_bonus <", value, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_post_non_oil_bonus <=", value, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusIn(List<BigDecimal> values) {
            addCriterion("manage_post_non_oil_bonus in", values, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("manage_post_non_oil_bonus not in", values, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_post_non_oil_bonus between", value1, value2, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostNonOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_post_non_oil_bonus not between", value1, value2, "managePostNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusIsNull() {
            addCriterion("first_tier_staff_non_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusIsNotNull() {
            addCriterion("first_tier_staff_non_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_non_oil_bonus =", value, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_non_oil_bonus <>", value, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusGreaterThan(BigDecimal value) {
            addCriterion("first_tier_staff_non_oil_bonus >", value, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_non_oil_bonus >=", value, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusLessThan(BigDecimal value) {
            addCriterion("first_tier_staff_non_oil_bonus <", value, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_non_oil_bonus <=", value, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusIn(List<BigDecimal> values) {
            addCriterion("first_tier_staff_non_oil_bonus in", values, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("first_tier_staff_non_oil_bonus not in", values, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_tier_staff_non_oil_bonus between", value1, value2, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffNonOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_tier_staff_non_oil_bonus not between", value1, value2, "firstTierStaffNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusIsNull() {
            addCriterion("manage_post_manage_bonus is null");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusIsNotNull() {
            addCriterion("manage_post_manage_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusEqualTo(BigDecimal value) {
            addCriterion("manage_post_manage_bonus =", value, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusNotEqualTo(BigDecimal value) {
            addCriterion("manage_post_manage_bonus <>", value, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusGreaterThan(BigDecimal value) {
            addCriterion("manage_post_manage_bonus >", value, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_post_manage_bonus >=", value, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusLessThan(BigDecimal value) {
            addCriterion("manage_post_manage_bonus <", value, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_post_manage_bonus <=", value, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusIn(List<BigDecimal> values) {
            addCriterion("manage_post_manage_bonus in", values, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusNotIn(List<BigDecimal> values) {
            addCriterion("manage_post_manage_bonus not in", values, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_post_manage_bonus between", value1, value2, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andManagePostManageBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_post_manage_bonus not between", value1, value2, "managePostManageBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusIsNull() {
            addCriterion("first_tier_staff_performance_bonus is null");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusIsNotNull() {
            addCriterion("first_tier_staff_performance_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_performance_bonus =", value, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusNotEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_performance_bonus <>", value, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusGreaterThan(BigDecimal value) {
            addCriterion("first_tier_staff_performance_bonus >", value, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_performance_bonus >=", value, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusLessThan(BigDecimal value) {
            addCriterion("first_tier_staff_performance_bonus <", value, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_tier_staff_performance_bonus <=", value, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusIn(List<BigDecimal> values) {
            addCriterion("first_tier_staff_performance_bonus in", values, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusNotIn(List<BigDecimal> values) {
            addCriterion("first_tier_staff_performance_bonus not in", values, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_tier_staff_performance_bonus between", value1, value2, "firstTierStaffPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andFirstTierStaffPerformanceBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_tier_staff_performance_bonus not between", value1, value2, "firstTierStaffPerformanceBonus");
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

        public Criteria andOvertimeAllowanceIsNull() {
            addCriterion("overtime_allowance is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceIsNotNull() {
            addCriterion("overtime_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceEqualTo(BigDecimal value) {
            addCriterion("overtime_allowance =", value, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("overtime_allowance <>", value, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceGreaterThan(BigDecimal value) {
            addCriterion("overtime_allowance >", value, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_allowance >=", value, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceLessThan(BigDecimal value) {
            addCriterion("overtime_allowance <", value, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("overtime_allowance <=", value, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceIn(List<BigDecimal> values) {
            addCriterion("overtime_allowance in", values, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("overtime_allowance not in", values, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_allowance between", value1, value2, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOvertimeAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("overtime_allowance not between", value1, value2, "overtimeAllowance");
            return (Criteria) this;
        }

        public Criteria andOilBonusIsNull() {
            addCriterion("oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andOilBonusIsNotNull() {
            addCriterion("oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andOilBonusEqualTo(BigDecimal value) {
            addCriterion("oil_bonus =", value, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("oil_bonus <>", value, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusGreaterThan(BigDecimal value) {
            addCriterion("oil_bonus >", value, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_bonus >=", value, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusLessThan(BigDecimal value) {
            addCriterion("oil_bonus <", value, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_bonus <=", value, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusIn(List<BigDecimal> values) {
            addCriterion("oil_bonus in", values, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("oil_bonus not in", values, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_bonus between", value1, value2, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_bonus not between", value1, value2, "oilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusIsNull() {
            addCriterion("non_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusIsNotNull() {
            addCriterion("non_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusEqualTo(BigDecimal value) {
            addCriterion("non_oil_bonus =", value, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("non_oil_bonus <>", value, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusGreaterThan(BigDecimal value) {
            addCriterion("non_oil_bonus >", value, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_bonus >=", value, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusLessThan(BigDecimal value) {
            addCriterion("non_oil_bonus <", value, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_bonus <=", value, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusIn(List<BigDecimal> values) {
            addCriterion("non_oil_bonus in", values, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("non_oil_bonus not in", values, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_bonus between", value1, value2, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andNonOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_bonus not between", value1, value2, "nonOilBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusIsNull() {
            addCriterion("star_level_performance_bonus is null");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusIsNotNull() {
            addCriterion("star_level_performance_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusEqualTo(BigDecimal value) {
            addCriterion("star_level_performance_bonus =", value, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusNotEqualTo(BigDecimal value) {
            addCriterion("star_level_performance_bonus <>", value, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusGreaterThan(BigDecimal value) {
            addCriterion("star_level_performance_bonus >", value, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("star_level_performance_bonus >=", value, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusLessThan(BigDecimal value) {
            addCriterion("star_level_performance_bonus <", value, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("star_level_performance_bonus <=", value, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusIn(List<BigDecimal> values) {
            addCriterion("star_level_performance_bonus in", values, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusNotIn(List<BigDecimal> values) {
            addCriterion("star_level_performance_bonus not in", values, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("star_level_performance_bonus between", value1, value2, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andStarLevelPerformanceBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("star_level_performance_bonus not between", value1, value2, "starLevelPerformanceBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusIsNull() {
            addCriterion("manager_bonus is null");
            return (Criteria) this;
        }

        public Criteria andManagerBonusIsNotNull() {
            addCriterion("manager_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andManagerBonusEqualTo(BigDecimal value) {
            addCriterion("manager_bonus =", value, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusNotEqualTo(BigDecimal value) {
            addCriterion("manager_bonus <>", value, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusGreaterThan(BigDecimal value) {
            addCriterion("manager_bonus >", value, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manager_bonus >=", value, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusLessThan(BigDecimal value) {
            addCriterion("manager_bonus <", value, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manager_bonus <=", value, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusIn(List<BigDecimal> values) {
            addCriterion("manager_bonus in", values, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusNotIn(List<BigDecimal> values) {
            addCriterion("manager_bonus not in", values, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manager_bonus between", value1, value2, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andManagerBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manager_bonus not between", value1, value2, "managerBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusIsNull() {
            addCriterion("performance_challenge_bonus is null");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusIsNotNull() {
            addCriterion("performance_challenge_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusEqualTo(BigDecimal value) {
            addCriterion("performance_challenge_bonus =", value, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusNotEqualTo(BigDecimal value) {
            addCriterion("performance_challenge_bonus <>", value, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusGreaterThan(BigDecimal value) {
            addCriterion("performance_challenge_bonus >", value, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("performance_challenge_bonus >=", value, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusLessThan(BigDecimal value) {
            addCriterion("performance_challenge_bonus <", value, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("performance_challenge_bonus <=", value, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusIn(List<BigDecimal> values) {
            addCriterion("performance_challenge_bonus in", values, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusNotIn(List<BigDecimal> values) {
            addCriterion("performance_challenge_bonus not in", values, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance_challenge_bonus between", value1, value2, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPerformanceChallengeBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("performance_challenge_bonus not between", value1, value2, "performanceChallengeBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusIsNull() {
            addCriterion("promotions_bonus is null");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusIsNotNull() {
            addCriterion("promotions_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusEqualTo(BigDecimal value) {
            addCriterion("promotions_bonus =", value, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusNotEqualTo(BigDecimal value) {
            addCriterion("promotions_bonus <>", value, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusGreaterThan(BigDecimal value) {
            addCriterion("promotions_bonus >", value, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotions_bonus >=", value, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusLessThan(BigDecimal value) {
            addCriterion("promotions_bonus <", value, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotions_bonus <=", value, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusIn(List<BigDecimal> values) {
            addCriterion("promotions_bonus in", values, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusNotIn(List<BigDecimal> values) {
            addCriterion("promotions_bonus not in", values, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotions_bonus between", value1, value2, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andPromotionsBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotions_bonus not between", value1, value2, "promotionsBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusIsNull() {
            addCriterion("gold_idea_bonus is null");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusIsNotNull() {
            addCriterion("gold_idea_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusEqualTo(BigDecimal value) {
            addCriterion("gold_idea_bonus =", value, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusNotEqualTo(BigDecimal value) {
            addCriterion("gold_idea_bonus <>", value, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusGreaterThan(BigDecimal value) {
            addCriterion("gold_idea_bonus >", value, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gold_idea_bonus >=", value, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusLessThan(BigDecimal value) {
            addCriterion("gold_idea_bonus <", value, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gold_idea_bonus <=", value, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusIn(List<BigDecimal> values) {
            addCriterion("gold_idea_bonus in", values, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusNotIn(List<BigDecimal> values) {
            addCriterion("gold_idea_bonus not in", values, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold_idea_bonus between", value1, value2, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andGoldIdeaBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gold_idea_bonus not between", value1, value2, "goldIdeaBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusIsNull() {
            addCriterion("annual_bonus is null");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusIsNotNull() {
            addCriterion("annual_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusEqualTo(BigDecimal value) {
            addCriterion("annual_bonus =", value, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusNotEqualTo(BigDecimal value) {
            addCriterion("annual_bonus <>", value, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusGreaterThan(BigDecimal value) {
            addCriterion("annual_bonus >", value, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_bonus >=", value, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusLessThan(BigDecimal value) {
            addCriterion("annual_bonus <", value, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annual_bonus <=", value, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusIn(List<BigDecimal> values) {
            addCriterion("annual_bonus in", values, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusNotIn(List<BigDecimal> values) {
            addCriterion("annual_bonus not in", values, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_bonus between", value1, value2, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andAnnualBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annual_bonus not between", value1, value2, "annualBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusIsNull() {
            addCriterion("splendor_card_bonus is null");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusIsNotNull() {
            addCriterion("splendor_card_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusEqualTo(BigDecimal value) {
            addCriterion("splendor_card_bonus =", value, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusNotEqualTo(BigDecimal value) {
            addCriterion("splendor_card_bonus <>", value, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusGreaterThan(BigDecimal value) {
            addCriterion("splendor_card_bonus >", value, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("splendor_card_bonus >=", value, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusLessThan(BigDecimal value) {
            addCriterion("splendor_card_bonus <", value, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("splendor_card_bonus <=", value, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusIn(List<BigDecimal> values) {
            addCriterion("splendor_card_bonus in", values, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusNotIn(List<BigDecimal> values) {
            addCriterion("splendor_card_bonus not in", values, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("splendor_card_bonus between", value1, value2, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andSplendorCardBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("splendor_card_bonus not between", value1, value2, "splendorCardBonus");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyIsNull() {
            addCriterion("part_time_store_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyIsNotNull() {
            addCriterion("part_time_store_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyEqualTo(BigDecimal value) {
            addCriterion("part_time_store_subsidy =", value, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyNotEqualTo(BigDecimal value) {
            addCriterion("part_time_store_subsidy <>", value, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyGreaterThan(BigDecimal value) {
            addCriterion("part_time_store_subsidy >", value, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("part_time_store_subsidy >=", value, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyLessThan(BigDecimal value) {
            addCriterion("part_time_store_subsidy <", value, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("part_time_store_subsidy <=", value, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyIn(List<BigDecimal> values) {
            addCriterion("part_time_store_subsidy in", values, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyNotIn(List<BigDecimal> values) {
            addCriterion("part_time_store_subsidy not in", values, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("part_time_store_subsidy between", value1, value2, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPartTimeStoreSubsidyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("part_time_store_subsidy not between", value1, value2, "partTimeStoreSubsidy");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceIsNull() {
            addCriterion("post_allowance is null");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceIsNotNull() {
            addCriterion("post_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceEqualTo(BigDecimal value) {
            addCriterion("post_allowance =", value, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("post_allowance <>", value, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceGreaterThan(BigDecimal value) {
            addCriterion("post_allowance >", value, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("post_allowance >=", value, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceLessThan(BigDecimal value) {
            addCriterion("post_allowance <", value, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("post_allowance <=", value, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceIn(List<BigDecimal> values) {
            addCriterion("post_allowance in", values, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("post_allowance not in", values, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_allowance between", value1, value2, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andPostAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("post_allowance not between", value1, value2, "postAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceIsNull() {
            addCriterion("high_temperature_allowance is null");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceIsNotNull() {
            addCriterion("high_temperature_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceEqualTo(BigDecimal value) {
            addCriterion("high_temperature_allowance =", value, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("high_temperature_allowance <>", value, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceGreaterThan(BigDecimal value) {
            addCriterion("high_temperature_allowance >", value, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("high_temperature_allowance >=", value, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceLessThan(BigDecimal value) {
            addCriterion("high_temperature_allowance <", value, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("high_temperature_allowance <=", value, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceIn(List<BigDecimal> values) {
            addCriterion("high_temperature_allowance in", values, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("high_temperature_allowance not in", values, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high_temperature_allowance between", value1, value2, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andHighTemperatureAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("high_temperature_allowance not between", value1, value2, "highTemperatureAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceIsNull() {
            addCriterion("service_year_allowance is null");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceIsNotNull() {
            addCriterion("service_year_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceEqualTo(BigDecimal value) {
            addCriterion("service_year_allowance =", value, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("service_year_allowance <>", value, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceGreaterThan(BigDecimal value) {
            addCriterion("service_year_allowance >", value, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_year_allowance >=", value, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceLessThan(BigDecimal value) {
            addCriterion("service_year_allowance <", value, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_year_allowance <=", value, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceIn(List<BigDecimal> values) {
            addCriterion("service_year_allowance in", values, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("service_year_allowance not in", values, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_year_allowance between", value1, value2, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andServiceYearAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_year_allowance not between", value1, value2, "serviceYearAllowance");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryIsNull() {
            addCriterion("total_gross_salary is null");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryIsNotNull() {
            addCriterion("total_gross_salary is not null");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryEqualTo(BigDecimal value) {
            addCriterion("total_gross_salary =", value, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryNotEqualTo(BigDecimal value) {
            addCriterion("total_gross_salary <>", value, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryGreaterThan(BigDecimal value) {
            addCriterion("total_gross_salary >", value, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_gross_salary >=", value, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryLessThan(BigDecimal value) {
            addCriterion("total_gross_salary <", value, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_gross_salary <=", value, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryIn(List<BigDecimal> values) {
            addCriterion("total_gross_salary in", values, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryNotIn(List<BigDecimal> values) {
            addCriterion("total_gross_salary not in", values, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_gross_salary between", value1, value2, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andTotalGrossSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_gross_salary not between", value1, value2, "totalGrossSalary");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyIsNull() {
            addCriterion("working_dinner_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyIsNotNull() {
            addCriterion("working_dinner_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyEqualTo(BigDecimal value) {
            addCriterion("working_dinner_subsidy =", value, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyNotEqualTo(BigDecimal value) {
            addCriterion("working_dinner_subsidy <>", value, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyGreaterThan(BigDecimal value) {
            addCriterion("working_dinner_subsidy >", value, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("working_dinner_subsidy >=", value, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyLessThan(BigDecimal value) {
            addCriterion("working_dinner_subsidy <", value, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("working_dinner_subsidy <=", value, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyIn(List<BigDecimal> values) {
            addCriterion("working_dinner_subsidy in", values, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyNotIn(List<BigDecimal> values) {
            addCriterion("working_dinner_subsidy not in", values, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("working_dinner_subsidy between", value1, value2, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andWorkingDinnerSubsidyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("working_dinner_subsidy not between", value1, value2, "workingDinnerSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyIsNull() {
            addCriterion("accommodation_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyIsNotNull() {
            addCriterion("accommodation_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyEqualTo(BigDecimal value) {
            addCriterion("accommodation_subsidy =", value, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyNotEqualTo(BigDecimal value) {
            addCriterion("accommodation_subsidy <>", value, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyGreaterThan(BigDecimal value) {
            addCriterion("accommodation_subsidy >", value, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("accommodation_subsidy >=", value, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyLessThan(BigDecimal value) {
            addCriterion("accommodation_subsidy <", value, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("accommodation_subsidy <=", value, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyIn(List<BigDecimal> values) {
            addCriterion("accommodation_subsidy in", values, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyNotIn(List<BigDecimal> values) {
            addCriterion("accommodation_subsidy not in", values, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accommodation_subsidy between", value1, value2, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andAccommodationSubsidyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("accommodation_subsidy not between", value1, value2, "accommodationSubsidy");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsIsNull() {
            addCriterion("holiday_costs is null");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsIsNotNull() {
            addCriterion("holiday_costs is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsEqualTo(BigDecimal value) {
            addCriterion("holiday_costs =", value, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsNotEqualTo(BigDecimal value) {
            addCriterion("holiday_costs <>", value, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsGreaterThan(BigDecimal value) {
            addCriterion("holiday_costs >", value, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("holiday_costs >=", value, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsLessThan(BigDecimal value) {
            addCriterion("holiday_costs <", value, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("holiday_costs <=", value, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsIn(List<BigDecimal> values) {
            addCriterion("holiday_costs in", values, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsNotIn(List<BigDecimal> values) {
            addCriterion("holiday_costs not in", values, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("holiday_costs between", value1, value2, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHolidayCostsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("holiday_costs not between", value1, value2, "holidayCosts");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeIsNull() {
            addCriterion("herb_watermelon_time is null");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeIsNotNull() {
            addCriterion("herb_watermelon_time is not null");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeEqualTo(BigDecimal value) {
            addCriterion("herb_watermelon_time =", value, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeNotEqualTo(BigDecimal value) {
            addCriterion("herb_watermelon_time <>", value, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeGreaterThan(BigDecimal value) {
            addCriterion("herb_watermelon_time >", value, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("herb_watermelon_time >=", value, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeLessThan(BigDecimal value) {
            addCriterion("herb_watermelon_time <", value, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("herb_watermelon_time <=", value, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeIn(List<BigDecimal> values) {
            addCriterion("herb_watermelon_time in", values, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeNotIn(List<BigDecimal> values) {
            addCriterion("herb_watermelon_time not in", values, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("herb_watermelon_time between", value1, value2, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andHerbWatermelonTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("herb_watermelon_time not between", value1, value2, "herbWatermelonTime");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryIsNull() {
            addCriterion("gross_combination_salary is null");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryIsNotNull() {
            addCriterion("gross_combination_salary is not null");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryEqualTo(BigDecimal value) {
            addCriterion("gross_combination_salary =", value, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryNotEqualTo(BigDecimal value) {
            addCriterion("gross_combination_salary <>", value, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryGreaterThan(BigDecimal value) {
            addCriterion("gross_combination_salary >", value, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_combination_salary >=", value, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryLessThan(BigDecimal value) {
            addCriterion("gross_combination_salary <", value, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gross_combination_salary <=", value, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryIn(List<BigDecimal> values) {
            addCriterion("gross_combination_salary in", values, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryNotIn(List<BigDecimal> values) {
            addCriterion("gross_combination_salary not in", values, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_combination_salary between", value1, value2, "grossCombinationSalary");
            return (Criteria) this;
        }

        public Criteria andGrossCombinationSalaryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gross_combination_salary not between", value1, value2, "grossCombinationSalary");
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

        public Criteria andTaxableIncomeIsNull() {
            addCriterion("taxable_income is null");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeIsNotNull() {
            addCriterion("taxable_income is not null");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeEqualTo(BigDecimal value) {
            addCriterion("taxable_income =", value, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeNotEqualTo(BigDecimal value) {
            addCriterion("taxable_income <>", value, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeGreaterThan(BigDecimal value) {
            addCriterion("taxable_income >", value, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taxable_income >=", value, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeLessThan(BigDecimal value) {
            addCriterion("taxable_income <", value, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taxable_income <=", value, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeIn(List<BigDecimal> values) {
            addCriterion("taxable_income in", values, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeNotIn(List<BigDecimal> values) {
            addCriterion("taxable_income not in", values, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxable_income between", value1, value2, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andTaxableIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taxable_income not between", value1, value2, "taxableIncome");
            return (Criteria) this;
        }

        public Criteria andWageTaxIsNull() {
            addCriterion("wage_tax is null");
            return (Criteria) this;
        }

        public Criteria andWageTaxIsNotNull() {
            addCriterion("wage_tax is not null");
            return (Criteria) this;
        }

        public Criteria andWageTaxEqualTo(BigDecimal value) {
            addCriterion("wage_tax =", value, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxNotEqualTo(BigDecimal value) {
            addCriterion("wage_tax <>", value, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxGreaterThan(BigDecimal value) {
            addCriterion("wage_tax >", value, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("wage_tax >=", value, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxLessThan(BigDecimal value) {
            addCriterion("wage_tax <", value, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("wage_tax <=", value, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxIn(List<BigDecimal> values) {
            addCriterion("wage_tax in", values, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxNotIn(List<BigDecimal> values) {
            addCriterion("wage_tax not in", values, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wage_tax between", value1, value2, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWageTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("wage_tax not between", value1, value2, "wageTax");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesIsNull() {
            addCriterion("withholding_subsidies is null");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesIsNotNull() {
            addCriterion("withholding_subsidies is not null");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesEqualTo(BigDecimal value) {
            addCriterion("withholding_subsidies =", value, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesNotEqualTo(BigDecimal value) {
            addCriterion("withholding_subsidies <>", value, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesGreaterThan(BigDecimal value) {
            addCriterion("withholding_subsidies >", value, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withholding_subsidies >=", value, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesLessThan(BigDecimal value) {
            addCriterion("withholding_subsidies <", value, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withholding_subsidies <=", value, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesIn(List<BigDecimal> values) {
            addCriterion("withholding_subsidies in", values, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesNotIn(List<BigDecimal> values) {
            addCriterion("withholding_subsidies not in", values, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withholding_subsidies between", value1, value2, "withholdingSubsidies");
            return (Criteria) this;
        }

        public Criteria andWithholdingSubsidiesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withholding_subsidies not between", value1, value2, "withholdingSubsidies");
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

        public Criteria andTotalChargeIsNull() {
            addCriterion("total_charge is null");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIsNotNull() {
            addCriterion("total_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChargeEqualTo(BigDecimal value) {
            addCriterion("total_charge =", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotEqualTo(BigDecimal value) {
            addCriterion("total_charge <>", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeGreaterThan(BigDecimal value) {
            addCriterion("total_charge >", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_charge >=", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeLessThan(BigDecimal value) {
            addCriterion("total_charge <", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_charge <=", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIn(List<BigDecimal> values) {
            addCriterion("total_charge in", values, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotIn(List<BigDecimal> values) {
            addCriterion("total_charge not in", values, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_charge between", value1, value2, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_charge not between", value1, value2, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andNetPayIsNull() {
            addCriterion("net_pay is null");
            return (Criteria) this;
        }

        public Criteria andNetPayIsNotNull() {
            addCriterion("net_pay is not null");
            return (Criteria) this;
        }

        public Criteria andNetPayEqualTo(BigDecimal value) {
            addCriterion("net_pay =", value, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayNotEqualTo(BigDecimal value) {
            addCriterion("net_pay <>", value, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayGreaterThan(BigDecimal value) {
            addCriterion("net_pay >", value, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("net_pay >=", value, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayLessThan(BigDecimal value) {
            addCriterion("net_pay <", value, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("net_pay <=", value, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayIn(List<BigDecimal> values) {
            addCriterion("net_pay in", values, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayNotIn(List<BigDecimal> values) {
            addCriterion("net_pay not in", values, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_pay between", value1, value2, "netPay");
            return (Criteria) this;
        }

        public Criteria andNetPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("net_pay not between", value1, value2, "netPay");
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

        public Criteria andSalaryDifferenceFinalIsNull() {
            addCriterion("salary_difference_final is null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalIsNotNull() {
            addCriterion("salary_difference_final is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalEqualTo(BigDecimal value) {
            addCriterion("salary_difference_final =", value, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalNotEqualTo(BigDecimal value) {
            addCriterion("salary_difference_final <>", value, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalGreaterThan(BigDecimal value) {
            addCriterion("salary_difference_final >", value, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_difference_final >=", value, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalLessThan(BigDecimal value) {
            addCriterion("salary_difference_final <", value, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("salary_difference_final <=", value, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalIn(List<BigDecimal> values) {
            addCriterion("salary_difference_final in", values, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalNotIn(List<BigDecimal> values) {
            addCriterion("salary_difference_final not in", values, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_difference_final between", value1, value2, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andSalaryDifferenceFinalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("salary_difference_final not between", value1, value2, "salaryDifferenceFinal");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkIsNull() {
            addCriterion("after_net_pay_remark is null");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkIsNotNull() {
            addCriterion("after_net_pay_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkEqualTo(String value) {
            addCriterion("after_net_pay_remark =", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkNotEqualTo(String value) {
            addCriterion("after_net_pay_remark <>", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkGreaterThan(String value) {
            addCriterion("after_net_pay_remark >", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("after_net_pay_remark >=", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkLessThan(String value) {
            addCriterion("after_net_pay_remark <", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkLessThanOrEqualTo(String value) {
            addCriterion("after_net_pay_remark <=", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkLike(String value) {
            addCriterion("after_net_pay_remark like", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkNotLike(String value) {
            addCriterion("after_net_pay_remark not like", value, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkIn(List<String> values) {
            addCriterion("after_net_pay_remark in", values, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkNotIn(List<String> values) {
            addCriterion("after_net_pay_remark not in", values, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkBetween(String value1, String value2) {
            addCriterion("after_net_pay_remark between", value1, value2, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andAfterNetPayRemarkNotBetween(String value1, String value2) {
            addCriterion("after_net_pay_remark not between", value1, value2, "afterNetPayRemark");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersIsNull() {
            addCriterion("other_tax_matters is null");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersIsNotNull() {
            addCriterion("other_tax_matters is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersEqualTo(BigDecimal value) {
            addCriterion("other_tax_matters =", value, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersNotEqualTo(BigDecimal value) {
            addCriterion("other_tax_matters <>", value, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersGreaterThan(BigDecimal value) {
            addCriterion("other_tax_matters >", value, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_tax_matters >=", value, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersLessThan(BigDecimal value) {
            addCriterion("other_tax_matters <", value, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_tax_matters <=", value, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersIn(List<BigDecimal> values) {
            addCriterion("other_tax_matters in", values, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersNotIn(List<BigDecimal> values) {
            addCriterion("other_tax_matters not in", values, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_tax_matters between", value1, value2, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andOtherTaxMattersNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_tax_matters not between", value1, value2, "otherTaxMatters");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeIsNull() {
            addCriterion("total_taxable_income is null");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeIsNotNull() {
            addCriterion("total_taxable_income is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeEqualTo(BigDecimal value) {
            addCriterion("total_taxable_income =", value, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeNotEqualTo(BigDecimal value) {
            addCriterion("total_taxable_income <>", value, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeGreaterThan(BigDecimal value) {
            addCriterion("total_taxable_income >", value, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_taxable_income >=", value, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeLessThan(BigDecimal value) {
            addCriterion("total_taxable_income <", value, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_taxable_income <=", value, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeIn(List<BigDecimal> values) {
            addCriterion("total_taxable_income in", values, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeNotIn(List<BigDecimal> values) {
            addCriterion("total_taxable_income not in", values, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_taxable_income between", value1, value2, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andTotalTaxableIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_taxable_income not between", value1, value2, "totalTaxableIncome");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxIsNull() {
            addCriterion("income_tax is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxIsNotNull() {
            addCriterion("income_tax is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxEqualTo(BigDecimal value) {
            addCriterion("income_tax =", value, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxNotEqualTo(BigDecimal value) {
            addCriterion("income_tax <>", value, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxGreaterThan(BigDecimal value) {
            addCriterion("income_tax >", value, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income_tax >=", value, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxLessThan(BigDecimal value) {
            addCriterion("income_tax <", value, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income_tax <=", value, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxIn(List<BigDecimal> values) {
            addCriterion("income_tax in", values, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxNotIn(List<BigDecimal> values) {
            addCriterion("income_tax not in", values, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_tax between", value1, value2, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andIncomeTaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income_tax not between", value1, value2, "incomeTax");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountIsNull() {
            addCriterion("unnamed_staff_count is null");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountIsNotNull() {
            addCriterion("unnamed_staff_count is not null");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountEqualTo(Integer value) {
            addCriterion("unnamed_staff_count =", value, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountNotEqualTo(Integer value) {
            addCriterion("unnamed_staff_count <>", value, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountGreaterThan(Integer value) {
            addCriterion("unnamed_staff_count >", value, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("unnamed_staff_count >=", value, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountLessThan(Integer value) {
            addCriterion("unnamed_staff_count <", value, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountLessThanOrEqualTo(Integer value) {
            addCriterion("unnamed_staff_count <=", value, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountIn(List<Integer> values) {
            addCriterion("unnamed_staff_count in", values, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountNotIn(List<Integer> values) {
            addCriterion("unnamed_staff_count not in", values, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountBetween(Integer value1, Integer value2) {
            addCriterion("unnamed_staff_count between", value1, value2, "unnamedStaffCount");
            return (Criteria) this;
        }

        public Criteria andUnnamedStaffCountNotBetween(Integer value1, Integer value2) {
            addCriterion("unnamed_staff_count not between", value1, value2, "unnamedStaffCount");
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