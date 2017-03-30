package com.fh.entity.system;

import java.util.ArrayList;
import java.util.List;

public class ParameterQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ParameterQuery() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParameterKeyIsNull() {
            addCriterion("parameter_key is null");
            return (Criteria) this;
        }

        public Criteria andParameterKeyIsNotNull() {
            addCriterion("parameter_key is not null");
            return (Criteria) this;
        }

        public Criteria andParameterKeyEqualTo(String value) {
            addCriterion("parameter_key =", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyNotEqualTo(String value) {
            addCriterion("parameter_key <>", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyGreaterThan(String value) {
            addCriterion("parameter_key >", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_key >=", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyLessThan(String value) {
            addCriterion("parameter_key <", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyLessThanOrEqualTo(String value) {
            addCriterion("parameter_key <=", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyLike(String value) {
            addCriterion("parameter_key like", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyNotLike(String value) {
            addCriterion("parameter_key not like", value, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyIn(List<String> values) {
            addCriterion("parameter_key in", values, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyNotIn(List<String> values) {
            addCriterion("parameter_key not in", values, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyBetween(String value1, String value2) {
            addCriterion("parameter_key between", value1, value2, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterKeyNotBetween(String value1, String value2) {
            addCriterion("parameter_key not between", value1, value2, "parameterKey");
            return (Criteria) this;
        }

        public Criteria andParameterValueIsNull() {
            addCriterion("parameter_value is null");
            return (Criteria) this;
        }

        public Criteria andParameterValueIsNotNull() {
            addCriterion("parameter_value is not null");
            return (Criteria) this;
        }

        public Criteria andParameterValueEqualTo(String value) {
            addCriterion("parameter_value =", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotEqualTo(String value) {
            addCriterion("parameter_value <>", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueGreaterThan(String value) {
            addCriterion("parameter_value >", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_value >=", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueLessThan(String value) {
            addCriterion("parameter_value <", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueLessThanOrEqualTo(String value) {
            addCriterion("parameter_value <=", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueLike(String value) {
            addCriterion("parameter_value like", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotLike(String value) {
            addCriterion("parameter_value not like", value, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueIn(List<String> values) {
            addCriterion("parameter_value in", values, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotIn(List<String> values) {
            addCriterion("parameter_value not in", values, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueBetween(String value1, String value2) {
            addCriterion("parameter_value between", value1, value2, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterValueNotBetween(String value1, String value2) {
            addCriterion("parameter_value not between", value1, value2, "parameterValue");
            return (Criteria) this;
        }

        public Criteria andParameterTypeIsNull() {
            addCriterion("parameter_type is null");
            return (Criteria) this;
        }

        public Criteria andParameterTypeIsNotNull() {
            addCriterion("parameter_type is not null");
            return (Criteria) this;
        }

        public Criteria andParameterTypeEqualTo(String value) {
            addCriterion("parameter_type =", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNotEqualTo(String value) {
            addCriterion("parameter_type <>", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeGreaterThan(String value) {
            addCriterion("parameter_type >", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_type >=", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeLessThan(String value) {
            addCriterion("parameter_type <", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeLessThanOrEqualTo(String value) {
            addCriterion("parameter_type <=", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeLike(String value) {
            addCriterion("parameter_type like", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNotLike(String value) {
            addCriterion("parameter_type not like", value, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeIn(List<String> values) {
            addCriterion("parameter_type in", values, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNotIn(List<String> values) {
            addCriterion("parameter_type not in", values, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeBetween(String value1, String value2) {
            addCriterion("parameter_type between", value1, value2, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNotBetween(String value1, String value2) {
            addCriterion("parameter_type not between", value1, value2, "parameterType");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameIsNull() {
            addCriterion("parameter_type_name is null");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameIsNotNull() {
            addCriterion("parameter_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameEqualTo(String value) {
            addCriterion("parameter_type_name =", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameNotEqualTo(String value) {
            addCriterion("parameter_type_name <>", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameGreaterThan(String value) {
            addCriterion("parameter_type_name >", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_type_name >=", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameLessThan(String value) {
            addCriterion("parameter_type_name <", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameLessThanOrEqualTo(String value) {
            addCriterion("parameter_type_name <=", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameLike(String value) {
            addCriterion("parameter_type_name like", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameNotLike(String value) {
            addCriterion("parameter_type_name not like", value, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameIn(List<String> values) {
            addCriterion("parameter_type_name in", values, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameNotIn(List<String> values) {
            addCriterion("parameter_type_name not in", values, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameBetween(String value1, String value2) {
            addCriterion("parameter_type_name between", value1, value2, "parameterTypeName");
            return (Criteria) this;
        }

        public Criteria andParameterTypeNameNotBetween(String value1, String value2) {
            addCriterion("parameter_type_name not between", value1, value2, "parameterTypeName");
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