package com.palace.seeds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.palace.seeds.data.UserInfo;
import com.palace.seeds.helper.Result;
import com.palace.seeds.helper.TableConst;
import com.palace.seeds.model.User;
import com.palace.seeds.util.UUIDKit;

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
	 * @see Filter#init(FilterConfig)
	 */
	private JdbcTemplate jdbcTemplate;
	public void init(FilterConfig fConfig) throws ServletException {
		WebApplicationContext wc =(WebApplicationContext) fConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		this.jdbcTemplate = (JdbcTemplate) wc.getBean("jdbcTemplate");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse)response;
		String uri = req.getRequestURI();
		if(uri.contains("logon")){
			String logonId= request.getParameter("logonId");
			String pwd=request.getParameter("pwd");
			if(logonId==null || logonId.isEmpty()){
				returnRes(Result.ERROR_CODE,"用户名不能为空!", res);
				return ;
			}
			if(pwd==null|| pwd.isEmpty()){
				returnRes(Result.ERROR_CODE,"密码不能为空!", res);
				return ;
			}
			Result result=this.geUserInfo(logonId, pwd);
			if(result.getCode()==Result.ERROR_CODE){
				returnRes(Result.ERROR_CODE,"用户名或密码不正确!", res);
				return ;
			}else{
				Map<String,Object> map= result.getRes();
				User user=new User();
				user.setEntId((Long)map.get(TableConst.ENTID));
				user.setId((Long)map.get(TableConst.ID));
				user.setLogonTime((System.currentTimeMillis()/1000));
				user.setPwd(pwd);
				user.setLogonId(logonId);
				String serial=UUIDKit.uuid();
				user.setSerial(serial);
				UserInfo.addUser(serial,user);
				UserInfo.userLocal.set(user);
			}
		}else{
			if(UserInfo.checkUser(req.getParameter("serial"))){
				returnRes(Result.ERROR_CODE,"不合法的操作",res);
				return ;
			}
		}
		chain.doFilter(request, response);
	}
	public Result geUserInfo(String logonId,String pwd){
			Map<String,Object> map = jdbcTemplate.queryForMap("select * from creadential where logonid=? and password=? ",logonId,pwd);
			if(map==null || map.isEmpty()){
				 return Result.err("用户不存在,用户名或密码错误！");
			}else{
				return Result.succ().setRes(map);
			}
	}
	
	public void returnRes(int code,String msg,HttpServletResponse response){
	    response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");  
	    PrintWriter out = null;  
	    try {  
	        out = response.getWriter();  
	        out.append("{\"code\":"+code+",\"msg\":\""+msg+"\"}");  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } finally {  
	        if (out != null) {  
	            out.close();  
	        }  
	    }  
	}


}
