package javase.serializable.advance;

import java.io.*;

/**
 * 定制序列化
 */

public class OverrideSerial implements Serializable {
	private static final long serialVersionUID = -1608783310676957433L;
	private static int count; // 用于计算OverrideSerial对象的数目
	private static final int MAX_COUNT = 1000;
	private String name;
	private transient String password;

	static {
		System.out.println("调用OverrideSerial类的静态代码块 ");
	}

	public OverrideSerial() {
		System.out.println("调用OverrideSerial类的不带参数的构造方法 ");
		count++;
	}

	public OverrideSerial(String name, String password) {
		System.out.println("调用OverrideSerial类的带参数的构造方法 ");
		this.name = name;
		this.password = password;
		count++;
	}

	/**
	 * 加密数组，将buff数组中的每个字节的每一位取反 例如13的二进制为00001101，取反后为11110010
	 */
	private byte[] change(byte[] buff) {
		for (int i = 0; i < buff.length; i++) {
			int b = 0;
			for (int j = 0; j < 8; j++) {
				int bit = (buff[i] >> j & 1) == 0 ? 1 : 0;
				b += (1 << j) * bit;
			}
			buff[i] = (byte) b;
		}
		return buff;
	}

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject(); // 先按默认方式序列化
		stream.writeObject(change(password.getBytes()));
		stream.writeInt(count);
	}

	private void readObject(ObjectInputStream stream) throws IOException,
			ClassNotFoundException {
		stream.defaultReadObject(); // 先按默认方式反序列化
		byte[] buff = (byte[]) stream.readObject();
		password = new String(change(buff));
		count = stream.readInt();
	}

	public String toString() {
		return "count= " + count + "   MAX_COUNT= " + MAX_COUNT + "   name= "
				+ name + "   password= " + password;
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		FileOutputStream fos = new FileOutputStream("src/demo/serializable/advance/OverrideSerial");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		OverrideSerial osInput1 = new OverrideSerial("leo1","akiy123");
		OverrideSerial osInput2 = new OverrideSerial("leo2","akiy123");
		OverrideSerial osInput3 = new OverrideSerial("leo3","akiy123");
		oos.writeObject(osInput1);
		oos.writeObject(osInput2);
		oos.writeObject(osInput3);
		oos.flush();
		oos.close();
		
		FileInputStream fis = new FileInputStream("src/demo/serializable/advance/OverrideSerial");
		ObjectInputStream ois = new ObjectInputStream(fis);
		OverrideSerial osOutput1 = (OverrideSerial) ois.readObject();
		System.out.println(osOutput1.toString());
		OverrideSerial osOutput2 = (OverrideSerial) ois.readObject();
		System.out.println(osOutput2.toString());
		OverrideSerial osOutput3 = (OverrideSerial) ois.readObject();
		System.out.println(osOutput3.toString());
	}
}
