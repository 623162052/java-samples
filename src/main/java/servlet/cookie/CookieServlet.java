package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shiwx
 * @since 2011-12-5
 * @version 1.0
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 7365342619279069786L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		Cookie cookie = new Cookie("userName",request.getParameter("UserName"));
		cookie.setMaxAge(7*24*60*60);			//设置Cookie的过期时间
		response.addCookie(cookie);				//将Cookie存到硬盘
		
		//取得Cookie
		Cookie[] cookies = request.getCookies();
		for(Cookie ck : cookies){
			if("userName".equals(ck.getName())){
				pw.println("Cookie userName : " + ck.getValue());
			}
		}
		pw.flush();
		pw.close();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}
