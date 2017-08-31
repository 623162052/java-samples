package servlet.session;

import java.io.IOException;

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
public class HttpSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 7590048049001106954L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("name", "嗷嗷");
		request.getRequestDispatcher("/HttpSessionServlet2").forward(request, response);	//跳转
//		response.sendRedirect("index.jsp");			//重定向
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
