package javase.concurrency.advance.synchronism;

import java.util.List;

public class Consumer implements Runnable {
    private List<Object> container = null;

    public Consumer(List<Object> lst) {
        this.container = lst;
    }

    public void run() {
        while (true) {
            synchronized (container) {
                if (container.size() == 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 开始等待");
                        container.wait();				//使线程进入阻塞 放弃锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (container.size() > 0) {
                    container.remove(0);
                    System.out.println(Thread.currentThread().getName() + " 消费了1个，仓库剩余" + container.size());
                }
                container.notifyAll();			//接触阻塞状态
            }
        }
    }
}
