package com.shawn;

import com.shawn.gateway.filter.ParamSetFilter;
import com.shawn.gateway.filter.SendResponsePreFilter;
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
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringCloudApplication
@ComponentScan("com.shawn")
@MapperScan({"com.shawn.finger.dao.mysql.mapper"})
//强制使用cglib
@EnableAspectJAutoProxy
@ImportResource(locations = {"classpath:spring/application*.xml"}) //映入spring配置
@EnableTransactionManagement
@EnableAsync
public class FingerApplication {
    private static final Logger logger = LoggerFactory.getLogger(FingerApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FingerApplication.class, args);
        startTest(context);
    }


    @Bean
    public ParamSetFilter paramSetFilter() {
        return new ParamSetFilter();
    }

    @Bean
    public SendResponsePreFilter sendResponsePreFilter() {
        return new SendResponsePreFilter();
    }

    private static void startTest(ConfigurableApplicationContext context) {
        try {
            ((RedisTemplate) (context.getBean("redisTemplate"))).opsForValue().get("test");
        } catch (Exception e) {
            logger.error("redis连接失败,请查看配置！！！", e);
            System.exit(-1);
        }
        logger.info("redis检测连接成功！！！");

    }
}
