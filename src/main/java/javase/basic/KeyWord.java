package javase.basic;

/**
 * �ؼ���
 * @since 2011-9-12
 * @author shiwx
 * @version 1.0
 */
public class KeyWord {
	public static String staticStr = "һ����̬���ַ���";
	public String publicStr = "";
	protected String protectedStr = "";
	String defaultStr = "";
	public volatile String volatileStr = "һ����volatile���εı���";
	transient public String transientStr = "һ����transient���εı���";
	public final String FINAL_STR = "һ��final���εĳ���";

	public static void doStaticMethod() {
		System.out.println("���� doStaticMethod()��̬����");
	}
	
	public final void doFinalMethod() {
		System.out.println("���� doFinalMethod()����");
	}

	public void doThrowsException() throws Exception {
		Thread.sleep(5000);
	}

	public static void main(String[] args) {
		KeyWord kw = new KeyWord();
		/**
		 * [private][protected][Ĭ��][public] 1 ��ͬһ��java�ļ��������������εķ����ͱ��������Է��ʵ� 2
		 * ��ͬһ���µĲ�ͬjava�ļ���[protected][Ĭ��][public]���εķ����ͱ��������Է��ʵ� 3
		 * �ڲ�ͬ���µ�java�ļ���[public]���εķ����ͱ��������Է��ʵ� 4
		 * ��ͬһ���µ�������[protected][Ĭ��][public]���εķ����ͱ��������Է��ʵ� 5
		 * �ڲ�ͬ���µ�������[protected][public]���εķ����ͱ��������Է��ʵ�
		 */
		/**
		 * [static] static���εı����ͷ��������ھ�̬���в��ҹ������� ����ֱ��ʹ����Щ����������Ҫ����Щ��������ѿռ䡣
		 * PS:ͨ��ʵ���������þ�̬����ʱ�����һ�����ʾ�̬�����ͷ���Ӧ��ʹ�þ�̬��ʽ�ı�����Ϣ
		 */
		System.out.println(KeyWord.staticStr);
		KeyWord.doStaticMethod();

		/**
		 * [volatile] volatile���εĳ�Ա������ÿ�α��̷߳���ʱ����ǿ�ȴӹ����ڴ����ض��ó�Ա������ֵ��
		 * ���ң�����Ա���������仯ʱ��ǿ���߳̽��仯ֵ��д�������ڴ档�������κ�ʱ�̣�������ͬ ���߳����ǿ���ĳ����Ա������ͬһ��ֵ��
		 * PS�����������߸�����̷߳��ʵĳ�Ա������ʹ��volatile��
		 * ��Ҫ���ʵı�������synchronized������У�����Ϊ����ʱ������ʹ�á�
		 * ����ʹ��volatile���ε���VM�б�Ҫ�Ĵ����Ż���������Ч���ϱȽϵͣ�
		 * ���һ���ڱ�Ҫʱ��ʹ�ô˹ؼ��֡�ͬʱ��Ҫע��final���ܺ�volatileһ��ʹ��
		 */
		System.out.println(kw.volatileStr);

		/**
		 * [transient] transient��Java���ԵĹؼ��֣�������ʾһ�����Ǹö����л���һ���֡�
		 * ��һ�����󱻴��л���ʱ��transient�ͱ�����ֵ�������ڴ��л��ı�ʾ�У� Ȼ����transient�͵ı����Ǳ�������ȥ�ġ�
		 */
		System.out.println(kw.transientStr);

		/**
		 * [final] ��final���ε��಻�ܱ��̳� ��final���εķ������ܱ����� ��final���εı������ܱ��޸�
		 * PS:��final��static���εı���Ϊ�������ҷ��ھ�̬������
		 */
		System.out.println(kw.FINAL_STR);
		kw.doFinalMethod();

		/**
		 * [abstract] 1 ��abstract���ε��಻�ܲ�ʵ����ֻ�ܱ��̳� 2 ��abstract���εķ���������������ʵ�� 3
		 * ֻ������Ϊabstract�������ӵ��abstract����
		 */

		/**
		 * [Thorws] �׳��쳣
		 */

		try {
			kw.doThrowsException();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
