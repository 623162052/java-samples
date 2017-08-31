package javase.javaMemory;

/*
 * 1.垃圾显式回收方法
 * 空引用
 * 为引用变量重新赋值
 * 隔离引用
 * 强行回收
 * 
 * 2.finalize方法
 * java提供finalize()方法，垃圾回收器准备释放内存的时候，会先调用finalize()。
 * (1).对象不一定会被回收。
 * (2).垃圾回收不是析构函数。
 * (3).垃圾回收只与内存有关。
 * (4).垃圾回收和finalize()都是靠不住的，只要JVM还没有快到耗尽内存的地步，它是不会浪费时间进行垃圾回收的。
 */
public class GarbageCollection {
	public String str = "测试字符串";

	public static void main(String[] args) {

		// 方法一 空引用
		// OO_GC test1 = new OO_GC();
		// System.out.println(test1.str);
		// test1 = null;

		// 方法二 为引用变量重新赋值
		// OO_GC test2_1 = new OO_GC();
		// OO_GC test2_2 = new OO_GC();
		// System.out.println(test2_1.str);
		// test2_1 = test2_2;

		// 方法三 隔离引用
		// Insulation i1 = new Insulation();
		// Insulation i2 = new Insulation();
		// Insulation i3 = new Insulation();
		// i1.i = i2;
		// i2.i = i3;
		// i3.i = i1;
		// i1 = null;
		// i2 = null;
		// i3 = null;

		// 方法四 强行回收
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
		System.out.println("调用构造方法");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("调用finalize()方法");
	}
}