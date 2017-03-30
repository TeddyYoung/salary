package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StationTargetQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public StationTargetQuery() {
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

        public Criteria andStationStaffNumIsNull() {
            addCriterion("station_staff_num is null");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumIsNotNull() {
            addCriterion("station_staff_num is not null");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumEqualTo(Integer value) {
            addCriterion("station_staff_num =", value, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumNotEqualTo(Integer value) {
            addCriterion("station_staff_num <>", value, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumGreaterThan(Integer value) {
            addCriterion("station_staff_num >", value, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_staff_num >=", value, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumLessThan(Integer value) {
            addCriterion("station_staff_num <", value, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumLessThanOrEqualTo(Integer value) {
            addCriterion("station_staff_num <=", value, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumIn(List<Integer> values) {
            addCriterion("station_staff_num in", values, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumNotIn(List<Integer> values) {
            addCriterion("station_staff_num not in", values, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumBetween(Integer value1, Integer value2) {
            addCriterion("station_staff_num between", value1, value2, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumNotBetween(Integer value1, Integer value2) {
            addCriterion("station_staff_num not between", value1, value2, "stationStaffNum");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatIsNull() {
            addCriterion("station_staff_num_float is null");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatIsNotNull() {
            addCriterion("station_staff_num_float is not null");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatEqualTo(Integer value) {
            addCriterion("station_staff_num_float =", value, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatNotEqualTo(Integer value) {
            addCriterion("station_staff_num_float <>", value, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatGreaterThan(Integer value) {
            addCriterion("station_staff_num_float >", value, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_staff_num_float >=", value, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatLessThan(Integer value) {
            addCriterion("station_staff_num_float <", value, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatLessThanOrEqualTo(Integer value) {
            addCriterion("station_staff_num_float <=", value, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatIn(List<Integer> values) {
            addCriterion("station_staff_num_float in", values, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatNotIn(List<Integer> values) {
            addCriterion("station_staff_num_float not in", values, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatBetween(Integer value1, Integer value2) {
            addCriterion("station_staff_num_float between", value1, value2, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumFloatNotBetween(Integer value1, Integer value2) {
            addCriterion("station_staff_num_float not between", value1, value2, "stationStaffNumFloat");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeIsNull() {
            addCriterion("station_level_code is null");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeIsNotNull() {
            addCriterion("station_level_code is not null");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeEqualTo(String value) {
            addCriterion("station_level_code =", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeNotEqualTo(String value) {
            addCriterion("station_level_code <>", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeGreaterThan(String value) {
            addCriterion("station_level_code >", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("station_level_code >=", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeLessThan(String value) {
            addCriterion("station_level_code <", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeLessThanOrEqualTo(String value) {
            addCriterion("station_level_code <=", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeLike(String value) {
            addCriterion("station_level_code like", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeNotLike(String value) {
            addCriterion("station_level_code not like", value, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeIn(List<String> values) {
            addCriterion("station_level_code in", values, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeNotIn(List<String> values) {
            addCriterion("station_level_code not in", values, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeBetween(String value1, String value2) {
            addCriterion("station_level_code between", value1, value2, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andStationLevelCodeNotBetween(String value1, String value2) {
            addCriterion("station_level_code not between", value1, value2, "stationLevelCode");
            return (Criteria) this;
        }

        public Criteria andMmpIsNull() {
            addCriterion("mmp is null");
            return (Criteria) this;
        }

        public Criteria andMmpIsNotNull() {
            addCriterion("mmp is not null");
            return (Criteria) this;
        }

        public Criteria andMmpEqualTo(Double value) {
            addCriterion("mmp =", value, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpNotEqualTo(Double value) {
            addCriterion("mmp <>", value, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpGreaterThan(Double value) {
            addCriterion("mmp >", value, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpGreaterThanOrEqualTo(Double value) {
            addCriterion("mmp >=", value, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpLessThan(Double value) {
            addCriterion("mmp <", value, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpLessThanOrEqualTo(Double value) {
            addCriterion("mmp <=", value, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpIn(List<Double> values) {
            addCriterion("mmp in", values, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpNotIn(List<Double> values) {
            addCriterion("mmp not in", values, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpBetween(Double value1, Double value2) {
            addCriterion("mmp between", value1, value2, "mmp");
            return (Criteria) this;
        }

        public Criteria andMmpNotBetween(Double value1, Double value2) {
            addCriterion("mmp not between", value1, value2, "mmp");
            return (Criteria) this;
        }

        public Criteria andNpsIsNull() {
            addCriterion("nps is null");
            return (Criteria) this;
        }

        public Criteria andNpsIsNotNull() {
            addCriterion("nps is not null");
            return (Criteria) this;
        }

        public Criteria andNpsEqualTo(Double value) {
            addCriterion("nps =", value, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsNotEqualTo(Double value) {
            addCriterion("nps <>", value, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsGreaterThan(Double value) {
            addCriterion("nps >", value, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsGreaterThanOrEqualTo(Double value) {
            addCriterion("nps >=", value, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsLessThan(Double value) {
            addCriterion("nps <", value, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsLessThanOrEqualTo(Double value) {
            addCriterion("nps <=", value, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsIn(List<Double> values) {
            addCriterion("nps in", values, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsNotIn(List<Double> values) {
            addCriterion("nps not in", values, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsBetween(Double value1, Double value2) {
            addCriterion("nps between", value1, value2, "nps");
            return (Criteria) this;
        }

        public Criteria andNpsNotBetween(Double value1, Double value2) {
            addCriterion("nps not between", value1, value2, "nps");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeIsNull() {
            addCriterion("oil_target_volume is null");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeIsNotNull() {
            addCriterion("oil_target_volume is not null");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeEqualTo(BigDecimal value) {
            addCriterion("oil_target_volume =", value, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeNotEqualTo(BigDecimal value) {
            addCriterion("oil_target_volume <>", value, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeGreaterThan(BigDecimal value) {
            addCriterion("oil_target_volume >", value, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_target_volume >=", value, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeLessThan(BigDecimal value) {
            addCriterion("oil_target_volume <", value, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_target_volume <=", value, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeIn(List<BigDecimal> values) {
            addCriterion("oil_target_volume in", values, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeNotIn(List<BigDecimal> values) {
            addCriterion("oil_target_volume not in", values, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_target_volume between", value1, value2, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilTargetVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_target_volume not between", value1, value2, "oilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeIsNull() {
            addCriterion("oil_real_volume is null");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeIsNotNull() {
            addCriterion("oil_real_volume is not null");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeEqualTo(BigDecimal value) {
            addCriterion("oil_real_volume =", value, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeNotEqualTo(BigDecimal value) {
            addCriterion("oil_real_volume <>", value, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeGreaterThan(BigDecimal value) {
            addCriterion("oil_real_volume >", value, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_real_volume >=", value, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeLessThan(BigDecimal value) {
            addCriterion("oil_real_volume <", value, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_real_volume <=", value, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeIn(List<BigDecimal> values) {
            addCriterion("oil_real_volume in", values, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeNotIn(List<BigDecimal> values) {
            addCriterion("oil_real_volume not in", values, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_real_volume between", value1, value2, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilRealVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_real_volume not between", value1, value2, "oilRealVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeIsNull() {
            addCriterion("oil_day_average_volume is null");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeIsNotNull() {
            addCriterion("oil_day_average_volume is not null");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeEqualTo(BigDecimal value) {
            addCriterion("oil_day_average_volume =", value, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeNotEqualTo(BigDecimal value) {
            addCriterion("oil_day_average_volume <>", value, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeGreaterThan(BigDecimal value) {
            addCriterion("oil_day_average_volume >", value, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_day_average_volume >=", value, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeLessThan(BigDecimal value) {
            addCriterion("oil_day_average_volume <", value, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_day_average_volume <=", value, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeIn(List<BigDecimal> values) {
            addCriterion("oil_day_average_volume in", values, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeNotIn(List<BigDecimal> values) {
            addCriterion("oil_day_average_volume not in", values, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_day_average_volume between", value1, value2, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andOilDayAverageVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_day_average_volume not between", value1, value2, "oilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeIsNull() {
            addCriterion("non_oil_target_volume is null");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeIsNotNull() {
            addCriterion("non_oil_target_volume is not null");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeEqualTo(BigDecimal value) {
            addCriterion("non_oil_target_volume =", value, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeNotEqualTo(BigDecimal value) {
            addCriterion("non_oil_target_volume <>", value, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeGreaterThan(BigDecimal value) {
            addCriterion("non_oil_target_volume >", value, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_target_volume >=", value, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeLessThan(BigDecimal value) {
            addCriterion("non_oil_target_volume <", value, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_target_volume <=", value, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeIn(List<BigDecimal> values) {
            addCriterion("non_oil_target_volume in", values, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeNotIn(List<BigDecimal> values) {
            addCriterion("non_oil_target_volume not in", values, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_target_volume between", value1, value2, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilTargetVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_target_volume not between", value1, value2, "nonOilTargetVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeIsNull() {
            addCriterion("non_oil_real_volume is null");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeIsNotNull() {
            addCriterion("non_oil_real_volume is not null");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeEqualTo(BigDecimal value) {
            addCriterion("non_oil_real_volume =", value, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeNotEqualTo(BigDecimal value) {
            addCriterion("non_oil_real_volume <>", value, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeGreaterThan(BigDecimal value) {
            addCriterion("non_oil_real_volume >", value, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_real_volume >=", value, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeLessThan(BigDecimal value) {
            addCriterion("non_oil_real_volume <", value, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_real_volume <=", value, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeIn(List<BigDecimal> values) {
            addCriterion("non_oil_real_volume in", values, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeNotIn(List<BigDecimal> values) {
            addCriterion("non_oil_real_volume not in", values, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_real_volume between", value1, value2, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilRealVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_real_volume not between", value1, value2, "nonOilRealVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeIsNull() {
            addCriterion("non_oil_day_average_volume is null");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeIsNotNull() {
            addCriterion("non_oil_day_average_volume is not null");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeEqualTo(BigDecimal value) {
            addCriterion("non_oil_day_average_volume =", value, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeNotEqualTo(BigDecimal value) {
            addCriterion("non_oil_day_average_volume <>", value, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeGreaterThan(BigDecimal value) {
            addCriterion("non_oil_day_average_volume >", value, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_day_average_volume >=", value, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeLessThan(BigDecimal value) {
            addCriterion("non_oil_day_average_volume <", value, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_day_average_volume <=", value, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeIn(List<BigDecimal> values) {
            addCriterion("non_oil_day_average_volume in", values, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeNotIn(List<BigDecimal> values) {
            addCriterion("non_oil_day_average_volume not in", values, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_day_average_volume between", value1, value2, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andNonOilDayAverageVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_day_average_volume not between", value1, value2, "nonOilDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreIsNull() {
            addCriterion("store_mark_score is null");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreIsNotNull() {
            addCriterion("store_mark_score is not null");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreEqualTo(BigDecimal value) {
            addCriterion("store_mark_score =", value, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreNotEqualTo(BigDecimal value) {
            addCriterion("store_mark_score <>", value, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreGreaterThan(BigDecimal value) {
            addCriterion("store_mark_score >", value, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("store_mark_score >=", value, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreLessThan(BigDecimal value) {
            addCriterion("store_mark_score <", value, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("store_mark_score <=", value, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreIn(List<BigDecimal> values) {
            addCriterion("store_mark_score in", values, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreNotIn(List<BigDecimal> values) {
            addCriterion("store_mark_score not in", values, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_mark_score between", value1, value2, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreMarkScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_mark_score not between", value1, value2, "storeMarkScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreIsNull() {
            addCriterion("store_manage_score is null");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreIsNotNull() {
            addCriterion("store_manage_score is not null");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreEqualTo(BigDecimal value) {
            addCriterion("store_manage_score =", value, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreNotEqualTo(BigDecimal value) {
            addCriterion("store_manage_score <>", value, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreGreaterThan(BigDecimal value) {
            addCriterion("store_manage_score >", value, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("store_manage_score >=", value, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreLessThan(BigDecimal value) {
            addCriterion("store_manage_score <", value, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("store_manage_score <=", value, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreIn(List<BigDecimal> values) {
            addCriterion("store_manage_score in", values, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreNotIn(List<BigDecimal> values) {
            addCriterion("store_manage_score not in", values, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_manage_score between", value1, value2, "storeManageScore");
            return (Criteria) this;
        }

        public Criteria andStoreManageScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_manage_score not between", value1, value2, "storeManageScore");
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

        public Criteria andGasolineTargetVolumeIsNull() {
            addCriterion("gasoline_target_volume is null");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeIsNotNull() {
            addCriterion("gasoline_target_volume is not null");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeEqualTo(BigDecimal value) {
            addCriterion("gasoline_target_volume =", value, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeNotEqualTo(BigDecimal value) {
            addCriterion("gasoline_target_volume <>", value, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeGreaterThan(BigDecimal value) {
            addCriterion("gasoline_target_volume >", value, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gasoline_target_volume >=", value, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeLessThan(BigDecimal value) {
            addCriterion("gasoline_target_volume <", value, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gasoline_target_volume <=", value, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeIn(List<BigDecimal> values) {
            addCriterion("gasoline_target_volume in", values, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeNotIn(List<BigDecimal> values) {
            addCriterion("gasoline_target_volume not in", values, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gasoline_target_volume between", value1, value2, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineTargetVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gasoline_target_volume not between", value1, value2, "gasolineTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeIsNull() {
            addCriterion("diesel_target_volume is null");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeIsNotNull() {
            addCriterion("diesel_target_volume is not null");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeEqualTo(BigDecimal value) {
            addCriterion("diesel_target_volume =", value, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeNotEqualTo(BigDecimal value) {
            addCriterion("diesel_target_volume <>", value, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeGreaterThan(BigDecimal value) {
            addCriterion("diesel_target_volume >", value, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("diesel_target_volume >=", value, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeLessThan(BigDecimal value) {
            addCriterion("diesel_target_volume <", value, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("diesel_target_volume <=", value, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeIn(List<BigDecimal> values) {
            addCriterion("diesel_target_volume in", values, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeNotIn(List<BigDecimal> values) {
            addCriterion("diesel_target_volume not in", values, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("diesel_target_volume between", value1, value2, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andDieselTargetVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("diesel_target_volume not between", value1, value2, "dieselTargetVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeIsNull() {
            addCriterion("gasoline_day_average_volume is null");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeIsNotNull() {
            addCriterion("gasoline_day_average_volume is not null");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeEqualTo(BigDecimal value) {
            addCriterion("gasoline_day_average_volume =", value, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeNotEqualTo(BigDecimal value) {
            addCriterion("gasoline_day_average_volume <>", value, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeGreaterThan(BigDecimal value) {
            addCriterion("gasoline_day_average_volume >", value, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gasoline_day_average_volume >=", value, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeLessThan(BigDecimal value) {
            addCriterion("gasoline_day_average_volume <", value, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gasoline_day_average_volume <=", value, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeIn(List<BigDecimal> values) {
            addCriterion("gasoline_day_average_volume in", values, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeNotIn(List<BigDecimal> values) {
            addCriterion("gasoline_day_average_volume not in", values, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gasoline_day_average_volume between", value1, value2, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andGasolineDayAverageVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gasoline_day_average_volume not between", value1, value2, "gasolineDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeIsNull() {
            addCriterion("diesel_day_average_volume is null");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeIsNotNull() {
            addCriterion("diesel_day_average_volume is not null");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeEqualTo(BigDecimal value) {
            addCriterion("diesel_day_average_volume =", value, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeNotEqualTo(BigDecimal value) {
            addCriterion("diesel_day_average_volume <>", value, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeGreaterThan(BigDecimal value) {
            addCriterion("diesel_day_average_volume >", value, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("diesel_day_average_volume >=", value, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeLessThan(BigDecimal value) {
            addCriterion("diesel_day_average_volume <", value, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("diesel_day_average_volume <=", value, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeIn(List<BigDecimal> values) {
            addCriterion("diesel_day_average_volume in", values, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeNotIn(List<BigDecimal> values) {
            addCriterion("diesel_day_average_volume not in", values, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("diesel_day_average_volume between", value1, value2, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andDieselDayAverageVolumeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("diesel_day_average_volume not between", value1, value2, "dieselDayAverageVolume");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryIsNull() {
            addCriterion("is_keep_dormitory is null");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryIsNotNull() {
            addCriterion("is_keep_dormitory is not null");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryEqualTo(String value) {
            addCriterion("is_keep_dormitory =", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryNotEqualTo(String value) {
            addCriterion("is_keep_dormitory <>", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryGreaterThan(String value) {
            addCriterion("is_keep_dormitory >", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryGreaterThanOrEqualTo(String value) {
            addCriterion("is_keep_dormitory >=", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryLessThan(String value) {
            addCriterion("is_keep_dormitory <", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryLessThanOrEqualTo(String value) {
            addCriterion("is_keep_dormitory <=", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryLike(String value) {
            addCriterion("is_keep_dormitory like", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryNotLike(String value) {
            addCriterion("is_keep_dormitory not like", value, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryIn(List<String> values) {
            addCriterion("is_keep_dormitory in", values, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryNotIn(List<String> values) {
            addCriterion("is_keep_dormitory not in", values, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryBetween(String value1, String value2) {
            addCriterion("is_keep_dormitory between", value1, value2, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andIsKeepDormitoryNotBetween(String value1, String value2) {
            addCriterion("is_keep_dormitory not between", value1, value2, "isKeepDormitory");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesIsNull() {
            addCriterion("dormitory_subsidies is null");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesIsNotNull() {
            addCriterion("dormitory_subsidies is not null");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesEqualTo(BigDecimal value) {
            addCriterion("dormitory_subsidies =", value, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesNotEqualTo(BigDecimal value) {
            addCriterion("dormitory_subsidies <>", value, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesGreaterThan(BigDecimal value) {
            addCriterion("dormitory_subsidies >", value, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dormitory_subsidies >=", value, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesLessThan(BigDecimal value) {
            addCriterion("dormitory_subsidies <", value, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dormitory_subsidies <=", value, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesIn(List<BigDecimal> values) {
            addCriterion("dormitory_subsidies in", values, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesNotIn(List<BigDecimal> values) {
            addCriterion("dormitory_subsidies not in", values, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dormitory_subsidies between", value1, value2, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andDormitorySubsidiesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dormitory_subsidies not between", value1, value2, "dormitorySubsidies");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceIsNull() {
            addCriterion("monthly_store_allowance is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceIsNotNull() {
            addCriterion("monthly_store_allowance is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceEqualTo(BigDecimal value) {
            addCriterion("monthly_store_allowance =", value, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceNotEqualTo(BigDecimal value) {
            addCriterion("monthly_store_allowance <>", value, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceGreaterThan(BigDecimal value) {
            addCriterion("monthly_store_allowance >", value, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_store_allowance >=", value, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceLessThan(BigDecimal value) {
            addCriterion("monthly_store_allowance <", value, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_store_allowance <=", value, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceIn(List<BigDecimal> values) {
            addCriterion("monthly_store_allowance in", values, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceNotIn(List<BigDecimal> values) {
            addCriterion("monthly_store_allowance not in", values, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_store_allowance between", value1, value2, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andMonthlyStoreAllowanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_store_allowance not between", value1, value2, "monthlyStoreAllowance");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateIsNull() {
            addCriterion("oil_standard_rate is null");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateIsNotNull() {
            addCriterion("oil_standard_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateEqualTo(BigDecimal value) {
            addCriterion("oil_standard_rate =", value, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateNotEqualTo(BigDecimal value) {
            addCriterion("oil_standard_rate <>", value, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateGreaterThan(BigDecimal value) {
            addCriterion("oil_standard_rate >", value, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_standard_rate >=", value, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateLessThan(BigDecimal value) {
            addCriterion("oil_standard_rate <", value, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oil_standard_rate <=", value, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateIn(List<BigDecimal> values) {
            addCriterion("oil_standard_rate in", values, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateNotIn(List<BigDecimal> values) {
            addCriterion("oil_standard_rate not in", values, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_standard_rate between", value1, value2, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andOilStandardRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oil_standard_rate not between", value1, value2, "oilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateIsNull() {
            addCriterion("non_oil_standard_rate is null");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateIsNotNull() {
            addCriterion("non_oil_standard_rate is not null");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateEqualTo(BigDecimal value) {
            addCriterion("non_oil_standard_rate =", value, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateNotEqualTo(BigDecimal value) {
            addCriterion("non_oil_standard_rate <>", value, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateGreaterThan(BigDecimal value) {
            addCriterion("non_oil_standard_rate >", value, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_standard_rate >=", value, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateLessThan(BigDecimal value) {
            addCriterion("non_oil_standard_rate <", value, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("non_oil_standard_rate <=", value, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateIn(List<BigDecimal> values) {
            addCriterion("non_oil_standard_rate in", values, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateNotIn(List<BigDecimal> values) {
            addCriterion("non_oil_standard_rate not in", values, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_standard_rate between", value1, value2, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andNonOilStandardRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("non_oil_standard_rate not between", value1, value2, "nonOilStandardRate");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusIsNull() {
            addCriterion("direct_selling_bonus is null");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusIsNotNull() {
            addCriterion("direct_selling_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusEqualTo(BigDecimal value) {
            addCriterion("direct_selling_bonus =", value, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusNotEqualTo(BigDecimal value) {
            addCriterion("direct_selling_bonus <>", value, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusGreaterThan(BigDecimal value) {
            addCriterion("direct_selling_bonus >", value, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("direct_selling_bonus >=", value, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusLessThan(BigDecimal value) {
            addCriterion("direct_selling_bonus <", value, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("direct_selling_bonus <=", value, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusIn(List<BigDecimal> values) {
            addCriterion("direct_selling_bonus in", values, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusNotIn(List<BigDecimal> values) {
            addCriterion("direct_selling_bonus not in", values, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("direct_selling_bonus between", value1, value2, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andDirectSellingBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("direct_selling_bonus not between", value1, value2, "directSellingBonus");
            return (Criteria) this;
        }

        public Criteria andUpperLimitIsNull() {
            addCriterion("upper_limit is null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitIsNotNull() {
            addCriterion("upper_limit is not null");
            return (Criteria) this;
        }

        public Criteria andUpperLimitEqualTo(BigDecimal value) {
            addCriterion("upper_limit =", value, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitNotEqualTo(BigDecimal value) {
            addCriterion("upper_limit <>", value, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitGreaterThan(BigDecimal value) {
            addCriterion("upper_limit >", value, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("upper_limit >=", value, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitLessThan(BigDecimal value) {
            addCriterion("upper_limit <", value, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("upper_limit <=", value, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitIn(List<BigDecimal> values) {
            addCriterion("upper_limit in", values, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitNotIn(List<BigDecimal> values) {
            addCriterion("upper_limit not in", values, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("upper_limit between", value1, value2, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andUpperLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("upper_limit not between", value1, value2, "upperLimit");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientIsNull() {
            addCriterion("mmp_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientIsNotNull() {
            addCriterion("mmp_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientEqualTo(BigDecimal value) {
            addCriterion("mmp_coefficient =", value, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("mmp_coefficient <>", value, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientGreaterThan(BigDecimal value) {
            addCriterion("mmp_coefficient >", value, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mmp_coefficient >=", value, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientLessThan(BigDecimal value) {
            addCriterion("mmp_coefficient <", value, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mmp_coefficient <=", value, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientIn(List<BigDecimal> values) {
            addCriterion("mmp_coefficient in", values, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("mmp_coefficient not in", values, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mmp_coefficient between", value1, value2, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andMmpCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mmp_coefficient not between", value1, value2, "mmpCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientIsNull() {
            addCriterion("nps_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientIsNotNull() {
            addCriterion("nps_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientEqualTo(BigDecimal value) {
            addCriterion("nps_coefficient =", value, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("nps_coefficient <>", value, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientGreaterThan(BigDecimal value) {
            addCriterion("nps_coefficient >", value, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("nps_coefficient >=", value, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientLessThan(BigDecimal value) {
            addCriterion("nps_coefficient <", value, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("nps_coefficient <=", value, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientIn(List<BigDecimal> values) {
            addCriterion("nps_coefficient in", values, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("nps_coefficient not in", values, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nps_coefficient between", value1, value2, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andNpsCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("nps_coefficient not between", value1, value2, "npsCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientIsNull() {
            addCriterion("weighting_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientIsNotNull() {
            addCriterion("weighting_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientEqualTo(BigDecimal value) {
            addCriterion("weighting_coefficient =", value, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientNotEqualTo(BigDecimal value) {
            addCriterion("weighting_coefficient <>", value, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientGreaterThan(BigDecimal value) {
            addCriterion("weighting_coefficient >", value, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weighting_coefficient >=", value, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientLessThan(BigDecimal value) {
            addCriterion("weighting_coefficient <", value, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weighting_coefficient <=", value, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientIn(List<BigDecimal> values) {
            addCriterion("weighting_coefficient in", values, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientNotIn(List<BigDecimal> values) {
            addCriterion("weighting_coefficient not in", values, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weighting_coefficient between", value1, value2, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andWeightingCoefficientNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weighting_coefficient not between", value1, value2, "weightingCoefficient");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusIsNull() {
            addCriterion("monthly_manager_bonus is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusIsNotNull() {
            addCriterion("monthly_manager_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_bonus =", value, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusNotEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_bonus <>", value, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusGreaterThan(BigDecimal value) {
            addCriterion("monthly_manager_bonus >", value, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_bonus >=", value, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusLessThan(BigDecimal value) {
            addCriterion("monthly_manager_bonus <", value, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_bonus <=", value, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusIn(List<BigDecimal> values) {
            addCriterion("monthly_manager_bonus in", values, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusNotIn(List<BigDecimal> values) {
            addCriterion("monthly_manager_bonus not in", values, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_manager_bonus between", value1, value2, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_manager_bonus not between", value1, value2, "monthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusIsNull() {
            addCriterion("monthly_manager_oil_standard_bonus is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusIsNotNull() {
            addCriterion("monthly_manager_oil_standard_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_oil_standard_bonus =", value, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusNotEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_oil_standard_bonus <>", value, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusGreaterThan(BigDecimal value) {
            addCriterion("monthly_manager_oil_standard_bonus >", value, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_oil_standard_bonus >=", value, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusLessThan(BigDecimal value) {
            addCriterion("monthly_manager_oil_standard_bonus <", value, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_oil_standard_bonus <=", value, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusIn(List<BigDecimal> values) {
            addCriterion("monthly_manager_oil_standard_bonus in", values, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusNotIn(List<BigDecimal> values) {
            addCriterion("monthly_manager_oil_standard_bonus not in", values, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_manager_oil_standard_bonus between", value1, value2, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerOilStandardBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_manager_oil_standard_bonus not between", value1, value2, "monthlyManagerOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusIsNull() {
            addCriterion("monthly_manager_non_oil_standard_bonus is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusIsNotNull() {
            addCriterion("monthly_manager_non_oil_standard_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_non_oil_standard_bonus =", value, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusNotEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_non_oil_standard_bonus <>", value, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusGreaterThan(BigDecimal value) {
            addCriterion("monthly_manager_non_oil_standard_bonus >", value, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_non_oil_standard_bonus >=", value, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusLessThan(BigDecimal value) {
            addCriterion("monthly_manager_non_oil_standard_bonus <", value, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_manager_non_oil_standard_bonus <=", value, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusIn(List<BigDecimal> values) {
            addCriterion("monthly_manager_non_oil_standard_bonus in", values, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusNotIn(List<BigDecimal> values) {
            addCriterion("monthly_manager_non_oil_standard_bonus not in", values, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_manager_non_oil_standard_bonus between", value1, value2, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyManagerNonOilStandardBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_manager_non_oil_standard_bonus not between", value1, value2, "monthlyManagerNonOilStandardBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusIsNull() {
            addCriterion("total_monthly_manager_bonus is null");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusIsNotNull() {
            addCriterion("total_monthly_manager_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusEqualTo(BigDecimal value) {
            addCriterion("total_monthly_manager_bonus =", value, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusNotEqualTo(BigDecimal value) {
            addCriterion("total_monthly_manager_bonus <>", value, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusGreaterThan(BigDecimal value) {
            addCriterion("total_monthly_manager_bonus >", value, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_monthly_manager_bonus >=", value, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusLessThan(BigDecimal value) {
            addCriterion("total_monthly_manager_bonus <", value, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_monthly_manager_bonus <=", value, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusIn(List<BigDecimal> values) {
            addCriterion("total_monthly_manager_bonus in", values, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusNotIn(List<BigDecimal> values) {
            addCriterion("total_monthly_manager_bonus not in", values, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_monthly_manager_bonus between", value1, value2, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andTotalMonthlyManagerBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_monthly_manager_bonus not between", value1, value2, "totalMonthlyManagerBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusIsNull() {
            addCriterion("monthly_sale_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusIsNotNull() {
            addCriterion("monthly_sale_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusEqualTo(BigDecimal value) {
            addCriterion("monthly_sale_oil_bonus =", value, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("monthly_sale_oil_bonus <>", value, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusGreaterThan(BigDecimal value) {
            addCriterion("monthly_sale_oil_bonus >", value, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_sale_oil_bonus >=", value, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusLessThan(BigDecimal value) {
            addCriterion("monthly_sale_oil_bonus <", value, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_sale_oil_bonus <=", value, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusIn(List<BigDecimal> values) {
            addCriterion("monthly_sale_oil_bonus in", values, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("monthly_sale_oil_bonus not in", values, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_sale_oil_bonus between", value1, value2, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlySaleOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_sale_oil_bonus not between", value1, value2, "monthlySaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusIsNull() {
            addCriterion("monthly_non_sale_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusIsNotNull() {
            addCriterion("monthly_non_sale_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusEqualTo(BigDecimal value) {
            addCriterion("monthly_non_sale_oil_bonus =", value, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("monthly_non_sale_oil_bonus <>", value, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusGreaterThan(BigDecimal value) {
            addCriterion("monthly_non_sale_oil_bonus >", value, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_non_sale_oil_bonus >=", value, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusLessThan(BigDecimal value) {
            addCriterion("monthly_non_sale_oil_bonus <", value, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("monthly_non_sale_oil_bonus <=", value, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusIn(List<BigDecimal> values) {
            addCriterion("monthly_non_sale_oil_bonus in", values, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("monthly_non_sale_oil_bonus not in", values, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_non_sale_oil_bonus between", value1, value2, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andMonthlyNonSaleOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("monthly_non_sale_oil_bonus not between", value1, value2, "monthlyNonSaleOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusIsNull() {
            addCriterion("current_month_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusIsNotNull() {
            addCriterion("current_month_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusEqualTo(BigDecimal value) {
            addCriterion("current_month_oil_bonus =", value, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("current_month_oil_bonus <>", value, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusGreaterThan(BigDecimal value) {
            addCriterion("current_month_oil_bonus >", value, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_oil_bonus >=", value, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusLessThan(BigDecimal value) {
            addCriterion("current_month_oil_bonus <", value, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_oil_bonus <=", value, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusIn(List<BigDecimal> values) {
            addCriterion("current_month_oil_bonus in", values, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("current_month_oil_bonus not in", values, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_oil_bonus between", value1, value2, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_oil_bonus not between", value1, value2, "currentMonthOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusIsNull() {
            addCriterion("current_month_non_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusIsNotNull() {
            addCriterion("current_month_non_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusEqualTo(BigDecimal value) {
            addCriterion("current_month_non_oil_bonus =", value, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("current_month_non_oil_bonus <>", value, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusGreaterThan(BigDecimal value) {
            addCriterion("current_month_non_oil_bonus >", value, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_non_oil_bonus >=", value, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusLessThan(BigDecimal value) {
            addCriterion("current_month_non_oil_bonus <", value, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_non_oil_bonus <=", value, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusIn(List<BigDecimal> values) {
            addCriterion("current_month_non_oil_bonus in", values, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("current_month_non_oil_bonus not in", values, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_non_oil_bonus between", value1, value2, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthNonOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_non_oil_bonus not between", value1, value2, "currentMonthNonOilBonus");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresIsNull() {
            addCriterion("safeguard_procedures is null");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresIsNotNull() {
            addCriterion("safeguard_procedures is not null");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresEqualTo(BigDecimal value) {
            addCriterion("safeguard_procedures =", value, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresNotEqualTo(BigDecimal value) {
            addCriterion("safeguard_procedures <>", value, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresGreaterThan(BigDecimal value) {
            addCriterion("safeguard_procedures >", value, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("safeguard_procedures >=", value, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresLessThan(BigDecimal value) {
            addCriterion("safeguard_procedures <", value, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresLessThanOrEqualTo(BigDecimal value) {
            addCriterion("safeguard_procedures <=", value, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresIn(List<BigDecimal> values) {
            addCriterion("safeguard_procedures in", values, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresNotIn(List<BigDecimal> values) {
            addCriterion("safeguard_procedures not in", values, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("safeguard_procedures between", value1, value2, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andSafeguardProceduresNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("safeguard_procedures not between", value1, value2, "safeguardProcedures");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusIsNull() {
            addCriterion("current_month_payable_oil_bonus is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusIsNotNull() {
            addCriterion("current_month_payable_oil_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusEqualTo(BigDecimal value) {
            addCriterion("current_month_payable_oil_bonus =", value, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusNotEqualTo(BigDecimal value) {
            addCriterion("current_month_payable_oil_bonus <>", value, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusGreaterThan(BigDecimal value) {
            addCriterion("current_month_payable_oil_bonus >", value, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_payable_oil_bonus >=", value, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusLessThan(BigDecimal value) {
            addCriterion("current_month_payable_oil_bonus <", value, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_payable_oil_bonus <=", value, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusIn(List<BigDecimal> values) {
            addCriterion("current_month_payable_oil_bonus in", values, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusNotIn(List<BigDecimal> values) {
            addCriterion("current_month_payable_oil_bonus not in", values, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_payable_oil_bonus between", value1, value2, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthPayableOilBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_payable_oil_bonus not between", value1, value2, "currentMonthPayableOilBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneIsNull() {
            addCriterion("station_accountant_data_one is null");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneIsNotNull() {
            addCriterion("station_accountant_data_one is not null");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneEqualTo(String value) {
            addCriterion("station_accountant_data_one =", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneNotEqualTo(String value) {
            addCriterion("station_accountant_data_one <>", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneGreaterThan(String value) {
            addCriterion("station_accountant_data_one >", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneGreaterThanOrEqualTo(String value) {
            addCriterion("station_accountant_data_one >=", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneLessThan(String value) {
            addCriterion("station_accountant_data_one <", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneLessThanOrEqualTo(String value) {
            addCriterion("station_accountant_data_one <=", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneLike(String value) {
            addCriterion("station_accountant_data_one like", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneNotLike(String value) {
            addCriterion("station_accountant_data_one not like", value, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneIn(List<String> values) {
            addCriterion("station_accountant_data_one in", values, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneNotIn(List<String> values) {
            addCriterion("station_accountant_data_one not in", values, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneBetween(String value1, String value2) {
            addCriterion("station_accountant_data_one between", value1, value2, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataOneNotBetween(String value1, String value2) {
            addCriterion("station_accountant_data_one not between", value1, value2, "stationAccountantDataOne");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoIsNull() {
            addCriterion("station_accountant_data_two is null");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoIsNotNull() {
            addCriterion("station_accountant_data_two is not null");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoEqualTo(String value) {
            addCriterion("station_accountant_data_two =", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoNotEqualTo(String value) {
            addCriterion("station_accountant_data_two <>", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoGreaterThan(String value) {
            addCriterion("station_accountant_data_two >", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoGreaterThanOrEqualTo(String value) {
            addCriterion("station_accountant_data_two >=", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoLessThan(String value) {
            addCriterion("station_accountant_data_two <", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoLessThanOrEqualTo(String value) {
            addCriterion("station_accountant_data_two <=", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoLike(String value) {
            addCriterion("station_accountant_data_two like", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoNotLike(String value) {
            addCriterion("station_accountant_data_two not like", value, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoIn(List<String> values) {
            addCriterion("station_accountant_data_two in", values, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoNotIn(List<String> values) {
            addCriterion("station_accountant_data_two not in", values, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoBetween(String value1, String value2) {
            addCriterion("station_accountant_data_two between", value1, value2, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantDataTwoNotBetween(String value1, String value2) {
            addCriterion("station_accountant_data_two not between", value1, value2, "stationAccountantDataTwo");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusIsNull() {
            addCriterion("station_accountant_base_bonus is null");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusIsNotNull() {
            addCriterion("station_accountant_base_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusEqualTo(BigDecimal value) {
            addCriterion("station_accountant_base_bonus =", value, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusNotEqualTo(BigDecimal value) {
            addCriterion("station_accountant_base_bonus <>", value, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusGreaterThan(BigDecimal value) {
            addCriterion("station_accountant_base_bonus >", value, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("station_accountant_base_bonus >=", value, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusLessThan(BigDecimal value) {
            addCriterion("station_accountant_base_bonus <", value, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("station_accountant_base_bonus <=", value, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusIn(List<BigDecimal> values) {
            addCriterion("station_accountant_base_bonus in", values, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusNotIn(List<BigDecimal> values) {
            addCriterion("station_accountant_base_bonus not in", values, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("station_accountant_base_bonus between", value1, value2, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andStationAccountantBaseBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("station_accountant_base_bonus not between", value1, value2, "stationAccountantBaseBonus");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeIsNull() {
            addCriterion("accountant_bonus_station_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeIsNotNull() {
            addCriterion("accountant_bonus_station_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeEqualTo(String value) {
            addCriterion("accountant_bonus_station_type =", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeNotEqualTo(String value) {
            addCriterion("accountant_bonus_station_type <>", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeGreaterThan(String value) {
            addCriterion("accountant_bonus_station_type >", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("accountant_bonus_station_type >=", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeLessThan(String value) {
            addCriterion("accountant_bonus_station_type <", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeLessThanOrEqualTo(String value) {
            addCriterion("accountant_bonus_station_type <=", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeLike(String value) {
            addCriterion("accountant_bonus_station_type like", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeNotLike(String value) {
            addCriterion("accountant_bonus_station_type not like", value, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeIn(List<String> values) {
            addCriterion("accountant_bonus_station_type in", values, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeNotIn(List<String> values) {
            addCriterion("accountant_bonus_station_type not in", values, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeBetween(String value1, String value2) {
            addCriterion("accountant_bonus_station_type between", value1, value2, "accountantBonusStationType");
            return (Criteria) this;
        }

        public Criteria andAccountantBonusStationTypeNotBetween(String value1, String value2) {
            addCriterion("accountant_bonus_station_type not between", value1, value2, "accountantBonusStationType");
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

        public Criteria andStationStaffNumAndAdminIsNull() {
            addCriterion("station_staff_num_and_admin is null");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminIsNotNull() {
            addCriterion("station_staff_num_and_admin is not null");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminEqualTo(Integer value) {
            addCriterion("station_staff_num_and_admin =", value, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminNotEqualTo(Integer value) {
            addCriterion("station_staff_num_and_admin <>", value, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminGreaterThan(Integer value) {
            addCriterion("station_staff_num_and_admin >", value, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("station_staff_num_and_admin >=", value, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminLessThan(Integer value) {
            addCriterion("station_staff_num_and_admin <", value, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminLessThanOrEqualTo(Integer value) {
            addCriterion("station_staff_num_and_admin <=", value, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminIn(List<Integer> values) {
            addCriterion("station_staff_num_and_admin in", values, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminNotIn(List<Integer> values) {
            addCriterion("station_staff_num_and_admin not in", values, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminBetween(Integer value1, Integer value2) {
            addCriterion("station_staff_num_and_admin between", value1, value2, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andStationStaffNumAndAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("station_staff_num_and_admin not between", value1, value2, "stationStaffNumAndAdmin");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesIsNull() {
            addCriterion("boarder_subsidies is null");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesIsNotNull() {
            addCriterion("boarder_subsidies is not null");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesEqualTo(BigDecimal value) {
            addCriterion("boarder_subsidies =", value, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesNotEqualTo(BigDecimal value) {
            addCriterion("boarder_subsidies <>", value, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesGreaterThan(BigDecimal value) {
            addCriterion("boarder_subsidies >", value, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("boarder_subsidies >=", value, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesLessThan(BigDecimal value) {
            addCriterion("boarder_subsidies <", value, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesLessThanOrEqualTo(BigDecimal value) {
            addCriterion("boarder_subsidies <=", value, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesIn(List<BigDecimal> values) {
            addCriterion("boarder_subsidies in", values, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesNotIn(List<BigDecimal> values) {
            addCriterion("boarder_subsidies not in", values, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("boarder_subsidies between", value1, value2, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("boarder_subsidies not between", value1, value2, "boarderSubsidies");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationIsNull() {
            addCriterion("managerial_position_population is null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationIsNotNull() {
            addCriterion("managerial_position_population is not null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationEqualTo(Integer value) {
            addCriterion("managerial_position_population =", value, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationNotEqualTo(Integer value) {
            addCriterion("managerial_position_population <>", value, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationGreaterThan(Integer value) {
            addCriterion("managerial_position_population >", value, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerial_position_population >=", value, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationLessThan(Integer value) {
            addCriterion("managerial_position_population <", value, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("managerial_position_population <=", value, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationIn(List<Integer> values) {
            addCriterion("managerial_position_population in", values, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationNotIn(List<Integer> values) {
            addCriterion("managerial_position_population not in", values, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationBetween(Integer value1, Integer value2) {
            addCriterion("managerial_position_population between", value1, value2, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("managerial_position_population not between", value1, value2, "managerialPositionPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationIsNull() {
            addCriterion("managerial_position_real_population is null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationIsNotNull() {
            addCriterion("managerial_position_real_population is not null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationEqualTo(Integer value) {
            addCriterion("managerial_position_real_population =", value, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationNotEqualTo(Integer value) {
            addCriterion("managerial_position_real_population <>", value, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationGreaterThan(Integer value) {
            addCriterion("managerial_position_real_population >", value, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("managerial_position_real_population >=", value, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationLessThan(Integer value) {
            addCriterion("managerial_position_real_population <", value, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("managerial_position_real_population <=", value, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationIn(List<Integer> values) {
            addCriterion("managerial_position_real_population in", values, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationNotIn(List<Integer> values) {
            addCriterion("managerial_position_real_population not in", values, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationBetween(Integer value1, Integer value2) {
            addCriterion("managerial_position_real_population between", value1, value2, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionRealPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("managerial_position_real_population not between", value1, value2, "managerialPositionRealPopulation");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneIsNull() {
            addCriterion("managerial_position_count_base_one is null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneIsNotNull() {
            addCriterion("managerial_position_count_base_one is not null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneEqualTo(String value) {
            addCriterion("managerial_position_count_base_one =", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneNotEqualTo(String value) {
            addCriterion("managerial_position_count_base_one <>", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneGreaterThan(String value) {
            addCriterion("managerial_position_count_base_one >", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneGreaterThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_one >=", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneLessThan(String value) {
            addCriterion("managerial_position_count_base_one <", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneLessThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_one <=", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneLike(String value) {
            addCriterion("managerial_position_count_base_one like", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneNotLike(String value) {
            addCriterion("managerial_position_count_base_one not like", value, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneIn(List<String> values) {
            addCriterion("managerial_position_count_base_one in", values, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneNotIn(List<String> values) {
            addCriterion("managerial_position_count_base_one not in", values, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_one between", value1, value2, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseOneNotBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_one not between", value1, value2, "managerialPositionCountBaseOne");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoIsNull() {
            addCriterion("managerial_position_count_base_two is null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoIsNotNull() {
            addCriterion("managerial_position_count_base_two is not null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoEqualTo(String value) {
            addCriterion("managerial_position_count_base_two =", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoNotEqualTo(String value) {
            addCriterion("managerial_position_count_base_two <>", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoGreaterThan(String value) {
            addCriterion("managerial_position_count_base_two >", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoGreaterThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_two >=", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoLessThan(String value) {
            addCriterion("managerial_position_count_base_two <", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoLessThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_two <=", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoLike(String value) {
            addCriterion("managerial_position_count_base_two like", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoNotLike(String value) {
            addCriterion("managerial_position_count_base_two not like", value, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoIn(List<String> values) {
            addCriterion("managerial_position_count_base_two in", values, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoNotIn(List<String> values) {
            addCriterion("managerial_position_count_base_two not in", values, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_two between", value1, value2, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseTwoNotBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_two not between", value1, value2, "managerialPositionCountBaseTwo");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeIsNull() {
            addCriterion("managerial_position_count_base_three is null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeIsNotNull() {
            addCriterion("managerial_position_count_base_three is not null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeEqualTo(String value) {
            addCriterion("managerial_position_count_base_three =", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeNotEqualTo(String value) {
            addCriterion("managerial_position_count_base_three <>", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeGreaterThan(String value) {
            addCriterion("managerial_position_count_base_three >", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeGreaterThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_three >=", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeLessThan(String value) {
            addCriterion("managerial_position_count_base_three <", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeLessThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_three <=", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeLike(String value) {
            addCriterion("managerial_position_count_base_three like", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeNotLike(String value) {
            addCriterion("managerial_position_count_base_three not like", value, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeIn(List<String> values) {
            addCriterion("managerial_position_count_base_three in", values, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeNotIn(List<String> values) {
            addCriterion("managerial_position_count_base_three not in", values, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_three between", value1, value2, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseThreeNotBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_three not between", value1, value2, "managerialPositionCountBaseThree");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourIsNull() {
            addCriterion("managerial_position_count_base_four is null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourIsNotNull() {
            addCriterion("managerial_position_count_base_four is not null");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourEqualTo(String value) {
            addCriterion("managerial_position_count_base_four =", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourNotEqualTo(String value) {
            addCriterion("managerial_position_count_base_four <>", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourGreaterThan(String value) {
            addCriterion("managerial_position_count_base_four >", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourGreaterThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_four >=", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourLessThan(String value) {
            addCriterion("managerial_position_count_base_four <", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourLessThanOrEqualTo(String value) {
            addCriterion("managerial_position_count_base_four <=", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourLike(String value) {
            addCriterion("managerial_position_count_base_four like", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourNotLike(String value) {
            addCriterion("managerial_position_count_base_four not like", value, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourIn(List<String> values) {
            addCriterion("managerial_position_count_base_four in", values, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourNotIn(List<String> values) {
            addCriterion("managerial_position_count_base_four not in", values, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_four between", value1, value2, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andManagerialPositionCountBaseFourNotBetween(String value1, String value2) {
            addCriterion("managerial_position_count_base_four not between", value1, value2, "managerialPositionCountBaseFour");
            return (Criteria) this;
        }

        public Criteria andBaseTargetIsNull() {
            addCriterion("base_target is null");
            return (Criteria) this;
        }

        public Criteria andBaseTargetIsNotNull() {
            addCriterion("base_target is not null");
            return (Criteria) this;
        }

        public Criteria andBaseTargetEqualTo(BigDecimal value) {
            addCriterion("base_target =", value, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetNotEqualTo(BigDecimal value) {
            addCriterion("base_target <>", value, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetGreaterThan(BigDecimal value) {
            addCriterion("base_target >", value, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_target >=", value, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetLessThan(BigDecimal value) {
            addCriterion("base_target <", value, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_target <=", value, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetIn(List<BigDecimal> values) {
            addCriterion("base_target in", values, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetNotIn(List<BigDecimal> values) {
            addCriterion("base_target not in", values, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_target between", value1, value2, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andBaseTargetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_target not between", value1, value2, "baseTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetIsNull() {
            addCriterion("challenge_target is null");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetIsNotNull() {
            addCriterion("challenge_target is not null");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetEqualTo(BigDecimal value) {
            addCriterion("challenge_target =", value, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetNotEqualTo(BigDecimal value) {
            addCriterion("challenge_target <>", value, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetGreaterThan(BigDecimal value) {
            addCriterion("challenge_target >", value, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("challenge_target >=", value, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetLessThan(BigDecimal value) {
            addCriterion("challenge_target <", value, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetLessThanOrEqualTo(BigDecimal value) {
            addCriterion("challenge_target <=", value, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetIn(List<BigDecimal> values) {
            addCriterion("challenge_target in", values, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetNotIn(List<BigDecimal> values) {
            addCriterion("challenge_target not in", values, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("challenge_target between", value1, value2, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andChallengeTargetNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("challenge_target not between", value1, value2, "challengeTarget");
            return (Criteria) this;
        }

        public Criteria andBaseBonusIsNull() {
            addCriterion("base_bonus is null");
            return (Criteria) this;
        }

        public Criteria andBaseBonusIsNotNull() {
            addCriterion("base_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andBaseBonusEqualTo(BigDecimal value) {
            addCriterion("base_bonus =", value, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusNotEqualTo(BigDecimal value) {
            addCriterion("base_bonus <>", value, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusGreaterThan(BigDecimal value) {
            addCriterion("base_bonus >", value, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("base_bonus >=", value, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusLessThan(BigDecimal value) {
            addCriterion("base_bonus <", value, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("base_bonus <=", value, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusIn(List<BigDecimal> values) {
            addCriterion("base_bonus in", values, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusNotIn(List<BigDecimal> values) {
            addCriterion("base_bonus not in", values, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_bonus between", value1, value2, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andBaseBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("base_bonus not between", value1, value2, "baseBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusIsNull() {
            addCriterion("challenge_bonus is null");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusIsNotNull() {
            addCriterion("challenge_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusEqualTo(BigDecimal value) {
            addCriterion("challenge_bonus =", value, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusNotEqualTo(BigDecimal value) {
            addCriterion("challenge_bonus <>", value, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusGreaterThan(BigDecimal value) {
            addCriterion("challenge_bonus >", value, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("challenge_bonus >=", value, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusLessThan(BigDecimal value) {
            addCriterion("challenge_bonus <", value, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("challenge_bonus <=", value, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusIn(List<BigDecimal> values) {
            addCriterion("challenge_bonus in", values, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusNotIn(List<BigDecimal> values) {
            addCriterion("challenge_bonus not in", values, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("challenge_bonus between", value1, value2, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andChallengeBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("challenge_bonus not between", value1, value2, "challengeBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusIsNull() {
            addCriterion("current_month_bonus is null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusIsNotNull() {
            addCriterion("current_month_bonus is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusEqualTo(BigDecimal value) {
            addCriterion("current_month_bonus =", value, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusNotEqualTo(BigDecimal value) {
            addCriterion("current_month_bonus <>", value, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusGreaterThan(BigDecimal value) {
            addCriterion("current_month_bonus >", value, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_bonus >=", value, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusLessThan(BigDecimal value) {
            addCriterion("current_month_bonus <", value, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_month_bonus <=", value, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusIn(List<BigDecimal> values) {
            addCriterion("current_month_bonus in", values, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusNotIn(List<BigDecimal> values) {
            addCriterion("current_month_bonus not in", values, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_bonus between", value1, value2, "currentMonthBonus");
            return (Criteria) this;
        }

        public Criteria andCurrentMonthBonusNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_month_bonus not between", value1, value2, "currentMonthBonus");
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

        public Criteria andDistrictCodeIsNull() {
            addCriterion("district_code is null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIsNotNull() {
            addCriterion("district_code is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeEqualTo(String value) {
            addCriterion("district_code =", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotEqualTo(String value) {
            addCriterion("district_code <>", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThan(String value) {
            addCriterion("district_code >", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("district_code >=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThan(String value) {
            addCriterion("district_code <", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLessThanOrEqualTo(String value) {
            addCriterion("district_code <=", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeLike(String value) {
            addCriterion("district_code like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotLike(String value) {
            addCriterion("district_code not like", value, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeIn(List<String> values) {
            addCriterion("district_code in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotIn(List<String> values) {
            addCriterion("district_code not in", values, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeBetween(String value1, String value2) {
            addCriterion("district_code between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andDistrictCodeNotBetween(String value1, String value2) {
            addCriterion("district_code not between", value1, value2, "districtCode");
            return (Criteria) this;
        }

        public Criteria andFoodWayIsNull() {
            addCriterion("food_way is null");
            return (Criteria) this;
        }

        public Criteria andFoodWayIsNotNull() {
            addCriterion("food_way is not null");
            return (Criteria) this;
        }

        public Criteria andFoodWayEqualTo(String value) {
            addCriterion("food_way =", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayNotEqualTo(String value) {
            addCriterion("food_way <>", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayGreaterThan(String value) {
            addCriterion("food_way >", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayGreaterThanOrEqualTo(String value) {
            addCriterion("food_way >=", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayLessThan(String value) {
            addCriterion("food_way <", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayLessThanOrEqualTo(String value) {
            addCriterion("food_way <=", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayLike(String value) {
            addCriterion("food_way like", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayNotLike(String value) {
            addCriterion("food_way not like", value, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayIn(List<String> values) {
            addCriterion("food_way in", values, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayNotIn(List<String> values) {
            addCriterion("food_way not in", values, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayBetween(String value1, String value2) {
            addCriterion("food_way between", value1, value2, "foodWay");
            return (Criteria) this;
        }

        public Criteria andFoodWayNotBetween(String value1, String value2) {
            addCriterion("food_way not between", value1, value2, "foodWay");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkIsNull() {
            addCriterion("boarder_subsidies_remark is null");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkIsNotNull() {
            addCriterion("boarder_subsidies_remark is not null");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkEqualTo(String value) {
            addCriterion("boarder_subsidies_remark =", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkNotEqualTo(String value) {
            addCriterion("boarder_subsidies_remark <>", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkGreaterThan(String value) {
            addCriterion("boarder_subsidies_remark >", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("boarder_subsidies_remark >=", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkLessThan(String value) {
            addCriterion("boarder_subsidies_remark <", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkLessThanOrEqualTo(String value) {
            addCriterion("boarder_subsidies_remark <=", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkLike(String value) {
            addCriterion("boarder_subsidies_remark like", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkNotLike(String value) {
            addCriterion("boarder_subsidies_remark not like", value, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkIn(List<String> values) {
            addCriterion("boarder_subsidies_remark in", values, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkNotIn(List<String> values) {
            addCriterion("boarder_subsidies_remark not in", values, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkBetween(String value1, String value2) {
            addCriterion("boarder_subsidies_remark between", value1, value2, "boarderSubsidiesRemark");
            return (Criteria) this;
        }

        public Criteria andBoarderSubsidiesRemarkNotBetween(String value1, String value2) {
            addCriterion("boarder_subsidies_remark not between", value1, value2, "boarderSubsidiesRemark");
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