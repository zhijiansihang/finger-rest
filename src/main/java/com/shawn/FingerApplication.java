package com.shawn;

import com.shawn.gateway.filter.ParamSetFilter;
import com.shawn.gateway.filter.SendResponsePreFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan("com.shawn")
@MapperScan(basePackages = "com.shawn.finger.dao")
public class FingerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FingerApplication.class, args);
	}


	@Bean
	public ParamSetFilter paramSetFilter() {
		return new ParamSetFilter();
	}

	@Bean
	public SendResponsePreFilter sendResponsePreFilter(){
		return  new SendResponsePreFilter();
	}
}
