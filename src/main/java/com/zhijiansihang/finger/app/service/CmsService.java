package com.zhijiansihang.finger.app.service;


import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.dao.mysql.mapper.CmsDAO;

import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.app.vo.CmsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CmsService {
    private static Logger logger = LoggerFactory.getLogger(CmsService.class);

    @Autowired
    private CmsDAO cmsDAO;


    public Page findCmsPage(CmsVO cmsVO) {
        logger.info("分页取cms 列表");

        Page<CmsVO,CmsDO> page = Page.create();
        page.setCurrentPage(cmsVO.getCurrentPage());
        page.setPageSize(cmsVO.getPageSize());
        page.setSelect(cmsVO);
        int countByCmsVO = cmsDAO.countByCmsVO(cmsVO);
        page.setRecordCount(countByCmsVO);
        if (countByCmsVO > 0 ){
            List<CmsDO> cmsDOS = cmsDAO.selectByCmsVO(cmsVO, page.getRowBounds());
            page.setResults(cmsDOS);
        }
        return page;
    }

    public Response save(CmsVO cmsVO, Long userId) {
        if(cmsVO.getId() == null){
            cmsVO.setCreateBy(userId);
            cmsVO.setCreateTime(new Date());
            if(cmsDAO.insert(cmsVO) <= 0)
                return Response.error("添加失败");
        }else {
            cmsVO.setUpdateBy(userId);
            cmsVO.setUpdateTime(new Date());
            if(cmsDAO.updateByPrimaryKey(cmsVO) <= 0)
                return Response.error("更新失败");
        }
        return Response.success("成功");
    }

    public Response updateByPrimaryKeySelective(CmsVO cmsVO, Long userId){
        cmsVO.setUpdateBy(userId);
        cmsVO.setUpdateTime(new Date());
        if(cmsDAO.updateByPrimaryKeySelective(cmsVO) <= 0)
            return Response.error("更新失败");
        return Response.success("成功");
    }

    public Response delete(Long id) {
        if(cmsDAO.deleteByPrimaryKey(id) <= 0)
            return Response.error("删除失败");
        return Response.success("删除成功");
    }

    public Response getById(Long id) {
        CmsDO cmsDO = cmsDAO.selectByPrimaryKey(id);
        if (cmsDO == null){
           return Response.error(" 数据不存在");
        }else{
            return Response.success(cmsDO);
        }

    }
}
