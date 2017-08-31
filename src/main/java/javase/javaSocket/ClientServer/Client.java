package javase.javaSocket.ClientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


/*
 * Socket
 * connect:
 * getInputStream:客户端获得网络连接输入，同时返回一个IutputStream对象实例 
 * getOutputStream:连接的另一端将得到输入，同时返回一个OutputStream对象实例 
 * 
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException,IOException {
		//创建socket连接
		Socket socket = new Socket("127.0.0.1",10000);

		//获取socket输入流
		InputStream is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader in = new BufferedReader(isr);
		
		//获取socket输出流
		OutputStream os=socket.getOutputStream();
		PrintWriter out = new PrintWriter(os, true);
		
		//由控制台读取输入数据
		InputStream sysIn=System.in;
		InputStreamReader sysReader=new InputStreamReader(sysIn);
		BufferedReader line = new BufferedReader(sysReader);
		
		out.write(line.readLine());
		out.flush();
		
		//释放所有资源
		line.close();
		out.close();
		in.close();
		socket.close();

	}
}
