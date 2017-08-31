package javase.concurrency.advance.thread_group;
/**
 * 线程组
 * @author shiwx
 * @since 2011-9-19
 * @version 1.0
 */
public class TestThreadGroup {

    public static void main(String[] args) {
//        //创建一个线程组
//        ThreadGroup threadGroup = new ThreadGroup("group1");
//        //创建该线程组的一个线程
//        Thread thread1 = new Thread(threadGroup, "thread1");
//
//        thread1.start();
//        System.out.println("当前活跃线程数：  " + threadGroup.activeCount());
//        if(threadGroup.activeCount() != 0){
//            //中断线程组和线程组中所有线程
//            threadGroup.interrupt();
//        }
//        System.out.println("当前活跃线程数：  " + threadGroup.activeCount());
//        //输出两个0为thread1处于就绪状态，等待系统分配资源


        StringBuilder xx = new StringBuilder("abc,");
        String result = xx.substring(0, xx.length() - 1);
        System.out.println("result: " + result);

    }
}
