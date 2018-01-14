package com.shawn.finger.dao.mysql.mapper;

import com.shawn.finger.dao.mysql.model.CmsDO;
import com.shawn.finger.dao.mysql.model.CmsDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface CmsDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from cms",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into cms (type_code, type_name, ",
        "image_path, image_access_path, ",
        "title, sub_title, ",
        "content, href_link, ",
        "is_front_display, is_deleted, ",
        "location_size, create_time, ",
        "create_by, update_time, ",
        "update_by)",
        "values (#{typeCode,jdbcType=SMALLINT}, #{typeName,jdbcType=VARCHAR}, ",
        "#{imagePath,jdbcType=VARCHAR}, #{imageAccessPath,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{subTitle,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{hrefLink,jdbcType=VARCHAR}, ",
        "#{isFrontDisplay,jdbcType=TINYINT}, #{isDeleted,jdbcType=TINYINT}, ",
        "#{locationSize,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{createBy,jdbcType=BIGINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CmsDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(CmsDO record);

    /**
     *
     * @mbg.generated
     */
    List<CmsDO> selectByExampleWithRowbounds(CmsDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<CmsDO> selectByExample(CmsDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, type_code, type_name, image_path, image_access_path, title, sub_title, content, ",
        "href_link, is_front_display, is_deleted, location_size, create_time, create_by, ",
        "update_time, update_by",
        "from cms",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.shawn.finger.dao.mysql.mapper.CmsDAO.BaseResultMap")
    CmsDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CmsDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update cms",
        "set type_code = #{typeCode,jdbcType=SMALLINT},",
          "type_name = #{typeName,jdbcType=VARCHAR},",
          "image_path = #{imagePath,jdbcType=VARCHAR},",
          "image_access_path = #{imageAccessPath,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "sub_title = #{subTitle,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "href_link = #{hrefLink,jdbcType=VARCHAR},",
          "is_front_display = #{isFrontDisplay,jdbcType=TINYINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "location_size = #{locationSize,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "create_by = #{createBy,jdbcType=BIGINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "update_by = #{updateBy,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CmsDO record);
}