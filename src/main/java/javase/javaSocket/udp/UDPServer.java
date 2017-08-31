package javase.javaSocket.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author shiwx
 * @since 2011-11-9
 * @version 1.0
 */
public class UDPServer {
	
	public static void main(String[] args) throws Exception {
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);	//��
		DatagramSocket ds = new DatagramSocket(5678);
		
		while(true){
			ds.receive(dp);	//�������հ�����buf��
			//��0��dp.getLength()���ȵ��ֽڷŵ���
			System.out.println(new String(buf, 0, dp.getLength()) + " ---");
		}

	}

}
