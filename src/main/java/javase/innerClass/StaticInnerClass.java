package javase.innerClass;

//import org.apache.log4j.Logger;

/*
 * ��̬�ڲ���
 */
public class StaticInnerClass {
//	private static Logger log = Logger.getLogger(StaticInnerClass.class);
	
	private static class Inner{
		public void logInfo(){
//            log.debug("Static Inner");
		}
	}
	
	public static void main(String[] args) {
		Inner inner = new Inner();
		inner.logInfo();
	}
}

/*
	��̬�ڲ��಻��������ڲ��ֻ࣬����Ϊ�ⲿ���һ����̬��Ա�����Բ�ͨ���ⲿ���ʵ�������ã�����Ҫ �ⲿ��.�ڲ��� �ڲ������ = new �ⲿ��.�ڲ���();
	��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա
*/