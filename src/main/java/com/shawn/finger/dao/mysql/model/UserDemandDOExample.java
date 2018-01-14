package com.shawn.finger.dao.mysql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDemandDOExample {
    /**
     * user_demand
     */
    protected String orderByClause;

    /**
     * user_demand
     */
    protected boolean distinct;

    /**
     * user_demand
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public UserDemandDOExample() {
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
     * user_demand null
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andMoneySituationIsNull() {
            addCriterion("money_situation is null");
            return (Criteria) this;
        }

        public Criteria andMoneySituationIsNotNull() {
            addCriterion("money_situation is not null");
            return (Criteria) this;
        }

        public Criteria andMoneySituationEqualTo(Short value) {
            addCriterion("money_situation =", value, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationNotEqualTo(Short value) {
            addCriterion("money_situation <>", value, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationGreaterThan(Short value) {
            addCriterion("money_situation >", value, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationGreaterThanOrEqualTo(Short value) {
            addCriterion("money_situation >=", value, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationLessThan(Short value) {
            addCriterion("money_situation <", value, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationLessThanOrEqualTo(Short value) {
            addCriterion("money_situation <=", value, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationIn(List<Short> values) {
            addCriterion("money_situation in", values, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationNotIn(List<Short> values) {
            addCriterion("money_situation not in", values, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationBetween(Short value1, Short value2) {
            addCriterion("money_situation between", value1, value2, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andMoneySituationNotBetween(Short value1, Short value2) {
            addCriterion("money_situation not between", value1, value2, "moneySituation");
            return (Criteria) this;
        }

        public Criteria andEarningTypeIsNull() {
            addCriterion("earning_type is null");
            return (Criteria) this;
        }

        public Criteria andEarningTypeIsNotNull() {
            addCriterion("earning_type is not null");
            return (Criteria) this;
        }

        public Criteria andEarningTypeEqualTo(Short value) {
            addCriterion("earning_type =", value, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeNotEqualTo(Short value) {
            addCriterion("earning_type <>", value, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeGreaterThan(Short value) {
            addCriterion("earning_type >", value, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("earning_type >=", value, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeLessThan(Short value) {
            addCriterion("earning_type <", value, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeLessThanOrEqualTo(Short value) {
            addCriterion("earning_type <=", value, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeIn(List<Short> values) {
            addCriterion("earning_type in", values, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeNotIn(List<Short> values) {
            addCriterion("earning_type not in", values, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeBetween(Short value1, Short value2) {
            addCriterion("earning_type between", value1, value2, "earningType");
            return (Criteria) this;
        }

        public Criteria andEarningTypeNotBetween(Short value1, Short value2) {
            addCriterion("earning_type not between", value1, value2, "earningType");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineIsNull() {
            addCriterion("expected_deadline is null");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineIsNotNull() {
            addCriterion("expected_deadline is not null");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineEqualTo(Short value) {
            addCriterion("expected_deadline =", value, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineNotEqualTo(Short value) {
            addCriterion("expected_deadline <>", value, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineGreaterThan(Short value) {
            addCriterion("expected_deadline >", value, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineGreaterThanOrEqualTo(Short value) {
            addCriterion("expected_deadline >=", value, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineLessThan(Short value) {
            addCriterion("expected_deadline <", value, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineLessThanOrEqualTo(Short value) {
            addCriterion("expected_deadline <=", value, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineIn(List<Short> values) {
            addCriterion("expected_deadline in", values, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineNotIn(List<Short> values) {
            addCriterion("expected_deadline not in", values, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineBetween(Short value1, Short value2) {
            addCriterion("expected_deadline between", value1, value2, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andExpectedDeadlineNotBetween(Short value1, Short value2) {
            addCriterion("expected_deadline not between", value1, value2, "expectedDeadline");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksIsNull() {
            addCriterion("additional_remarks is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksIsNotNull() {
            addCriterion("additional_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksEqualTo(String value) {
            addCriterion("additional_remarks =", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksNotEqualTo(String value) {
            addCriterion("additional_remarks <>", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksGreaterThan(String value) {
            addCriterion("additional_remarks >", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("additional_remarks >=", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksLessThan(String value) {
            addCriterion("additional_remarks <", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksLessThanOrEqualTo(String value) {
            addCriterion("additional_remarks <=", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksLike(String value) {
            addCriterion("additional_remarks like", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksNotLike(String value) {
            addCriterion("additional_remarks not like", value, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksIn(List<String> values) {
            addCriterion("additional_remarks in", values, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksNotIn(List<String> values) {
            addCriterion("additional_remarks not in", values, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksBetween(String value1, String value2) {
            addCriterion("additional_remarks between", value1, value2, "additionalRemarks");
            return (Criteria) this;
        }

        public Criteria andAdditionalRemarksNotBetween(String value1, String value2) {
            addCriterion("additional_remarks not between", value1, value2, "additionalRemarks");
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

        public Criteria andIsClosedIsNull() {
            addCriterion("is_closed is null");
            return (Criteria) this;
        }

        public Criteria andIsClosedIsNotNull() {
            addCriterion("is_closed is not null");
            return (Criteria) this;
        }

        public Criteria andIsClosedEqualTo(Byte value) {
            addCriterion("is_closed =", value, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedNotEqualTo(Byte value) {
            addCriterion("is_closed <>", value, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedGreaterThan(Byte value) {
            addCriterion("is_closed >", value, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_closed >=", value, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedLessThan(Byte value) {
            addCriterion("is_closed <", value, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedLessThanOrEqualTo(Byte value) {
            addCriterion("is_closed <=", value, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedIn(List<Byte> values) {
            addCriterion("is_closed in", values, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedNotIn(List<Byte> values) {
            addCriterion("is_closed not in", values, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedBetween(Byte value1, Byte value2) {
            addCriterion("is_closed between", value1, value2, "isClosed");
            return (Criteria) this;
        }

        public Criteria andIsClosedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_closed not between", value1, value2, "isClosed");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidIsNull() {
            addCriterion("last_batch_sid is null");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidIsNotNull() {
            addCriterion("last_batch_sid is not null");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidEqualTo(Long value) {
            addCriterion("last_batch_sid =", value, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidNotEqualTo(Long value) {
            addCriterion("last_batch_sid <>", value, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidGreaterThan(Long value) {
            addCriterion("last_batch_sid >", value, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidGreaterThanOrEqualTo(Long value) {
            addCriterion("last_batch_sid >=", value, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidLessThan(Long value) {
            addCriterion("last_batch_sid <", value, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidLessThanOrEqualTo(Long value) {
            addCriterion("last_batch_sid <=", value, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidIn(List<Long> values) {
            addCriterion("last_batch_sid in", values, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidNotIn(List<Long> values) {
            addCriterion("last_batch_sid not in", values, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidBetween(Long value1, Long value2) {
            addCriterion("last_batch_sid between", value1, value2, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andLastBatchSidNotBetween(Long value1, Long value2) {
            addCriterion("last_batch_sid not between", value1, value2, "lastBatchSid");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountIsNull() {
            addCriterion("match_solution_count is null");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountIsNotNull() {
            addCriterion("match_solution_count is not null");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountEqualTo(Long value) {
            addCriterion("match_solution_count =", value, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountNotEqualTo(Long value) {
            addCriterion("match_solution_count <>", value, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountGreaterThan(Long value) {
            addCriterion("match_solution_count >", value, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountGreaterThanOrEqualTo(Long value) {
            addCriterion("match_solution_count >=", value, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountLessThan(Long value) {
            addCriterion("match_solution_count <", value, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountLessThanOrEqualTo(Long value) {
            addCriterion("match_solution_count <=", value, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountIn(List<Long> values) {
            addCriterion("match_solution_count in", values, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountNotIn(List<Long> values) {
            addCriterion("match_solution_count not in", values, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountBetween(Long value1, Long value2) {
            addCriterion("match_solution_count between", value1, value2, "matchSolutionCount");
            return (Criteria) this;
        }

        public Criteria andMatchSolutionCountNotBetween(Long value1, Long value2) {
            addCriterion("match_solution_count not between", value1, value2, "matchSolutionCount");
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
     * user_demand
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_demand null
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