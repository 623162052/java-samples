package servlet.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -8479375949287828277L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=gbk");
		String sname = req.getParameter("stuname");
		PrintWriter out = resp.getWriter();
		out.print("doGet: " + sname);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=gbk");
		//String sname = URLDecoder.decode(req.getParameter("stuname"),"UTF-8");
		String sname = req.getParameter("stuname");
		PrintWriter out = resp.getWriter();
		out.print("doPost: " + sname);
	}
}
