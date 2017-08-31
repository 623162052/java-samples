package javase.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

//import org.apache.log4j.Logger;

/*
 * ����
 * LinkedListʵ����Queue�ӿ�
 */
public class TestQueue {
//	private static Logger log = Logger.getLogger(TestQueue.class);
	
	public static void testQueue(){
		Queue<String> queue = new LinkedList<String>();
		
		//��ָ����Ԫ�ز���˶���?
		queue.add("item1");				
		
		//��ȡ�������Ƴ�˶��е��?
//		log.debug(queue.element());
		
		//��ָ����Ԫ�ز���˶��У�������������Ҳ���Υ���������ƣ�����ʹ�����������ƵĶ���ʱ���˷���ͨ��Ҫ���� add(E)�����߿����޷�����Ԫ�أ���ֻ���׳�һ���쳣
		//���Կ����ڲ�Ĭ�ϵ���LinkedList��add����,Ҳ����Ĭ�Ϸŵ���β��head��previousָ��
//		log.debug(queue.offer("item2"));
		
		//��ȡ�������Ƴ�˶��е��?
//		log.debug(queue.peek());
		
		//��ȡ�����Ƴ�˶��е��?
//		log.debug(queue.poll());
		
//		log.debug(queue.remove());
	}
	
	public static void main(String[] args) {
		testQueue();
	}
}
