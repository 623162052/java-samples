package javase.javaJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class TimeDate {
	//JDBC时间类型
	//java.sql.Time		-时分秒
	//java.sql.Date		-年月日(继承java.util.Date)
	//java.sql.TimeStemp		-年月日时分秒
	//java.util.Date	-1970-1-1 00:00:00 GMT以来的指定毫秒数 
	
	//Oracle date	-年月日时分秒
	public static void main(String[] args) throws Exception {
	//createTable();
	insertData();
	}

	protected static void insertData() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into xuesheng(id,name,birthday) values (?,?,?)";
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1,3);
		preparedStatement.setString(2, "abc");
		
		// 1987-2-1 ==> java.util.Date ==> 毫秒 ==> java.sql.Date
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = f.parse("1987-2-1");	
		preparedStatement.setDate(3,new java.sql.Date(d.getTime()));

		
		preparedStatement.executeUpdate();
		
		if (null != preparedStatement)
			preparedStatement.close();
		if (null != connection)
			connection.close();
	}

	protected static void createTable() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		//执行DDL，一般使用execute()方法
		//此方法返回boolean值表示是否有查询结果集	
		statement.execute(
				"create table xuesheng (" +
				"	id number(8) primary key," +
				"	name varchar2(32)," +
				"	birthday date" +
				")"
		);
		//statement.getResultSet();	如果有结果集可用此方法获得
		if (null != statement)
			statement.close();
		if (null != connection)
			connection.close();
	}
}
