package javase.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author shiwx
 * @since 2011-12-8
 */
public class TimerTest extends TimerTask {

	@Override
	public void run() {
		System.out.println("Work at " + System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		Timer timer = new Timer();
		//任务, 时延, 时间间隔
		timer.schedule(new TimerTest(), 0, 5000);
	}

}

/**
 *	使用Timer类需要继承java.util.TimerTask
 *	Timer用 schedule方法启动执行
 *	
 *	PS
	 	TimerTask类：将所要运行的任务封装其run方法中
		Timer类：设定定时器的参数，包括起始时间、间隔时间、时延时间,详情见schedule方法
		注意点：同一个TimerTask对象不能两次加入到Timer中执行，若你有多个任务要执行，需要声明多个TimerTask的实例 

 *
 */
