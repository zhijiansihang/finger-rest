package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserDemandDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_demand",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_demand (user_id, money_situation, ",
        "earning_type, expected_deadline, ",
        "additional_remarks, is_deleted, ",
        "is_closed, last_batch_sid, ",
        "match_solution_count, serial_number, ",
        "update_time, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{moneySituation,jdbcType=SMALLINT}, ",
        "#{earningType,jdbcType=SMALLINT}, #{expectedDeadline,jdbcType=SMALLINT}, ",
        "#{additionalRemarks,jdbcType=VARCHAR}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{isClosed,jdbcType=TINYINT}, #{lastBatchSid,jdbcType=BIGINT}, ",
        "#{matchSolutionCount,jdbcType=BIGINT}, #{serialNumber,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserDemandDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserDemandDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserDemandDO> selectByExampleWithRowbounds(UserDemandDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserDemandDO> selectByExample(UserDemandDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, user_id, money_situation, earning_type, expected_deadline, additional_remarks, ",
        "is_deleted, is_closed, last_batch_sid, match_solution_count, serial_number, ",
        "update_time, create_time",
        "from user_demand",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO.BaseResultMap")
    UserDemandDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserDemandDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_demand",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "money_situation = #{moneySituation,jdbcType=SMALLINT},",
          "earning_type = #{earningType,jdbcType=SMALLINT},",
          "expected_deadline = #{expectedDeadline,jdbcType=SMALLINT},",
          "additional_remarks = #{additionalRemarks,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "is_closed = #{isClosed,jdbcType=TINYINT},",
          "last_batch_sid = #{lastBatchSid,jdbcType=BIGINT},",
          "match_solution_count = #{matchSolutionCount,jdbcType=BIGINT},",
          "serial_number = #{serialNumber,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserDemandDO record);
}