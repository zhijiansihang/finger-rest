package com.zhijiansihang.sys;

import com.zhijiansihang.finger.app.dao.mysql.mapper.UserFinanceDetailDAO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.UserFinanceDetailSelect;
import com.zhijiansihang.finger.app.vo.UserFinanceDetailVO;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewayApplicationTests {
    @Autowired
    UserFinanceDetailDAO userFinanceDetailDAO;

    @Test
    public void contextLoads() {
        String order = "0";
        //0:全部1:机构理财师2:个人理财师
        String type = "1";

        UserFinanceDetailSelect userFinanceDetailSelect = new UserFinanceDetailSelect();
        userFinanceDetailSelect.setFinanceOrder(Integer.parseInt(order.trim()));
        userFinanceDetailSelect.setFinanceType(Integer.parseInt(type.trim()));
        Long id = UserTools.getLoginUser().getId();
        Page<UserFinanceDetailSelect, UserFinanceDetailVO> page = Page.create();
        page.setCurrentPage(1);
        page.setPageSize(10);
        page.setSelect(userFinanceDetailSelect);

        int count = userFinanceDetailDAO.selectCountByFinanceType(userFinanceDetailSelect);
        page.setRecordCount(count);

        if (count > 0) {
            List<UserFinanceDetailVO> cmsDOS = userFinanceDetailDAO.selectByFinanceType(userFinanceDetailSelect, page.getRowBounds());
        }
        System.out.println(page);
    }

}
