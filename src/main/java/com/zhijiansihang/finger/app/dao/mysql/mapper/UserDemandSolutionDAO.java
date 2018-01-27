package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDOExample;

import java.security.acl.LastOwnerException;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import javax.persistence.criteria.CriteriaBuilder;

@Mapper
public interface UserDemandSolutionDAO {
    @Delete({
        "delete from user_demand_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

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

    int insertSelective(UserDemandSolutionDO record);

    List<UserDemandSolutionDO> selectByExampleWithRowbounds(UserDemandSolutionDOExample example, RowBounds rowBounds);

    List<UserDemandSolutionDO> selectByExample(UserDemandSolutionDOExample example);

    @Select({
        "select",
        "id, demand_user_id, demand_id, solution_user_id, solution_id, is_read_demand, ",
        "is_operate_solution, update_time, create_time",
        "from user_demand_solution",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserDemandSolutionDAO.BaseResultMap")
    UserDemandSolutionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDemandSolutionDO record);

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
    @Update({
            "update user_demand_solution",
            "set is_operate_solution = 1,",
            "update_time = now() ",
            "where id = #{id} and is_operate_solution = 0 and demand_user_id = #{demandUserId}"
    })
    int readMyDemandsolution(@Param("demandUserId") Long demandUserId, @Param("id") Integer id);

    @Update({
            "update user_demand_solution",
            "set is_operate_solution = 2,",
            "update_time = now() ",
            "where id = #{id} and is_operate_solution <> 2 and demand_user_id = #{demandUserId}"
    })
    int adoptMyDemandsolution(@Param("demandUserId") Long demandUserId, @Param("id") Integer id);


}