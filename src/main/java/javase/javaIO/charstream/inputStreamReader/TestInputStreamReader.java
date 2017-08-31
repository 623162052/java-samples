package javase.javaIO.charstream.inputStreamReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *	����InputStreamReader, OutputStreamWriter 
 */
public class TestInputStreamReader {
	/**
	 *	���� 
	 */
	public static void main(String[] args) throws Exception {
		System.out.print(System.getProperty("user.dir"));
		copy("src/javaIO/charstream/inputStreamReader/test.txt", "src/javaIO/charstream/inputStreamReader/test_to.txt", "GBK", "UTF-8");
	}

	/**
	 *	�����ļ����任���ݱ��룩 
	 */
	protected static void copy(String from, String to, String fromCharSet, String toCharSet) throws Exception {
		InputStreamReader in = new InputStreamReader(new FileInputStream(from), fromCharSet);
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(to), toCharSet);
		
		char[] charArray = new char[1024];
		int counter;
		while((counter = in.read(charArray)) != -1){
			out.write(charArray, 0, counter);
			out.flush();
		}
		if(null != out){
			out.close();
		}
		if(null != in){
			in.close();
		}
	}
}
