package com.zhijiansihang.sys.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.zhijiansihang.common.RetCode;
import com.zhijiansihang.sys.entity.Resource;
import com.zhijiansihang.sys.entity.Role;
import com.zhijiansihang.sys.exception.EditDomainException;
import com.zhijiansihang.sys.exception.ValidationException;
import com.zhijiansihang.sys.repository.ResourceRepository;
import com.zhijiansihang.sys.util.MessageUtils;
import com.zhijiansihang.sys.util.UuidHelper;
import com.zhijiansihang.sys.vo.JsTreeNode;
import com.zhijiansihang.sys.vo.ResourceVO;
import com.zhijiansihang.sys.vo.RoleVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ResourceService {
    private static Logger logger = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    private ResourceRepository resourceRepository;

    /**
     * 获取资源树列表
     *
     * @return
     */
    public JsTreeNode<Resource> menuJsTree() throws Exception {
        try {
            JsTreeNode<Resource> root = new JsTreeNode<>("-1", "资源树");
            root.getState().setOpened(true);
            List<Resource> byParentId = this.resourceRepository.findByParentIdOrderByDispOrder("0");
            iteratorInitResourceJsTree(root, byParentId);
            return root;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("========[获取资源树列表出现异常]，errorMSG：{}", e.getMessage());
            }
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 迭代树结构
     *
     * @param parent
     * @param resources
     */
    private void iteratorInitResourceJsTree(JsTreeNode<Resource> parent, List<Resource> resources) {
        if (null != resources && !resources.isEmpty()) {
            for (Resource resource : resources) {
                JsTreeNode<Resource> children = new JsTreeNode<>(resource.getId().toString(), resource.getName(), resource);
                parent.getChildren().add(children);
                List<Resource> byId = this.resourceRepository.findByParentIdOrderByDispOrder(String.valueOf(resource.getId()));
                iteratorInitResourceJsTree(children, byId);
            }
        }
    }

    /**
     * 保存资源菜单
     *
     * @param resourceVO
     * @param loginUserId
     */
    @Transactional
    public void saveResource(ResourceVO resourceVO, String loginUserId) throws ValidationException {
        logger.info("========[保存资源菜单]，resourceVO：{}，loginUserId：{}", resourceVO, loginUserId);
        try {
            Resource resource = new Resource();
            BeanUtils.copyProperties(resourceVO, resource);

            //修改操作 不需要校验
            if (resource.getId() == null) {
                if ("1".equals(resource.getResType())) {//0:API资源
                    Resource resourceByParentIdAndNameAndPath = this.resourceRepository.findByParentIdAndNameAndPath(resource.getParentId().trim(), resource.getName().trim(), resource.getPath().trim());
                    if (null != resourceByParentIdAndNameAndPath) {
                        throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "该资源名称及URL链接已被使用");
                    }
                } else if ("2".equals(resource.getResType())) { //1:功能模块
                    Resource resourceByParentIdAndName = this.resourceRepository.findByParentIdAndName(resource.getParentId().trim(), resource.getName().trim());
                    if (null != resourceByParentIdAndName) {
                        throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "该资源名称已被使用");
                    }
                }
                resource.setId(UuidHelper.randomShorterString());
                resource.setCreateBy(loginUserId);//创建者
                resource.setCreateTime(new Date());
            } else {
                resource.setUpdateBy(loginUserId);//修改者
                resource.setUpdateTime(new Date());
            }


            this.resourceRepository.save(resource);
        } catch (BeansException e) {
            logger.error("[=======保存资源菜单属性copy赋值信息出现异常]，errorMSG:{}", e.getMessage());
            throw new ValidationException(RetCode.INTERNALEXCEP.getCode(), RetCode.INTERNALEXCEP.getMessage());
        } catch (ValidationException e) {
            logger.error("[=======保存资源菜单信息出现异常]，errorMSG:{}", e.getMessage());
            throw new ValidationException(e.getCode(), e.getMessage());
        }
    }

    /**
     * 修改资源
     *
     * @param resourceVO
     * @param loginUserId
     * @param resourceId
     */
    @Transactional
    public void updateResource(ResourceVO resourceVO, String loginUserId, String resourceId) throws ValidationException {
        if (logger.isInfoEnabled()) {
            logger.info("========[修改资源菜单]，resourceVO：{}，loginUserId：{}", resourceVO, loginUserId);
        }
        try {
            Resource resource = this.resourceRepository.findOne(resourceId);
            if (null == resource) {
                throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "资源不存在");
            }
            if (!resource.getName().equalsIgnoreCase(resourceVO.getName())) {
                Resource byParentIdAndName = this.resourceRepository.findByParentIdAndName(resourceVO.getParentId(), resourceVO.getName());
                if (null != byParentIdAndName) {
                    throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "该资源名称已被使用");
                }
                resource.setName(resourceVO.getName());
                resource.setUpdateBy(loginUserId);
                resource.setUpdateTime(new Date());
                resource.setRemarks(resourceVO.getRemarks());
                this.resourceRepository.saveAndFlush(resource);
            }
        } catch (ValidationException e) {
            if (logger.isErrorEnabled()) {
                logger.error("[=======修改资源菜单信息出现异常]，errorMSG:{}", e.getMessage());
            }
            throw new ValidationException(e.getCode(), e.getMessage());
        }
    }

    /**
     * 删除资源
     *
     * @param resourceId
     */
    @Transactional
    public void deleteById(String resourceId) throws ValidationException {
        if (logger.isInfoEnabled()) {
            logger.info("========[删除资源菜单]，resourceId：{}", resourceId);
        }
        try {
            Resource resource = this.resourceRepository.findOne(resourceId);
            if (null == resource) {
                throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "资源不存在");
            }

            resource.setRoles(null);
            this.resourceRepository.delete(resource);
        } catch (ValidationException e) {
            if (logger.isErrorEnabled()) {
                logger.error("[=======删除资源菜单信息出现异常]，errorMSG:{}", e.getMessage());
            }
            throw new ValidationException(e.getCode(), e.getMessage());
        }


    }


    /**
     * 根据资源id查询资源
     *
     * @param resourceId
     * @return
     */
    public Resource findById(String resourceId) throws EditDomainException {
        if (logger.isInfoEnabled()) {
            logger.info("========[根据资源id查询资源]，resourceId：{}", resourceId);
        }
        try {
            return this.resourceRepository.findOne(resourceId);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("[=======根据角色id查询角色出现异常]，errorMSG:{}", e.getMessage());
            }
            throw new EditDomainException(RetCode.INTERNALEXCEP.getCode(), RetCode.INTERNALEXCEP.getMessage());
        }
    }


    /**
     * 改变资源节点
     *
     * @param srcResourceId
     * @param newResourceId
     * @param loginUserId
     */
    public void changeResourceNode(String srcResourceId, String newResourceId, String loginUserId) throws ValidationException {
        if (logger.isInfoEnabled()) {
            logger.info("========[改变资源节点]，srcResourceId：{},newResourceId:{},loginUserId:{}", srcResourceId, newResourceId, loginUserId);
        }
        if (StringUtils.isBlank(String.valueOf(newResourceId))) {
            throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "新资源节点位置有误");
        }
        try {
            Resource srcResource = this.resourceRepository.findOne(srcResourceId);
            Resource newResource = this.resourceRepository.findOne(newResourceId);
            if (null == srcResource || null == newResource) {
                throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "该资源不存在");
            }

            if ("0".equals(srcResource.getParentId())) {
                throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "[根节点]资源不能移动");
            }

            if ("0".equals(newResource.getResType())) {
                throw new ValidationException(RetCode.VALIDATEERROR.getCode(), "不能移动至API资源下");
            }
            srcResource.setParentId(String.valueOf(newResourceId));//设置父节点

            //设置level
            int newResLevel = Integer.parseInt(newResource.getResLevel());
            List<Resource> resources = this.resourceRepository.findByParentIdOrderByDispOrder(String.valueOf(srcResourceId));
            resources.add(srcResource);
            for (Resource resource : resources) {
                resource.setResLevel(newResLevel + 1 + "");
                resource.setUpdateBy(loginUserId);
                resource.setUpdateTime(new Date());
            }
            this.resourceRepository.save(resources);
        } catch (ValidationException e) {
            if (logger.isErrorEnabled()) {
                logger.error("[=======改变资源节点]，errorMSG:{}", e.getMessage());
            }
            throw new ValidationException(e);
        } catch (NumberFormatException e) {
            if (logger.isErrorEnabled()) {
                logger.error("[=======改变资源节点]，errorMSG:{}", e.getMessage());
            }
            throw new ValidationException(MessageUtils.REQUESTEXCEPTION.getCode() + "", MessageUtils.REQUESTEXCEPTION.getMessage());
        }
    }

    public List<ResourceVO> findAll() {
        List<Resource> resources = resourceRepository.findByPathIsNotNullOrderByIdDesc();
        List<ResourceVO> resourceVos = Lists.newArrayList();

        for (Resource resource : resources) {
            ResourceVO resourceVO = new ResourceVO();
            BeanUtils.copyProperties(resource, resourceVO);
            resource.getRoles();
            Set<Role> roles = resource.getRoles();
            Set<RoleVO> roleVOs = Sets.newHashSet();
            for (Role role : roles) {
                RoleVO roleVO = new RoleVO();
                BeanUtils.copyProperties(role, roleVO);
                roleVOs.add(roleVO);
            }
            resourceVO.setRoles(roleVOs);
            resourceVos.add(resourceVO);
        }

        return resourceVos;
    }

    public  JsTreeNode<Resource> menuList(String system) {
        JsTreeNode<Resource> root = new JsTreeNode<>("-1", " 菜单树");
        Resource platform = resourceRepository.findByModTypeAndNameOrderByDispOrder("1",system);

        if(platform != null){
            iteratorInitMenuJsTree(root,resourceRepository.findByModTypeAndParentIdOrderByDispOrder("2",platform.getId().toString()));
        }
        return root;
    }

    private void iteratorInitMenuJsTree(JsTreeNode<Resource> parent, List<Resource> resources) {
        resources.forEach( resource -> {
            JsTreeNode<Resource> children = new JsTreeNode<>(resource.getId().toString(), resource.getName(), resource);
            parent.getChildren().add(children);
            iteratorInitMenuJsTree(children, resourceRepository.findByModTypeAndParentIdOrderByDispOrder("2",String.valueOf(resource.getId())));

        });
    }

    public String export(String id) {
        List<Resource> resources = Lists.newArrayList();
        Resource resource = this.resourceRepository.findOne(id);
        resource.setRoles(null);
        resources.add(resource);
        iteratorExportResources(id, resources);
        return JSON.toJSONString(resources);
    }

    private void  iteratorExportResources(String id, List<Resource> resources){
        resourceRepository.findByParentIdOrderByDispOrder(id).forEach( resource -> {
            resource.setRoles(null);
            resources.add(resource);
            iteratorExportResources(resource.getId(), resources);
        });
    }

    public void importResource(List<Resource> resources) {
        resourceRepository.save(resources);
    }

}
