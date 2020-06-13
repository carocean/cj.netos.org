package cj.netos.org.model;

import java.util.ArrayList;
import java.util.List;

public class OrgLaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public OrgLaExample() {
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

        public Criteria andCorpNameIsNull() {
            addCriterion("corp_name is null");
            return (Criteria) this;
        }

        public Criteria andCorpNameIsNotNull() {
            addCriterion("corp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCorpNameEqualTo(String value) {
            addCriterion("corp_name =", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotEqualTo(String value) {
            addCriterion("corp_name <>", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThan(String value) {
            addCriterion("corp_name >", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("corp_name >=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThan(String value) {
            addCriterion("corp_name <", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThanOrEqualTo(String value) {
            addCriterion("corp_name <=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLike(String value) {
            addCriterion("corp_name like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotLike(String value) {
            addCriterion("corp_name not like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameIn(List<String> values) {
            addCriterion("corp_name in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotIn(List<String> values) {
            addCriterion("corp_name not in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameBetween(String value1, String value2) {
            addCriterion("corp_name between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotBetween(String value1, String value2) {
            addCriterion("corp_name not between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIsNull() {
            addCriterion("corp_code is null");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIsNotNull() {
            addCriterion("corp_code is not null");
            return (Criteria) this;
        }

        public Criteria andCorpCodeEqualTo(String value) {
            addCriterion("corp_code =", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotEqualTo(String value) {
            addCriterion("corp_code <>", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeGreaterThan(String value) {
            addCriterion("corp_code >", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("corp_code >=", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLessThan(String value) {
            addCriterion("corp_code <", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLessThanOrEqualTo(String value) {
            addCriterion("corp_code <=", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLike(String value) {
            addCriterion("corp_code like", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotLike(String value) {
            addCriterion("corp_code not like", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIn(List<String> values) {
            addCriterion("corp_code in", values, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotIn(List<String> values) {
            addCriterion("corp_code not in", values, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeBetween(String value1, String value2) {
            addCriterion("corp_code between", value1, value2, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotBetween(String value1, String value2) {
            addCriterion("corp_code not between", value1, value2, "corpCode");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcIsNull() {
            addCriterion("licence_src is null");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcIsNotNull() {
            addCriterion("licence_src is not null");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcEqualTo(String value) {
            addCriterion("licence_src =", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcNotEqualTo(String value) {
            addCriterion("licence_src <>", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcGreaterThan(String value) {
            addCriterion("licence_src >", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcGreaterThanOrEqualTo(String value) {
            addCriterion("licence_src >=", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcLessThan(String value) {
            addCriterion("licence_src <", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcLessThanOrEqualTo(String value) {
            addCriterion("licence_src <=", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcLike(String value) {
            addCriterion("licence_src like", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcNotLike(String value) {
            addCriterion("licence_src not like", value, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcIn(List<String> values) {
            addCriterion("licence_src in", values, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcNotIn(List<String> values) {
            addCriterion("licence_src not in", values, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcBetween(String value1, String value2) {
            addCriterion("licence_src between", value1, value2, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andLicenceSrcNotBetween(String value1, String value2) {
            addCriterion("licence_src not between", value1, value2, "licenceSrc");
            return (Criteria) this;
        }

        public Criteria andCorpLogoIsNull() {
            addCriterion("corp_logo is null");
            return (Criteria) this;
        }

        public Criteria andCorpLogoIsNotNull() {
            addCriterion("corp_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCorpLogoEqualTo(String value) {
            addCriterion("corp_logo =", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotEqualTo(String value) {
            addCriterion("corp_logo <>", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoGreaterThan(String value) {
            addCriterion("corp_logo >", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoGreaterThanOrEqualTo(String value) {
            addCriterion("corp_logo >=", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoLessThan(String value) {
            addCriterion("corp_logo <", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoLessThanOrEqualTo(String value) {
            addCriterion("corp_logo <=", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoLike(String value) {
            addCriterion("corp_logo like", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotLike(String value) {
            addCriterion("corp_logo not like", value, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoIn(List<String> values) {
            addCriterion("corp_logo in", values, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotIn(List<String> values) {
            addCriterion("corp_logo not in", values, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoBetween(String value1, String value2) {
            addCriterion("corp_logo between", value1, value2, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andCorpLogoNotBetween(String value1, String value2) {
            addCriterion("corp_logo not between", value1, value2, "corpLogo");
            return (Criteria) this;
        }

        public Criteria andIspIsNull() {
            addCriterion("isp is null");
            return (Criteria) this;
        }

        public Criteria andIspIsNotNull() {
            addCriterion("isp is not null");
            return (Criteria) this;
        }

        public Criteria andIspEqualTo(String value) {
            addCriterion("isp =", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotEqualTo(String value) {
            addCriterion("isp <>", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspGreaterThan(String value) {
            addCriterion("isp >", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspGreaterThanOrEqualTo(String value) {
            addCriterion("isp >=", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLessThan(String value) {
            addCriterion("isp <", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLessThanOrEqualTo(String value) {
            addCriterion("isp <=", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspLike(String value) {
            addCriterion("isp like", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotLike(String value) {
            addCriterion("isp not like", value, "isp");
            return (Criteria) this;
        }

        public Criteria andIspIn(List<String> values) {
            addCriterion("isp in", values, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotIn(List<String> values) {
            addCriterion("isp not in", values, "isp");
            return (Criteria) this;
        }

        public Criteria andIspBetween(String value1, String value2) {
            addCriterion("isp between", value1, value2, "isp");
            return (Criteria) this;
        }

        public Criteria andIspNotBetween(String value1, String value2) {
            addCriterion("isp not between", value1, value2, "isp");
            return (Criteria) this;
        }

        public Criteria andMasterPersonIsNull() {
            addCriterion("master_person is null");
            return (Criteria) this;
        }

        public Criteria andMasterPersonIsNotNull() {
            addCriterion("master_person is not null");
            return (Criteria) this;
        }

        public Criteria andMasterPersonEqualTo(String value) {
            addCriterion("master_person =", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonNotEqualTo(String value) {
            addCriterion("master_person <>", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonGreaterThan(String value) {
            addCriterion("master_person >", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonGreaterThanOrEqualTo(String value) {
            addCriterion("master_person >=", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonLessThan(String value) {
            addCriterion("master_person <", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonLessThanOrEqualTo(String value) {
            addCriterion("master_person <=", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonLike(String value) {
            addCriterion("master_person like", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonNotLike(String value) {
            addCriterion("master_person not like", value, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonIn(List<String> values) {
            addCriterion("master_person in", values, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonNotIn(List<String> values) {
            addCriterion("master_person not in", values, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonBetween(String value1, String value2) {
            addCriterion("master_person between", value1, value2, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterPersonNotBetween(String value1, String value2) {
            addCriterion("master_person not between", value1, value2, "masterPerson");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameIsNull() {
            addCriterion("master_real_name is null");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameIsNotNull() {
            addCriterion("master_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameEqualTo(String value) {
            addCriterion("master_real_name =", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameNotEqualTo(String value) {
            addCriterion("master_real_name <>", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameGreaterThan(String value) {
            addCriterion("master_real_name >", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("master_real_name >=", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameLessThan(String value) {
            addCriterion("master_real_name <", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameLessThanOrEqualTo(String value) {
            addCriterion("master_real_name <=", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameLike(String value) {
            addCriterion("master_real_name like", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameNotLike(String value) {
            addCriterion("master_real_name not like", value, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameIn(List<String> values) {
            addCriterion("master_real_name in", values, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameNotIn(List<String> values) {
            addCriterion("master_real_name not in", values, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameBetween(String value1, String value2) {
            addCriterion("master_real_name between", value1, value2, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterRealNameNotBetween(String value1, String value2) {
            addCriterion("master_real_name not between", value1, value2, "masterRealName");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIsNull() {
            addCriterion("master_phone is null");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIsNotNull() {
            addCriterion("master_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneEqualTo(String value) {
            addCriterion("master_phone =", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotEqualTo(String value) {
            addCriterion("master_phone <>", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneGreaterThan(String value) {
            addCriterion("master_phone >", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("master_phone >=", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLessThan(String value) {
            addCriterion("master_phone <", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLessThanOrEqualTo(String value) {
            addCriterion("master_phone <=", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneLike(String value) {
            addCriterion("master_phone like", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotLike(String value) {
            addCriterion("master_phone not like", value, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneIn(List<String> values) {
            addCriterion("master_phone in", values, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotIn(List<String> values) {
            addCriterion("master_phone not in", values, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneBetween(String value1, String value2) {
            addCriterion("master_phone between", value1, value2, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andMasterPhoneNotBetween(String value1, String value2) {
            addCriterion("master_phone not between", value1, value2, "masterPhone");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("`time` is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("`time` is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("`time` =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("`time` <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("`time` >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("`time` >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("`time` <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("`time` <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("`time` like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("`time` not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("`time` in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("`time` not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("`time` between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("`time` not between", value1, value2, "time");
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