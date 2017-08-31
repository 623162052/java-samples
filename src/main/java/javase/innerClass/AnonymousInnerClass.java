package javase.innerClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 匿名内部类
 */
public class AnonymousInnerClass {
	
	public static void main(String[] args) {
		Date d3 = new Date(){
			private static final long serialVersionUID = 1L;
			
			//重写toString
			public String toString(){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str = format.format(this);
				return str;
			}
		};
		//print会调用toString()方法
		System.out.println(d3);
	}
}


/*
匿名内部类
	定义：被声明的内部类没有类名
	父类 V = new 父类(){匿名子类类体;};
	例子1：
		class Popcorn{
			public void pop(){
				System.out.println("popcorn");
			}
		}
		class Food{
			Popcorn p = new Popcorn(){								
			//可以这样理解：声明Popcorn类型的引用变量p，然后声明一个新类，它没有名字，但是是Popcorn的子类。波形号开始了这个类的定义
				public void pop(){
					System.out.println("anonymous popcorn");
				}
			};
		}
		匿名内部类涉及到多态性
		
	例子2：假设Popcorn是接口
			Popcorn p = new Popcorn(){};  		//创建一个新的、匿名的Popcorn实现类的实例；波形号内实现Popcorn接口；此处只能实现一个接口
			
	变元内声明匿名内部类：
		b.doStuff(new FOO(){
			...
		});
 */
