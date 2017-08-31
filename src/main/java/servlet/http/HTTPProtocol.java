package servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shiwx
 * @since 2011-12-1
 * @version 1.0
 */
public class HTTPProtocol extends HttpServlet {
	private static final long serialVersionUID = -2761469864504262234L;

	@Override
	public void init() throws ServletException {
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String flag = request.getParameter("str");
		//flag = new String(flag.getBytes("ISO-8859-1"),"UTF-8");	//乱码时使用
		
		pw.print("str: " + flag);
		pw.print("<hr />");
		
		String[] arr = request.getParameterValues("arr");
		for(String str : arr){
			pw.print(arr.length + " : " + str);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
