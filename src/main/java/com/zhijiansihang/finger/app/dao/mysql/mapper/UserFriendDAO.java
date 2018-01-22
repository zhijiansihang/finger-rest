package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendDOExample;
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
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
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
}