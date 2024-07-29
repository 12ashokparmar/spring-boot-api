package com.ap.api.config;

public class AuthenticationConfigConstants {

    /*
    ,
 "/api/common/test/**",
 api/common/mou
     */
    public static final String[] AUTH_WHITELIST = {
            "/login",
            "/error",
            "/api/public/common/auth/**",
            "/api/**",
            "/docs/view/**",
    };

    public static final String[] SWAGGER_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/t2t-pg-api.html",
            "/actuator/**",
            "/instances"
    };
}
