package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserSolutionDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_solution (user_id, money_situation, ",
        "earning_type, expected_deadline, ",
        "solution, risk_assessment_level, ",
        "create_time, is_deleted, ",
        "is_closed, match_demand_count, ",
        "read_count, adopt_count)",
        "values (#{userId,jdbcType=BIGINT}, #{moneySituation,jdbcType=SMALLINT}, ",
        "#{earningType,jdbcType=SMALLINT}, #{expectedDeadline,jdbcType=SMALLINT}, ",
        "#{solution,jdbcType=VARCHAR}, #{riskAssessmentLevel,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{isClosed,jdbcType=TINYINT}, #{matchDemandCount,jdbcType=BIGINT}, ",
        "#{readCount,jdbcType=BIGINT}, #{adoptCount,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserSolutionDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserSolutionDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserSolutionDO> selectByExampleWithRowbounds(UserSolutionDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserSolutionDO> selectByExample(UserSolutionDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, user_id, money_situation, earning_type, expected_deadline, solution, risk_assessment_level, ",
        "create_time, is_deleted, is_closed, match_demand_count, read_count, adopt_count",
        "from user_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.dao.mysql.mapper.UserSolutionDAO.BaseResultMap")
    UserSolutionDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserSolutionDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_solution",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "money_situation = #{moneySituation,jdbcType=SMALLINT},",
          "earning_type = #{earningType,jdbcType=SMALLINT},",
          "expected_deadline = #{expectedDeadline,jdbcType=SMALLINT},",
          "solution = #{solution,jdbcType=VARCHAR},",
          "risk_assessment_level = #{riskAssessmentLevel,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "is_closed = #{isClosed,jdbcType=TINYINT},",
          "match_demand_count = #{matchDemandCount,jdbcType=BIGINT},",
          "read_count = #{readCount,jdbcType=BIGINT},",
          "adopt_count = #{adoptCount,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserSolutionDO record);
}