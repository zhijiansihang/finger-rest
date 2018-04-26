package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.CmsDOExample;

import java.io.Serializable;
import java.util.List;

import com.zhijiansihang.finger.app.vo.CmsVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.SingularAttribute;

@Mapper
public interface CmsDAO {
    @Delete({
        "delete from cms",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

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

    int insertSelective(CmsDO record);

    List<CmsDO> selectByExampleWithRowbounds(CmsDOExample example, RowBounds rowBounds);

    List<CmsDO> selectByExample(CmsDOExample example);

    @Select({
        "select",
        "id, type_code, type_name, image_path, image_access_path, title, sub_title, content, ",
        "href_link, is_front_display, is_deleted, location_size, create_time, create_by, ",
        "update_time, update_by",
        "from cms",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.CmsDAO.BaseResultMap")
    CmsDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsDO record);

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


    @Select({
            "select count(*)",
            "from cms",
            "where type_code = #{typeCode}",
    })
    int countByCmsVO(CmsVO cmsVO);

    @Select({
            "select",
            "id, type_code, type_name, image_path, image_access_path, title, sub_title, content, ",
            "href_link, is_front_display, is_deleted, location_size, create_time, create_by, ",
            "update_time, update_by",
            "from cms",
            "where type_code = #{typeCode}",
            "order by create_time desc"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.CmsDAO.BaseResultMap")
    List<CmsDO> selectByCmsVO(CmsVO cmsVO, RowBounds rowBounds);

    @Select({
            "select count(*)",
            "from cms",
            "where type_code = #{typeCode} and  is_front_display = 1 and is_deleted =0 "
    })
    int countByTypeCode(@Param("typeCode") Integer typeCode);

    @Select({
            "select",
            "id, type_code, type_name, image_path, image_access_path, title, sub_title, content, ",
            "href_link, is_front_display, is_deleted, location_size, create_time, create_by, ",
            "update_time, update_by",
            "from cms",
            "where type_code = #{typeCode} and  is_front_display = 1 and is_deleted =0 ",
            "order by location_size desc,location_size desc "
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.CmsDAO.BaseResultMap")
    List<CmsDO> selectByTypeCodePage(@Param("typeCode") Integer typeCode, RowBounds rowBounds);
}