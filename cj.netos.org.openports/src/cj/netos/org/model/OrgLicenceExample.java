package cj.netos.org.model;

import java.util.ArrayList;
import java.util.List;

public class OrgLicenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public OrgLicenceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodIsNull() {
            addCriterion("operate_period is null");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodIsNotNull() {
            addCriterion("operate_period is not null");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodEqualTo(String value) {
            addCriterion("operate_period =", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodNotEqualTo(String value) {
            addCriterion("operate_period <>", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodGreaterThan(String value) {
            addCriterion("operate_period >", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("operate_period >=", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodLessThan(String value) {
            addCriterion("operate_period <", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodLessThanOrEqualTo(String value) {
            addCriterion("operate_period <=", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodLike(String value) {
            addCriterion("operate_period like", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodNotLike(String value) {
            addCriterion("operate_period not like", value, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodIn(List<String> values) {
            addCriterion("operate_period in", values, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodNotIn(List<String> values) {
            addCriterion("operate_period not in", values, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodBetween(String value1, String value2) {
            addCriterion("operate_period between", value1, value2, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andOperatePeriodNotBetween(String value1, String value2) {
            addCriterion("operate_period not between", value1, value2, "operatePeriod");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Integer value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Integer value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Integer value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Integer value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Integer value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Integer> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Integer> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Integer value1, Integer value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Integer value1, Integer value2) {
            addCriterion("fee not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelIsNull() {
            addCriterion("privilege_level is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelIsNotNull() {
            addCriterion("privilege_level is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelEqualTo(Integer value) {
            addCriterion("privilege_level =", value, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelNotEqualTo(Integer value) {
            addCriterion("privilege_level <>", value, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelGreaterThan(Integer value) {
            addCriterion("privilege_level >", value, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("privilege_level >=", value, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelLessThan(Integer value) {
            addCriterion("privilege_level <", value, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelLessThanOrEqualTo(Integer value) {
            addCriterion("privilege_level <=", value, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelIn(List<Integer> values) {
            addCriterion("privilege_level in", values, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelNotIn(List<Integer> values) {
            addCriterion("privilege_level not in", values, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelBetween(Integer value1, Integer value2) {
            addCriterion("privilege_level between", value1, value2, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andPrivilegeLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("privilege_level not between", value1, value2, "privilegeLevel");
            return (Criteria) this;
        }

        public Criteria andBussinessScopIsNull() {
            addCriterion("bussiness_scop is null");
            return (Criteria) this;
        }

        public Criteria andBussinessScopIsNotNull() {
            addCriterion("bussiness_scop is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessScopEqualTo(String value) {
            addCriterion("bussiness_scop =", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopNotEqualTo(String value) {
            addCriterion("bussiness_scop <>", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopGreaterThan(String value) {
            addCriterion("bussiness_scop >", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopGreaterThanOrEqualTo(String value) {
            addCriterion("bussiness_scop >=", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopLessThan(String value) {
            addCriterion("bussiness_scop <", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopLessThanOrEqualTo(String value) {
            addCriterion("bussiness_scop <=", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopLike(String value) {
            addCriterion("bussiness_scop like", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopNotLike(String value) {
            addCriterion("bussiness_scop not like", value, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopIn(List<String> values) {
            addCriterion("bussiness_scop in", values, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopNotIn(List<String> values) {
            addCriterion("bussiness_scop not in", values, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopBetween(String value1, String value2) {
            addCriterion("bussiness_scop between", value1, value2, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessScopNotBetween(String value1, String value2) {
            addCriterion("bussiness_scop not between", value1, value2, "bussinessScop");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleIsNull() {
            addCriterion("bussiness_area_title is null");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleIsNotNull() {
            addCriterion("bussiness_area_title is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleEqualTo(String value) {
            addCriterion("bussiness_area_title =", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleNotEqualTo(String value) {
            addCriterion("bussiness_area_title <>", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleGreaterThan(String value) {
            addCriterion("bussiness_area_title >", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bussiness_area_title >=", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleLessThan(String value) {
            addCriterion("bussiness_area_title <", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleLessThanOrEqualTo(String value) {
            addCriterion("bussiness_area_title <=", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleLike(String value) {
            addCriterion("bussiness_area_title like", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleNotLike(String value) {
            addCriterion("bussiness_area_title not like", value, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleIn(List<String> values) {
            addCriterion("bussiness_area_title in", values, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleNotIn(List<String> values) {
            addCriterion("bussiness_area_title not in", values, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleBetween(String value1, String value2) {
            addCriterion("bussiness_area_title between", value1, value2, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaTitleNotBetween(String value1, String value2) {
            addCriterion("bussiness_area_title not between", value1, value2, "bussinessAreaTitle");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeIsNull() {
            addCriterion("bussiness_area_code is null");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeIsNotNull() {
            addCriterion("bussiness_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeEqualTo(String value) {
            addCriterion("bussiness_area_code =", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeNotEqualTo(String value) {
            addCriterion("bussiness_area_code <>", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeGreaterThan(String value) {
            addCriterion("bussiness_area_code >", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bussiness_area_code >=", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeLessThan(String value) {
            addCriterion("bussiness_area_code <", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("bussiness_area_code <=", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeLike(String value) {
            addCriterion("bussiness_area_code like", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeNotLike(String value) {
            addCriterion("bussiness_area_code not like", value, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeIn(List<String> values) {
            addCriterion("bussiness_area_code in", values, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeNotIn(List<String> values) {
            addCriterion("bussiness_area_code not in", values, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeBetween(String value1, String value2) {
            addCriterion("bussiness_area_code between", value1, value2, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andBussinessAreaCodeNotBetween(String value1, String value2) {
            addCriterion("bussiness_area_code not between", value1, value2, "bussinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andOrganIsNull() {
            addCriterion("organ is null");
            return (Criteria) this;
        }

        public Criteria andOrganIsNotNull() {
            addCriterion("organ is not null");
            return (Criteria) this;
        }

        public Criteria andOrganEqualTo(String value) {
            addCriterion("organ =", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganNotEqualTo(String value) {
            addCriterion("organ <>", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganGreaterThan(String value) {
            addCriterion("organ >", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganGreaterThanOrEqualTo(String value) {
            addCriterion("organ >=", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganLessThan(String value) {
            addCriterion("organ <", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganLessThanOrEqualTo(String value) {
            addCriterion("organ <=", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganLike(String value) {
            addCriterion("organ like", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganNotLike(String value) {
            addCriterion("organ not like", value, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganIn(List<String> values) {
            addCriterion("organ in", values, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganNotIn(List<String> values) {
            addCriterion("organ not in", values, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganBetween(String value1, String value2) {
            addCriterion("organ between", value1, value2, "organ");
            return (Criteria) this;
        }

        public Criteria andOrganNotBetween(String value1, String value2) {
            addCriterion("organ not between", value1, value2, "organ");
            return (Criteria) this;
        }

        public Criteria andSignTextIsNull() {
            addCriterion("sign_text is null");
            return (Criteria) this;
        }

        public Criteria andSignTextIsNotNull() {
            addCriterion("sign_text is not null");
            return (Criteria) this;
        }

        public Criteria andSignTextEqualTo(String value) {
            addCriterion("sign_text =", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextNotEqualTo(String value) {
            addCriterion("sign_text <>", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextGreaterThan(String value) {
            addCriterion("sign_text >", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextGreaterThanOrEqualTo(String value) {
            addCriterion("sign_text >=", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextLessThan(String value) {
            addCriterion("sign_text <", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextLessThanOrEqualTo(String value) {
            addCriterion("sign_text <=", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextLike(String value) {
            addCriterion("sign_text like", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextNotLike(String value) {
            addCriterion("sign_text not like", value, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextIn(List<String> values) {
            addCriterion("sign_text in", values, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextNotIn(List<String> values) {
            addCriterion("sign_text not in", values, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextBetween(String value1, String value2) {
            addCriterion("sign_text between", value1, value2, "signText");
            return (Criteria) this;
        }

        public Criteria andSignTextNotBetween(String value1, String value2) {
            addCriterion("sign_text not between", value1, value2, "signText");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(String value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(String value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(String value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(String value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(String value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLike(String value) {
            addCriterion("pub_time like", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotLike(String value) {
            addCriterion("pub_time not like", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<String> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<String> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(String value1, String value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(String value1, String value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("end_time like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("end_time not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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