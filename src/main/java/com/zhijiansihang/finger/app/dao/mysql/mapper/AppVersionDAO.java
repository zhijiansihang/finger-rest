package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.AppVersionDO;
import com.zhijiansihang.finger.app.dao.mysql.model.AppVersionDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface AppVersionDAO {
    @Delete({
        "delete from app_version",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into app_version (app_name, platform, ",
        "version_code, version_name, ",
        "min_version_code, update_title, ",
        "update_content, update_time, ",
        "update_status, update_url)",
        "values (#{appName,jdbcType=VARCHAR}, #{platform,jdbcType=VARCHAR}, ",
        "#{versionCode,jdbcType=INTEGER}, #{versionName,jdbcType=VARCHAR}, ",
        "#{minVersionCode,jdbcType=INTEGER}, #{updateTitle,jdbcType=VARCHAR}, ",
        "#{updateContent,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updateStatus,jdbcType=VARCHAR}, #{updateUrl,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(AppVersionDO record);

    int insertSelective(AppVersionDO record);

    List<AppVersionDO> selectByExampleWithRowbounds(AppVersionDOExample example, RowBounds rowBounds);

    List<AppVersionDO> selectByExample(AppVersionDOExample example);

    @Select({
        "select",
        "id, app_name, platform, version_code, version_name, min_version_code, update_title, ",
        "update_content, update_time, update_status, update_url",
        "from app_version",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.AppVersionDAO.BaseResultMap")
    AppVersionDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppVersionDO record);

    @Update({
        "update app_version",
        "set app_name = #{appName,jdbcType=VARCHAR},",
          "platform = #{platform,jdbcType=VARCHAR},",
          "version_code = #{versionCode,jdbcType=INTEGER},",
          "version_name = #{versionName,jdbcType=VARCHAR},",
          "min_version_code = #{minVersionCode,jdbcType=INTEGER},",
          "update_title = #{updateTitle,jdbcType=VARCHAR},",
          "update_content = #{updateContent,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_status = #{updateStatus,jdbcType=VARCHAR},",
          "update_url = #{updateUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(AppVersionDO record);



    @Select({
            "select",
            "id, app_name, platform, version_code, version_name, min_version_code, update_title, ",
            "update_content, update_time, update_status, update_url",
            "from app_version",
            "where ",
            "app_name=#{appName} and platform = #{platform} ",
            "AND version_code = (select max(version_code) FROM app_version WHERE app_name=#{appName} and platform = #{platform} and update_status = 1)"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.AppVersionDAO.BaseResultMap")
    AppVersionDO getNewestVersionByAppNameAndPlatform(@Param("appName")String appName, @Param("platform")String platform);

//    @Select({
//            "select",
//            "id, app_name, platform, version_code, version_name, min_version_code, update_title, ",
//            "update_content, update_time, update_status, update_url",
//            "from app_version",
//            "where ",
//            "app_name=#{appName} and platform = #{platform} AND update_status = 1 AND version_code > #{versionCode} order by version_code desc"
//    })
//    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.AppVersionDAO.BaseResultMap")
//    List<AppVersionDO> queryNewerVersionList(String appName, String platform, Integer versionCode);
}