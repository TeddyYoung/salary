package com.fh.entity.system;

import java.util.ArrayList;
import java.util.List;

public class DepPartQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public DepPartQuery() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNull() {
            addCriterion("Store_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("Store_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(String value) {
            addCriterion("Store_type =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(String value) {
            addCriterion("Store_type <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(String value) {
            addCriterion("Store_type >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Store_type >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(String value) {
            addCriterion("Store_type <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(String value) {
            addCriterion("Store_type <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLike(String value) {
            addCriterion("Store_type like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotLike(String value) {
            addCriterion("Store_type not like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<String> values) {
            addCriterion("Store_type in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<String> values) {
            addCriterion("Store_type not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(String value1, String value2) {
            addCriterion("Store_type between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(String value1, String value2) {
            addCriterion("Store_type not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andPartidIsNull() {
            addCriterion("partID is null");
            return (Criteria) this;
        }

        public Criteria andPartidIsNotNull() {
            addCriterion("partID is not null");
            return (Criteria) this;
        }

        public Criteria andPartidEqualTo(String value) {
            addCriterion("partID =", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotEqualTo(String value) {
            addCriterion("partID <>", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidGreaterThan(String value) {
            addCriterion("partID >", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidGreaterThanOrEqualTo(String value) {
            addCriterion("partID >=", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidLessThan(String value) {
            addCriterion("partID <", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidLessThanOrEqualTo(String value) {
            addCriterion("partID <=", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidLike(String value) {
            addCriterion("partID like", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotLike(String value) {
            addCriterion("partID not like", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidIn(List<String> values) {
            addCriterion("partID in", values, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotIn(List<String> values) {
            addCriterion("partID not in", values, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidBetween(String value1, String value2) {
            addCriterion("partID between", value1, value2, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotBetween(String value1, String value2) {
            addCriterion("partID not between", value1, value2, "partid");
            return (Criteria) this;
        }

        public Criteria andStorePartIsNull() {
            addCriterion("Store_part is null");
            return (Criteria) this;
        }

        public Criteria andStorePartIsNotNull() {
            addCriterion("Store_part is not null");
            return (Criteria) this;
        }

        public Criteria andStorePartEqualTo(String value) {
            addCriterion("Store_part =", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartNotEqualTo(String value) {
            addCriterion("Store_part <>", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartGreaterThan(String value) {
            addCriterion("Store_part >", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartGreaterThanOrEqualTo(String value) {
            addCriterion("Store_part >=", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartLessThan(String value) {
            addCriterion("Store_part <", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartLessThanOrEqualTo(String value) {
            addCriterion("Store_part <=", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartLike(String value) {
            addCriterion("Store_part like", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartNotLike(String value) {
            addCriterion("Store_part not like", value, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartIn(List<String> values) {
            addCriterion("Store_part in", values, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartNotIn(List<String> values) {
            addCriterion("Store_part not in", values, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartBetween(String value1, String value2) {
            addCriterion("Store_part between", value1, value2, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartNotBetween(String value1, String value2) {
            addCriterion("Store_part not between", value1, value2, "storePart");
            return (Criteria) this;
        }

        public Criteria andStorePartNameIsNull() {
            addCriterion("Store_part_name is null");
            return (Criteria) this;
        }

        public Criteria andStorePartNameIsNotNull() {
            addCriterion("Store_part_name is not null");
            return (Criteria) this;
        }

        public Criteria andStorePartNameEqualTo(String value) {
            addCriterion("Store_part_name =", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameNotEqualTo(String value) {
            addCriterion("Store_part_name <>", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameGreaterThan(String value) {
            addCriterion("Store_part_name >", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameGreaterThanOrEqualTo(String value) {
            addCriterion("Store_part_name >=", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameLessThan(String value) {
            addCriterion("Store_part_name <", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameLessThanOrEqualTo(String value) {
            addCriterion("Store_part_name <=", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameLike(String value) {
            addCriterion("Store_part_name like", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameNotLike(String value) {
            addCriterion("Store_part_name not like", value, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameIn(List<String> values) {
            addCriterion("Store_part_name in", values, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameNotIn(List<String> values) {
            addCriterion("Store_part_name not in", values, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameBetween(String value1, String value2) {
            addCriterion("Store_part_name between", value1, value2, "storePartName");
            return (Criteria) this;
        }

        public Criteria andStorePartNameNotBetween(String value1, String value2) {
            addCriterion("Store_part_name not between", value1, value2, "storePartName");
            return (Criteria) this;
        }

        public Criteria andPStorePartIsNull() {
            addCriterion("P_store_part is null");
            return (Criteria) this;
        }

        public Criteria andPStorePartIsNotNull() {
            addCriterion("P_store_part is not null");
            return (Criteria) this;
        }

        public Criteria andPStorePartEqualTo(String value) {
            addCriterion("P_store_part =", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartNotEqualTo(String value) {
            addCriterion("P_store_part <>", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartGreaterThan(String value) {
            addCriterion("P_store_part >", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartGreaterThanOrEqualTo(String value) {
            addCriterion("P_store_part >=", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartLessThan(String value) {
            addCriterion("P_store_part <", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartLessThanOrEqualTo(String value) {
            addCriterion("P_store_part <=", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartLike(String value) {
            addCriterion("P_store_part like", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartNotLike(String value) {
            addCriterion("P_store_part not like", value, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartIn(List<String> values) {
            addCriterion("P_store_part in", values, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartNotIn(List<String> values) {
            addCriterion("P_store_part not in", values, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartBetween(String value1, String value2) {
            addCriterion("P_store_part between", value1, value2, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andPStorePartNotBetween(String value1, String value2) {
            addCriterion("P_store_part not between", value1, value2, "pStorePart");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdIsNull() {
            addCriterion("orderby_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdIsNotNull() {
            addCriterion("orderby_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdEqualTo(String value) {
            addCriterion("orderby_id =", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotEqualTo(String value) {
            addCriterion("orderby_id <>", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdGreaterThan(String value) {
            addCriterion("orderby_id >", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdGreaterThanOrEqualTo(String value) {
            addCriterion("orderby_id >=", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdLessThan(String value) {
            addCriterion("orderby_id <", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdLessThanOrEqualTo(String value) {
            addCriterion("orderby_id <=", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdLike(String value) {
            addCriterion("orderby_id like", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotLike(String value) {
            addCriterion("orderby_id not like", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdIn(List<String> values) {
            addCriterion("orderby_id in", values, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotIn(List<String> values) {
            addCriterion("orderby_id not in", values, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdBetween(String value1, String value2) {
            addCriterion("orderby_id between", value1, value2, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotBetween(String value1, String value2) {
            addCriterion("orderby_id not between", value1, value2, "orderbyId");
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