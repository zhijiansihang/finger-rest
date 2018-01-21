package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserSurverDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserSurverDOExample;
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
public interface UserSurverDAO {
    @Delete({
        "delete from user_surver",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_surver (user_id, exam_id, ",
        "answers, exam_result, ",
        "risk_assessment_level, score, ",
        "create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{examId,jdbcType=BIGINT}, ",
        "#{answers,jdbcType=VARCHAR}, #{examResult,jdbcType=VARCHAR}, ",
        "#{riskAssessmentLevel,jdbcType=SMALLINT}, #{score,jdbcType=SMALLINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserSurverDO record);

    int insertSelective(UserSurverDO record);

    List<UserSurverDO> selectByExampleWithRowbounds(UserSurverDOExample example, RowBounds rowBounds);

    List<UserSurverDO> selectByExample(UserSurverDOExample example);

    @Select({
        "select",
        "id, user_id, exam_id, answers, exam_result, risk_assessment_level, score, create_time",
        "from user_surver",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserSurverDAO.BaseResultMap")
    UserSurverDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSurverDO record);

    @Update({
        "update user_surver",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "exam_id = #{examId,jdbcType=BIGINT},",
          "answers = #{answers,jdbcType=VARCHAR},",
          "exam_result = #{examResult,jdbcType=VARCHAR},",
          "risk_assessment_level = #{riskAssessmentLevel,jdbcType=SMALLINT},",
          "score = #{score,jdbcType=SMALLINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserSurverDO record);
}