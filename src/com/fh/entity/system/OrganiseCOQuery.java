package com.fh.entity.system;

import java.util.ArrayList;
import java.util.List;

public class OrganiseCOQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public OrganiseCOQuery() {
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

        public Criteria andOrganiseIdIsNull() {
            addCriterion("organise_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdIsNotNull() {
            addCriterion("organise_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdEqualTo(String value) {
            addCriterion("organise_ID =", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdNotEqualTo(String value) {
            addCriterion("organise_ID <>", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdGreaterThan(String value) {
            addCriterion("organise_ID >", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdGreaterThanOrEqualTo(String value) {
            addCriterion("organise_ID >=", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdLessThan(String value) {
            addCriterion("organise_ID <", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdLessThanOrEqualTo(String value) {
            addCriterion("organise_ID <=", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdLike(String value) {
            addCriterion("organise_ID like", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdNotLike(String value) {
            addCriterion("organise_ID not like", value, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdIn(List<String> values) {
            addCriterion("organise_ID in", values, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdNotIn(List<String> values) {
            addCriterion("organise_ID not in", values, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdBetween(String value1, String value2) {
            addCriterion("organise_ID between", value1, value2, "organiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseIdNotBetween(String value1, String value2) {
            addCriterion("organise_ID not between", value1, value2, "organiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdIsNull() {
            addCriterion("p_organise_ID is null");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdIsNotNull() {
            addCriterion("p_organise_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdEqualTo(String value) {
            addCriterion("p_organise_ID =", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdNotEqualTo(String value) {
            addCriterion("p_organise_ID <>", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdGreaterThan(String value) {
            addCriterion("p_organise_ID >", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_organise_ID >=", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdLessThan(String value) {
            addCriterion("p_organise_ID <", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdLessThanOrEqualTo(String value) {
            addCriterion("p_organise_ID <=", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdLike(String value) {
            addCriterion("p_organise_ID like", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdNotLike(String value) {
            addCriterion("p_organise_ID not like", value, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdIn(List<String> values) {
            addCriterion("p_organise_ID in", values, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdNotIn(List<String> values) {
            addCriterion("p_organise_ID not in", values, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdBetween(String value1, String value2) {
            addCriterion("p_organise_ID between", value1, value2, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andPOrganiseIdNotBetween(String value1, String value2) {
            addCriterion("p_organise_ID not between", value1, value2, "pOrganiseId");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameIsNull() {
            addCriterion("organise_Name is null");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameIsNotNull() {
            addCriterion("organise_Name is not null");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameEqualTo(String value) {
            addCriterion("organise_Name =", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameNotEqualTo(String value) {
            addCriterion("organise_Name <>", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameGreaterThan(String value) {
            addCriterion("organise_Name >", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameGreaterThanOrEqualTo(String value) {
            addCriterion("organise_Name >=", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameLessThan(String value) {
            addCriterion("organise_Name <", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameLessThanOrEqualTo(String value) {
            addCriterion("organise_Name <=", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameLike(String value) {
            addCriterion("organise_Name like", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameNotLike(String value) {
            addCriterion("organise_Name not like", value, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameIn(List<String> values) {
            addCriterion("organise_Name in", values, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameNotIn(List<String> values) {
            addCriterion("organise_Name not in", values, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameBetween(String value1, String value2) {
            addCriterion("organise_Name between", value1, value2, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseNameNotBetween(String value1, String value2) {
            addCriterion("organise_Name not between", value1, value2, "organiseName");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdIsNull() {
            addCriterion("organise_type_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdIsNotNull() {
            addCriterion("organise_type_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdEqualTo(String value) {
            addCriterion("organise_type_ID =", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdNotEqualTo(String value) {
            addCriterion("organise_type_ID <>", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdGreaterThan(String value) {
            addCriterion("organise_type_ID >", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("organise_type_ID >=", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdLessThan(String value) {
            addCriterion("organise_type_ID <", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdLessThanOrEqualTo(String value) {
            addCriterion("organise_type_ID <=", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdLike(String value) {
            addCriterion("organise_type_ID like", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdNotLike(String value) {
            addCriterion("organise_type_ID not like", value, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdIn(List<String> values) {
            addCriterion("organise_type_ID in", values, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdNotIn(List<String> values) {
            addCriterion("organise_type_ID not in", values, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdBetween(String value1, String value2) {
            addCriterion("organise_type_ID between", value1, value2, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andOrganiseTypeIdNotBetween(String value1, String value2) {
            addCriterion("organise_type_ID not between", value1, value2, "organiseTypeId");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("City is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("City is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("City =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("City <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("City >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("City >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("City <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("City <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("City like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("City not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("City in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("City not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("City between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("City not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCoidIsNull() {
            addCriterion("COID is null");
            return (Criteria) this;
        }

        public Criteria andCoidIsNotNull() {
            addCriterion("COID is not null");
            return (Criteria) this;
        }

        public Criteria andCoidEqualTo(String value) {
            addCriterion("COID =", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotEqualTo(String value) {
            addCriterion("COID <>", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidGreaterThan(String value) {
            addCriterion("COID >", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidGreaterThanOrEqualTo(String value) {
            addCriterion("COID >=", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLessThan(String value) {
            addCriterion("COID <", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLessThanOrEqualTo(String value) {
            addCriterion("COID <=", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLike(String value) {
            addCriterion("COID like", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotLike(String value) {
            addCriterion("COID not like", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidIn(List<String> values) {
            addCriterion("COID in", values, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotIn(List<String> values) {
            addCriterion("COID not in", values, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidBetween(String value1, String value2) {
            addCriterion("COID between", value1, value2, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotBetween(String value1, String value2) {
            addCriterion("COID not between", value1, value2, "coid");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeIsNull() {
            addCriterion("SAP_Factory_Code is null");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeIsNotNull() {
            addCriterion("SAP_Factory_Code is not null");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeEqualTo(String value) {
            addCriterion("SAP_Factory_Code =", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeNotEqualTo(String value) {
            addCriterion("SAP_Factory_Code <>", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeGreaterThan(String value) {
            addCriterion("SAP_Factory_Code >", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SAP_Factory_Code >=", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeLessThan(String value) {
            addCriterion("SAP_Factory_Code <", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeLessThanOrEqualTo(String value) {
            addCriterion("SAP_Factory_Code <=", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeLike(String value) {
            addCriterion("SAP_Factory_Code like", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeNotLike(String value) {
            addCriterion("SAP_Factory_Code not like", value, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeIn(List<String> values) {
            addCriterion("SAP_Factory_Code in", values, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeNotIn(List<String> values) {
            addCriterion("SAP_Factory_Code not in", values, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeBetween(String value1, String value2) {
            addCriterion("SAP_Factory_Code between", value1, value2, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andSapFactoryCodeNotBetween(String value1, String value2) {
            addCriterion("SAP_Factory_Code not between", value1, value2, "sapFactoryCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeIsNull() {
            addCriterion("Card_System_Code is null");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeIsNotNull() {
            addCriterion("Card_System_Code is not null");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeEqualTo(String value) {
            addCriterion("Card_System_Code =", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeNotEqualTo(String value) {
            addCriterion("Card_System_Code <>", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeGreaterThan(String value) {
            addCriterion("Card_System_Code >", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Card_System_Code >=", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeLessThan(String value) {
            addCriterion("Card_System_Code <", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeLessThanOrEqualTo(String value) {
            addCriterion("Card_System_Code <=", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeLike(String value) {
            addCriterion("Card_System_Code like", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeNotLike(String value) {
            addCriterion("Card_System_Code not like", value, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeIn(List<String> values) {
            addCriterion("Card_System_Code in", values, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeNotIn(List<String> values) {
            addCriterion("Card_System_Code not in", values, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeBetween(String value1, String value2) {
            addCriterion("Card_System_Code between", value1, value2, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andCardSystemCodeNotBetween(String value1, String value2) {
            addCriterion("Card_System_Code not between", value1, value2, "cardSystemCode");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidIsNull() {
            addCriterion("Manager_RegionID is null");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidIsNotNull() {
            addCriterion("Manager_RegionID is not null");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidEqualTo(String value) {
            addCriterion("Manager_RegionID =", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidNotEqualTo(String value) {
            addCriterion("Manager_RegionID <>", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidGreaterThan(String value) {
            addCriterion("Manager_RegionID >", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidGreaterThanOrEqualTo(String value) {
            addCriterion("Manager_RegionID >=", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidLessThan(String value) {
            addCriterion("Manager_RegionID <", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidLessThanOrEqualTo(String value) {
            addCriterion("Manager_RegionID <=", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidLike(String value) {
            addCriterion("Manager_RegionID like", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidNotLike(String value) {
            addCriterion("Manager_RegionID not like", value, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidIn(List<String> values) {
            addCriterion("Manager_RegionID in", values, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidNotIn(List<String> values) {
            addCriterion("Manager_RegionID not in", values, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidBetween(String value1, String value2) {
            addCriterion("Manager_RegionID between", value1, value2, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andManagerRegionidNotBetween(String value1, String value2) {
            addCriterion("Manager_RegionID not between", value1, value2, "managerRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidIsNull() {
            addCriterion("Place_RegionID is null");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidIsNotNull() {
            addCriterion("Place_RegionID is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidEqualTo(String value) {
            addCriterion("Place_RegionID =", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidNotEqualTo(String value) {
            addCriterion("Place_RegionID <>", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidGreaterThan(String value) {
            addCriterion("Place_RegionID >", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidGreaterThanOrEqualTo(String value) {
            addCriterion("Place_RegionID >=", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidLessThan(String value) {
            addCriterion("Place_RegionID <", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidLessThanOrEqualTo(String value) {
            addCriterion("Place_RegionID <=", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidLike(String value) {
            addCriterion("Place_RegionID like", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidNotLike(String value) {
            addCriterion("Place_RegionID not like", value, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidIn(List<String> values) {
            addCriterion("Place_RegionID in", values, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidNotIn(List<String> values) {
            addCriterion("Place_RegionID not in", values, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidBetween(String value1, String value2) {
            addCriterion("Place_RegionID between", value1, value2, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPlaceRegionidNotBetween(String value1, String value2) {
            addCriterion("Place_RegionID not between", value1, value2, "placeRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidIsNull() {
            addCriterion("Price_RegionID is null");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidIsNotNull() {
            addCriterion("Price_RegionID is not null");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidEqualTo(String value) {
            addCriterion("Price_RegionID =", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidNotEqualTo(String value) {
            addCriterion("Price_RegionID <>", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidGreaterThan(String value) {
            addCriterion("Price_RegionID >", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidGreaterThanOrEqualTo(String value) {
            addCriterion("Price_RegionID >=", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidLessThan(String value) {
            addCriterion("Price_RegionID <", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidLessThanOrEqualTo(String value) {
            addCriterion("Price_RegionID <=", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidLike(String value) {
            addCriterion("Price_RegionID like", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidNotLike(String value) {
            addCriterion("Price_RegionID not like", value, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidIn(List<String> values) {
            addCriterion("Price_RegionID in", values, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidNotIn(List<String> values) {
            addCriterion("Price_RegionID not in", values, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidBetween(String value1, String value2) {
            addCriterion("Price_RegionID between", value1, value2, "priceRegionid");
            return (Criteria) this;
        }

        public Criteria andPriceRegionidNotBetween(String value1, String value2) {
            addCriterion("Price_RegionID not between", value1, value2, "priceRegionid");
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