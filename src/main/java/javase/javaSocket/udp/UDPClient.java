package javase.javaSocket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author shiwx
 * @since 2011-11-9
 * @version 1.0
 */
public class UDPClient {

	public static void main(String[] args) throws Exception {
		byte[] buf = new String("hello").getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1",5678));
		DatagramSocket ds = new DatagramSocket(9999);	//client占据9999端口向server端5678发
		ds.send(dp);
		ds.close();
		
	}
}
