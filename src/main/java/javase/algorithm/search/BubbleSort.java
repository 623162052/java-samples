
package javase.algorithm.search;

/**
 * @author 嗷嗷
 * 冒泡排序
 *
 */
public class BubbleSort {
	
	private int[] arrayBubble;		
	private static int flag;				
	
	private BubbleSort(int length)
	{
		arrayBubble = new int[length];
		flag = 0;
	}
	
	private void insert(int value){
		arrayBubble[flag] = value;
		flag++;
	}
	
	private void swap(int a,int b){
		int temp = arrayBubble[a];
		arrayBubble[a] = arrayBubble[b];
		arrayBubble[b] = temp;
	}
	
	/*未优化的冒泡排序算法*/
	private void sortArray(){
		for(int i=0;i<arrayBubble.length;i++)
			for(int j=0;j<arrayBubble.length-1 ;j++){
				if(arrayBubble[j]>arrayBubble[j+1])  
					swap(j,j+1);
			}
	}
	
	
	/*优化过的冒泡排序算法*/
//	private void sortArray(){
//		for(int i=0;i<arrayBubble.length;i++)
//			for(int j=arrayBubble.length-1; j>0;j--)
//				if(arrayBubble[j]<arrayBubble[j-1])
//					swap(j,j-1);
//	}
	
	private void display(){
		for(int i=0;i<arrayBubble.length;i++)
			System.out.print(arrayBubble[i] + " ");		
		System.out.println();
	}
	
	
	public static void main(String[] args){
		BubbleSort bs = new BubbleSort(10);
		bs.insert(10);
		bs.insert(9);
		bs.insert(8);
		bs.insert(7);
		bs.insert(6);
		bs.insert(5);
		bs.insert(4);
		bs.insert(3);
		bs.insert(2);
		bs.insert(1);
		
		bs.display();
		bs.sortArray();
		bs.display();
		
	}
	

}












