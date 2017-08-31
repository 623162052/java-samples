package javase.javaSocket.tcp;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shiwx
 * @since 2011-11-9
 * @version 1.0
 */
public class TCPServer {

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(10000);	//指定端口
		int flag = 0;
		while(true){
			Socket socket = serverSocket.accept();		//serverSocket.accept()阻塞式的，等待连接封装为Socket对象
			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			System.out.println(dis.readUTF() + " - " + socket.getInetAddress().toString());			//dis.readUTF()阻塞式的
			dis.close();
			socket.close();
			
			System.out.println("success: " + flag);
			flag++;
		}
	}
}
