package javase.javaIO.charstream.printWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter {
	/**
	 * 测试
	 */
	public static void main(String[] args) throws IOException {
		print();
	}

	/**
	 *	PrintWriter打印流，用于输出带格式的信息 
	 */
	public static void print() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("src/javaIO/charstream/printWriter/test.txt"));
		pw.printf("abcdefg");
		pw.flush();
		pw.close();
	}

}
