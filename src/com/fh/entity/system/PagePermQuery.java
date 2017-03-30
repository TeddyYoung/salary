package com.fh.entity.system;

import java.util.ArrayList;
import java.util.List;

public class PagePermQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public PagePermQuery() {
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

        public Criteria andPageidIsNull() {
            addCriterion("PageID is null");
            return (Criteria) this;
        }

        public Criteria andPageidIsNotNull() {
            addCriterion("PageID is not null");
            return (Criteria) this;
        }

        public Criteria andPageidEqualTo(String value) {
            addCriterion("PageID =", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidNotEqualTo(String value) {
            addCriterion("PageID <>", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidGreaterThan(String value) {
            addCriterion("PageID >", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidGreaterThanOrEqualTo(String value) {
            addCriterion("PageID >=", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidLessThan(String value) {
            addCriterion("PageID <", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidLessThanOrEqualTo(String value) {
            addCriterion("PageID <=", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidLike(String value) {
            addCriterion("PageID like", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidNotLike(String value) {
            addCriterion("PageID not like", value, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidIn(List<String> values) {
            addCriterion("PageID in", values, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidNotIn(List<String> values) {
            addCriterion("PageID not in", values, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidBetween(String value1, String value2) {
            addCriterion("PageID between", value1, value2, "pageid");
            return (Criteria) this;
        }

        public Criteria andPageidNotBetween(String value1, String value2) {
            addCriterion("PageID not between", value1, value2, "pageid");
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