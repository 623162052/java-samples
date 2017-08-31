package javase.basic;

/**
 * 关键词
 * @since 2011-9-12
 * @author shiwx
 * @version 1.0
 */
public class KeyWord {
	public static String staticStr = "一个静态的字符串";
	public String publicStr = "";
	protected String protectedStr = "";
	String defaultStr = "";
	public volatile String volatileStr = "一个用volatile修饰的变量";
	transient public String transientStr = "一个用transient修饰的变量";
	public final String FINAL_STR = "一个final修饰的常量";

	public static void doStaticMethod() {
		System.out.println("调用 doStaticMethod()静态方法");
	}
	
	public final void doFinalMethod() {
		System.out.println("调用 doFinalMethod()方法");
	}

	public void doThrowsException() throws Exception {
		Thread.sleep(5000);
	}

	public static void main(String[] args) {
		KeyWord kw = new KeyWord();
		/**
		 * [private][protected][默认][public] 1 在同一个java文件中上述四种修饰的方法和变量都可以访问到 2
		 * 在同一包下的不同java文件中[protected][默认][public]修饰的方法和变量都可以访问到 3
		 * 在不同包下的java文件中[public]修饰的方法和变量都可以访问到 4
		 * 在同一包下的子类中[protected][默认][public]修饰的方法和变量都可以访问到 5
		 * 在不同包下的子类中[protected][public]修饰的方法和变量都可以访问到
		 */
		/**
		 * [static] static修饰的变量和方法保存在静态区中并且共享，所以 可以直接使用这些变量而不需要给这些变量分配堆空间。
		 * PS:通过实例化来调用静态方法时会产生一个访问静态变量和方法应该使用静态方式的报警信息
		 */
		System.out.println(KeyWord.staticStr);
		KeyWord.doStaticMethod();

		/**
		 * [volatile] volatile修饰的成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
		 * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同 的线程总是看到某个成员变量的同一个值。
		 * PS：在两个或者更多的线程访问的成员变量上使用volatile。
		 * 当要访问的变量已在synchronized代码块中，或者为常量时，不必使用。
		 * 由于使用volatile屏蔽掉了VM中必要的代码优化，所以在效率上比较低，
		 * 因此一定在必要时才使用此关键字。同时需要注意final不能和volatile一起使用
		 */
		System.out.println(kw.volatileStr);

		/**
		 * [transient] transient是Java语言的关键字，用来表示一个域不是该对象串行化的一部分。
		 * 当一个对象被串行化的时候，transient型变量的值不包括在串行化的表示中， 然而非transient型的变量是被包括进去的。
		 */
		System.out.println(kw.transientStr);

		/**
		 * [final] 被final修饰的类不能被继承 被final修饰的方法不能被覆盖 被final修饰的变量不能被修改
		 * PS:被final和static修饰的变量为常量并且放在静态区共享
		 */
		System.out.println(kw.FINAL_STR);
		kw.doFinalMethod();

		/**
		 * [abstract] 1 被abstract修饰的类不能不实例化只能被继承 2 被abstract修饰的方法必须在子类中实现 3
		 * 只有修饰为abstract的类才能拥有abstract方法
		 */

		/**
		 * [Thorws] 抛出异常
		 */

		try {
			kw.doThrowsException();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
