package javase.javaMemory;

import java.io.UnsupportedEncodingException;

public class Memoary {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * JAVA内存空间 寄存器： 最快存储区，编译器根据需求分配，程序无法控制 堆：
		 * (不能共享)存放所有new出来的对象【除了String】【变量对象的地址和数据
		 * 】（GC堆堆进行回收）【堆中的对象的由垃圾回收器负责回收，因此大小和生命周期不需要确定，具有很大的灵活性】 栈：
		 * (可以共享)【基本数据类型的变量和数据】和【对象的引用】【栈中的数据大小和生命周期是可以确定的，当没有引用指向数据时，这个数据就会消失】
		 * 常量池： (可以共享)存放字符串常量和基本类型常量（public static
		 * final）【对于字符串：其对象的引用都是存储在栈中的，如果是编译期已经创建好
		 * (直接用双引号定义的)的就存储在常量池中，如果是运行期（new出来的）才能确定的就存储在堆中】 静态域：
		 * (可以共享)存放静态成员（static定义的) 非RAM存储： 硬盘等永久存放空间
		 * 
		 * 
		 * 栈中的数据大小和生命周期是可以确定的，当没有引用指向数据时，这个数据就会消失。
		 * 堆中的对象的由垃圾回收器负责回收，因此大小和生命周期不需要确定，具有很大的灵活性。
		 * 对于字符串：其对象的引用都是存储栈中的，如果是编译期已经创建好
		 * (直接用双引号定义的)的就存储在常量池中，如果是运行期（new出来的）才能确定的就存储在堆中。
		 * 
		 * 1.String a = new String("abc"); 栈 堆 常量池 a----->地址----->"abc"
		 * 2.StringBuilder varOne = new StringBuilder("abc"); 栈 堆 常量池
		 * 		varOne->地址----->"abc"
		 * 3.String a = "abc"; 栈-----常量池 a------>"abc"
		 * 4.int a = 3; a和3都放在栈
		 */
		/**
		 * 1.字符串常量与常量池
		 */
		// 存放在常量池
		// String strA1="abc";
		// String strA2="abc";

		// 存放在栈区中
		// String strB1=new String("efg");
		// String strB2=new String("efg");

		// System.out.println(strA1==strA2);
		// System.out.println(strA1.equals(strA2));
		//			
		// System.out.println(strB1==strB2);
		// System.out.println(strB1.equals(strB2));

		/**
		 * 2.创建了几个对象
		 */
		// String strA="spring";
		// strA=strA.substring(0);
		// System.out.println(strA);

		// String y="abc";
		// String x=new String("abc");
		// StringBuffer strBuf=new StringBuffer("abc");

		// String s1="spring ";
		// String s2=s1+"summer ";
		// String s3=s2+"summer ";
		// s3.concat(": ");
		// s1.concat("fail ");
		// s2.concat(s1);
		// s1+="winter ";
		// System.out.println(s1+" "+s2);

		/**
		 * 3.对于基础类型的变量和常量：变量和引用存储在栈中，常量存储在常量池中
		 */
		// int intA=0;
		// public static final int INTB=0;

		/**
		 * 4.Byte,Short,Integer,Long,Character,Boolean,String实现了常量池技术，
		 * Double和Float不放在常量池中
		 */
		// Byte byteA=120;
		// Byte byteB=120;
		// System.out.println(byteA==byteB);
		//			
		// Double doubleA=120d;
		// Double doubleB=120d;
		// System.out.println(doubleA==doubleB);

		/**
		 * 5.如果String可以被继承则会破坏常量池，所以String是final类型的
		 */

		/**
		 * 6.java5，StringBuilder 非线程安全，速度更快，建议使用
		 */
		// StringBuilder strBuild=new StringBuilder("abc");
		// StringBuffer strBuffer=new StringBuffer("abc");

		/**
		 * 7.StringBuilder和StringBuffer没有overriding方法equals，默认返回的是==的值
		 */
		// StringBuilder sBd1=new StringBuilder("abc");
		// StringBuilder sBd2=new StringBuilder("abc");
		// System.out.println(sBd1==sBd2);
		// System.out.println(sBd1.equals(sBd2));

		/**
		 * 8.累加性能问题
		 */
		// StringBuilder strBuilder=new StringBuilder();
		// String concatStr="a";
		// for (int iCount=0;iCount<4;iCount++){
		// strBuilder.append(iCount);
		// //concatStr+=iCount;
		// }
		// System.out.println(strBuilder);

		// Integer sumInt=0;
		// for (int iCount=0;iCount<4;iCount++){
		// sumInt+=iCount;
		// }
		// System.out.println(sumInt);

		/**
		 * 9.字符串解析
		 */
//		String a = new String("a_c_c_d_e_f_t");
//		String b = new String("a*c*c*d_e_f_t");
//
//		StringTokenizer st = new StringTokenizer(b, "*");
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}

		/**
		 * 10.装箱与拆箱
		 */
		// java 1.4 或者早期版本
		// Integer intVal=new Integer(3); //装箱
		// int temp=intVal.intValue(); //拆箱

		// java 5 或者以上版本
		// Integer intVal=3; //自动装箱
		// intVal++; //自动拆箱
	}
}
