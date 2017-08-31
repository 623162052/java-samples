package javase.javaJDBC.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//DataSource： DataManager的替代项，由驱动程序供应商提供，可以生成数据库连接池
//使用DataManager直接获得数据库连接
//使用DataSource通过数据库连接池获得连接

public class C3P0Test {
	public static void main(String[] args) throws Exception {
		C3P0Test dsTest = new C3P0Test();
		List<String> list = dsTest.getConnectionFromFactory();
		if(list.size() != 0){
			System.out.println(list.get(0));
		}
	}

	//使用C3P0连接数据库并得到Connection
	protected Connection connectionFactory() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.12.34:1521:XE";
		String user = "ccagapp";
		String password = "ccagapp";
		
		//jdbc:mysql://localhost:port:database?characterEncoding=utf-8
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		datasource.setDriverClass(driver);
		datasource.setJdbcUrl(url);
		datasource.setUser(user);
		datasource.setPassword(password);			
		datasource.setMaxPoolSize(10);				//设置最大连接数
		datasource.setMinPoolSize(4);				//设置最小连接数
		return datasource.getConnection();			//从连接池得到连接
	}
	
	//得到连接并进行其他操作
	protected List<String> getConnectionFromFactory() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM TD_M_STAFf WHERE STAFF_ID = ?";
		List<String> result = new ArrayList<String>();
		
		try{
			connection = connectionFactory();					
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "SUPERUSR");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				result.add(resultSet.getString("DEPART_ID"));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(resultSet != null && !resultSet.isClosed()){
					resultSet.close();
				}
				if(preparedStatement != null && !preparedStatement.isClosed()){
					preparedStatement.close();
				}
				if(connection != null && !connection.isClosed()){
					connection.close();				//此处的close()方法表示归还连接，而不是断开连接
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}





