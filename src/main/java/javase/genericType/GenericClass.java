package javase.genericType;


/**
 * Generic Interface
 */
interface GenericInterface<E> {
	public abstract E ooFoo();
}


public class GenericClass implements GenericInterface<Boolean> {

	public Boolean ooFoo() {
		return true;
	}
	
	public static void main(String[] args) {
		GenericInterface<Boolean> gc = new GenericClass();
		System.out.println(gc.ooFoo());
	}
	
}