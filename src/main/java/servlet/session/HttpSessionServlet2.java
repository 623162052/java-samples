package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author shiwx
 * @since 2011-12-5
 * @version 1.0
 */
public class HttpSessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 3997425402764782662L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		pw.println("name:" + name);
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
