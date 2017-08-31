package javase.concurrency.advance.synchronism;

import java.util.ArrayList;
import java.util.List;

public class TestCP {
    private List<Object> container = new ArrayList<Object>();

    public List<Object> getContainer() {
        return container;
    }

    public void setContainer(List<Object> container) {
        this.container = container;
    }

    public final static int MAX = 5;
    public static void main(String args[]) throws InterruptedException {
        List<Object> containers = new ArrayList<Object>();
        Consumer consumer1=new Consumer(containers);
        new Thread(consumer1).start();
        Consumer consumer2=new Consumer(containers);
        new Thread(consumer2).start();
        Consumer consumer3=new Consumer(containers);
        new Thread(consumer3).start();
        Productor Product1=new Productor(containers);
        new Thread(Product1).start();
        Productor Product2=new Productor(containers);
        new Thread(Product2).start();
    }
}
/**
 * ʵ��������������
 * wait()�������ǽ��߳����롰˯�ߡ�״̬��ͬʱ�֡��������صȴ����������ı�.
 * ����ֻ����һ��notify()��notifyAll()�����仯��ʱ���̲߳Żᱻ���ѣ�����������Ƿ��б�.
 */

/**
 * ʲô�ǻ���
 * Java��һ��synchronized�ؼ��֣���������һ�������lock/unlock��
 * �����ĺô������Ǳ�֤��lock/unlock�ĳɶ�ʹ�ã�������뿴����Ҳ���һЩ��
 * ����Java��Ҳ����Ҫ������ɾ����������ÿ������Object��������һ����������һ��������͹����ˡ�
 * ��̬synchronized������
 * �﷨�ϣ�JavaҲ��֧����static method�ϼ�synchronized�ģ�
 * ��������൱��lock������Class�����ˣ���static��synchronized���ǻ��ڶ���ģ������ȸ��������÷��һ�û�ù�����������˵�ġ�
 */
