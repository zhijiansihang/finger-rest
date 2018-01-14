package com.shawn.finger.dao.mysql.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanDOExample {
    /**
     * loan
     */
    protected String orderByClause;

    /**
     * loan
     */
    protected boolean distinct;

    /**
     * loan
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public LoanDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * loan null
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

        public Criteria andLoanIdIsNull() {
            addCriterion("loan_id is null");
            return (Criteria) this;
        }

        public Criteria andLoanIdIsNotNull() {
            addCriterion("loan_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoanIdEqualTo(Long value) {
            addCriterion("loan_id =", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotEqualTo(Long value) {
            addCriterion("loan_id <>", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdGreaterThan(Long value) {
            addCriterion("loan_id >", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("loan_id >=", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdLessThan(Long value) {
            addCriterion("loan_id <", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdLessThanOrEqualTo(Long value) {
            addCriterion("loan_id <=", value, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdIn(List<Long> values) {
            addCriterion("loan_id in", values, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotIn(List<Long> values) {
            addCriterion("loan_id not in", values, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdBetween(Long value1, Long value2) {
            addCriterion("loan_id between", value1, value2, "loanId");
            return (Criteria) this;
        }

        public Criteria andLoanIdNotBetween(Long value1, Long value2) {
            addCriterion("loan_id not between", value1, value2, "loanId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdIsNull() {
            addCriterion("institution_user_id is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdIsNotNull() {
            addCriterion("institution_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdEqualTo(Long value) {
            addCriterion("institution_user_id =", value, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdNotEqualTo(Long value) {
            addCriterion("institution_user_id <>", value, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdGreaterThan(Long value) {
            addCriterion("institution_user_id >", value, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("institution_user_id >=", value, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdLessThan(Long value) {
            addCriterion("institution_user_id <", value, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdLessThanOrEqualTo(Long value) {
            addCriterion("institution_user_id <=", value, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdIn(List<Long> values) {
            addCriterion("institution_user_id in", values, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdNotIn(List<Long> values) {
            addCriterion("institution_user_id not in", values, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdBetween(Long value1, Long value2) {
            addCriterion("institution_user_id between", value1, value2, "institutionUserId");
            return (Criteria) this;
        }

        public Criteria andInstitutionUserIdNotBetween(Long value1, Long value2) {
            addCriterion("institution_user_id not between", value1, value2, "institutionUserId");
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

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(Byte value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(Byte value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(Byte value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(Byte value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(Byte value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<Byte> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<Byte> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(Byte value1, Byte value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(Short value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(Short value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(Short value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(Short value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(Short value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<Short> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<Short> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(Short value1, Short value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(Short value1, Short value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNull() {
            addCriterion("reserve_amount is null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNotNull() {
            addCriterion("reserve_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountEqualTo(BigDecimal value) {
            addCriterion("reserve_amount =", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotEqualTo(BigDecimal value) {
            addCriterion("reserve_amount <>", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThan(BigDecimal value) {
            addCriterion("reserve_amount >", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_amount >=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThan(BigDecimal value) {
            addCriterion("reserve_amount <", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_amount <=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIn(List<BigDecimal> values) {
            addCriterion("reserve_amount in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotIn(List<BigDecimal> values) {
            addCriterion("reserve_amount not in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_amount between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_amount not between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andLoanStatusIsNull() {
            addCriterion("loan_status is null");
            return (Criteria) this;
        }

        public Criteria andLoanStatusIsNotNull() {
            addCriterion("loan_status is not null");
            return (Criteria) this;
        }

        public Criteria andLoanStatusEqualTo(Short value) {
            addCriterion("loan_status =", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusNotEqualTo(Short value) {
            addCriterion("loan_status <>", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusGreaterThan(Short value) {
            addCriterion("loan_status >", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("loan_status >=", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusLessThan(Short value) {
            addCriterion("loan_status <", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusLessThanOrEqualTo(Short value) {
            addCriterion("loan_status <=", value, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusIn(List<Short> values) {
            addCriterion("loan_status in", values, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusNotIn(List<Short> values) {
            addCriterion("loan_status not in", values, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusBetween(Short value1, Short value2) {
            addCriterion("loan_status between", value1, value2, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andLoanStatusNotBetween(Short value1, Short value2) {
            addCriterion("loan_status not between", value1, value2, "loanStatus");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIsNull() {
            addCriterion("is_display is null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIsNotNull() {
            addCriterion("is_display is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayEqualTo(Byte value) {
            addCriterion("is_display =", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotEqualTo(Byte value) {
            addCriterion("is_display <>", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayGreaterThan(Byte value) {
            addCriterion("is_display >", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_display >=", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLessThan(Byte value) {
            addCriterion("is_display <", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayLessThanOrEqualTo(Byte value) {
            addCriterion("is_display <=", value, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayIn(List<Byte> values) {
            addCriterion("is_display in", values, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotIn(List<Byte> values) {
            addCriterion("is_display not in", values, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayBetween(Byte value1, Byte value2) {
            addCriterion("is_display between", value1, value2, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andIsDisplayNotBetween(Byte value1, Byte value2) {
            addCriterion("is_display not between", value1, value2, "isDisplay");
            return (Criteria) this;
        }

        public Criteria andLocationSizeIsNull() {
            addCriterion("location_size is null");
            return (Criteria) this;
        }

        public Criteria andLocationSizeIsNotNull() {
            addCriterion("location_size is not null");
            return (Criteria) this;
        }

        public Criteria andLocationSizeEqualTo(Integer value) {
            addCriterion("location_size =", value, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeNotEqualTo(Integer value) {
            addCriterion("location_size <>", value, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeGreaterThan(Integer value) {
            addCriterion("location_size >", value, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_size >=", value, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeLessThan(Integer value) {
            addCriterion("location_size <", value, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeLessThanOrEqualTo(Integer value) {
            addCriterion("location_size <=", value, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeIn(List<Integer> values) {
            addCriterion("location_size in", values, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeNotIn(List<Integer> values) {
            addCriterion("location_size not in", values, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeBetween(Integer value1, Integer value2) {
            addCriterion("location_size between", value1, value2, "locationSize");
            return (Criteria) this;
        }

        public Criteria andLocationSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("location_size not between", value1, value2, "locationSize");
            return (Criteria) this;
        }

        public Criteria andProductDirectionIsNull() {
            addCriterion("product_direction is null");
            return (Criteria) this;
        }

        public Criteria andProductDirectionIsNotNull() {
            addCriterion("product_direction is not null");
            return (Criteria) this;
        }

        public Criteria andProductDirectionEqualTo(String value) {
            addCriterion("product_direction =", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionNotEqualTo(String value) {
            addCriterion("product_direction <>", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionGreaterThan(String value) {
            addCriterion("product_direction >", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("product_direction >=", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionLessThan(String value) {
            addCriterion("product_direction <", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionLessThanOrEqualTo(String value) {
            addCriterion("product_direction <=", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionLike(String value) {
            addCriterion("product_direction like", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionNotLike(String value) {
            addCriterion("product_direction not like", value, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionIn(List<String> values) {
            addCriterion("product_direction in", values, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionNotIn(List<String> values) {
            addCriterion("product_direction not in", values, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionBetween(String value1, String value2) {
            addCriterion("product_direction between", value1, value2, "productDirection");
            return (Criteria) this;
        }

        public Criteria andProductDirectionNotBetween(String value1, String value2) {
            addCriterion("product_direction not between", value1, value2, "productDirection");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayIsNull() {
            addCriterion("safeguard_way is null");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayIsNotNull() {
            addCriterion("safeguard_way is not null");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayEqualTo(String value) {
            addCriterion("safeguard_way =", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayNotEqualTo(String value) {
            addCriterion("safeguard_way <>", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayGreaterThan(String value) {
            addCriterion("safeguard_way >", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayGreaterThanOrEqualTo(String value) {
            addCriterion("safeguard_way >=", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayLessThan(String value) {
            addCriterion("safeguard_way <", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayLessThanOrEqualTo(String value) {
            addCriterion("safeguard_way <=", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayLike(String value) {
            addCriterion("safeguard_way like", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayNotLike(String value) {
            addCriterion("safeguard_way not like", value, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayIn(List<String> values) {
            addCriterion("safeguard_way in", values, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayNotIn(List<String> values) {
            addCriterion("safeguard_way not in", values, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayBetween(String value1, String value2) {
            addCriterion("safeguard_way between", value1, value2, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andSafeguardWayNotBetween(String value1, String value2) {
            addCriterion("safeguard_way not between", value1, value2, "safeguardWay");
            return (Criteria) this;
        }

        public Criteria andBeginAmountIsNull() {
            addCriterion("begin_amount is null");
            return (Criteria) this;
        }

        public Criteria andBeginAmountIsNotNull() {
            addCriterion("begin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBeginAmountEqualTo(BigDecimal value) {
            addCriterion("begin_amount =", value, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountNotEqualTo(BigDecimal value) {
            addCriterion("begin_amount <>", value, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountGreaterThan(BigDecimal value) {
            addCriterion("begin_amount >", value, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_amount >=", value, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountLessThan(BigDecimal value) {
            addCriterion("begin_amount <", value, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("begin_amount <=", value, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountIn(List<BigDecimal> values) {
            addCriterion("begin_amount in", values, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountNotIn(List<BigDecimal> values) {
            addCriterion("begin_amount not in", values, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_amount between", value1, value2, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andBeginAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("begin_amount not between", value1, value2, "beginAmount");
            return (Criteria) this;
        }

        public Criteria andEarningDescIsNull() {
            addCriterion("earning_desc is null");
            return (Criteria) this;
        }

        public Criteria andEarningDescIsNotNull() {
            addCriterion("earning_desc is not null");
            return (Criteria) this;
        }

        public Criteria andEarningDescEqualTo(String value) {
            addCriterion("earning_desc =", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescNotEqualTo(String value) {
            addCriterion("earning_desc <>", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescGreaterThan(String value) {
            addCriterion("earning_desc >", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescGreaterThanOrEqualTo(String value) {
            addCriterion("earning_desc >=", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescLessThan(String value) {
            addCriterion("earning_desc <", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescLessThanOrEqualTo(String value) {
            addCriterion("earning_desc <=", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescLike(String value) {
            addCriterion("earning_desc like", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescNotLike(String value) {
            addCriterion("earning_desc not like", value, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescIn(List<String> values) {
            addCriterion("earning_desc in", values, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescNotIn(List<String> values) {
            addCriterion("earning_desc not in", values, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescBetween(String value1, String value2) {
            addCriterion("earning_desc between", value1, value2, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andEarningDescNotBetween(String value1, String value2) {
            addCriterion("earning_desc not between", value1, value2, "earningDesc");
            return (Criteria) this;
        }

        public Criteria andIssuerIsNull() {
            addCriterion("issuer is null");
            return (Criteria) this;
        }

        public Criteria andIssuerIsNotNull() {
            addCriterion("issuer is not null");
            return (Criteria) this;
        }

        public Criteria andIssuerEqualTo(String value) {
            addCriterion("issuer =", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotEqualTo(String value) {
            addCriterion("issuer <>", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerGreaterThan(String value) {
            addCriterion("issuer >", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerGreaterThanOrEqualTo(String value) {
            addCriterion("issuer >=", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerLessThan(String value) {
            addCriterion("issuer <", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerLessThanOrEqualTo(String value) {
            addCriterion("issuer <=", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerLike(String value) {
            addCriterion("issuer like", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotLike(String value) {
            addCriterion("issuer not like", value, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerIn(List<String> values) {
            addCriterion("issuer in", values, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotIn(List<String> values) {
            addCriterion("issuer not in", values, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerBetween(String value1, String value2) {
            addCriterion("issuer between", value1, value2, "issuer");
            return (Criteria) this;
        }

        public Criteria andIssuerNotBetween(String value1, String value2) {
            addCriterion("issuer not between", value1, value2, "issuer");
            return (Criteria) this;
        }

        public Criteria andFundTypeIsNull() {
            addCriterion("fund_type is null");
            return (Criteria) this;
        }

        public Criteria andFundTypeIsNotNull() {
            addCriterion("fund_type is not null");
            return (Criteria) this;
        }

        public Criteria andFundTypeEqualTo(Short value) {
            addCriterion("fund_type =", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotEqualTo(Short value) {
            addCriterion("fund_type <>", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeGreaterThan(Short value) {
            addCriterion("fund_type >", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("fund_type >=", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLessThan(Short value) {
            addCriterion("fund_type <", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeLessThanOrEqualTo(Short value) {
            addCriterion("fund_type <=", value, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeIn(List<Short> values) {
            addCriterion("fund_type in", values, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotIn(List<Short> values) {
            addCriterion("fund_type not in", values, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeBetween(Short value1, Short value2) {
            addCriterion("fund_type between", value1, value2, "fundType");
            return (Criteria) this;
        }

        public Criteria andFundTypeNotBetween(Short value1, Short value2) {
            addCriterion("fund_type not between", value1, value2, "fundType");
            return (Criteria) this;
        }

        public Criteria andServicingWayIsNull() {
            addCriterion("servicing_way is null");
            return (Criteria) this;
        }

        public Criteria andServicingWayIsNotNull() {
            addCriterion("servicing_way is not null");
            return (Criteria) this;
        }

        public Criteria andServicingWayEqualTo(Short value) {
            addCriterion("servicing_way =", value, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayNotEqualTo(Short value) {
            addCriterion("servicing_way <>", value, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayGreaterThan(Short value) {
            addCriterion("servicing_way >", value, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayGreaterThanOrEqualTo(Short value) {
            addCriterion("servicing_way >=", value, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayLessThan(Short value) {
            addCriterion("servicing_way <", value, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayLessThanOrEqualTo(Short value) {
            addCriterion("servicing_way <=", value, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayIn(List<Short> values) {
            addCriterion("servicing_way in", values, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayNotIn(List<Short> values) {
            addCriterion("servicing_way not in", values, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayBetween(Short value1, Short value2) {
            addCriterion("servicing_way between", value1, value2, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andServicingWayNotBetween(Short value1, Short value2) {
            addCriterion("servicing_way not between", value1, value2, "servicingWay");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineIsNull() {
            addCriterion("adaptation_deadline is null");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineIsNotNull() {
            addCriterion("adaptation_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineEqualTo(Short value) {
            addCriterion("adaptation_deadline =", value, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineNotEqualTo(Short value) {
            addCriterion("adaptation_deadline <>", value, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineGreaterThan(Short value) {
            addCriterion("adaptation_deadline >", value, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineGreaterThanOrEqualTo(Short value) {
            addCriterion("adaptation_deadline >=", value, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineLessThan(Short value) {
            addCriterion("adaptation_deadline <", value, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineLessThanOrEqualTo(Short value) {
            addCriterion("adaptation_deadline <=", value, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineIn(List<Short> values) {
            addCriterion("adaptation_deadline in", values, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineNotIn(List<Short> values) {
            addCriterion("adaptation_deadline not in", values, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineBetween(Short value1, Short value2) {
            addCriterion("adaptation_deadline between", value1, value2, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andAdaptationDeadlineNotBetween(Short value1, Short value2) {
            addCriterion("adaptation_deadline not between", value1, value2, "adaptationDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineIsNull() {
            addCriterion("investment_deadline is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineIsNotNull() {
            addCriterion("investment_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineEqualTo(Short value) {
            addCriterion("investment_deadline =", value, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineNotEqualTo(Short value) {
            addCriterion("investment_deadline <>", value, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineGreaterThan(Short value) {
            addCriterion("investment_deadline >", value, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineGreaterThanOrEqualTo(Short value) {
            addCriterion("investment_deadline >=", value, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineLessThan(Short value) {
            addCriterion("investment_deadline <", value, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineLessThanOrEqualTo(Short value) {
            addCriterion("investment_deadline <=", value, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineIn(List<Short> values) {
            addCriterion("investment_deadline in", values, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineNotIn(List<Short> values) {
            addCriterion("investment_deadline not in", values, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineBetween(Short value1, Short value2) {
            addCriterion("investment_deadline between", value1, value2, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andInvestmentDeadlineNotBetween(Short value1, Short value2) {
            addCriterion("investment_deadline not between", value1, value2, "investmentDeadline");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionIsNull() {
            addCriterion("distribution_region is null");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionIsNotNull() {
            addCriterion("distribution_region is not null");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionEqualTo(String value) {
            addCriterion("distribution_region =", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionNotEqualTo(String value) {
            addCriterion("distribution_region <>", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionGreaterThan(String value) {
            addCriterion("distribution_region >", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionGreaterThanOrEqualTo(String value) {
            addCriterion("distribution_region >=", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionLessThan(String value) {
            addCriterion("distribution_region <", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionLessThanOrEqualTo(String value) {
            addCriterion("distribution_region <=", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionLike(String value) {
            addCriterion("distribution_region like", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionNotLike(String value) {
            addCriterion("distribution_region not like", value, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionIn(List<String> values) {
            addCriterion("distribution_region in", values, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionNotIn(List<String> values) {
            addCriterion("distribution_region not in", values, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionBetween(String value1, String value2) {
            addCriterion("distribution_region between", value1, value2, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andDistributionRegionNotBetween(String value1, String value2) {
            addCriterion("distribution_region not between", value1, value2, "distributionRegion");
            return (Criteria) this;
        }

        public Criteria andRatioTypeIsNull() {
            addCriterion("ratio_type is null");
            return (Criteria) this;
        }

        public Criteria andRatioTypeIsNotNull() {
            addCriterion("ratio_type is not null");
            return (Criteria) this;
        }

        public Criteria andRatioTypeEqualTo(Short value) {
            addCriterion("ratio_type =", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeNotEqualTo(Short value) {
            addCriterion("ratio_type <>", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeGreaterThan(Short value) {
            addCriterion("ratio_type >", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ratio_type >=", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeLessThan(Short value) {
            addCriterion("ratio_type <", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeLessThanOrEqualTo(Short value) {
            addCriterion("ratio_type <=", value, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeIn(List<Short> values) {
            addCriterion("ratio_type in", values, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeNotIn(List<Short> values) {
            addCriterion("ratio_type not in", values, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeBetween(Short value1, Short value2) {
            addCriterion("ratio_type between", value1, value2, "ratioType");
            return (Criteria) this;
        }

        public Criteria andRatioTypeNotBetween(Short value1, Short value2) {
            addCriterion("ratio_type not between", value1, value2, "ratioType");
            return (Criteria) this;
        }

        public Criteria andBrightSpotIsNull() {
            addCriterion("bright_spot is null");
            return (Criteria) this;
        }

        public Criteria andBrightSpotIsNotNull() {
            addCriterion("bright_spot is not null");
            return (Criteria) this;
        }

        public Criteria andBrightSpotEqualTo(String value) {
            addCriterion("bright_spot =", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotNotEqualTo(String value) {
            addCriterion("bright_spot <>", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotGreaterThan(String value) {
            addCriterion("bright_spot >", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotGreaterThanOrEqualTo(String value) {
            addCriterion("bright_spot >=", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotLessThan(String value) {
            addCriterion("bright_spot <", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotLessThanOrEqualTo(String value) {
            addCriterion("bright_spot <=", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotLike(String value) {
            addCriterion("bright_spot like", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotNotLike(String value) {
            addCriterion("bright_spot not like", value, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotIn(List<String> values) {
            addCriterion("bright_spot in", values, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotNotIn(List<String> values) {
            addCriterion("bright_spot not in", values, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotBetween(String value1, String value2) {
            addCriterion("bright_spot between", value1, value2, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andBrightSpotNotBetween(String value1, String value2) {
            addCriterion("bright_spot not between", value1, value2, "brightSpot");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceIsNull() {
            addCriterion("finance_introduce is null");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceIsNotNull() {
            addCriterion("finance_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceEqualTo(String value) {
            addCriterion("finance_introduce =", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceNotEqualTo(String value) {
            addCriterion("finance_introduce <>", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceGreaterThan(String value) {
            addCriterion("finance_introduce >", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("finance_introduce >=", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceLessThan(String value) {
            addCriterion("finance_introduce <", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceLessThanOrEqualTo(String value) {
            addCriterion("finance_introduce <=", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceLike(String value) {
            addCriterion("finance_introduce like", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceNotLike(String value) {
            addCriterion("finance_introduce not like", value, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceIn(List<String> values) {
            addCriterion("finance_introduce in", values, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceNotIn(List<String> values) {
            addCriterion("finance_introduce not in", values, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceBetween(String value1, String value2) {
            addCriterion("finance_introduce between", value1, value2, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andFinanceIntroduceNotBetween(String value1, String value2) {
            addCriterion("finance_introduce not between", value1, value2, "financeIntroduce");
            return (Criteria) this;
        }

        public Criteria andMoneyUseIsNull() {
            addCriterion("money_use is null");
            return (Criteria) this;
        }

        public Criteria andMoneyUseIsNotNull() {
            addCriterion("money_use is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyUseEqualTo(String value) {
            addCriterion("money_use =", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseNotEqualTo(String value) {
            addCriterion("money_use <>", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseGreaterThan(String value) {
            addCriterion("money_use >", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseGreaterThanOrEqualTo(String value) {
            addCriterion("money_use >=", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseLessThan(String value) {
            addCriterion("money_use <", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseLessThanOrEqualTo(String value) {
            addCriterion("money_use <=", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseLike(String value) {
            addCriterion("money_use like", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseNotLike(String value) {
            addCriterion("money_use not like", value, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseIn(List<String> values) {
            addCriterion("money_use in", values, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseNotIn(List<String> values) {
            addCriterion("money_use not in", values, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseBetween(String value1, String value2) {
            addCriterion("money_use between", value1, value2, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andMoneyUseNotBetween(String value1, String value2) {
            addCriterion("money_use not between", value1, value2, "moneyUse");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIsNull() {
            addCriterion("repay_source is null");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIsNotNull() {
            addCriterion("repay_source is not null");
            return (Criteria) this;
        }

        public Criteria andRepaySourceEqualTo(String value) {
            addCriterion("repay_source =", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotEqualTo(String value) {
            addCriterion("repay_source <>", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceGreaterThan(String value) {
            addCriterion("repay_source >", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceGreaterThanOrEqualTo(String value) {
            addCriterion("repay_source >=", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLessThan(String value) {
            addCriterion("repay_source <", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLessThanOrEqualTo(String value) {
            addCriterion("repay_source <=", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceLike(String value) {
            addCriterion("repay_source like", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotLike(String value) {
            addCriterion("repay_source not like", value, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceIn(List<String> values) {
            addCriterion("repay_source in", values, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotIn(List<String> values) {
            addCriterion("repay_source not in", values, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceBetween(String value1, String value2) {
            addCriterion("repay_source between", value1, value2, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRepaySourceNotBetween(String value1, String value2) {
            addCriterion("repay_source not between", value1, value2, "repaySource");
            return (Criteria) this;
        }

        public Criteria andRiskControlIsNull() {
            addCriterion("risk_control is null");
            return (Criteria) this;
        }

        public Criteria andRiskControlIsNotNull() {
            addCriterion("risk_control is not null");
            return (Criteria) this;
        }

        public Criteria andRiskControlEqualTo(String value) {
            addCriterion("risk_control =", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlNotEqualTo(String value) {
            addCriterion("risk_control <>", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlGreaterThan(String value) {
            addCriterion("risk_control >", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlGreaterThanOrEqualTo(String value) {
            addCriterion("risk_control >=", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlLessThan(String value) {
            addCriterion("risk_control <", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlLessThanOrEqualTo(String value) {
            addCriterion("risk_control <=", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlLike(String value) {
            addCriterion("risk_control like", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlNotLike(String value) {
            addCriterion("risk_control not like", value, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlIn(List<String> values) {
            addCriterion("risk_control in", values, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlNotIn(List<String> values) {
            addCriterion("risk_control not in", values, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlBetween(String value1, String value2) {
            addCriterion("risk_control between", value1, value2, "riskControl");
            return (Criteria) this;
        }

        public Criteria andRiskControlNotBetween(String value1, String value2) {
            addCriterion("risk_control not between", value1, value2, "riskControl");
            return (Criteria) this;
        }

        public Criteria andProductDescIsNull() {
            addCriterion("product_desc is null");
            return (Criteria) this;
        }

        public Criteria andProductDescIsNotNull() {
            addCriterion("product_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescEqualTo(String value) {
            addCriterion("product_desc =", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotEqualTo(String value) {
            addCriterion("product_desc <>", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescGreaterThan(String value) {
            addCriterion("product_desc >", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescGreaterThanOrEqualTo(String value) {
            addCriterion("product_desc >=", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLessThan(String value) {
            addCriterion("product_desc <", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLessThanOrEqualTo(String value) {
            addCriterion("product_desc <=", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLike(String value) {
            addCriterion("product_desc like", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotLike(String value) {
            addCriterion("product_desc not like", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescIn(List<String> values) {
            addCriterion("product_desc in", values, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotIn(List<String> values) {
            addCriterion("product_desc not in", values, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescBetween(String value1, String value2) {
            addCriterion("product_desc between", value1, value2, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotBetween(String value1, String value2) {
            addCriterion("product_desc not between", value1, value2, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesIsNull() {
            addCriterion("product_desc_files is null");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesIsNotNull() {
            addCriterion("product_desc_files is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesEqualTo(String value) {
            addCriterion("product_desc_files =", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesNotEqualTo(String value) {
            addCriterion("product_desc_files <>", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesGreaterThan(String value) {
            addCriterion("product_desc_files >", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesGreaterThanOrEqualTo(String value) {
            addCriterion("product_desc_files >=", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesLessThan(String value) {
            addCriterion("product_desc_files <", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesLessThanOrEqualTo(String value) {
            addCriterion("product_desc_files <=", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesLike(String value) {
            addCriterion("product_desc_files like", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesNotLike(String value) {
            addCriterion("product_desc_files not like", value, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesIn(List<String> values) {
            addCriterion("product_desc_files in", values, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesNotIn(List<String> values) {
            addCriterion("product_desc_files not in", values, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesBetween(String value1, String value2) {
            addCriterion("product_desc_files between", value1, value2, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andProductDescFilesNotBetween(String value1, String value2) {
            addCriterion("product_desc_files not between", value1, value2, "productDescFiles");
            return (Criteria) this;
        }

        public Criteria andRiskAlertIsNull() {
            addCriterion("risk_alert is null");
            return (Criteria) this;
        }

        public Criteria andRiskAlertIsNotNull() {
            addCriterion("risk_alert is not null");
            return (Criteria) this;
        }

        public Criteria andRiskAlertEqualTo(String value) {
            addCriterion("risk_alert =", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertNotEqualTo(String value) {
            addCriterion("risk_alert <>", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertGreaterThan(String value) {
            addCriterion("risk_alert >", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertGreaterThanOrEqualTo(String value) {
            addCriterion("risk_alert >=", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertLessThan(String value) {
            addCriterion("risk_alert <", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertLessThanOrEqualTo(String value) {
            addCriterion("risk_alert <=", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertLike(String value) {
            addCriterion("risk_alert like", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertNotLike(String value) {
            addCriterion("risk_alert not like", value, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertIn(List<String> values) {
            addCriterion("risk_alert in", values, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertNotIn(List<String> values) {
            addCriterion("risk_alert not in", values, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertBetween(String value1, String value2) {
            addCriterion("risk_alert between", value1, value2, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andRiskAlertNotBetween(String value1, String value2) {
            addCriterion("risk_alert not between", value1, value2, "riskAlert");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeIsNull() {
            addCriterion("capital_type is null");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeIsNotNull() {
            addCriterion("capital_type is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeEqualTo(String value) {
            addCriterion("capital_type =", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeNotEqualTo(String value) {
            addCriterion("capital_type <>", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeGreaterThan(String value) {
            addCriterion("capital_type >", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeGreaterThanOrEqualTo(String value) {
            addCriterion("capital_type >=", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeLessThan(String value) {
            addCriterion("capital_type <", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeLessThanOrEqualTo(String value) {
            addCriterion("capital_type <=", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeLike(String value) {
            addCriterion("capital_type like", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeNotLike(String value) {
            addCriterion("capital_type not like", value, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeIn(List<String> values) {
            addCriterion("capital_type in", values, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeNotIn(List<String> values) {
            addCriterion("capital_type not in", values, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeBetween(String value1, String value2) {
            addCriterion("capital_type between", value1, value2, "capitalType");
            return (Criteria) this;
        }

        public Criteria andCapitalTypeNotBetween(String value1, String value2) {
            addCriterion("capital_type not between", value1, value2, "capitalType");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormIsNull() {
            addCriterion("organize_form is null");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormIsNotNull() {
            addCriterion("organize_form is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormEqualTo(String value) {
            addCriterion("organize_form =", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormNotEqualTo(String value) {
            addCriterion("organize_form <>", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormGreaterThan(String value) {
            addCriterion("organize_form >", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormGreaterThanOrEqualTo(String value) {
            addCriterion("organize_form >=", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormLessThan(String value) {
            addCriterion("organize_form <", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormLessThanOrEqualTo(String value) {
            addCriterion("organize_form <=", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormLike(String value) {
            addCriterion("organize_form like", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormNotLike(String value) {
            addCriterion("organize_form not like", value, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormIn(List<String> values) {
            addCriterion("organize_form in", values, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormNotIn(List<String> values) {
            addCriterion("organize_form not in", values, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormBetween(String value1, String value2) {
            addCriterion("organize_form between", value1, value2, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andOrganizeFormNotBetween(String value1, String value2) {
            addCriterion("organize_form not between", value1, value2, "organizeForm");
            return (Criteria) this;
        }

        public Criteria andManageRateIsNull() {
            addCriterion("manage_rate is null");
            return (Criteria) this;
        }

        public Criteria andManageRateIsNotNull() {
            addCriterion("manage_rate is not null");
            return (Criteria) this;
        }

        public Criteria andManageRateEqualTo(BigDecimal value) {
            addCriterion("manage_rate =", value, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateNotEqualTo(BigDecimal value) {
            addCriterion("manage_rate <>", value, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateGreaterThan(BigDecimal value) {
            addCriterion("manage_rate >", value, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_rate >=", value, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateLessThan(BigDecimal value) {
            addCriterion("manage_rate <", value, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_rate <=", value, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateIn(List<BigDecimal> values) {
            addCriterion("manage_rate in", values, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateNotIn(List<BigDecimal> values) {
            addCriterion("manage_rate not in", values, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_rate between", value1, value2, "manageRate");
            return (Criteria) this;
        }

        public Criteria andManageRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_rate not between", value1, value2, "manageRate");
            return (Criteria) this;
        }

        public Criteria andReviewCodeIsNull() {
            addCriterion("review_code is null");
            return (Criteria) this;
        }

        public Criteria andReviewCodeIsNotNull() {
            addCriterion("review_code is not null");
            return (Criteria) this;
        }

        public Criteria andReviewCodeEqualTo(String value) {
            addCriterion("review_code =", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeNotEqualTo(String value) {
            addCriterion("review_code <>", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeGreaterThan(String value) {
            addCriterion("review_code >", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeGreaterThanOrEqualTo(String value) {
            addCriterion("review_code >=", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeLessThan(String value) {
            addCriterion("review_code <", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeLessThanOrEqualTo(String value) {
            addCriterion("review_code <=", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeLike(String value) {
            addCriterion("review_code like", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeNotLike(String value) {
            addCriterion("review_code not like", value, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeIn(List<String> values) {
            addCriterion("review_code in", values, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeNotIn(List<String> values) {
            addCriterion("review_code not in", values, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeBetween(String value1, String value2) {
            addCriterion("review_code between", value1, value2, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewCodeNotBetween(String value1, String value2) {
            addCriterion("review_code not between", value1, value2, "reviewCode");
            return (Criteria) this;
        }

        public Criteria andReviewDescIsNull() {
            addCriterion("review_desc is null");
            return (Criteria) this;
        }

        public Criteria andReviewDescIsNotNull() {
            addCriterion("review_desc is not null");
            return (Criteria) this;
        }

        public Criteria andReviewDescEqualTo(String value) {
            addCriterion("review_desc =", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotEqualTo(String value) {
            addCriterion("review_desc <>", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescGreaterThan(String value) {
            addCriterion("review_desc >", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescGreaterThanOrEqualTo(String value) {
            addCriterion("review_desc >=", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescLessThan(String value) {
            addCriterion("review_desc <", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescLessThanOrEqualTo(String value) {
            addCriterion("review_desc <=", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescLike(String value) {
            addCriterion("review_desc like", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotLike(String value) {
            addCriterion("review_desc not like", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescIn(List<String> values) {
            addCriterion("review_desc in", values, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotIn(List<String> values) {
            addCriterion("review_desc not in", values, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescBetween(String value1, String value2) {
            addCriterion("review_desc between", value1, value2, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotBetween(String value1, String value2) {
            addCriterion("review_desc not between", value1, value2, "reviewDesc");
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
     * loan
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * loan null
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