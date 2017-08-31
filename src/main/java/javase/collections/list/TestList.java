package javase.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Test List
 */
public class TestList {

	/**
	 * 列表 (List)[有序、可重复]
	 * 采用线性列表的存储方式,长度可动态改变	
	 * [内部是一个数组，添加更多数据时，创建新的更长的数组]
	 * 查询效率比较高，增删的效率比较低，适用于查询比较频繁，增删动作较少的元素管理的集合
	 * 加载大批量的数据时，先进行手动扩容提高效率(调用ensureCapacity(int minCapacity)方法)
	 * 列表在数据结构中分别表现为：数组和向量、链表、堆栈、队列
     * 
	 * 
	 * LinkedList：底层是用双向循环链表来实现的
			查询效率低，但是增删效率很高，适用于增删动作的比较频繁，查询次数较少的元素管理的集合
			对中间数据存取效率不高，对两端数据存取效率高
		双向链表：由若干节点连接在一起，每个节点包括前指向、后指向和要存放的数据，能双向遍历
		遍历：节点.next()比较高效[Iterator]
		用for循环直接索引值遍历效率比较低，因为每次都从第一项开始找
	 * 
	 * Vector与ArrayList区别:
	 *    1.vector是线程同步的，所以线程安全；而arraylist是线程异步的，所以线程不安全
	 * 			如果不考虑到线程的安全因素，一般用arraylist效率比较高
	 * 	  2.集合中元素数目大于目前集合数组长度时，Vector增长率为目前数组长度的100%,而ArrayList增长率为目前数组长度的50%
	 *			如果在集合中使用数据量比较大的数据，用vector有一定的优势
	 *    3.如果查找一个指定位置的数据，Vector和ArrayList使用的时间是相同的，都是0(1),
	 *		而如果移动一个指定位置的数据花费的时间为0(n-i)n为总长度，这个时候就应该考虑到使用linklist,
	 * 		linklist移动一个指定位置的数据所花费的时间为0(1), 而查询一个指定位置的数据时花费的时间为0(i)。
	 */
	
	/**
	 * ArrayList的遍历-----------------------------------------------------------------------------------------------
	 */
	public void traverseList(){
		List<String> list = new ArrayList<String>();
		list.add("str1");
		list.add("str2");
		list.add("str3");
		
//		//for循环
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println((String) list.get(i));
//		}
//		
//		//增强for循环[for/in]: 不能确定位置
//		for(String str : list){
//			System.out.println(str);
//		}
		
		//Iterator:不能确定位置
		Iterator<String> iterator1 = list.iterator();
		while(iterator1.hasNext()){
			String elem = iterator1.next();
			System.out.println(elem);
			if(iterator1.next().equals("str2")){
				list.remove("str2");
			}
		}
		
		System.out.println("-------------");
		
		//for循环:不能确定位置,旧式学院风格
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
