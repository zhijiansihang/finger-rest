package com.zhijiansihang.finger.app.controller;

import com.zhijiansihang.finger.app.constant.CmsConsts;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by paul on 2018/4/7.
 */

@Controller
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @PostMapping("/user/avatar/upload/{userId}")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                  @PathVariable("userId") Integer userId ) throws Exception {
        String storageLocationPrefix = CmsConsts.CmsEnum.avatar.getStorageLocationPrefix();
        String accessLocationPrefix = CmsConsts.CmsEnum.avatar.getAccessLocationPrefix();

        FileUtils.forceMkdir(new File(storageLocationPrefix));

        String ext =  FilenameUtils.getExtension(file.getOriginalFilename());

        String logoFileName = storageLocationPrefix + userId + "." + ext;
        file.transferTo(new File(logoFileName));
        return accessLocationPrefix + userId + "." + ext;
    }

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
            if (file!=null &&imageName.endsWith("png")){
                httpServletResponse.setContentType("image/png");
            }else {
                httpServletResponse.setContentType("image/jpeg");

            }
            httpServletResponse.getOutputStream().write(
                    FileUtils.readFileToByteArray(file));
            httpServletResponse.getOutputStream().close();
        }catch (Exception e){
            logger.error(e.getMessage(),e.fillInStackTrace());
            httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
