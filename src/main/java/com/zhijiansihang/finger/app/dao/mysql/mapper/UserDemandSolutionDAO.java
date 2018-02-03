package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDemandSolutionDOExample;

import java.security.acl.LastOwnerException;
import java.util.List;

import com.zhijiansihang.finger.app.vo.DemandMatchSolutionResult;
import com.zhijiansihang.finger.app.vo.SolutionMatchDemandResult;
import org.apache.coyote.http11.filters.VoidInputFilter;
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


    @Select({
            "select count(*)",
            "from user_demand_solution",
            "where demand_user_id = #{demandUserId} and demand_id = #{demandId} and is_operate_solution=#{isOperateSolution}"
    })
    int countByDemandUserIdAndUserid(UserDemandSolutionDO userDemandSolutionDO);

    @Select({
            "select us.adopt_count,ufc.friend_counts,uds.id,u.institution_name,uds.is_operate_solution,u.logo,u.real_name",
            "us.serial_number,uds.solution_id,uds.solution_user_id,ufd.service_direction",
            "from user_demand_solution uds ,user u,user_solution us,user_friend_count ufc,user_finance_detail ufd",
            "where uds.solution_user_id = u.user_id and uds.solution_id = us.id and uds.solution_user_id = ufc.user_id and uds.solution_user_id = ufd.user_id",
            " and uds.demand_user_id = #{demandUserId} and uds.demand_id = #{demandId} and uds.is_operate_solution=#{isOperateSolution}",
            "order by uds.create_time desc"
    })
    @Results({
            @Result(property = "adoptCount", column = "adopt_count"),
            @Result(property = "friendCounts", column = "friend_counts"),
            @Result(property = "id", column = "id"),
            @Result(property = "institutionName", column = "institution_name"),
            @Result(property = "isOperateSolution", column = "is_operate_solution"),
            @Result(property = "logo", column = "logo"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "serialNumber", column = "serial_number"),
            @Result(property = "solutionId", column = "solution_id"),
            @Result(property = "solutionUserId", column = "solution_user_id"),
            @Result(property = "serviceDirection", column = "service_direction")
    })
    List<DemandMatchSolutionResult> selectByDemandUserIdAndUseridPage(UserDemandSolutionDO userDemandSolutionDO, RowBounds rowBounds);

    @Select({
            "select count(*)",
            "from user_demand_solution",
            "where solution_user_id = #{solutionUserId} and solution_id = #{solutionId} and is_read_demand=#{isReadDemand}"
    })
    int countBySolutionUserIdAndUserid(UserDemandSolutionDO userDemandSolutionDO);

    @Select({
            "select uds.demand_id,uds.demand_user_id,uds.id,ud.serial_number,uds.is_read_demand,u.logo,u.real_name",
            "from user_demand_solution uds ,user u,user_demand ud",
            "where uds.demand_user_id = u.user_id and uds.demand_id = ud.id",
            "and solution_user_id = #{solutionUserId} and solution_id = #{solutionId} and is_read_demand=#{isReadDemand}",
            "order by uds.create_time desc"
    })
    @Results({
            @Result(property = "realName", column = "real_name"),
            @Result(property = "logo", column = "logo"),
            @Result(property = "isReadDemand", column = "is_read_demand"),
            @Result(property = "serialNumber", column = "serial_number"),
            @Result(property = "demandId", column = "demand_id"),
            @Result(property = "demandUserId", column = "demand_user_id"),
            @Result(property = "id", column = "id")
    })
    List<SolutionMatchDemandResult> selectBySolutionUserIdAndUseridPage(UserDemandSolutionDO userDemandSolutionDO, RowBounds rowBounds);


    @Select({
            "select count(*)",
            "from user_demand_solution",
            "where demand_user_id = #{demandUserId}"
    })
    int countByDemandUserId(Long demandUserId);
}