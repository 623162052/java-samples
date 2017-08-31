package javase.concurrency;

import java.util.Date;

/**
 * Created by shiwx on 2014/7/23.
 */
public class ThreadTest implements Runnable {


    @Override
    public void run() {
        while (true){

            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.run();
    }
}
