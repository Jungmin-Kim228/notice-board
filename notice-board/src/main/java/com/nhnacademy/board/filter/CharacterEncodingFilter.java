package com.nhnacademy.board.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "characterEncodingFilter", urlPatterns = "/*",
initParams = {
    @WebInitParam(name = "encoding", value = "UTF-8")
})
public class CharacterEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.error("character encoding filter work");

        servletRequest.setCharacterEncoding(this.encoding);
        servletResponse.setCharacterEncoding(this.encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
