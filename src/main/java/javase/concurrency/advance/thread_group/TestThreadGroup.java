package javase.concurrency.advance.thread_group;
/**
 * �߳���
 * @author shiwx
 * @since 2011-9-19
 * @version 1.0
 */
public class TestThreadGroup {

    public static void main(String[] args) {
//        //����һ���߳���
//        ThreadGroup threadGroup = new ThreadGroup("group1");
//        //�������߳����һ���߳�
//        Thread thread1 = new Thread(threadGroup, "thread1");
//
//        thread1.start();
//        System.out.println("��ǰ��Ծ�߳�����  " + threadGroup.activeCount());
//        if(threadGroup.activeCount() != 0){
//            //�ж��߳�����߳����������߳�
//            threadGroup.interrupt();
//        }
//        System.out.println("��ǰ��Ծ�߳�����  " + threadGroup.activeCount());
//        //�������0Ϊthread1���ھ���״̬���ȴ�ϵͳ������Դ


        StringBuilder xx = new StringBuilder("abc,");
        String result = xx.substring(0, xx.length() - 1);
        System.out.println("result: " + result);

    }
}
