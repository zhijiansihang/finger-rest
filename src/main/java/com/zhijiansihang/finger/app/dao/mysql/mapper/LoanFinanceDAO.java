package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.LoanFinanceDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanFinanceDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface LoanFinanceDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from loan_finance",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into loan_finance (loan_id, finance_user_id, ",
        "is_deleted, update_time, ",
        "create_time)",
        "values (#{loanId,jdbcType=BIGINT}, #{financeUserId,jdbcType=BIGINT}, ",
        "#{isDeleted,jdbcType=TINYINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(LoanFinanceDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LoanFinanceDO record);

    /**
     *
     * @mbg.generated
     */
    List<LoanFinanceDO> selectByExampleWithRowbounds(LoanFinanceDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<LoanFinanceDO> selectByExample(LoanFinanceDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, loan_id, finance_user_id, is_deleted, update_time, create_time",
        "from loan_finance",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.dao.mysql.mapper.LoanFinanceDAO.BaseResultMap")
    LoanFinanceDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LoanFinanceDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update loan_finance",
        "set loan_id = #{loanId,jdbcType=BIGINT},",
          "finance_user_id = #{financeUserId,jdbcType=BIGINT},",
          "is_deleted = #{isDeleted,jdbcType=TINYINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanFinanceDO record);
}