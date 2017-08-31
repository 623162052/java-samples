package javase.javaSocket.ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ServerSocket
 * accept:用于产生"阻塞",直到服务端接受到一个连接并返回一个客户端的Socket对象实例 
 * getInputStream:服务端获得网络连接输入，同时返回一个IutputStream对象实例
 * getOutputStream:连接的另一端将得到输入，同时返回一个OutputStream对象实例
 * 
 */
public class Server {
	public static void main(String[] args) throws IOException {
		// 初始socket化服务器并开始运行
		ServerSocket serverSocket = new ServerSocket(10000);
		while (true) {
			// 侦听客户端的连接请求，如果发现有连接则实例化一个socket连接线程提供给客户机
			Socket socket = serverSocket.accept();
			// 获取socket输入流
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			// 获取socket输出流
			OutputStream os = socket.getOutputStream();
			PrintWriter out = new PrintWriter(os, true);
			// 读取客户端发送的数据流
			String line = in.readLine();
			System.out.println("由客户端传入的数据为:" + line);
			// 关闭所有资源
			out.close();
			in.close();
			socket.close();
		}
	}
}

