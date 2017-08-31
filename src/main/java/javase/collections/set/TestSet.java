package javase.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Test Set
 */
public class TestSet {

	/**
	 * �� (Set) [���򡢲����ظ�]
	 * ������򵥵�һ�ּ��ϣ����Ķ��󲻰��ض���ʽ����ֻ�Ǽ򵥵İѶ�����뼯���У��������ڴ���Ŷ���
	 * �Լ��г�Ա�ķ��ʺͲ�����ͨ�����ж�������ý��еģ����Լ��в������ظ����� 
	 
	 * ��Ҳ�ж��ֱ��壬����ʵ�������***�ܣ�
	 * ��TreeSet�����Ѷ�����ӵ����еĲ�������Ϊ����ĳ�ֱȽϹ�������뵽����Ķ��������С�
	 * ��ʵ�ֵ���SortedSet�ӿڣ�Ҳ���Ǽ����˶���Ƚϵķ�����ͨ���Լ��еĶ�����������ǿ��Եõ�һ������Ķ��󼯺ϡ�
	 * 
		ֻ��ͨ������������
		Iterator�ӿ�
		���������ڶ���
		�������ǲ������
		Collections.sort(list);�÷���Ҫ�󱻱ȽϵĶ���ʵ����comparable�ӿ�
		
		���Զ�����Ķ�������TreeSet�У��������Ҫʵ����Comparable�ӿڣ�TreeSet�����Զ����˵��ظ�Ԫ�����Բ�����Ҫ����hashCode()������TreeSet����ݱȽϹ����ж�Ԫ�������Ƿ���ͬ����ͬ�����룬TreeSet����Ԫ�ش���ʱ�ͽ�������
			
		Comparable�ӿڣ�
		Ҳ�����ɱȽϽӿڣ�����ӿ���java.lang���£�ֻҪ����ָ�����͵��������ʵ��������ӿڣ����ǿ�����ġ�
		����ӿ���ֻ������һ��compareTo(Objecto)�������÷����ķ���ֵ���������ͣ������ǰ������ڲ�������ͷ�����������ǰ������ڲ�������ͷ���0����ǰ����С�ڲ�������ͷ��ظ�ֵ������д�����������У���֮���ǽ��н������С�
			
		TreeSetҪʵ��comparable�ӿڲ��ܱȽ϶���
	 */
	
	//Set�ı���
	public void traverseSet(){

		Set<String> set = new HashSet<String>();
		set.add("str1");
		set.add("str2");
		set.add("str3");
		
		//Iterator
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println((String) it.next());
		}
		
		//for
		for(Iterator<String> iterator = set.iterator(); iterator.hasNext(); ){
			System.out.println(iterator.next());
		}
	}
	
	//test
	public static void main(String[] args) {
//		TestSet test = new TestSet();
//		test.traverseSet();
//		
//		List<String> list = new ArrayList<String>();
//		list.add("1");
//		list.add("2");
//		list.add("1");
//		System.out.println(list.toString());
//		
//		Collection<String> noDups = new HashSet<String>(list);
//		System.out.println(noDups.toString());

		
		/**
		 * ���ϼ�Ĺ�ϵ
		 */
		Set<String> setA = new HashSet<String>();
		setA.add("aaa");
		setA.add("bbb");
		Set<String> setB = new HashSet<String>();
		setB.add("bbb");
		setB.add("ccc");
		
//		//returns true if setB is a subset of setA
//		System.out.println(setA.containsAll(setB));
//		
//		//transforms setA into the union of setA and setA
//		System.out.println(setA.addAll(setB));
//		System.out.println(setA);
//		
//		//transforms setA into the intersection of setA and setB
//		System.out.println(setA.retainAll(setB));
//		System.out.println(setA);
		
		//transforms setA into the (asymmetric) set difference of setA and setB
		System.out.println(setA.removeAll(setB));
		System.out.println(setA);
	}
}
