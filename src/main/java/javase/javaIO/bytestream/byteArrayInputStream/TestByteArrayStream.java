package javase.javaIO.bytestream.byteArrayInputStream;

import java.io.ByteArrayInputStream;

public class TestByteArrayStream {

	public static void main(String[] args) throws Exception {

		String strValue = "abcdefghijklmn";
		ByteArrayInputStream bais = new ByteArrayInputStream(strValue.getBytes());
		int k = 0;
		while ((k = bais.read()) != -1) {
			System.out.println((char)k);
		}
	}
}
