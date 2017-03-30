package com.fh.entity.system;

import java.util.ArrayList;
import java.util.List;

public class UserStorePartQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UserStorePartQuery() {
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

        public Criteria andUseridIsNull() {
            addCriterion("UserID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("UserID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("UserID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("UserID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("UserID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("UserID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("UserID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("UserID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("UserID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("UserID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("UserID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("UserID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("UserID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNull() {
            addCriterion("StoreID is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("StoreID is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(String value) {
            addCriterion("StoreID =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(String value) {
            addCriterion("StoreID <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(String value) {
            addCriterion("StoreID >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(String value) {
            addCriterion("StoreID >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(String value) {
            addCriterion("StoreID <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(String value) {
            addCriterion("StoreID <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLike(String value) {
            addCriterion("StoreID like", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotLike(String value) {
            addCriterion("StoreID not like", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<String> values) {
            addCriterion("StoreID in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<String> values) {
            addCriterion("StoreID not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(String value1, String value2) {
            addCriterion("StoreID between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(String value1, String value2) {
            addCriterion("StoreID not between", value1, value2, "storeid");
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

        public Criteria andDiffIsNull() {
            addCriterion("Diff is null");
            return (Criteria) this;
        }

        public Criteria andDiffIsNotNull() {
            addCriterion("Diff is not null");
            return (Criteria) this;
        }

        public Criteria andDiffEqualTo(String value) {
            addCriterion("Diff =", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotEqualTo(String value) {
            addCriterion("Diff <>", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffGreaterThan(String value) {
            addCriterion("Diff >", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffGreaterThanOrEqualTo(String value) {
            addCriterion("Diff >=", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffLessThan(String value) {
            addCriterion("Diff <", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffLessThanOrEqualTo(String value) {
            addCriterion("Diff <=", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffLike(String value) {
            addCriterion("Diff like", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotLike(String value) {
            addCriterion("Diff not like", value, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffIn(List<String> values) {
            addCriterion("Diff in", values, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotIn(List<String> values) {
            addCriterion("Diff not in", values, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffBetween(String value1, String value2) {
            addCriterion("Diff between", value1, value2, "diff");
            return (Criteria) this;
        }

        public Criteria andDiffNotBetween(String value1, String value2) {
            addCriterion("Diff not between", value1, value2, "diff");
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