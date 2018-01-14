package com.shawn.finger.dao.mysql.mapper;

import com.shawn.finger.dao.mysql.model.UserDemandSolutionDO;
import com.shawn.finger.dao.mysql.model.UserDemandSolutionDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserDemandSolutionDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_demand_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_demand_solution (demand_user_id, demand_id, ",
        "solution_user_id, solution_id, ",
        "is_read_demand, is_operate_solution, ",
        "update_time, create_time)",
        "values (#{demandUserId,jdbcType=BIGINT}, #{demandId,jdbcType=BIGINT}, ",
        "#{solutionUserId,jdbcType=BIGINT}, #{solutionId,jdbcType=BIGINT}, ",
        "#{isReadDemand,jdbcType=TINYINT}, #{isOperateSolution,jdbcType=TINYINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserDemandSolutionDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserDemandSolutionDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserDemandSolutionDO> selectByExampleWithRowbounds(UserDemandSolutionDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserDemandSolutionDO> selectByExample(UserDemandSolutionDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, demand_user_id, demand_id, solution_user_id, solution_id, is_read_demand, ",
        "is_operate_solution, update_time, create_time",
        "from user_demand_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.shawn.finger.dao.mysql.mapper.UserDemandSolutionDAO.BaseResultMap")
    UserDemandSolutionDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserDemandSolutionDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_demand_solution",
        "set demand_user_id = #{demandUserId,jdbcType=BIGINT},",
          "demand_id = #{demandId,jdbcType=BIGINT},",
          "solution_user_id = #{solutionUserId,jdbcType=BIGINT},",
          "solution_id = #{solutionId,jdbcType=BIGINT},",
          "is_read_demand = #{isReadDemand,jdbcType=TINYINT},",
          "is_operate_solution = #{isOperateSolution,jdbcType=TINYINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserDemandSolutionDO record);
}