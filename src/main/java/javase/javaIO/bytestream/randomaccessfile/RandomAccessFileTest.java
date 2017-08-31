package javase.javaIO.bytestream.randomaccessfile;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *	RandomAccessFile ��������ļ��Ķ�ȡ��д�� 
 */
public class RandomAccessFileTest {
	public static void main(String[] args) throws IOException {
		tst1();
	}

	public static void tst1() throws IOException {
		RandomAccessFile r = new RandomAccessFile("src/javaIO/bytestream/test.obj", "rw");
		
		r.writeInt(8888888);
		r.writeLong(1L);
		r.writeDouble(3.14);
		r.writeUTF("���");
		
		r.seek(0); // ָ�붨λ��ĳ���ֽ�
		int i = r.readInt();
		r.seek(12);
		double d = r.readDouble();
		r.seek(4);
		r.writeLong(2L);
		r.seek(4);
		long l = r.readLong();
		
		System.out.println(i);
		System.out.println(d);
		System.out.println(l);
		
		r.seek(20);
		String s = r.readUTF();
		System.out.println(s);
		
		r.close();
	}
}
