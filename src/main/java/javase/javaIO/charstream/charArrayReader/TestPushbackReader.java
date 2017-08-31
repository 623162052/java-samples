package javase.javaIO.charstream.charArrayReader;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class TestPushbackReader {

	public static void main(String[] args) throws IOException {
		/*
		 * PushbackReader��ǰ���ᵽ��PushbackInputStream���ƣ�
		 * ��ӵ��һ��PushBack��������ֻ����PushbackReader����������ַ���
		 * ���������������ݺ����Ը��Ļ���ֻҪPushBack������û������ �Ϳ���ʹ��unread()�������ƻ�����ǰ�ˡ�
		 */
		char[] charVal = { 'a', 'b', 'c' };
		PushbackReader pushbackReader = new PushbackReader(new CharArrayReader(charVal),3);
		
		int k = 0;
		k = pushbackReader.read();
		System.out.println((char) k);
		k = pushbackReader.read();
		System.out.println((char) k);

		pushbackReader.unread('x');
		pushbackReader.unread('y');
		pushbackReader.unread('y');
		
		k = pushbackReader.read();
		System.out.println((char) k);
		k = pushbackReader.read();
		System.out.println((char) k);
	}

}
