package javase.javaIO.charstream.charArrayReader;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.PushbackReader;

public class TestPushbackReader {

	public static void main(String[] args) throws IOException {
		/*
		 * PushbackReader与前面提到的PushbackInputStream类似，
		 * 都拥有一个PushBack缓冲区，只不过PushbackReader所处理的是字符。
		 * 从这个对象读出数据后，如果愿意的话，只要PushBack缓冲区没有满， 就可以使用unread()将数据推回流的前端。
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
