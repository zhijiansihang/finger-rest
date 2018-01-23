package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserDemandDAO {
    @Delete({
        "delete from user_demand",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

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

    int insertSelective(UserDemandDO record);

    List<UserDemandDO> selectByExampleWithRowbounds(UserDemandDOExample example, RowBounds rowBounds);

    List<UserDemandDO> selectByExample(UserDemandDOExample example);

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

    int updateByPrimaryKeySelective(UserDemandDO record);

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

    @Select({
            "select count(*)",
            "from user_demand",
            "where user_id = #{userId} and money_situation = #{moneySituation} and earning_type = #{earningType} and expected_deadline = #{expectedDeadline}"
    })
    int existSameType(UserDemandDO userDemandDO);

    @Select({
            "select ifnull(max(serial_number),0)",
            "from user_demand",
            "where user_id = #{userId}"
    })
    int getMaxSerialNumber(long userId);
}