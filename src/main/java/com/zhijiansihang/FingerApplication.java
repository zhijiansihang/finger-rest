package com.zhijiansihang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhijiansihang.gateway.filter.ParamSetFilter;
import com.zhijiansihang.gateway.filter.SendResponsePreFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;

@SpringCloudApplication
@ComponentScan("com.zhijiansihang")
@MapperScan({"com.zhijiansihang.finger.dao.mysql.mapper"})
//强制使用cglib
@EnableAspectJAutoProxy
@ImportResource(locations = {"classpath:spring/application*.xml"}) //映入spring配置
@EnableTransactionManagement
@EnableAsync
public class FingerApplication {
    private static final Logger logger = LoggerFactory.getLogger(FingerApplication.class);

    public static void main(String[] args) {
//        ConfigurableApplicationContext context =
        SpringApplication.run(FingerApplication.class, args);
//        startTest(context);
    }

    @Bean
    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        //设置日期格式
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        objectMapper.setDateFormat(smt);
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
        //设置中文编码格式
//        List<MediaType> list = new ArrayList<MediaType>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
        return mappingJackson2HttpMessageConverter;
    }
}
