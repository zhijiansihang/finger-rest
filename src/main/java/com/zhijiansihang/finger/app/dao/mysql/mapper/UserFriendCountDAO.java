package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendCountDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserFriendCountDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserFriendCountDAO {
    @Delete({
        "delete from user_friend_count",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    @Insert({
        "insert into user_friend_count (user_id, friend_counts, ",
        "create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{friendCounts,jdbcType=BIGINT}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserFriendCountDO record);

    int insertSelective(UserFriendCountDO record);

    List<UserFriendCountDO> selectByExampleWithRowbounds(UserFriendCountDOExample example, RowBounds rowBounds);

    List<UserFriendCountDO> selectByExample(UserFriendCountDOExample example);

    @Select({
        "select",
        "user_id, friend_counts, create_time",
        "from user_friend_count",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserFriendCountDAO.BaseResultMap")
    UserFriendCountDO selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserFriendCountDO record);

    @Update({
        "update user_friend_count",
        "set friend_counts = #{friendCounts,jdbcType=BIGINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserFriendCountDO record);


    @Update({
            "update user_friend_count",
            "set friend_counts = friend_counts + 1 ",
            "where user_id = #{userId}"
    })
    int addFriendCounts(Long userId);
}