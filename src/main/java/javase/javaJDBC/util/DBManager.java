package javase.javaJDBC.util;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * ���ݿ����
 * @since 2011-12-15
 * @author shiwx
 */
public class DBManager {
	private static Logger logger = Logger.getLogger(DBManager.class);
	private static DataSource dataSource;
	private static Connection connection = null;
	
	/**
	 * ��ʼ�����ݿ����ӳ�(������������ʱִ��)
	 */
	public static final void initDataSource() {
		logger.info("------ init datasource ------");
		
		//��ȡ�����ļ�
		Properties dbProps = new Properties();
		try {
			dbProps.load(DBManager.class.getResourceAsStream("db.properties"));
			dataSource =  (DataSource) Class.forName(dbProps.getProperty("jdbc.datasource")).newInstance();
			
			//��������Դ��Ϣ
			if(dbProps.getProperty("jdbc.datasource").indexOf("c3p0") > -1){
//				logger.info("------ config c3p0 ------");
				((ComboPooledDataSource) dataSource).setDriverClass(dbProps.getProperty("jdbc.driver"));
				((ComboPooledDataSource) dataSource).setJdbcUrl(dbProps.getProperty("jdbc.url"));
				((ComboPooledDataSource) dataSource).setUser(dbProps.getProperty("jdbc.user"));
				((ComboPooledDataSource) dataSource).setPassword(dbProps.getProperty("jdbc.password"));			
				//�������������
				((ComboPooledDataSource) dataSource).setMaxPoolSize(Integer.parseInt(dbProps.getProperty("jdbc.maxPoolSize")));
				//������С������
				((ComboPooledDataSource) dataSource).setMinPoolSize(Integer.parseInt(dbProps.getProperty("jdbc.minPoolSize")));
			}else if(dbProps.getProperty("jdbc.datasource").indexOf("dbcp") > -1){
//				logger.info("------ config dbcp ------");
				((BasicDataSource) dataSource).setUrl(dbProps.getProperty("jdbc.url"));
				((BasicDataSource) dataSource).setDriverClassName(dbProps.getProperty("jdbc.driver"));
				((BasicDataSource) dataSource).setUsername(dbProps.getProperty("jdbc.user"));
				((BasicDataSource) dataSource).setPassword(dbProps.getProperty("jdbc.password"));
				//��ʼ������
				((BasicDataSource) dataSource).setInitialSize(2);
				//��С������������
				((BasicDataSource) dataSource).setMinIdle(Integer.parseInt(dbProps.getProperty("jdbc.minPoolSize")));	
				//�������
				((BasicDataSource) dataSource).setMaxActive(Integer.parseInt(dbProps.getProperty("jdbc.maxPoolSize")));	
				//������PreparedStatement
				((BasicDataSource) dataSource).setPoolPreparedStatements(true);
			}else{
				throw new Exception("------ only support c3p0 and dbcp ------");
			}
		} catch (Exception e) {
//			logger.error("------ init datasource fail ------");
			e.printStackTrace();
		}
	}
	
	/**
	 * ע������Դ(���������ر�ʱִ��)
	 */
	public static final void destoryDataSource(){
//		logger.info("------ destroy datasource ------");
		try {
			Method close = dataSource.getClass().getMethod("close");
			close.invoke(dataSource);
		} catch (Exception e) {
//			logger.error("------ destroy datasource fail ------");
			e.printStackTrace();
		}
	} 
	
	/**
	 * ��ȡConnection
	 */
	public Connection getConnection(){
			try {
				connection = dataSource.getConnection();
			} catch (SQLException e) {
//				logger.error("------ get connection error ------");
				e.printStackTrace();
			}
			return connection;
	}
	
	/**
	 * �ر�Connection
	 */
	public static final void closeConnection(Connection conn){
		try{
			if(conn!=null && !conn.isClosed()){
				conn.setAutoCommit(true);
				conn.close();
			}
		}catch(Exception e){
//			logger.error("------ close connection error: " +  e.getMessage() +" ------");
		}
		
	}
}
