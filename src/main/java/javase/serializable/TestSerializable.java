package javase.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class TestSerializable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149411321746836965L;
	transient public byte version = 100;
	public int count = 10;

	/**
	 * Ϊʲô˵static���εĳ�Ա����Ҳ�Ƿ����л��ģ�
	 * static���๲��ģ�������һ���������л���
	 * ���static�������ܻᱻ��һ������ı䣬����������˾�̬�����ǲ������л���
	 */
    public static String strValue = new String("���л������ַ�");

	/**
	 * @param args
	 * @throws java.io.IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		/**
		 * 1.���౻���л������е����඼����ʽ�����л�
		 * 2.Ҫ�����л����������������Ķ���������Ѿ������л���
		 */
		
		FileOutputStream fos = new FileOutputStream("src/demo/serializable/TestSerializable");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TestSerializable tso = new TestSerializable();
		oos.writeObject(tso);
		oos.writeObject(new Date());
		oos.flush();
		oos.close();

		FileInputStream fis = new FileInputStream("src/demo/serializable/TestSerializable");
		ObjectInputStream ois = new ObjectInputStream(fis);
		TestSerializable tsi = (TestSerializable) ois.readObject();
		System.out.println("version:" + tsi.version + "  count:" + tsi.count);
		Date dateInput = (Date) ois.readObject();
		System.out.println(dateInput);
	}

}
