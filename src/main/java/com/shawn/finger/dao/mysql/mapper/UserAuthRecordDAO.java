package com.shawn.finger.dao.mysql.mapper;

import com.shawn.finger.dao.mysql.model.UserAuthRecordDO;
import com.shawn.finger.dao.mysql.model.UserAuthRecordDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface UserAuthRecordDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from user_auth_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into user_auth_record (user_id, real_name, ",
        "id_card, req_message, ",
        "resp_message, request_id, ",
        "biz_id, send_status, ",
        "create_time, update_time)",
        "values (#{userId,jdbcType=BIGINT}, #{realName,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR}, #{reqMessage,jdbcType=VARCHAR}, ",
        "#{respMessage,jdbcType=VARCHAR}, #{requestId,jdbcType=VARCHAR}, ",
        "#{bizId,jdbcType=VARCHAR}, #{sendStatus,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(UserAuthRecordDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(UserAuthRecordDO record);

    /**
     *
     * @mbg.generated
     */
    List<UserAuthRecordDO> selectByExampleWithRowbounds(UserAuthRecordDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<UserAuthRecordDO> selectByExample(UserAuthRecordDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, user_id, real_name, id_card, req_message, resp_message, request_id, biz_id, ",
        "send_status, create_time, update_time",
        "from user_auth_record",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.shawn.finger.dao.mysql.mapper.UserAuthRecordDAO.BaseResultMap")
    UserAuthRecordDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserAuthRecordDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update user_auth_record",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "id_card = #{idCard,jdbcType=VARCHAR},",
          "req_message = #{reqMessage,jdbcType=VARCHAR},",
          "resp_message = #{respMessage,jdbcType=VARCHAR},",
          "request_id = #{requestId,jdbcType=VARCHAR},",
          "biz_id = #{bizId,jdbcType=VARCHAR},",
          "send_status = #{sendStatus,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserAuthRecordDO record);
}