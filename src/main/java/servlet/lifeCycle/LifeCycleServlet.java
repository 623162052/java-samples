package servlet.lifeCycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author shiwx
 * @since 2011-12-1
 * @version 1.0
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 2117214983822497285L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init --------------");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init(config)---------------");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service -11-1---3-45-3-------");
		PrintWriter pw = response.getWriter();
		pw.print("look console");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy --------------");
	}
}








