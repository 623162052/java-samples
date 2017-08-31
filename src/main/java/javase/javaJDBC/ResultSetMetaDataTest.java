package javase.javaJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 * 结果集元数据：	ResultSetMetaData:不知道结果集的字段或类型，可以通过此类的方法
 */
public class ResultSetMetaDataTest {
	public static void main(String[] args){
		ResultSetMetaDataTest test = new ResultSetMetaDataTest();
		test.getColumnTypeName("select * from students");
	}

	protected void getColumnTypeName(String sql) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData metaData = null;
		
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			metaData = resultSet.getMetaData();
			
			int columnCount = metaData.getColumnCount();	//得到列数
			while (resultSet.next()) {
				for(int i = 1; i <= columnCount; i++){
					int columnType = metaData.getColumnType(i);
					String columnName = metaData.getColumnName(i);
					System.out.println("Column Name--" + columnName);
					//根据不同的类型，采用不同的获取函数
					switch(columnType){
						//JDBC中有Types，里面存放了数据库变量类型的常量
						case Types.NUMERIC:	
							int n = resultSet.getInt("id");
							System.out.println("columnType: NUMERIC" + " - " + n);
							break;
						case Types.VARCHAR: 
							String v = resultSet.getString("name");
							System.out.println("columnType: VARCHAR" + " - " + v);
							break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (resultSet != null && !resultSet.isClosed())
					resultSet.close();
				if (statement != null && !statement.isClosed())
					statement.close();
				if (connection != null && !connection.isClosed())
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}




