package javase.javaIO.bytestream.fileInputStream;

import java.io.*;

/**
 * Test FileInputStream
 */
public class TestFileInputStream {
	
	/**
	 *  复制图片：一次性写入内存，比较危险
	 */
	public static void copyPic() throws Exception{
		FileInputStream input = new FileInputStream("src/javaIO/bytestream/A.jpg");
		FileOutputStream out = new FileOutputStream("src/javaIO/bytestream/CopyA.jpg");
		byte[] b = new byte[input.available()];
		input.read(b);
		input.close();
		
		out.write(b);
		out.close();
	}
	
	/**
	 * 复制图片：优化,分批写入
	 */
	public static void copyPicAdvance() throws Exception{
		FileInputStream input = new FileInputStream("src/javaIO/bytestream/A.jpg");
		FileOutputStream out = new FileOutputStream("src/javaIO/bytestream/CopyAA.jpg");
		// 建立1M的数组，每次读取1M的数据
		byte[] b = new byte[1024]; 
		int count = 0;
		while ((count = input.read(b)) > 0) {
			out.write(b, 0, count);
			out.flush();
		}
		
		input.close();
		out.close();
	}
	
	/**
	 *	 从文件读取内容
	 */
	public static void readFileContent() throws Exception {
		FileInputStream in = new FileInputStream("src/javaIO/io.txt");
		//用字节数组一下读取多个字节提议减少磁盘活动，提高效率
		//偶数个字节一起处理，可以处理中文，单字节读取时，中文会被拆分成两个字节，从而成为乱码
		byte[] byteArray = new byte[10];				
		int n;		//每次读取的字节个数
		while((n = in.read(byteArray)) != -1){
			//不这样，如果最后一次读取的字节数不满，则字符串会读取上一次读的
			String temp = new String(byteArray, 0, n);		
			System.out.print(temp);
		}
		if(null != in){
			in.close();
		}
	}
	
	/**
	 * 测试
	 */
	public static void main(String[] args) throws Exception {
//		test.copyPic();
//		test.copyPicAdvance();
		readFileContent();
	}
}
