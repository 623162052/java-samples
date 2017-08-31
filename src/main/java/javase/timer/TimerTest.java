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
		//����, ʱ��, ʱ����
		timer.schedule(new TimerTest(), 0, 5000);
	}

}

/**
 *	ʹ��Timer����Ҫ�̳�java.util.TimerTask
 *	Timer�� schedule��������ִ��
 *	
 *	PS
	 	TimerTask�ࣺ����Ҫ���е������װ��run������
		Timer�ࣺ�趨��ʱ���Ĳ�����������ʼʱ�䡢���ʱ�䡢ʱ��ʱ��,�����schedule����
		ע��㣺ͬһ��TimerTask���������μ��뵽Timer��ִ�У������ж������Ҫִ�У���Ҫ�������TimerTask��ʵ�� 

 *
 */
