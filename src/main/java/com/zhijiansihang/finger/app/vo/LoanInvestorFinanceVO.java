package com.zhijiansihang.finger.app.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BiConsumer;

/**
 * Created by paul on 2018/1/28.
 */
public class LoanInvestorFinanceVO {

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;
}
