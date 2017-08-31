package javase.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Test List
 */
public class TestList {

	/**
	 * �б� (List)[���򡢿��ظ�]
	 * ���������б�Ĵ洢��ʽ,���ȿɶ�̬�ı�	
	 * [�ڲ���һ�����飬��Ӹ�������ʱ�������µĸ���������]
	 * ��ѯЧ�ʱȽϸߣ���ɾ��Ч�ʱȽϵͣ������ڲ�ѯ�Ƚ�Ƶ������ɾ�������ٵ�Ԫ�ع���ļ���
	 * ���ش�����������ʱ���Ƚ����ֶ��������Ч��(����ensureCapacity(int minCapacity)����)
	 * �б������ݽṹ�зֱ����Ϊ�������������������ջ������
     * 
	 * 
	 * LinkedList���ײ�����˫��ѭ��������ʵ�ֵ�
			��ѯЧ�ʵͣ�������ɾЧ�ʺܸߣ���������ɾ�����ıȽ�Ƶ������ѯ�������ٵ�Ԫ�ع���ļ���
			���м����ݴ�ȡЧ�ʲ��ߣ����������ݴ�ȡЧ�ʸ�
		˫�����������ɽڵ�������һ��ÿ���ڵ����ǰָ�򡢺�ָ���Ҫ��ŵ����ݣ���˫�����
		�������ڵ�.next()�Ƚϸ�Ч[Iterator]
		��forѭ��ֱ������ֵ����Ч�ʱȽϵͣ���Ϊÿ�ζ��ӵ�һ�ʼ��
	 * 
	 * Vector��ArrayList����:
	 *    1.vector���߳�ͬ���ģ������̰߳�ȫ����arraylist���߳��첽�ģ������̲߳���ȫ
	 * 			��������ǵ��̵߳İ�ȫ���أ�һ����arraylistЧ�ʱȽϸ�
	 * 	  2.������Ԫ����Ŀ����Ŀǰ�������鳤��ʱ��Vector������ΪĿǰ���鳤�ȵ�100%,��ArrayList������ΪĿǰ���鳤�ȵ�50%
	 *			����ڼ�����ʹ���������Ƚϴ�����ݣ���vector��һ��������
	 *    3.�������һ��ָ��λ�õ����ݣ�Vector��ArrayListʹ�õ�ʱ������ͬ�ģ�����0(1),
	 *		������ƶ�һ��ָ��λ�õ����ݻ��ѵ�ʱ��Ϊ0(n-i)nΪ�ܳ��ȣ����ʱ���Ӧ�ÿ��ǵ�ʹ��linklist,
	 * 		linklist�ƶ�һ��ָ��λ�õ����������ѵ�ʱ��Ϊ0(1), ����ѯһ��ָ��λ�õ�����ʱ���ѵ�ʱ��Ϊ0(i)��
	 */
	
	/**
	 * ArrayList�ı���-----------------------------------------------------------------------------------------------
	 */
	public void traverseList(){
		List<String> list = new ArrayList<String>();
		list.add("str1");
		list.add("str2");
		list.add("str3");
		
//		//forѭ��
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println((String) list.get(i));
//		}
//		
//		//��ǿforѭ��[for/in]: ����ȷ��λ��
//		for(String str : list){
//			System.out.println(str);
//		}
		
		//Iterator:����ȷ��λ��
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()){
			String elem = iterator1.next();
			System.out.println(elem);
			if(iterator1.next().equals("str2")){
				list.remove("str2");
			}
		}
		
		System.out.println("-------------");
		
		//forѭ��:����ȷ��λ��,��ʽѧԺ���
		for(Iterator<String> iterator2 = list.iterator(); iterator2.hasNext(); ){
			System.out.println(iterator2.next());
		}
	}
	
	//test
	public static void main(String[] args) {
		TestList test = new TestList();
		test.traverseList();
	}
}
