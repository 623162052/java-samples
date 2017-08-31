package servlet.timer;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 定时器
 * @author shiwx
 * @since 2011-12-8
 */
public class TimerListener implements ServletContextListener {

	private Timer timer = null;

	public void contextInitialized(ServletContextEvent event) {
		TimerTask task = new TimerTask(){
			public void run() {
//				System.out.println("Listener ---" + System.currentTimeMillis());
			}
		};
		timer = new Timer();
		event.getServletContext().log("定时器已启动");
		timer.schedule(task, 0, 2000);
		event.getServletContext().log("已经添加计划任务");
		
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("定时器已关闭");
	}
}

/**
 *	1.实现ServletContextListener接口
 *	2.在初始化方法contextInitialized中创建任务并添加到定时器
 *	3.关闭定时器
 *	4.在web.xml中配置listener
		<listener>
			<listener-class>servlet.timer.ListenerServlet</listener-class>
		</listener>
 * 
 * 
 */