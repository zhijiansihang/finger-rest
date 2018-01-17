package com.zhijiansihang.finger.app.dao.mysql.mapper;

import com.zhijiansihang.finger.app.dao.mysql.model.LoanDO;
import com.zhijiansihang.finger.app.dao.mysql.model.LoanDOExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface LoanDAO {
    /**
     *
     * @mbg.generated
     */
    @Delete({
        "delete from loan",
        "where loan_id = #{loanId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long loanId);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into loan (institution_user_id, title, ",
        "loan_type, product_type, ",
        "amount, reserve_amount, ",
        "loan_status, is_display, ",
        "location_size, product_direction, ",
        "safeguard_way, begin_amount, ",
        "earning_desc, issuer, ",
        "fund_type, servicing_way, ",
        "adaptation_deadline, investment_deadline, ",
        "distribution_region, ratio_type, ",
        "bright_spot, finance_introduce, ",
        "money_use, repay_source, ",
        "risk_control, product_desc, ",
        "product_desc_files, risk_alert, ",
        "capital_type, organize_form, ",
        "manage_rate, review_code, ",
        "review_desc, update_time, ",
        "create_time)",
        "values (#{institutionUserId,jdbcType=BIGINT}, #{title,jdbcType=VARCHAR}, ",
        "#{loanType,jdbcType=TINYINT}, #{productType,jdbcType=SMALLINT}, ",
        "#{amount,jdbcType=DECIMAL}, #{reserveAmount,jdbcType=DECIMAL}, ",
        "#{loanStatus,jdbcType=SMALLINT}, #{isDisplay,jdbcType=TINYINT}, ",
        "#{locationSize,jdbcType=INTEGER}, #{productDirection,jdbcType=VARCHAR}, ",
        "#{safeguardWay,jdbcType=VARCHAR}, #{beginAmount,jdbcType=DECIMAL}, ",
        "#{earningDesc,jdbcType=VARCHAR}, #{issuer,jdbcType=VARCHAR}, ",
        "#{fundType,jdbcType=SMALLINT}, #{servicingWay,jdbcType=SMALLINT}, ",
        "#{adaptationDeadline,jdbcType=SMALLINT}, #{investmentDeadline,jdbcType=SMALLINT}, ",
        "#{distributionRegion,jdbcType=VARCHAR}, #{ratioType,jdbcType=SMALLINT}, ",
        "#{brightSpot,jdbcType=VARCHAR}, #{financeIntroduce,jdbcType=VARCHAR}, ",
        "#{moneyUse,jdbcType=VARCHAR}, #{repaySource,jdbcType=VARCHAR}, ",
        "#{riskControl,jdbcType=VARCHAR}, #{productDesc,jdbcType=VARCHAR}, ",
        "#{productDescFiles,jdbcType=VARCHAR}, #{riskAlert,jdbcType=VARCHAR}, ",
        "#{capitalType,jdbcType=VARCHAR}, #{organizeForm,jdbcType=VARCHAR}, ",
        "#{manageRate,jdbcType=DECIMAL}, #{reviewCode,jdbcType=VARCHAR}, ",
        "#{reviewDesc,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="loanId", before=false, resultType=Long.class)
    int insert(LoanDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LoanDO record);

    /**
     *
     * @mbg.generated
     */
    List<LoanDO> selectByExampleWithRowbounds(LoanDOExample example, RowBounds rowBounds);

    /**
     *
     * @mbg.generated
     */
    List<LoanDO> selectByExample(LoanDOExample example);

    /**
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "loan_id, institution_user_id, title, loan_type, product_type, amount, reserve_amount, ",
        "loan_status, is_display, location_size, product_direction, safeguard_way, begin_amount, ",
        "earning_desc, issuer, fund_type, servicing_way, adaptation_deadline, investment_deadline, ",
        "distribution_region, ratio_type, bright_spot, finance_introduce, money_use, ",
        "repay_source, risk_control, product_desc, product_desc_files, risk_alert, capital_type, ",
        "organize_form, manage_rate, review_code, review_desc, update_time, create_time",
        "from loan",
        "where loan_id = #{loanId,jdbcType=BIGINT}"
    })
    @ResultMap("com.zhijiansihang.finger.app.dao.mysql.mapper.LoanDAO.BaseResultMap")
    LoanDO selectByPrimaryKey(Long loanId);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LoanDO record);

    /**
     *
     * @mbg.generated
     */
    @Update({
        "update loan",
        "set institution_user_id = #{institutionUserId,jdbcType=BIGINT},",
          "title = #{title,jdbcType=VARCHAR},",
          "loan_type = #{loanType,jdbcType=TINYINT},",
          "product_type = #{productType,jdbcType=SMALLINT},",
          "amount = #{amount,jdbcType=DECIMAL},",
          "reserve_amount = #{reserveAmount,jdbcType=DECIMAL},",
          "loan_status = #{loanStatus,jdbcType=SMALLINT},",
          "is_display = #{isDisplay,jdbcType=TINYINT},",
          "location_size = #{locationSize,jdbcType=INTEGER},",
          "product_direction = #{productDirection,jdbcType=VARCHAR},",
          "safeguard_way = #{safeguardWay,jdbcType=VARCHAR},",
          "begin_amount = #{beginAmount,jdbcType=DECIMAL},",
          "earning_desc = #{earningDesc,jdbcType=VARCHAR},",
          "issuer = #{issuer,jdbcType=VARCHAR},",
          "fund_type = #{fundType,jdbcType=SMALLINT},",
          "servicing_way = #{servicingWay,jdbcType=SMALLINT},",
          "adaptation_deadline = #{adaptationDeadline,jdbcType=SMALLINT},",
          "investment_deadline = #{investmentDeadline,jdbcType=SMALLINT},",
          "distribution_region = #{distributionRegion,jdbcType=VARCHAR},",
          "ratio_type = #{ratioType,jdbcType=SMALLINT},",
          "bright_spot = #{brightSpot,jdbcType=VARCHAR},",
          "finance_introduce = #{financeIntroduce,jdbcType=VARCHAR},",
          "money_use = #{moneyUse,jdbcType=VARCHAR},",
          "repay_source = #{repaySource,jdbcType=VARCHAR},",
          "risk_control = #{riskControl,jdbcType=VARCHAR},",
          "product_desc = #{productDesc,jdbcType=VARCHAR},",
          "product_desc_files = #{productDescFiles,jdbcType=VARCHAR},",
          "risk_alert = #{riskAlert,jdbcType=VARCHAR},",
          "capital_type = #{capitalType,jdbcType=VARCHAR},",
          "organize_form = #{organizeForm,jdbcType=VARCHAR},",
          "manage_rate = #{manageRate,jdbcType=DECIMAL},",
          "review_code = #{reviewCode,jdbcType=VARCHAR},",
          "review_desc = #{reviewDesc,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP}",
        "where loan_id = #{loanId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(LoanDO record);
}