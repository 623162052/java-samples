package javase.javaIO.charstream.printWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
	/**
	 * ����
	 */
	public static void main(String[] args) throws IOException {
		print();
	}

	/**
	 *	PrintWriter��ӡ���������������ʽ����Ϣ 
	 */
	public static void print() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("src/javaIO/charstream/printWriter/test.txt"));
		pw.printf("abcdefg");
		pw.flush();
		pw.close();
	}

}
