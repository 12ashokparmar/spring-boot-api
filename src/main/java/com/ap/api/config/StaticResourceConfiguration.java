package com.ap.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)

public class StaticResourceConfiguration implements WebMvcConfigurer  /* extends WebMvcConfigurerAdapter */ {
	@Autowired
	private Environment env;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		String viewImage = env.getProperty("web.t2thmis.fileUpload.path");
		
	    registry.addResourceHandler("/docs/view/**")
	            .addResourceLocations("file:"+viewImage)
	            .resourceChain(true);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
	    AntPathMatcher matcher = new AntPathMatcher();
	    matcher.setCaseSensitive(false);
	    configurer.setPathMatcher(matcher);
	}
	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
	 * 
	 * System.out.println("********* Static Files....."); String viewImage =
	 * env.getProperty("web.t2thmis.fileUpload.path");
	 * 
	 * System.out.println("********* Static Files....."+viewImage); //
	 * registry.addResourceHandler(File.separator+"img"+File.separator+"view"+File.
	 * separator+"**") registry.addResourceHandler("/docs/view/**")
	 * .addResourceLocations("file:///"+viewImage) .setCachePeriod(0);
	 * 
	 * // super.addResourceHandlers(registry);
	 * 
	 * registry.addResourceHandler("/docs/view/**","/css/**", "/js/**",
	 * "/images/**", "/vendors/**") .addResourceLocations("classpath:/static/css/",
	 * "classpath:/static/js/", "classpath:/static/images/",
	 * "classpath:/static/vendors/") .setCacheControl(CacheControl.maxAge(1,
	 * TimeUnit.DAYS));
	 * 
	 * }
	 */
}
