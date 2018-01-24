package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDOExample;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserFriendDAO {
    @Delete({
            "delete from user_friend",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
            "insert into user_friend (my_user_id, friend_user_id, ",
            "create_time)",
            "values (#{myUserId,jdbcType=BIGINT}, #{friendUserId,jdbcType=BIGINT}, ",
            "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    int insert(UserFriendDO record);

    int insertSelective(UserFriendDO record);

    List<UserFriendDO> selectByExampleWithRowbounds(UserFriendDOExample example, RowBounds rowBounds);

    List<UserFriendDO> selectByExample(UserFriendDOExample example);

    @Select({
            "select",
            "id, my_user_id, friend_user_id, create_time",
            "from user_friend",
            "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendDAO.BaseResultMap")
    UserFriendDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFriendDO record);

    @Update({
            "update user_friend",
            "set my_user_id = #{myUserId,jdbcType=BIGINT},",
            "friend_user_id = #{friendUserId,jdbcType=BIGINT},",
            "create_time = #{createTime,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserFriendDO record);

    @Select({
            "select count(*)",
            "from user_friend",
            "where my_user_id = #{myUserId} and friend_user_id = #{friendUserId}"
    })
    int existFriendUserid(UserFriendDO userFriendDO);

    @Select({
            "select count(*)",
            "from user_friend",
            "where my_user_id = #{myUserId}"
    })
    int countByUserid(Long myUserId);

    @Select({
            "select uf.friend_user_id,u.real_name,u.logo ",
            "from user_friend uf,user u",
            "where uf.my_user_id = #{myUserId} and uf.friend_user_id = u.user_id",
            "order by uf.create_time desc"
    })
    @Results({
            @Result(property = "userId", column = "friend_user_id"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "logo", column = "logo")
    })
    List<UserDO> selectByUseridPage(Long id, RowBounds rowBounds);
}