package javase.basic;

public class DataType {
	/**
	 * 枚举类型
	 */
	enum Color {
		YELLOW, RED, BLACK, WHITE
	}; // enum不能再方法体中定义

	public static void main(String[] args) {
		
		//String是final的，一旦创建了，值就无法更改
		
		/**
		 * 关于枚举的equals和==
		 */
		// Color color1 = Color.RED;
		// Color color2 = Color.RED;
		//		
		// if(color1==color2)
		// System.out.println("==相等");
		// else
		// System.out.println("==不相等");
		//		
		// if(color1.equals(color2))
		// System.out.println("equal相等");
		// else
		// System.out.println("equal不相等");

		/**
		 * 短路
		 */
		// int a=1;
		// if(false && (a++)==1) //(a++)==1不参见运算
		// System.out.println(a); //这条语句不运行

		/**
		 * switch结构
		 */
		// switch中可以使用byte,short,char,int,enum
		// char temp='b';
		// switch(temp)
		// {
		// case 'a': System.out.print("a");
		// case 'b': System.out.print("b"); //没有break;输出bcdOthers
		// case 'c': System.out.print("c");
		// case 'd': System.out.print("d");
		// default:System.out.println("Others");
		// }

		/**
		 * switch结构
		 */
		// char temp1='b';
		// switch(temp1)
		// {
		// default:System.out.print("Others");
		// case 'a': System.out.print("a");
		// case 'b': System.out.print("b"); //没有break;default放到前面，输出bcd
		// case 'c': System.out.print("c");
		// case 'd': System.out.print("d");
		// }

		/**
		 * switch结构
		 * Only convertible int values or enum constants are permitted
		 */
		// char temp='b';
		// switch(temp)
		// {
		// case 'a': System.out.print("a"); break;
		// case 'b': System.out.print("b"); break; //输出b
		// case 'c': System.out.print("c"); break;
		// case 'd': System.out.print("d"); break;
		// default:
		// System.out.println("Others"); break;
		// }

		/**
		 * 死循环问题
		 */
		// int i=2147483640;
		// int j=1;
		// while(j>0)
		// {
		// System.out.println(i);
		// i++;
		// }

	}
}
