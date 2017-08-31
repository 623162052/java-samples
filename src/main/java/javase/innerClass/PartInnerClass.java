package javase.innerClass;

//import org.apache.log4j.Logger;

/*
 * �ֲ������ڲ���
 */
public class PartInnerClass {
//	private static Logger log = Logger.getLogger(PartInnerClass.class);
	
	public void test(){
		class InnerClass {
			public void logInfo(){
//                log.debug("PartInnerClass");
			}
		}
		//ֻ���ڴ˴�����InnerClass
		InnerClass inner = new InnerClass();
		inner.logInfo();
	}
	
	public static void main(String[] args) {
		PartInnerClass instance = new PartInnerClass();
		instance.test();
	}
}


/*
�ֲ������ڲ���
	���壺���ⲿ��ķ����ڶ����ڲ���
	�ֲ������ڲ���ֻ���ڸ��ڲ���ķ�����ʵ��


*/