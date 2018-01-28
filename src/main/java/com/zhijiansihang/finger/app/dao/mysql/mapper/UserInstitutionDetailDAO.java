package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserInstitutionDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserInstitutionDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserInstitutionDetailDAO {
    @Delete({
        "delete from user_institution_detail",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into user_institution_detail (user_id, `name`, ",
        "contact_name, contact_mobile, ",
        "is_personal, is_deleted, ",
        "update_time, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{contactName,jdbcType=VARCHAR}, #{contactMobile,jdbcType=VARCHAR}, ",
        "#{isPersonal,jdbcType=TINYINT}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserInstitutionDetailDO record);

    int insertSelective(UserInstitutionDetailDO record);

    List<UserInstitutionDetailDO> selectByExampleWithRowbounds(UserInstitutionDetailDOExample example, RowBounds rowBounds);

    List<UserInstitutionDetailDO> selectByExample(UserInstitutionDetailDOExample example);

    @Select({
        "select",
        "user_id, `name`, contact_name, contact_mobile, is_personal, is_deleted, update_time, ",
        "create_time",
        "from user_institution_detail",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserInstitutionDetailDAO.BaseResultMap")
    UserInstitutionDetailDO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInstitutionDetailDO record);

    @Update({
        "update user_institution_detail",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "contact_name = #{contactName,jdbcType=VARCHAR},",
          "contact_mobile = #{contactMobile,jdbcType=VARCHAR},",
          "is_personal = #{isPersonal,jdbcType=TINYINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserInstitutionDetailDO record);
}