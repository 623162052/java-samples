package javase.innerClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * �����ڲ���
 */
public class AnonymousInnerClass {
	
	public static void main(String[] args) {
		Date d3 = new Date(){
			private static final long serialVersionUID = 1L;
			
			//��дtoString
			public String toString(){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String str = format.format(this);
				return str;
			}
		};
		//print�����toString()����
		System.out.println(d3);
	}
}


/*
�����ڲ���
	���壺���������ڲ���û������
	���� V = new ����(){������������;};
	����1��
		class Popcorn{
			public void pop(){
				System.out.println("popcorn");
			}
		}
		class Food{
			Popcorn p = new Popcorn(){								
			//����������⣺����Popcorn���͵����ñ���p��Ȼ������һ�����࣬��û�����֣�������Popcorn�����ࡣ���κſ�ʼ�������Ķ���
				public void pop(){
					System.out.println("anonymous popcorn");
				}
			};
		}
		�����ڲ����漰����̬��
		
	����2������Popcorn�ǽӿ�
			Popcorn p = new Popcorn(){};  		//����һ���µġ�������Popcornʵ�����ʵ�������κ���ʵ��Popcorn�ӿڣ��˴�ֻ��ʵ��һ���ӿ�
			
	��Ԫ�����������ڲ��ࣺ
		b.doStuff(new FOO(){
			...
		});
 */
