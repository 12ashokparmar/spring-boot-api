package com.ap.api.config;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@Order(Integer.MIN_VALUE)
public class ExcludeSessionRepositoryFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
       // if (/* here goes your logic to exclude the session repository filter, probably depending on the request uri */) {
        //    httpRequest.setAttribute("org.springframework.session.web.http.SessionRepositoryFilter.FILTERED", Boolean.TRUE);
       // }
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
