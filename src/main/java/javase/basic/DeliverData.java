package javase.basic;

/**
 * 基本类型传值,对象传递地址的副本
 * @since 2011-9-12
 * @author shiwx
 * @version 1.0
 */
public class DeliverData {

	static int method1(int i) {
		i = 12;
		i++;
		return i;
	}

	static String method3(StringBuffer sb) {
		sb.append("efg");
		return sb.toString();
	}

	public static void main(String[] args) {
		int i = 0;
		String str = "abcd";
		StringBuffer sb = new StringBuffer("abcd");

		method1(i);
		method3(sb);

		System.out.println(i);
		System.out.println(str);
		System.out.println(sb);
	}
}
