package servlet.easyui;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shiwx on 2016/3/3.
 */
@WebServlet(name = "EasyUIServlet", urlPatterns = "/EasyUIServlet")
public class EasyUIServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(EasyUIServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        log.debug("start: " + start + " - " + " end: " + end);

        List<MessageBean> dataList = new ArrayList<>();
        for (int i = Integer.valueOf(start) - 1; i < Integer.valueOf(end); i++) {
            dataList.add(new MessageBean(String.valueOf(i), String.valueOf(i), String.valueOf(i),
                    String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i)));
        }

        PrintWriter out = response.getWriter();
        Map<String, Object> data = new HashMap<>();
        data.put("total", 100);
        data.put("rows", dataList);
        out.print(new Gson().toJson(data));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
