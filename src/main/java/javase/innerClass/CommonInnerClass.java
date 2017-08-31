package javase.innerClass;

//import org.apache.log4j.Logger;

/*
 * �����ڲ���
 */
public class CommonInnerClass {
//	private static Logger log = Logger.getLogger(CommonInnerClass.class);
	
	private class MyInner {
		public void logInfo(){
//			log.debug("MyInner -- logInfo");
		}

		public void testInnerThis(){
			//thisָ���ڲ���ʵ��
			this.logInfo();
		}
	}
	
	public void logInnerInfo(){
		MyInner myInner = new MyInner();
		myInner.logInfo();
	}
	
	public void testOuterThis() {
		//thisָ���ⲿ��ʵ��
		this.logInnerInfo();
		this.new MyInner().testInnerThis();
	}
	
	public static void main(String[] args) {
		//���������ڲ���ʵ��
		MyInner inner = new CommonInnerClass().new MyInner();
		inner.testInnerThis();
		
		CommonInnerClass commonInnerClass = new CommonInnerClass();
		commonInnerClass.logInnerInfo();
		commonInnerClass.testOuterThis();
		
	}
}

/*
�����ڲ���
	����һ�������ڲ���B�����ļ�A.java,����������ļ���A.class,  A$B.class.
	�����ڲ��಻�����κ����͵ľ�̬����
	�ܹ������ڲ����Ψһ������ͨ���ⲿ���һ����ʵ��
		����ֱ��ͨ���ⲿ��ľ�̬���������ڲ������
		���ⲿ��ʵ������ⲿ�������ⲿ��ľ�̬���������ڲ���������ⲿ����󴴽�
		���ⲿ��ʵ������ڲ�����������̬������������ֱ�Ӵ����ڲ������
		
	�����ڲ����ڲ������ڲ����ⲿʵ��
		ʹ��this���ã���this�������ھ�̬������	
		���ڲ����ڣ� thisָ���ڲ�����󣬶�OuterClass.thisָ���ⲿ�����
		
	Java�ڲ��ࣨInner Class, Nested Class��:�ӱ����Ͽ��������������ֶ�����һ����
		�κ��࣬��������Ķ��Ƕ��Ե�class�ļ�	
		�������ڲ�����Է����ⲿ������г�Ա������private��Ա
		�ô��������㲻���ñ���֪���Ĳ�����Ҳ����װ��
*/