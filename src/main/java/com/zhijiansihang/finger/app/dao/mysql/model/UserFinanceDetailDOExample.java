package com.zhijiansihang.finger.app.dao.mysql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFinanceDetailDOExample {
    /**
     * user_finance_detail
     */
    protected String orderByClause;

    /**
     * user_finance_detail
     */
    protected boolean distinct;

    /**
     * user_finance_detail
     */
    protected List<Criteria> oredCriteria;

    public UserFinanceDetailDOExample() {
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

    /**
     * user_finance_detail null
     */
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andEducationLevelIsNull() {
            addCriterion("education_level is null");
            return (Criteria) this;
        }

        public Criteria andEducationLevelIsNotNull() {
            addCriterion("education_level is not null");
            return (Criteria) this;
        }

        public Criteria andEducationLevelEqualTo(String value) {
            addCriterion("education_level =", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelNotEqualTo(String value) {
            addCriterion("education_level <>", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelGreaterThan(String value) {
            addCriterion("education_level >", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelGreaterThanOrEqualTo(String value) {
            addCriterion("education_level >=", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelLessThan(String value) {
            addCriterion("education_level <", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelLessThanOrEqualTo(String value) {
            addCriterion("education_level <=", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelLike(String value) {
            addCriterion("education_level like", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelNotLike(String value) {
            addCriterion("education_level not like", value, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelIn(List<String> values) {
            addCriterion("education_level in", values, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelNotIn(List<String> values) {
            addCriterion("education_level not in", values, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelBetween(String value1, String value2) {
            addCriterion("education_level between", value1, value2, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andEducationLevelNotBetween(String value1, String value2) {
            addCriterion("education_level not between", value1, value2, "educationLevel");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNull() {
            addCriterion("school_name is null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIsNotNull() {
            addCriterion("school_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolNameEqualTo(String value) {
            addCriterion("school_name =", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotEqualTo(String value) {
            addCriterion("school_name <>", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThan(String value) {
            addCriterion("school_name >", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameGreaterThanOrEqualTo(String value) {
            addCriterion("school_name >=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThan(String value) {
            addCriterion("school_name <", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLessThanOrEqualTo(String value) {
            addCriterion("school_name <=", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameLike(String value) {
            addCriterion("school_name like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotLike(String value) {
            addCriterion("school_name not like", value, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameIn(List<String> values) {
            addCriterion("school_name in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotIn(List<String> values) {
            addCriterion("school_name not in", values, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameBetween(String value1, String value2) {
            addCriterion("school_name between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andSchoolNameNotBetween(String value1, String value2) {
            addCriterion("school_name not between", value1, value2, "schoolName");
            return (Criteria) this;
        }

        public Criteria andWorkAgeIsNull() {
            addCriterion("work_age is null");
            return (Criteria) this;
        }

        public Criteria andWorkAgeIsNotNull() {
            addCriterion("work_age is not null");
            return (Criteria) this;
        }

        public Criteria andWorkAgeEqualTo(Short value) {
            addCriterion("work_age =", value, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeNotEqualTo(Short value) {
            addCriterion("work_age <>", value, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeGreaterThan(Short value) {
            addCriterion("work_age >", value, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeGreaterThanOrEqualTo(Short value) {
            addCriterion("work_age >=", value, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeLessThan(Short value) {
            addCriterion("work_age <", value, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeLessThanOrEqualTo(Short value) {
            addCriterion("work_age <=", value, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeIn(List<Short> values) {
            addCriterion("work_age in", values, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeNotIn(List<Short> values) {
            addCriterion("work_age not in", values, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeBetween(Short value1, Short value2) {
            addCriterion("work_age between", value1, value2, "workAge");
            return (Criteria) this;
        }

        public Criteria andWorkAgeNotBetween(Short value1, Short value2) {
            addCriterion("work_age not between", value1, value2, "workAge");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("`position` is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("`position` is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("`position` =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("`position` <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("`position` >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("`position` >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("`position` <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("`position` <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("`position` like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("`position` not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("`position` in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("`position` not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("`position` between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("`position` not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionIsNull() {
            addCriterion("service_direction is null");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionIsNotNull() {
            addCriterion("service_direction is not null");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionEqualTo(String value) {
            addCriterion("service_direction =", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionNotEqualTo(String value) {
            addCriterion("service_direction <>", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionGreaterThan(String value) {
            addCriterion("service_direction >", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("service_direction >=", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionLessThan(String value) {
            addCriterion("service_direction <", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionLessThanOrEqualTo(String value) {
            addCriterion("service_direction <=", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionLike(String value) {
            addCriterion("service_direction like", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionNotLike(String value) {
            addCriterion("service_direction not like", value, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionIn(List<String> values) {
            addCriterion("service_direction in", values, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionNotIn(List<String> values) {
            addCriterion("service_direction not in", values, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionBetween(String value1, String value2) {
            addCriterion("service_direction between", value1, value2, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceDirectionNotBetween(String value1, String value2) {
            addCriterion("service_direction not between", value1, value2, "serviceDirection");
            return (Criteria) this;
        }

        public Criteria andServiceConceptIsNull() {
            addCriterion("service_concept is null");
            return (Criteria) this;
        }

        public Criteria andServiceConceptIsNotNull() {
            addCriterion("service_concept is not null");
            return (Criteria) this;
        }

        public Criteria andServiceConceptEqualTo(String value) {
            addCriterion("service_concept =", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptNotEqualTo(String value) {
            addCriterion("service_concept <>", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptGreaterThan(String value) {
            addCriterion("service_concept >", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptGreaterThanOrEqualTo(String value) {
            addCriterion("service_concept >=", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptLessThan(String value) {
            addCriterion("service_concept <", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptLessThanOrEqualTo(String value) {
            addCriterion("service_concept <=", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptLike(String value) {
            addCriterion("service_concept like", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptNotLike(String value) {
            addCriterion("service_concept not like", value, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptIn(List<String> values) {
            addCriterion("service_concept in", values, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptNotIn(List<String> values) {
            addCriterion("service_concept not in", values, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptBetween(String value1, String value2) {
            addCriterion("service_concept between", value1, value2, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andServiceConceptNotBetween(String value1, String value2) {
            addCriterion("service_concept not between", value1, value2, "serviceConcept");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceIsNull() {
            addCriterion("working_experience is null");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceIsNotNull() {
            addCriterion("working_experience is not null");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceEqualTo(String value) {
            addCriterion("working_experience =", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceNotEqualTo(String value) {
            addCriterion("working_experience <>", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceGreaterThan(String value) {
            addCriterion("working_experience >", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceGreaterThanOrEqualTo(String value) {
            addCriterion("working_experience >=", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceLessThan(String value) {
            addCriterion("working_experience <", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceLessThanOrEqualTo(String value) {
            addCriterion("working_experience <=", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceLike(String value) {
            addCriterion("working_experience like", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceNotLike(String value) {
            addCriterion("working_experience not like", value, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceIn(List<String> values) {
            addCriterion("working_experience in", values, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceNotIn(List<String> values) {
            addCriterion("working_experience not in", values, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceBetween(String value1, String value2) {
            addCriterion("working_experience between", value1, value2, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andWorkingExperienceNotBetween(String value1, String value2) {
            addCriterion("working_experience not between", value1, value2, "workingExperience");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIsNull() {
            addCriterion("personal_profile is null");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIsNotNull() {
            addCriterion("personal_profile is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileEqualTo(String value) {
            addCriterion("personal_profile =", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotEqualTo(String value) {
            addCriterion("personal_profile <>", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileGreaterThan(String value) {
            addCriterion("personal_profile >", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileGreaterThanOrEqualTo(String value) {
            addCriterion("personal_profile >=", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLessThan(String value) {
            addCriterion("personal_profile <", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLessThanOrEqualTo(String value) {
            addCriterion("personal_profile <=", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileLike(String value) {
            addCriterion("personal_profile like", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotLike(String value) {
            addCriterion("personal_profile not like", value, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileIn(List<String> values) {
            addCriterion("personal_profile in", values, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotIn(List<String> values) {
            addCriterion("personal_profile not in", values, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileBetween(String value1, String value2) {
            addCriterion("personal_profile between", value1, value2, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andPersonalProfileNotBetween(String value1, String value2) {
            addCriterion("personal_profile not between", value1, value2, "personalProfile");
            return (Criteria) this;
        }

        public Criteria andIsAddIsNull() {
            addCriterion("is_add is null");
            return (Criteria) this;
        }

        public Criteria andIsAddIsNotNull() {
            addCriterion("is_add is not null");
            return (Criteria) this;
        }

        public Criteria andIsAddEqualTo(Byte value) {
            addCriterion("is_add =", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotEqualTo(Byte value) {
            addCriterion("is_add <>", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddGreaterThan(Byte value) {
            addCriterion("is_add >", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_add >=", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddLessThan(Byte value) {
            addCriterion("is_add <", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddLessThanOrEqualTo(Byte value) {
            addCriterion("is_add <=", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddIn(List<Byte> values) {
            addCriterion("is_add in", values, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotIn(List<Byte> values) {
            addCriterion("is_add not in", values, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddBetween(Byte value1, Byte value2) {
            addCriterion("is_add between", value1, value2, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotBetween(Byte value1, Byte value2) {
            addCriterion("is_add not between", value1, value2, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andLoanCountIsNull() {
            addCriterion("loan_count is null");
            return (Criteria) this;
        }

        public Criteria andLoanCountIsNotNull() {
            addCriterion("loan_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCountEqualTo(Long value) {
            addCriterion("loan_count =", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotEqualTo(Long value) {
            addCriterion("loan_count <>", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountGreaterThan(Long value) {
            addCriterion("loan_count >", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountGreaterThanOrEqualTo(Long value) {
            addCriterion("loan_count >=", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountLessThan(Long value) {
            addCriterion("loan_count <", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountLessThanOrEqualTo(Long value) {
            addCriterion("loan_count <=", value, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountIn(List<Long> values) {
            addCriterion("loan_count in", values, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotIn(List<Long> values) {
            addCriterion("loan_count not in", values, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountBetween(Long value1, Long value2) {
            addCriterion("loan_count between", value1, value2, "loanCount");
            return (Criteria) this;
        }

        public Criteria andLoanCountNotBetween(Long value1, Long value2) {
            addCriterion("loan_count not between", value1, value2, "loanCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountIsNull() {
            addCriterion("user_order_count is null");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountIsNotNull() {
            addCriterion("user_order_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountEqualTo(Long value) {
            addCriterion("user_order_count =", value, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountNotEqualTo(Long value) {
            addCriterion("user_order_count <>", value, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountGreaterThan(Long value) {
            addCriterion("user_order_count >", value, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountGreaterThanOrEqualTo(Long value) {
            addCriterion("user_order_count >=", value, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountLessThan(Long value) {
            addCriterion("user_order_count <", value, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountLessThanOrEqualTo(Long value) {
            addCriterion("user_order_count <=", value, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountIn(List<Long> values) {
            addCriterion("user_order_count in", values, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountNotIn(List<Long> values) {
            addCriterion("user_order_count not in", values, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountBetween(Long value1, Long value2) {
            addCriterion("user_order_count between", value1, value2, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andUserOrderCountNotBetween(Long value1, Long value2) {
            addCriterion("user_order_count not between", value1, value2, "userOrderCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountIsNull() {
            addCriterion("adopt_count is null");
            return (Criteria) this;
        }

        public Criteria andAdoptCountIsNotNull() {
            addCriterion("adopt_count is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptCountEqualTo(Long value) {
            addCriterion("adopt_count =", value, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountNotEqualTo(Long value) {
            addCriterion("adopt_count <>", value, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountGreaterThan(Long value) {
            addCriterion("adopt_count >", value, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountGreaterThanOrEqualTo(Long value) {
            addCriterion("adopt_count >=", value, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountLessThan(Long value) {
            addCriterion("adopt_count <", value, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountLessThanOrEqualTo(Long value) {
            addCriterion("adopt_count <=", value, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountIn(List<Long> values) {
            addCriterion("adopt_count in", values, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountNotIn(List<Long> values) {
            addCriterion("adopt_count not in", values, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountBetween(Long value1, Long value2) {
            addCriterion("adopt_count between", value1, value2, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andAdoptCountNotBetween(Long value1, Long value2) {
            addCriterion("adopt_count not between", value1, value2, "adoptCount");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * user_finance_detail
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_finance_detail null
     */
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