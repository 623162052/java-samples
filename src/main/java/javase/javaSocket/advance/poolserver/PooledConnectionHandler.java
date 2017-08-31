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
 * 多线程类，对连接到服务器的socket进行处理
 * @author Leo
 * @version 2.2
 * @since 2010
 */
public class PooledConnectionHandler implements Runnable {
	
	/**
	 * 当前连接
	 */
	protected Socket connection;
	
	/**
	 * 线程池
	 */
	protected static List<Socket> pool = new LinkedList<Socket>();

	/**
	 * 构造函数
	 */
	public PooledConnectionHandler() {
	}

	/**
	 * 这里我们实现需做改动的 handleConnection() 方法，该方法将攫取连接的流，使用它们，并在任务完成之后清除它们。
	 * 跟在多线程服务器中不同，我们的 PooledConnectionHandler 有一个 handleConnection() 方法。
	 * 这个方法的代码跟非池式的 ConnectionHandler 上的 run() 方法的代码完全一样。
	 * 首先，我们把 OutputStream 和 InputStream 分别包装进
	 * （用 Socket 上的 getOutputStream() 和 getInputStream() ）
	 * BufferedReader 和 PrintWriter 。然后我们逐行读目标文件，就象我们在多线程示例中做的那样。
	 * 再一次，我们获取一些字节之后就把它们放到本地的 line 变量中，然后写出到客户机。
	 * 完成读写操作之后，我们关闭 FileReader 和打开的流。
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
			System.out.println("在服务器上无法找到该文档.");
		} catch (IOException e) {
			System.out.println("Error handling a client: " + e);
		}
	}

	/**
	 * 这里我们实现 PooledConnectionHandler 上的 processRequest() 方法，
	 * 它将把传入请求添加到池中，并告诉其它正在等待的对象该池已经有一些内容
	 * processRequest() 方法包含有一个 pool （请记住它是一个 LinkedList ，保存等待处理的连接池）的 synchronized 块。
	 * 我们这样做的原因是确保没有别人能跟我们同时修改连接池。 既然我们已经保证了我们是唯一“涉水”池中的人，
	 * 我们就可以把传入的 Socket 添加到 LinkedList 的尾端。
	 * 一旦我们添加了新的连接，我们就用以下代码通知其它正在等待该池的 Thread ，池现在已经可用
	 * @param requestToHandle
	 */
	public static void processRequest(Socket requestToHandle) {
		synchronized (pool) {
			pool.add(pool.size(), requestToHandle);
			pool.notifyAll();
		}
	}

	/**
	 * 这里我们实现 PooledConnectionHandler 上需作改动的 run() 方法，它将在连接池上等待，并且池中一有连接就处理它
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