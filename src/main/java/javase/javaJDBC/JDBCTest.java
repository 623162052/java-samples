package javase.javaJDBC;

import java.sql.*;

/**
 * Created by shiwx on 2016/4/4.
 */
public class JDBCTest {

    public void test() throws SQLException {
        String url = "jdbc:mysql://120.26.215.167:3306/aicp";
        String user = "aicp";
        String password = "aicp";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        try {
            statement.executeUpdate(
                    " INSERT INTO `aicp`.`cp_user` (`USER_ACCOUNT`) VALUES ('ABC') ", Statement.RETURN_GENERATED_KEYS);
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                int autoIncKeyFromApi = resultSet.getInt(1);
                System.out.println("autoIncKeyFromApi:" + autoIncKeyFromApi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null){
                resultSet.close();
            }

        }
    }

    public static void main(String[] args) throws SQLException {
        new JDBCTest().test();
    }
}
