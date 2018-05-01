package com.zhijiansihang.finger.app.vo;

import com.zhijiansihang.finger.app.dao.mysql.model.LoanInvestorFinanceDO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BiConsumer;

/**
 * Created by paul on 2018/1/28.
 */
public class LoanInvestorFinanceVO extends LoanInvestorFinanceDO{

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private BigDecimal amount;
    private Long id;
    private String realName;
    private String title;
    private String financeUserName;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String logo;
    private Long userId;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFinanceUserName() {
        return financeUserName;
    }

    public void setFinanceUserName(String financeUserName) {
        this.financeUserName = financeUserName;
    }
}
