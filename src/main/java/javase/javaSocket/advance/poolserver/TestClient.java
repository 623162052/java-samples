package javase.javaSocket.advance.poolserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	/**
	 * @param args
	 * @throws java.io.IOException
	 * @throws java.net.UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//����socket����
		Socket socket = new Socket("127.0.0.1", 10000);
		
		//��ȡsocket������
		InputStream is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader in = new BufferedReader(isr);
		
		//��ȡsocket�����
		OutputStream os=socket.getOutputStream();
		PrintWriter out = new PrintWriter(os, true);
		
		//�ɿ���̨��ȡ�������
		InputStream sysIn=System.in;
		InputStreamReader sysReader=new InputStreamReader(sysIn);
		BufferedReader line = new BufferedReader(sysReader);
		
		//������ݵ������
		out.println(line.readLine());
		
		String content="";
		while((content=in.readLine())!=null){
			System.out.println(content);
		}
		
		//�ͷ�������Դ
		line.close();
		out.close();
		in.close();
		socket.close();
	}

}
