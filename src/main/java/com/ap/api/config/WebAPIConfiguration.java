package com.ap.api.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@Configuration
public class WebAPIConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper ;
    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact contact = new Contact();
        contact.email("ashokparmar.works@gmail.com");

        return new OpenAPI()
                .info(new Info().title("T2T-PG API")
                        .description("T2T-PG API APIs")
                        .version("v1.0.0").contact(contact)
                        .license(new License().name("-").url("")))

                        /*.components(new Components()
                                .addHeaders("Authorization",new Header().description("Enter Token Key")))*/

                .externalDocs(new ExternalDocumentation());
        //.description("SpringShop Wiki Documentation")
        //.url("https://springshop.wiki.github.org/docs"));
    }

    @Bean
    public GroupedOpenApi adminApi() {
        //Adding Header

        return GroupedOpenApi.builder()
                .group("T2T-Api-Access")
                .pathsToMatch("/api/access/**")
                //.pathsToMatch("/api/views/common/**")

                .build();
    }
    @Bean
    public GroupedOpenApi adminViewApi() {
        //Adding Header

        return GroupedOpenApi.builder()
                .group("T2T-PG-Views")
                .pathsToMatch("/api/views/**")
                .build();
    }

    @Bean
    public GroupedOpenApi vendorViewApi() {
        //Adding Header

        return GroupedOpenApi.builder()
                .group("T2T-PG-Vendors")
                .pathsToMatch("/api/vendors/**")
                .build();
    }




}
