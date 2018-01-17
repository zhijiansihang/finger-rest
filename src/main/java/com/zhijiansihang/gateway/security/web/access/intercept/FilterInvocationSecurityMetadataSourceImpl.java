package com.zhijiansihang.gateway.security.web.access.intercept;

import com.zhijiansihang.gateway.security.core.PermissionsService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.zhijiansihang.sys.service.ResourceService;
import com.zhijiansihang.sys.vo.ResourceVO;
import com.zhijiansihang.sys.vo.RoleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class FilterInvocationSecurityMetadataSourceImpl extends PermissionsService implements FilterInvocationSecurityMetadataSource {

    private static Logger logger = LoggerFactory.getLogger(FilterInvocationSecurityMetadataSourceImpl.class);
    @Value("${url.filter.permission}")
    private String permissions;
    @Autowired
    private ResourceService resourceService;

    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }

        return new HashSet<>();

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {

        Set<ConfigAttribute> allAttributes = new HashSet<>();

        List<ResourceVO> resourceList = this.findAll();

        Map<RequestMatcher, Collection<ConfigAttribute>> tmpMap  = new LinkedHashMap<>();
        // 资源角色
        resourceList.forEach( resource -> {
            Set<ConfigAttribute> itemAttributes = new HashSet<>();

            Set<RoleVO> roles = resource.getRoles();
            roles.forEach(role -> {
                ConfigAttribute ca = new SecurityConfig(role.getRoleCode());
                // 每一个请求资源对应的Role
                itemAttributes.add(ca);
                // 所有的Role对象
                allAttributes.add(ca);
            });
            if(roles.size() > 0){
                tmpMap.put(new AntPathRequestMatcher(resource.getPath(), null), itemAttributes);
            }
        });

        this.requestMap = tmpMap; // 赋值，指针切换，防止并发

        return allAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


    @Override
    public void refresh() {
        this.setFromDb(true);
        try {
            this.getAllConfigAttributes();
        } catch (Exception e){
            new Thread(() -> {  // 获取失败 增加重试机制
                while (!received){
                    logger.info("权限资源获取失败，重试中...");
                    try {
                        Thread.sleep(10000);
                        getAllConfigAttributes();
                    } catch (Exception e1) {
                        logger.info("重试失败，继续");
                    }
                }
            }).start();
        }
    }

    @Override
    public List<ResourceVO> findAll() {

        List<ResourceVO> resources = Lists.newArrayList();

        // 配置文件中取
        for (String permission : permissions.replace("\\n","@n").split("@n")) {
            logger.info(permission);
            String[] str = permission.split("=");
            ResourceVO resource = new ResourceVO();
            resource.setPath(str[0].trim());

            Set<RoleVO> roles = Sets.newHashSet();
            for (String roleStr : str[1].split(",")) {
                RoleVO role = new RoleVO();
                if (roleStr.trim().equals("ANONYMOUS")) {
                    role.setRoleCode(AuthenticatedVoter.IS_AUTHENTICATED_ANONYMOUSLY);
                } else if (roleStr.trim().equals("USER")) {
                    role.setRoleCode(AuthenticatedVoter.IS_AUTHENTICATED_FULLY);
                } else {
                    role.setRoleCode("ROLE_" + roleStr.trim());
                }
                roles.add(role);
            }
            resource.setRoles(roles);
            resources.add(resource);
        }
        // 数据库中获取
        if (super.fromDb) {
            logger.info("远程获取权限资源");
            List<ResourceVO> resourcesFromDb = resourceService.findAll();
            for (ResourceVO resource : resourcesFromDb) {
                for (RoleVO role : resource.getRoles()) {
                    if(role.getRoleCode().trim().equals("ANONYMOUS")){
                        role.setRoleCode(AuthenticatedVoter.IS_AUTHENTICATED_ANONYMOUSLY);
                    }else if(role.getRoleCode().trim().equals("USER")){
                        role.setRoleCode(AuthenticatedVoter.IS_AUTHENTICATED_FULLY);
                    }else {
                        role.setRoleCode("ROLE_" + role.getRoleCode().trim());
                    }
                }
            }
            this.received = true;
            logger.info("权限资源获取成功");
            resourcesFromDb.addAll(resources); // 配置文件中的资源在后
            resources = resourcesFromDb;
        }

        return resources;
    }
}
