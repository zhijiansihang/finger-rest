package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.UserInstitutionDetailDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserInstitutionDetailDOExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserRealnameAuthRecordDAO {


    @Insert({
        "insert into user_realname_auth_record (id,real_name,",
        "id_card)",
        "values (",
        "#{id,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{idCard,jdbcType=VARCHAR})"
    })
    int insert(@Param("id") String id,@Param("realName") String realName,@Param("idCard") String idCard);

    @Update({
        "update user_realname_auth_record",
        "set flag = #{flag,jdbcType=TINYINT},",
            "response_message = #{responseMessage,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateResponse(@Param("id") String id,@Param("flag") int flag,@Param("responseMessage") String responseMessage);
}