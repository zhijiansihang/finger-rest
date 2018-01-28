package com.zhijiansihang.finger.gen.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.zhijiansihang.finger.app.constant.CmsConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.CmsDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.CmsDO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.app.sharing.SharingProperties;
import com.zhijiansihang.finger.app.tool.Page;
import com.zhijiansihang.finger.gen.tool.CheckTools;
import com.zhijiansihang.finger.gen.tool.UserTools;
import com.zhijiansihang.finger.mmc.MessageService;
import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.gen.entity.GetCmsRequest;
import com.zhijiansihang.finger.gen.entity.GetCmsResponse;
import com.zhijiansihang.finger.gen.entity.GetCmsResponse.CmsListElement;

import org.apache.poi.hssf.record.OldFormulaRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * 获取banner咨询公告
 */
@Component("getCmsService")
public class GetCmsService implements MessageService<GetCmsRequest, Response<GetCmsResponse>> {

    private static final Logger LOG = LoggerFactory.getLogger(GetCmsService.class);
    private static final String SERVICE_DESC = "获取banner咨询公告";
    @Autowired
    CmsDAO cmsDAO;
    @Autowired
    SharingProperties sharingProperties;

    @Override
    public void execute(GetCmsRequest request, Response<GetCmsResponse> response) {
        LOG.info("[{}][request={}]", SERVICE_DESC, request);

        int typeCode = Integer.parseInt(request.getTypeCode().trim());
        Page<Long, UserDO> page = Page.create();
        page.setCurrentPage(CheckTools.isInteger(request.getCurrentPage()) ? Integer.parseInt(request.getCurrentPage()) : 1);
        page.setPageSize(CheckTools.isInteger(request.getPageSize()) ? Integer.parseInt(request.getPageSize()) : 10);
        page.setSelect((long) typeCode);
        int count = cmsDAO.countByTypeCode(typeCode);
        page.setRecordCount(count);

        if (count > 0) {
            List<CmsDO> cmsDOS = cmsDAO.selectByTypeCodePage(typeCode, page.getRowBounds());
            response.getBody().setCmsList(getCmsList(cmsDOS));
        } else {
            response.getBody().setCmsList(new ArrayList<>());
        }
        response.getBody().setTypeCode(typeCode+"");
        response.getBody().setCurrentPage(page.getCurrentPage() + "");
        response.getBody().setPageCount(page.getPageCount() + "");
        response.getBody().setPageSize(page.getPageSize() + "");
        response.getBody().setRecordCount(page.getRecordCount() + "");
    }

    private List<CmsListElement> getCmsList(List<CmsDO> cmsDOS) {
        List<CmsListElement> elems = new ArrayList<CmsListElement>();
        if (cmsDOS == null) {
            return elems;
        }

        for (CmsDO cmsDO : cmsDOS){
            CmsListElement elem = new CmsListElement();
            elems.add(elem);

            elem.setContent(cmsDO.getContent());
            elem.setHrefLink(cmsDO.getHrefLink());
            elem.setId(cmsDO.getId().toString());
            elem.setImageAccessPath("1");
            if (cmsDO.getImageAccessPath() !=null && cmsDO.getImageAccessPath().trim().length()>0){
                elem.setImageAccessPath(sharingProperties.getStaticServerLink()+cmsDO.getImageAccessPath());
            }else {
                elem.setImageAccessPath("");
            }
            elem.setSubTitle(cmsDO.getSubTitle());
            elem.setTitle(cmsDO.getTitle());
        }


        return elems;
    }
}
