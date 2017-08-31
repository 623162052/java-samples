package javase.javaOO.constructor;

public class ConstructorInvoke extends Constructor {
	// static
	// {
	// System.out.println("子类静态块");
	// }
	// {
	// System.out.println("子类初始化块");
	// }
	public ConstructorInvoke() {
		super(3);
		System.out.println("子类无参构造函数");
	}

	//	
	// public ConstructorInvoke(int x)
	// {
	// System.out.println("子类有参构造函数");
	// }
	public void printTwo() {
		System.out.println("子类普通方法");
	}

}
