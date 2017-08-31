package javase.javaSocket.advance.poolserver;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������Ѿ�ӵ�е� MultithreadedServer ÿ���пͻ�������һ������ʱ����һ���� Thread �д���һ���� ConnectionHandler ��
 * ����ζ�ſ�����һ�� Thread ���ɡ���������Χ�����Ҵ��� Thread ��ϵͳ����������΢������ġ�������ܳ�Ϊ�����⣨Ҳ�벻Ҫ�µ���ͷ����ʶ��������
 * ����Ч�ش������ǵķ������Ǽ����¡���ô��������θ���Ч�ع�����������أ�
 * ���ǿ���ά��һ����������ӳأ�һ�������� ConnectionHandler ��Ϊ���ṩ����
 * ��������ܴ������ºô��� 
 * 	->���޶�������ͬʱ���ӵ���Ŀ�� 
 * 	->����ֻ������ ConnectionHandler Thread һ�Ρ� 
 * ���˵��ǣ��������ǵĶ��߳�ʾ����һ��������������ӡ��ء�����Ҫ��һ����Ķ�����ʵ�ϣ�Ӧ�ó���Ŀͻ����˸����Ͳ���Ӱ�졣
 * �ڷ������ˣ������ڷ���������ʱ����һ�������� ConnectionHandler ��
 * ���ǰѽ�������ӷ��롰�ء��в��� ConnectionHandler ����ʣ�µ����顣
 * ����������кܶ����ǲ��������۵Ŀ��ܴ��ڵļ��ɡ�
 * ���磬���ǿ���ͨ���޶������ڡ��ء��н��������ӵ���Ŀ���ܾ��ͻ����� 
 * @author Leo
 * @version 2.2
 * @since 2010
 */
public class PooledRemoteFileServer {

	/**
	 * ���������
	 */
	protected int maxConnections;
	
	/**
	 * �����˿�
	 */
	protected int listenPort;
	
	/**
	 * socket����
	 */
	protected ServerSocket serverSocket;

	/**
	 * ��Ĺ������õĲ����������˿ں����ӵ������Ŀ 
	 * ���ǵ�����һ�� main() ���������������������Ժ����ǽ�̽����Щ������ϸ�ڡ�
	 * ����ֻ��֪�� setUpHandlers() ������ĿΪ maxConnections �Ĵ��� PooledConnectionHandler ��
	 * ����������������������ǰ���Ѿ����������ƣ�acceptConnections() �� ServerSocket ����������Ŀͻ������ӣ�
	 * �� handleConnection ���ڿͻ�������һ�����������ʵ�ʴ�����
	 * @param aListenPort
	 * @param maxConnections
	 */
	public PooledRemoteFileServer(int aListenPort, int maxConnections) {
		listenPort = aListenPort;
		this.maxConnections = maxConnections;
	}

	/**
	 * �������� maxConnections ������ 3���� PooledConnectionHandler ������ Thread �м������ǡ�
	 * ��ʵ���� Runnable �Ķ��������� Thread ʹ���ǿ����� Thread ���� start() 
	 * ���ҿ��������� Runnable �ϵ����� run() �����仰˵�����ǵ� PooledConnectionHandler 
	 * �����Ŵ����������ӣ�ÿ���������Լ��� Thread �н��С�������ʾ����ֻ�������� Thread ������һ�����������У���Ͳ��ܱ��ı䡣 
	 */
	public void setUpHandlers() {
		for (int i = 0; i < maxConnections; i++) {
			PooledConnectionHandler currentHandler = new PooledConnectionHandler();
			new Thread(currentHandler, "Handler " + i).start();
		}
	}

	/**
	 * ��һ���socket������ͬ������������������Ӳ��������handleConnection���������socket����
	 */
	public void acceptConnections() {
		try {
			ServerSocket server = new ServerSocket(listenPort, 5);
			Socket incomingConnection = null;
			while (true) {
				incomingConnection = server.accept();
				handleConnection(incomingConnection);
			}
		} catch (BindException e) {
			System.out.println("Unable to bind to port " + listenPort);
		} catch (IOException e) {
			System.out.println("Unable to instantiate a ServerSocket on port: "
					+ listenPort);
		}
	}

	/**
	 * ��������ʵ�������Ķ��� handleConnections() ����������ί�� PooledConnectionHandler ��������
	 * �������ڽ� PooledConnectionHandler �������н�������ӣ�processRequest() ��һ����̬��������
	 * @param connectionToHandle
	 */
	protected void handleConnection(Socket connectionToHandle) {
		PooledConnectionHandler.processRequest(connectionToHandle);
	}

	/**
	 * ��������ʵ�������Ķ��� main() �������÷����������ܹ����������Ŀ�Ŀͻ������ӵ� 
	 * PooledRemoteFileServer ������������������
	 * @param args
	 */
	public static void main(String[] args) {
		PooledRemoteFileServer server = new PooledRemoteFileServer(10000, 3);
		server.setUpHandlers();
		server.acceptConnections();
	}
}
