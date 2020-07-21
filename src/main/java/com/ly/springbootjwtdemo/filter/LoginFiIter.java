package com.ly.springbootjwtdemo.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(1)
@WebFilter(filterName = "loginFilter", urlPatterns = "/*" , initParams = {
        @WebInitParam(name = "URL", value = "http://localhost:8080")})
public class LoginFiIter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器过滤前");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;

        String uri = httpServletRequest.getRequestURI();
        if (uri.endsWith("login.html") || uri.endsWith("login")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String uesrname = (String) httpServletRequest.getSession().getAttribute("username");
        if(uesrname == null)
            throw new RuntimeException("无session，请重新登录");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("过滤器过滤后");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
