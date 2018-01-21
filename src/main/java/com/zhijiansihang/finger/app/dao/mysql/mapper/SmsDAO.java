package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.SmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.SmsDOExample;
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
public interface SmsDAO {
    @Delete({
        "delete from sms",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sms (mobile, req_message, ",
        "resp_message, channel_name, ",
        "template_code, request_id, ",
        "biz_id, send_status, ",
        "create_time, update_time)",
        "values (#{mobile,jdbcType=VARCHAR}, #{reqMessage,jdbcType=VARCHAR}, ",
        "#{respMessage,jdbcType=VARCHAR}, #{channelName,jdbcType=VARCHAR}, ",
        "#{templateCode,jdbcType=VARCHAR}, #{requestId,jdbcType=VARCHAR}, ",
        "#{bizId,jdbcType=VARCHAR}, #{sendStatus,jdbcType=TINYINT}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SmsDO record);

    int insertSelective(SmsDO record);

    List<SmsDO> selectByExampleWithRowbounds(SmsDOExample example, RowBounds rowBounds);

    List<SmsDO> selectByExample(SmsDOExample example);

    @Select({
        "select",
        "id, mobile, req_message, resp_message, channel_name, template_code, request_id, ",
        "biz_id, send_status, create_time, update_time",
        "from sms",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.SmsDAO.BaseResultMap")
    SmsDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsDO record);

    @Update({
        "update sms",
        "set mobile = #{mobile,jdbcType=VARCHAR},",
          "req_message = #{reqMessage,jdbcType=VARCHAR},",
          "resp_message = #{respMessage,jdbcType=VARCHAR},",
          "channel_name = #{channelName,jdbcType=VARCHAR},",
          "template_code = #{templateCode,jdbcType=VARCHAR},",
          "request_id = #{requestId,jdbcType=VARCHAR},",
          "biz_id = #{bizId,jdbcType=VARCHAR},",
          "send_status = #{sendStatus,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SmsDO record);
}