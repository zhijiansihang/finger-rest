package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserServiceRecordDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserServiceRecordDOExample;
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
public interface UserServiceRecordDAO {
    @Delete({
        "delete from user_service_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into user_service_record (user_id, person_user_id, ",
        "service_type, create_time)",
        "values (#{userId,jdbcType=BIGINT}, #{personUserId,jdbcType=BIGINT}, ",
        "#{serviceType,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserServiceRecordDO record);

    int insertSelective(UserServiceRecordDO record);

    List<UserServiceRecordDO> selectByExampleWithRowbounds(UserServiceRecordDOExample example, RowBounds rowBounds);

    List<UserServiceRecordDO> selectByExample(UserServiceRecordDOExample example);

    @Select({
        "select",
        "id, user_id, person_user_id, service_type, create_time",
        "from user_service_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.UserServiceRecordDAO.BaseResultMap")
    UserServiceRecordDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserServiceRecordDO record);

    @Update({
        "update user_service_record",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "person_user_id = #{personUserId,jdbcType=BIGINT},",
          "service_type = #{serviceType,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserServiceRecordDO record);
}