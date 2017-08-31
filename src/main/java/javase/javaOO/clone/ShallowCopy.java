package javase.javaOO.clone;

/**
 * ǳ������Ӱ�ӿ�����
 * @author Leo
 *
 */
public class ShallowCopy implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowCopy shallowCopy=new ShallowCopy();
		System.out.println(shallowCopy);
		ShallowCopy shallowCopy1=(ShallowCopy)shallowCopy.clone();
		System.out.println(shallowCopy1);
	}
}
