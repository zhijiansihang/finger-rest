package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserFinanceDetailDAO {
    @Delete({
        "delete from user_finance_detail",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into user_finance_detail (user_id, education_level, ",
        "school_name, work_age, ",
        "`position`, service_direction, ",
        "service_concept, working_experience, ",
        "personal_profile, is_add, ",
        "is_deleted, loan_count, ",
        "user_order_count, adopt_count, ",
        "update_time, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{educationLevel,jdbcType=VARCHAR}, ",
        "#{schoolName,jdbcType=VARCHAR}, #{workAge,jdbcType=SMALLINT}, ",
        "#{position,jdbcType=VARCHAR}, #{serviceDirection,jdbcType=VARCHAR}, ",
        "#{serviceConcept,jdbcType=VARCHAR}, #{workingExperience,jdbcType=VARCHAR}, ",
        "#{personalProfile,jdbcType=VARCHAR}, #{isAdd,jdbcType=TINYINT}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{loanCount,jdbcType=BIGINT}, ",
        "#{userOrderCount,jdbcType=BIGINT}, #{adoptCount,jdbcType=BIGINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserFinanceDetailDO record);

    int insertSelective(UserFinanceDetailDO record);

    List<UserFinanceDetailDO> selectByExampleWithRowbounds(UserFinanceDetailDOExample example, RowBounds rowBounds);

    List<UserFinanceDetailDO> selectByExample(UserFinanceDetailDOExample example);

    @Select({
        "select",
        "user_id, education_level, school_name, work_age, `position`, service_direction, ",
        "service_concept, working_experience, personal_profile, is_add, is_deleted, loan_count, ",
        "user_order_count, adopt_count, update_time, create_time",
        "from user_finance_detail",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO.BaseResultMap")
    UserFinanceDetailDO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserFinanceDetailDO record);

    @Update({
        "update user_finance_detail",
        "set education_level = #{educationLevel,jdbcType=VARCHAR},",
          "school_name = #{schoolName,jdbcType=VARCHAR},",
          "work_age = #{workAge,jdbcType=SMALLINT},",
          "`position` = #{position,jdbcType=VARCHAR},",
          "service_direction = #{serviceDirection,jdbcType=VARCHAR},",
          "service_concept = #{serviceConcept,jdbcType=VARCHAR},",
          "working_experience = #{workingExperience,jdbcType=VARCHAR},",
          "personal_profile = #{personalProfile,jdbcType=VARCHAR},",
          "is_add = #{isAdd,jdbcType=TINYINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "loan_count = #{loanCount,jdbcType=BIGINT},",
          "user_order_count = #{userOrderCount,jdbcType=BIGINT},",
          "adopt_count = #{adoptCount,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserFinanceDetailDO record);
}