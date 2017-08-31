package javase.javaIO.bytestream.filterInputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 测试 DataInputStream/DataOutputStream
 */
public class TestDataInputStream {
	
	/**
	 *	测试 
	 */
	public static void main(String[] args) throws Exception {
		TestDataInputStream test = new TestDataInputStream();
		test.outputContent();
		test.inputContent();
	}

	/**
	 *	利用DataInputStream读取文件内容 
	 */
	public void inputContent() throws Exception {
		DataInputStream in = new DataInputStream(new FileInputStream("src/javaIO/bytestream/data.dat"));
		
		int i = in.readInt();
		double d = in.readDouble();
		boolean b = in.readBoolean();
		char c = in.readChar();
		String s = in.readUTF();
		
		// DataInputStream 循环读取数据，控制循环结束可以用 available() 或捕获异常
		System.out.println(i + " - " + d + " - " + b + " - " + c + " - " + s);
		in.close();
	}

	/**
	 * 利用 DataOutputStream 输出到文件
	 */
	public void outputContent() throws Exception {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("src/javaIO/bytestream/data.dat"));
		
		out.writeInt(8888888);
		out.writeDouble(3.14);
		out.writeBoolean(false);
		out.writeChar('a');
		out.writeUTF("abc中"); // 将UNICODE编码转为UTF-8编码进行输出
		
		out.flush();
		out.close();
	}
	
}
