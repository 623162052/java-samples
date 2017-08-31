package javase.concurrency.advance.synchronism;

import java.util.List;

public class Productor implements Runnable {
    private List<Object> container = null;

    public Productor(List<Object> lst) {
        this.container = lst;
    }

    public void run() {
        while (true) {
            synchronized (container) {
                if (container.size() > TestCP.MAX) {
                    try {
                        container.wait();				// ������
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                container.add(new Object());
                System.out.println(Thread.currentThread().getName() + " ������1�����ֿ�ʣ��" + container.size());
                container.notifyAll();
            }
        }
    }
}