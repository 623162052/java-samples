package javase.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ���������ת��
 */
public class ArrayTransform {

	
	public static void main(String[] args) {		
		//��ȷ����
		List<String> list2 = new ArrayList<String>();
		list2.add("aaaa");
		list2.add("bbbbb");
		list2.add("ccccc");
		String[] strs2 = list2.toArray(new String[list2.size()]);
		for(String str : strs2){
			System.out.println(str);
		}
		
		//ListתΪ����
		String[] s = {"a","b","c"};
		List<String> list = java.util.Arrays.asList(s);
		for(String ss : list){
			System.out.println(ss);
		}
	}
}
