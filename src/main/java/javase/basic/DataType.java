package javase.basic;

public class DataType {
	/**
	 * ö������
	 */
	enum Color {
		YELLOW, RED, BLACK, WHITE
	}; // enum�����ٷ������ж���

	public static void main(String[] args) {
		
		//String��final�ģ�һ�������ˣ�ֵ���޷�����
		
		/**
		 * ����ö�ٵ�equals��==
		 */
		// Color color1 = Color.RED;
		// Color color2 = Color.RED;
		//		
		// if(color1==color2)
		// System.out.println("==���");
		// else
		// System.out.println("==�����");
		//		
		// if(color1.equals(color2))
		// System.out.println("equal���");
		// else
		// System.out.println("equal�����");

		/**
		 * ��·
		 */
		// int a=1;
		// if(false && (a++)==1) //(a++)==1���μ�����
		// System.out.println(a); //������䲻����

		/**
		 * switch�ṹ
		 */
		// switch�п���ʹ��byte,short,char,int,enum
		// char temp='b';
		// switch(temp)
		// {
		// case 'a': System.out.print("a");
		// case 'b': System.out.print("b"); //û��break;���bcdOthers
		// case 'c': System.out.print("c");
		// case 'd': System.out.print("d");
		// default:System.out.println("Others");
		// }

		/**
		 * switch�ṹ
		 */
		// char temp1='b';
		// switch(temp1)
		// {
		// default:System.out.print("Others");
		// case 'a': System.out.print("a");
		// case 'b': System.out.print("b"); //û��break;default�ŵ�ǰ�棬���bcd
		// case 'c': System.out.print("c");
		// case 'd': System.out.print("d");
		// }

		/**
		 * switch�ṹ
		 * Only convertible int values or enum constants are permitted
		 */
		// char temp='b';
		// switch(temp)
		// {
		// case 'a': System.out.print("a"); break;
		// case 'b': System.out.print("b"); break; //���b
		// case 'c': System.out.print("c"); break;
		// case 'd': System.out.print("d"); break;
		// default:
		// System.out.println("Others"); break;
		// }

		/**
		 * ��ѭ������
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
