package servlet.thread;

import java.util.Map;

/**
 * 发送数据
 * @author shiwx
 * @date   2012-2-17
 */
public class PushData implements Runnable {
	private Map<String, Object> container = null;
	
	public void setContainer(Map<String, Object> container) {
		this.container = container;
	}

	public void run() {
		System.out.println("--------------------- PushData start ----------------");
		
		while(true){
			synchronized(container){
				if(container.size() > 0){
					System.out.println(Thread.currentThread().getName() + " - push " + container.get("val"));
					container.remove("val");
				}else{
					try {
						container.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				container.notifyAll();
			}
		}	
	}
}
