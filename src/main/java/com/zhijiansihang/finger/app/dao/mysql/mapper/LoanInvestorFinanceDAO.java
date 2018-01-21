package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDOExample;
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
public interface LoanInvestorFinanceDAO {
    @Delete({
        "delete from loan_investor_finance",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into loan_investor_finance (loan_id, user_id, ",
        "real_name, mobile, ",
        "amount, finance_user_id, ",
        "is_deal, update_time, ",
        "create_time)",
        "values (#{loanId,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{realName,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{amount,jdbcType=DECIMAL}, #{financeUserId,jdbcType=BIGINT}, ",
        "#{isDeal,jdbcType=TINYINT}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(LoanInvestorFinanceDO record);

    int insertSelective(LoanInvestorFinanceDO record);

    List<LoanInvestorFinanceDO> selectByExampleWithRowbounds(LoanInvestorFinanceDOExample example, RowBounds rowBounds);

    List<LoanInvestorFinanceDO> selectByExample(LoanInvestorFinanceDOExample example);

    @Select({
        "select",
        "id, loan_id, user_id, real_name, mobile, amount, finance_user_id, is_deal, update_time, ",
        "create_time",
        "from loan_investor_finance",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.LoanInvestorFinanceDAO.BaseResultMap")
    LoanInvestorFinanceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoanInvestorFinanceDO record);

    @Update({
        "update loan_investor_finance",
        "set loan_id = #{loanId,jdbcType=BIGINT},",
          "user_id = #{userId,jdbcType=BIGINT},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "finance_user_id = #{financeUserId,jdbcType=BIGINT},",
          "is_deal = #{isDeal,jdbcType=TINYINT},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanInvestorFinanceDO record);
}