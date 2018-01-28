package com.zhijiansihang.finger.app.vo;

import com.zhijiansihang.finger.app.dao.mysql.model.UserFinanceDetailDO;

/**
 * Created by paul on 2018/1/27.
 */
public class UserFinanceDetailSelect {
    public Integer getFinanceOrder() {
        return financeOrder;
    }

    public void setFinanceOrder(Integer financeOrder) {
        this.financeOrder = financeOrder;
    }

    //0:默认排序1:按产品数量排序2:按预约单数排序3:按关注度排序
    public Integer financeOrder;

    public Integer getFinanceType() {
        return financeType;
    }

    public void setFinanceType(Integer financeType) {
        this.financeType = financeType;
    }

    //0:全部1:机构理财师2:个人理财师
    public Integer financeType;
}
