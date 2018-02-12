package com.zhijiansihang.finger.app.controller;


        import com.zhijiansihang.common.ComParams;
        import com.zhijiansihang.common.Response;
        import com.zhijiansihang.finger.app.constant.CmsConsts;
        import com.zhijiansihang.finger.app.service.CmsService;
        import com.zhijiansihang.finger.app.vo.CmsVO;
        import org.apache.commons.io.FileUtils;
        import org.apache.commons.io.FilenameUtils;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.ServletInputStream;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.File;
        import java.util.UUID;

/**
 * @author paul
 * @description
 * @date 2018/1/3
 */
@RestController
public class CmsController {
    private static final Logger logger = LoggerFactory.getLogger(CmsController.class);


    @Autowired
    private CmsService cmsService;

    /**
     *
     * @param cmsEnumName  com.paulzhangcc.demo.constant.CmsConsts.CmsEnum#name()
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping(CmsConsts.ACCESS_PREFIX_0+"/{name}/{imageName:.*}")
    public void viewPicture(@PathVariable("name") String cmsEnumName , @PathVariable("imageName") String imageName, HttpServletResponse httpServletResponse) throws Exception {
        if (imageName !=null && imageName.contains("../")){
            throw new IllegalAccessException("Illegal image name");
        }
        try {
            File file = new File(CmsConsts.CmsEnum.valueOf(cmsEnumName).getStorageLocationPrefix() + imageName);
            httpServletResponse.getOutputStream().write(
                    FileUtils.readFileToByteArray(file));
            httpServletResponse.getOutputStream().close();
        }catch (Exception e){
            logger.error(e.getMessage(),e.fillInStackTrace());
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @RequestMapping("/user/avatar/upload/{userId}")
    public String uploadUserId(HttpServletRequest request, @PathVariable("userId") Integer userId) throws Exception{
        ServletInputStream inputStream = request.getInputStream();

        String storageLocationPrefix = CmsConsts.CmsEnum.avatar.getStorageLocationPrefix();
        String accessLocationPrefix = CmsConsts.CmsEnum.avatar.getAccessLocationPrefix();

        FileUtils.forceMkdir(new File(storageLocationPrefix));
        String logoFileName = storageLocationPrefix + userId + ".jpg";
        FileUtils.copyInputStreamToFile(inputStream,new File(logoFileName));
        return  accessLocationPrefix + userId + ".jpg";
    }

    /**
     *  cms分页
     * @return
     */
    @RequestMapping(value = "/cms/page")
    @ResponseBody
    public Response page(@RequestBody CmsVO  cmsVO) {
        return Response.success(cmsService.findCmsPage(cmsVO));
    }

    /**
     *  根据Id获取
     * @return
     */
    @RequestMapping(value = "/cms/get")
    @ResponseBody
    public Response save(@RequestBody CmsVO  cmsVO) {
        return cmsService.getById(cmsVO.getId());
    }

    /**
     *  cms保存
     * @return
     */
    @RequestMapping(value = "/cms/save")
    @ResponseBody
    public Response save(@RequestParam(ComParams.X_USERID)Long userId, @RequestBody CmsVO  cmsVO) {
        return cmsService.save(cmsVO, userId);
    }
    /**
     *  修改
     * @return
     */
    @RequestMapping(value = "/cms/update")
    @ResponseBody
    public Response update(@RequestParam(ComParams.X_USERID)Long userId, @RequestBody CmsVO  cmsVO) {
        return cmsService.updateByPrimaryKeySelective(cmsVO, userId);
    }

    /**
     *  删除
     * @return
     */
    @RequestMapping(value = "/cms/delete")
    @ResponseBody
    public Response delete(@RequestBody CmsVO  cmsVO) {
        return cmsService.delete(cmsVO.getId());
    }

    @RequestMapping("/cms/{name}/upload")
    public Response uploadUserId(@RequestParam("file")MultipartFile file, @PathVariable("name") String cmsEnumName) throws Exception{
        String storageLocationPrefix = CmsConsts.CmsEnum.valueOf(cmsEnumName).getStorageLocationPrefix();
        String accessLocationPrefix = CmsConsts.CmsEnum.valueOf(cmsEnumName).getAccessLocationPrefix();

        FileUtils.forceMkdir(new File(storageLocationPrefix));

        String filename = UUID.randomUUID().toString();
        String ext =  FilenameUtils.getExtension(file.getOriginalFilename());

        String logoFileName = storageLocationPrefix + filename + "." + ext;
        file.transferTo(new File(logoFileName));
        return Response.success(accessLocationPrefix + filename + "." + ext);
    }


}
