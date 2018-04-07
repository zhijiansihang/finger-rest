package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandDOExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

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
            "where is_deleted = 0 and user_id = #{userId} and money_situation = #{moneySituation} and earning_type = #{earningType} and expected_deadline = #{expectedDeadline}"
    })
    int existSameType(UserDemandDO userDemandDO);

    @Select({
            "select *",
            "from user_demand",
            "where is_deleted = 0 and user_id = #{userId} and money_situation = #{moneySituation} and earning_type = #{earningType} and expected_deadline = #{expectedDeadline}"
    })
    List<UserDemandDO> getSameTypeList(UserDemandDO userDemandDO);

    @Select({
            "select ifnull(max(serial_number),0)",
            "from user_demand",
            "where user_id = #{userId}"
    })
    int getMaxSerialNumber(long userId);

    @Select({
            "select count(*)",
            "from user_demand",
            "where user_id = #{userId} and is_deleted = 0"
    })
    int countByUserid(Long userId);

    @Select({
            "select",
            "id, user_id, money_situation, earning_type, expected_deadline, additional_remarks, ",
            "is_deleted, is_closed, last_batch_sid, match_solution_count, serial_number, ",
            "update_time, create_time",
            "from user_demand",
            "where user_id = #{userId} and is_deleted = 0",
            "order by is_closed desc,serial_number desc"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO.BaseResultMap")
    List<UserDemandDO> selectByUseridPage(@Param("userId") Long userId, RowBounds rowBounds);





    @Update({
           "update user_demand set last_batch_sid = null and match_solution_count = 0 where is_deleted = 0 and is_closed = 0 and user_id = #{userId} "
    })
    int updateAgainRishBatchByUserid(Long userId);

    @Select({
          "select ifnull(max(id),0) from user_demand"
    })
    long getMaxId();

    @Select({
            "select ud.*,u.risk_assessment_level",
            "from user_demand ud, user u",
            "where ifnull(ud.last_batch_sid,0) < #{userSolutionMax}  and ud.is_deleted = 0 and ud.is_closed = 0 ",
            " and ud.user_id = u.user_id and u.risk_assessment_level is not null ",
            "order by ud.id desc"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandDAO.BaseResultMap")
    List<UserDemandDO> getLowLastBatchid(@Param("userSolutionMax") Long user_solution_max, RowBounds rowBounds);

    @Update({
            "update user_demand set last_batch_sid = #{userSolutionMax}  where id= #{id} "
    })
    int updateLastBatchid(@Param("id") Long id, @Param("userSolutionMax") Long userSolutionMax);

    @Update({
            "update user_demand set match_solution_count = match_solution_count + #{matchSolutionCount}  where id= #{id} "
    })
    int addMatchSolutionCount(@Param("id") Long id, @Param("matchSolutionCount") long matchSolutionCount);
}