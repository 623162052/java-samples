package javase.javaJDBC.datasource;
import java.sql.Connection;
import org.apache.commons.dbcp.BasicDataSource;

public class DBCPTest {
	public static void main(String[] args) throws Exception {
		getConnection();
	}

	private static void getConnection() throws Exception {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("ccagapp");
		ds.setPassword("ccagapp");
		
		ds.setInitialSize(1);				//��ʼ������
		ds.setMinIdle(3);				//��С������������
		ds.setMaxActive(10);			//�������
		ds.setMaxWait(1000*60);				//�ô��黹���ʱ��
		ds.setPoolPreparedStatements(true);		//������PreparedStatement
		ds.setValidationQuery("select sysdate from dual");		//����һ�������Ƿ���������sql���
		//��һ����Ҫ�½�����
		long t1 = System.currentTimeMillis();
		Connection connection = ds.getConnection();
		connection.close();	
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		//�ڶ���ֱ�Ӵ����ӳ�ȡ���Ӳ���Ҫ�½�
		long t3 = System.currentTimeMillis();
		connection = ds.getConnection();
		connection.close();		//�˴���close()������ʾ�黹���ӣ������ǶϿ�����
		long t4 = System.currentTimeMillis();
		System.out.println(t4-t3);
	}
}
