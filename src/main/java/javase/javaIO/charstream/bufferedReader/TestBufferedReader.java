package javase.javaIO.charstream.bufferedReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestBufferedReader {
	/**
	 *	测试 
	 */
	public static void main(String[] args) throws IOException {
//		testReadLine();
		getConsoleData();
		
	}
	
	/**
	 * BufferedReader 按行读取 
	 */
	public static void testReadLine() throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("src/javaIO/charstream/bufferedReader/from.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/javaIO/charstream/bufferedReader/to.txt"));
		
		String line;
		while((line = bf.readLine()) != null) {
			bw.write(line);
			bw.newLine();
			//清空缓冲区写入文件
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
	 *	从控制台获取数据 
	 */
	public static void getConsoleData() throws NumberFormatException, IOException{
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("输入一个int值");
		int a = Integer.valueOf(bufReader.readLine());
		System.out.println(a);
		
		System.out.println("输入一个float值");
		float b = Float.valueOf(bufReader.readLine());
		System.out.println(b);
		
		System.out.println("输入一个double值");
		double c = Double.valueOf(bufReader.readLine());
		System.out.println(c);
	}
	
}


