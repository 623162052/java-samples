package javase.javaJDBC.pagination;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaginationTest {
	public static void main(String[] args) throws Exception {
		PaginationTest paginationTest = new PaginationTest();
		paginationTest.paginationUseJDBC(10, 20);
		paginationTest.paginationUseDatabase(10, 20);
	}

	/**
	 * �������ݿ�ʵ�ַ�ҳ,ֱ�Ӳ�ѯ�õ���Ҫ�����ݣ�Ч�ʱȽϸ�
	 */
	protected void paginationUseDatabase(int page, int pageSize) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "select * from (select rownum row_number, v.* from (select * from students order by id) v where rownum < ?) where row_number > ?";

		int startRow = (page - 1) * pageSize + 1; // Ҫ��ѯ�ĵ�pageҳ�ĵ�һ������
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startRow + pageSize);
			preparedStatement.setInt(2, startRow);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.println(resultSet.getString("id"));
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (null != resultSet) {
				resultSet.close();
			}
			if (null != preparedStatement) {
				preparedStatement.close();
			}
			if (null != connection) {
				connection.close();
			}
		}
	}

	/**
	 * ����JDBCʵ�ַ�ҳ,��ѯ�������ݣ��ٽ�ȡ��Ҫ�ģ�Ч�ʱȽϵ�
	 * page��Ҫ�鿴�ĵڼ�ҳ,pageSize��ûҳ��ʾ����
	 */
	protected void paginationUseJDBC(int page, int pageSize) throws SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "select * from students";
		// Ҫ���ĵ�pageҳ�ĵ�һ������
		int startRow = (page - 1) * pageSize + 1;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			// ResultSetĬ��ResultSet.TYPE_FORWARD_ONLY
			statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sql);
			resultSet.absolute(startRow); // ���Զ�λ

			if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				System.out.println("û����");
				return;
			}
			for (int i = 0; i < pageSize; i++) {
				System.out.println(resultSet.getString("id"));
				if (!resultSet.next()) {
					break; // ����ָ�뷢��û������ֱ��break
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			if (null != resultSet) {
				resultSet.close();
			}
			if (null != statement) {
				statement.close();
			}
			if (null != connection) {
				connection.close();
			}
		}
	}
}
