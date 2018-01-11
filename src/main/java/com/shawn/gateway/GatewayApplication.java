package com.shawn.gateway;

import com.shawn.gateway.filter.ParamSetFilter;
import com.shawn.gateway.filter.SendResponsePreFilter;
import org.springframework.boot.SpringApplication;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@ComponentScan("com.shawn")
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
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
