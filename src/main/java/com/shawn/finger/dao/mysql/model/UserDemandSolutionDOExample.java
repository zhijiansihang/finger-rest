package com.shawn.finger.dao.mysql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDemandSolutionDOExample {
    /**
     * user_demand_solution
     */
    protected String orderByClause;

    /**
     * user_demand_solution
     */
    protected boolean distinct;

    /**
     * user_demand_solution
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated
     */
    public UserDemandSolutionDOExample() {
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
     * user_demand_solution null
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

        public Criteria andDemandUserIdIsNull() {
            addCriterion("demand_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdIsNotNull() {
            addCriterion("demand_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdEqualTo(Long value) {
            addCriterion("demand_user_id =", value, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdNotEqualTo(Long value) {
            addCriterion("demand_user_id <>", value, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdGreaterThan(Long value) {
            addCriterion("demand_user_id >", value, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("demand_user_id >=", value, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdLessThan(Long value) {
            addCriterion("demand_user_id <", value, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdLessThanOrEqualTo(Long value) {
            addCriterion("demand_user_id <=", value, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdIn(List<Long> values) {
            addCriterion("demand_user_id in", values, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdNotIn(List<Long> values) {
            addCriterion("demand_user_id not in", values, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdBetween(Long value1, Long value2) {
            addCriterion("demand_user_id between", value1, value2, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandUserIdNotBetween(Long value1, Long value2) {
            addCriterion("demand_user_id not between", value1, value2, "demandUserId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNull() {
            addCriterion("demand_id is null");
            return (Criteria) this;
        }

        public Criteria andDemandIdIsNotNull() {
            addCriterion("demand_id is not null");
            return (Criteria) this;
        }

        public Criteria andDemandIdEqualTo(Long value) {
            addCriterion("demand_id =", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotEqualTo(Long value) {
            addCriterion("demand_id <>", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThan(Long value) {
            addCriterion("demand_id >", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdGreaterThanOrEqualTo(Long value) {
            addCriterion("demand_id >=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThan(Long value) {
            addCriterion("demand_id <", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdLessThanOrEqualTo(Long value) {
            addCriterion("demand_id <=", value, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdIn(List<Long> values) {
            addCriterion("demand_id in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotIn(List<Long> values) {
            addCriterion("demand_id not in", values, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdBetween(Long value1, Long value2) {
            addCriterion("demand_id between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andDemandIdNotBetween(Long value1, Long value2) {
            addCriterion("demand_id not between", value1, value2, "demandId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdIsNull() {
            addCriterion("solution_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdIsNotNull() {
            addCriterion("solution_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdEqualTo(Long value) {
            addCriterion("solution_user_id =", value, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdNotEqualTo(Long value) {
            addCriterion("solution_user_id <>", value, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdGreaterThan(Long value) {
            addCriterion("solution_user_id >", value, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("solution_user_id >=", value, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdLessThan(Long value) {
            addCriterion("solution_user_id <", value, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdLessThanOrEqualTo(Long value) {
            addCriterion("solution_user_id <=", value, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdIn(List<Long> values) {
            addCriterion("solution_user_id in", values, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdNotIn(List<Long> values) {
            addCriterion("solution_user_id not in", values, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdBetween(Long value1, Long value2) {
            addCriterion("solution_user_id between", value1, value2, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionUserIdNotBetween(Long value1, Long value2) {
            addCriterion("solution_user_id not between", value1, value2, "solutionUserId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdIsNull() {
            addCriterion("solution_id is null");
            return (Criteria) this;
        }

        public Criteria andSolutionIdIsNotNull() {
            addCriterion("solution_id is not null");
            return (Criteria) this;
        }

        public Criteria andSolutionIdEqualTo(Long value) {
            addCriterion("solution_id =", value, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdNotEqualTo(Long value) {
            addCriterion("solution_id <>", value, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdGreaterThan(Long value) {
            addCriterion("solution_id >", value, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("solution_id >=", value, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdLessThan(Long value) {
            addCriterion("solution_id <", value, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdLessThanOrEqualTo(Long value) {
            addCriterion("solution_id <=", value, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdIn(List<Long> values) {
            addCriterion("solution_id in", values, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdNotIn(List<Long> values) {
            addCriterion("solution_id not in", values, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdBetween(Long value1, Long value2) {
            addCriterion("solution_id between", value1, value2, "solutionId");
            return (Criteria) this;
        }

        public Criteria andSolutionIdNotBetween(Long value1, Long value2) {
            addCriterion("solution_id not between", value1, value2, "solutionId");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandIsNull() {
            addCriterion("is_read_demand is null");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandIsNotNull() {
            addCriterion("is_read_demand is not null");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandEqualTo(Byte value) {
            addCriterion("is_read_demand =", value, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandNotEqualTo(Byte value) {
            addCriterion("is_read_demand <>", value, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandGreaterThan(Byte value) {
            addCriterion("is_read_demand >", value, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_read_demand >=", value, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandLessThan(Byte value) {
            addCriterion("is_read_demand <", value, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandLessThanOrEqualTo(Byte value) {
            addCriterion("is_read_demand <=", value, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandIn(List<Byte> values) {
            addCriterion("is_read_demand in", values, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandNotIn(List<Byte> values) {
            addCriterion("is_read_demand not in", values, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandBetween(Byte value1, Byte value2) {
            addCriterion("is_read_demand between", value1, value2, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsReadDemandNotBetween(Byte value1, Byte value2) {
            addCriterion("is_read_demand not between", value1, value2, "isReadDemand");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionIsNull() {
            addCriterion("is_operate_solution is null");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionIsNotNull() {
            addCriterion("is_operate_solution is not null");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionEqualTo(Byte value) {
            addCriterion("is_operate_solution =", value, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionNotEqualTo(Byte value) {
            addCriterion("is_operate_solution <>", value, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionGreaterThan(Byte value) {
            addCriterion("is_operate_solution >", value, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_operate_solution >=", value, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionLessThan(Byte value) {
            addCriterion("is_operate_solution <", value, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionLessThanOrEqualTo(Byte value) {
            addCriterion("is_operate_solution <=", value, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionIn(List<Byte> values) {
            addCriterion("is_operate_solution in", values, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionNotIn(List<Byte> values) {
            addCriterion("is_operate_solution not in", values, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionBetween(Byte value1, Byte value2) {
            addCriterion("is_operate_solution between", value1, value2, "isOperateSolution");
            return (Criteria) this;
        }

        public Criteria andIsOperateSolutionNotBetween(Byte value1, Byte value2) {
            addCriterion("is_operate_solution not between", value1, value2, "isOperateSolution");
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
     * user_demand_solution
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_demand_solution null
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