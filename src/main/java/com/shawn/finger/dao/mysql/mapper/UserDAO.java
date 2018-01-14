package com.shawn.finger.dao.mysql.mapper;

import com.shawn.finger.dao.mysql.model.UserDO;
import com.shawn.finger.dao.mysql.model.UserDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user (mobile, real_name, ",
        "id_card, nick_name, ",
        "passwd, is_name_auth, ",
        "is_frozen, logo, ",
        "roles, `source`, ",
        "institution_user_id, risk_assessment_level, ",
        "update_time, create_time)",
        "values (#{mobile,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{passwd,jdbcType=VARCHAR}, #{isNameAuth,jdbcType=TINYINT}, ",
        "#{isFrozen,jdbcType=TINYINT}, #{logo,jdbcType=VARCHAR}, ",
        "#{roles,jdbcType=SMALLINT}, #{source,jdbcType=SMALLINT}, ",
        "#{institutionUserId,jdbcType=BIGINT}, #{riskAssessmentLevel,jdbcType=SMALLINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Long.class)
    int insert(UserDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserDO> selectByExampleWithRowbounds(UserDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserDO> selectByExample(UserDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "user_id, mobile, real_name, id_card, nick_name, passwd, is_name_auth, is_frozen, ",
        "logo, roles, `source`, institution_user_id, risk_assessment_level, update_time, ",
        "create_time",
        "from user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @ResultMap("com.shawn.finger.dao.mysql.mapper.UserDAO.BaseResultMap")
    UserDO selectByPrimaryKey(Long userId);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "passwd = #{passwd,jdbcType=VARCHAR},",
          "is_name_auth = #{isNameAuth,jdbcType=TINYINT},",
          "is_frozen = #{isFrozen,jdbcType=TINYINT},",
          "logo = #{logo,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=SMALLINT},",
          "`source` = #{source,jdbcType=SMALLINT},",
          "institution_user_id = #{institutionUserId,jdbcType=BIGINT},",
          "risk_assessment_level = #{riskAssessmentLevel,jdbcType=SMALLINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserDO record);
}