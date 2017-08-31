package servlet.jndi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * 通过JNDI获取数据库连接
 * @author shiwx
 * @since 2011-12-9
 */
public class ConnectionJNDI extends HttpServlet {
	private static final long serialVersionUID = 944271411195492120L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Context context = null;
		DataSource source = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			context = new InitialContext();
			//java:comp/env为JavaEE默认路径
			//myDB为JNDI名
			source = (DataSource) context.lookup("java:comp/env/myDB");
			connection = source.getConnection();
			preparedStatement = connection.prepareStatement("SELECT TNAME FROM TAB");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("TNAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(null!=resultSet){
					resultSet.close();
				}
				if(null!=preparedStatement && !preparedStatement.isClosed()){
					preparedStatement.close();
				}
				if(null!=connection && !connection.isClosed()){
					//此处的close()方法表示归还连接，而不是断开连接
					connection.close();		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
}
