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
                        System.out.println(Thread.currentThread().getName() + " ��ʼ�ȴ�");
                        container.wait();				//ʹ�߳̽������� ������
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
                    System.out.println(Thread.currentThread().getName() + " ������1�����ֿ�ʣ��" + container.size());
                }
                container.notifyAll();			//�Ӵ�����״̬
            }
        }
    }
}
