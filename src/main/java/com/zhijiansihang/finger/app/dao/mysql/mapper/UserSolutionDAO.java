package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSolutionDOExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
@Mapper
public interface UserSolutionDAO {
    @Delete({
        "delete from user_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_solution (user_id, money_situation, ",
        "earning_type, expected_deadline, ",
        "solution, risk_assessment_level, ",
        "create_time, is_deleted, ",
        "is_closed, match_demand_count, ",
        "read_count, adopt_count, ",
        "serial_number)",
        "values (#{userId,jdbcType=BIGINT}, #{moneySituation,jdbcType=SMALLINT}, ",
        "#{earningType,jdbcType=SMALLINT}, #{expectedDeadline,jdbcType=SMALLINT}, ",
        "#{solution,jdbcType=VARCHAR}, #{riskAssessmentLevel,jdbcType=SMALLINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{isClosed,jdbcType=TINYINT}, #{matchDemandCount,jdbcType=BIGINT}, ",
        "#{readCount,jdbcType=BIGINT}, #{adoptCount,jdbcType=BIGINT}, ",
        "#{serialNumber,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserSolutionDO record);

    int insertSelective(UserSolutionDO record);

    List<UserSolutionDO> selectByExampleWithRowbounds(UserSolutionDOExample example, RowBounds rowBounds);

    List<UserSolutionDO> selectByExample(UserSolutionDOExample example);

    @Select({
        "select",
        "id, user_id, money_situation, earning_type, expected_deadline, solution, risk_assessment_level, ",
        "create_time, is_deleted, is_closed, match_demand_count, read_count, adopt_count, ",
        "serial_number",
        "from user_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO.BaseResultMap")
    UserSolutionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSolutionDO record);

    @Update({
        "update user_solution",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "money_situation = #{moneySituation,jdbcType=SMALLINT},",
          "earning_type = #{earningType,jdbcType=SMALLINT},",
          "expected_deadline = #{expectedDeadline,jdbcType=SMALLINT},",
          "solution = #{solution,jdbcType=VARCHAR},",
          "risk_assessment_level = #{riskAssessmentLevel,jdbcType=SMALLINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "is_closed = #{isClosed,jdbcType=TINYINT},",
          "match_demand_count = #{matchDemandCount,jdbcType=BIGINT},",
          "read_count = #{readCount,jdbcType=BIGINT},",
          "adopt_count = #{adoptCount,jdbcType=BIGINT},",
          "serial_number = #{serialNumber,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserSolutionDO record);

    @Select({
            "select count(*) ",
            "from user_solution ",
            "where is_deleted = 0 and user_id = #{userId} and money_situation = #{moneySituation} " +
            " and earning_type = #{earningType} and expected_deadline = #{expectedDeadline} and risk_assessment_level=#{riskAssessmentLevel}"
    })
    int existSameType(UserSolutionDO userSolutionDO);

    @Select({
            "select *",
            "from user_solution ",
            "where is_deleted = 0 and user_id = #{userId} and money_situation = #{moneySituation} " +
                    " and earning_type = #{earningType} and expected_deadline = #{expectedDeadline} and risk_assessment_level=#{riskAssessmentLevel}"
    })
    List<UserSolutionDO> getSameTypeList(UserSolutionDO userSolutionDO);

    @Select({
            "select ifnull(max(serial_number),0)",
            "from user_solution",
            "where user_id = #{userId}"
    })
    int getMaxSerialNumber(long userId);

    @Select({
            "select count(*)",
            "from user_solution",
            "where user_id = #{userId} and is_deleted = 0"
    })
    int countByUserid(Long userid);

    @Select({
            "select",
            "id, user_id, money_situation, earning_type, expected_deadline, solution, risk_assessment_level, ",
            "create_time, is_deleted, is_closed, match_demand_count, read_count, adopt_count, ",
            "serial_number",
            "from user_solution",
            "where user_id = #{userId} and is_deleted = 0",
            "order by is_closed ACS,serial_number desc"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO.BaseResultMap")
    List<UserSolutionDO> selectByUseridPage(Long userid, RowBounds rowBounds);

    @Update({
            "update user_solution",
            "set read_count = read_count + 1",
            "where id = #{id}"
    })
    int readCountAdd(Long id);

    @Update({
            "update user_solution",
            "set adopt_count = adopt_count + 1",
            "where id = #{id}"
    })
    int adoptCountAdd(Long solutionId);
    @Select({
           "select ifnull(max(id),0) from user_solution"
    })
    long getMaxId();

    @Select({
            "select",
            "id, user_id, money_situation, earning_type, expected_deadline, solution, risk_assessment_level, ",
            "create_time, is_deleted, is_closed, match_demand_count, read_count, adopt_count, ",
            "serial_number",
            "from user_solution",
            "where is_deleted = 0 and is_closed = 0 ",
            "and money_situation = #{moneySituation} ",
            "and earning_type = #{earningType} ",
            "and expected_deadline = #{expectedDeadline} ",
            "and risk_assessment_level = #{riskAssessmentLevel} ",
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserSolutionDAO.BaseResultMap")
    List<UserSolutionDO> selectMatch(UserSolutionDO userSolutionDO);

    @Update({
            "update user_solution",
            "set match_demand_count = ifnull(match_demand_count,0) + 1",
            "where id = #{id}"
    })
    int addMatchDemandCount(Long id);
}