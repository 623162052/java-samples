package javase.genericType;

/**
 * 泛型,可以使用E或T代替未知类型
 * @author shiwx
 * @date   2012-2-26
 */
public class GenericType {
	
	//T可以为任何类型
	protected static <E> E cast(E x){
		return x;
	}
	
	//此处<? extends Object>,<?>,<? super String>都可以
	public void print(People<?> people){
		System.out.println(people.getFirst());
	}
	
	
	public static void main(String[] args) {
		GenericType gt = new GenericType();
		
		//test cast
		String str = cast("foo");
		
		//test print
		People<String> people = new People<String>();
		people.setFirst("fitst");
		people.setFirst("second");
		gt.print(people);
		
	}
}

/**
 * 泛型类
 * @author shiwx
 * @date   2012-2-26
 * @param <E>
 */
class People<E>{
	private E first;
	private E second;
	
	public People(){
	}
	public People(E first, E second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public E getFirst() {
		return first;
	}
	public void setFirst(E first) {
		this.first = first;
	}
	public E getSecond() {
		return second;
	}
	public void setSecond(E second) {
		this.second = second;
	}
}
