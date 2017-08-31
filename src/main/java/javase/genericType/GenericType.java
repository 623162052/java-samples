package javase.genericType;

/**
 * ����,����ʹ��E��T����δ֪����
 * @author shiwx
 * @date   2012-2-26
 */
public class GenericType {
	
	//T����Ϊ�κ�����
	protected static <E> E cast(E x){
		return x;
	}
	
	//�˴�<? extends Object>,<?>,<? super String>������
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
 * ������
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
