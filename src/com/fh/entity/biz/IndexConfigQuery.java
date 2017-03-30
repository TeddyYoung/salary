package com.fh.entity.biz;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndexConfigQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public IndexConfigQuery() {
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

        public Criteria andIndexCodeIsNull() {
            addCriterion("index_code is null");
            return (Criteria) this;
        }

        public Criteria andIndexCodeIsNotNull() {
            addCriterion("index_code is not null");
            return (Criteria) this;
        }

        public Criteria andIndexCodeEqualTo(String value) {
            addCriterion("index_code =", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeNotEqualTo(String value) {
            addCriterion("index_code <>", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeGreaterThan(String value) {
            addCriterion("index_code >", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeGreaterThanOrEqualTo(String value) {
            addCriterion("index_code >=", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeLessThan(String value) {
            addCriterion("index_code <", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeLessThanOrEqualTo(String value) {
            addCriterion("index_code <=", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeLike(String value) {
            addCriterion("index_code like", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeNotLike(String value) {
            addCriterion("index_code not like", value, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeIn(List<String> values) {
            addCriterion("index_code in", values, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeNotIn(List<String> values) {
            addCriterion("index_code not in", values, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeBetween(String value1, String value2) {
            addCriterion("index_code between", value1, value2, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexCodeNotBetween(String value1, String value2) {
            addCriterion("index_code not between", value1, value2, "indexCode");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNull() {
            addCriterion("index_name is null");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNotNull() {
            addCriterion("index_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNameEqualTo(String value) {
            addCriterion("index_name =", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotEqualTo(String value) {
            addCriterion("index_name <>", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThan(String value) {
            addCriterion("index_name >", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("index_name >=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThan(String value) {
            addCriterion("index_name <", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThanOrEqualTo(String value) {
            addCriterion("index_name <=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLike(String value) {
            addCriterion("index_name like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotLike(String value) {
            addCriterion("index_name not like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameIn(List<String> values) {
            addCriterion("index_name in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotIn(List<String> values) {
            addCriterion("index_name not in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameBetween(String value1, String value2) {
            addCriterion("index_name between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotBetween(String value1, String value2) {
            addCriterion("index_name not between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexValueIsNull() {
            addCriterion("index_value is null");
            return (Criteria) this;
        }

        public Criteria andIndexValueIsNotNull() {
            addCriterion("index_value is not null");
            return (Criteria) this;
        }

        public Criteria andIndexValueEqualTo(BigDecimal value) {
            addCriterion("index_value =", value, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueNotEqualTo(BigDecimal value) {
            addCriterion("index_value <>", value, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueGreaterThan(BigDecimal value) {
            addCriterion("index_value >", value, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("index_value >=", value, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueLessThan(BigDecimal value) {
            addCriterion("index_value <", value, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("index_value <=", value, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueIn(List<BigDecimal> values) {
            addCriterion("index_value in", values, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueNotIn(List<BigDecimal> values) {
            addCriterion("index_value not in", values, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("index_value between", value1, value2, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("index_value not between", value1, value2, "indexValue");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIsNull() {
            addCriterion("index_order is null");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIsNotNull() {
            addCriterion("index_order is not null");
            return (Criteria) this;
        }

        public Criteria andIndexOrderEqualTo(String value) {
            addCriterion("index_order =", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotEqualTo(String value) {
            addCriterion("index_order <>", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderGreaterThan(String value) {
            addCriterion("index_order >", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderGreaterThanOrEqualTo(String value) {
            addCriterion("index_order >=", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLessThan(String value) {
            addCriterion("index_order <", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLessThanOrEqualTo(String value) {
            addCriterion("index_order <=", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderLike(String value) {
            addCriterion("index_order like", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotLike(String value) {
            addCriterion("index_order not like", value, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderIn(List<String> values) {
            addCriterion("index_order in", values, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotIn(List<String> values) {
            addCriterion("index_order not in", values, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderBetween(String value1, String value2) {
            addCriterion("index_order between", value1, value2, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexOrderNotBetween(String value1, String value2) {
            addCriterion("index_order not between", value1, value2, "indexOrder");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIsNull() {
            addCriterion("index_type is null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIsNotNull() {
            addCriterion("index_type is not null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeEqualTo(String value) {
            addCriterion("index_type =", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotEqualTo(String value) {
            addCriterion("index_type <>", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeGreaterThan(String value) {
            addCriterion("index_type >", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeGreaterThanOrEqualTo(String value) {
            addCriterion("index_type >=", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeLessThan(String value) {
            addCriterion("index_type <", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeLessThanOrEqualTo(String value) {
            addCriterion("index_type <=", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeLike(String value) {
            addCriterion("index_type like", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotLike(String value) {
            addCriterion("index_type not like", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIn(List<String> values) {
            addCriterion("index_type in", values, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotIn(List<String> values) {
            addCriterion("index_type not in", values, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeBetween(String value1, String value2) {
            addCriterion("index_type between", value1, value2, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotBetween(String value1, String value2) {
            addCriterion("index_type not between", value1, value2, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameIsNull() {
            addCriterion("index_type_name is null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameIsNotNull() {
            addCriterion("index_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameEqualTo(String value) {
            addCriterion("index_type_name =", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameNotEqualTo(String value) {
            addCriterion("index_type_name <>", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameGreaterThan(String value) {
            addCriterion("index_type_name >", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("index_type_name >=", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameLessThan(String value) {
            addCriterion("index_type_name <", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameLessThanOrEqualTo(String value) {
            addCriterion("index_type_name <=", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameLike(String value) {
            addCriterion("index_type_name like", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameNotLike(String value) {
            addCriterion("index_type_name not like", value, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameIn(List<String> values) {
            addCriterion("index_type_name in", values, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameNotIn(List<String> values) {
            addCriterion("index_type_name not in", values, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameBetween(String value1, String value2) {
            addCriterion("index_type_name between", value1, value2, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNameNotBetween(String value1, String value2) {
            addCriterion("index_type_name not between", value1, value2, "indexTypeName");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2IsNull() {
            addCriterion("index_standard2 is null");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2IsNotNull() {
            addCriterion("index_standard2 is not null");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2EqualTo(String value) {
            addCriterion("index_standard2 =", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2NotEqualTo(String value) {
            addCriterion("index_standard2 <>", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2GreaterThan(String value) {
            addCriterion("index_standard2 >", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2GreaterThanOrEqualTo(String value) {
            addCriterion("index_standard2 >=", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2LessThan(String value) {
            addCriterion("index_standard2 <", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2LessThanOrEqualTo(String value) {
            addCriterion("index_standard2 <=", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2Like(String value) {
            addCriterion("index_standard2 like", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2NotLike(String value) {
            addCriterion("index_standard2 not like", value, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2In(List<String> values) {
            addCriterion("index_standard2 in", values, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2NotIn(List<String> values) {
            addCriterion("index_standard2 not in", values, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2Between(String value1, String value2) {
            addCriterion("index_standard2 between", value1, value2, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandard2NotBetween(String value1, String value2) {
            addCriterion("index_standard2 not between", value1, value2, "indexStandard2");
            return (Criteria) this;
        }

        public Criteria andIndexStandardIsNull() {
            addCriterion("index_standard is null");
            return (Criteria) this;
        }

        public Criteria andIndexStandardIsNotNull() {
            addCriterion("index_standard is not null");
            return (Criteria) this;
        }

        public Criteria andIndexStandardEqualTo(String value) {
            addCriterion("index_standard =", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardNotEqualTo(String value) {
            addCriterion("index_standard <>", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardGreaterThan(String value) {
            addCriterion("index_standard >", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardGreaterThanOrEqualTo(String value) {
            addCriterion("index_standard >=", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardLessThan(String value) {
            addCriterion("index_standard <", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardLessThanOrEqualTo(String value) {
            addCriterion("index_standard <=", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardLike(String value) {
            addCriterion("index_standard like", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardNotLike(String value) {
            addCriterion("index_standard not like", value, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardIn(List<String> values) {
            addCriterion("index_standard in", values, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardNotIn(List<String> values) {
            addCriterion("index_standard not in", values, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardBetween(String value1, String value2) {
            addCriterion("index_standard between", value1, value2, "indexStandard");
            return (Criteria) this;
        }

        public Criteria andIndexStandardNotBetween(String value1, String value2) {
            addCriterion("index_standard not between", value1, value2, "indexStandard");
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