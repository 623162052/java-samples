package javase.javaIO.bytestream.pipedInputStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * �ܵ���
 * �ܵ�������һ�������̺߳ʹ�����������ӵ���һ�������̺߳ʹ��������롣
 * java.io���ṩ����PipedInputStream��PipedOutputStream��Ϊ�ܵ�������/������ܵ�������
 * ��Ϊһ��ͨ�Źܵ��Ľ��նˣ��ܵ����������Ϊ���Ͷˡ��ܵ�������������������ã�����ʹ�ùܵ�ǰ�����߱����������
 *
 */
public class TestPipedStream {

	/**
	 * @param args
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);

		Send s1 = new Send(out, 1);
		Send s2 = new Send(out, 2);
		Receive r1 = new Receive(in);
		Receive r2 = new Receive(in);
		s1.start();
		s2.start();
		r1.start();
		r2.start();
	}

}

/**
 * �����߳�
 * @author Leo
 *
 */
class Send extends Thread
{
	PipedOutputStream out;
	int k = 0;
	static int threadCount=0;
	
	public Send(PipedOutputStream out, int k) {
		this.out = out;
		this.k = k;
		threadCount++;
	}

	public void run() {
		System.out.println("Send" + this.k + ": " + this.getName() + " ");
		int i = 1;
		try {
			while (i<=5) {
				out.write(i);
				System.out.println(this.getName()+" ��ܵ���д�� "+i);
				i++;
				sleep(100);
			}
			
			if (threadCount==1)
				out.close();
			else
				threadCount--;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Receive extends Thread // �����߳�
{
	PipedInputStream in;
	static int threadCount=0;
	
	public Receive(PipedInputStream in) {
		this.in = in;
		threadCount++;
	}

	public void run() {
		System.out.println("Receive: " + this.getName() + " ");
		try {
			int i=0;
			while ((i= in.read())!=-1) // ������δ����ʱ
			{
				System.out.println(this.getName()+" �ɹܵ��ж�ȡ "+i);
				sleep(100);
			}

			if (threadCount==1)
				in.close();
			else
				threadCount--;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}