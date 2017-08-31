package javase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 *  能够分析类能力的程序被称为反射,以便编写能够动态操纵Java代码的程序
 *  
 *  Class 没有公共构造方法。Class 对象是在加载类时由 Java 虚拟机以及通过调用类加载器中的 defineClass 方法自动构造的。
clazz.newInstance() 效率比 new 的效率高
 *  
 * @author shiwx
 * @since 2011-12-13
 */
public class ReflectTest {

	/**
	 * clazz相关的属性方法
	 */
	public static void getClazz(){
		Class<?> clazz = String.class.getClass();
		//获得类名
		System.out.println(clazz.getName());
		//获取父类名
		System.out.println(clazz.getSuperclass());
		
		//getFields() - 获得可访问的成员变量，包括继承的
		// getDeclaredFields() - 获得所有成员变量，不包括继承的
		//getField(成员变量名字)
        //getDeclaredField(成员变量名字)
		Field[] fields = clazz.getFields();
		System.out.println(fields.length);
		for(Field field : fields){
			System.out.println(field.getName());
		}
		
		//获取构造方法
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> constructor : constructors){
			System.out.println(constructor.getName());
		}
		
		//获取可访问的成员方法，包括通过继承的
		//getMethods() - //获得可访问的方法，包括通过继承的
        //getDeclaredMethods() - //获得所有方法，包括私有但不包括继承的
		//getMethod(方法名)	-//获得指定的方法(可访问的，包括继承的)
		//getDeclaredMethod(方法名, 参数类型数组)-//获得所有方法，不包括继承的
		Method[] methods = clazz.getMethods();
		for(Method method : methods){
			System.out.println(method.getName());
		}
		
		//方法调用
		//Method m = String.class.getMethod(方法名, 参数类型列表);
//		/Object returnVal = m.invoke(实例, 参数数据列表);
	}
	
	/**
	 * 创建实例
	 */
	public void createInstance() throws Exception{
		Class<?> clazz = String.class;
		//使用无参观构造方法创建实例
		Object obj1 = clazz.newInstance();
		
		//使用有参构造方法创建实例
		Constructor<?> constructor = clazz.getConstructor(new Class[]{String.class});	//传入参数类型类对象 
		Object obj2 = constructor.newInstance(new Object[]{"abcd"});					//传入构造方法的参数数据
		
	}
	
	/**
	 * 反射技术：可以动态调用任何方法
	 * 利用反射根据类名创建对象，程序变的更灵活
	 */
	public static void testReflect() throws Exception{
//		Class clazz = Class.forName(className);
//		Method method = clazz.getmethod("method",new Class[]{String.class,int.class});
//		method.invoke(null,new Object[]{"Tom",18});
		
		//实例化 & 传参
//		Class clazz = Class.forName(className);
//		Object object = clazz.newInstance();		//实例化对象
//		Method method = clazz.getmethod("method",new Class[]{String.class,int.class});
//		method.invoke(object,new Object[]{"Tom",18});
		
		
		//类加载机制Class.forName()对类的静态方法，静态属性，静态快进行了初始化，不掉调用构造函数【此时还没实例化】
		Class<?> clazz = Class.forName("java.lang.String");
		Method method = clazz.getMethod("concat", new Class[]{String.class});
		String result = (String) method.invoke("abc","def");
		System.out.println(result);
	}
	
	public static void main(String[] args) throws Exception {
//		getClazz();
		testReflect();
	}
}




/*

	//第一种方式：***********************************************
	//类的装载，连接，初始化一次性完成
	//一个类在产生它自己实例的时候或是用到该类的static方法或是域的时候装载自己对应的Class实例。但是在new同一个类第二次时就不装载Class实例了,因为该类已经被装载了。
	
	//第二种方式：***********************************************
	//Class.forName方法默认的情况下是类装载、链接和初始化的，
	Class.forName(className, true, currentLoader)(true和false管是否初始化,如果是true的，那么装载、连接、并初始化;如果false，仅仅装载和连接)
	JVM查找并加载指定的类
		【类的装载过程简单的说就是产生一个二进制流并解析它然后创建Class的实例】
		【如果找不到该类会报ClassNotFoundException】
		【在生命周期内，第二次创建对象时就不需要重新装载该类】，
		对类的静态方法，静态属性，静态块进行初始化，不掉调用构造函数
*/


/*		-------反射与JDBC---------
	在JDBC规范中明确要求这个Driver类必须向DriverManager注册自己，调用forName,等于运行static代码块的内容. 
	他会向DriverManager注册自身.所以我们在使用JDBC时只需要Class.forName(xxx.xxx);
	java.sql.DriverManager.registerDriver(new Driver());
	然后你从DriverManager得到数据库的连接.
	Connection conn=DriverManager.getConnection(url); 

*/


