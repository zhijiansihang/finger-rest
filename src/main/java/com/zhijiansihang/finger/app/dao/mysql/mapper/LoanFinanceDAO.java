package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.LoanFinanceDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanFinanceDOExample;
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
public interface LoanFinanceDAO {
    @Delete({
        "delete from loan_finance",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

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

    int insertSelective(LoanFinanceDO record);

    List<LoanFinanceDO> selectByExampleWithRowbounds(LoanFinanceDOExample example, RowBounds rowBounds);

    List<LoanFinanceDO> selectByExample(LoanFinanceDOExample example);

    @Select({
        "select",
        "id, loan_id, finance_user_id, is_deleted, update_time, create_time",
        "from loan_finance",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.LoanFinanceDAO.BaseResultMap")
    LoanFinanceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoanFinanceDO record);

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

    @Select({
            "select count(*)",
            "from loan_finance",
            "where finance_user_id  = #{financeUserid}"
    })
    int countLoanByFinanceUser(Long financeUserid);

    @Select({
            "select count(*)",
            "from loan_finance lf ,loan l",
            "where lf.finance_user_id  = #{financeUserid} and lf.loan_id = l.loan_id  and l.loan_status = 200"
    })
    int countSellingLoanByFinanceUser(Long financeUserid);    @Select({
            "select count(*)",
            "from loan_finance lf ,loan l",
            "where lf.finance_user_id  = #{financeUserid} and lf.loan_id = l.loan_id  and l.loan_status = 300"
    })
    int countSelledLoanByFinanceUser(Long financeUserid);

    @Select({
            "select count(*)",
            "from loan_finance",
            "where loan_id  = #{loanId}"
    })
    int countFinanceUserByLoanId(Long loanId);

    @Delete({
            "delete from loan_finance",
            "where loan_id = #{loanId}"
    })
    void deleteByLoanId(Long loanId);
}