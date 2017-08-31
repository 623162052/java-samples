package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 业务处理方法入口，URI的映射逻辑
 * @author Matthew
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = -1048209450981177002L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, false);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, true);
	}

	/**
	 * 执行Action方法并进行返回处理、异常处理
	 */
	protected void process(HttpServletRequest req, boolean is_Post) throws ServletException, IOException {

	}
}
