package javase.javaSocket.advance.poolserver;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 我们现在已经拥有的 MultithreadedServer 每当有客户机申请一个连接时都在一个新 Thread 中创建一个新 ConnectionHandler 。
 * 这意味着可能有一捆 Thread “躺”在我们周围。而且创建 Thread 的系统开销并不是微不足道的。如果性能成为了问题（也请不要事到临头才意识到它），
 * 更高效地处理我们的服务器是件好事。那么，我们如何更高效地管理服务器端呢？
 * 我们可以维护一个进入的连接池，一定数量的 ConnectionHandler 将为它提供服务。
 * 这种设计能带来以下好处： 
 * 	->它限定了允许同时连接的数目。 
 * 	->我们只需启动 ConnectionHandler Thread 一次。 
 * 幸运的是，跟在我们的多线程示例中一样，往代码中添加“池”不需要来一个大改动。事实上，应用程序的客户机端根本就不受影响。
 * 在服务器端，我们在服务器启动时创建一定数量的 ConnectionHandler ，
 * 我们把进入的连接放入“池”中并让 ConnectionHandler 打理剩下的事情。
 * 这种设计中有很多我们不打算讨论的可能存在的技巧。
 * 例如，我们可以通过限定允许在“池”中建立的连接的数目来拒绝客户机。 
 * @author Leo
 * @version 2.2
 * @since 2010
 */
public class PooledRemoteFileServer {

	/**
	 * 最大连接数
	 */
	protected int maxConnections;
	
	/**
	 * 侦听端口
	 */
	protected int listenPort;
	
	/**
	 * socket服务
	 */
	protected ServerSocket serverSocket;

	/**
	 * 类的构造器用的参数是侦听端口和连接的最大数目 
	 * 我们的类有一个 main() 方法和三个其它方法。稍后我们将探究这些方法的细节。
	 * 现在只须知道 setUpHandlers() 创建数目为 maxConnections 的大量 PooledConnectionHandler ，
	 * 而其它两个方法则与我们前面已经看到的相似：acceptConnections() 在 ServerSocket 上侦听传入的客户机连接，
	 * 而 handleConnection 则在客户机连接一旦被建立后就实际处理它
	 * @param aListenPort
	 * @param maxConnections
	 */
	public PooledRemoteFileServer(int aListenPort, int maxConnections) {
		listenPort = aListenPort;
		this.maxConnections = maxConnections;
	}

	/**
	 * 方法创建 maxConnections （例如 3）个 PooledConnectionHandler 并在新 Thread 中激活它们。
	 * 用实现了 Runnable 的对象来创建 Thread 使我们可以在 Thread 调用 start() 
	 * 并且可以期望在 Runnable 上调用了 run() 。换句话说，我们的 PooledConnectionHandler 
	 * 将等着处理进入的连接，每个都在它自己的 Thread 中进行。我们在示例中只创建三个 Thread ，而且一旦服务器运行，这就不能被改变。 
	 */
	public void setUpHandlers() {
		for (int i = 0; i < maxConnections; i++) {
			PooledConnectionHandler currentHandler = new PooledConnectionHandler();
			new Thread(currentHandler, "Handler " + i).start();
		}
	}

	/**
	 * 与一般的socket连接做同样处理，如果发现有连接差生则调用handleConnection方法处理该socket连接
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
	 * 这里我们实现需作改动的 handleConnections() 方法，它将委派 PooledConnectionHandler 处理连接
	 * 我们现在叫 PooledConnectionHandler 处理所有进入的连接（processRequest() 是一个静态方法）。
	 * @param connectionToHandle
	 */
	protected void handleConnection(Socket connectionToHandle) {
		PooledConnectionHandler.processRequest(connectionToHandle);
	}

	/**
	 * 这里我们实现需作改动的 main() 方法，该方法将创建能够处理给定数目的客户机连接的 
	 * PooledRemoteFileServer ，并告诉它接受连接
	 * @param args
	 */
	public static void main(String[] args) {
		PooledRemoteFileServer server = new PooledRemoteFileServer(10000, 3);
		server.setUpHandlers();
		server.acceptConnections();
	}
}
