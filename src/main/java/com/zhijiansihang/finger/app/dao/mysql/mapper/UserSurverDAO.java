package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserSurverDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSurverDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserSurverDAO {

    @Insert({
        "insert into user_surver (user_id, ",
        "answers, ",
        "risk_assessment_level, ",
        "create_time)",
        "values (#{userId,jdbcType=BIGINT}, ",
        "#{answers,jdbcType=VARCHAR}, ",
        "#{riskAssessmentLevel,jdbcType=SMALLINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserSurverDO record);


    @Select({
        "select",
        "id, user_id, answers, risk_assessment_level, create_time",
        "from user_surver",
        "where user_id = #{id,jdbcType=BIGINT}",
        "order by create_time desc",
        "limit 0,1"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "answers", column = "answers"),
            @Result(property = "riskAssessmentLevel", column = "risk_assessment_level"),
            @Result(property = "createTime", column = "create_time")
    })
    UserSurverDO selectByPrimaryKey(Long id);
}