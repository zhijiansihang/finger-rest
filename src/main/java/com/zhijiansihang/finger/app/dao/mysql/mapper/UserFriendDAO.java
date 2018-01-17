package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserFriendDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_friend",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_friend (my_user_id, friend_user_id, ",
        "create_time)",
        "values (#{myUserId,jdbcType=BIGINT}, #{friendUserId,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserFriendDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserFriendDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserFriendDO> selectByExampleWithRowbounds(UserFriendDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserFriendDO> selectByExample(UserFriendDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, my_user_id, friend_user_id, create_time",
        "from user_friend",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.dao.mysql.mapper.UserFriendDAO.BaseResultMap")
    UserFriendDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserFriendDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_friend",
        "set my_user_id = #{myUserId,jdbcType=BIGINT},",
          "friend_user_id = #{friendUserId,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserFriendDO record);
}