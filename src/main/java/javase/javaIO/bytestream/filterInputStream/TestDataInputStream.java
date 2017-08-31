package javase.javaIO.bytestream.filterInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * ���� DataInputStream/DataOutputStream
 */
public class TestDataInputStream {
	
	/**
	 *	���� 
	 */
	public static void main(String[] args) throws Exception {
		TestDataInputStream test = new TestDataInputStream();
		test.outputContent();
		test.inputContent();
	}

	/**
	 *	����DataInputStream��ȡ�ļ����� 
	 */
	public void inputContent() throws Exception {
		DataInputStream in = new DataInputStream(new FileInputStream("src/javaIO/bytestream/data.dat"));
		
		int i = in.readInt();
		double d = in.readDouble();
		boolean b = in.readBoolean();
		char c = in.readChar();
		String s = in.readUTF();
		
		// DataInputStream ѭ����ȡ���ݣ�����ѭ������������ available() �򲶻��쳣
		System.out.println(i + " - " + d + " - " + b + " - " + c + " - " + s);
		in.close();
	}

	/**
	 * ���� DataOutputStream ������ļ�
	 */
	public void outputContent() throws Exception {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("src/javaIO/bytestream/data.dat"));
		
		out.writeInt(8888888);
		out.writeDouble(3.14);
		out.writeBoolean(false);
		out.writeChar('a');
		out.writeUTF("abc��"); // ��UNICODE����תΪUTF-8����������
		
		out.flush();
		out.close();
	}
	
}
