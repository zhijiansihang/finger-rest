package com.zhijiansihang.finger.app.controller;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.CmsDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.CmsDOExample;
import com.zhijiansihang.finger.app.service.UserDetailService;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.CmsVO;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    SharingProperties sharingProperties;
    /**
     * hello world
     *
     * @return
     */
    @RequestMapping("/world")
    @ResponseBody
    public Response world() {
        logger.info("hello world");
        logger.info(sharingProperties.toString());
        return Response.success("aaa");
    }

    @Autowired
    CmsDAO cmsDAO;

    /**
     * /hello/page?currentPage=1&typeCode=4
     * @param cmsVO
     * @return
     */
    @RequestMapping("/page")
    @ResponseBody
    public Response page(CmsVO  cmsVO) {
        Page<CmsVO,CmsDO> page = Page.create();
        page.setCurrentPage(cmsVO.getCurrentPage());
        page.setSelect(cmsVO);
        int countByCmsVO = cmsDAO.countByCmsVO(cmsVO);
        page.setRecordCount(countByCmsVO);
        if (countByCmsVO > 0 ){
            List<CmsDO> cmsDOS = cmsDAO.selectByCmsVO(cmsVO, page.getRowBounds());
            page.setResults(cmsDOS);
        }
        return Response.success(page);
    }

    /**
     * /hello/top10?typeCode=3
     * @param cmsVO
     * @return
     */
    @RequestMapping("/top10")
    @ResponseBody
    public Response top10(CmsVO  cmsVO) {
        CmsDOExample example = new CmsDOExample();
        example.createCriteria().andTypeCodeEqualTo(cmsVO.getTypeCode());
        example.setOrderByClause("id desc");
        List<CmsDO> cmsDOS = cmsDAO.selectByExampleWithRowbounds(example, new RowBounds(0, 10));
        return Response.success(cmsDOS);
    }

}
