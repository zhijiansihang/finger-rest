package com.zhijiansihang.finger.app.dao.mysql.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserFriendDOExample {
    /**
     * user_friend
     */
    protected String orderByClause;

    /**
     * user_friend
     */
    protected boolean distinct;

    /**
     * user_friend
     */
    protected List<Criteria> oredCriteria;

    public UserFriendDOExample() {
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
     * user_friend null
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

        public Criteria andMyUserIdIsNull() {
            addCriterion("my_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIsNotNull() {
            addCriterion("my_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMyUserIdEqualTo(Long value) {
            addCriterion("my_user_id =", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotEqualTo(Long value) {
            addCriterion("my_user_id <>", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdGreaterThan(Long value) {
            addCriterion("my_user_id >", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("my_user_id >=", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLessThan(Long value) {
            addCriterion("my_user_id <", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("my_user_id <=", value, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdIn(List<Long> values) {
            addCriterion("my_user_id in", values, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotIn(List<Long> values) {
            addCriterion("my_user_id not in", values, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdBetween(Long value1, Long value2) {
            addCriterion("my_user_id between", value1, value2, "myUserId");
            return (Criteria) this;
        }

        public Criteria andMyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("my_user_id not between", value1, value2, "myUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdIsNull() {
            addCriterion("friend_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdIsNotNull() {
            addCriterion("friend_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdEqualTo(Long value) {
            addCriterion("friend_user_id =", value, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdNotEqualTo(Long value) {
            addCriterion("friend_user_id <>", value, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdGreaterThan(Long value) {
            addCriterion("friend_user_id >", value, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("friend_user_id >=", value, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdLessThan(Long value) {
            addCriterion("friend_user_id <", value, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdLessThanOrEqualTo(Long value) {
            addCriterion("friend_user_id <=", value, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdIn(List<Long> values) {
            addCriterion("friend_user_id in", values, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdNotIn(List<Long> values) {
            addCriterion("friend_user_id not in", values, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdBetween(Long value1, Long value2) {
            addCriterion("friend_user_id between", value1, value2, "friendUserId");
            return (Criteria) this;
        }

        public Criteria andFriendUserIdNotBetween(Long value1, Long value2) {
            addCriterion("friend_user_id not between", value1, value2, "friendUserId");
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
     * user_friend
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * user_friend null
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