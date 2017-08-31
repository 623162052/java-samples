package javase.javaJDBC;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
Blob:	Byte Large Object		字节大对象，最大放4G数据
Clob:	Character Large Object	字符大对象

create table pics(
   id number(11) primary key,
   description varchar(255),
   pic blob
);

PreparedStatement---setBinaryStream(序号,输入流,字节量(int));
ResultSet---getBinaryStream()
*/

public class BlobTest {
	public static void main(String[] args) throws Exception {
		BlobTest test = new BlobTest();
		test.savePic(new File("C:/IMG_7998.JPG"));
	}
	
	//保存图片到数据库
	//Blob 字节大对象
	public void savePic(File pic) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		String sql = "insert into pics(id,description,pic) values(?,?,?)";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FileInputStream in = null;
		
		try{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "good");
			//通过流把图片加入到数据库 
			//从数据库取得图片数据也用流getBinaryStream()
			in = new FileInputStream(pic);
			preparedStatement.setBinaryStream(3, in, (int)pic.length());
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				if(in != null){
					in.close();
				}
				if(preparedStatement != null && !preparedStatement.isClosed()){
					preparedStatement.close();
				}
				if(connection != null && !connection.isClosed()){
					connection.close();
				}
	}
	}
}
