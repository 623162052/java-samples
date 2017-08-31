package javase.javaMemory;

/*
 * 1.������ʽ���շ���
 * ������
 * Ϊ���ñ������¸�ֵ
 * ��������
 * ǿ�л���
 * 
 * 2.finalize����
 * java�ṩfinalize()����������������׼���ͷ��ڴ��ʱ�򣬻��ȵ���finalize()��
 * (1).����һ���ᱻ���ա�
 * (2).�������ղ�������������
 * (3).��������ֻ���ڴ��йء�
 * (4).�������պ�finalize()���ǿ���ס�ģ�ֻҪJVM��û�п쵽�ľ��ڴ�ĵز������ǲ����˷�ʱ������������յġ�
 */
public class GarbageCollection {
	public String str = "�����ַ���";

	public static void main(String[] args) {

		// ����һ ������
		// OO_GC test1 = new OO_GC();
		// System.out.println(test1.str);
		// test1 = null;

		// ������ Ϊ���ñ������¸�ֵ
		// OO_GC test2_1 = new OO_GC();
		// OO_GC test2_2 = new OO_GC();
		// System.out.println(test2_1.str);
		// test2_1 = test2_2;

		// ������ ��������
		// Insulation i1 = new Insulation();
		// Insulation i2 = new Insulation();
		// Insulation i3 = new Insulation();
		// i1.i = i2;
		// i2.i = i3;
		// i3.i = i1;
		// i1 = null;
		// i2 = null;
		// i3 = null;

		// ������ ǿ�л���
		// Runtime rt = Runtime.getRuntime();
		// OO_GC test4 = null;
		// for (int i = 0; i < 10000; i++) {
		// test4 = new OO_GC();
		// test4.str = "abc";
		// test4 = null;
		// }
		// System.out.println(rt.freeMemory());
		// System.gc();
		// System.out.println(rt.freeMemory());

		Finalize finalize = new Finalize();
		System.out.println(finalize);
		finalize = null;
		System.gc();
	}
}

class Insulation {
	Insulation i;
}

class Finalize {
	public Finalize() {
		System.out.println("���ù��췽��");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("����finalize()����");
	}
}