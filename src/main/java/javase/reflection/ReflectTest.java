package javase.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 *  �ܹ������������ĳ��򱻳�Ϊ����,�Ա��д�ܹ���̬����Java����ĳ���
 *  
 *  Class û�й������췽����Class �������ڼ�����ʱ�� Java ������Լ�ͨ��������������е� defineClass �����Զ�����ġ�
clazz.newInstance() Ч�ʱ� new ��Ч�ʸ�
 *  
 * @author shiwx
 * @since 2011-12-13
 */
public class ReflectTest {

	/**
	 * clazz��ص����Է���
	 */
	public static void getClazz(){
		Class<?> clazz = String.class.getClass();
		//�������
		System.out.println(clazz.getName());
		//��ȡ������
		System.out.println(clazz.getSuperclass());
		
		//getFields() - ��ÿɷ��ʵĳ�Ա�����������̳е�
		// getDeclaredFields() - ������г�Ա�������������̳е�
		//getField(��Ա��������)
        //getDeclaredField(��Ա��������)
		Field[] fields = clazz.getFields();
		System.out.println(fields.length);
		for(Field field : fields){
			System.out.println(field.getName());
		}
		
		//��ȡ���췽��
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> constructor : constructors){
			System.out.println(constructor.getName());
		}
		
		//��ȡ�ɷ��ʵĳ�Ա����������ͨ���̳е�
		//getMethods() - //��ÿɷ��ʵķ���������ͨ���̳е�
        //getDeclaredMethods() - //������з���������˽�е��������̳е�
		//getMethod(������)	-//���ָ���ķ���(�ɷ��ʵģ������̳е�)
		//getDeclaredMethod(������, ������������)-//������з������������̳е�
		Method[] methods = clazz.getMethods();
		for(Method method : methods){
			System.out.println(method.getName());
		}
		
		//��������
		//Method m = String.class.getMethod(������, ���������б�);
//		/Object returnVal = m.invoke(ʵ��, ���������б�);
	}
	
	/**
	 * ����ʵ��
	 */
	public void createInstance() throws Exception{
		Class<?> clazz = String.class;
		//ʹ���޲ι۹��췽������ʵ��
		Object obj1 = clazz.newInstance();
		
		//ʹ���вι��췽������ʵ��
		Constructor<?> constructor = clazz.getConstructor(new Class[]{String.class});	//���������������� 
		Object obj2 = constructor.newInstance(new Object[]{"abcd"});					//���빹�췽���Ĳ�������
		
	}
	
	/**
	 * ���似�������Զ�̬�����κη���
	 * ���÷�����������������󣬳����ĸ����
	 */
	public static void testReflect() throws Exception{
//		Class clazz = Class.forName(className);
//		Method method = clazz.getmethod("method",new Class[]{String.class,int.class});
//		method.invoke(null,new Object[]{"Tom",18});
		
		//ʵ���� & ����
//		Class clazz = Class.forName(className);
//		Object object = clazz.newInstance();		//ʵ��������
//		Method method = clazz.getmethod("method",new Class[]{String.class,int.class});
//		method.invoke(object,new Object[]{"Tom",18});
		
		
		//����ػ���Class.forName()����ľ�̬��������̬���ԣ���̬������˳�ʼ�����������ù��캯������ʱ��ûʵ������
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

	//��һ�ַ�ʽ��***********************************************
	//���װ�أ����ӣ���ʼ��һ�������
	//һ�����ڲ������Լ�ʵ����ʱ������õ������static�����������ʱ��װ���Լ���Ӧ��Classʵ����������newͬһ����ڶ���ʱ�Ͳ�װ��Classʵ����,��Ϊ�����Ѿ���װ���ˡ�
	
	//�ڶ��ַ�ʽ��***********************************************
	//Class.forName����Ĭ�ϵ����������װ�ء����Ӻͳ�ʼ���ģ�
	Class.forName(className, true, currentLoader)(true��false���Ƿ��ʼ��,�����true�ģ���ôװ�ء����ӡ�����ʼ��;���false������װ�غ�����)
	JVM���Ҳ�����ָ������
		�����װ�ع��̼򵥵�˵���ǲ���һ������������������Ȼ�󴴽�Class��ʵ����
		������Ҳ�������ᱨClassNotFoundException��
		�������������ڣ��ڶ��δ�������ʱ�Ͳ���Ҫ����װ�ظ��ࡿ��
		����ľ�̬��������̬���ԣ���̬����г�ʼ�����������ù��캯��
*/


/*		-------������JDBC---------
	��JDBC�淶����ȷҪ�����Driver�������DriverManagerע���Լ�������forName,��������static����������. 
	������DriverManagerע������.����������ʹ��JDBCʱֻ��ҪClass.forName(xxx.xxx);
	java.sql.DriverManager.registerDriver(new Driver());
	Ȼ�����DriverManager�õ����ݿ������.
	Connection conn=DriverManager.getConnection(url); 

*/


