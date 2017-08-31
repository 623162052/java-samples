package javase.algorithm.search;

/**
 * 搜索
 * @author Matthew
 *
 */
public class SearchAlgorithm {
	
	/**
	 * 二分法查询指定值在指定已排序的数组中的位置
	 * 最好情况：1
	 * 最坏勤快：logn + 1
	 * 
	 * @since 2011-12-2
	 * @author shiwx
	 * @version 1.0
	 */
	public static void dichotomy(){
		int[] intArr = {1,2,3,5,6,7,8,9,10,17,23,46,59};
		//target为需要寻找的值
		int target = 59, value = 0;
		int low = 0, high = intArr.length-1, middle;
		int count = 0;
		
		while(low <= high && value == 0){
			count++;
			middle = (low + high)/2;
			
			if(target == intArr[middle]){
				value = middle;
			}else if(target > intArr[middle]){
				low = middle + 1;
			}else{
				high = middle -1;
			}
			System.out.println("数组下标：" + value + " --- " + "当前找到值：" + intArr[middle]);
		}
		System.out.println("共使用： " + count + " 次找到目标，目标在数组中的下标为： " + value);
	}
	
	
	public static void main(String[] args) {
		dichotomy();
	}
}
