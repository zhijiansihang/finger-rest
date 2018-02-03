package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDOExample;

import java.math.BigDecimal;
import java.util.List;

import com.zhijiansihang.finger.app.vo.LoanInvestorFinanceVO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

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

    @Select({
            "select count(*)",
            "from loan_investor_finance",
            "where finance_user_id = #{userId,jdbcType=BIGINT} and is_deal =1"
    })
    int countDealByFinanceUserid(Long userId);

    @Select({
            "select count(*)",
            "from loan_investor_finance",
            "where finance_user_id = #{userId,jdbcType=BIGINT} and is_deal =0"
    })
    int countNotDealByFinanceUserid(Long userId);

    @Select({
            "select count(*)",
            "from loan_investor_finance",
            "where finance_user_id = #{userId,jdbcType=BIGINT}"
    })
    int countByFinanceUserid(Long userId);

    @Select({
            "select lif.id,l.title,lif.amount,user.real_name",
            "from loan_investor_finance",
            "where finance_user_id = #{userId,jdbcType=BIGINT} and is_deal = 0",
            "order by create_time desc"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "realName", column = "real_name")
    })
    List<LoanInvestorFinanceVO> selectNotDealByFinanceUseridPage(@Param("userId") Long userId, RowBounds rowBounds);

    @Select({
            "select lif.id,l.title,lif.amount,user.real_name",
            "from loan_investor_finance lif ,loan l,user u",
            "where lif.loan_id = l.loan_id and lif.user_id = u.user_id and lif.finance_user_id = #{userId,jdbcType=BIGINT} and lif.is_deal = 1",
            "order by lif.create_time desc"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "realName", column = "real_name")
    })
    List<LoanInvestorFinanceVO> selectDealByFinanceUseridPage(@Param("userId")Long userId, RowBounds rowBounds);

    @Select({
            "select count(*)",
            "from loan_investor_finance",
            "where user_id = #{userId,jdbcType=BIGINT} and is_deal =0"
    })
    int countNotDealByUserid(Long userId);
    @Select({
            "select count(*)",
            "from loan_investor_finance",
            "where user_id = #{userId,jdbcType=BIGINT} and is_deal =1"
    })
    int countDealByUserid(Long userId);

    @Select({
            "select lif.id,l.title,lif.amount,user.real_name",
            "from loan_investor_finance lif ,loan l,user u",
            "where lif.loan_id = l.loan_id and lif.user_id = u.user_id and lif.user_id = #{userId,jdbcType=BIGINT} and lif.is_deal = 0",
            "order by lif.create_time desc"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "realName", column = "real_name")
    })
    List<LoanInvestorFinanceVO> selectNotDealByUseridPage(@Param("userId") Long userId, RowBounds rowBounds);

    @Select({
            "select lif.id,l.title,lif.amount,user.real_name",
            "from loan_investor_finance lif ,loan l,user u",
            "where lif.loan_id = l.loan_id and lif.user_id = u.user_id and lif.user_id = #{userId,jdbcType=BIGINT} and lif.is_deal = 1",
            "order by lif.create_time desc"
    })
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "realName", column = "real_name")
    })
    List<LoanInvestorFinanceVO> selectDealByUseridPage(@Param("userId") Long userId, RowBounds rowBounds);


    @Select({
            "select count(*)",
            "from loan_investor_finance",
            "where user_id = #{userId} and loan_id =#{loanId}"
    })
    int countBuy(LoanInvestorFinanceDO loanInvestorFinanceDO);
}