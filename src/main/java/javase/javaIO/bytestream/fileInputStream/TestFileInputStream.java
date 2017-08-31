package javase.javaIO.bytestream.fileInputStream;

import java.io.*;

/**
 * Test FileInputStream
 */
public class TestFileInputStream {
	
	/**
	 *  ����ͼƬ��һ����д���ڴ棬�Ƚ�Σ��
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
	 * ����ͼƬ���Ż�,����д��
	 */
	public static void copyPicAdvance() throws Exception{
		FileInputStream input = new FileInputStream("src/javaIO/bytestream/A.jpg");
		FileOutputStream out = new FileOutputStream("src/javaIO/bytestream/CopyAA.jpg");
		// ����1M�����飬ÿ�ζ�ȡ1M������
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
	 *	 ���ļ���ȡ����
	 */
	public static void readFileContent() throws Exception {
		FileInputStream in = new FileInputStream("src/javaIO/io.txt");
		//���ֽ�����һ�¶�ȡ����ֽ�������ٴ��̻�����Ч��
		//ż�����ֽ�һ�������Դ������ģ����ֽڶ�ȡʱ�����Ļᱻ��ֳ������ֽڣ��Ӷ���Ϊ����
		byte[] byteArray = new byte[10];				
		int n;		//ÿ�ζ�ȡ���ֽڸ���
		while((n = in.read(byteArray)) != -1){
			//��������������һ�ζ�ȡ���ֽ������������ַ������ȡ��һ�ζ���
			String temp = new String(byteArray, 0, n);		
			System.out.print(temp);
		}
		if(null != in){
			in.close();
		}
	}
	
	/**
	 * ����
	 */
	public static void main(String[] args) throws Exception {
//		test.copyPic();
//		test.copyPicAdvance();
		readFileContent();
	}
}
