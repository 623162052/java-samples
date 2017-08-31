package servlet.thread;

import java.util.Map;

/**
 * 查询数据
 * 
 * @author shiwx
 * @date 2012-2-17
 */
public class QueryData implements Runnable {

	private Map<String, Object> container = null;

	public void setContainer(Map<String, Object> container) {
		this.container = container;
	}

	public void run() {
		System.out.println("--------------------- QueryData start ----------------");
		while (true) {
			synchronized (container) {
				if (container.size() == 0) {
					container.put("val", Math.random());
					System.out.println(Thread.currentThread().getName() + " - query " + container.get("val"));
				} else {
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
