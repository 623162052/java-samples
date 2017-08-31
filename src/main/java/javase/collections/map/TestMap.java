package javase.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 测试Map
 */
public class TestMap {

	/**
	 * 映射(map) 映射与集或列表有明显区别，映射中每个项都是成对的。映射中存储的每个对象都有一个相关的关键字（Key）对象，
	 * 关键字决定了对象在映射中的存储位置，检索对象时必须提供相应的关键字，就像在字典中查单词一样。关键字应该是唯一的。
	 * 关键字本身并不能决定对象的存储位置，它需要对过一种散列(hashing)技术来处理， 产生一个被称作散列码(hash
	 * code)的整数值，散列码通常用作一个偏置量， 该偏置量是相对于分配给映射的内存区域起始位置的，由此确定关键字/对象对的存储位置。
	 * 理想情况下，散列处理应该产生给定范围内均匀分布的值，而且每个关键字应得到不同的散列码。
	 * 
	 * 
	 * * Map|->EnumMap [无序，key不可重复] |->HashMap
		 * [无序，key不可重复]（多）非线程安全，key值可以为null |->Hashtable
		 * [无序，key不可重复]线程安全，key值必须有值 |->WeakHashMap [无序，key不可重复]
		 * |->IdentityHashMap [无序，key可重复] |->LinkedHashMap [扩展类：有序，key不可重复]
		 * **|->TreeMap [扩展类：有序，key不可重复]（多）
		 * 
		 * 
		 * 
		 *  * Q.HashMap与HashTable区别？ A:1.Hashtable的方法是同步的，而HashMap的方法不是.
		 * 2.只有HashMap可以让你将空值作为一个表的条目的key或value。
		 * HashMap中只有一条记录可以是一个空的key，但任意数量的条目可以是空的value。
		 * 这就是说，如果在表中没有发现搜索键，或者如果发现了搜索键，但它是一个空的值，那么get()将返回null。
		 * 
		 * 
		 * 	
	3.Map[无序，key不可重复，value可重复]（映射）： 采用键(key)-值(value)对的存储方式，长度可动态改变
		Map中存放的是Entry对象。key、value封装成一个Entry对象，放在Map中计算出的位置
		Map只能通过迭代器遍历
		HashMap：key,value都能为null
		HashTable:key,value都不能为null
		TreeMap		
		Map泛型限定：<Object,Object>
	Map：存放key-value对(有关系的两个对象，一个做key，一个做value，同时存入)
		HashMap：基于哈希表的 Map 接口的实现，此实现提供所有可选的映射操作，并允许使用 null 值和 null 键
			遍历：
				先调用keySet()得到key的set集合，
				再迭代遍历key的set集合，
				根据key得到value。
				
		Hashtable：同HashMap，一般不使用
		
		HashMap与Hashtable的区别：
			HashMap：非线程安全，不支持并发控制，允许空的键值对。
			Hashtable：是线程安全，支持并发控制，不允许有空的键值对。
			
		SortedMap接口：Map的子接口，按某一特定排序规则来存放所加入的键值对
			实现类：TreeMap类。
				Key值的排序规则，同SortedSet接口实现类TreeSet
				
		注意：
			key一般是8种基本类型的封装类或者是String类，拿自己自定义的类作为Key没有意义。
			key不可重复，value可以重复
			
	HashMap
	遍历：	1.遍历所有Entry【比较好】
				Set entrys = map.entrySet();
				Iterator it = entrys.iterator();
				while(it.hasNext()){
				  Map.Entry e = (Entry)it.next();
				  Object k = e.getKey();
				  Object v = e.getValue();				  
				}
			2.遍历所有key
				Set keys = map.keySet();
				Interator it = keys.iterator();
				while(it.hasNext()){
					Object k = it.next();
					Object v = map.get(k);
				}		
			
			--------------------------
			【TreeMap
				自定义对象作为键时，则自定义类需要实现Comparable接口，重写compareTo()方法
				//compareTo()自己和传入的另一对象比较大小，规则自己写
				//自己大，返回正数
				//自己小，返回负数
				//相等，返回0
				】
				或者
				【比较器
				Comparator comparator = new Comparator(){
					public int compare (Object obj1, Object obj2){
						Point p1 = (Point) obj1;
						Point p2 = (Point) obj2;
						double d1 = p1.distance();
						double d2 = p2.distance();
						return d1 > d2 ? 1 : (d1 < d2 ? -1 : 0)
					}
				};
				】
				
		TreeMap
		二叉树
		每个节点有三部分：左引用、对象、右引用
		每新加数据时，比根小，方左边，比根大，放右边，然后依次比下去，键相等替换。查找数据时，也是这样比
		遍历时，从左到右【也就是从小到大】
	 * 
	 */
	
	/**
	 * Map遍历-------------------------------------------------------------------------------------------------
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

		//Iterator遍历key
		//利用keyset进行遍历，它的优点在于可以根据你所想要的key值得到你想要的 values，更具灵活性
		Iterator<Integer> iterator1 = map.keySet().iterator();
		while (iterator1.hasNext()) {
			System.out.println("key -- " + iterator1.next());
		}

		
		//Iterator
		//利用values进行遍历
		long start1 = System.currentTimeMillis();
		for(Iterator<String> iterator2 = map.values().iterator(); iterator2.hasNext(); ) {
			System.out.println("value -- " + (String) iterator2.next());
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1-start1);
	
		//Iterator
		//利用entrySet遍历,这种效率高
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
