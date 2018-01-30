package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDOExample;
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
public interface UserDAO {
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into user (mobile, real_name, ",
        "id_card, nick_name, ",
        "passwd, is_name_auth, ",
        "is_frozen, is_register_jg, ",
        "logo, roles, `source`, ",
        "institution_user_id, institution_name, ",
        "risk_assessment_level, update_time, ",
        "create_time)",
        "values (#{mobile,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{passwd,jdbcType=VARCHAR}, #{isNameAuth,jdbcType=TINYINT}, ",
        "#{isFrozen,jdbcType=TINYINT}, #{isRegisterJg,jdbcType=TINYINT}, ",
        "#{logo,jdbcType=VARCHAR}, #{roles,jdbcType=SMALLINT}, #{source,jdbcType=SMALLINT}, ",
        "#{institutionUserId,jdbcType=BIGINT}, #{institutionName,jdbcType=BIGINT}, ",
        "#{riskAssessmentLevel,jdbcType=SMALLINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="userId", before=false, resultType=Long.class)
    int insert(UserDO record);

    int insertSelective(UserDO record);

    List<UserDO> selectByExampleWithRowbounds(UserDOExample example, RowBounds rowBounds);

    List<UserDO> selectByExample(UserDOExample example);

    @Select({
        "select",
        "user_id, mobile, real_name, id_card, nick_name, passwd, is_name_auth, is_frozen, ",
        "is_register_jg, logo, roles, `source`, institution_user_id, institution_name, ",
        "risk_assessment_level, update_time, create_time",
        "from user",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO.BaseResultMap")
    UserDO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserDO record);

    @Update({
        "update user",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "passwd = #{passwd,jdbcType=VARCHAR},",
          "is_name_auth = #{isNameAuth,jdbcType=TINYINT},",
          "is_frozen = #{isFrozen,jdbcType=TINYINT},",
          "is_register_jg = #{isRegisterJg,jdbcType=TINYINT},",
          "logo = #{logo,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=SMALLINT},",
          "`source` = #{source,jdbcType=SMALLINT},",
          "institution_user_id = #{institutionUserId,jdbcType=BIGINT},",
          "institution_name = #{institutionName,jdbcType=BIGINT},",
          "risk_assessment_level = #{riskAssessmentLevel,jdbcType=SMALLINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserDO record);

    @Select({
            "select count(*) ",
            "from user",
            "where real_name = #{realName} and id_card = #{idCard}"
    })
    int existIdCardAndRealName(@Param("realName") String realName,@Param("idCard") String idCard);

    int countByExample(UserDOExample example);

}