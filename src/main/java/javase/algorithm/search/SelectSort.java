package javase.algorithm.search;


public class SelectSort {
	private int[] arraySelect;
	private static int flag1;	
	
	private SelectSort(int length) {
		arraySelect = new int[length];
		flag1 = 0;
	}
	
	private void insert(int value) {
		arraySelect[flag1] = value;
		flag1++;
	}
	
	private void display(){
		for(int i=0; i<arraySelect.length;i++){
			System.out.print(arraySelect[i] + "  ");
		}
		System.out.println();
	}
	
	private void selectSort() {
		int swap = 0;
		int flag2 = 0;
		for(int i=0;i<arraySelect.length-1;i++){				//最多进行length-1次交换
			flag2 = i;
			for(int j=i+1;j<arraySelect.length;j++){ 			//j=i+1,i=1时，j循环分别执行9，8，7，6，5，4，3，2，1次											
				if(arraySelect[flag2] > arraySelect[j])
					flag2 = j;
			}
				
			swap = arraySelect[flag2]; 
			arraySelect[flag2] = arraySelect[i];
			arraySelect[i] = swap;
			
		}
	}
	
	public static void main(String[] args){
		SelectSort ss = new SelectSort(10);
		ss.insert(10);
		ss.insert(9);
		ss.insert(8);
		ss.insert(7);
		ss.insert(6);
		ss.insert(5);
		ss.insert(4);
		ss.insert(3);
		ss.insert(2);
		ss.insert(1);
		
		ss.display();
		ss.selectSort();
		ss.display();
	}
	
}



