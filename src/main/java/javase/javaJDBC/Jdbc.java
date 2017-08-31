package javase.javaJDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

//未实现
//CallableStatement：由prepareCall方法创建，用来执行SQL stored procedure
//PreparedStatement 怎么预编译
//*********************************************************************
/**
 *JDBC访问步骤： 
 *	加载驱动：Class.forName(driver)。
 *	取得数据库连接: DriverManager.getConnection(url, user, password)
 *	获得Statement/PreparedStatement发送sql语句。
 *	处理sql返回结果
 *	按最后使用最先关闭连接
*/

//一些小技巧
//SQL语句先放在客户端执行，再放在程序中，保证sql语句正确性
//SQL语句出错，可以打印出来，放到客户端执行，若sql语句一直在等待，则判断是不是同时在对数据表操作导致表被锁定
//sql语句拼接："..........stuno like '%" + input + "%';"


//DriverManager	由Sun提供，负责载入不同的JDBC驱动

public class Jdbc {
	public static void main(String[] args) throws Exception {
//		connectDatabaseUseStatement();
//		connectDatabaseUsePreparedStatement();
//		insertAndDeleteUseStatement();
//		insertAndDeleteUsePreparedStatement();
//		insertAndDeleteUsePreparedStatementBatch();
//		transactionTest();
//		invokeProcedure();
		
	
	}

	/*Statement*/
	/*查询*/
	/**
	 * JDBC用来传送SQL语句的三个类：
	 * Statement：由createStatement方法创建，用来传送简单的SQL语句
	 * PreparedStatement：由prepareStatement方法创建，用来传送携带一到多个参数作为输入参数的SQL语句
	 * CallableStatement：由prepareCall方法创建，用来执行SQL stored procedure
	 */
	public static void connectDatabaseUseStatement() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		//【其他数据库JDBC URL】
//		//****MySQL****
//		String url = "jdbc:mysql://ip:3306/student";
								//之后可以加  ?useUnicode=true&characterEncoding=GB2312 设定字符集
//		String driver = "com.mysql.jdbc.Driver";	
//		//****DB2****
//		String url = "jdbc:db2://ip:50000/databasename";
//		String driver = "com.ibm.db2.jcc.DB2Driver";
//		//****SqlServer****
//		String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
//		String url = "jdbc:microsoft:sqlserver://ip:1433";
		
		String sql = "select * from students";
		
		//在类oracle.jdbc.driver.OracleDriver的静态块调用DriverManager.regist(driver实例)
		//保证一加载驱动就向DriverManager注册驱动	
		Class.forName(driver);	
		//从DriverManager获得连接
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		//执行sql，得到查询结果放到ResultSet
		//【查询用executeQurey()，增删改用executeUpdate()】
		//返回一个数据集，针对查询
		ResultSet resultset = statement.executeQuery(sql);	
		
		//遍历查询结果
		while (resultset.next()) {			
			String id = resultset.getString("id");
			String name = resultset.getString("name");
			String gender = resultset.getString("gender");
			String age = resultset.getString("age");
			System.out.println(id + '-' + name + '-' + gender + '-' + age);
		}
		
		//关闭释放资源
		//注意关闭顺序
		if(null != resultset)
			resultset.close();
		if(null != statement)
			statement.close();
		if(null != connection)
			connection.close();	
	}
	

	/*插入数据, 删除数据*/
	public static void insertAndDeleteUseStatement() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
//		String sql1 = "insert into students(id,name,gender,age) values (1,'zzz','F',30)";
//		String sql2 = "delete from students where id = 1";
		String sql3 = "update students set name='ppp' where id = 2";
		
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url,user,password);
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql3);
		
		//关闭释放资源
		
		if(null != statement)
			statement.close();
		if(null != connection)
			connection.close();		
	}
	
	//【PreparedStatement】使用参数实现动态插入数据
	//PreparedStatement可以防止sql注入攻击
	//PreparedStatement只对sql语句有效，并且只有值才能使用参数，列不可以*/
	
	// PreparedStatement在多次执行同一条sql时可以大大的提高效率，
	//把sql语句发送到数据库，进行预编译，参数先空白，以后只要传递参数，不需要重新编译	
	// PreparedStatement第一次执行确实比较慢,对于只执行一次的SQL 语句选择Statement是最好的,
	//如果SQL 语句被多次执行选用PreparedStatement是最好的
	public static void insertAndDeleteUsePreparedStatement() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into students(id,name,gender,age) values (?,?,?,?)";
			
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		//把sql语句发送到数据库，进行预编译，参数先空白，以后只要传递参数，不需要重新编译
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//索引从1开始
		//PreparedStatement有setInt(),setString(),setFloat(),setBoolean(),setByte(),setDouble,setLong(),setDate()等方法
		preparedStatement.setInt(1, 100);
		preparedStatement.setString(2, "xxx");
		preparedStatement.setString(3, "F");
		preparedStatement.setInt(4, 20);
		preparedStatement.execute();
		
		//关闭释放资源
		if(null != preparedStatement)
			preparedStatement.close();
		if(null != connection)
			connection.close();		
	}
	
	/**
	 * 批量处理:减少网络通信，提高效率
	 */
	public static void insertAndDeleteUsePreparedStatementBatch() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into students(id,name,gender,age) values (?,'aoao','M',20)";
			
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		System.out.println("1");
		for(int i = 1500; i < 2000; i++){
			preparedStatement.setInt(1, i);
			preparedStatement.addBatch();			//在本地缓存sql，之后可以一批一起发送
			System.out.println("2-" + i);
			if( i % 100 == 0){
				System.out.println("flag");
				preparedStatement.executeBatch();	//将本地缓存的一批sql一起发送到数据库
				System.out.println("3-" + i);
			}	
		}	
		preparedStatement.executeBatch();
		
		//关闭释放资源
		if(null != preparedStatement)
			preparedStatement.close();
		if(null != connection)
			connection.close();		
	}
	
	
	/*JDBC事务处理*/
	//事物：在设定不自动提交后，执行多条sql语句，假定其中一条发生错误，则全部回滚
	

	/**
	 * JDBC的数据隔离级别设置： 
	 * 【赃读，隔离级别最低】TRANSACTION_READ_UNCOMMITTED ur,就是俗称"脏读"（dirty read）， 在一个事务没有提交数据时，另一个事务就能够读到已经更新的数据
	 * 
	 * TRANSACTION_READ_COMMITTED cs 在一个事务中进行查询时，允许读取提交前的数据，数据提交后，当前查询就可以读取到数据。 update数据时候并不锁住表
	 * 
	 * TRANSACTION_REPEATABLE_READ rs 在一个事务中进行查询时， 不允许读取其他事务update的数据，允许读取到其他事务提交的新增数据
	 * 
	 * TRANSACTION_SERIALIZABLE rr 在一个事务中进行查询时， 不允许任何对这个查询表的数据修改。
	 * 
	 * TRANSACTION_NONE
	 */

	/**
	 * TRANSACTION_NONE 说明不支持事务
	 * TRANSACTION_READ_UNCOMMITTED说明在提交前一个事务可以看到另一个事务的变化。 这样脏读、不可重复的读和虚读都是允许的。
	 * TRANSACTION_READ_COMMITTED 说明读取未提交的数据是不允许的。这个级别仍然允许不可重复的读和虚读产生。
	 * TRANSACTION_REPEATABLE_READ 说明事务保证能够再次读取相同的数据而不会失败，但虚读仍然会出现。
	 * TRANSACTION_SERIALIZABLE 是最高的事务级别，它防止脏读、不可重复的读和虚读。
	 */

	
	/**
	 * 有关事务的方法
	 * connection.setAutoCommit(false);
	 * connection.commit();
	 * connection.rollback();	
	 */
	public static void transactionTest() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql1 = "insert into students(id,name,gender,age) values (21,'21a','F',30)";
		String sql2 = "insert into students(id,name,gender,age) values (22,'22a','F',30)";
		String sql3 = "insert into students(id,name,gender,age) values (23,'23a','F',30)";
		String sql4 = "insert into students(id,name,gender,age) values (24,'24a','F',30)";
		
		Connection connection = null;
		Statement statement = null;
		
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			//设置隔离级别
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			//设置事务不自动提交,并开始事务
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			statement.execute(sql1);
			statement.execute(sql2);
			statement.execute(sql3);
			statement.execute(sql4);
			//手动提交事务
			connection.commit();
			System.out.println("事务提交成功");
		} catch (Exception e) {
			try {
				//发生异常就回滚事务
				if(connection != null){
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if(null != statement)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(null != connection)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
		}
	}
	
	/**
	 * 调用存储过程
	 */
	public static void invokeProcedure(){
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "call procedure(?,?,?,?)";
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			callableStatement = connection .prepareCall(sql);
			
			callableStatement.setString(1, "5");
			callableStatement.setString(2, "测试");
			callableStatement.registerOutParameter(3, Types.VARCHAR);
			callableStatement.registerOutParameter(4, Types.INTEGER);
			callableStatement.registerOutParameter(5, Types.VARCHAR);
			callableStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(null != callableStatement){
				try {
					callableStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(null != connection){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

