package com.fh.entity.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbWorkflowUserDUserQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public TbWorkflowUserDUserQuery() {
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
            addCriterion("Userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("Userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("Userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("Userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("Userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("Userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("Userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("Userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("Userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("Userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("Userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("Userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("Userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("Userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUserPartIsNull() {
            addCriterion("User_part is null");
            return (Criteria) this;
        }

        public Criteria andUserPartIsNotNull() {
            addCriterion("User_part is not null");
            return (Criteria) this;
        }

        public Criteria andUserPartEqualTo(String value) {
            addCriterion("User_part =", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartNotEqualTo(String value) {
            addCriterion("User_part <>", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartGreaterThan(String value) {
            addCriterion("User_part >", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartGreaterThanOrEqualTo(String value) {
            addCriterion("User_part >=", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartLessThan(String value) {
            addCriterion("User_part <", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartLessThanOrEqualTo(String value) {
            addCriterion("User_part <=", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartLike(String value) {
            addCriterion("User_part like", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartNotLike(String value) {
            addCriterion("User_part not like", value, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartIn(List<String> values) {
            addCriterion("User_part in", values, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartNotIn(List<String> values) {
            addCriterion("User_part not in", values, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartBetween(String value1, String value2) {
            addCriterion("User_part between", value1, value2, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserPartNotBetween(String value1, String value2) {
            addCriterion("User_part not between", value1, value2, "userPart");
            return (Criteria) this;
        }

        public Criteria andUserDepIsNull() {
            addCriterion("User_dep is null");
            return (Criteria) this;
        }

        public Criteria andUserDepIsNotNull() {
            addCriterion("User_dep is not null");
            return (Criteria) this;
        }

        public Criteria andUserDepEqualTo(String value) {
            addCriterion("User_dep =", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepNotEqualTo(String value) {
            addCriterion("User_dep <>", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepGreaterThan(String value) {
            addCriterion("User_dep >", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepGreaterThanOrEqualTo(String value) {
            addCriterion("User_dep >=", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepLessThan(String value) {
            addCriterion("User_dep <", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepLessThanOrEqualTo(String value) {
            addCriterion("User_dep <=", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepLike(String value) {
            addCriterion("User_dep like", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepNotLike(String value) {
            addCriterion("User_dep not like", value, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepIn(List<String> values) {
            addCriterion("User_dep in", values, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepNotIn(List<String> values) {
            addCriterion("User_dep not in", values, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepBetween(String value1, String value2) {
            addCriterion("User_dep between", value1, value2, "userDep");
            return (Criteria) this;
        }

        public Criteria andUserDepNotBetween(String value1, String value2) {
            addCriterion("User_dep not between", value1, value2, "userDep");
            return (Criteria) this;
        }

        public Criteria andDUseridIsNull() {
            addCriterion("D_userid is null");
            return (Criteria) this;
        }

        public Criteria andDUseridIsNotNull() {
            addCriterion("D_userid is not null");
            return (Criteria) this;
        }

        public Criteria andDUseridEqualTo(String value) {
            addCriterion("D_userid =", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridNotEqualTo(String value) {
            addCriterion("D_userid <>", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridGreaterThan(String value) {
            addCriterion("D_userid >", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridGreaterThanOrEqualTo(String value) {
            addCriterion("D_userid >=", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridLessThan(String value) {
            addCriterion("D_userid <", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridLessThanOrEqualTo(String value) {
            addCriterion("D_userid <=", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridLike(String value) {
            addCriterion("D_userid like", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridNotLike(String value) {
            addCriterion("D_userid not like", value, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridIn(List<String> values) {
            addCriterion("D_userid in", values, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridNotIn(List<String> values) {
            addCriterion("D_userid not in", values, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridBetween(String value1, String value2) {
            addCriterion("D_userid between", value1, value2, "dUserid");
            return (Criteria) this;
        }

        public Criteria andDUseridNotBetween(String value1, String value2) {
            addCriterion("D_userid not between", value1, value2, "dUserid");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("Begin_date is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("Begin_date is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(Date value) {
            addCriterion("Begin_date =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(Date value) {
            addCriterion("Begin_date <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(Date value) {
            addCriterion("Begin_date >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("Begin_date >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(Date value) {
            addCriterion("Begin_date <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(Date value) {
            addCriterion("Begin_date <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<Date> values) {
            addCriterion("Begin_date in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<Date> values) {
            addCriterion("Begin_date not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(Date value1, Date value2) {
            addCriterion("Begin_date between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(Date value1, Date value2) {
            addCriterion("Begin_date not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("End_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("End_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("End_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("End_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("End_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("End_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("End_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("End_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("End_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("End_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("End_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("End_date not between", value1, value2, "endDate");
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

        public Criteria andProcessDefinitionIdIsNull() {
            addCriterion("processDefinitionId is null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdIsNotNull() {
            addCriterion("processDefinitionId is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdEqualTo(String value) {
            addCriterion("processDefinitionId =", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotEqualTo(String value) {
            addCriterion("processDefinitionId <>", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdGreaterThan(String value) {
            addCriterion("processDefinitionId >", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdGreaterThanOrEqualTo(String value) {
            addCriterion("processDefinitionId >=", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdLessThan(String value) {
            addCriterion("processDefinitionId <", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdLessThanOrEqualTo(String value) {
            addCriterion("processDefinitionId <=", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdLike(String value) {
            addCriterion("processDefinitionId like", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotLike(String value) {
            addCriterion("processDefinitionId not like", value, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdIn(List<String> values) {
            addCriterion("processDefinitionId in", values, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotIn(List<String> values) {
            addCriterion("processDefinitionId not in", values, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdBetween(String value1, String value2) {
            addCriterion("processDefinitionId between", value1, value2, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andProcessDefinitionIdNotBetween(String value1, String value2) {
            addCriterion("processDefinitionId not between", value1, value2, "processDefinitionId");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNull() {
            addCriterion("flow_type is null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNotNull() {
            addCriterion("flow_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeEqualTo(String value) {
            addCriterion("flow_type =", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotEqualTo(String value) {
            addCriterion("flow_type <>", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThan(String value) {
            addCriterion("flow_type >", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("flow_type >=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThan(String value) {
            addCriterion("flow_type <", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThanOrEqualTo(String value) {
            addCriterion("flow_type <=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLike(String value) {
            addCriterion("flow_type like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotLike(String value) {
            addCriterion("flow_type not like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIn(List<String> values) {
            addCriterion("flow_type in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotIn(List<String> values) {
            addCriterion("flow_type not in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeBetween(String value1, String value2) {
            addCriterion("flow_type between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotBetween(String value1, String value2) {
            addCriterion("flow_type not between", value1, value2, "flowType");
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