package javase.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Test Set
 */
public class TestSet {

	/**
	 * 集 (Set) [无序、不可重复]
	 * 集是最简单的一种集合，它的对象不按特定方式排序，只是简单的把对象加入集合中，就像往口袋里放东西
	 * 对集中成员的访问和操作是通过集中对象的引用进行的，所以集中不能有重复对象。 
	 
	 * 集也有多种变体，可以实现排序等***能，
	 * 如TreeSet，它把对象添加到集中的操作将变为按照某种比较规则将其插入到有序的对象序列中。
	 * 它实现的是SortedSet接口，也就是加入了对象比较的方法。通过对集中的对象迭代，我们可以得到一个升序的对象集合。
	 * 
		只能通过迭代器遍历
		Iterator接口
		迭代器放在堆中
		迭代器是不可逆的
		Collections.sort(list);该方法要求被比较的对象实现了comparable接口
		
		将自定义类的对象存放在TreeSet中，这个类需要实现了Comparable接口，TreeSet可以自动过滤掉重复元素所以不在需要重载hashCode()方法，TreeSet会根据比较规则判断元素内容是否相同，不同则会存入，TreeSet会在元素存入时就进行排序。
			
		Comparable接口：
		也叫做可比较接口，这个接口在java.lang包下，只要根据指定类型的排序规则实现了这个接口，就是可排序的。
		这个接口中只定义了一个compareTo(Objecto)方法，该方法的返回值类型是整型，如果当前对象大于参数对象就返回正数，当前对象等于参数对象就返回0，当前对象小于参数对象就返回负值，这样写就是升序排列，反之则是进行降序排列。
			
		TreeSet要实现comparable接口才能比较对象
	 */
	
	//Set的遍历
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
		 * 集合间的关系
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
