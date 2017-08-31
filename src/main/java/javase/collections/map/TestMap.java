package javase.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * ����Map
 */
public class TestMap {

	/**
	 * ӳ��(map) ӳ���뼯���б�����������ӳ����ÿ����ǳɶԵġ�ӳ���д洢��ÿ��������һ����صĹؼ��֣�Key������
	 * �ؼ��־����˶�����ӳ���еĴ洢λ�ã���������ʱ�����ṩ��Ӧ�Ĺؼ��֣��������ֵ��в鵥��һ�����ؼ���Ӧ����Ψһ�ġ�
	 * �ؼ��ֱ������ܾ�������Ĵ洢λ�ã�����Ҫ�Թ�һ��ɢ��(hashing)���������� ����һ��������ɢ����(hash
	 * code)������ֵ��ɢ����ͨ������һ��ƫ������ ��ƫ����������ڷ����ӳ����ڴ�������ʼλ�õģ��ɴ�ȷ���ؼ���/����ԵĴ洢λ�á�
	 * ��������£�ɢ�д���Ӧ�ò���������Χ�ھ��ȷֲ���ֵ������ÿ���ؼ���Ӧ�õ���ͬ��ɢ���롣
	 * 
	 * 
	 * * Map|->EnumMap [����key�����ظ�] |->HashMap
		 * [����key�����ظ�]���ࣩ���̰߳�ȫ��keyֵ����Ϊnull |->Hashtable
		 * [����key�����ظ�]�̰߳�ȫ��keyֵ������ֵ |->WeakHashMap [����key�����ظ�]
		 * |->IdentityHashMap [����key���ظ�] |->LinkedHashMap [��չ�ࣺ����key�����ظ�]
		 * **|->TreeMap [��չ�ࣺ����key�����ظ�]���ࣩ
		 * 
		 * 
		 * 
		 *  * Q.HashMap��HashTable���� A:1.Hashtable�ķ�����ͬ���ģ���HashMap�ķ�������.
		 * 2.ֻ��HashMap�������㽫��ֵ��Ϊһ�������Ŀ��key��value��
		 * HashMap��ֻ��һ����¼������һ���յ�key����������������Ŀ�����ǿյ�value��
		 * �����˵������ڱ���û�з��������������������������������������һ���յ�ֵ����ôget()������null��
		 * 
		 * 
		 * 	
	3.Map[����key�����ظ���value���ظ�]��ӳ�䣩�� ���ü�(key)-ֵ(value)�ԵĴ洢��ʽ�����ȿɶ�̬�ı�
		Map�д�ŵ���Entry����key��value��װ��һ��Entry���󣬷���Map�м������λ��
		Mapֻ��ͨ������������
		HashMap��key,value����Ϊnull
		HashTable:key,value������Ϊnull
		TreeMap		
		Map�����޶���<Object,Object>
	Map�����key-value��(�й�ϵ����������һ����key��һ����value��ͬʱ����)
		HashMap�����ڹ�ϣ��� Map �ӿڵ�ʵ�֣���ʵ���ṩ���п�ѡ��ӳ�������������ʹ�� null ֵ�� null ��
			������
				�ȵ���keySet()�õ�key��set���ϣ�
				�ٵ�������key��set���ϣ�
				����key�õ�value��
				
		Hashtable��ͬHashMap��һ�㲻ʹ��
		
		HashMap��Hashtable������
			HashMap�����̰߳�ȫ����֧�ֲ������ƣ�����յļ�ֵ�ԡ�
			Hashtable�����̰߳�ȫ��֧�ֲ������ƣ��������пյļ�ֵ�ԡ�
			
		SortedMap�ӿڣ�Map���ӽӿڣ���ĳһ�ض�������������������ļ�ֵ��
			ʵ���ࣺTreeMap�ࡣ
				Keyֵ���������ͬSortedSet�ӿ�ʵ����TreeSet
				
		ע�⣺
			keyһ����8�ֻ������͵ķ�װ�������String�࣬���Լ��Զ��������ΪKeyû�����塣
			key�����ظ���value�����ظ�
			
	HashMap
	������	1.��������Entry���ȽϺá�
				Set entrys = map.entrySet();
				Iterator it = entrys.iterator();
				while(it.hasNext()){
				  Map.Entry e = (Entry)it.next();
				  Object k = e.getKey();
				  Object v = e.getValue();				  
				}
			2.��������key
				Set keys = map.keySet();
				Interator it = keys.iterator();
				while(it.hasNext()){
					Object k = it.next();
					Object v = map.get(k);
				}		
			
			--------------------------
			��TreeMap
				�Զ��������Ϊ��ʱ�����Զ�������Ҫʵ��Comparable�ӿڣ���дcompareTo()����
				//compareTo()�Լ��ʹ������һ����Ƚϴ�С�������Լ�д
				//�Լ��󣬷�������
				//�Լ�С�����ظ���
				//��ȣ�����0
				��
				����
				���Ƚ���
				Comparator comparator = new Comparator(){
					public int compare (Object obj1, Object obj2){
						Point p1 = (Point) obj1;
						Point p2 = (Point) obj2;
						double d1 = p1.distance();
						double d2 = p2.distance();
						return d1 > d2 ? 1 : (d1 < d2 ? -1 : 0)
					}
				};
				��
				
		TreeMap
		������
		ÿ���ڵ��������֣������á�����������
		ÿ�¼�����ʱ���ȸ�С������ߣ��ȸ��󣬷��ұߣ�Ȼ�����α���ȥ��������滻����������ʱ��Ҳ��������
		����ʱ�������ҡ�Ҳ���Ǵ�С����
	 * 
	 */
	
	/**
	 * Map����-------------------------------------------------------------------------------------------------
	 */
	public void traverseMap(){
		String str1 = new String("Jack");
		String str2 = new String("Mike");
		String str3 = new String("Rose");
		String str4 = new String("David");

		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, str1);
		map.put(2, str2);
		map.put(3, str3);
		map.put(4, str4);

		//Iterator����key
		//����keyset���б����������ŵ����ڿ��Ը���������Ҫ��keyֵ�õ�����Ҫ�� values�����������
		Iterator<Integer> iterator1 = map.keySet().iterator();
		while (iterator1.hasNext()) {
			System.out.println("key -- " + iterator1.next());
		}

		
		//Iterator
		//����values���б���
		long start1 = System.currentTimeMillis();
		for(Iterator<String> iterator2 = map.values().iterator(); iterator2.hasNext(); ) {
			System.out.println("value -- " + (String) iterator2.next());
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
	
		//Iterator
		//����entrySet����,����Ч�ʸ�
		long start2 = System.currentTimeMillis();
		Iterator<Map.Entry<Integer, String>> iterator3 = map.entrySet().iterator();
		while(iterator3.hasNext()){
			//iterator3.next() 	 1=Mike
			Map.Entry<Integer, String> entry = iterator3.next();
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2-start2);
	}
	
	public void test2(){
		Map<String,Integer> m1 = new HashMap<String,Integer>();
		Map<String,Integer> m2 = new TreeMap<String,Integer>();
		m1.put("one", 1);
		m1.put("two", 2);
		m1.put("three", 3);
		m2.put("A", 1);
		m2.put("B", 2);
		System.out.println(m1.size());
		System.out.println(m1.containsKey("one"));
		System.out.println
				(m2.containsValue(1));
		if (m1.containsKey("two")) {
			int i = (Integer) m1.get("two");
			System.out.println(i);
		}
		Map<String,Integer> m3 = new HashMap<String,Integer>(m1);
		m3.putAll(m2);
		System.out.println(m3);
	}
	
	public static void main(String[] args) {
		TestMap test = new TestMap();
		test.traverseMap();
	}
	
}
