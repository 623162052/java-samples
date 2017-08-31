package javase.basic;
/**
 * ตÝน้
 * @author shiwx
 * @since 2011-9-12
 * @version 1.0
 */
public class Recursion {
	
	public static int method(int n){
		if(n==1){
			return 1;
		}else{
			return n*method(n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(method(5));
	}
}
