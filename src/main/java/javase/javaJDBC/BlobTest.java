package javase.javaJDBC;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
Blob:	Byte Large Object		�ֽڴ��������4G����
Clob:	Character Large Object	�ַ������

create table pics(
   id number(11) primary key,
   description varchar(255),
   pic blob
);

PreparedStatement---setBinaryStream(���,������,�ֽ���(int));
ResultSet---getBinaryStream()
*/

public class BlobTest {
	public static void main(String[] args) throws Exception {
		BlobTest test = new BlobTest();
		test.savePic(new File("C:/IMG_7998.JPG"));
	}
	
	//����ͼƬ�����ݿ�
	//Blob �ֽڴ����
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
			//ͨ������ͼƬ���뵽���ݿ� 
			//�����ݿ�ȡ��ͼƬ����Ҳ����getBinaryStream()
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
