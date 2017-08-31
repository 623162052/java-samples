package javase.javaSocket.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author shiwx
 * @since 2011-11-9
 * @version 1.0
 */
public class TCPClient {
	public static void main(String[] args) throws Exception {
		TCPClient tcpClient = new TCPClient();
		tcpClient.tcpClient();
	}
	
	
	public void tcpClient() throws Exception {
		Socket socket = new Socket("192.168.37.6",8080);
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeUTF("hello server");
		
		dos.flush();
		dos.close();
		socket.close();
	}
	
	//连接163
	public void test163() throws Exception {
		//创建socket链接
		//pop3.163.com IP : 123.125.50.29
		Socket socket = new Socket("pop3.163.com", 110);
		
		//获取socket输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());
		
		
		//获取socket输出流
		OutputStream os = socket.getOutputStream();
		os.write("Hello".getBytes());
		
		//关闭资源
		os.flush();
		br.close();
		os.close();
		socket.close();
	}
}
