package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserInstitutionDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserInstitutionDetailDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserInstitutionDetailDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_institution_detail",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_institution_detail (user_id, `name`, ",
        "contact_name, contact_mobile, ",
        "is_deleted, update_time, ",
        "create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{contactName,jdbcType=VARCHAR}, #{contactMobile,jdbcType=VARCHAR}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserInstitutionDetailDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserInstitutionDetailDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserInstitutionDetailDO> selectByExampleWithRowbounds(UserInstitutionDetailDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserInstitutionDetailDO> selectByExample(UserInstitutionDetailDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "user_id, `name`, contact_name, contact_mobile, is_deleted, update_time, create_time",
        "from user_institution_detail",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserInstitutionDetailDAO.BaseResultMap")
    UserInstitutionDetailDO selectByPrimaryKey(Long userId);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserInstitutionDetailDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_institution_detail",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "contact_name = #{contactName,jdbcType=VARCHAR},",
          "contact_mobile = #{contactMobile,jdbcType=VARCHAR},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserInstitutionDetailDO record);
}