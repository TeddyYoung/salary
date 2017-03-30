package com.fh.entity.system;

import java.util.ArrayList;
import java.util.List;

public class PartQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public PartQuery() {
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

        public Criteria andPartidIsNull() {
            addCriterion("PartID is null");
            return (Criteria) this;
        }

        public Criteria andPartidIsNotNull() {
            addCriterion("PartID is not null");
            return (Criteria) this;
        }

        public Criteria andPartidEqualTo(String value) {
            addCriterion("PartID =", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotEqualTo(String value) {
            addCriterion("PartID <>", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidGreaterThan(String value) {
            addCriterion("PartID >", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidGreaterThanOrEqualTo(String value) {
            addCriterion("PartID >=", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidLessThan(String value) {
            addCriterion("PartID <", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidLessThanOrEqualTo(String value) {
            addCriterion("PartID <=", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidLike(String value) {
            addCriterion("PartID like", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotLike(String value) {
            addCriterion("PartID not like", value, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidIn(List<String> values) {
            addCriterion("PartID in", values, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotIn(List<String> values) {
            addCriterion("PartID not in", values, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidBetween(String value1, String value2) {
            addCriterion("PartID between", value1, value2, "partid");
            return (Criteria) this;
        }

        public Criteria andPartidNotBetween(String value1, String value2) {
            addCriterion("PartID not between", value1, value2, "partid");
            return (Criteria) this;
        }

        public Criteria andPartnameIsNull() {
            addCriterion("PartName is null");
            return (Criteria) this;
        }

        public Criteria andPartnameIsNotNull() {
            addCriterion("PartName is not null");
            return (Criteria) this;
        }

        public Criteria andPartnameEqualTo(String value) {
            addCriterion("PartName =", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameNotEqualTo(String value) {
            addCriterion("PartName <>", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameGreaterThan(String value) {
            addCriterion("PartName >", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameGreaterThanOrEqualTo(String value) {
            addCriterion("PartName >=", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameLessThan(String value) {
            addCriterion("PartName <", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameLessThanOrEqualTo(String value) {
            addCriterion("PartName <=", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameLike(String value) {
            addCriterion("PartName like", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameNotLike(String value) {
            addCriterion("PartName not like", value, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameIn(List<String> values) {
            addCriterion("PartName in", values, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameNotIn(List<String> values) {
            addCriterion("PartName not in", values, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameBetween(String value1, String value2) {
            addCriterion("PartName between", value1, value2, "partname");
            return (Criteria) this;
        }

        public Criteria andPartnameNotBetween(String value1, String value2) {
            addCriterion("PartName not between", value1, value2, "partname");
            return (Criteria) this;
        }

        public Criteria andDesctiptionIsNull() {
            addCriterion("Desctiption is null");
            return (Criteria) this;
        }

        public Criteria andDesctiptionIsNotNull() {
            addCriterion("Desctiption is not null");
            return (Criteria) this;
        }

        public Criteria andDesctiptionEqualTo(String value) {
            addCriterion("Desctiption =", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionNotEqualTo(String value) {
            addCriterion("Desctiption <>", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionGreaterThan(String value) {
            addCriterion("Desctiption >", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionGreaterThanOrEqualTo(String value) {
            addCriterion("Desctiption >=", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionLessThan(String value) {
            addCriterion("Desctiption <", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionLessThanOrEqualTo(String value) {
            addCriterion("Desctiption <=", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionLike(String value) {
            addCriterion("Desctiption like", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionNotLike(String value) {
            addCriterion("Desctiption not like", value, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionIn(List<String> values) {
            addCriterion("Desctiption in", values, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionNotIn(List<String> values) {
            addCriterion("Desctiption not in", values, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionBetween(String value1, String value2) {
            addCriterion("Desctiption between", value1, value2, "desctiption");
            return (Criteria) this;
        }

        public Criteria andDesctiptionNotBetween(String value1, String value2) {
            addCriterion("Desctiption not between", value1, value2, "desctiption");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdIsNull() {
            addCriterion("orderby_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdIsNotNull() {
            addCriterion("orderby_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdEqualTo(String value) {
            addCriterion("orderby_ID =", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotEqualTo(String value) {
            addCriterion("orderby_ID <>", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdGreaterThan(String value) {
            addCriterion("orderby_ID >", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdGreaterThanOrEqualTo(String value) {
            addCriterion("orderby_ID >=", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdLessThan(String value) {
            addCriterion("orderby_ID <", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdLessThanOrEqualTo(String value) {
            addCriterion("orderby_ID <=", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdLike(String value) {
            addCriterion("orderby_ID like", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotLike(String value) {
            addCriterion("orderby_ID not like", value, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdIn(List<String> values) {
            addCriterion("orderby_ID in", values, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotIn(List<String> values) {
            addCriterion("orderby_ID not in", values, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdBetween(String value1, String value2) {
            addCriterion("orderby_ID between", value1, value2, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andOrderbyIdNotBetween(String value1, String value2) {
            addCriterion("orderby_ID not between", value1, value2, "orderbyId");
            return (Criteria) this;
        }

        public Criteria andPPartidIsNull() {
            addCriterion("P_partID is null");
            return (Criteria) this;
        }

        public Criteria andPPartidIsNotNull() {
            addCriterion("P_partID is not null");
            return (Criteria) this;
        }

        public Criteria andPPartidEqualTo(String value) {
            addCriterion("P_partID =", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidNotEqualTo(String value) {
            addCriterion("P_partID <>", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidGreaterThan(String value) {
            addCriterion("P_partID >", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidGreaterThanOrEqualTo(String value) {
            addCriterion("P_partID >=", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidLessThan(String value) {
            addCriterion("P_partID <", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidLessThanOrEqualTo(String value) {
            addCriterion("P_partID <=", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidLike(String value) {
            addCriterion("P_partID like", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidNotLike(String value) {
            addCriterion("P_partID not like", value, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidIn(List<String> values) {
            addCriterion("P_partID in", values, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidNotIn(List<String> values) {
            addCriterion("P_partID not in", values, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidBetween(String value1, String value2) {
            addCriterion("P_partID between", value1, value2, "pPartid");
            return (Criteria) this;
        }

        public Criteria andPPartidNotBetween(String value1, String value2) {
            addCriterion("P_partID not between", value1, value2, "pPartid");
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