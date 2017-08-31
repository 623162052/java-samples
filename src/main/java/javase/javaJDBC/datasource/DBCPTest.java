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
		
		ds.setInitialSize(1);				//初始连接数
		ds.setMinIdle(3);				//最小空闲连接数量
		ds.setMaxActive(10);			//最大活动链接
		ds.setMaxWait(1000*60);				//得带归还的最长时间
		ds.setPoolPreparedStatements(true);		//允许缓存PreparedStatement
		ds.setValidationQuery("select sysdate from dual");		//测试一个连接是否正常，的sql语句
		//第一次需要新建连接
		long t1 = System.currentTimeMillis();
		Connection connection = ds.getConnection();
		connection.close();	
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
		
		//第二次直接从连接池取连接不需要新建
		long t3 = System.currentTimeMillis();
		connection = ds.getConnection();
		connection.close();		//此处的close()方法表示归还连接，而不是断开连接
		long t4 = System.currentTimeMillis();
		System.out.println(t4-t3);
	}
}
