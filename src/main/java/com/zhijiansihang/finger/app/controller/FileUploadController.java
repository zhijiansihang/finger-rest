package com.zhijiansihang.finger.app.controller;

import com.zhijiansihang.common.Response;
import com.zhijiansihang.finger.app.constant.CmsConsts;
import com.zhijiansihang.finger.app.dao.mysql.mapper.UserDAO;
import com.zhijiansihang.finger.app.dao.mysql.model.UserDO;
import com.zhijiansihang.finger.gen.tool.UserTools;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

import static com.zhijiansihang.finger.app.constant.CmsConsts.ACCESS_PREFIX_0;
import static com.zhijiansihang.finger.app.constant.CmsConsts.CmsEnum.avatar;

/**
 * Created by paul on 2018/4/7.
 */

@Controller
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    UserDAO userDAO;
    @PostMapping("/user/avatar/upload/{userId}")
    @ResponseBody
    public Response<String> handleFileUpload(@RequestParam("file") MultipartFile file,
                                     @PathVariable("userId") Integer userId ) throws Exception {
            Long userid1 = UserTools.getLoginUser().getId();

        if (userId == null || userId.intValue() <=0){
            return Response.error("请求参数有问题呢");
        }
        if (userid1.intValue() != userId.intValue()){
            return Response.error("非本人操作");
        }
        String storageLocationPrefix = avatar.getStorageLocationPrefix();
        String accessLocationPrefix = avatar.getAccessLocationPrefix();

        FileUtils.forceMkdir(new File(storageLocationPrefix));

        String ext =  FilenameUtils.getExtension(file.getOriginalFilename());

        UserDO userDO = new UserDO();
        userDO.setUserId(userId.longValue());
        userDO.setLogo(ACCESS_PREFIX_0+"/"+avatar.name()+"/"+ userId + "." + ext);
        userDAO.updateByPrimaryKeySelective(userDO);
        String logoFileName = storageLocationPrefix + userId + "." + ext;
        file.transferTo(new File(logoFileName));
        return Response.success(accessLocationPrefix + userId + "." + ext);
    }

    /**
     *
     * @param cmsEnumName  com.paulzhangcc.demo.constant.CmsConsts.CmsEnum#name()
     * @param httpServletResponse
     * @throws Exception
     */
    @RequestMapping(ACCESS_PREFIX_0+"/{name}/{imageName:.*}")
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
