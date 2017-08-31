package javase.javaIO.charstream.fileReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFlieReader {

	/**
	 *	≤‚ ‘ 
	 */
	public static void main(String[] args) throws IOException {
		test();
	}
	
	/**
	 * 	FileReader
	 */
	public static void test() throws IOException{
		FileReader fr = new FileReader("src/javaIO/charstream/fileReader/test.txt");
		FileWriter fw = new FileWriter("src/javaIO/charstream/fileReader/test_to.txt");

		char[] in = new char[20];
		fr.read(in);
		fw.write(in);
		fw.flush();
		
		fr.close();
		fw.close();
	}

}
