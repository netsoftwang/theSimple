package com.palace.seeds;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

/**
 * Servlet Filter implementation class LogonFilter
 */
public class LogonFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogonFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
 
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//this.jdbcTemplate.execute("insert into action(entId,actionVal,actionGroup) values(1000,'actionVal','actionGroup')");

	 
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	private JdbcTemplate jdbcTemplate;
	public void init(FilterConfig fConfig) throws ServletException {
		//WebApplicationContext wc =(WebApplicationContext) fConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//this.jdbcTemplate = (JdbcTemplate) wc.getBean("jdbcTemplate");
	}

}
