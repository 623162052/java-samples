package javase.javaOO.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ���
 * 
 * @author Leo
 * 
 */
public class DeepCopy implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	public DC dc = new DC();

	/**
	 * ͨ��ʵ��Cloneable�ӿ���ʵ�����
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {

		Object o = super.clone();
		DeepCopy d = (DeepCopy) o;
		d.dc = (DC) dc.clone();
		return d;
	}

	/**
	 * ͨ��ʵ�����л���ʵ�����
	 * 
	 * @return
	 * @throws java.io.IOException
	 * @throws ClassNotFoundException
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {

		// ������д������
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);

		// �����������
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 * @throws ClassNotFoundException
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws CloneNotSupportedException,
			IOException, ClassNotFoundException {

		DeepCopy deepCopy1 = new DeepCopy();
		System.out.println(deepCopy1);
		System.out.println(deepCopy1.dc);

		DeepCopy deepCopy2 = (DeepCopy) deepCopy1.clone();
		System.out.println(deepCopy2);
		System.out.println(deepCopy2.dc);

		DeepCopy deepCopy3 = (DeepCopy) deepCopy1.deepClone();
		System.out.println(deepCopy3);
		System.out.println(deepCopy3.dc);
	}

}

class DC implements Cloneable, Serializable {
	private static final long serialVersionUID = 1816856252611186327L;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}