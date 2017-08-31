package servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import org.apache.log4j.Logger;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;


/**
 * @author shiwx
 * @since 2011-12-2
 * @version 1.0
 */
public class ServletFilter implements Filter {
//    private static Logger logger = Logger.getLogger(ServletFilter.class);
	
	//读取web.xml文件中Servelt过滤器的初始化参数
	//容器启动的过程中启动
	public void init(FilterConfig config) throws ServletException {
//		log.debug("Filter init------------");
	}
	
	//完成实际的过滤操作
	//当客户请求访问与过滤器关联的URL时，Servlet容器将先调用过滤器的doFilter方法
	//FilterChain参数用于访问后续过滤器
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {
		long before = System.currentTimeMillis();
		
		//使用过滤器处理乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		long after = System.currentTimeMillis();
//		log.debug("Filter doFilter: " + (after - before) + " MS");
		System.out.println("Filter doFilter: " + (after - before) + " MS");
		//后续操作
		chain.doFilter(request, response);
		
	}

	//Servlet容器在销毁过滤器实例前调用该方法，在这个方法中可以释放Servlet过滤器占用的资源
	public void destroy() {

//        log.debug("Filter destroy-----------");
	}

}



/**
 *	Filter
 *	1.创建MyFilter，实现Filter接口
 *	2.在wei.xml配置Filter
 * 	3.doFilter方法中配置业务
 */