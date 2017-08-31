package javase.algorithm.search;

/**
 * ����
 * @author Matthew
 *
 */
public class SearchAlgorithm {
	
	/**
	 * ���ַ���ѯָ��ֵ��ָ��������������е�λ��
	 * ��������1
	 * ��ڿ죺logn + 1
	 * 
	 * @since 2011-12-2
	 * @author shiwx
	 * @version 1.0
	 */
	public static void dichotomy(){
		int[] intArr = {1,2,3,5,6,7,8,9,10,17,23,46,59};
		//targetΪ��ҪѰ�ҵ�ֵ
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
			System.out.println("�����±꣺" + value + " --- " + "��ǰ�ҵ�ֵ��" + intArr[middle]);
		}
		System.out.println("��ʹ�ã� " + count + " ���ҵ�Ŀ�꣬Ŀ���������е��±�Ϊ�� " + value);
	}
	
	
	public static void main(String[] args) {
		dichotomy();
	}
}
