package com.ap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

//@SpringBootApplication
//@EnableAutoConfiguration
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class,
		org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@ComponentScan({"com.ap.api"})
public class AshokApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(AshokApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(AshokApplication.class, args);
        System.out.println("version: " + SpringVersion.getVersion());

	}

}
