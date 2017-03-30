package com.fh.entity.system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActHiActinstQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public ActHiActinstQuery() {
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
            addCriterion("ID_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProcDefIdIsNull() {
            addCriterion("PROC_DEF_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andProcDefIdIsNotNull() {
            addCriterion("PROC_DEF_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andProcDefIdEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ =", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ <>", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdGreaterThan(String value) {
            addCriterion("PROC_DEF_ID_ >", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ >=", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdLessThan(String value) {
            addCriterion("PROC_DEF_ID_ <", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdLessThanOrEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ <=", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdLike(String value) {
            addCriterion("PROC_DEF_ID_ like", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotLike(String value) {
            addCriterion("PROC_DEF_ID_ not like", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdIn(List<String> values) {
            addCriterion("PROC_DEF_ID_ in", values, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotIn(List<String> values) {
            addCriterion("PROC_DEF_ID_ not in", values, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdBetween(String value1, String value2) {
            addCriterion("PROC_DEF_ID_ between", value1, value2, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotBetween(String value1, String value2) {
            addCriterion("PROC_DEF_ID_ not between", value1, value2, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdIsNull() {
            addCriterion("PROC_INST_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andProcInstIdIsNotNull() {
            addCriterion("PROC_INST_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andProcInstIdEqualTo(String value) {
            addCriterion("PROC_INST_ID_ =", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotEqualTo(String value) {
            addCriterion("PROC_INST_ID_ <>", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdGreaterThan(String value) {
            addCriterion("PROC_INST_ID_ >", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROC_INST_ID_ >=", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdLessThan(String value) {
            addCriterion("PROC_INST_ID_ <", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdLessThanOrEqualTo(String value) {
            addCriterion("PROC_INST_ID_ <=", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdLike(String value) {
            addCriterion("PROC_INST_ID_ like", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotLike(String value) {
            addCriterion("PROC_INST_ID_ not like", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdIn(List<String> values) {
            addCriterion("PROC_INST_ID_ in", values, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotIn(List<String> values) {
            addCriterion("PROC_INST_ID_ not in", values, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdBetween(String value1, String value2) {
            addCriterion("PROC_INST_ID_ between", value1, value2, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotBetween(String value1, String value2) {
            addCriterion("PROC_INST_ID_ not between", value1, value2, "procInstId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdIsNull() {
            addCriterion("EXECUTION_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andExecutionIdIsNotNull() {
            addCriterion("EXECUTION_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andExecutionIdEqualTo(String value) {
            addCriterion("EXECUTION_ID_ =", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotEqualTo(String value) {
            addCriterion("EXECUTION_ID_ <>", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdGreaterThan(String value) {
            addCriterion("EXECUTION_ID_ >", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXECUTION_ID_ >=", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdLessThan(String value) {
            addCriterion("EXECUTION_ID_ <", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdLessThanOrEqualTo(String value) {
            addCriterion("EXECUTION_ID_ <=", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdLike(String value) {
            addCriterion("EXECUTION_ID_ like", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotLike(String value) {
            addCriterion("EXECUTION_ID_ not like", value, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdIn(List<String> values) {
            addCriterion("EXECUTION_ID_ in", values, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotIn(List<String> values) {
            addCriterion("EXECUTION_ID_ not in", values, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdBetween(String value1, String value2) {
            addCriterion("EXECUTION_ID_ between", value1, value2, "executionId");
            return (Criteria) this;
        }

        public Criteria andExecutionIdNotBetween(String value1, String value2) {
            addCriterion("EXECUTION_ID_ not between", value1, value2, "executionId");
            return (Criteria) this;
        }

        public Criteria andActIdIsNull() {
            addCriterion("ACT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andActIdIsNotNull() {
            addCriterion("ACT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andActIdEqualTo(String value) {
            addCriterion("ACT_ID_ =", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotEqualTo(String value) {
            addCriterion("ACT_ID_ <>", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThan(String value) {
            addCriterion("ACT_ID_ >", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_ID_ >=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThan(String value) {
            addCriterion("ACT_ID_ <", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThanOrEqualTo(String value) {
            addCriterion("ACT_ID_ <=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLike(String value) {
            addCriterion("ACT_ID_ like", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotLike(String value) {
            addCriterion("ACT_ID_ not like", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdIn(List<String> values) {
            addCriterion("ACT_ID_ in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotIn(List<String> values) {
            addCriterion("ACT_ID_ not in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdBetween(String value1, String value2) {
            addCriterion("ACT_ID_ between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotBetween(String value1, String value2) {
            addCriterion("ACT_ID_ not between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("TASK_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("TASK_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("TASK_ID_ =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("TASK_ID_ <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("TASK_ID_ >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ID_ >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("TASK_ID_ <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("TASK_ID_ <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("TASK_ID_ like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("TASK_ID_ not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("TASK_ID_ in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("TASK_ID_ not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("TASK_ID_ between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("TASK_ID_ not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdIsNull() {
            addCriterion("CALL_PROC_INST_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdIsNotNull() {
            addCriterion("CALL_PROC_INST_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdEqualTo(String value) {
            addCriterion("CALL_PROC_INST_ID_ =", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdNotEqualTo(String value) {
            addCriterion("CALL_PROC_INST_ID_ <>", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdGreaterThan(String value) {
            addCriterion("CALL_PROC_INST_ID_ >", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_PROC_INST_ID_ >=", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdLessThan(String value) {
            addCriterion("CALL_PROC_INST_ID_ <", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdLessThanOrEqualTo(String value) {
            addCriterion("CALL_PROC_INST_ID_ <=", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdLike(String value) {
            addCriterion("CALL_PROC_INST_ID_ like", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdNotLike(String value) {
            addCriterion("CALL_PROC_INST_ID_ not like", value, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdIn(List<String> values) {
            addCriterion("CALL_PROC_INST_ID_ in", values, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdNotIn(List<String> values) {
            addCriterion("CALL_PROC_INST_ID_ not in", values, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdBetween(String value1, String value2) {
            addCriterion("CALL_PROC_INST_ID_ between", value1, value2, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andCallProcInstIdNotBetween(String value1, String value2) {
            addCriterion("CALL_PROC_INST_ID_ not between", value1, value2, "callProcInstId");
            return (Criteria) this;
        }

        public Criteria andActNameIsNull() {
            addCriterion("ACT_NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andActNameIsNotNull() {
            addCriterion("ACT_NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andActNameEqualTo(String value) {
            addCriterion("ACT_NAME_ =", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotEqualTo(String value) {
            addCriterion("ACT_NAME_ <>", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameGreaterThan(String value) {
            addCriterion("ACT_NAME_ >", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_NAME_ >=", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameLessThan(String value) {
            addCriterion("ACT_NAME_ <", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameLessThanOrEqualTo(String value) {
            addCriterion("ACT_NAME_ <=", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameLike(String value) {
            addCriterion("ACT_NAME_ like", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotLike(String value) {
            addCriterion("ACT_NAME_ not like", value, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameIn(List<String> values) {
            addCriterion("ACT_NAME_ in", values, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotIn(List<String> values) {
            addCriterion("ACT_NAME_ not in", values, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameBetween(String value1, String value2) {
            addCriterion("ACT_NAME_ between", value1, value2, "actName");
            return (Criteria) this;
        }

        public Criteria andActNameNotBetween(String value1, String value2) {
            addCriterion("ACT_NAME_ not between", value1, value2, "actName");
            return (Criteria) this;
        }

        public Criteria andActTypeIsNull() {
            addCriterion("ACT_TYPE_ is null");
            return (Criteria) this;
        }

        public Criteria andActTypeIsNotNull() {
            addCriterion("ACT_TYPE_ is not null");
            return (Criteria) this;
        }

        public Criteria andActTypeEqualTo(String value) {
            addCriterion("ACT_TYPE_ =", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotEqualTo(String value) {
            addCriterion("ACT_TYPE_ <>", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeGreaterThan(String value) {
            addCriterion("ACT_TYPE_ >", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_TYPE_ >=", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLessThan(String value) {
            addCriterion("ACT_TYPE_ <", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLessThanOrEqualTo(String value) {
            addCriterion("ACT_TYPE_ <=", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLike(String value) {
            addCriterion("ACT_TYPE_ like", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotLike(String value) {
            addCriterion("ACT_TYPE_ not like", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeIn(List<String> values) {
            addCriterion("ACT_TYPE_ in", values, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotIn(List<String> values) {
            addCriterion("ACT_TYPE_ not in", values, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeBetween(String value1, String value2) {
            addCriterion("ACT_TYPE_ between", value1, value2, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotBetween(String value1, String value2) {
            addCriterion("ACT_TYPE_ not between", value1, value2, "actType");
            return (Criteria) this;
        }

        public Criteria andAssigneeIsNull() {
            addCriterion("ASSIGNEE_ is null");
            return (Criteria) this;
        }

        public Criteria andAssigneeIsNotNull() {
            addCriterion("ASSIGNEE_ is not null");
            return (Criteria) this;
        }

        public Criteria andAssigneeEqualTo(String value) {
            addCriterion("ASSIGNEE_ =", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeNotEqualTo(String value) {
            addCriterion("ASSIGNEE_ <>", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeGreaterThan(String value) {
            addCriterion("ASSIGNEE_ >", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeGreaterThanOrEqualTo(String value) {
            addCriterion("ASSIGNEE_ >=", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeLessThan(String value) {
            addCriterion("ASSIGNEE_ <", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeLessThanOrEqualTo(String value) {
            addCriterion("ASSIGNEE_ <=", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeLike(String value) {
            addCriterion("ASSIGNEE_ like", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeNotLike(String value) {
            addCriterion("ASSIGNEE_ not like", value, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeIn(List<String> values) {
            addCriterion("ASSIGNEE_ in", values, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeNotIn(List<String> values) {
            addCriterion("ASSIGNEE_ not in", values, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeBetween(String value1, String value2) {
            addCriterion("ASSIGNEE_ between", value1, value2, "assignee");
            return (Criteria) this;
        }

        public Criteria andAssigneeNotBetween(String value1, String value2) {
            addCriterion("ASSIGNEE_ not between", value1, value2, "assignee");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME_ =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME_ <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME_ >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME_ >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME_ <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME_ <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME_ in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME_ not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME_ between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME_ not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME_ =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME_ <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME_ >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME_ >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME_ <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME_ <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME_ in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME_ not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME_ between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME_ not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("DURATION_ is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("DURATION_ is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(BigDecimal value) {
            addCriterion("DURATION_ =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(BigDecimal value) {
            addCriterion("DURATION_ <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(BigDecimal value) {
            addCriterion("DURATION_ >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DURATION_ >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(BigDecimal value) {
            addCriterion("DURATION_ <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DURATION_ <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<BigDecimal> values) {
            addCriterion("DURATION_ in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<BigDecimal> values) {
            addCriterion("DURATION_ not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DURATION_ between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DURATION_ not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andOperationIsNull() {
            addCriterion("OPERATION_ is null");
            return (Criteria) this;
        }

        public Criteria andOperationIsNotNull() {
            addCriterion("OPERATION_ is not null");
            return (Criteria) this;
        }

        public Criteria andOperationEqualTo(String value) {
            addCriterion("OPERATION_ =", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotEqualTo(String value) {
            addCriterion("OPERATION_ <>", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThan(String value) {
            addCriterion("OPERATION_ >", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATION_ >=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThan(String value) {
            addCriterion("OPERATION_ <", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLessThanOrEqualTo(String value) {
            addCriterion("OPERATION_ <=", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationLike(String value) {
            addCriterion("OPERATION_ like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotLike(String value) {
            addCriterion("OPERATION_ not like", value, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationIn(List<String> values) {
            addCriterion("OPERATION_ in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotIn(List<String> values) {
            addCriterion("OPERATION_ not in", values, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationBetween(String value1, String value2) {
            addCriterion("OPERATION_ between", value1, value2, "operation");
            return (Criteria) this;
        }

        public Criteria andOperationNotBetween(String value1, String value2) {
            addCriterion("OPERATION_ not between", value1, value2, "operation");
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