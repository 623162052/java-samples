package javase.collections.stack;

import java.util.Stack;

//import org.apache.log4j.Logger;

/*
 * 	ջ�� ֻ���ڶ���ȡ��Ԫ�ػ��߼���Ԫ�صĽṹ(FIFO)
 *  ջ����Ҫ˼�룺����
 */
public class TestStack {
//	private static Logger log = Logger.getLogger(TestStack.class);
	
	public static void testStack(){
		Stack<String> stack = new Stack<String>();
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		
//		log.debug(stack.empty());				//����ѹ���ջ����?
//		log.debug(stack.peek());				//�鿴��ջ�����Ķ���
//		log.debug(stack.pop());					//�Ƴ��ջ�����Ķ��󣬲���Ϊ�˺����ֵ���ظö���
//		log.debug(stack.search("item1"));		//���ض����ڶ�ջ�е�λ�ã��Ӷ�ջ������������ 1 Ϊ����
		
		stack.clear();							//��ն��?
	}
	
	public static void main(String[] args) {
		testStack();
	}
}
