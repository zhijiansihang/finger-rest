package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserCollectionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserCollectionDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface UserCollectionDAO {
    @Delete({
        "delete from user_collection",
        "where id = #{id} and user_id = #{userid} "
    })
    int deleteByPrimaryKey(@Param("id") Long id,@Param("userid") Long userid);

    @Insert({
        "insert into user_collection (user_id, content_id, ",
        "content_type, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{contentId,jdbcType=BIGINT}, ",
        "#{contentType,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserCollectionDO record);

    int insertSelective(UserCollectionDO record);

    List<UserCollectionDO> selectByExampleWithRowbounds(UserCollectionDOExample example, RowBounds rowBounds);

    List<UserCollectionDO> selectByExample(UserCollectionDOExample example);

    @Select({
        "select",
        "id, user_id, content_id, content_type, create_time",
        "from user_collection",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserCollectionDAO.BaseResultMap")
    UserCollectionDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCollectionDO record);

    @Update({
        "update user_collection",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "content_id = #{contentId,jdbcType=BIGINT},",
          "content_type = #{contentType,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserCollectionDO record);

    @Select({
            "select count(*)",
            "from user_collection",
            "where user_id = #{userId} AND content_id=#{contentId} AND content_type=#{contentType}"
    })
    int existContentidtypeAndUserid(UserCollectionDO userCollection);

    @Select({
            "select * ",
            "from user_collection",
            "where user_id = #{userId} AND content_id=#{contentId} AND content_type=#{contentType}"
    })
    UserCollectionDO getContentidtypeAndUserid(UserCollectionDO userCollection);

    @Select({
            "select count(*)",
            "from user_collection",
            "where user_id = #{userId} AND content_type=1"
    })
    int countFinanceByUserid(Long userId);

    @Select({
            "select count(*)",
            "from user_collection",
            "where user_id = #{userId} AND content_type=2"
    })
    int countLoanByUserid(Long userId);
}