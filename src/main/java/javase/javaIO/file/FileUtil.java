package javase.javaIO.file;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *	�ļ�������
 */
public class FileUtil {

	/**
	 *	���� 
	 */
	public static void main(String[] args) throws Exception {
//		concat("C:/test10.txt", "C:/test1.txt.1", "C:/test1.txt.2", "C:/test1.txt.3");
//		listAllFiles(new File("src/javaIO/bytestream"));
	}

	
	/**
	 * �ϲ�С�ļ�Ϊ���ļ�
	 * @param target	�ϲ��ɵĴ��ļ�
	 * @param files		��ϲ���С�ļ�
	 */
	public static void concat(String target, String ...files) throws IOException{
		BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(target, true));
		BufferedInputStream bfIn = null;
		byte[] byteArray = new byte[10];
		int byteCounter;
		for(String file : files){ 
			bfIn = new BufferedInputStream(new FileInputStream(file));
			while((byteCounter = bfIn.read(byteArray)) != -1){
				bfOut.write(byteArray, 0, byteCounter);
			}
			if(null != bfIn){
				bfIn.close();
			}
		}
		if(null != bfOut){
			bfOut.close();
		}
		
	}
	
	
	/**
	 *	����Ŀ¼�������ļ�
	 */
	public static void listAllFiles(File directory) {
		File[] files = directory.listFiles();
		for(File file : files){
			if(!file.isDirectory()){
					System.out.println(file.getPath() + " - " + file.getName());
			}else{
				listAllFiles(file);
			}
		}
		
	}

}






