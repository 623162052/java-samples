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
 * accept:���ڲ���"����",ֱ������˽��ܵ�һ�����Ӳ�����һ���ͻ��˵�Socket����ʵ�� 
 * getInputStream:����˻�������������룬ͬʱ����һ��IutputStream����ʵ��
 * getOutputStream:���ӵ���һ�˽��õ����룬ͬʱ����һ��OutputStream����ʵ��
 * 
 */
public class Server {
	public static void main(String[] args) throws IOException {
		// ��ʼsocket������������ʼ����
		ServerSocket serverSocket = new ServerSocket(10000);
		while (true) {
			// �����ͻ��˵������������������������ʵ����һ��socket�����߳��ṩ���ͻ���
			Socket socket = serverSocket.accept();
			// ��ȡsocket������
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			// ��ȡsocket�����
			OutputStream os = socket.getOutputStream();
			PrintWriter out = new PrintWriter(os, true);
			// ��ȡ�ͻ��˷��͵�������
			String line = in.readLine();
			System.out.println("�ɿͻ��˴��������Ϊ:" + line);
			// �ر�������Դ
			out.close();
			in.close();
			socket.close();
		}
	}
}

