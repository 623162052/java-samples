package javase.javaJDBC.dbutil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class DBUtil {
	private String url;
	private String driver;
	private String userName;
	private String passWord;
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public DBUtil(){
		// 解析xml
		InputStream inputStream = DBUtil.class.getResourceAsStream("/javaJDBC/model/util/db.xml");
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		url = document.selectSingleNode("/jdbc/url").getText();
		driver = document.selectSingleNode("/jdbc/driver").getText();
		userName = document.selectSingleNode("/jdbc/username").getText();
		passWord = document.selectSingleNode("/jdbc/password").getText();
		try {
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	返回数据库连接Connection
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		connection = DriverManager.getConnection(url, userName, passWord);
		return connection;
	}
	
	/**
	 * 返回Statement
	 */
	public Statement getStatement(Connection connection) throws SQLException {
		statement = connection.createStatement();
		return statement;
	}
	
	/**
	 * 返回ResultSet
	 */
	public ResultSet getResultSet(Statement statement, String sql) throws SQLException {
		resultSet = statement.executeQuery(sql);
		return resultSet;
	}
	
	
	/**
	 * 关闭数据库连接
	 */
	public void close(Connection conn, Statement st, ResultSet rs) throws SQLException{
		if(!rs.isClosed()){
			rs.close();
		}
		if(!st.isClosed()){
			st.close();
		}
		if(!conn.isClosed()){
			conn.close();
		}
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void close(Connection conn, PreparedStatement pst, ResultSet rs) throws SQLException{
		if(rs!=null && !rs.isClosed()){
			rs.close();
		}
		if(pst!=null && !pst.isClosed()){
			pst.close();
		}
		if(conn!=null && !conn.isClosed()){
			conn.close();
		}
	}
}
