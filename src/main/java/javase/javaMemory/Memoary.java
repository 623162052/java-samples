package javase.javaMemory;

import java.io.UnsupportedEncodingException;

public class Memoary {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/**
		 * JAVA�ڴ�ռ� �Ĵ����� ���洢��������������������䣬�����޷����� �ѣ�
		 * (���ܹ���)�������new�����Ķ��󡾳���String������������ĵ�ַ������
		 * ����GC�Ѷѽ��л��գ������еĶ����������������������գ���˴�С���������ڲ���Ҫȷ�������кܴ������ԡ� ջ��
		 * (���Թ���)�������������͵ı��������ݡ��͡���������á���ջ�е����ݴ�С�����������ǿ���ȷ���ģ���û������ָ������ʱ��������ݾͻ���ʧ��
		 * �����أ� (���Թ���)����ַ��������ͻ������ͳ�����public static
		 * final���������ַ��������������ö��Ǵ洢��ջ�еģ�����Ǳ������Ѿ�������
		 * (ֱ����˫���Ŷ����)�ľʹ洢�ڳ������У�����������ڣ�new�����ģ�����ȷ���ľʹ洢�ڶ��С� ��̬��
		 * (���Թ���)��ž�̬��Ա��static�����) ��RAM�洢�� Ӳ�̵����ô�ſռ�
		 * 
		 * 
		 * ջ�е����ݴ�С�����������ǿ���ȷ���ģ���û������ָ������ʱ��������ݾͻ���ʧ��
		 * ���еĶ����������������������գ���˴�С���������ڲ���Ҫȷ�������кܴ������ԡ�
		 * �����ַ��������������ö��Ǵ洢ջ�еģ�����Ǳ������Ѿ�������
		 * (ֱ����˫���Ŷ����)�ľʹ洢�ڳ������У�����������ڣ�new�����ģ�����ȷ���ľʹ洢�ڶ��С�
		 * 
		 * 1.String a = new String("abc"); ջ �� ������ a----->��ַ----->"abc"
		 * 2.StringBuilder varOne = new StringBuilder("abc"); ջ �� ������
		 * 		varOne->��ַ----->"abc"
		 * 3.String a = "abc"; ջ-----������ a------>"abc"
		 * 4.int a = 3; a��3������ջ
		 */
		/**
		 * 1.�ַ��������볣����
		 */
		// ����ڳ�����
		// String strA1="abc";
		// String strA2="abc";

		// �����ջ����
		// String strB1=new String("efg");
		// String strB2=new String("efg");

		// System.out.println(strA1==strA2);
		// System.out.println(strA1.equals(strA2));
		//			
		// System.out.println(strB1==strB2);
		// System.out.println(strB1.equals(strB2));

		/**
		 * 2.�����˼�������
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
		 * 3.���ڻ������͵ı����ͳ��������������ô洢��ջ�У������洢�ڳ�������
		 */
		// int intA=0;
		// public static final int INTB=0;

		/**
		 * 4.Byte,Short,Integer,Long,Character,Boolean,Stringʵ���˳����ؼ�����
		 * Double��Float�����ڳ�������
		 */
		// Byte byteA=120;
		// Byte byteB=120;
		// System.out.println(byteA==byteB);
		//			
		// Double doubleA=120d;
		// Double doubleB=120d;
		// System.out.println(doubleA==doubleB);

		/**
		 * 5.���String���Ա��̳�����ƻ������أ�����String��final���͵�
		 */

		/**
		 * 6.java5��StringBuilder ���̰߳�ȫ���ٶȸ��죬����ʹ��
		 */
		// StringBuilder strBuild=new StringBuilder("abc");
		// StringBuffer strBuffer=new StringBuffer("abc");

		/**
		 * 7.StringBuilder��StringBufferû��overriding����equals��Ĭ�Ϸ��ص���==��ֵ
		 */
		// StringBuilder sBd1=new StringBuilder("abc");
		// StringBuilder sBd2=new StringBuilder("abc");
		// System.out.println(sBd1==sBd2);
		// System.out.println(sBd1.equals(sBd2));

		/**
		 * 8.�ۼ���������
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
		 * 9.�ַ�������
		 */
//		String a = new String("a_c_c_d_e_f_t");
//		String b = new String("a*c*c*d_e_f_t");
//
//		StringTokenizer st = new StringTokenizer(b, "*");
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}

		/**
		 * 10.װ�������
		 */
		// java 1.4 �������ڰ汾
		// Integer intVal=new Integer(3); //װ��
		// int temp=intVal.intValue(); //����

		// java 5 �������ϰ汾
		// Integer intVal=3; //�Զ�װ��
		// intVal++; //�Զ�����
	}
}
