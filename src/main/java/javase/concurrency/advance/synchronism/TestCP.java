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
 * 实现生产者消费者
 * wait()允许我们将线程置入“睡眠”状态，同时又“积极”地等待条件发生改变.
 * 而且只有在一个notify()或notifyAll()发生变化的时候，线程才会被唤醒，并检查条件是否有变.
 */

/**
 * 什么是互斥
 * Java有一个synchronized关键字，用来代替一般意义的lock/unlock，
 * 这样的好处起码是保证了lock/unlock的成对使用，另外代码看起来也清楚一些。
 * 而且Java里也不需要创建和删除互斥量，每个对象（Object）都带有一个互斥量，一般用这个就够用了。
 * 静态synchronized方法：
 * 语法上，Java也是支持在static method上加synchronized的，
 * 不过这就相当于lock了整个Class的锁了（非static的synchronized锁是基于对象的），粒度更大，这种用法我还没用过，书上如是说的。
 */
