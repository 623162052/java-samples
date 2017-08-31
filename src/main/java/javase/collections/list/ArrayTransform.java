package javase.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合数组间转换
 */
public class ArrayTransform {

	
	public static void main(String[] args) {		
		//正确代码
		List<String> list2 = new ArrayList<String>();
		list2.add("aaaa");
		list2.add("bbbbb");
		list2.add("ccccc");
		String[] strs2 = list2.toArray(new String[list2.size()]);
		for(String str : strs2){
			System.out.println(str);
		}
		
		//List转为数组
		String[] s = {"a","b","c"};
		List<String> list = java.util.Arrays.asList(s);
		for(String ss : list){
			System.out.println(ss);
		}
	}
}
