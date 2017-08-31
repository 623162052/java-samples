package javase.javaJDBC.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import org.apache.log4j.Logger;

/**
 * ����
 * @author shiwx
 * @since 2011-12-15
 */
public class Test {
//	private static Logger logger = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		//��ʼ������Դ
		DBManager.initDataSource();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection = new DBManager().getConnection();
			statement = connection.createStatement();
			//�˴�sql���������ܼ� �ֺ�
			resultSet = statement.executeQuery("SELECT * FROM TAB");		
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("TNAME") + " ----------");
			}
		}catch(Exception e){
//			logger.error("get result fial");
			e.printStackTrace();
			
		}finally{
			try{
				if(null!=resultSet && !resultSet.isClosed()){
					resultSet.close();
				}
				if(null!=statement && !statement.isClosed()){
					statement.close();
				}
				if(null!=connection && !connection.isClosed()){
					connection.close();
				}
			}catch(Exception e){
//				logger.error("close resource fail");
			}
			
		}
		//�ر�����Դ
		//DBManager.destoryDataSource();
	}
}
