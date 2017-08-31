package javase.javaIO.charstream.bufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * 	≤‚ ‘ LineNumberReader
 */	
public class TestLineNumberReader {
	
	/**
	 *	≤‚ ‘ 
	 */
	public static void main(String[] args) throws IOException {
		test();
	}
	
	
	public static void test() throws IOException {
		LineNumberReader lmr = null;
		lmr = new LineNumberReader(
				new FileReader("src/javaIO/charstream/bufferedReader/from.txt"));
		
		System.out.println(lmr.readLine());
		System.out.println(lmr.readLine());
		//line number¥”0ø™ º
		System.out.println(lmr.getLineNumber() + 1);
		System.out.println(lmr.readLine());
		
		if(lmr != null){
			lmr.close();
		}
	}

}
