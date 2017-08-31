package javase.javaJDBC.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//DataSource�� DataManager����������������Ӧ���ṩ�������������ݿ����ӳ�
//ʹ��DataManagerֱ�ӻ�����ݿ�����
//ʹ��DataSourceͨ�����ݿ����ӳػ������

public class C3P0Test {
	public static void main(String[] args) throws Exception {
		C3P0Test dsTest = new C3P0Test();
		List<String> list = dsTest.getConnectionFromFactory();
		if(list.size() != 0){
			System.out.println(list.get(0));
		}
	}

	//ʹ��C3P0�������ݿⲢ�õ�Connection
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
		datasource.setMaxPoolSize(10);				//�������������
		datasource.setMinPoolSize(4);				//������С������
		return datasource.getConnection();			//�����ӳصõ�����
	}
	
	//�õ����Ӳ�������������
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
					connection.close();				//�˴���close()������ʾ�黹���ӣ������ǶϿ�����
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
}





