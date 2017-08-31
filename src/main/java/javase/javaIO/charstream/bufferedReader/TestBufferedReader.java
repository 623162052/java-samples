package javase.javaIO.charstream.bufferedReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestBufferedReader {
	/**
	 *	���� 
	 */
	public static void main(String[] args) throws IOException {
//		testReadLine();
		getConsoleData();
		
	}
	
	/**
	 * BufferedReader ���ж�ȡ 
	 */
	public static void testReadLine() throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("src/javaIO/charstream/bufferedReader/from.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/javaIO/charstream/bufferedReader/to.txt"));
		
		String line;
		while((line = bf.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			//��ջ�����д���ļ�
			bw.flush();
		}
		if(bw != null){
			bw.close();
		}
		if(bf != null){
			bf.close();
		}
	}
	
	/**
	 *	�ӿ���̨��ȡ���� 
	 */
	public static void getConsoleData() throws NumberFormatException, IOException{
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("����һ��intֵ");
		int a = Integer.valueOf(bufReader.readLine());
		System.out.println(a);
		
		System.out.println("����һ��floatֵ");
		float b = Float.valueOf(bufReader.readLine());
		System.out.println(b);
		
		System.out.println("����һ��doubleֵ");
		double c = Double.valueOf(bufReader.readLine());
		System.out.println(c);
	}
	
}


