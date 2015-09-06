package com.palace.seeds;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.jfinal.i18n.Res;
import com.mysql.jdbc.StringUtils;
import com.palace.seeds.helper.Result;
import com.palace.seeds.model.User;

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
		
		HttpServletRequest req=(HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		if(uri.contains("logon")){
			String logonId= request.getParameter("logonId");
			String pwd=request.getParameter("pwd");
			if(logonId==null || logonId.isEmpty()){
				 
			}
			if(pwd==null|| pwd.isEmpty()){
				
			}
			if(this.geUserInfo(logonId, pwd).getCode()==Result.ERROR_CODE){
				
			}else{
				User user=new User();
				user.setEntId(12l);
			}
		}else{
			String serial = req.getParameter("serial");
		}
		
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	private JdbcTemplate jdbcTemplate;
	public static ThreadLocal<User> userLocal;
	public void init(FilterConfig fConfig) throws ServletException {
		WebApplicationContext wc =(WebApplicationContext) fConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.jdbcTemplate = (JdbcTemplate) wc.getBean("jdbcTemplate");
	}
	
	
	public Result geUserInfo(String logonId,String pwd){
			Map<String,Object> map = jdbcTemplate.queryForMap("select * from creadential where logonid=? and password=? ",logonId,pwd);
			if(map==null || map.isEmpty()){
				 return Result.err("用户不存在,用户名或密码错误！");
			}else{
				return Result.succ().setRes(map);
			}
	}
	

}
