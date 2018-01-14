package com.shawn.finger.dao.mysql.mapper;

import com.shawn.finger.dao.mysql.model.UserCollectionDO;
import com.shawn.finger.dao.mysql.model.UserCollectionDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserCollectionDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_collection",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_collection (user_id, content_id, ",
        "content_type, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{contentId,jdbcType=BIGINT}, ",
        "#{contentType,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserCollectionDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserCollectionDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserCollectionDO> selectByExampleWithRowbounds(UserCollectionDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserCollectionDO> selectByExample(UserCollectionDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, user_id, content_id, content_type, create_time",
        "from user_collection",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.shawn.finger.dao.mysql.mapper.UserCollectionDAO.BaseResultMap")
    UserCollectionDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserCollectionDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_collection",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "content_id = #{contentId,jdbcType=BIGINT},",
          "content_type = #{contentType,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserCollectionDO record);
}