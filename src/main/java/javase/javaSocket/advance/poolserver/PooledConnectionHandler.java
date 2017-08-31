package javase.javaSocket.advance.poolserver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * ���߳��࣬�����ӵ���������socket���д���
 * @author Leo
 * @version 2.2
 * @since 2010
 */
public class PooledConnectionHandler implements Runnable {
	
	/**
	 * ��ǰ����
	 */
	protected Socket connection;
	
	/**
	 * �̳߳�
	 */
	protected static List<Socket> pool = new LinkedList<Socket>();

	/**
	 * ���캯��
	 */
	public PooledConnectionHandler() {
	}

	/**
	 * ��������ʵ�������Ķ��� handleConnection() �������÷�������ȡ���ӵ�����ʹ�����ǣ������������֮��������ǡ�
	 * ���ڶ��̷߳������в�ͬ�����ǵ� PooledConnectionHandler ��һ�� handleConnection() ������
	 * ��������Ĵ�����ǳ�ʽ�� ConnectionHandler �ϵ� run() �����Ĵ�����ȫһ����
	 * ���ȣ����ǰ� OutputStream �� InputStream �ֱ��װ��
	 * ���� Socket �ϵ� getOutputStream() �� getInputStream() ��
	 * BufferedReader �� PrintWriter ��Ȼ���������ж�Ŀ���ļ������������ڶ��߳�ʾ��������������
	 * ��һ�Σ����ǻ�ȡһЩ�ֽ�֮��Ͱ����Ƿŵ����ص� line �����У�Ȼ��д�����ͻ�����
	 * ��ɶ�д����֮�����ǹر� FileReader �ʹ򿪵�����
	 */
	public void handleConnection() {
		try {
			PrintWriter streamWriter = new PrintWriter(connection
					.getOutputStream());
			BufferedReader streamReader = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));

			String fileToRead = streamReader.readLine();
			BufferedReader fileReader = new BufferedReader(new FileReader(
					"src/demo/socket/advance/poolserver/"+fileToRead));

			String line = null;
			while ((line = fileReader.readLine()) != null)
				streamWriter.println(line);

			fileReader.close();
			streamWriter.close();
			streamReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ڷ��������޷��ҵ����ĵ�.");
		} catch (IOException e) {
			System.out.println("Error handling a client: " + e);
		}
	}

	/**
	 * ��������ʵ�� PooledConnectionHandler �ϵ� processRequest() ������
	 * �����Ѵ���������ӵ����У��������������ڵȴ��Ķ���ó��Ѿ���һЩ����
	 * processRequest() ����������һ�� pool �����ס����һ�� LinkedList ������ȴ���������ӳأ��� synchronized �顣
	 * ������������ԭ����ȷ��û�б����ܸ�����ͬʱ�޸����ӳء� ��Ȼ�����Ѿ���֤��������Ψһ����ˮ�����е��ˣ�
	 * ���ǾͿ��԰Ѵ���� Socket ��ӵ� LinkedList ��β�ˡ�
	 * һ������������µ����ӣ����Ǿ������´���֪ͨ�������ڵȴ��óص� Thread ���������Ѿ�����
	 * @param requestToHandle
	 */
	public static void processRequest(Socket requestToHandle) {
		synchronized (pool) {
			pool.add(pool.size(), requestToHandle);
			pool.notifyAll();
		}
	}

	/**
	 * ��������ʵ�� PooledConnectionHandler �������Ķ��� run() ���������������ӳ��ϵȴ������ҳ���һ�����Ӿʹ�����
	 */
	public void run() {
		while (true) {
			synchronized (pool) {
				while (pool.isEmpty()) {
					try {
						pool.wait();
					} catch (InterruptedException e) {
						return;
					}
				}
				connection = (Socket) pool.remove(0);
			}
			handleConnection();
		}
	}
}