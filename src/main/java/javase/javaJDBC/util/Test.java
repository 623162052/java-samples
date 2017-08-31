package javase.javaJDBC.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import org.apache.log4j.Logger;

/**
 * 测试
 * @author shiwx
 * @since 2011-12-15
 */
public class Test {
//	private static Logger logger = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		//初始化数据源
		DBManager.initDataSource();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try{
			connection = new DBManager().getConnection();
			statement = connection.createStatement();
			//此处sql语句结束不能加 分号
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
		//关闭数据源
		//DBManager.destoryDataSource();
	}
}
