package javase.javaJDBC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

//δʵ��
//CallableStatement����prepareCall��������������ִ��SQL stored procedure
//PreparedStatement ��ôԤ����
//*********************************************************************
/**
 *JDBC���ʲ��裺 
 *	����������Class.forName(driver)��
 *	ȡ�����ݿ�����: DriverManager.getConnection(url, user, password)
 *	���Statement/PreparedStatement����sql��䡣
 *	����sql���ؽ��
 *	�����ʹ�����ȹر�����
*/

//һЩС����
//SQL����ȷ��ڿͻ���ִ�У��ٷ��ڳ����У���֤sql�����ȷ��
//SQL���������Դ�ӡ�������ŵ��ͻ���ִ�У���sql���һֱ�ڵȴ������ж��ǲ���ͬʱ�ڶ����ݱ�������±�����
//sql���ƴ�ӣ�"..........stuno like '%" + input + "%';"


//DriverManager	��Sun�ṩ���������벻ͬ��JDBC����

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
	/*��ѯ*/
	/**
	 * JDBC��������SQL���������ࣺ
	 * Statement����createStatement�����������������ͼ򵥵�SQL���
	 * PreparedStatement����prepareStatement������������������Я��һ�����������Ϊ���������SQL���
	 * CallableStatement����prepareCall��������������ִ��SQL stored procedure
	 */
	public static void connectDatabaseUseStatement() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		//���������ݿ�JDBC URL��
//		//****MySQL****
//		String url = "jdbc:mysql://ip:3306/student";
								//֮����Լ�  ?useUnicode=true&characterEncoding=GB2312 �趨�ַ���
//		String driver = "com.mysql.jdbc.Driver";	
//		//****DB2****
//		String url = "jdbc:db2://ip:50000/databasename";
//		String driver = "com.ibm.db2.jcc.DB2Driver";
//		//****SqlServer****
//		String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
//		String url = "jdbc:microsoft:sqlserver://ip:1433";
		
		String sql = "select * from students";
		
		//����oracle.jdbc.driver.OracleDriver�ľ�̬�����DriverManager.regist(driverʵ��)
		//��֤һ������������DriverManagerע������	
		Class.forName(driver);	
		//��DriverManager�������
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		//ִ��sql���õ���ѯ����ŵ�ResultSet
		//����ѯ��executeQurey()����ɾ����executeUpdate()��
		//����һ�����ݼ�����Բ�ѯ
		ResultSet resultset = statement.executeQuery(sql);	
		
		//������ѯ���
		while (resultset.next()) {			
			String id = resultset.getString("id");
			String name = resultset.getString("name");
			String gender = resultset.getString("gender");
			String age = resultset.getString("age");
			System.out.println(id + '-' + name + '-' + gender + '-' + age);
		}
		
		//�ر��ͷ���Դ
		//ע��ر�˳��
		if(null != resultset)
			resultset.close();
		if(null != statement)
			statement.close();
		if(null != connection)
			connection.close();	
	}
	

	/*��������, ɾ������*/
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
		
		//�ر��ͷ���Դ
		
		if(null != statement)
			statement.close();
		if(null != connection)
			connection.close();		
	}
	
	//��PreparedStatement��ʹ�ò���ʵ�ֶ�̬��������
	//PreparedStatement���Է�ֹsqlע�빥��
	//PreparedStatementֻ��sql�����Ч������ֻ��ֵ����ʹ�ò������в�����*/
	
	// PreparedStatement�ڶ��ִ��ͬһ��sqlʱ���Դ������Ч�ʣ�
	//��sql��䷢�͵����ݿ⣬����Ԥ���룬�����ȿհף��Ժ�ֻҪ���ݲ���������Ҫ���±���	
	// PreparedStatement��һ��ִ��ȷʵ�Ƚ���,����ִֻ��һ�ε�SQL ���ѡ��Statement����õ�,
	//���SQL ��䱻���ִ��ѡ��PreparedStatement����õ�
	public static void insertAndDeleteUsePreparedStatement() throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into students(id,name,gender,age) values (?,?,?,?)";
			
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		//��sql��䷢�͵����ݿ⣬����Ԥ���룬�����ȿհף��Ժ�ֻҪ���ݲ���������Ҫ���±���
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//������1��ʼ
		//PreparedStatement��setInt(),setString(),setFloat(),setBoolean(),setByte(),setDouble,setLong(),setDate()�ȷ���
		preparedStatement.setInt(1, 100);
		preparedStatement.setString(2, "xxx");
		preparedStatement.setString(3, "F");
		preparedStatement.setInt(4, 20);
		preparedStatement.execute();
		
		//�ر��ͷ���Դ
		if(null != preparedStatement)
			preparedStatement.close();
		if(null != connection)
			connection.close();		
	}
	
	/**
	 * ��������:��������ͨ�ţ����Ч��
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
			preparedStatement.addBatch();			//�ڱ��ػ���sql��֮�����һ��һ����
			System.out.println("2-" + i);
			if( i % 100 == 0){
				System.out.println("flag");
				preparedStatement.executeBatch();	//�����ػ����һ��sqlһ���͵����ݿ�
				System.out.println("3-" + i);
			}	
		}	
		preparedStatement.executeBatch();
		
		//�ر��ͷ���Դ
		if(null != preparedStatement)
			preparedStatement.close();
		if(null != connection)
			connection.close();		
	}
	
	
	/*JDBC������*/
	//������趨���Զ��ύ��ִ�ж���sql��䣬�ٶ�����һ������������ȫ���ع�
	

	/**
	 * JDBC�����ݸ��뼶�����ã� 
	 * ���߶������뼶����͡�TRANSACTION_READ_UNCOMMITTED ur,�����׳�"���"��dirty read���� ��һ������û���ύ����ʱ����һ��������ܹ������Ѿ����µ�����
	 * 
	 * TRANSACTION_READ_COMMITTED cs ��һ�������н��в�ѯʱ�������ȡ�ύǰ�����ݣ������ύ�󣬵�ǰ��ѯ�Ϳ��Զ�ȡ�����ݡ� update����ʱ�򲢲���ס��
	 * 
	 * TRANSACTION_REPEATABLE_READ rs ��һ�������н��в�ѯʱ�� �������ȡ��������update�����ݣ������ȡ�����������ύ����������
	 * 
	 * TRANSACTION_SERIALIZABLE rr ��һ�������н��в�ѯʱ�� �������κζ������ѯ��������޸ġ�
	 * 
	 * TRANSACTION_NONE
	 */

	/**
	 * TRANSACTION_NONE ˵����֧������
	 * TRANSACTION_READ_UNCOMMITTED˵�����ύǰһ��������Կ�����һ������ı仯�� ��������������ظ��Ķ��������������ġ�
	 * TRANSACTION_READ_COMMITTED ˵����ȡδ�ύ�������ǲ�����ġ����������Ȼ�������ظ��Ķ������������
	 * TRANSACTION_REPEATABLE_READ ˵������֤�ܹ��ٴζ�ȡ��ͬ�����ݶ�����ʧ�ܣ��������Ȼ����֡�
	 * TRANSACTION_SERIALIZABLE ����ߵ����񼶱�����ֹ����������ظ��Ķ��������
	 */

	
	/**
	 * �й�����ķ���
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
			//���ø��뼶��
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			//���������Զ��ύ,����ʼ����
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			statement.execute(sql1);
			statement.execute(sql2);
			statement.execute(sql3);
			statement.execute(sql4);
			//�ֶ��ύ����
			connection.commit();
			System.out.println("�����ύ�ɹ�");
		} catch (Exception e) {
			try {
				//�����쳣�ͻع�����
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
	 * ���ô洢����
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
			callableStatement.setString(2, "����");
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

